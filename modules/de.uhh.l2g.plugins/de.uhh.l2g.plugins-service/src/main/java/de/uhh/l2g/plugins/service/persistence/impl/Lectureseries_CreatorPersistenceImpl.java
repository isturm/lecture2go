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

import de.uhh.l2g.plugins.exception.NoSuchLectureseries_CreatorException;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorImpl;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorModelImpl;
import de.uhh.l2g.plugins.service.persistence.Lectureseries_CreatorPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the lectureseries_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class Lectureseries_CreatorPersistenceImpl
	extends BasePersistenceImpl<Lectureseries_Creator>
	implements Lectureseries_CreatorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Lectureseries_CreatorUtil</code> to access the lectureseries_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Lectureseries_CreatorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLectureseries;
	private FinderPath _finderPathWithoutPaginationFindByLectureseries;
	private FinderPath _finderPathCountByLectureseries;

	/**
	 * Returns all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId) {

		return findByLectureseries(
			lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end) {

		return findByLectureseries(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return findByLectureseries(
			lectureseriesId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLectureseries;
				finderArgs = new Object[] {lectureseriesId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLectureseries;
			finderArgs = new Object[] {
				lectureseriesId, start, end, orderByComparator
			};
		}

		List<Lectureseries_Creator> list = null;

		if (useFinderCache) {
			list = (List<Lectureseries_Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries_Creator lectureseries_Creator : list) {
					if (lectureseriesId !=
							lectureseries_Creator.getLectureseriesId()) {

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

			sb.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lectureseriesId);

				list = (List<Lectureseries_Creator>)QueryUtil.list(
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
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator findByLectureseries_First(
			long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator =
			fetchByLectureseries_First(lectureseriesId, orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lectureseriesId=");
		sb.append(lectureseriesId);

		sb.append("}");

		throw new NoSuchLectureseries_CreatorException(sb.toString());
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator fetchByLectureseries_First(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		List<Lectureseries_Creator> list = findByLectureseries(
			lectureseriesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator findByLectureseries_Last(
			long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator = fetchByLectureseries_Last(
			lectureseriesId, orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lectureseriesId=");
		sb.append(lectureseriesId);

		sb.append("}");

		throw new NoSuchLectureseries_CreatorException(sb.toString());
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator fetchByLectureseries_Last(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		int count = countByLectureseries(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Creator> list = findByLectureseries(
			lectureseriesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	@Override
	public Lectureseries_Creator[] findByLectureseries_PrevAndNext(
			long lectureseriesCreatorId, long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator = findByPrimaryKey(
			lectureseriesCreatorId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Creator[] array = new Lectureseries_CreatorImpl[3];

			array[0] = getByLectureseries_PrevAndNext(
				session, lectureseries_Creator, lectureseriesId,
				orderByComparator, true);

			array[1] = lectureseries_Creator;

			array[2] = getByLectureseries_PrevAndNext(
				session, lectureseries_Creator, lectureseriesId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries_Creator getByLectureseries_PrevAndNext(
		Session session, Lectureseries_Creator lectureseries_Creator,
		long lectureseriesId,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
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

		sb.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

		sb.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

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
			sb.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lectureseriesId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lectureseries_Creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lectureseries_Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ creators where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByLectureseries(long lectureseriesId) {
		for (Lectureseries_Creator lectureseries_Creator :
				findByLectureseries(
					lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(lectureseries_Creator);
		}
	}

	/**
	 * Returns the number of lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ creators
	 */
	@Override
	public int countByLectureseries(long lectureseriesId) {
		FinderPath finderPath = _finderPathCountByLectureseries;

		Object[] finderArgs = new Object[] {lectureseriesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LECTURESERIES_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lectureseriesId);

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

	private static final String _FINDER_COLUMN_LECTURESERIES_LECTURESERIESID_2 =
		"lectureseries_Creator.lectureseriesId = ?";

	private FinderPath _finderPathWithPaginationFindByCreator;
	private FinderPath _finderPathWithoutPaginationFindByCreator;
	private FinderPath _finderPathCountByCreator;

	/**
	 * Returns all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByCreator(long creatorId) {
		return findByCreator(
			creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end) {

		return findByCreator(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return findByCreator(creatorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCreator;
				finderArgs = new Object[] {creatorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCreator;
			finderArgs = new Object[] {
				creatorId, start, end, orderByComparator
			};
		}

		List<Lectureseries_Creator> list = null;

		if (useFinderCache) {
			list = (List<Lectureseries_Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries_Creator lectureseries_Creator : list) {
					if (creatorId != lectureseries_Creator.getCreatorId()) {
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

			sb.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(creatorId);

				list = (List<Lectureseries_Creator>)QueryUtil.list(
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
	 * Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator findByCreator_First(
			long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator = fetchByCreator_First(
			creatorId, orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("creatorId=");
		sb.append(creatorId);

		sb.append("}");

		throw new NoSuchLectureseries_CreatorException(sb.toString());
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator fetchByCreator_First(
		long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		List<Lectureseries_Creator> list = findByCreator(
			creatorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator findByCreator_Last(
			long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator = fetchByCreator_Last(
			creatorId, orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("creatorId=");
		sb.append(creatorId);

		sb.append("}");

		throw new NoSuchLectureseries_CreatorException(sb.toString());
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator fetchByCreator_Last(
		long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		int count = countByCreator(creatorId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Creator> list = findByCreator(
			creatorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	@Override
	public Lectureseries_Creator[] findByCreator_PrevAndNext(
			long lectureseriesCreatorId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator = findByPrimaryKey(
			lectureseriesCreatorId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Creator[] array = new Lectureseries_CreatorImpl[3];

			array[0] = getByCreator_PrevAndNext(
				session, lectureseries_Creator, creatorId, orderByComparator,
				true);

			array[1] = lectureseries_Creator;

			array[2] = getByCreator_PrevAndNext(
				session, lectureseries_Creator, creatorId, orderByComparator,
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

	protected Lectureseries_Creator getByCreator_PrevAndNext(
		Session session, Lectureseries_Creator lectureseries_Creator,
		long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
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

		sb.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

		sb.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

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
			sb.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(creatorId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lectureseries_Creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lectureseries_Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 */
	@Override
	public void removeByCreator(long creatorId) {
		for (Lectureseries_Creator lectureseries_Creator :
				findByCreator(
					creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(lectureseries_Creator);
		}
	}

	/**
	 * Returns the number of lectureseries_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching lectureseries_ creators
	 */
	@Override
	public int countByCreator(long creatorId) {
		FinderPath finderPath = _finderPathCountByCreator;

		Object[] finderArgs = new Object[] {creatorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LECTURESERIES_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_CREATOR_CREATORID_2 =
		"lectureseries_Creator.creatorId = ?";

	private FinderPath _finderPathWithPaginationFindByLectureseriesCreator;
	private FinderPath _finderPathWithoutPaginationFindByLectureseriesCreator;
	private FinderPath _finderPathCountByLectureseriesCreator;

	/**
	 * Returns all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @return the matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId) {

		return findByLectureseriesCreator(
			lectureseriesId, creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end) {

		return findByLectureseriesCreator(
			lectureseriesId, creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return findByLectureseriesCreator(
			lectureseriesId, creatorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByLectureseriesCreator;
				finderArgs = new Object[] {lectureseriesId, creatorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLectureseriesCreator;
			finderArgs = new Object[] {
				lectureseriesId, creatorId, start, end, orderByComparator
			};
		}

		List<Lectureseries_Creator> list = null;

		if (useFinderCache) {
			list = (List<Lectureseries_Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Lectureseries_Creator lectureseries_Creator : list) {
					if ((lectureseriesId !=
							lectureseries_Creator.getLectureseriesId()) ||
						(creatorId != lectureseries_Creator.getCreatorId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_LECTURESERIESCREATOR_LECTURESERIESID_2);

			sb.append(_FINDER_COLUMN_LECTURESERIESCREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lectureseriesId);

				queryPos.add(creatorId);

				list = (List<Lectureseries_Creator>)QueryUtil.list(
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
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator findByLectureseriesCreator_First(
			long lectureseriesId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator =
			fetchByLectureseriesCreator_First(
				lectureseriesId, creatorId, orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lectureseriesId=");
		sb.append(lectureseriesId);

		sb.append(", creatorId=");
		sb.append(creatorId);

		sb.append("}");

		throw new NoSuchLectureseries_CreatorException(sb.toString());
	}

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator fetchByLectureseriesCreator_First(
		long lectureseriesId, long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		List<Lectureseries_Creator> list = findByLectureseriesCreator(
			lectureseriesId, creatorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator findByLectureseriesCreator_Last(
			long lectureseriesId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator =
			fetchByLectureseriesCreator_Last(
				lectureseriesId, creatorId, orderByComparator);

		if (lectureseries_Creator != null) {
			return lectureseries_Creator;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lectureseriesId=");
		sb.append(lectureseriesId);

		sb.append(", creatorId=");
		sb.append(creatorId);

		sb.append("}");

		throw new NoSuchLectureseries_CreatorException(sb.toString());
	}

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	@Override
	public Lectureseries_Creator fetchByLectureseriesCreator_Last(
		long lectureseriesId, long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		int count = countByLectureseriesCreator(lectureseriesId, creatorId);

		if (count == 0) {
			return null;
		}

		List<Lectureseries_Creator> list = findByLectureseriesCreator(
			lectureseriesId, creatorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	@Override
	public Lectureseries_Creator[] findByLectureseriesCreator_PrevAndNext(
			long lectureseriesCreatorId, long lectureseriesId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator = findByPrimaryKey(
			lectureseriesCreatorId);

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Creator[] array = new Lectureseries_CreatorImpl[3];

			array[0] = getByLectureseriesCreator_PrevAndNext(
				session, lectureseries_Creator, lectureseriesId, creatorId,
				orderByComparator, true);

			array[1] = lectureseries_Creator;

			array[2] = getByLectureseriesCreator_PrevAndNext(
				session, lectureseries_Creator, lectureseriesId, creatorId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Lectureseries_Creator getByLectureseriesCreator_PrevAndNext(
		Session session, Lectureseries_Creator lectureseries_Creator,
		long lectureseriesId, long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LECTURESERIES_CREATOR_WHERE);

		sb.append(_FINDER_COLUMN_LECTURESERIESCREATOR_LECTURESERIESID_2);

		sb.append(_FINDER_COLUMN_LECTURESERIESCREATOR_CREATORID_2);

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
			sb.append(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(lectureseriesId);

		queryPos.add(creatorId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						lectureseries_Creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Lectureseries_Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 */
	@Override
	public void removeByLectureseriesCreator(
		long lectureseriesId, long creatorId) {

		for (Lectureseries_Creator lectureseries_Creator :
				findByLectureseriesCreator(
					lectureseriesId, creatorId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(lectureseries_Creator);
		}
	}

	/**
	 * Returns the number of lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @return the number of matching lectureseries_ creators
	 */
	@Override
	public int countByLectureseriesCreator(
		long lectureseriesId, long creatorId) {

		FinderPath finderPath = _finderPathCountByLectureseriesCreator;

		Object[] finderArgs = new Object[] {lectureseriesId, creatorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LECTURESERIES_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_LECTURESERIESCREATOR_LECTURESERIESID_2);

			sb.append(_FINDER_COLUMN_LECTURESERIESCREATOR_CREATORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(lectureseriesId);

				queryPos.add(creatorId);

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

	private static final String
		_FINDER_COLUMN_LECTURESERIESCREATOR_LECTURESERIESID_2 =
			"lectureseries_Creator.lectureseriesId = ? AND ";

	private static final String
		_FINDER_COLUMN_LECTURESERIESCREATOR_CREATORID_2 =
			"lectureseries_Creator.creatorId = ?";

	public Lectureseries_CreatorPersistenceImpl() {
		setModelClass(Lectureseries_Creator.class);

		setModelImplClass(Lectureseries_CreatorImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the lectureseries_ creator in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Creator the lectureseries_ creator
	 */
	@Override
	public void cacheResult(Lectureseries_Creator lectureseries_Creator) {
		entityCache.putResult(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			lectureseries_Creator.getPrimaryKey(), lectureseries_Creator);

		lectureseries_Creator.resetOriginalValues();
	}

	/**
	 * Caches the lectureseries_ creators in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Creators the lectureseries_ creators
	 */
	@Override
	public void cacheResult(
		List<Lectureseries_Creator> lectureseries_Creators) {

		for (Lectureseries_Creator lectureseries_Creator :
				lectureseries_Creators) {

			if (entityCache.getResult(
					Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
					Lectureseries_CreatorImpl.class,
					lectureseries_Creator.getPrimaryKey()) == null) {

				cacheResult(lectureseries_Creator);
			}
			else {
				lectureseries_Creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lectureseries_ creators.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Lectureseries_CreatorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lectureseries_ creator.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lectureseries_Creator lectureseries_Creator) {
		entityCache.removeResult(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			lectureseries_Creator.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Lectureseries_Creator> lectureseries_Creators) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Lectureseries_Creator lectureseries_Creator :
				lectureseries_Creators) {

			entityCache.removeResult(
				Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_CreatorImpl.class,
				lectureseries_Creator.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Lectureseries_CreatorImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new lectureseries_ creator with the primary key. Does not add the lectureseries_ creator to the database.
	 *
	 * @param lectureseriesCreatorId the primary key for the new lectureseries_ creator
	 * @return the new lectureseries_ creator
	 */
	@Override
	public Lectureseries_Creator create(long lectureseriesCreatorId) {
		Lectureseries_Creator lectureseries_Creator =
			new Lectureseries_CreatorImpl();

		lectureseries_Creator.setNew(true);
		lectureseries_Creator.setPrimaryKey(lectureseriesCreatorId);

		return lectureseries_Creator;
	}

	/**
	 * Removes the lectureseries_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator that was removed
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	@Override
	public Lectureseries_Creator remove(long lectureseriesCreatorId)
		throws NoSuchLectureseries_CreatorException {

		return remove((Serializable)lectureseriesCreatorId);
	}

	/**
	 * Removes the lectureseries_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator that was removed
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	@Override
	public Lectureseries_Creator remove(Serializable primaryKey)
		throws NoSuchLectureseries_CreatorException {

		Session session = null;

		try {
			session = openSession();

			Lectureseries_Creator lectureseries_Creator =
				(Lectureseries_Creator)session.get(
					Lectureseries_CreatorImpl.class, primaryKey);

			if (lectureseries_Creator == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLectureseries_CreatorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lectureseries_Creator);
		}
		catch (NoSuchLectureseries_CreatorException noSuchEntityException) {
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
	protected Lectureseries_Creator removeImpl(
		Lectureseries_Creator lectureseries_Creator) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lectureseries_Creator)) {
				lectureseries_Creator = (Lectureseries_Creator)session.get(
					Lectureseries_CreatorImpl.class,
					lectureseries_Creator.getPrimaryKeyObj());
			}

			if (lectureseries_Creator != null) {
				session.delete(lectureseries_Creator);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lectureseries_Creator != null) {
			clearCache(lectureseries_Creator);
		}

		return lectureseries_Creator;
	}

	@Override
	public Lectureseries_Creator updateImpl(
		Lectureseries_Creator lectureseries_Creator) {

		boolean isNew = lectureseries_Creator.isNew();

		if (!(lectureseries_Creator instanceof
				Lectureseries_CreatorModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lectureseries_Creator.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					lectureseries_Creator);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lectureseries_Creator proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Lectureseries_Creator implementation " +
					lectureseries_Creator.getClass());
		}

		Lectureseries_CreatorModelImpl lectureseries_CreatorModelImpl =
			(Lectureseries_CreatorModelImpl)lectureseries_Creator;

		Session session = null;

		try {
			session = openSession();

			if (lectureseries_Creator.isNew()) {
				session.save(lectureseries_Creator);

				lectureseries_Creator.setNew(false);
			}
			else {
				lectureseries_Creator = (Lectureseries_Creator)session.merge(
					lectureseries_Creator);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Lectureseries_CreatorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				lectureseries_CreatorModelImpl.getLectureseriesId()
			};

			finderCache.removeResult(_finderPathCountByLectureseries, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLectureseries, args);

			args = new Object[] {lectureseries_CreatorModelImpl.getCreatorId()};

			finderCache.removeResult(_finderPathCountByCreator, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCreator, args);

			args = new Object[] {
				lectureseries_CreatorModelImpl.getLectureseriesId(),
				lectureseries_CreatorModelImpl.getCreatorId()
			};

			finderCache.removeResult(
				_finderPathCountByLectureseriesCreator, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLectureseriesCreator, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((lectureseries_CreatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLectureseries.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lectureseries_CreatorModelImpl.getOriginalLectureseriesId()
				};

				finderCache.removeResult(_finderPathCountByLectureseries, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseries, args);

				args = new Object[] {
					lectureseries_CreatorModelImpl.getLectureseriesId()
				};

				finderCache.removeResult(_finderPathCountByLectureseries, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseries, args);
			}

			if ((lectureseries_CreatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCreator.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lectureseries_CreatorModelImpl.getOriginalCreatorId()
				};

				finderCache.removeResult(_finderPathCountByCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCreator, args);

				args = new Object[] {
					lectureseries_CreatorModelImpl.getCreatorId()
				};

				finderCache.removeResult(_finderPathCountByCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCreator, args);
			}

			if ((lectureseries_CreatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLectureseriesCreator.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					lectureseries_CreatorModelImpl.getOriginalLectureseriesId(),
					lectureseries_CreatorModelImpl.getOriginalCreatorId()
				};

				finderCache.removeResult(
					_finderPathCountByLectureseriesCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseriesCreator,
					args);

				args = new Object[] {
					lectureseries_CreatorModelImpl.getLectureseriesId(),
					lectureseries_CreatorModelImpl.getCreatorId()
				};

				finderCache.removeResult(
					_finderPathCountByLectureseriesCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseriesCreator,
					args);
			}
		}

		entityCache.putResult(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			lectureseries_Creator.getPrimaryKey(), lectureseries_Creator,
			false);

		lectureseries_Creator.resetOriginalValues();

		return lectureseries_Creator;
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	@Override
	public Lectureseries_Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLectureseries_CreatorException {

		Lectureseries_Creator lectureseries_Creator = fetchByPrimaryKey(
			primaryKey);

		if (lectureseries_Creator == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLectureseries_CreatorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lectureseries_Creator;
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or throws a <code>NoSuchLectureseries_CreatorException</code> if it could not be found.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	@Override
	public Lectureseries_Creator findByPrimaryKey(long lectureseriesCreatorId)
		throws NoSuchLectureseries_CreatorException {

		return findByPrimaryKey((Serializable)lectureseriesCreatorId);
	}

	/**
	 * Returns the lectureseries_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator, or <code>null</code> if a lectureseries_ creator with the primary key could not be found
	 */
	@Override
	public Lectureseries_Creator fetchByPrimaryKey(
		long lectureseriesCreatorId) {

		return fetchByPrimaryKey((Serializable)lectureseriesCreatorId);
	}

	/**
	 * Returns all the lectureseries_ creators.
	 *
	 * @return the lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findAll(
		int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lectureseries_ creators
	 */
	@Override
	public List<Lectureseries_Creator> findAll(
		int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
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

		List<Lectureseries_Creator> list = null;

		if (useFinderCache) {
			list = (List<Lectureseries_Creator>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LECTURESERIES_CREATOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LECTURESERIES_CREATOR;

				sql = sql.concat(Lectureseries_CreatorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Lectureseries_Creator>)QueryUtil.list(
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
	 * Removes all the lectureseries_ creators from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lectureseries_Creator lectureseries_Creator : findAll()) {
			remove(lectureseries_Creator);
		}
	}

	/**
	 * Returns the number of lectureseries_ creators.
	 *
	 * @return the number of lectureseries_ creators
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_LECTURESERIES_CREATOR);

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
		return "lectureseriesCreatorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LECTURESERIES_CREATOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Lectureseries_CreatorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lectureseries_ creator persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByLectureseries = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseries",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLectureseries = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseries",
			new String[] {Long.class.getName()},
			Lectureseries_CreatorModelImpl.LECTURESERIESID_COLUMN_BITMASK);

		_finderPathCountByLectureseries = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseries",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCreator = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreator",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCreator = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreator",
			new String[] {Long.class.getName()},
			Lectureseries_CreatorModelImpl.CREATORID_COLUMN_BITMASK);

		_finderPathCountByCreator = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreator",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByLectureseriesCreator = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByLectureseriesCreator",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLectureseriesCreator = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Lectureseries_CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByLectureseriesCreator",
			new String[] {Long.class.getName(), Long.class.getName()},
			Lectureseries_CreatorModelImpl.LECTURESERIESID_COLUMN_BITMASK |
			Lectureseries_CreatorModelImpl.CREATORID_COLUMN_BITMASK);

		_finderPathCountByLectureseriesCreator = new FinderPath(
			Lectureseries_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Lectureseries_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesCreator",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(Lectureseries_CreatorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LECTURESERIES_CREATOR =
		"SELECT lectureseries_Creator FROM Lectureseries_Creator lectureseries_Creator";

	private static final String _SQL_SELECT_LECTURESERIES_CREATOR_WHERE =
		"SELECT lectureseries_Creator FROM Lectureseries_Creator lectureseries_Creator WHERE ";

	private static final String _SQL_COUNT_LECTURESERIES_CREATOR =
		"SELECT COUNT(lectureseries_Creator) FROM Lectureseries_Creator lectureseries_Creator";

	private static final String _SQL_COUNT_LECTURESERIES_CREATOR_WHERE =
		"SELECT COUNT(lectureseries_Creator) FROM Lectureseries_Creator lectureseries_Creator WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"lectureseries_Creator.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Lectureseries_Creator exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Lectureseries_Creator exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Lectureseries_CreatorPersistenceImpl.class);

}