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

import de.uhh.l2g.plugins.exception.NoSuchProducer_LectureseriesException;
import de.uhh.l2g.plugins.model.Producer_Lectureseries;
import de.uhh.l2g.plugins.model.impl.Producer_LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.Producer_LectureseriesModelImpl;
import de.uhh.l2g.plugins.service.persistence.Producer_LectureseriesPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence implementation for the producer_ lectureseries service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Producer_LectureseriesPersistenceImpl
	extends BasePersistenceImpl<Producer_Lectureseries>
	implements Producer_LectureseriesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Producer_LectureseriesUtil</code> to access the producer_ lectureseries persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Producer_LectureseriesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByLectureseriesId;
	private FinderPath _finderPathWithoutPaginationFindByLectureseriesId;
	private FinderPath _finderPathCountByLectureseriesId;

	/**
	 * Returns all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId) {

		return findByLectureseriesId(
			lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end) {

		return findByLectureseriesId(lectureseriesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLectureseriesId(long, int, int, OrderByComparator)}
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	@Deprecated
	@Override
	public List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return findByLectureseriesId(
			lectureseriesId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesId(
		long lectureseriesId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByLectureseriesId;
			finderArgs = new Object[] {lectureseriesId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByLectureseriesId;
			finderArgs = new Object[] {
				lectureseriesId, start, end, orderByComparator
			};
		}

		List<Producer_Lectureseries> list =
			(List<Producer_Lectureseries>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer_Lectureseries producer_Lectureseries : list) {
				if ((lectureseriesId !=
						producer_Lectureseries.getLectureseriesId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				if (!pagination) {
					list = (List<Producer_Lectureseries>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Producer_Lectureseries>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries findByLectureseriesId_First(
			long lectureseriesId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries =
			fetchByLectureseriesId_First(lectureseriesId, orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append("}");

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries fetchByLectureseriesId_First(
		long lectureseriesId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		List<Producer_Lectureseries> list = findByLectureseriesId(
			lectureseriesId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries findByLectureseriesId_Last(
			long lectureseriesId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries =
			fetchByLectureseriesId_Last(lectureseriesId, orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append("}");

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries fetchByLectureseriesId_Last(
		long lectureseriesId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		int count = countByLectureseriesId(lectureseriesId);

		if (count == 0) {
			return null;
		}

		List<Producer_Lectureseries> list = findByLectureseriesId(
			lectureseriesId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public Producer_Lectureseries[] findByLectureseriesId_PrevAndNext(
			long producerLectureseriesId, long lectureseriesId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries = findByPrimaryKey(
			producerLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Producer_Lectureseries[] array = new Producer_LectureseriesImpl[3];

			array[0] = getByLectureseriesId_PrevAndNext(
				session, producer_Lectureseries, lectureseriesId,
				orderByComparator, true);

			array[1] = producer_Lectureseries;

			array[2] = getByLectureseriesId_PrevAndNext(
				session, producer_Lectureseries, lectureseriesId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Producer_Lectureseries getByLectureseriesId_PrevAndNext(
		Session session, Producer_Lectureseries producer_Lectureseries,
		long lectureseriesId,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						producer_Lectureseries)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Producer_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producer_ lectureserieses where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	@Override
	public void removeByLectureseriesId(long lectureseriesId) {
		for (Producer_Lectureseries producer_Lectureseries :
				findByLectureseriesId(
					lectureseriesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(producer_Lectureseries);
		}
	}

	/**
	 * Returns the number of producer_ lectureserieses where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching producer_ lectureserieses
	 */
	@Override
	public int countByLectureseriesId(long lectureseriesId) {
		FinderPath finderPath = _finderPathCountByLectureseriesId;

		Object[] finderArgs = new Object[] {lectureseriesId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_LECTURESERIESID_LECTURESERIESID_2 =
			"producer_Lectureseries.lectureseriesId = ?";

	private FinderPath _finderPathWithPaginationFindByProducerId;
	private FinderPath _finderPathWithoutPaginationFindByProducerId;
	private FinderPath _finderPathCountByProducerId;

	/**
	 * Returns all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByProducerId(long producerId) {
		return findByProducerId(
			producerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end) {

		return findByProducerId(producerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByProducerId(long, int, int, OrderByComparator)}
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	@Deprecated
	@Override
	public List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return findByProducerId(producerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByProducerId(
		long producerId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByProducerId;
			finderArgs = new Object[] {producerId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByProducerId;
			finderArgs = new Object[] {
				producerId, start, end, orderByComparator
			};
		}

		List<Producer_Lectureseries> list =
			(List<Producer_Lectureseries>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer_Lectureseries producer_Lectureseries : list) {
				if ((producerId != producer_Lectureseries.getProducerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERID_PRODUCERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				if (!pagination) {
					list = (List<Producer_Lectureseries>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Producer_Lectureseries>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries findByProducerId_First(
			long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries = fetchByProducerId_First(
			producerId, orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append("}");

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries fetchByProducerId_First(
		long producerId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		List<Producer_Lectureseries> list = findByProducerId(
			producerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries findByProducerId_Last(
			long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries = fetchByProducerId_Last(
			producerId, orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("producerId=");
		msg.append(producerId);

		msg.append("}");

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries fetchByProducerId_Last(
		long producerId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		int count = countByProducerId(producerId);

		if (count == 0) {
			return null;
		}

		List<Producer_Lectureseries> list = findByProducerId(
			producerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where producerId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public Producer_Lectureseries[] findByProducerId_PrevAndNext(
			long producerLectureseriesId, long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries = findByPrimaryKey(
			producerLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Producer_Lectureseries[] array = new Producer_LectureseriesImpl[3];

			array[0] = getByProducerId_PrevAndNext(
				session, producer_Lectureseries, producerId, orderByComparator,
				true);

			array[1] = producer_Lectureseries;

			array[2] = getByProducerId_PrevAndNext(
				session, producer_Lectureseries, producerId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Producer_Lectureseries getByProducerId_PrevAndNext(
		Session session, Producer_Lectureseries producer_Lectureseries,
		long producerId,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

		query.append(_FINDER_COLUMN_PRODUCERID_PRODUCERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(producerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						producer_Lectureseries)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Producer_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producer_ lectureserieses where producerId = &#63; from the database.
	 *
	 * @param producerId the producer ID
	 */
	@Override
	public void removeByProducerId(long producerId) {
		for (Producer_Lectureseries producer_Lectureseries :
				findByProducerId(
					producerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(producer_Lectureseries);
		}
	}

	/**
	 * Returns the number of producer_ lectureserieses where producerId = &#63;.
	 *
	 * @param producerId the producer ID
	 * @return the number of matching producer_ lectureserieses
	 */
	@Override
	public int countByProducerId(long producerId) {
		FinderPath finderPath = _finderPathCountByProducerId;

		Object[] finderArgs = new Object[] {producerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PRODUCER_LECTURESERIES_WHERE);

			query.append(_FINDER_COLUMN_PRODUCERID_PRODUCERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(producerId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRODUCERID_PRODUCERID_2 =
		"producer_Lectureseries.producerId = ?";

	private FinderPath
		_finderPathWithPaginationFindByLectureseriesIdAndProducerId;
	private FinderPath
		_finderPathWithoutPaginationFindByLectureseriesIdAndProducerId;
	private FinderPath _finderPathCountByLectureseriesIdAndProducerId;

	/**
	 * Returns all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @return the matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId) {

		return findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId, int start, int end) {

		return findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLectureseriesIdAndProducerId(long,long, int, int, OrderByComparator)}
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	@Deprecated
	@Override
	public List<Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId, int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindByLectureseriesIdAndProducerId;
			finderArgs = new Object[] {lectureseriesId, producerId};
		}
		else {
			finderPath =
				_finderPathWithPaginationFindByLectureseriesIdAndProducerId;
			finderArgs = new Object[] {
				lectureseriesId, producerId, start, end, orderByComparator
			};
		}

		List<Producer_Lectureseries> list =
			(List<Producer_Lectureseries>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Producer_Lectureseries producer_Lectureseries : list) {
				if ((lectureseriesId !=
						producer_Lectureseries.getLectureseriesId()) ||
					(producerId != producer_Lectureseries.getProducerId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

			query.append(
				_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_LECTURESERIESID_2);

			query.append(
				_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_PRODUCERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(producerId);

				if (!pagination) {
					list = (List<Producer_Lectureseries>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Producer_Lectureseries>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries findByLectureseriesIdAndProducerId_First(
			long lectureseriesId, long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries =
			fetchByLectureseriesIdAndProducerId_First(
				lectureseriesId, producerId, orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", producerId=");
		msg.append(producerId);

		msg.append("}");

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the first producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries fetchByLectureseriesIdAndProducerId_First(
		long lectureseriesId, long producerId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		List<Producer_Lectureseries> list = findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries findByLectureseriesIdAndProducerId_Last(
			long lectureseriesId, long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries =
			fetchByLectureseriesIdAndProducerId_Last(
				lectureseriesId, producerId, orderByComparator);

		if (producer_Lectureseries != null) {
			return producer_Lectureseries;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("lectureseriesId=");
		msg.append(lectureseriesId);

		msg.append(", producerId=");
		msg.append(producerId);

		msg.append("}");

		throw new NoSuchProducer_LectureseriesException(msg.toString());
	}

	/**
	 * Returns the last producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer_ lectureseries, or <code>null</code> if a matching producer_ lectureseries could not be found
	 */
	@Override
	public Producer_Lectureseries fetchByLectureseriesIdAndProducerId_Last(
		long lectureseriesId, long producerId,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		int count = countByLectureseriesIdAndProducerId(
			lectureseriesId, producerId);

		if (count == 0) {
			return null;
		}

		List<Producer_Lectureseries> list = findByLectureseriesIdAndProducerId(
			lectureseriesId, producerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the producer_ lectureserieses before and after the current producer_ lectureseries in the ordered set where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param producerLectureseriesId the primary key of the current producer_ lectureseries
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public Producer_Lectureseries[]
			findByLectureseriesIdAndProducerId_PrevAndNext(
				long producerLectureseriesId, long lectureseriesId,
				long producerId,
				OrderByComparator<Producer_Lectureseries> orderByComparator)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries = findByPrimaryKey(
			producerLectureseriesId);

		Session session = null;

		try {
			session = openSession();

			Producer_Lectureseries[] array = new Producer_LectureseriesImpl[3];

			array[0] = getByLectureseriesIdAndProducerId_PrevAndNext(
				session, producer_Lectureseries, lectureseriesId, producerId,
				orderByComparator, true);

			array[1] = producer_Lectureseries;

			array[2] = getByLectureseriesIdAndProducerId_PrevAndNext(
				session, producer_Lectureseries, lectureseriesId, producerId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Producer_Lectureseries
		getByLectureseriesIdAndProducerId_PrevAndNext(
			Session session, Producer_Lectureseries producer_Lectureseries,
			long lectureseriesId, long producerId,
			OrderByComparator<Producer_Lectureseries> orderByComparator,
			boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PRODUCER_LECTURESERIES_WHERE);

		query.append(
			_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_LECTURESERIESID_2);

		query.append(_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_PRODUCERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(lectureseriesId);

		qPos.add(producerId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						producer_Lectureseries)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Producer_Lectureseries> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 */
	@Override
	public void removeByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId) {

		for (Producer_Lectureseries producer_Lectureseries :
				findByLectureseriesIdAndProducerId(
					lectureseriesId, producerId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(producer_Lectureseries);
		}
	}

	/**
	 * Returns the number of producer_ lectureserieses where lectureseriesId = &#63; and producerId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param producerId the producer ID
	 * @return the number of matching producer_ lectureserieses
	 */
	@Override
	public int countByLectureseriesIdAndProducerId(
		long lectureseriesId, long producerId) {

		FinderPath finderPath = _finderPathCountByLectureseriesIdAndProducerId;

		Object[] finderArgs = new Object[] {lectureseriesId, producerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PRODUCER_LECTURESERIES_WHERE);

			query.append(
				_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_LECTURESERIESID_2);

			query.append(
				_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_PRODUCERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(lectureseriesId);

				qPos.add(producerId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_LECTURESERIESID_2 =
			"producer_Lectureseries.lectureseriesId = ? AND ";

	private static final String
		_FINDER_COLUMN_LECTURESERIESIDANDPRODUCERID_PRODUCERID_2 =
			"producer_Lectureseries.producerId = ?";

	public Producer_LectureseriesPersistenceImpl() {
		setModelClass(Producer_Lectureseries.class);

		setModelImplClass(Producer_LectureseriesImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the producer_ lectureseries in the entity cache if it is enabled.
	 *
	 * @param producer_Lectureseries the producer_ lectureseries
	 */
	@Override
	public void cacheResult(Producer_Lectureseries producer_Lectureseries) {
		entityCache.putResult(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			producer_Lectureseries.getPrimaryKey(), producer_Lectureseries);

		producer_Lectureseries.resetOriginalValues();
	}

	/**
	 * Caches the producer_ lectureserieses in the entity cache if it is enabled.
	 *
	 * @param producer_Lectureserieses the producer_ lectureserieses
	 */
	@Override
	public void cacheResult(
		List<Producer_Lectureseries> producer_Lectureserieses) {

		for (Producer_Lectureseries producer_Lectureseries :
				producer_Lectureserieses) {

			if (entityCache.getResult(
					Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
					Producer_LectureseriesImpl.class,
					producer_Lectureseries.getPrimaryKey()) == null) {

				cacheResult(producer_Lectureseries);
			}
			else {
				producer_Lectureseries.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all producer_ lectureserieses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Producer_LectureseriesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the producer_ lectureseries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Producer_Lectureseries producer_Lectureseries) {
		entityCache.removeResult(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			producer_Lectureseries.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<Producer_Lectureseries> producer_Lectureserieses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Producer_Lectureseries producer_Lectureseries :
				producer_Lectureserieses) {

			entityCache.removeResult(
				Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Producer_LectureseriesImpl.class,
				producer_Lectureseries.getPrimaryKey());
		}
	}

	/**
	 * Creates a new producer_ lectureseries with the primary key. Does not add the producer_ lectureseries to the database.
	 *
	 * @param producerLectureseriesId the primary key for the new producer_ lectureseries
	 * @return the new producer_ lectureseries
	 */
	@Override
	public Producer_Lectureseries create(long producerLectureseriesId) {
		Producer_Lectureseries producer_Lectureseries =
			new Producer_LectureseriesImpl();

		producer_Lectureseries.setNew(true);
		producer_Lectureseries.setPrimaryKey(producerLectureseriesId);

		return producer_Lectureseries;
	}

	/**
	 * Removes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries that was removed
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public Producer_Lectureseries remove(long producerLectureseriesId)
		throws NoSuchProducer_LectureseriesException {

		return remove((Serializable)producerLectureseriesId);
	}

	/**
	 * Removes the producer_ lectureseries with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries that was removed
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public Producer_Lectureseries remove(Serializable primaryKey)
		throws NoSuchProducer_LectureseriesException {

		Session session = null;

		try {
			session = openSession();

			Producer_Lectureseries producer_Lectureseries =
				(Producer_Lectureseries)session.get(
					Producer_LectureseriesImpl.class, primaryKey);

			if (producer_Lectureseries == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProducer_LectureseriesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(producer_Lectureseries);
		}
		catch (NoSuchProducer_LectureseriesException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Producer_Lectureseries removeImpl(
		Producer_Lectureseries producer_Lectureseries) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(producer_Lectureseries)) {
				producer_Lectureseries = (Producer_Lectureseries)session.get(
					Producer_LectureseriesImpl.class,
					producer_Lectureseries.getPrimaryKeyObj());
			}

			if (producer_Lectureseries != null) {
				session.delete(producer_Lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (producer_Lectureseries != null) {
			clearCache(producer_Lectureseries);
		}

		return producer_Lectureseries;
	}

	@Override
	public Producer_Lectureseries updateImpl(
		Producer_Lectureseries producer_Lectureseries) {

		boolean isNew = producer_Lectureseries.isNew();

		if (!(producer_Lectureseries instanceof
				Producer_LectureseriesModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(producer_Lectureseries.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					producer_Lectureseries);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in producer_Lectureseries proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Producer_Lectureseries implementation " +
					producer_Lectureseries.getClass());
		}

		Producer_LectureseriesModelImpl producer_LectureseriesModelImpl =
			(Producer_LectureseriesModelImpl)producer_Lectureseries;

		Session session = null;

		try {
			session = openSession();

			if (producer_Lectureseries.isNew()) {
				session.save(producer_Lectureseries);

				producer_Lectureseries.setNew(false);
			}
			else {
				producer_Lectureseries = (Producer_Lectureseries)session.merge(
					producer_Lectureseries);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Producer_LectureseriesModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				producer_LectureseriesModelImpl.getLectureseriesId()
			};

			finderCache.removeResult(_finderPathCountByLectureseriesId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLectureseriesId, args);

			args = new Object[] {
				producer_LectureseriesModelImpl.getProducerId()
			};

			finderCache.removeResult(_finderPathCountByProducerId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProducerId, args);

			args = new Object[] {
				producer_LectureseriesModelImpl.getLectureseriesId(),
				producer_LectureseriesModelImpl.getProducerId()
			};

			finderCache.removeResult(
				_finderPathCountByLectureseriesIdAndProducerId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLectureseriesIdAndProducerId,
				args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((producer_LectureseriesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLectureseriesId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					producer_LectureseriesModelImpl.getOriginalLectureseriesId()
				};

				finderCache.removeResult(
					_finderPathCountByLectureseriesId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseriesId, args);

				args = new Object[] {
					producer_LectureseriesModelImpl.getLectureseriesId()
				};

				finderCache.removeResult(
					_finderPathCountByLectureseriesId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseriesId, args);
			}

			if ((producer_LectureseriesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProducerId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					producer_LectureseriesModelImpl.getOriginalProducerId()
				};

				finderCache.removeResult(_finderPathCountByProducerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProducerId, args);

				args = new Object[] {
					producer_LectureseriesModelImpl.getProducerId()
				};

				finderCache.removeResult(_finderPathCountByProducerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProducerId, args);
			}

			if ((producer_LectureseriesModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLectureseriesIdAndProducerId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					producer_LectureseriesModelImpl.
						getOriginalLectureseriesId(),
					producer_LectureseriesModelImpl.getOriginalProducerId()
				};

				finderCache.removeResult(
					_finderPathCountByLectureseriesIdAndProducerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseriesIdAndProducerId,
					args);

				args = new Object[] {
					producer_LectureseriesModelImpl.getLectureseriesId(),
					producer_LectureseriesModelImpl.getProducerId()
				};

				finderCache.removeResult(
					_finderPathCountByLectureseriesIdAndProducerId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLectureseriesIdAndProducerId,
					args);
			}
		}

		entityCache.putResult(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			producer_Lectureseries.getPrimaryKey(), producer_Lectureseries,
			false);

		producer_Lectureseries.resetOriginalValues();

		return producer_Lectureseries;
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public Producer_Lectureseries findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProducer_LectureseriesException {

		Producer_Lectureseries producer_Lectureseries = fetchByPrimaryKey(
			primaryKey);

		if (producer_Lectureseries == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProducer_LectureseriesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return producer_Lectureseries;
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or throws a <code>NoSuchProducer_LectureseriesException</code> if it could not be found.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries
	 * @throws NoSuchProducer_LectureseriesException if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public Producer_Lectureseries findByPrimaryKey(long producerLectureseriesId)
		throws NoSuchProducer_LectureseriesException {

		return findByPrimaryKey((Serializable)producerLectureseriesId);
	}

	/**
	 * Returns the producer_ lectureseries with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param producerLectureseriesId the primary key of the producer_ lectureseries
	 * @return the producer_ lectureseries, or <code>null</code> if a producer_ lectureseries with the primary key could not be found
	 */
	@Override
	public Producer_Lectureseries fetchByPrimaryKey(
		long producerLectureseriesId) {

		return fetchByPrimaryKey((Serializable)producerLectureseriesId);
	}

	/**
	 * Returns all the producer_ lectureserieses.
	 *
	 * @return the producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @return the range of producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of producer_ lectureserieses
	 */
	@Deprecated
	@Override
	public List<Producer_Lectureseries> findAll(
		int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the producer_ lectureserieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Producer_LectureseriesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of producer_ lectureserieses
	 * @param end the upper bound of the range of producer_ lectureserieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producer_ lectureserieses
	 */
	@Override
	public List<Producer_Lectureseries> findAll(
		int start, int end,
		OrderByComparator<Producer_Lectureseries> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Producer_Lectureseries> list =
			(List<Producer_Lectureseries>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PRODUCER_LECTURESERIES);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCER_LECTURESERIES;

				if (pagination) {
					sql = sql.concat(
						Producer_LectureseriesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Producer_Lectureseries>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Producer_Lectureseries>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the producer_ lectureserieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Producer_Lectureseries producer_Lectureseries : findAll()) {
			remove(producer_Lectureseries);
		}
	}

	/**
	 * Returns the number of producer_ lectureserieses.
	 *
	 * @return the number of producer_ lectureserieses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
					_SQL_COUNT_PRODUCER_LECTURESERIES);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
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
		return "producerLectureseriesId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCER_LECTURESERIES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Producer_LectureseriesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the producer_ lectureseries persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByLectureseriesId = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLectureseriesId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLectureseriesId = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLectureseriesId",
			new String[] {Long.class.getName()},
			Producer_LectureseriesModelImpl.LECTURESERIESID_COLUMN_BITMASK);

		_finderPathCountByLectureseriesId = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLectureseriesId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByProducerId = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProducerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProducerId = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
			Producer_LectureseriesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProducerId",
			new String[] {Long.class.getName()},
			Producer_LectureseriesModelImpl.PRODUCERID_COLUMN_BITMASK);

		_finderPathCountByProducerId = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProducerId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByLectureseriesIdAndProducerId =
			new FinderPath(
				Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
				Producer_LectureseriesImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByLectureseriesIdAndProducerId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithoutPaginationFindByLectureseriesIdAndProducerId =
			new FinderPath(
				Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
				Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED,
				Producer_LectureseriesImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByLectureseriesIdAndProducerId",
				new String[] {Long.class.getName(), Long.class.getName()},
				Producer_LectureseriesModelImpl.LECTURESERIESID_COLUMN_BITMASK |
				Producer_LectureseriesModelImpl.PRODUCERID_COLUMN_BITMASK);

		_finderPathCountByLectureseriesIdAndProducerId = new FinderPath(
			Producer_LectureseriesModelImpl.ENTITY_CACHE_ENABLED,
			Producer_LectureseriesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLectureseriesIdAndProducerId",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(Producer_LectureseriesImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PRODUCER_LECTURESERIES =
		"SELECT producer_Lectureseries FROM Producer_Lectureseries producer_Lectureseries";

	private static final String _SQL_SELECT_PRODUCER_LECTURESERIES_WHERE =
		"SELECT producer_Lectureseries FROM Producer_Lectureseries producer_Lectureseries WHERE ";

	private static final String _SQL_COUNT_PRODUCER_LECTURESERIES =
		"SELECT COUNT(producer_Lectureseries) FROM Producer_Lectureseries producer_Lectureseries";

	private static final String _SQL_COUNT_PRODUCER_LECTURESERIES_WHERE =
		"SELECT COUNT(producer_Lectureseries) FROM Producer_Lectureseries producer_Lectureseries WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"producer_Lectureseries.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Producer_Lectureseries exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Producer_Lectureseries exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Producer_LectureseriesPersistenceImpl.class);

}