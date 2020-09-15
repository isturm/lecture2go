package de.uhh.l2g.plugins.service.persistence.impl;

import java.util.Date;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
//import com.liferay.util.dao.orm.CustomSQLUtil;

import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.service.persistence.OaiRecordFinder;

public class OaiRecordFinderImpl extends OaiRecordFinderBaseImpl implements OaiRecordFinder {
	public static final String FIND_EARLIEST_DATESTAMP = OaiRecordFinder.class.getName() + ".findEarliestDatestamp";

	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	
	public Date findEarliestDatestamp() {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_EARLIEST_DATESTAMP);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar("earliestDatestamp", Type.TIMESTAMP);
			q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			return (Date) q.uniqueResult();
		} catch (Exception e) {
			
		} finally {
			closeSession(session);
		}
		return null;
	}
}
