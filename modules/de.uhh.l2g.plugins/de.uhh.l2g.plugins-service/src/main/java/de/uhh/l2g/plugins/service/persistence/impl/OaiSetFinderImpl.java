package de.uhh.l2g.plugins.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;

import de.uhh.l2g.plugins.model.OaiSet;
import de.uhh.l2g.plugins.service.persistence.OaiSetFinder;
 

public class OaiSetFinderImpl extends BasePersistenceImpl<OaiSet> implements OaiSetFinder {
	public static final String FIND_BY_OAI_RECORD = OaiSetFinder.class.getName() + ".findByOaiRecord";
	
	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;
	
	public List<OaiSet> findByOaiRecord(long oaiRecord) {
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), FIND_BY_OAI_RECORD);
			SQLQuery q = session.createSQLQuery(sql);
            q.addEntity("OaiSet",OaiSet.class);
            q.setCacheable(false);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(oaiRecord);
			
			List <OaiSet> sl =  (List<OaiSet>) QueryUtil.list(q, getDialect(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS);
			return sl;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}

}
