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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchMetadataException;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.MetadataModelImpl;
import de.uhh.l2g.plugins.service.persistence.MetadataPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the metadata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class MetadataPersistenceImpl
	extends BasePersistenceImpl<Metadata> implements MetadataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MetadataUtil</code> to access the metadata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MetadataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the metadatas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching metadatas
	 */
	@Override
	public List<Metadata> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	@Override
	public List<Metadata> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	@Override
	public List<Metadata> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Metadata> orderByComparator) {

		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	@Override
	public List<Metadata> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Metadata> list = null;

		if (useFinderCache) {
			list = (List<Metadata>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Metadata metadata : list) {
					if (groupId != metadata.getGroupId()) {
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

			sb.append(_SQL_SELECT_METADATA_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MetadataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Metadata>)QueryUtil.list(
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
	 * Returns the first metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	@Override
	public Metadata findByGroup_First(
			long groupId, OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = fetchByGroup_First(groupId, orderByComparator);

		if (metadata != null) {
			return metadata;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchMetadataException(sb.toString());
	}

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	@Override
	public Metadata fetchByGroup_First(
		long groupId, OrderByComparator<Metadata> orderByComparator) {

		List<Metadata> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	@Override
	public Metadata findByGroup_Last(
			long groupId, OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = fetchByGroup_Last(groupId, orderByComparator);

		if (metadata != null) {
			return metadata;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchMetadataException(sb.toString());
	}

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	@Override
	public Metadata fetchByGroup_Last(
		long groupId, OrderByComparator<Metadata> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Metadata> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where groupId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata[] findByGroup_PrevAndNext(
			long metadataId, long groupId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = findByPrimaryKey(metadataId);

		Session session = null;

		try {
			session = openSession();

			Metadata[] array = new MetadataImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, metadata, groupId, orderByComparator, true);

			array[1] = metadata;

			array[2] = getByGroup_PrevAndNext(
				session, metadata, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Metadata getByGroup_PrevAndNext(
		Session session, Metadata metadata, long groupId,
		OrderByComparator<Metadata> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_METADATA_WHERE);

		sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

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
			sb.append(MetadataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(metadata)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Metadata> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the metadatas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Metadata metadata :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(metadata);
		}
	}

	/**
	 * Returns the number of metadatas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching metadatas
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_METADATA_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPID_2 =
		"metadata.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the metadatas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching metadatas
	 */
	@Override
	public List<Metadata> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	@Override
	public List<Metadata> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	@Override
	public List<Metadata> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator) {

		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	@Override
	public List<Metadata> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCompany;
				finderArgs = new Object[] {companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCompany;
			finderArgs = new Object[] {
				companyId, start, end, orderByComparator
			};
		}

		List<Metadata> list = null;

		if (useFinderCache) {
			list = (List<Metadata>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Metadata metadata : list) {
					if (companyId != metadata.getCompanyId()) {
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

			sb.append(_SQL_SELECT_METADATA_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MetadataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<Metadata>)QueryUtil.list(
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
	 * Returns the first metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	@Override
	public Metadata findByCompany_First(
			long companyId, OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = fetchByCompany_First(companyId, orderByComparator);

		if (metadata != null) {
			return metadata;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMetadataException(sb.toString());
	}

	/**
	 * Returns the first metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	@Override
	public Metadata fetchByCompany_First(
		long companyId, OrderByComparator<Metadata> orderByComparator) {

		List<Metadata> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	@Override
	public Metadata findByCompany_Last(
			long companyId, OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = fetchByCompany_Last(companyId, orderByComparator);

		if (metadata != null) {
			return metadata;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMetadataException(sb.toString());
	}

	/**
	 * Returns the last metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	@Override
	public Metadata fetchByCompany_Last(
		long companyId, OrderByComparator<Metadata> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Metadata> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where companyId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata[] findByCompany_PrevAndNext(
			long metadataId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = findByPrimaryKey(metadataId);

		Session session = null;

		try {
			session = openSession();

			Metadata[] array = new MetadataImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, metadata, companyId, orderByComparator, true);

			array[1] = metadata;

			array[2] = getByCompany_PrevAndNext(
				session, metadata, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Metadata getByCompany_PrevAndNext(
		Session session, Metadata metadata, long companyId,
		OrderByComparator<Metadata> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_METADATA_WHERE);

		sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

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
			sb.append(MetadataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(metadata)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Metadata> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the metadatas where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Metadata metadata :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(metadata);
		}
	}

	/**
	 * Returns the number of metadatas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching metadatas
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_METADATA_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANY_COMPANYID_2 =
		"metadata.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching metadatas
	 */
	@Override
	public List<Metadata> findByGroupAndCompany(long groupId, long companyId) {
		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	@Override
	public List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	@Override
	public List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	@Override
	public List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupAndCompany;
				finderArgs = new Object[] {groupId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupAndCompany;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<Metadata> list = null;

		if (useFinderCache) {
			list = (List<Metadata>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Metadata metadata : list) {
					if ((groupId != metadata.getGroupId()) ||
						(companyId != metadata.getCompanyId())) {

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

			sb.append(_SQL_SELECT_METADATA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MetadataModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<Metadata>)QueryUtil.list(
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
	 * Returns the first metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	@Override
	public Metadata findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (metadata != null) {
			return metadata;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMetadataException(sb.toString());
	}

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	@Override
	public Metadata fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Metadata> orderByComparator) {

		List<Metadata> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	@Override
	public Metadata findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (metadata != null) {
			return metadata;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMetadataException(sb.toString());
	}

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	@Override
	public Metadata fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Metadata> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Metadata> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata[] findByGroupAndCompany_PrevAndNext(
			long metadataId, long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException {

		Metadata metadata = findByPrimaryKey(metadataId);

		Session session = null;

		try {
			session = openSession();

			Metadata[] array = new MetadataImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, metadata, groupId, companyId, orderByComparator, true);

			array[1] = metadata;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, metadata, groupId, companyId, orderByComparator,
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

	protected Metadata getByGroupAndCompany_PrevAndNext(
		Session session, Metadata metadata, long groupId, long companyId,
		OrderByComparator<Metadata> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_METADATA_WHERE);

		sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

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
			sb.append(MetadataModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(metadata)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Metadata> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the metadatas where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Metadata metadata :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(metadata);
		}
	}

	/**
	 * Returns the number of metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching metadatas
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_METADATA_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2 =
		"metadata.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"metadata.companyId = ?";

	public MetadataPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Metadata.class);

		setModelImplClass(MetadataImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(MetadataModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the metadata in the entity cache if it is enabled.
	 *
	 * @param metadata the metadata
	 */
	@Override
	public void cacheResult(Metadata metadata) {
		entityCache.putResult(
			MetadataModelImpl.ENTITY_CACHE_ENABLED, MetadataImpl.class,
			metadata.getPrimaryKey(), metadata);

		metadata.resetOriginalValues();
	}

	/**
	 * Caches the metadatas in the entity cache if it is enabled.
	 *
	 * @param metadatas the metadatas
	 */
	@Override
	public void cacheResult(List<Metadata> metadatas) {
		for (Metadata metadata : metadatas) {
			if (entityCache.getResult(
					MetadataModelImpl.ENTITY_CACHE_ENABLED, MetadataImpl.class,
					metadata.getPrimaryKey()) == null) {

				cacheResult(metadata);
			}
			else {
				metadata.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all metadatas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MetadataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the metadata.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Metadata metadata) {
		entityCache.removeResult(
			MetadataModelImpl.ENTITY_CACHE_ENABLED, MetadataImpl.class,
			metadata.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Metadata> metadatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Metadata metadata : metadatas) {
			entityCache.removeResult(
				MetadataModelImpl.ENTITY_CACHE_ENABLED, MetadataImpl.class,
				metadata.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				MetadataModelImpl.ENTITY_CACHE_ENABLED, MetadataImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new metadata with the primary key. Does not add the metadata to the database.
	 *
	 * @param metadataId the primary key for the new metadata
	 * @return the new metadata
	 */
	@Override
	public Metadata create(long metadataId) {
		Metadata metadata = new MetadataImpl();

		metadata.setNew(true);
		metadata.setPrimaryKey(metadataId);

		metadata.setCompanyId(CompanyThreadLocal.getCompanyId());

		return metadata;
	}

	/**
	 * Removes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata remove(long metadataId) throws NoSuchMetadataException {
		return remove((Serializable)metadataId);
	}

	/**
	 * Removes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata remove(Serializable primaryKey)
		throws NoSuchMetadataException {

		Session session = null;

		try {
			session = openSession();

			Metadata metadata = (Metadata)session.get(
				MetadataImpl.class, primaryKey);

			if (metadata == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetadataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(metadata);
		}
		catch (NoSuchMetadataException noSuchEntityException) {
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
	protected Metadata removeImpl(Metadata metadata) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metadata)) {
				metadata = (Metadata)session.get(
					MetadataImpl.class, metadata.getPrimaryKeyObj());
			}

			if (metadata != null) {
				session.delete(metadata);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (metadata != null) {
			clearCache(metadata);
		}

		return metadata;
	}

	@Override
	public Metadata updateImpl(Metadata metadata) {
		boolean isNew = metadata.isNew();

		if (!(metadata instanceof MetadataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(metadata.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(metadata);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in metadata proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Metadata implementation " +
					metadata.getClass());
		}

		MetadataModelImpl metadataModelImpl = (MetadataModelImpl)metadata;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (metadata.getCreateDate() == null)) {
			if (serviceContext == null) {
				metadata.setCreateDate(now);
			}
			else {
				metadata.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!metadataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				metadata.setModifiedDate(now);
			}
			else {
				metadata.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (metadata.isNew()) {
				session.save(metadata);

				metadata.setNew(false);
			}
			else {
				metadata = (Metadata)session.merge(metadata);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!MetadataModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {metadataModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {metadataModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				metadataModelImpl.getGroupId(), metadataModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((metadataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					metadataModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {metadataModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((metadataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					metadataModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {metadataModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((metadataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					metadataModelImpl.getOriginalGroupId(),
					metadataModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					metadataModelImpl.getGroupId(),
					metadataModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			MetadataModelImpl.ENTITY_CACHE_ENABLED, MetadataImpl.class,
			metadata.getPrimaryKey(), metadata, false);

		metadata.resetOriginalValues();

		return metadata;
	}

	/**
	 * Returns the metadata with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata
	 * @return the metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetadataException {

		Metadata metadata = fetchByPrimaryKey(primaryKey);

		if (metadata == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetadataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return metadata;
	}

	/**
	 * Returns the metadata with the primary key or throws a <code>NoSuchMetadataException</code> if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata findByPrimaryKey(long metadataId)
		throws NoSuchMetadataException {

		return findByPrimaryKey((Serializable)metadataId);
	}

	/**
	 * Returns the metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata, or <code>null</code> if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata fetchByPrimaryKey(long metadataId) {
		return fetchByPrimaryKey((Serializable)metadataId);
	}

	/**
	 * Returns all the metadatas.
	 *
	 * @return the metadatas
	 */
	@Override
	public List<Metadata> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of metadatas
	 */
	@Override
	public List<Metadata> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadatas
	 */
	@Override
	public List<Metadata> findAll(
		int start, int end, OrderByComparator<Metadata> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of metadatas
	 */
	@Override
	public List<Metadata> findAll(
		int start, int end, OrderByComparator<Metadata> orderByComparator,
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

		List<Metadata> list = null;

		if (useFinderCache) {
			list = (List<Metadata>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_METADATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_METADATA;

				sql = sql.concat(MetadataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Metadata>)QueryUtil.list(
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
	 * Removes all the metadatas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Metadata metadata : findAll()) {
			remove(metadata);
		}
	}

	/**
	 * Returns the number of metadatas.
	 *
	 * @return the number of metadatas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_METADATA);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "metadataId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_METADATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MetadataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the metadata persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroup = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			MetadataModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			MetadataModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			MetadataModelImpl.GROUPID_COLUMN_BITMASK |
			MetadataModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(MetadataImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_METADATA =
		"SELECT metadata FROM Metadata metadata";

	private static final String _SQL_SELECT_METADATA_WHERE =
		"SELECT metadata FROM Metadata metadata WHERE ";

	private static final String _SQL_COUNT_METADATA =
		"SELECT COUNT(metadata) FROM Metadata metadata";

	private static final String _SQL_COUNT_METADATA_WHERE =
		"SELECT COUNT(metadata) FROM Metadata metadata WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "metadata.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Metadata exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Metadata exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MetadataPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

}