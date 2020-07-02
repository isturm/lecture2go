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
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchCreatorException;
import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.impl.CreatorImpl;
import de.uhh.l2g.plugins.model.impl.CreatorModelImpl;
import de.uhh.l2g.plugins.service.persistence.CreatorPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class CreatorPersistenceImpl
	extends BasePersistenceImpl<Creator> implements CreatorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CreatorUtil</code> to access the creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CreatorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByFirstName;
	private FinderPath _finderPathWithoutPaginationFindByFirstName;
	private FinderPath _finderPathCountByFirstName;

	/**
	 * Returns all the creators where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByFirstName(String firstName) {
		return findByFirstName(
			firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	@Override
	public List<Creator> findByFirstName(String firstName, int start, int end) {
		return findByFirstName(firstName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByFirstName(
		String firstName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return findByFirstName(firstName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the creators where firstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param firstName the first name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByFirstName(
		String firstName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		firstName = Objects.toString(firstName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFirstName;
				finderArgs = new Object[] {firstName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFirstName;
			finderArgs = new Object[] {
				firstName, start, end, orderByComparator
			};
		}

		List<Creator> list = null;

		if (useFinderCache) {
			list = (List<Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (!firstName.equals(creator.getFirstName())) {
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

			sb.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFirstName) {
					queryPos.add(firstName);
				}

				list = (List<Creator>)QueryUtil.list(
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
	 * Returns the first creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByFirstName_First(
			String firstName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByFirstName_First(firstName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("firstName=");
		sb.append(firstName);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the first creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByFirstName_First(
		String firstName, OrderByComparator<Creator> orderByComparator) {

		List<Creator> list = findByFirstName(
			firstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByFirstName_Last(
			String firstName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByFirstName_Last(firstName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("firstName=");
		sb.append(firstName);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the last creator in the ordered set where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByFirstName_Last(
		String firstName, OrderByComparator<Creator> orderByComparator) {

		int count = countByFirstName(firstName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByFirstName(
			firstName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where firstName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param firstName the first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator[] findByFirstName_PrevAndNext(
			long creatorId, String firstName,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		firstName = Objects.toString(firstName, "");

		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByFirstName_PrevAndNext(
				session, creator, firstName, orderByComparator, true);

			array[1] = creator;

			array[2] = getByFirstName_PrevAndNext(
				session, creator, firstName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByFirstName_PrevAndNext(
		Session session, Creator creator, String firstName,
		OrderByComparator<Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindFirstName = false;

		if (firstName.isEmpty()) {
			sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
		}
		else {
			bindFirstName = true;

			sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
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
			sb.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFirstName) {
			queryPos.add(firstName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where firstName = &#63; from the database.
	 *
	 * @param firstName the first name
	 */
	@Override
	public void removeByFirstName(String firstName) {
		for (Creator creator :
				findByFirstName(
					firstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where firstName = &#63;.
	 *
	 * @param firstName the first name
	 * @return the number of matching creators
	 */
	@Override
	public int countByFirstName(String firstName) {
		firstName = Objects.toString(firstName, "");

		FinderPath finderPath = _finderPathCountByFirstName;

		Object[] finderArgs = new Object[] {firstName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				sb.append(_FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFirstName) {
					queryPos.add(firstName);
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

	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_2 =
		"creator.firstName = ?";

	private static final String _FINDER_COLUMN_FIRSTNAME_FIRSTNAME_3 =
		"(creator.firstName IS NULL OR creator.firstName = '')";

	private FinderPath _finderPathWithPaginationFindByLastName;
	private FinderPath _finderPathWithoutPaginationFindByLastName;
	private FinderPath _finderPathCountByLastName;

	/**
	 * Returns all the creators where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByLastName(String lastName) {
		return findByLastName(
			lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	@Override
	public List<Creator> findByLastName(String lastName, int start, int end) {
		return findByLastName(lastName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return findByLastName(lastName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the creators where lastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param lastName the last name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByLastName(
		String lastName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLastName;
				finderArgs = new Object[] {lastName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLastName;
			finderArgs = new Object[] {lastName, start, end, orderByComparator};
		}

		List<Creator> list = null;

		if (useFinderCache) {
			list = (List<Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (!lastName.equals(creator.getLastName())) {
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

			sb.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLastName) {
					queryPos.add(lastName);
				}

				list = (List<Creator>)QueryUtil.list(
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
	 * Returns the first creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByLastName_First(
			String lastName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByLastName_First(lastName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lastName=");
		sb.append(lastName);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the first creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByLastName_First(
		String lastName, OrderByComparator<Creator> orderByComparator) {

		List<Creator> list = findByLastName(lastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByLastName_Last(
			String lastName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByLastName_Last(lastName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("lastName=");
		sb.append(lastName);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the last creator in the ordered set where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByLastName_Last(
		String lastName, OrderByComparator<Creator> orderByComparator) {

		int count = countByLastName(lastName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByLastName(
			lastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where lastName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param lastName the last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator[] findByLastName_PrevAndNext(
			long creatorId, String lastName,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		lastName = Objects.toString(lastName, "");

		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByLastName_PrevAndNext(
				session, creator, lastName, orderByComparator, true);

			array[1] = creator;

			array[2] = getByLastName_PrevAndNext(
				session, creator, lastName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByLastName_PrevAndNext(
		Session session, Creator creator, String lastName,
		OrderByComparator<Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindLastName = false;

		if (lastName.isEmpty()) {
			sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
		}
		else {
			bindLastName = true;

			sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
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
			sb.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindLastName) {
			queryPos.add(lastName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where lastName = &#63; from the database.
	 *
	 * @param lastName the last name
	 */
	@Override
	public void removeByLastName(String lastName) {
		for (Creator creator :
				findByLastName(
					lastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where lastName = &#63;.
	 *
	 * @param lastName the last name
	 * @return the number of matching creators
	 */
	@Override
	public int countByLastName(String lastName) {
		lastName = Objects.toString(lastName, "");

		FinderPath finderPath = _finderPathCountByLastName;

		Object[] finderArgs = new Object[] {lastName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_LASTNAME_LASTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindLastName) {
					queryPos.add(lastName);
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

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_2 =
		"creator.lastName = ?";

	private static final String _FINDER_COLUMN_LASTNAME_LASTNAME_3 =
		"(creator.lastName IS NULL OR creator.lastName = '')";

	private FinderPath _finderPathWithPaginationFindByMiddleName;
	private FinderPath _finderPathWithoutPaginationFindByMiddleName;
	private FinderPath _finderPathCountByMiddleName;

	/**
	 * Returns all the creators where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByMiddleName(String middleName) {
		return findByMiddleName(
			middleName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	@Override
	public List<Creator> findByMiddleName(
		String middleName, int start, int end) {

		return findByMiddleName(middleName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByMiddleName(
		String middleName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return findByMiddleName(
			middleName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the creators where middleName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param middleName the middle name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByMiddleName(
		String middleName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		middleName = Objects.toString(middleName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMiddleName;
				finderArgs = new Object[] {middleName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMiddleName;
			finderArgs = new Object[] {
				middleName, start, end, orderByComparator
			};
		}

		List<Creator> list = null;

		if (useFinderCache) {
			list = (List<Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (!middleName.equals(creator.getMiddleName())) {
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

			sb.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindMiddleName = false;

			if (middleName.isEmpty()) {
				sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
			}
			else {
				bindMiddleName = true;

				sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMiddleName) {
					queryPos.add(middleName);
				}

				list = (List<Creator>)QueryUtil.list(
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
	 * Returns the first creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByMiddleName_First(
			String middleName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByMiddleName_First(
			middleName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("middleName=");
		sb.append(middleName);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the first creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByMiddleName_First(
		String middleName, OrderByComparator<Creator> orderByComparator) {

		List<Creator> list = findByMiddleName(
			middleName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByMiddleName_Last(
			String middleName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByMiddleName_Last(middleName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("middleName=");
		sb.append(middleName);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the last creator in the ordered set where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByMiddleName_Last(
		String middleName, OrderByComparator<Creator> orderByComparator) {

		int count = countByMiddleName(middleName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByMiddleName(
			middleName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where middleName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param middleName the middle name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator[] findByMiddleName_PrevAndNext(
			long creatorId, String middleName,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		middleName = Objects.toString(middleName, "");

		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByMiddleName_PrevAndNext(
				session, creator, middleName, orderByComparator, true);

			array[1] = creator;

			array[2] = getByMiddleName_PrevAndNext(
				session, creator, middleName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByMiddleName_PrevAndNext(
		Session session, Creator creator, String middleName,
		OrderByComparator<Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindMiddleName = false;

		if (middleName.isEmpty()) {
			sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
		}
		else {
			bindMiddleName = true;

			sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
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
			sb.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindMiddleName) {
			queryPos.add(middleName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where middleName = &#63; from the database.
	 *
	 * @param middleName the middle name
	 */
	@Override
	public void removeByMiddleName(String middleName) {
		for (Creator creator :
				findByMiddleName(
					middleName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where middleName = &#63;.
	 *
	 * @param middleName the middle name
	 * @return the number of matching creators
	 */
	@Override
	public int countByMiddleName(String middleName) {
		middleName = Objects.toString(middleName, "");

		FinderPath finderPath = _finderPathCountByMiddleName;

		Object[] finderArgs = new Object[] {middleName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindMiddleName = false;

			if (middleName.isEmpty()) {
				sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3);
			}
			else {
				bindMiddleName = true;

				sb.append(_FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMiddleName) {
					queryPos.add(middleName);
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

	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_2 =
		"creator.middleName = ?";

	private static final String _FINDER_COLUMN_MIDDLENAME_MIDDLENAME_3 =
		"(creator.middleName IS NULL OR creator.middleName = '')";

	private FinderPath _finderPathWithPaginationFindByFullName;
	private FinderPath _finderPathWithoutPaginationFindByFullName;
	private FinderPath _finderPathCountByFullName;

	/**
	 * Returns all the creators where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByFullName(String fullName) {
		return findByFullName(
			fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	@Override
	public List<Creator> findByFullName(String fullName, int start, int end) {
		return findByFullName(fullName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByFullName(
		String fullName, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return findByFullName(fullName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the creators where fullName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param fullName the full name
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByFullName(
		String fullName, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

		fullName = Objects.toString(fullName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFullName;
				finderArgs = new Object[] {fullName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFullName;
			finderArgs = new Object[] {fullName, start, end, orderByComparator};
		}

		List<Creator> list = null;

		if (useFinderCache) {
			list = (List<Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (!fullName.equals(creator.getFullName())) {
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

			sb.append(_SQL_SELECT_CREATOR_WHERE);

			boolean bindFullName = false;

			if (fullName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
			}
			else {
				bindFullName = true;

				sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFullName) {
					queryPos.add(fullName);
				}

				list = (List<Creator>)QueryUtil.list(
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
	 * Returns the first creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByFullName_First(
			String fullName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByFullName_First(fullName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fullName=");
		sb.append(fullName);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the first creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByFullName_First(
		String fullName, OrderByComparator<Creator> orderByComparator) {

		List<Creator> list = findByFullName(fullName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByFullName_Last(
			String fullName, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByFullName_Last(fullName, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("fullName=");
		sb.append(fullName);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the last creator in the ordered set where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByFullName_Last(
		String fullName, OrderByComparator<Creator> orderByComparator) {

		int count = countByFullName(fullName);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByFullName(
			fullName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where fullName = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param fullName the full name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator[] findByFullName_PrevAndNext(
			long creatorId, String fullName,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		fullName = Objects.toString(fullName, "");

		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByFullName_PrevAndNext(
				session, creator, fullName, orderByComparator, true);

			array[1] = creator;

			array[2] = getByFullName_PrevAndNext(
				session, creator, fullName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByFullName_PrevAndNext(
		Session session, Creator creator, String fullName,
		OrderByComparator<Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CREATOR_WHERE);

		boolean bindFullName = false;

		if (fullName.isEmpty()) {
			sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
		}
		else {
			bindFullName = true;

			sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
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
			sb.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindFullName) {
			queryPos.add(fullName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where fullName = &#63; from the database.
	 *
	 * @param fullName the full name
	 */
	@Override
	public void removeByFullName(String fullName) {
		for (Creator creator :
				findByFullName(
					fullName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where fullName = &#63;.
	 *
	 * @param fullName the full name
	 * @return the number of matching creators
	 */
	@Override
	public int countByFullName(String fullName) {
		fullName = Objects.toString(fullName, "");

		FinderPath finderPath = _finderPathCountByFullName;

		Object[] finderArgs = new Object[] {fullName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CREATOR_WHERE);

			boolean bindFullName = false;

			if (fullName.isEmpty()) {
				sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_3);
			}
			else {
				bindFullName = true;

				sb.append(_FINDER_COLUMN_FULLNAME_FULLNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFullName) {
					queryPos.add(fullName);
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

	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_2 =
		"creator.fullName = ?";

	private static final String _FINDER_COLUMN_FULLNAME_FULLNAME_3 =
		"(creator.fullName IS NULL OR creator.fullName = '')";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the creators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	@Override
	public List<Creator> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the creators where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

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

		List<Creator> list = null;

		if (useFinderCache) {
			list = (List<Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (groupId != creator.getGroupId()) {
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

			sb.append(_SQL_SELECT_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Creator>)QueryUtil.list(
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
	 * Returns the first creator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByGroup_First(
			long groupId, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByGroup_First(groupId, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the first creator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByGroup_First(
		long groupId, OrderByComparator<Creator> orderByComparator) {

		List<Creator> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByGroup_Last(
			long groupId, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByGroup_Last(groupId, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the last creator in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByGroup_Last(
		long groupId, OrderByComparator<Creator> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where groupId = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator[] findByGroup_PrevAndNext(
			long creatorId, long groupId,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, creator, groupId, orderByComparator, true);

			array[1] = creator;

			array[2] = getByGroup_PrevAndNext(
				session, creator, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByGroup_PrevAndNext(
		Session session, Creator creator, long groupId,
		OrderByComparator<Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CREATOR_WHERE);

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
			sb.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Creator creator :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching creators
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CREATOR_WHERE);

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
		"creator.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the creators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	@Override
	public List<Creator> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the creators where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

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

		List<Creator> list = null;

		if (useFinderCache) {
			list = (List<Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if (companyId != creator.getCompanyId()) {
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

			sb.append(_SQL_SELECT_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<Creator>)QueryUtil.list(
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
	 * Returns the first creator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByCompany_First(
			long companyId, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByCompany_First(companyId, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the first creator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByCompany_First(
		long companyId, OrderByComparator<Creator> orderByComparator) {

		List<Creator> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByCompany_Last(
			long companyId, OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByCompany_Last(companyId, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the last creator in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByCompany_Last(
		long companyId, OrderByComparator<Creator> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where companyId = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator[] findByCompany_PrevAndNext(
			long creatorId, long companyId,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, creator, companyId, orderByComparator, true);

			array[1] = creator;

			array[2] = getByCompany_PrevAndNext(
				session, creator, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByCompany_PrevAndNext(
		Session session, Creator creator, long companyId,
		OrderByComparator<Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CREATOR_WHERE);

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
			sb.append(CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Creator creator :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching creators
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CREATOR_WHERE);

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
		"creator.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the creators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching creators
	 */
	@Override
	public List<Creator> findByGroupAndCompany(long groupId, long companyId) {
		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of matching creators
	 */
	@Override
	public List<Creator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Creator> orderByComparator) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the creators where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching creators
	 */
	@Override
	public List<Creator> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Creator> orderByComparator, boolean useFinderCache) {

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

		List<Creator> list = null;

		if (useFinderCache) {
			list = (List<Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Creator creator : list) {
					if ((groupId != creator.getGroupId()) ||
						(companyId != creator.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<Creator>)QueryUtil.list(
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
	 * Returns the first creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the first creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Creator> orderByComparator) {

		List<Creator> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator
	 * @throws NoSuchCreatorException if a matching creator could not be found
	 */
	@Override
	public Creator findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (creator != null) {
			return creator;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCreatorException(sb.toString());
	}

	/**
	 * Returns the last creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching creator, or <code>null</code> if a matching creator could not be found
	 */
	@Override
	public Creator fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Creator> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Creator> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the creators before and after the current creator in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param creatorId the primary key of the current creator
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator[] findByGroupAndCompany_PrevAndNext(
			long creatorId, long groupId, long companyId,
			OrderByComparator<Creator> orderByComparator)
		throws NoSuchCreatorException {

		Creator creator = findByPrimaryKey(creatorId);

		Session session = null;

		try {
			session = openSession();

			Creator[] array = new CreatorImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, creator, groupId, companyId, orderByComparator, true);

			array[1] = creator;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, creator, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Creator getByGroupAndCompany_PrevAndNext(
		Session session, Creator creator, long groupId, long companyId,
		OrderByComparator<Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CREATOR_WHERE);

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
			sb.append(CreatorModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the creators where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Creator creator :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(creator);
		}
	}

	/**
	 * Returns the number of creators where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching creators
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CREATOR_WHERE);

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
		"creator.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"creator.companyId = ?";

	public CreatorPersistenceImpl() {
		setModelClass(Creator.class);

		setModelImplClass(CreatorImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(CreatorModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the creator in the entity cache if it is enabled.
	 *
	 * @param creator the creator
	 */
	@Override
	public void cacheResult(Creator creator) {
		entityCache.putResult(
			CreatorModelImpl.ENTITY_CACHE_ENABLED, CreatorImpl.class,
			creator.getPrimaryKey(), creator);

		creator.resetOriginalValues();
	}

	/**
	 * Caches the creators in the entity cache if it is enabled.
	 *
	 * @param creators the creators
	 */
	@Override
	public void cacheResult(List<Creator> creators) {
		for (Creator creator : creators) {
			if (entityCache.getResult(
					CreatorModelImpl.ENTITY_CACHE_ENABLED, CreatorImpl.class,
					creator.getPrimaryKey()) == null) {

				cacheResult(creator);
			}
			else {
				creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all creators.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CreatorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the creator.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Creator creator) {
		entityCache.removeResult(
			CreatorModelImpl.ENTITY_CACHE_ENABLED, CreatorImpl.class,
			creator.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Creator> creators) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Creator creator : creators) {
			entityCache.removeResult(
				CreatorModelImpl.ENTITY_CACHE_ENABLED, CreatorImpl.class,
				creator.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				CreatorModelImpl.ENTITY_CACHE_ENABLED, CreatorImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new creator with the primary key. Does not add the creator to the database.
	 *
	 * @param creatorId the primary key for the new creator
	 * @return the new creator
	 */
	@Override
	public Creator create(long creatorId) {
		Creator creator = new CreatorImpl();

		creator.setNew(true);
		creator.setPrimaryKey(creatorId);

		creator.setCompanyId(CompanyThreadLocal.getCompanyId());

		return creator;
	}

	/**
	 * Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator that was removed
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator remove(long creatorId) throws NoSuchCreatorException {
		return remove((Serializable)creatorId);
	}

	/**
	 * Removes the creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the creator
	 * @return the creator that was removed
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator remove(Serializable primaryKey)
		throws NoSuchCreatorException {

		Session session = null;

		try {
			session = openSession();

			Creator creator = (Creator)session.get(
				CreatorImpl.class, primaryKey);

			if (creator == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCreatorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(creator);
		}
		catch (NoSuchCreatorException noSuchEntityException) {
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
	protected Creator removeImpl(Creator creator) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(creator)) {
				creator = (Creator)session.get(
					CreatorImpl.class, creator.getPrimaryKeyObj());
			}

			if (creator != null) {
				session.delete(creator);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (creator != null) {
			clearCache(creator);
		}

		return creator;
	}

	@Override
	public Creator updateImpl(Creator creator) {
		boolean isNew = creator.isNew();

		if (!(creator instanceof CreatorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(creator.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(creator);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in creator proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Creator implementation " +
					creator.getClass());
		}

		CreatorModelImpl creatorModelImpl = (CreatorModelImpl)creator;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (creator.getCreateDate() == null)) {
			if (serviceContext == null) {
				creator.setCreateDate(now);
			}
			else {
				creator.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!creatorModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				creator.setModifiedDate(now);
			}
			else {
				creator.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (creator.isNew()) {
				session.save(creator);

				creator.setNew(false);
			}
			else {
				creator = (Creator)session.merge(creator);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CreatorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {creatorModelImpl.getFirstName()};

			finderCache.removeResult(_finderPathCountByFirstName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFirstName, args);

			args = new Object[] {creatorModelImpl.getLastName()};

			finderCache.removeResult(_finderPathCountByLastName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByLastName, args);

			args = new Object[] {creatorModelImpl.getMiddleName()};

			finderCache.removeResult(_finderPathCountByMiddleName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMiddleName, args);

			args = new Object[] {creatorModelImpl.getFullName()};

			finderCache.removeResult(_finderPathCountByFullName, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFullName, args);

			args = new Object[] {creatorModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {creatorModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				creatorModelImpl.getGroupId(), creatorModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((creatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFirstName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					creatorModelImpl.getOriginalFirstName()
				};

				finderCache.removeResult(_finderPathCountByFirstName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFirstName, args);

				args = new Object[] {creatorModelImpl.getFirstName()};

				finderCache.removeResult(_finderPathCountByFirstName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFirstName, args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByLastName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					creatorModelImpl.getOriginalLastName()
				};

				finderCache.removeResult(_finderPathCountByLastName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLastName, args);

				args = new Object[] {creatorModelImpl.getLastName()};

				finderCache.removeResult(_finderPathCountByLastName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByLastName, args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMiddleName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					creatorModelImpl.getOriginalMiddleName()
				};

				finderCache.removeResult(_finderPathCountByMiddleName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMiddleName, args);

				args = new Object[] {creatorModelImpl.getMiddleName()};

				finderCache.removeResult(_finderPathCountByMiddleName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMiddleName, args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFullName.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					creatorModelImpl.getOriginalFullName()
				};

				finderCache.removeResult(_finderPathCountByFullName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFullName, args);

				args = new Object[] {creatorModelImpl.getFullName()};

				finderCache.removeResult(_finderPathCountByFullName, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFullName, args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					creatorModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {creatorModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					creatorModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {creatorModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((creatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					creatorModelImpl.getOriginalGroupId(),
					creatorModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					creatorModelImpl.getGroupId(),
					creatorModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}
		}

		entityCache.putResult(
			CreatorModelImpl.ENTITY_CACHE_ENABLED, CreatorImpl.class,
			creator.getPrimaryKey(), creator, false);

		creator.resetOriginalValues();

		return creator;
	}

	/**
	 * Returns the creator with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the creator
	 * @return the creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCreatorException {

		Creator creator = fetchByPrimaryKey(primaryKey);

		if (creator == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCreatorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return creator;
	}

	/**
	 * Returns the creator with the primary key or throws a <code>NoSuchCreatorException</code> if it could not be found.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator
	 * @throws NoSuchCreatorException if a creator with the primary key could not be found
	 */
	@Override
	public Creator findByPrimaryKey(long creatorId)
		throws NoSuchCreatorException {

		return findByPrimaryKey((Serializable)creatorId);
	}

	/**
	 * Returns the creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param creatorId the primary key of the creator
	 * @return the creator, or <code>null</code> if a creator with the primary key could not be found
	 */
	@Override
	public Creator fetchByPrimaryKey(long creatorId) {
		return fetchByPrimaryKey((Serializable)creatorId);
	}

	/**
	 * Returns all the creators.
	 *
	 * @return the creators
	 */
	@Override
	public List<Creator> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @return the range of creators
	 */
	@Override
	public List<Creator> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of creators
	 */
	@Override
	public List<Creator> findAll(
		int start, int end, OrderByComparator<Creator> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of creators
	 * @param end the upper bound of the range of creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of creators
	 */
	@Override
	public List<Creator> findAll(
		int start, int end, OrderByComparator<Creator> orderByComparator,
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

		List<Creator> list = null;

		if (useFinderCache) {
			list = (List<Creator>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CREATOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CREATOR;

				sql = sql.concat(CreatorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Creator>)QueryUtil.list(
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
	 * Removes all the creators from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Creator creator : findAll()) {
			remove(creator);
		}
	}

	/**
	 * Returns the number of creators.
	 *
	 * @return the number of creators
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CREATOR);

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
		return "creatorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CREATOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CreatorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the creator persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByFirstName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFirstName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFirstName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFirstName",
			new String[] {String.class.getName()},
			CreatorModelImpl.FIRSTNAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByFirstName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFirstName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByLastName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLastName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByLastName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLastName",
			new String[] {String.class.getName()},
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByLastName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLastName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByMiddleName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMiddleName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMiddleName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMiddleName",
			new String[] {String.class.getName()},
			CreatorModelImpl.MIDDLENAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByMiddleName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMiddleName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByFullName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFullName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFullName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFullName",
			new String[] {String.class.getName()},
			CreatorModelImpl.FULLNAME_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByFullName = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFullName",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			CreatorModelImpl.GROUPID_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			CreatorModelImpl.COMPANYID_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, CreatorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			CreatorModelImpl.GROUPID_COLUMN_BITMASK |
			CreatorModelImpl.COMPANYID_COLUMN_BITMASK |
			CreatorModelImpl.LASTNAME_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			CreatorModelImpl.ENTITY_CACHE_ENABLED,
			CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(CreatorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CREATOR =
		"SELECT creator FROM Creator creator";

	private static final String _SQL_SELECT_CREATOR_WHERE =
		"SELECT creator FROM Creator creator WHERE ";

	private static final String _SQL_COUNT_CREATOR =
		"SELECT COUNT(creator) FROM Creator creator";

	private static final String _SQL_COUNT_CREATOR_WHERE =
		"SELECT COUNT(creator) FROM Creator creator WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "creator.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Creator exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Creator exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CreatorPersistenceImpl.class);

}