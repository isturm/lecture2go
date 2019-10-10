package de.uhh.l2g.plugins.service.persistence.impl;

import java.util.List;

import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.service.persistence.StatisticFinder;

public class StatisticFinderImpl extends StatisticFinderBaseImpl implements StatisticFinder {

	public static final String CREATE_VIDEO_STATISTIC_VIEW = StatisticFinder.class.getName() + ".createVideoStatisticView";
	public static final String REMOVE_VIDEO_STATISTIC_TABLE = StatisticFinder.class.getName() + ".removeVideoStatisticTable";
	public static final String ADD_NEW_STATISTIC_ENTRY = StatisticFinder.class.getName() + ".addNewStatisticEntry";
	public static final String GET_ALL_STATISTICS = StatisticFinder.class.getName() + ".getAllStatistics";

	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	public JSONObject findAllStatistics ()  {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), GET_ALL_STATISTICS);
			SQLQuery q = session.createSQLQuery(sql);
			@SuppressWarnings("unchecked")
			List <Object[]> sl =  (List<Object[]>) QueryUtil.list(q, getDialect(),com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS , com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return assemble(sl);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	private JSONObject assemble(List<Object[]> objectList) throws JSONException{
		JSONArray ja = JSONFactoryUtil.createJSONArray();
		JSONObject mainObj = JSONFactoryUtil.createJSONObject();
		for (Object[] obj: objectList){
			JSONObject jo = JSONFactoryUtil.createJSONObject();
			jo.put("public", obj[0]);
			jo.put("private", obj[1]);
			jo.put("total", obj[2]);
			jo.put("date", obj[3]);
			jo.put("timespan", obj[4]);
			jo.put("publicDiff", obj[5]);
			jo.put("privateDiff", obj[6]);
			jo.put("totalDiff", obj[7]);
			ja.put(jo);
		}
		mainObj.put("statistic", ja);
		return mainObj;
	}
	
	/**
	 * WARNING: As Custom Query is restricted executeQuery() 
	 * this methods uses Core DB functionality of Liferay 
	 */
	public int createVideoStatisticView() {
		Session session = null;
		int out = 0;
		session = openSession();
		String sql = _customSQL.get(getClass(), CREATE_VIDEO_STATISTIC_VIEW);
		SQLQuery q = session.createSQLQuery(sql);
		out = q.executeUpdate();
		return out;
	}

	/**
	 * WARNING: As Custom Query is restricted executeQuery() 
	 * this methods uses Core DB functionality of Liferay 
	 */
	public int removeVideoStatisticTable() {
		Session session = null;
		int out = 0;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), REMOVE_VIDEO_STATISTIC_TABLE);
			SQLQuery q = session.createSQLQuery(sql);
			out = q.executeUpdate();
	      } catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				//e.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return out;
	}


}
