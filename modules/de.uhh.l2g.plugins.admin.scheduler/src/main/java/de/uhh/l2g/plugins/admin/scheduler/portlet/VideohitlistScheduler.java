package de.uhh.l2g.plugins.admin.scheduler.portlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseSchedulerEntryMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngine;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.util.GetterUtil;

import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.Videohitlist;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideohitlistLocalServiceUtil;

/**
 * The Class DatabaseThread.
 */
@Component(
		  immediate = true, 
		  property = {"cron.expression=0 0/30 * * * ?"},
		  service = VideohitlistScheduler.class
)
public final class VideohitlistScheduler extends BaseSchedulerEntryMessageListener {  

	private static Long HITS = new Long(20);

	@Override
	protected void doReceive(Message message) throws Exception {
		// uncoment for further debug messages
		// super.receive(message);
		_log.info("Videohitlist Scheduler running " + message.getValues().get(SchedulerEngine.JOB_NAME).toString() + "...");
		// Do Job
		createPopularVideoList();
		_log.info("Videohitlist Scheduler finished.");
	}
	
	public void createPopularVideoList(){
		List<Video> returnList = new ArrayList<Video>();
		//1.get open access videos with more than 20 clicks 
		returnList = VideoLocalServiceUtil.getByHitsAndOpenAccess(HITS);
		//2.truncate table videohitlist
		VideohitlistLocalServiceUtil.deleteAll();
		//3.fill table with data
		Calendar calendar = new GregorianCalendar(); 
		calendar.setTimeZone( TimeZone.getTimeZone("CET") );
		long msnow = calendar.getTimeInMillis();

		Date d1 = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH-mm");

		for(Video v : returnList){
			try {
				d1 = df.parse(v.getGenerationDate()); 
				long ms1   = d1.getTime();
				long hits = v.getHits();
				long timeinms = msnow - ms1;

				// Durschnittswerte berechnen
				//Berechne alter des Videos in...
				long days = timeinms / (1000*60*60*24); //...Tagen
				long week = timeinms / (1000*60*60*24*7); //...Wochen
				long month = timeinms / 2628000000l; //....Monaten
				long year = timeinms / (2628000000l*12l); //....Jahren
				
				//Berechne die Hits pro...
				long clicksperday = calcHitsPro(days, hits);
				long clicksperweek = calcHitsPro(week, hits);
				long clickspermonth = calcHitsPro(month, hits);
				long clicksperyear = calcHitsPro(year, hits);

				Videohitlist vhl = VideohitlistLocalServiceUtil.createVideohitlist(0);
				vhl.setVideoId(v.getVideoId());
				vhl.setHitsPerDay(clicksperday);
				vhl.setHitsPerWeek(clicksperweek);
				vhl.setHitsPerMonth(clickspermonth);
				vhl.setHitsPerYear(clicksperyear);
				//save
				VideohitlistLocalServiceUtil.addVideohitlist(vhl);
				}catch (ParseException e) {
					System.out.println("Simple Date Parsen Error!!");
				}
		}
	}	
	
	private long calcHitsPro(long einheit, long hits){
		if(einheit>=1)return (long) (hits/einheit); //Hits pro Einheit (tag, woche, monat, jahr...)
		else return hits; //else: Das Video ist noch kein volles Jahr vollen Monat etc alt.
	}
	  
	  /**
	   * activate: Called whenever the properties for the component change (ala Config Admin)
	   * or OSGi is activating the component.
	   * @param properties The properties map from Config Admin.
	   * @throws SchedulerException in case of error.
	   */
	  @Activate
	  @Modified
	  protected void activate(Map<String,Object> properties) throws SchedulerException {

	    // extract the cron expression from the properties
	    String cronExpression = GetterUtil.getString(properties.get("cron.expression"), _DEFAULT_CRON_EXPRESSION);

	    // create a new trigger definition for the job.
	    String listenerClass = getClass().getName();
	    Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass, listenerClass, new Date(), null, cronExpression);

	    // wrap the current scheduler entry in our new wrapper.
	    // use the persisted storaget type and set the wrapper back to the class field.
	    _schedulerEntryImpl = new SchedulerEntryImpl();
	    _schedulerEntryImpl.setEventListenerClass(listenerClass);
	    _schedulerEntryImpl.setTrigger(jobTrigger);
	    _schedulerEntryImpl = new StorageTypeAwareSchedulerEntryImpl(_schedulerEntryImpl);

	    // update the trigger for the scheduled job.
	    _schedulerEntryImpl.setTrigger(jobTrigger);

	    // if we were initialized (i.e. if this is called due to CA modification)
	    if (_initialized) {
	      // first deactivate the current job before we schedule.
	      deactivate();
	    }

	    // register the scheduled task
	    _schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

	    // set the initialized flag.
	    _initialized = true;
	  }

	  /**
	   * deactivate: Called when OSGi is deactivating the component.
	   */
	  @Deactivate
	  protected void deactivate() {
	    // if we previously were initialized
	    if (_initialized) {
	      // unschedule the job so it is cleaned up
	      try {
	        _schedulerEngineHelper.unschedule(_schedulerEntryImpl, getStorageType());
	      } catch (SchedulerException se) {
	        if (_log.isWarnEnabled()) {
	          _log.warn("Unable to unschedule trigger", se);
	        }
	      }

	      // unregister this listener
	      _schedulerEngineHelper.unregister(this);
	    }
	    
	    // clear the initialized flag
	    _initialized = false;
	  }

	  /**
	   * getStorageType: Utility method to get the storage type from the scheduler entry wrapper.
	   * @return StorageType The storage type to use.
	   */
	  protected StorageType getStorageType() {
	    if (_schedulerEntryImpl instanceof StorageTypeAware) {
	      return ((StorageTypeAware) _schedulerEntryImpl).getStorageType();
	    }
	    
	    return StorageType.MEMORY_CLUSTERED;
	  }
	  
	  /**
	   * setModuleServiceLifecycle: So this requires some explanation...
	   * 
	   * OSGi will start a component once all of it's dependencies are satisfied.  However, there
	   * are times where you want to hold off until the portal is completely ready to go.
	   * 
	   * This reference declaration is waiting for the ModuleServiceLifecycle's PORTAL_INITIALIZED
	   * component which will not be available until, surprise surprise, the portal has finished
	   * initializing.
	   * 
	   * With this reference, this component activation waits until portal initialization has completed.
	   * @param moduleServiceLifecycle
	   */
	  @Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	  protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	  }

	  @Reference
	  protected void setTriggerFactory(TriggerFactory triggerFactory) {
	    _triggerFactory = triggerFactory;
	  }

	  @Reference
	  protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {
	    _schedulerEngineHelper = schedulerEngineHelper;
	  }

	  // the default cron expression is to run daily at midnight
	  private static final String _DEFAULT_CRON_EXPRESSION = "0 0 0 * * ?";

	  private static final Log _log = LogFactoryUtil.getLog(VideohitlistScheduler.class);

	  private volatile boolean _initialized;
	  private TriggerFactory _triggerFactory;
	  private SchedulerEngineHelper _schedulerEngineHelper;
	  private SchedulerEntryImpl _schedulerEntryImpl = null;

}
