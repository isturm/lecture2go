/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException;
import de.uhh.l2g.plugins.model.OaiRecord_OaiSet;
import de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetImpl;
import de.uhh.l2g.plugins.model.impl.OaiRecord_OaiSetModelImpl;
import de.uhh.l2g.plugins.service.persistence.OaiRecord_OaiSetPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the oai record_ oai set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class OaiRecord_OaiSetPersistenceImpl
	extends BasePersistenceImpl<OaiRecord_OaiSet>
	implements OaiRecord_OaiSetPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OaiRecord_OaiSetUtil</code> to access the oai record_ oai set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OaiRecord_OaiSetImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByoaiSet;
	private FinderPath _finderPathWithoutPaginationFindByoaiSet;
	private FinderPath _finderPathCountByoaiSet;

	/**
	 * Returns all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @return the matching oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiSet(long oaiSetId) {
		return findByoaiSet(
			oaiSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of matching oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end) {

		return findByoaiSet(oaiSetId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return findByoaiSet(oaiSetId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByoaiSet;
				finderArgs = new Object[] {oaiSetId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByoaiSet;
			finderArgs = new Object[] {oaiSetId, start, end, orderByComparator};
		}

		List<OaiRecord_OaiSet> list = null;

		if (useFinderCache) {
			list = (List<OaiRecord_OaiSet>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OaiRecord_OaiSet oaiRecord_OaiSet : list) {
					if (oaiSetId != oaiRecord_OaiSet.getOaiSetId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OAIRECORD_OAISET_WHERE);

			sb.append(_FINDER_COLUMN_OAISET_OAISETID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(oaiSetId);

				list = (List<OaiRecord_OaiSet>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	@Override
	public OaiRecord_OaiSet findByoaiSet_First(
			long oaiSetId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws NoSuchOaiRecord_OaiSetException {

		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByoaiSet_First(
			oaiSetId, orderByComparator);

		if (oaiRecord_OaiSet != null) {
			return oaiRecord_OaiSet;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("oaiSetId=");
		sb.append(oaiSetId);

		sb.append("}");

		throw new NoSuchOaiRecord_OaiSetException(sb.toString());
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	@Override
	public OaiRecord_OaiSet fetchByoaiSet_First(
		long oaiSetId, OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		List<OaiRecord_OaiSet> list = findByoaiSet(
			oaiSetId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	@Override
	public OaiRecord_OaiSet findByoaiSet_Last(
			long oaiSetId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws NoSuchOaiRecord_OaiSetException {

		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByoaiSet_Last(
			oaiSetId, orderByComparator);

		if (oaiRecord_OaiSet != null) {
			return oaiRecord_OaiSet;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("oaiSetId=");
		sb.append(oaiSetId);

		sb.append("}");

		throw new NoSuchOaiRecord_OaiSetException(sb.toString());
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	@Override
	public OaiRecord_OaiSet fetchByoaiSet_Last(
		long oaiSetId, OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		int count = countByoaiSet(oaiSetId);

		if (count == 0) {
			return null;
		}

		List<OaiRecord_OaiSet> list = findByoaiSet(
			oaiSetId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public OaiRecord_OaiSet[] findByoaiSet_PrevAndNext(
			long oaiRecordOaiSetId, long oaiSetId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws NoSuchOaiRecord_OaiSetException {

		OaiRecord_OaiSet oaiRecord_OaiSet = findByPrimaryKey(oaiRecordOaiSetId);

		Session session = null;

		try {
			session = openSession();

			OaiRecord_OaiSet[] array = new OaiRecord_OaiSetImpl[3];

			array[0] = getByoaiSet_PrevAndNext(
				session, oaiRecord_OaiSet, oaiSetId, orderByComparator, true);

			array[1] = oaiRecord_OaiSet;

			array[2] = getByoaiSet_PrevAndNext(
				session, oaiRecord_OaiSet, oaiSetId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OaiRecord_OaiSet getByoaiSet_PrevAndNext(
		Session session, OaiRecord_OaiSet oaiRecord_OaiSet, long oaiSetId,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OAIRECORD_OAISET_WHERE);

		sb.append(_FINDER_COLUMN_OAISET_OAISETID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(oaiSetId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						oaiRecord_OaiSet)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OaiRecord_OaiSet> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the oai record_ oai sets where oaiSetId = &#63; from the database.
	 *
	 * @param oaiSetId the oai set ID
	 */
	@Override
	public void removeByoaiSet(long oaiSetId) {
		for (OaiRecord_OaiSet oaiRecord_OaiSet :
				findByoaiSet(
					oaiSetId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(oaiRecord_OaiSet);
		}
	}

	/**
	 * Returns the number of oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @return the number of matching oai record_ oai sets
	 */
	@Override
	public int countByoaiSet(long oaiSetId) {
		FinderPath finderPath = _finderPathCountByoaiSet;

		Object[] finderArgs = new Object[] {oaiSetId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OAIRECORD_OAISET_WHERE);

			sb.append(_FINDER_COLUMN_OAISET_OAISETID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(oaiSetId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_OAISET_OAISETID_2 =
		"oaiRecord_OaiSet.oaiSetId = ?";

	private FinderPath _finderPathWithPaginationFindByoaiRecord;
	private FinderPath _finderPathWithoutPaginationFindByoaiRecord;
	private FinderPath _finderPathCountByoaiRecord;

	/**
	 * Returns all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @return the matching oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiRecord(long oaiRecordId) {
		return findByoaiRecord(
			oaiRecordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of matching oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end) {

		return findByoaiRecord(oaiRecordId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return findByoaiRecord(
			oaiRecordId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByoaiRecord;
				finderArgs = new Object[] {oaiRecordId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByoaiRecord;
			finderArgs = new Object[] {
				oaiRecordId, start, end, orderByComparator
			};
		}

		List<OaiRecord_OaiSet> list = null;

		if (useFinderCache) {
			list = (List<OaiRecord_OaiSet>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (OaiRecord_OaiSet oaiRecord_OaiSet : list) {
					if (oaiRecordId != oaiRecord_OaiSet.getOaiRecordId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OAIRECORD_OAISET_WHERE);

			sb.append(_FINDER_COLUMN_OAIRECORD_OAIRECORDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(oaiRecordId);

				list = (List<OaiRecord_OaiSet>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	@Override
	public OaiRecord_OaiSet findByoaiRecord_First(
			long oaiRecordId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws NoSuchOaiRecord_OaiSetException {

		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByoaiRecord_First(
			oaiRecordId, orderByComparator);

		if (oaiRecord_OaiSet != null) {
			return oaiRecord_OaiSet;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("oaiRecordId=");
		sb.append(oaiRecordId);

		sb.append("}");

		throw new NoSuchOaiRecord_OaiSetException(sb.toString());
	}

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	@Override
	public OaiRecord_OaiSet fetchByoaiRecord_First(
		long oaiRecordId,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		List<OaiRecord_OaiSet> list = findByoaiRecord(
			oaiRecordId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	@Override
	public OaiRecord_OaiSet findByoaiRecord_Last(
			long oaiRecordId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws NoSuchOaiRecord_OaiSetException {

		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByoaiRecord_Last(
			oaiRecordId, orderByComparator);

		if (oaiRecord_OaiSet != null) {
			return oaiRecord_OaiSet;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("oaiRecordId=");
		sb.append(oaiRecordId);

		sb.append("}");

		throw new NoSuchOaiRecord_OaiSetException(sb.toString());
	}

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	@Override
	public OaiRecord_OaiSet fetchByoaiRecord_Last(
		long oaiRecordId,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		int count = countByoaiRecord(oaiRecordId);

		if (count == 0) {
			return null;
		}

		List<OaiRecord_OaiSet> list = findByoaiRecord(
			oaiRecordId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public OaiRecord_OaiSet[] findByoaiRecord_PrevAndNext(
			long oaiRecordOaiSetId, long oaiRecordId,
			OrderByComparator<OaiRecord_OaiSet> orderByComparator)
		throws NoSuchOaiRecord_OaiSetException {

		OaiRecord_OaiSet oaiRecord_OaiSet = findByPrimaryKey(oaiRecordOaiSetId);

		Session session = null;

		try {
			session = openSession();

			OaiRecord_OaiSet[] array = new OaiRecord_OaiSetImpl[3];

			array[0] = getByoaiRecord_PrevAndNext(
				session, oaiRecord_OaiSet, oaiRecordId, orderByComparator,
				true);

			array[1] = oaiRecord_OaiSet;

			array[2] = getByoaiRecord_PrevAndNext(
				session, oaiRecord_OaiSet, oaiRecordId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected OaiRecord_OaiSet getByoaiRecord_PrevAndNext(
		Session session, OaiRecord_OaiSet oaiRecord_OaiSet, long oaiRecordId,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OAIRECORD_OAISET_WHERE);

		sb.append(_FINDER_COLUMN_OAIRECORD_OAIRECORDID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(oaiRecordId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						oaiRecord_OaiSet)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<OaiRecord_OaiSet> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the oai record_ oai sets where oaiRecordId = &#63; from the database.
	 *
	 * @param oaiRecordId the oai record ID
	 */
	@Override
	public void removeByoaiRecord(long oaiRecordId) {
		for (OaiRecord_OaiSet oaiRecord_OaiSet :
				findByoaiRecord(
					oaiRecordId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(oaiRecord_OaiSet);
		}
	}

	/**
	 * Returns the number of oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @return the number of matching oai record_ oai sets
	 */
	@Override
	public int countByoaiRecord(long oaiRecordId) {
		FinderPath finderPath = _finderPathCountByoaiRecord;

		Object[] finderArgs = new Object[] {oaiRecordId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OAIRECORD_OAISET_WHERE);

			sb.append(_FINDER_COLUMN_OAIRECORD_OAIRECORDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(oaiRecordId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_OAIRECORD_OAIRECORDID_2 =
		"oaiRecord_OaiSet.oaiRecordId = ?";

	public OaiRecord_OaiSetPersistenceImpl() {
		setModelClass(OaiRecord_OaiSet.class);

		setModelImplClass(OaiRecord_OaiSetImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the oai record_ oai set in the entity cache if it is enabled.
	 *
	 * @param oaiRecord_OaiSet the oai record_ oai set
	 */
	@Override
	public void cacheResult(OaiRecord_OaiSet oaiRecord_OaiSet) {
		entityCache.putResult(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, oaiRecord_OaiSet.getPrimaryKey(),
			oaiRecord_OaiSet);

		oaiRecord_OaiSet.resetOriginalValues();
	}

	/**
	 * Caches the oai record_ oai sets in the entity cache if it is enabled.
	 *
	 * @param oaiRecord_OaiSets the oai record_ oai sets
	 */
	@Override
	public void cacheResult(List<OaiRecord_OaiSet> oaiRecord_OaiSets) {
		for (OaiRecord_OaiSet oaiRecord_OaiSet : oaiRecord_OaiSets) {
			if (entityCache.getResult(
					OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
					OaiRecord_OaiSetImpl.class,
					oaiRecord_OaiSet.getPrimaryKey()) == null) {

				cacheResult(oaiRecord_OaiSet);
			}
			else {
				oaiRecord_OaiSet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all oai record_ oai sets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OaiRecord_OaiSetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the oai record_ oai set.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OaiRecord_OaiSet oaiRecord_OaiSet) {
		entityCache.removeResult(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, oaiRecord_OaiSet.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OaiRecord_OaiSet> oaiRecord_OaiSets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OaiRecord_OaiSet oaiRecord_OaiSet : oaiRecord_OaiSets) {
			entityCache.removeResult(
				OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
				OaiRecord_OaiSetImpl.class, oaiRecord_OaiSet.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
				OaiRecord_OaiSetImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new oai record_ oai set with the primary key. Does not add the oai record_ oai set to the database.
	 *
	 * @param oaiRecordOaiSetId the primary key for the new oai record_ oai set
	 * @return the new oai record_ oai set
	 */
	@Override
	public OaiRecord_OaiSet create(long oaiRecordOaiSetId) {
		OaiRecord_OaiSet oaiRecord_OaiSet = new OaiRecord_OaiSetImpl();

		oaiRecord_OaiSet.setNew(true);
		oaiRecord_OaiSet.setPrimaryKey(oaiRecordOaiSetId);

		return oaiRecord_OaiSet;
	}

	/**
	 * Removes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set that was removed
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public OaiRecord_OaiSet remove(long oaiRecordOaiSetId)
		throws NoSuchOaiRecord_OaiSetException {

		return remove((Serializable)oaiRecordOaiSetId);
	}

	/**
	 * Removes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the oai record_ oai set
	 * @return the oai record_ oai set that was removed
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public OaiRecord_OaiSet remove(Serializable primaryKey)
		throws NoSuchOaiRecord_OaiSetException {

		Session session = null;

		try {
			session = openSession();

			OaiRecord_OaiSet oaiRecord_OaiSet = (OaiRecord_OaiSet)session.get(
				OaiRecord_OaiSetImpl.class, primaryKey);

			if (oaiRecord_OaiSet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOaiRecord_OaiSetException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(oaiRecord_OaiSet);
		}
		catch (NoSuchOaiRecord_OaiSetException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected OaiRecord_OaiSet removeImpl(OaiRecord_OaiSet oaiRecord_OaiSet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(oaiRecord_OaiSet)) {
				oaiRecord_OaiSet = (OaiRecord_OaiSet)session.get(
					OaiRecord_OaiSetImpl.class,
					oaiRecord_OaiSet.getPrimaryKeyObj());
			}

			if (oaiRecord_OaiSet != null) {
				session.delete(oaiRecord_OaiSet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (oaiRecord_OaiSet != null) {
			clearCache(oaiRecord_OaiSet);
		}

		return oaiRecord_OaiSet;
	}

	@Override
	public OaiRecord_OaiSet updateImpl(OaiRecord_OaiSet oaiRecord_OaiSet) {
		boolean isNew = oaiRecord_OaiSet.isNew();

		if (!(oaiRecord_OaiSet instanceof OaiRecord_OaiSetModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(oaiRecord_OaiSet.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					oaiRecord_OaiSet);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in oaiRecord_OaiSet proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OaiRecord_OaiSet implementation " +
					oaiRecord_OaiSet.getClass());
		}

		OaiRecord_OaiSetModelImpl oaiRecord_OaiSetModelImpl =
			(OaiRecord_OaiSetModelImpl)oaiRecord_OaiSet;

		Session session = null;

		try {
			session = openSession();

			if (oaiRecord_OaiSet.isNew()) {
				session.save(oaiRecord_OaiSet);

				oaiRecord_OaiSet.setNew(false);
			}
			else {
				oaiRecord_OaiSet = (OaiRecord_OaiSet)session.merge(
					oaiRecord_OaiSet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!OaiRecord_OaiSetModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				oaiRecord_OaiSetModelImpl.getOaiSetId()
			};

			finderCache.removeResult(_finderPathCountByoaiSet, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByoaiSet, args);

			args = new Object[] {oaiRecord_OaiSetModelImpl.getOaiRecordId()};

			finderCache.removeResult(_finderPathCountByoaiRecord, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByoaiRecord, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((oaiRecord_OaiSetModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByoaiSet.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					oaiRecord_OaiSetModelImpl.getOriginalOaiSetId()
				};

				finderCache.removeResult(_finderPathCountByoaiSet, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByoaiSet, args);

				args = new Object[] {oaiRecord_OaiSetModelImpl.getOaiSetId()};

				finderCache.removeResult(_finderPathCountByoaiSet, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByoaiSet, args);
			}

			if ((oaiRecord_OaiSetModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByoaiRecord.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					oaiRecord_OaiSetModelImpl.getOriginalOaiRecordId()
				};

				finderCache.removeResult(_finderPathCountByoaiRecord, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByoaiRecord, args);

				args = new Object[] {
					oaiRecord_OaiSetModelImpl.getOaiRecordId()
				};

				finderCache.removeResult(_finderPathCountByoaiRecord, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByoaiRecord, args);
			}
		}

		entityCache.putResult(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, oaiRecord_OaiSet.getPrimaryKey(),
			oaiRecord_OaiSet, false);

		oaiRecord_OaiSet.resetOriginalValues();

		return oaiRecord_OaiSet;
	}

	/**
	 * Returns the oai record_ oai set with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai record_ oai set
	 * @return the oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public OaiRecord_OaiSet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOaiRecord_OaiSetException {

		OaiRecord_OaiSet oaiRecord_OaiSet = fetchByPrimaryKey(primaryKey);

		if (oaiRecord_OaiSet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOaiRecord_OaiSetException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return oaiRecord_OaiSet;
	}

	/**
	 * Returns the oai record_ oai set with the primary key or throws a <code>NoSuchOaiRecord_OaiSetException</code> if it could not be found.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public OaiRecord_OaiSet findByPrimaryKey(long oaiRecordOaiSetId)
		throws NoSuchOaiRecord_OaiSetException {

		return findByPrimaryKey((Serializable)oaiRecordOaiSetId);
	}

	/**
	 * Returns the oai record_ oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set, or <code>null</code> if a oai record_ oai set with the primary key could not be found
	 */
	@Override
	public OaiRecord_OaiSet fetchByPrimaryKey(long oaiRecordOaiSetId) {
		return fetchByPrimaryKey((Serializable)oaiRecordOaiSetId);
	}

	/**
	 * Returns all the oai record_ oai sets.
	 *
	 * @return the oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findAll(
		int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oai record_ oai sets
	 */
	@Override
	public List<OaiRecord_OaiSet> findAll(
		int start, int end,
		OrderByComparator<OaiRecord_OaiSet> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<OaiRecord_OaiSet> list = null;

		if (useFinderCache) {
			list = (List<OaiRecord_OaiSet>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OAIRECORD_OAISET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OAIRECORD_OAISET;

				sql = sql.concat(OaiRecord_OaiSetModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OaiRecord_OaiSet>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the oai record_ oai sets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OaiRecord_OaiSet oaiRecord_OaiSet : findAll()) {
			remove(oaiRecord_OaiSet);
		}
	}

	/**
	 * Returns the number of oai record_ oai sets.
	 *
	 * @return the number of oai record_ oai sets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OAIRECORD_OAISET);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "oaiRecordOaiSetId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OAIRECORD_OAISET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OaiRecord_OaiSetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the oai record_ oai set persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByoaiSet = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByoaiSet",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByoaiSet = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByoaiSet",
			new String[] {Long.class.getName()},
			OaiRecord_OaiSetModelImpl.OAISETID_COLUMN_BITMASK);

		_finderPathCountByoaiSet = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoaiSet",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByoaiRecord = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByoaiRecord",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByoaiRecord = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED,
			OaiRecord_OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByoaiRecord",
			new String[] {Long.class.getName()},
			OaiRecord_OaiSetModelImpl.OAIRECORDID_COLUMN_BITMASK);

		_finderPathCountByoaiRecord = new FinderPath(
			OaiRecord_OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecord_OaiSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByoaiRecord",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(OaiRecord_OaiSetImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OAIRECORD_OAISET =
		"SELECT oaiRecord_OaiSet FROM OaiRecord_OaiSet oaiRecord_OaiSet";

	private static final String _SQL_SELECT_OAIRECORD_OAISET_WHERE =
		"SELECT oaiRecord_OaiSet FROM OaiRecord_OaiSet oaiRecord_OaiSet WHERE ";

	private static final String _SQL_COUNT_OAIRECORD_OAISET =
		"SELECT COUNT(oaiRecord_OaiSet) FROM OaiRecord_OaiSet oaiRecord_OaiSet";

	private static final String _SQL_COUNT_OAIRECORD_OAISET_WHERE =
		"SELECT COUNT(oaiRecord_OaiSet) FROM OaiRecord_OaiSet oaiRecord_OaiSet WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "oaiRecord_OaiSet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OaiRecord_OaiSet exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OaiRecord_OaiSet exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OaiRecord_OaiSetPersistenceImpl.class);

}