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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchInstitutionException;
import de.uhh.l2g.plugins.model.Institution;
import de.uhh.l2g.plugins.model.impl.InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.InstitutionModelImpl;
import de.uhh.l2g.plugins.service.persistence.InstitutionPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class InstitutionPersistenceImpl
	extends BasePersistenceImpl<Institution> implements InstitutionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InstitutionUtil</code> to access the institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InstitutionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByParent;
	private FinderPath _finderPathWithoutPaginationFindByParent;
	private FinderPath _finderPathCountByParent;

	/**
	 * Returns all the institutions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching institutions
	 */
	@Override
	public List<Institution> findByParent(long parentId) {
		return findByParent(
			parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	@Override
	public List<Institution> findByParent(long parentId, int start, int end) {
		return findByParent(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByParent(
		long parentId, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return findByParent(parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institutions where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByParent(
		long parentId, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParent;
				finderArgs = new Object[] {parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParent;
			finderArgs = new Object[] {parentId, start, end, orderByComparator};
		}

		List<Institution> list = null;

		if (useFinderCache) {
			list = (List<Institution>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution institution : list) {
					if (parentId != institution.getParentId()) {
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

			sb.append(_SQL_SELECT_INSTITUTION_WHERE);

			sb.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				list = (List<Institution>)QueryUtil.list(
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
	 * Returns the first institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByParent_First(
			long parentId, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByParent_First(
			parentId, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the first institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByParent_First(
		long parentId, OrderByComparator<Institution> orderByComparator) {

		List<Institution> list = findByParent(
			parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByParent_Last(
			long parentId, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByParent_Last(
			parentId, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the last institution in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByParent_Last(
		long parentId, OrderByComparator<Institution> orderByComparator) {

		int count = countByParent(parentId);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByParent(
			parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where parentId = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution[] findByParent_PrevAndNext(
			long institutionId, long parentId,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByParent_PrevAndNext(
				session, institution, parentId, orderByComparator, true);

			array[1] = institution;

			array[2] = getByParent_PrevAndNext(
				session, institution, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByParent_PrevAndNext(
		Session session, Institution institution, long parentId,
		OrderByComparator<Institution> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INSTITUTION_WHERE);

		sb.append(_FINDER_COLUMN_PARENT_PARENTID_2);

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
			sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(institution)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByParent(long parentId) {
		for (Institution institution :
				findByParent(
					parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching institutions
	 */
	@Override
	public int countByParent(long parentId) {
		FinderPath finderPath = _finderPathCountByParent;

		Object[] finderArgs = new Object[] {parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_WHERE);

			sb.append(_FINDER_COLUMN_PARENT_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENT_PARENTID_2 =
		"institution.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByName;
	private FinderPath _finderPathWithoutPaginationFindByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns all the institutions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching institutions
	 */
	@Override
	public List<Institution> findByName(String name) {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	@Override
	public List<Institution> findByName(String name, int start, int end) {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByName(
		String name, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return findByName(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institutions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByName(
		String name, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByName;
				finderArgs = new Object[] {name};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByName;
			finderArgs = new Object[] {name, start, end, orderByComparator};
		}

		List<Institution> list = null;

		if (useFinderCache) {
			list = (List<Institution>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution institution : list) {
					if (!name.equals(institution.getName())) {
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

			sb.append(_SQL_SELECT_INSTITUTION_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<Institution>)QueryUtil.list(
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
	 * Returns the first institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByName_First(
			String name, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByName_First(name, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the first institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByName_First(
		String name, OrderByComparator<Institution> orderByComparator) {

		List<Institution> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByName_Last(
			String name, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByName_Last(name, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("name=");
		sb.append(name);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the last institution in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByName_Last(
		String name, OrderByComparator<Institution> orderByComparator) {

		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByName(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where name = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution[] findByName_PrevAndNext(
			long institutionId, String name,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		name = Objects.toString(name, "");

		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByName_PrevAndNext(
				session, institution, name, orderByComparator, true);

			array[1] = institution;

			array[2] = getByName_PrevAndNext(
				session, institution, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByName_PrevAndNext(
		Session session, Institution institution, String name,
		OrderByComparator<Institution> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INSTITUTION_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(institution)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByName(String name) {
		for (Institution institution :
				findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching institutions
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"institution.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(institution.name IS NULL OR institution.name = '')";

	private FinderPath _finderPathWithPaginationFindByTyp;
	private FinderPath _finderPathWithoutPaginationFindByTyp;
	private FinderPath _finderPathCountByTyp;

	/**
	 * Returns all the institutions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the matching institutions
	 */
	@Override
	public List<Institution> findByTyp(String typ) {
		return findByTyp(typ, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	@Override
	public List<Institution> findByTyp(String typ, int start, int end) {
		return findByTyp(typ, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByTyp(
		String typ, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return findByTyp(typ, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institutions where typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByTyp(
		String typ, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		typ = Objects.toString(typ, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTyp;
				finderArgs = new Object[] {typ};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTyp;
			finderArgs = new Object[] {typ, start, end, orderByComparator};
		}

		List<Institution> list = null;

		if (useFinderCache) {
			list = (List<Institution>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution institution : list) {
					if (!typ.equals(institution.getTyp())) {
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

			sb.append(_SQL_SELECT_INSTITUTION_WHERE);

			boolean bindTyp = false;

			if (typ.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYP_TYP_3);
			}
			else {
				bindTyp = true;

				sb.append(_FINDER_COLUMN_TYP_TYP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTyp) {
					queryPos.add(typ);
				}

				list = (List<Institution>)QueryUtil.list(
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
	 * Returns the first institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByTyp_First(
			String typ, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByTyp_First(typ, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("typ=");
		sb.append(typ);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the first institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByTyp_First(
		String typ, OrderByComparator<Institution> orderByComparator) {

		List<Institution> list = findByTyp(typ, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByTyp_Last(
			String typ, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByTyp_Last(typ, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("typ=");
		sb.append(typ);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the last institution in the ordered set where typ = &#63;.
	 *
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByTyp_Last(
		String typ, OrderByComparator<Institution> orderByComparator) {

		int count = countByTyp(typ);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByTyp(
			typ, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where typ = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution[] findByTyp_PrevAndNext(
			long institutionId, String typ,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		typ = Objects.toString(typ, "");

		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByTyp_PrevAndNext(
				session, institution, typ, orderByComparator, true);

			array[1] = institution;

			array[2] = getByTyp_PrevAndNext(
				session, institution, typ, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByTyp_PrevAndNext(
		Session session, Institution institution, String typ,
		OrderByComparator<Institution> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INSTITUTION_WHERE);

		boolean bindTyp = false;

		if (typ.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYP_TYP_3);
		}
		else {
			bindTyp = true;

			sb.append(_FINDER_COLUMN_TYP_TYP_2);
		}

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
			sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTyp) {
			queryPos.add(typ);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(institution)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where typ = &#63; from the database.
	 *
	 * @param typ the typ
	 */
	@Override
	public void removeByTyp(String typ) {
		for (Institution institution :
				findByTyp(typ, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where typ = &#63;.
	 *
	 * @param typ the typ
	 * @return the number of matching institutions
	 */
	@Override
	public int countByTyp(String typ) {
		typ = Objects.toString(typ, "");

		FinderPath finderPath = _finderPathCountByTyp;

		Object[] finderArgs = new Object[] {typ};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_WHERE);

			boolean bindTyp = false;

			if (typ.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYP_TYP_3);
			}
			else {
				bindTyp = true;

				sb.append(_FINDER_COLUMN_TYP_TYP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTyp) {
					queryPos.add(typ);
				}

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

	private static final String _FINDER_COLUMN_TYP_TYP_2 =
		"institution.typ = ?";

	private static final String _FINDER_COLUMN_TYP_TYP_3 =
		"(institution.typ IS NULL OR institution.typ = '')";

	private FinderPath _finderPathWithPaginationFindByWww;
	private FinderPath _finderPathWithoutPaginationFindByWww;
	private FinderPath _finderPathCountByWww;

	/**
	 * Returns all the institutions where www = &#63;.
	 *
	 * @param www the www
	 * @return the matching institutions
	 */
	@Override
	public List<Institution> findByWww(String www) {
		return findByWww(www, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	@Override
	public List<Institution> findByWww(String www, int start, int end) {
		return findByWww(www, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByWww(
		String www, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return findByWww(www, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institutions where www = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param www the www
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByWww(
		String www, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		www = Objects.toString(www, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByWww;
				finderArgs = new Object[] {www};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByWww;
			finderArgs = new Object[] {www, start, end, orderByComparator};
		}

		List<Institution> list = null;

		if (useFinderCache) {
			list = (List<Institution>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution institution : list) {
					if (!www.equals(institution.getWww())) {
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

			sb.append(_SQL_SELECT_INSTITUTION_WHERE);

			boolean bindWww = false;

			if (www.isEmpty()) {
				sb.append(_FINDER_COLUMN_WWW_WWW_3);
			}
			else {
				bindWww = true;

				sb.append(_FINDER_COLUMN_WWW_WWW_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWww) {
					queryPos.add(www);
				}

				list = (List<Institution>)QueryUtil.list(
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
	 * Returns the first institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByWww_First(
			String www, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByWww_First(www, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("www=");
		sb.append(www);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the first institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByWww_First(
		String www, OrderByComparator<Institution> orderByComparator) {

		List<Institution> list = findByWww(www, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByWww_Last(
			String www, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByWww_Last(www, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("www=");
		sb.append(www);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the last institution in the ordered set where www = &#63;.
	 *
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByWww_Last(
		String www, OrderByComparator<Institution> orderByComparator) {

		int count = countByWww(www);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByWww(
			www, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where www = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param www the www
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution[] findByWww_PrevAndNext(
			long institutionId, String www,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		www = Objects.toString(www, "");

		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByWww_PrevAndNext(
				session, institution, www, orderByComparator, true);

			array[1] = institution;

			array[2] = getByWww_PrevAndNext(
				session, institution, www, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByWww_PrevAndNext(
		Session session, Institution institution, String www,
		OrderByComparator<Institution> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INSTITUTION_WHERE);

		boolean bindWww = false;

		if (www.isEmpty()) {
			sb.append(_FINDER_COLUMN_WWW_WWW_3);
		}
		else {
			bindWww = true;

			sb.append(_FINDER_COLUMN_WWW_WWW_2);
		}

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
			sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindWww) {
			queryPos.add(www);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(institution)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where www = &#63; from the database.
	 *
	 * @param www the www
	 */
	@Override
	public void removeByWww(String www) {
		for (Institution institution :
				findByWww(www, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where www = &#63;.
	 *
	 * @param www the www
	 * @return the number of matching institutions
	 */
	@Override
	public int countByWww(String www) {
		www = Objects.toString(www, "");

		FinderPath finderPath = _finderPathCountByWww;

		Object[] finderArgs = new Object[] {www};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_WHERE);

			boolean bindWww = false;

			if (www.isEmpty()) {
				sb.append(_FINDER_COLUMN_WWW_WWW_3);
			}
			else {
				bindWww = true;

				sb.append(_FINDER_COLUMN_WWW_WWW_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWww) {
					queryPos.add(www);
				}

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

	private static final String _FINDER_COLUMN_WWW_WWW_2 =
		"institution.www = ?";

	private static final String _FINDER_COLUMN_WWW_WWW_3 =
		"(institution.www IS NULL OR institution.www = '')";

	private FinderPath _finderPathWithPaginationFindByLevel;
	private FinderPath _finderPathWithoutPaginationFindByLevel;
	private FinderPath _finderPathCountByLevel;

	/**
	 * Returns all the institutions where level = &#63;.
	 *
	 * @param level the level
	 * @return the matching institutions
	 */
	@Override
	public List<Institution> findByLevel(int level) {
		return findByLevel(level, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	@Override
	public List<Institution> findByLevel(int level, int start, int end) {
		return findByLevel(level, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByLevel(
		int level, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return findByLevel(level, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByLevel(
		int level, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLevel;
				finderArgs = new Object[] {level};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLevel;
			finderArgs = new Object[] {level, start, end, orderByComparator};
		}

		List<Institution> list = null;

		if (useFinderCache) {
			list = (List<Institution>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution institution : list) {
					if (level != institution.getLevel()) {
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

			sb.append(_SQL_SELECT_INSTITUTION_WHERE);

			sb.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(level);

				list = (List<Institution>)QueryUtil.list(
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
	 * Returns the first institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByLevel_First(
			int level, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByLevel_First(level, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("level=");
		sb.append(level);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByLevel_First(
		int level, OrderByComparator<Institution> orderByComparator) {

		List<Institution> list = findByLevel(level, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByLevel_Last(
			int level, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByLevel_Last(level, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("level=");
		sb.append(level);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByLevel_Last(
		int level, OrderByComparator<Institution> orderByComparator) {

		int count = countByLevel(level);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByLevel(
			level, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution[] findByLevel_PrevAndNext(
			long institutionId, int level,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByLevel_PrevAndNext(
				session, institution, level, orderByComparator, true);

			array[1] = institution;

			array[2] = getByLevel_PrevAndNext(
				session, institution, level, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByLevel_PrevAndNext(
		Session session, Institution institution, int level,
		OrderByComparator<Institution> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INSTITUTION_WHERE);

		sb.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

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
			sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(level);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(institution)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where level = &#63; from the database.
	 *
	 * @param level the level
	 */
	@Override
	public void removeByLevel(int level) {
		for (Institution institution :
				findByLevel(
					level, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where level = &#63;.
	 *
	 * @param level the level
	 * @return the number of matching institutions
	 */
	@Override
	public int countByLevel(int level) {
		FinderPath finderPath = _finderPathCountByLevel;

		Object[] finderArgs = new Object[] {level};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_WHERE);

			sb.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(level);

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

	private static final String _FINDER_COLUMN_LEVEL_LEVEL_2 =
		"institution.level = ?";

	private FinderPath _finderPathWithPaginationFindBySort;
	private FinderPath _finderPathWithoutPaginationFindBySort;
	private FinderPath _finderPathCountBySort;

	/**
	 * Returns all the institutions where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the matching institutions
	 */
	@Override
	public List<Institution> findBySort(int sort) {
		return findBySort(sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	@Override
	public List<Institution> findBySort(int sort, int start, int end) {
		return findBySort(sort, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findBySort(
		int sort, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return findBySort(sort, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institutions where sort = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param sort the sort
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findBySort(
		int sort, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySort;
				finderArgs = new Object[] {sort};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySort;
			finderArgs = new Object[] {sort, start, end, orderByComparator};
		}

		List<Institution> list = null;

		if (useFinderCache) {
			list = (List<Institution>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution institution : list) {
					if (sort != institution.getSort()) {
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

			sb.append(_SQL_SELECT_INSTITUTION_WHERE);

			sb.append(_FINDER_COLUMN_SORT_SORT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(sort);

				list = (List<Institution>)QueryUtil.list(
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
	 * Returns the first institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findBySort_First(
			int sort, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchBySort_First(sort, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("sort=");
		sb.append(sort);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the first institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchBySort_First(
		int sort, OrderByComparator<Institution> orderByComparator) {

		List<Institution> list = findBySort(sort, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findBySort_Last(
			int sort, OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchBySort_Last(sort, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("sort=");
		sb.append(sort);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the last institution in the ordered set where sort = &#63;.
	 *
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchBySort_Last(
		int sort, OrderByComparator<Institution> orderByComparator) {

		int count = countBySort(sort);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findBySort(
			sort, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where sort = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param sort the sort
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution[] findBySort_PrevAndNext(
			long institutionId, int sort,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getBySort_PrevAndNext(
				session, institution, sort, orderByComparator, true);

			array[1] = institution;

			array[2] = getBySort_PrevAndNext(
				session, institution, sort, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getBySort_PrevAndNext(
		Session session, Institution institution, int sort,
		OrderByComparator<Institution> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INSTITUTION_WHERE);

		sb.append(_FINDER_COLUMN_SORT_SORT_2);

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
			sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(sort);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(institution)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where sort = &#63; from the database.
	 *
	 * @param sort the sort
	 */
	@Override
	public void removeBySort(int sort) {
		for (Institution institution :
				findBySort(sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where sort = &#63;.
	 *
	 * @param sort the sort
	 * @return the number of matching institutions
	 */
	@Override
	public int countBySort(int sort) {
		FinderPath finderPath = _finderPathCountBySort;

		Object[] finderArgs = new Object[] {sort};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INSTITUTION_WHERE);

			sb.append(_FINDER_COLUMN_SORT_SORT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(sort);

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

	private static final String _FINDER_COLUMN_SORT_SORT_2 =
		"institution.sort = ?";

	private FinderPath _finderPathWithPaginationFindByLevelAndType;
	private FinderPath _finderPathWithoutPaginationFindByLevelAndType;
	private FinderPath _finderPathCountByLevelAndType;

	/**
	 * Returns all the institutions where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @return the matching institutions
	 */
	@Override
	public List<Institution> findByLevelAndType(int level, String typ) {
		return findByLevelAndType(
			level, typ, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of matching institutions
	 */
	@Override
	public List<Institution> findByLevelAndType(
		int level, String typ, int start, int end) {

		return findByLevelAndType(level, typ, start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByLevelAndType(
		int level, String typ, int start, int end,
		OrderByComparator<Institution> orderByComparator) {

		return findByLevelAndType(
			level, typ, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institutions where level = &#63; and typ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching institutions
	 */
	@Override
	public List<Institution> findByLevelAndType(
		int level, String typ, int start, int end,
		OrderByComparator<Institution> orderByComparator,
		boolean useFinderCache) {

		typ = Objects.toString(typ, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLevelAndType;
				finderArgs = new Object[] {level, typ};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLevelAndType;
			finderArgs = new Object[] {
				level, typ, start, end, orderByComparator
			};
		}

		List<Institution> list = null;

		if (useFinderCache) {
			list = (List<Institution>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Institution institution : list) {
					if ((level != institution.getLevel()) ||
						!typ.equals(institution.getTyp())) {

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

			sb.append(_SQL_SELECT_INSTITUTION_WHERE);

			sb.append(_FINDER_COLUMN_LEVELANDTYPE_LEVEL_2);

			boolean bindTyp = false;

			if (typ.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_3);
			}
			else {
				bindTyp = true;

				sb.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(level);

				if (bindTyp) {
					queryPos.add(typ);
				}

				list = (List<Institution>)QueryUtil.list(
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
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByLevelAndType_First(
			int level, String typ,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByLevelAndType_First(
			level, typ, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("level=");
		sb.append(level);

		sb.append(", typ=");
		sb.append(typ);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the first institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByLevelAndType_First(
		int level, String typ,
		OrderByComparator<Institution> orderByComparator) {

		List<Institution> list = findByLevelAndType(
			level, typ, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution
	 * @throws NoSuchInstitutionException if a matching institution could not be found
	 */
	@Override
	public Institution findByLevelAndType_Last(
			int level, String typ,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		Institution institution = fetchByLevelAndType_Last(
			level, typ, orderByComparator);

		if (institution != null) {
			return institution;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("level=");
		sb.append(level);

		sb.append(", typ=");
		sb.append(typ);

		sb.append("}");

		throw new NoSuchInstitutionException(sb.toString());
	}

	/**
	 * Returns the last institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching institution, or <code>null</code> if a matching institution could not be found
	 */
	@Override
	public Institution fetchByLevelAndType_Last(
		int level, String typ,
		OrderByComparator<Institution> orderByComparator) {

		int count = countByLevelAndType(level, typ);

		if (count == 0) {
			return null;
		}

		List<Institution> list = findByLevelAndType(
			level, typ, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the institutions before and after the current institution in the ordered set where level = &#63; and typ = &#63;.
	 *
	 * @param institutionId the primary key of the current institution
	 * @param level the level
	 * @param typ the typ
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution[] findByLevelAndType_PrevAndNext(
			long institutionId, int level, String typ,
			OrderByComparator<Institution> orderByComparator)
		throws NoSuchInstitutionException {

		typ = Objects.toString(typ, "");

		Institution institution = findByPrimaryKey(institutionId);

		Session session = null;

		try {
			session = openSession();

			Institution[] array = new InstitutionImpl[3];

			array[0] = getByLevelAndType_PrevAndNext(
				session, institution, level, typ, orderByComparator, true);

			array[1] = institution;

			array[2] = getByLevelAndType_PrevAndNext(
				session, institution, level, typ, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Institution getByLevelAndType_PrevAndNext(
		Session session, Institution institution, int level, String typ,
		OrderByComparator<Institution> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_INSTITUTION_WHERE);

		sb.append(_FINDER_COLUMN_LEVELANDTYPE_LEVEL_2);

		boolean bindTyp = false;

		if (typ.isEmpty()) {
			sb.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_3);
		}
		else {
			bindTyp = true;

			sb.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_2);
		}

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
			sb.append(InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(level);

		if (bindTyp) {
			queryPos.add(typ);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(institution)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Institution> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the institutions where level = &#63; and typ = &#63; from the database.
	 *
	 * @param level the level
	 * @param typ the typ
	 */
	@Override
	public void removeByLevelAndType(int level, String typ) {
		for (Institution institution :
				findByLevelAndType(
					level, typ, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions where level = &#63; and typ = &#63;.
	 *
	 * @param level the level
	 * @param typ the typ
	 * @return the number of matching institutions
	 */
	@Override
	public int countByLevelAndType(int level, String typ) {
		typ = Objects.toString(typ, "");

		FinderPath finderPath = _finderPathCountByLevelAndType;

		Object[] finderArgs = new Object[] {level, typ};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INSTITUTION_WHERE);

			sb.append(_FINDER_COLUMN_LEVELANDTYPE_LEVEL_2);

			boolean bindTyp = false;

			if (typ.isEmpty()) {
				sb.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_3);
			}
			else {
				bindTyp = true;

				sb.append(_FINDER_COLUMN_LEVELANDTYPE_TYP_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(level);

				if (bindTyp) {
					queryPos.add(typ);
				}

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

	private static final String _FINDER_COLUMN_LEVELANDTYPE_LEVEL_2 =
		"institution.level = ? AND ";

	private static final String _FINDER_COLUMN_LEVELANDTYPE_TYP_2 =
		"institution.typ = ?";

	private static final String _FINDER_COLUMN_LEVELANDTYPE_TYP_3 =
		"(institution.typ IS NULL OR institution.typ = '')";

	public InstitutionPersistenceImpl() {
		setModelClass(Institution.class);

		setModelImplClass(InstitutionImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(InstitutionModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the institution in the entity cache if it is enabled.
	 *
	 * @param institution the institution
	 */
	@Override
	public void cacheResult(Institution institution) {
		entityCache.putResult(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED, InstitutionImpl.class,
			institution.getPrimaryKey(), institution);

		institution.resetOriginalValues();
	}

	/**
	 * Caches the institutions in the entity cache if it is enabled.
	 *
	 * @param institutions the institutions
	 */
	@Override
	public void cacheResult(List<Institution> institutions) {
		for (Institution institution : institutions) {
			if (entityCache.getResult(
					InstitutionModelImpl.ENTITY_CACHE_ENABLED,
					InstitutionImpl.class, institution.getPrimaryKey()) ==
						null) {

				cacheResult(institution);
			}
			else {
				institution.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all institutions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InstitutionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the institution.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Institution institution) {
		entityCache.removeResult(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED, InstitutionImpl.class,
			institution.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Institution> institutions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Institution institution : institutions) {
			entityCache.removeResult(
				InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				InstitutionImpl.class, institution.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				InstitutionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new institution with the primary key. Does not add the institution to the database.
	 *
	 * @param institutionId the primary key for the new institution
	 * @return the new institution
	 */
	@Override
	public Institution create(long institutionId) {
		Institution institution = new InstitutionImpl();

		institution.setNew(true);
		institution.setPrimaryKey(institutionId);

		institution.setCompanyId(CompanyThreadLocal.getCompanyId());

		return institution;
	}

	/**
	 * Removes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution that was removed
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution remove(long institutionId)
		throws NoSuchInstitutionException {

		return remove((Serializable)institutionId);
	}

	/**
	 * Removes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the institution
	 * @return the institution that was removed
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution remove(Serializable primaryKey)
		throws NoSuchInstitutionException {

		Session session = null;

		try {
			session = openSession();

			Institution institution = (Institution)session.get(
				InstitutionImpl.class, primaryKey);

			if (institution == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInstitutionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(institution);
		}
		catch (NoSuchInstitutionException noSuchEntityException) {
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
	protected Institution removeImpl(Institution institution) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(institution)) {
				institution = (Institution)session.get(
					InstitutionImpl.class, institution.getPrimaryKeyObj());
			}

			if (institution != null) {
				session.delete(institution);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (institution != null) {
			clearCache(institution);
		}

		return institution;
	}

	@Override
	public Institution updateImpl(Institution institution) {
		boolean isNew = institution.isNew();

		if (!(institution instanceof InstitutionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(institution.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(institution);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in institution proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Institution implementation " +
					institution.getClass());
		}

		InstitutionModelImpl institutionModelImpl =
			(InstitutionModelImpl)institution;

		Session session = null;

		try {
			session = openSession();

			if (institution.isNew()) {
				session.save(institution);

				institution.setNew(false);
			}
			else {
				institution = (Institution)session.merge(institution);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!InstitutionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {institutionModelImpl.getParentId()};

			finderCache.removeResult(_finderPathCountByParent, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByParent, args);

			args = new Object[] {institutionModelImpl.getName()};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByName, args);

			args = new Object[] {institutionModelImpl.getTyp()};

			finderCache.removeResult(_finderPathCountByTyp, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTyp, args);

			args = new Object[] {institutionModelImpl.getWww()};

			finderCache.removeResult(_finderPathCountByWww, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByWww, args);

			args = new Object[] {institutionModelImpl.getLevel()};

			finderCache.removeResult(_finderPathCountByLevel, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLevel, args);

			args = new Object[] {institutionModelImpl.getSort()};

			finderCache.removeResult(_finderPathCountBySort, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySort, args);

			args = new Object[] {
				institutionModelImpl.getLevel(), institutionModelImpl.getTyp()
			};

			finderCache.removeResult(_finderPathCountByLevelAndType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLevelAndType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((institutionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByParent.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institutionModelImpl.getOriginalParentId()
				};

				finderCache.removeResult(_finderPathCountByParent, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParent, args);

				args = new Object[] {institutionModelImpl.getParentId()};

				finderCache.removeResult(_finderPathCountByParent, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParent, args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByName.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institutionModelImpl.getOriginalName()
				};

				finderCache.removeResult(_finderPathCountByName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName, args);

				args = new Object[] {institutionModelImpl.getName()};

				finderCache.removeResult(_finderPathCountByName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByName, args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTyp.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institutionModelImpl.getOriginalTyp()
				};

				finderCache.removeResult(_finderPathCountByTyp, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTyp, args);

				args = new Object[] {institutionModelImpl.getTyp()};

				finderCache.removeResult(_finderPathCountByTyp, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTyp, args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByWww.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institutionModelImpl.getOriginalWww()
				};

				finderCache.removeResult(_finderPathCountByWww, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByWww, args);

				args = new Object[] {institutionModelImpl.getWww()};

				finderCache.removeResult(_finderPathCountByWww, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByWww, args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLevel.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institutionModelImpl.getOriginalLevel()
				};

				finderCache.removeResult(_finderPathCountByLevel, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLevel, args);

				args = new Object[] {institutionModelImpl.getLevel()};

				finderCache.removeResult(_finderPathCountByLevel, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLevel, args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySort.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					institutionModelImpl.getOriginalSort()
				};

				finderCache.removeResult(_finderPathCountBySort, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySort, args);

				args = new Object[] {institutionModelImpl.getSort()};

				finderCache.removeResult(_finderPathCountBySort, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySort, args);
			}

			if ((institutionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLevelAndType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					institutionModelImpl.getOriginalLevel(),
					institutionModelImpl.getOriginalTyp()
				};

				finderCache.removeResult(_finderPathCountByLevelAndType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLevelAndType, args);

				args = new Object[] {
					institutionModelImpl.getLevel(),
					institutionModelImpl.getTyp()
				};

				finderCache.removeResult(_finderPathCountByLevelAndType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLevelAndType, args);
			}
		}

		entityCache.putResult(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED, InstitutionImpl.class,
			institution.getPrimaryKey(), institution, false);

		institution.resetOriginalValues();

		return institution;
	}

	/**
	 * Returns the institution with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the institution
	 * @return the institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInstitutionException {

		Institution institution = fetchByPrimaryKey(primaryKey);

		if (institution == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInstitutionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return institution;
	}

	/**
	 * Returns the institution with the primary key or throws a <code>NoSuchInstitutionException</code> if it could not be found.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution
	 * @throws NoSuchInstitutionException if a institution with the primary key could not be found
	 */
	@Override
	public Institution findByPrimaryKey(long institutionId)
		throws NoSuchInstitutionException {

		return findByPrimaryKey((Serializable)institutionId);
	}

	/**
	 * Returns the institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param institutionId the primary key of the institution
	 * @return the institution, or <code>null</code> if a institution with the primary key could not be found
	 */
	@Override
	public Institution fetchByPrimaryKey(long institutionId) {
		return fetchByPrimaryKey((Serializable)institutionId);
	}

	/**
	 * Returns all the institutions.
	 *
	 * @return the institutions
	 */
	@Override
	public List<Institution> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @return the range of institutions
	 */
	@Override
	public List<Institution> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of institutions
	 */
	@Override
	public List<Institution> findAll(
		int start, int end, OrderByComparator<Institution> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InstitutionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of institutions
	 * @param end the upper bound of the range of institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of institutions
	 */
	@Override
	public List<Institution> findAll(
		int start, int end, OrderByComparator<Institution> orderByComparator,
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

		List<Institution> list = null;

		if (useFinderCache) {
			list = (List<Institution>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INSTITUTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INSTITUTION;

				sql = sql.concat(InstitutionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Institution>)QueryUtil.list(
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
	 * Removes all the institutions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Institution institution : findAll()) {
			remove(institution);
		}
	}

	/**
	 * Returns the number of institutions.
	 *
	 * @return the number of institutions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INSTITUTION);

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
		return "institutionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INSTITUTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InstitutionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the institution persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByParent = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParent",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByParent = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParent",
			new String[] {Long.class.getName()},
			InstitutionModelImpl.PARENTID_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);

		_finderPathCountByParent = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParent",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByName = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByName = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] {String.class.getName()},
			InstitutionModelImpl.NAME_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);

		_finderPathCountByName = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTyp = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTyp",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTyp = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTyp",
			new String[] {String.class.getName()},
			InstitutionModelImpl.TYP_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);

		_finderPathCountByTyp = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTyp",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByWww = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByWww",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByWww = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWww",
			new String[] {String.class.getName()},
			InstitutionModelImpl.WWW_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);

		_finderPathCountByWww = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWww",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByLevel = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevel",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLevel = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevel",
			new String[] {Integer.class.getName()},
			InstitutionModelImpl.LEVEL_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);

		_finderPathCountByLevel = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevel",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindBySort = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySort",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySort = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySort",
			new String[] {Integer.class.getName()},
			InstitutionModelImpl.SORT_COLUMN_BITMASK);

		_finderPathCountBySort = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySort",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByLevelAndType = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevelAndType",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLevelAndType = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevelAndType",
			new String[] {Integer.class.getName(), String.class.getName()},
			InstitutionModelImpl.LEVEL_COLUMN_BITMASK |
			InstitutionModelImpl.TYP_COLUMN_BITMASK |
			InstitutionModelImpl.SORT_COLUMN_BITMASK);

		_finderPathCountByLevelAndType = new FinderPath(
			InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevelAndType",
			new String[] {Integer.class.getName(), String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(InstitutionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_INSTITUTION =
		"SELECT institution FROM Institution institution";

	private static final String _SQL_SELECT_INSTITUTION_WHERE =
		"SELECT institution FROM Institution institution WHERE ";

	private static final String _SQL_COUNT_INSTITUTION =
		"SELECT COUNT(institution) FROM Institution institution";

	private static final String _SQL_COUNT_INSTITUTION_WHERE =
		"SELECT COUNT(institution) FROM Institution institution WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "institution.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Institution exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Institution exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		InstitutionPersistenceImpl.class);

}