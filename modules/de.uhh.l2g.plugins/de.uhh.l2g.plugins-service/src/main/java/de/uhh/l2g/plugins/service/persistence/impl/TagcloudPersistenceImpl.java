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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchTagcloudException;
import de.uhh.l2g.plugins.model.Tagcloud;
import de.uhh.l2g.plugins.model.impl.TagcloudImpl;
import de.uhh.l2g.plugins.model.impl.TagcloudModelImpl;
import de.uhh.l2g.plugins.service.persistence.TagcloudPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence implementation for the tagcloud service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class TagcloudPersistenceImpl
	extends BasePersistenceImpl<Tagcloud> implements TagcloudPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TagcloudUtil</code> to access the tagcloud persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TagcloudImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByObjectClassType;
	private FinderPath _finderPathWithoutPaginationFindByObjectClassType;
	private FinderPath _finderPathCountByObjectClassType;

	/**
	 * Returns all the tagclouds where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @return the matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(String objectClassType) {
		return findByObjectClassType(
			objectClassType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(
		String objectClassType, int start, int end) {

		return findByObjectClassType(objectClassType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByObjectClassType(String, int, int, OrderByComparator)}
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	@Override
	public List<Tagcloud> findByObjectClassType(
		String objectClassType, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return findByObjectClassType(
			objectClassType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectClassType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectClassType the object class type
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectClassType(
		String objectClassType, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		objectClassType = Objects.toString(objectClassType, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByObjectClassType;
			finderArgs = new Object[] {objectClassType};
		}
		else {
			finderPath = _finderPathWithPaginationFindByObjectClassType;
			finderArgs = new Object[] {
				objectClassType, start, end, orderByComparator
			};
		}

		List<Tagcloud> list = (List<Tagcloud>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if (!objectClassType.equals(tagcloud.getObjectClassType())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType.isEmpty()) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(
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
	 * Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectClassType_First(
			String objectClassType,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByObjectClassType_First(
			objectClassType, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectClassType=");
		msg.append(objectClassType);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectClassType_First(
		String objectClassType, OrderByComparator<Tagcloud> orderByComparator) {

		List<Tagcloud> list = findByObjectClassType(
			objectClassType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectClassType_Last(
			String objectClassType,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByObjectClassType_Last(
			objectClassType, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectClassType=");
		msg.append(objectClassType);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectClassType_Last(
		String objectClassType, OrderByComparator<Tagcloud> orderByComparator) {

		int count = countByObjectClassType(objectClassType);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByObjectClassType(
			objectClassType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where objectClassType = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param objectClassType the object class type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud[] findByObjectClassType_PrevAndNext(
			long tagcloudId, String objectClassType,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		objectClassType = Objects.toString(objectClassType, "");

		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByObjectClassType_PrevAndNext(
				session, tagcloud, objectClassType, orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByObjectClassType_PrevAndNext(
				session, tagcloud, objectClassType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tagcloud getByObjectClassType_PrevAndNext(
		Session session, Tagcloud tagcloud, String objectClassType,
		OrderByComparator<Tagcloud> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		boolean bindObjectClassType = false;

		if (objectClassType.isEmpty()) {
			query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
		}
		else {
			bindObjectClassType = true;

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
		}

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindObjectClassType) {
			qPos.add(objectClassType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tagcloud)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where objectClassType = &#63; from the database.
	 *
	 * @param objectClassType the object class type
	 */
	@Override
	public void removeByObjectClassType(String objectClassType) {
		for (Tagcloud tagcloud :
				findByObjectClassType(
					objectClassType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where objectClassType = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByObjectClassType(String objectClassType) {
		objectClassType = Objects.toString(objectClassType, "");

		FinderPath finderPath = _finderPathCountByObjectClassType;

		Object[] finderArgs = new Object[] {objectClassType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType.isEmpty()) {
				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

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
		_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_2 =
			"tagcloud.objectClassType = ?";

	private static final String
		_FINDER_COLUMN_OBJECTCLASSTYPE_OBJECTCLASSTYPE_3 =
			"(tagcloud.objectClassType IS NULL OR tagcloud.objectClassType = '')";

	private FinderPath _finderPathWithPaginationFindByObjectId;
	private FinderPath _finderPathWithoutPaginationFindByObjectId;
	private FinderPath _finderPathCountByObjectId;

	/**
	 * Returns all the tagclouds where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @return the matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId) {
		return findByObjectId(
			objectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectId(long objectId, int start, int end) {
		return findByObjectId(objectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByObjectId(long, int, int, OrderByComparator)}
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	@Override
	public List<Tagcloud> findByObjectId(
		long objectId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return findByObjectId(objectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tagclouds where objectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param objectId the object ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByObjectId(
		long objectId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByObjectId;
			finderArgs = new Object[] {objectId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByObjectId;
			finderArgs = new Object[] {objectId, start, end, orderByComparator};
		}

		List<Tagcloud> list = (List<Tagcloud>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if ((objectId != tagcloud.getObjectId())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objectId);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(
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
	 * Returns the first tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectId_First(
			long objectId, OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByObjectId_First(objectId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectId=");
		msg.append(objectId);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectId_First(
		long objectId, OrderByComparator<Tagcloud> orderByComparator) {

		List<Tagcloud> list = findByObjectId(objectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectId_Last(
			long objectId, OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByObjectId_Last(objectId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectId=");
		msg.append(objectId);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectId_Last(
		long objectId, OrderByComparator<Tagcloud> orderByComparator) {

		int count = countByObjectId(objectId);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByObjectId(
			objectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where objectId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param objectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud[] findByObjectId_PrevAndNext(
			long tagcloudId, long objectId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByObjectId_PrevAndNext(
				session, tagcloud, objectId, orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByObjectId_PrevAndNext(
				session, tagcloud, objectId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tagcloud getByObjectId_PrevAndNext(
		Session session, Tagcloud tagcloud, long objectId,
		OrderByComparator<Tagcloud> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(objectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tagcloud)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where objectId = &#63; from the database.
	 *
	 * @param objectId the object ID
	 */
	@Override
	public void removeByObjectId(long objectId) {
		for (Tagcloud tagcloud :
				findByObjectId(
					objectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where objectId = &#63;.
	 *
	 * @param objectId the object ID
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByObjectId(long objectId) {
		FinderPath finderPath = _finderPathCountByObjectId;

		Object[] finderArgs = new Object[] {objectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_OBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(objectId);

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

	private static final String _FINDER_COLUMN_OBJECTID_OBJECTID_2 =
		"tagcloud.objectId = ?";

	private FinderPath _finderPathFetchByObjectClassTypeAndObjectId;
	private FinderPath _finderPathCountByObjectClassTypeAndObjectId;

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or throws a <code>NoSuchTagcloudException</code> if it could not be found.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByObjectClassTypeAndObjectId(
			String objectClassType, long objectId)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByObjectClassTypeAndObjectId(
			objectClassType, objectId);

		if (tagcloud == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("objectClassType=");
			msg.append(objectClassType);

			msg.append(", objectId=");
			msg.append(objectId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTagcloudException(msg.toString());
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByObjectClassTypeAndObjectId(String,long)}
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Deprecated
	@Override
	public Tagcloud fetchByObjectClassTypeAndObjectId(
		String objectClassType, long objectId, boolean useFinderCache) {

		return fetchByObjectClassTypeAndObjectId(objectClassType, objectId);
	}

	/**
	 * Returns the tagcloud where objectClassType = &#63; and objectId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByObjectClassTypeAndObjectId(
		String objectClassType, long objectId) {

		objectClassType = Objects.toString(objectClassType, "");

		Object[] finderArgs = new Object[] {objectClassType, objectId};

		Object result = finderCache.getResult(
			_finderPathFetchByObjectClassTypeAndObjectId, finderArgs, this);

		if (result instanceof Tagcloud) {
			Tagcloud tagcloud = (Tagcloud)result;

			if (!Objects.equals(
					objectClassType, tagcloud.getObjectClassType()) ||
				(objectId != tagcloud.getObjectId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType.isEmpty()) {
				query.append(
					_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(
					_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2);
			}

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				qPos.add(objectId);

				List<Tagcloud> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByObjectClassTypeAndObjectId,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TagcloudPersistenceImpl.fetchByObjectClassTypeAndObjectId(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Tagcloud tagcloud = list.get(0);

					result = tagcloud;

					cacheResult(tagcloud);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByObjectClassTypeAndObjectId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Tagcloud)result;
		}
	}

	/**
	 * Removes the tagcloud where objectClassType = &#63; and objectId = &#63; from the database.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the tagcloud that was removed
	 */
	@Override
	public Tagcloud removeByObjectClassTypeAndObjectId(
			String objectClassType, long objectId)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = findByObjectClassTypeAndObjectId(
			objectClassType, objectId);

		return remove(tagcloud);
	}

	/**
	 * Returns the number of tagclouds where objectClassType = &#63; and objectId = &#63;.
	 *
	 * @param objectClassType the object class type
	 * @param objectId the object ID
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByObjectClassTypeAndObjectId(
		String objectClassType, long objectId) {

		objectClassType = Objects.toString(objectClassType, "");

		FinderPath finderPath = _finderPathCountByObjectClassTypeAndObjectId;

		Object[] finderArgs = new Object[] {objectClassType, objectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			boolean bindObjectClassType = false;

			if (objectClassType.isEmpty()) {
				query.append(
					_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3);
			}
			else {
				bindObjectClassType = true;

				query.append(
					_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2);
			}

			query.append(_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectClassType) {
					qPos.add(objectClassType);
				}

				qPos.add(objectId);

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
		_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_2 =
			"tagcloud.objectClassType = ? AND ";

	private static final String
		_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTCLASSTYPE_3 =
			"(tagcloud.objectClassType IS NULL OR tagcloud.objectClassType = '') AND ";

	private static final String
		_FINDER_COLUMN_OBJECTCLASSTYPEANDOBJECTID_OBJECTID_2 =
			"tagcloud.objectId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the tagclouds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	@Override
	public List<Tagcloud> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return findByGroup(groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tagclouds where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroup;
			finderArgs = new Object[] {groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroup;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Tagcloud> list = (List<Tagcloud>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if ((groupId != tagcloud.getGroupId())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(
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
	 * Returns the first tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByGroup_First(
			long groupId, OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByGroup_First(groupId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByGroup_First(
		long groupId, OrderByComparator<Tagcloud> orderByComparator) {

		List<Tagcloud> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByGroup_Last(
			long groupId, OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByGroup_Last(groupId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByGroup_Last(
		long groupId, OrderByComparator<Tagcloud> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where groupId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud[] findByGroup_PrevAndNext(
			long tagcloudId, long groupId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, tagcloud, groupId, orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByGroup_PrevAndNext(
				session, tagcloud, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tagcloud getByGroup_PrevAndNext(
		Session session, Tagcloud tagcloud, long groupId,
		OrderByComparator<Tagcloud> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tagcloud)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Tagcloud tagcloud :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 =
		"tagcloud.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the tagclouds where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	@Override
	public List<Tagcloud> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return findByCompany(companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tagclouds where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCompany;
			finderArgs = new Object[] {companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCompany;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<Tagcloud> list = (List<Tagcloud>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if ((companyId != tagcloud.getCompanyId())) {
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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(
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
	 * Returns the first tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByCompany_First(
			long companyId, OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByCompany_First(companyId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByCompany_First(
		long companyId, OrderByComparator<Tagcloud> orderByComparator) {

		List<Tagcloud> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByCompany_Last(
			long companyId, OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByCompany_Last(companyId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByCompany_Last(
		long companyId, OrderByComparator<Tagcloud> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where companyId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud[] findByCompany_PrevAndNext(
			long tagcloudId, long companyId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, tagcloud, companyId, orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByCompany_PrevAndNext(
				session, tagcloud, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Tagcloud getByCompany_PrevAndNext(
		Session session, Tagcloud tagcloud, long companyId,
		OrderByComparator<Tagcloud> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tagcloud)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Tagcloud tagcloud :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 =
		"tagcloud.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByGroupAndCompany(long groupId, long companyId) {
		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tagclouds
	 */
	@Deprecated
	@Override
	public List<Tagcloud> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator, boolean useFinderCache) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tagclouds
	 */
	@Override
	public List<Tagcloud> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Tagcloud> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByGroupAndCompany;
			finderArgs = new Object[] {groupId, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByGroupAndCompany;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<Tagcloud> list = (List<Tagcloud>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Tagcloud tagcloud : list) {
				if ((groupId != tagcloud.getGroupId()) ||
					(companyId != tagcloud.getCompanyId())) {

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

			query.append(_SQL_SELECT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TagcloudModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(
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
	 * Returns the first tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the first tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Tagcloud> orderByComparator) {

		List<Tagcloud> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud
	 * @throws NoSuchTagcloudException if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (tagcloud != null) {
			return tagcloud;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchTagcloudException(msg.toString());
	}

	/**
	 * Returns the last tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tagcloud, or <code>null</code> if a matching tagcloud could not be found
	 */
	@Override
	public Tagcloud fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Tagcloud> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Tagcloud> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tagclouds before and after the current tagcloud in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param tagcloudId the primary key of the current tagcloud
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud[] findByGroupAndCompany_PrevAndNext(
			long tagcloudId, long groupId, long companyId,
			OrderByComparator<Tagcloud> orderByComparator)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = findByPrimaryKey(tagcloudId);

		Session session = null;

		try {
			session = openSession();

			Tagcloud[] array = new TagcloudImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, tagcloud, groupId, companyId, orderByComparator, true);

			array[1] = tagcloud;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, tagcloud, groupId, companyId, orderByComparator,
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

	protected Tagcloud getByGroupAndCompany_PrevAndNext(
		Session session, Tagcloud tagcloud, long groupId, long companyId,
		OrderByComparator<Tagcloud> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TAGCLOUD_WHERE);

		query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

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
			query.append(TagcloudModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tagcloud)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Tagcloud> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tagclouds where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Tagcloud tagcloud :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching tagclouds
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TAGCLOUD_WHERE);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2 =
		"tagcloud.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"tagcloud.companyId = ?";

	public TagcloudPersistenceImpl() {
		setModelClass(Tagcloud.class);

		setModelImplClass(TagcloudImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(TagcloudModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the tagcloud in the entity cache if it is enabled.
	 *
	 * @param tagcloud the tagcloud
	 */
	@Override
	public void cacheResult(Tagcloud tagcloud) {
		entityCache.putResult(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED, TagcloudImpl.class,
			tagcloud.getPrimaryKey(), tagcloud);

		finderCache.putResult(
			_finderPathFetchByObjectClassTypeAndObjectId,
			new Object[] {
				tagcloud.getObjectClassType(), tagcloud.getObjectId()
			},
			tagcloud);

		tagcloud.resetOriginalValues();
	}

	/**
	 * Caches the tagclouds in the entity cache if it is enabled.
	 *
	 * @param tagclouds the tagclouds
	 */
	@Override
	public void cacheResult(List<Tagcloud> tagclouds) {
		for (Tagcloud tagcloud : tagclouds) {
			if (entityCache.getResult(
					TagcloudModelImpl.ENTITY_CACHE_ENABLED, TagcloudImpl.class,
					tagcloud.getPrimaryKey()) == null) {

				cacheResult(tagcloud);
			}
			else {
				tagcloud.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tagclouds.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TagcloudImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tagcloud.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Tagcloud tagcloud) {
		entityCache.removeResult(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED, TagcloudImpl.class,
			tagcloud.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TagcloudModelImpl)tagcloud, true);
	}

	@Override
	public void clearCache(List<Tagcloud> tagclouds) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Tagcloud tagcloud : tagclouds) {
			entityCache.removeResult(
				TagcloudModelImpl.ENTITY_CACHE_ENABLED, TagcloudImpl.class,
				tagcloud.getPrimaryKey());

			clearUniqueFindersCache((TagcloudModelImpl)tagcloud, true);
		}
	}

	protected void cacheUniqueFindersCache(
		TagcloudModelImpl tagcloudModelImpl) {

		Object[] args = new Object[] {
			tagcloudModelImpl.getObjectClassType(),
			tagcloudModelImpl.getObjectId()
		};

		finderCache.putResult(
			_finderPathCountByObjectClassTypeAndObjectId, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByObjectClassTypeAndObjectId, args,
			tagcloudModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TagcloudModelImpl tagcloudModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				tagcloudModelImpl.getObjectClassType(),
				tagcloudModelImpl.getObjectId()
			};

			finderCache.removeResult(
				_finderPathCountByObjectClassTypeAndObjectId, args);
			finderCache.removeResult(
				_finderPathFetchByObjectClassTypeAndObjectId, args);
		}

		if ((tagcloudModelImpl.getColumnBitmask() &
			 _finderPathFetchByObjectClassTypeAndObjectId.getColumnBitmask()) !=
				 0) {

			Object[] args = new Object[] {
				tagcloudModelImpl.getOriginalObjectClassType(),
				tagcloudModelImpl.getOriginalObjectId()
			};

			finderCache.removeResult(
				_finderPathCountByObjectClassTypeAndObjectId, args);
			finderCache.removeResult(
				_finderPathFetchByObjectClassTypeAndObjectId, args);
		}
	}

	/**
	 * Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	 *
	 * @param tagcloudId the primary key for the new tagcloud
	 * @return the new tagcloud
	 */
	@Override
	public Tagcloud create(long tagcloudId) {
		Tagcloud tagcloud = new TagcloudImpl();

		tagcloud.setNew(true);
		tagcloud.setPrimaryKey(tagcloudId);

		tagcloud.setCompanyId(CompanyThreadLocal.getCompanyId());

		return tagcloud;
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud remove(long tagcloudId) throws NoSuchTagcloudException {
		return remove((Serializable)tagcloudId);
	}

	/**
	 * Removes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud that was removed
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud remove(Serializable primaryKey)
		throws NoSuchTagcloudException {

		Session session = null;

		try {
			session = openSession();

			Tagcloud tagcloud = (Tagcloud)session.get(
				TagcloudImpl.class, primaryKey);

			if (tagcloud == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTagcloudException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tagcloud);
		}
		catch (NoSuchTagcloudException nsee) {
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
	protected Tagcloud removeImpl(Tagcloud tagcloud) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tagcloud)) {
				tagcloud = (Tagcloud)session.get(
					TagcloudImpl.class, tagcloud.getPrimaryKeyObj());
			}

			if (tagcloud != null) {
				session.delete(tagcloud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (tagcloud != null) {
			clearCache(tagcloud);
		}

		return tagcloud;
	}

	@Override
	public Tagcloud updateImpl(Tagcloud tagcloud) {
		boolean isNew = tagcloud.isNew();

		if (!(tagcloud instanceof TagcloudModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tagcloud.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tagcloud);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tagcloud proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Tagcloud implementation " +
					tagcloud.getClass());
		}

		TagcloudModelImpl tagcloudModelImpl = (TagcloudModelImpl)tagcloud;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (tagcloud.getCreateDate() == null)) {
			if (serviceContext == null) {
				tagcloud.setCreateDate(now);
			}
			else {
				tagcloud.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!tagcloudModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				tagcloud.setModifiedDate(now);
			}
			else {
				tagcloud.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (tagcloud.isNew()) {
				session.save(tagcloud);

				tagcloud.setNew(false);
			}
			else {
				tagcloud = (Tagcloud)session.merge(tagcloud);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TagcloudModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				tagcloudModelImpl.getObjectClassType()
			};

			finderCache.removeResult(_finderPathCountByObjectClassType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByObjectClassType, args);

			args = new Object[] {tagcloudModelImpl.getObjectId()};

			finderCache.removeResult(_finderPathCountByObjectId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByObjectId, args);

			args = new Object[] {tagcloudModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {tagcloudModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				tagcloudModelImpl.getGroupId(), tagcloudModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((tagcloudModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByObjectClassType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					tagcloudModelImpl.getOriginalObjectClassType()
				};

				finderCache.removeResult(
					_finderPathCountByObjectClassType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByObjectClassType, args);

				args = new Object[] {tagcloudModelImpl.getObjectClassType()};

				finderCache.removeResult(
					_finderPathCountByObjectClassType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByObjectClassType, args);
			}

			if ((tagcloudModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByObjectId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					tagcloudModelImpl.getOriginalObjectId()
				};

				finderCache.removeResult(_finderPathCountByObjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByObjectId, args);

				args = new Object[] {tagcloudModelImpl.getObjectId()};

				finderCache.removeResult(_finderPathCountByObjectId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByObjectId, args);
			}

			if ((tagcloudModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					tagcloudModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {tagcloudModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((tagcloudModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					tagcloudModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {tagcloudModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((tagcloudModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					tagcloudModelImpl.getOriginalGroupId(),
					tagcloudModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					tagcloudModelImpl.getGroupId(),
					tagcloudModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED, TagcloudImpl.class,
			tagcloud.getPrimaryKey(), tagcloud, false);

		clearUniqueFindersCache(tagcloudModelImpl, false);
		cacheUniqueFindersCache(tagcloudModelImpl);

		tagcloud.resetOriginalValues();

		return tagcloud;
	}

	/**
	 * Returns the tagcloud with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTagcloudException {

		Tagcloud tagcloud = fetchByPrimaryKey(primaryKey);

		if (tagcloud == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTagcloudException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tagcloud;
	}

	/**
	 * Returns the tagcloud with the primary key or throws a <code>NoSuchTagcloudException</code> if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud
	 * @throws NoSuchTagcloudException if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud findByPrimaryKey(long tagcloudId)
		throws NoSuchTagcloudException {

		return findByPrimaryKey((Serializable)tagcloudId);
	}

	/**
	 * Returns the tagcloud with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tagcloudId the primary key of the tagcloud
	 * @return the tagcloud, or <code>null</code> if a tagcloud with the primary key could not be found
	 */
	@Override
	public Tagcloud fetchByPrimaryKey(long tagcloudId) {
		return fetchByPrimaryKey((Serializable)tagcloudId);
	}

	/**
	 * Returns all the tagclouds.
	 *
	 * @return the tagclouds
	 */
	@Override
	public List<Tagcloud> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @return the range of tagclouds
	 */
	@Override
	public List<Tagcloud> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tagclouds
	 */
	@Deprecated
	@Override
	public List<Tagcloud> findAll(
		int start, int end, OrderByComparator<Tagcloud> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the tagclouds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TagcloudModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of tagclouds
	 * @param end the upper bound of the range of tagclouds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tagclouds
	 */
	@Override
	public List<Tagcloud> findAll(
		int start, int end, OrderByComparator<Tagcloud> orderByComparator) {

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

		List<Tagcloud> list = (List<Tagcloud>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TAGCLOUD);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAGCLOUD;

				if (pagination) {
					sql = sql.concat(TagcloudModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Tagcloud>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Tagcloud>)QueryUtil.list(
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
	 * Removes all the tagclouds from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Tagcloud tagcloud : findAll()) {
			remove(tagcloud);
		}
	}

	/**
	 * Returns the number of tagclouds.
	 *
	 * @return the number of tagclouds
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TAGCLOUD);

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
		return "tagcloudId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TAGCLOUD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TagcloudModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tagcloud persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByObjectClassType = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObjectClassType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByObjectClassType = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObjectClassType",
			new String[] {String.class.getName()},
			TagcloudModelImpl.OBJECTCLASSTYPE_COLUMN_BITMASK);

		_finderPathCountByObjectClassType = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByObjectClassType",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByObjectId = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByObjectId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByObjectId = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByObjectId",
			new String[] {Long.class.getName()},
			TagcloudModelImpl.OBJECTID_COLUMN_BITMASK);

		_finderPathCountByObjectId = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByObjectId",
			new String[] {Long.class.getName()});

		_finderPathFetchByObjectClassTypeAndObjectId = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByObjectClassTypeAndObjectId",
			new String[] {String.class.getName(), Long.class.getName()},
			TagcloudModelImpl.OBJECTCLASSTYPE_COLUMN_BITMASK |
			TagcloudModelImpl.OBJECTID_COLUMN_BITMASK);

		_finderPathCountByObjectClassTypeAndObjectId = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByObjectClassTypeAndObjectId",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			TagcloudModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			TagcloudModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, TagcloudImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			TagcloudModelImpl.GROUPID_COLUMN_BITMASK |
			TagcloudModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			TagcloudModelImpl.ENTITY_CACHE_ENABLED,
			TagcloudModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(TagcloudImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TAGCLOUD =
		"SELECT tagcloud FROM Tagcloud tagcloud";

	private static final String _SQL_SELECT_TAGCLOUD_WHERE =
		"SELECT tagcloud FROM Tagcloud tagcloud WHERE ";

	private static final String _SQL_COUNT_TAGCLOUD =
		"SELECT COUNT(tagcloud) FROM Tagcloud tagcloud";

	private static final String _SQL_COUNT_TAGCLOUD_WHERE =
		"SELECT COUNT(tagcloud) FROM Tagcloud tagcloud WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tagcloud.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Tagcloud exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Tagcloud exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TagcloudPersistenceImpl.class);

}