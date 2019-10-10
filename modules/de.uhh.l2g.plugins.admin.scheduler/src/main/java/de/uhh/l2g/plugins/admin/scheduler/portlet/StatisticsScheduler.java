package de.uhh.l2g.plugins.admin.scheduler.portlet;

import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
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

import de.uhh.l2g.plugins.service.StatisticLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;

/** Statistics is less flawed when running job at concrete time (ideally around midnight)  
 *  
 * The Class StatisticsSheduler.
 */
@Component(
		  immediate = true, 
		  property = {"cron.expression=0 0/5 * * * ?"},
		  service = StatisticsScheduler.class
)
public class StatisticsScheduler  extends BaseSchedulerEntryMessageListener {  

	  /**
	   * doReceive: This is where the magic happens, this is where you want to do the work for
	   * the scheduled job.
	   * @param message This is the message object tied to the job.  If you stored data with the
	   *                job, the message will contain that data.   
	   * @throws Exception In case there is some sort of error processing the task.
	   */
	  @Override
	  protected void doReceive(Message message) throws Exception {
		   //uncoment for further debug messages
		   //super.receive(message);
		  _log.info("Statistics Scheduler running "+message.getValues().get(SchedulerEngine.JOB_NAME).toString()+"...");
		   //Do Job....
		   int privateVideos = 0;
		   int publicVideos = 0;
		   try {
			   publicVideos=VideoLocalServiceUtil.getByOpenAccessAndUploadedFile(1);
			   privateVideos=VideoLocalServiceUtil.getByOpenAccessAndUploadedFile(0);
			   //TODO can not get the service context for using the addEntry method, because of the scheduler! And can't find workaround.
			   StatisticLocalServiceUtil.add(privateVideos, publicVideos);
		   } catch (PortalException e) {
			   _log.info("Statistics Scheduler failed.");
		   } catch (SystemException e) {
			   _log.info("Statistics Scheduler failed.");
		   }
		   //Job end
		   _log.info("Statistics Scheduler finished.");
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

	  private static final Log _log = LogFactoryUtil.getLog(StatisticsScheduler.class);

	  private volatile boolean _initialized;
	  private TriggerFactory _triggerFactory;
	  private SchedulerEngineHelper _schedulerEngineHelper;
	  private SchedulerEntryImpl _schedulerEntryImpl = null;
    
}
 

 
