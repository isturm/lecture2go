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

import de.uhh.l2g.plugins.exception.NoSuchTermException;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.impl.TermImpl;
import de.uhh.l2g.plugins.model.impl.TermModelImpl;
import de.uhh.l2g.plugins.service.persistence.TermPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the term service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class TermPersistenceImpl
	extends BasePersistenceImpl<Term> implements TermPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TermUtil</code> to access the term persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TermImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPrefix;
	private FinderPath _finderPathWithoutPaginationFindByPrefix;
	private FinderPath _finderPathCountByPrefix;

	/**
	 * Returns all the terms where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the matching terms
	 */
	@Override
	public List<Term> findByPrefix(String prefix) {
		return findByPrefix(prefix, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	@Override
	public List<Term> findByPrefix(String prefix, int start, int end) {
		return findByPrefix(prefix, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByPrefix(
		String prefix, int start, int end,
		OrderByComparator<Term> orderByComparator) {

		return findByPrefix(prefix, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms where prefix = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByPrefix(
		String prefix, int start, int end,
		OrderByComparator<Term> orderByComparator, boolean useFinderCache) {

		prefix = Objects.toString(prefix, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPrefix;
				finderArgs = new Object[] {prefix};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPrefix;
			finderArgs = new Object[] {prefix, start, end, orderByComparator};
		}

		List<Term> list = null;

		if (useFinderCache) {
			list = (List<Term>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Term term : list) {
					if (!prefix.equals(term.getPrefix())) {
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

			sb.append(_SQL_SELECT_TERM_WHERE);

			boolean bindPrefix = false;

			if (prefix.isEmpty()) {
				sb.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
			}
			else {
				bindPrefix = true;

				sb.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPrefix) {
					queryPos.add(prefix);
				}

				list = (List<Term>)QueryUtil.list(
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
	 * Returns the first term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByPrefix_First(
			String prefix, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByPrefix_First(prefix, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("prefix=");
		sb.append(prefix);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the first term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByPrefix_First(
		String prefix, OrderByComparator<Term> orderByComparator) {

		List<Term> list = findByPrefix(prefix, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByPrefix_Last(
			String prefix, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByPrefix_Last(prefix, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("prefix=");
		sb.append(prefix);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByPrefix_Last(
		String prefix, OrderByComparator<Term> orderByComparator) {

		int count = countByPrefix(prefix);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByPrefix(
			prefix, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where prefix = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param prefix the prefix
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term[] findByPrefix_PrevAndNext(
			long termId, String prefix,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		prefix = Objects.toString(prefix, "");

		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByPrefix_PrevAndNext(
				session, term, prefix, orderByComparator, true);

			array[1] = term;

			array[2] = getByPrefix_PrevAndNext(
				session, term, prefix, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Term getByPrefix_PrevAndNext(
		Session session, Term term, String prefix,
		OrderByComparator<Term> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TERM_WHERE);

		boolean bindPrefix = false;

		if (prefix.isEmpty()) {
			sb.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
		}
		else {
			bindPrefix = true;

			sb.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
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
			sb.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPrefix) {
			queryPos.add(prefix);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(term)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Term> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where prefix = &#63; from the database.
	 *
	 * @param prefix the prefix
	 */
	@Override
	public void removeByPrefix(String prefix) {
		for (Term term :
				findByPrefix(
					prefix, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(term);
		}
	}

	/**
	 * Returns the number of terms where prefix = &#63;.
	 *
	 * @param prefix the prefix
	 * @return the number of matching terms
	 */
	@Override
	public int countByPrefix(String prefix) {
		prefix = Objects.toString(prefix, "");

		FinderPath finderPath = _finderPathCountByPrefix;

		Object[] finderArgs = new Object[] {prefix};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TERM_WHERE);

			boolean bindPrefix = false;

			if (prefix.isEmpty()) {
				sb.append(_FINDER_COLUMN_PREFIX_PREFIX_3);
			}
			else {
				bindPrefix = true;

				sb.append(_FINDER_COLUMN_PREFIX_PREFIX_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPrefix) {
					queryPos.add(prefix);
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

	private static final String _FINDER_COLUMN_PREFIX_PREFIX_2 =
		"term.prefix = ?";

	private static final String _FINDER_COLUMN_PREFIX_PREFIX_3 =
		"(term.prefix IS NULL OR term.prefix = '')";

	private FinderPath _finderPathWithPaginationFindByYear;
	private FinderPath _finderPathWithoutPaginationFindByYear;
	private FinderPath _finderPathCountByYear;

	/**
	 * Returns all the terms where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching terms
	 */
	@Override
	public List<Term> findByYear(String year) {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	@Override
	public List<Term> findByYear(String year, int start, int end) {
		return findByYear(year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByYear(
		String year, int start, int end,
		OrderByComparator<Term> orderByComparator) {

		return findByYear(year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByYear(
		String year, int start, int end,
		OrderByComparator<Term> orderByComparator, boolean useFinderCache) {

		year = Objects.toString(year, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByYear;
				finderArgs = new Object[] {year};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByYear;
			finderArgs = new Object[] {year, start, end, orderByComparator};
		}

		List<Term> list = null;

		if (useFinderCache) {
			list = (List<Term>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Term term : list) {
					if (!year.equals(term.getYear())) {
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

			sb.append(_SQL_SELECT_TERM_WHERE);

			boolean bindYear = false;

			if (year.isEmpty()) {
				sb.append(_FINDER_COLUMN_YEAR_YEAR_3);
			}
			else {
				bindYear = true;

				sb.append(_FINDER_COLUMN_YEAR_YEAR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindYear) {
					queryPos.add(year);
				}

				list = (List<Term>)QueryUtil.list(
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
	 * Returns the first term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByYear_First(
			String year, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByYear_First(year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the first term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByYear_First(
		String year, OrderByComparator<Term> orderByComparator) {

		List<Term> list = findByYear(year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByYear_Last(
			String year, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByYear_Last(year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the last term in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByYear_Last(
		String year, OrderByComparator<Term> orderByComparator) {

		int count = countByYear(year);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByYear(year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where year = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term[] findByYear_PrevAndNext(
			long termId, String year, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		year = Objects.toString(year, "");

		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByYear_PrevAndNext(
				session, term, year, orderByComparator, true);

			array[1] = term;

			array[2] = getByYear_PrevAndNext(
				session, term, year, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Term getByYear_PrevAndNext(
		Session session, Term term, String year,
		OrderByComparator<Term> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TERM_WHERE);

		boolean bindYear = false;

		if (year.isEmpty()) {
			sb.append(_FINDER_COLUMN_YEAR_YEAR_3);
		}
		else {
			bindYear = true;

			sb.append(_FINDER_COLUMN_YEAR_YEAR_2);
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
			sb.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindYear) {
			queryPos.add(year);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(term)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Term> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	@Override
	public void removeByYear(String year) {
		for (Term term :
				findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(term);
		}
	}

	/**
	 * Returns the number of terms where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching terms
	 */
	@Override
	public int countByYear(String year) {
		year = Objects.toString(year, "");

		FinderPath finderPath = _finderPathCountByYear;

		Object[] finderArgs = new Object[] {year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TERM_WHERE);

			boolean bindYear = false;

			if (year.isEmpty()) {
				sb.append(_FINDER_COLUMN_YEAR_YEAR_3);
			}
			else {
				bindYear = true;

				sb.append(_FINDER_COLUMN_YEAR_YEAR_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindYear) {
					queryPos.add(year);
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

	private static final String _FINDER_COLUMN_YEAR_YEAR_2 = "term.year = ?";

	private static final String _FINDER_COLUMN_YEAR_YEAR_3 =
		"(term.year IS NULL OR term.year = '')";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the terms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching terms
	 */
	@Override
	public List<Term> findByGroup(long groupId) {
		return findByGroup(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	@Override
	public List<Term> findByGroup(long groupId, int start, int end) {
		return findByGroup(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Term> orderByComparator) {

		return findByGroup(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Term> orderByComparator, boolean useFinderCache) {

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

		List<Term> list = null;

		if (useFinderCache) {
			list = (List<Term>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Term term : list) {
					if (groupId != term.getGroupId()) {
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

			sb.append(_SQL_SELECT_TERM_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Term>)QueryUtil.list(
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
	 * Returns the first term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByGroup_First(
			long groupId, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByGroup_First(groupId, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the first term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByGroup_First(
		long groupId, OrderByComparator<Term> orderByComparator) {

		List<Term> list = findByGroup(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByGroup_Last(
			long groupId, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByGroup_Last(groupId, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the last term in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByGroup_Last(
		long groupId, OrderByComparator<Term> orderByComparator) {

		int count = countByGroup(groupId);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByGroup(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where groupId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term[] findByGroup_PrevAndNext(
			long termId, long groupId,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, term, groupId, orderByComparator, true);

			array[1] = term;

			array[2] = getByGroup_PrevAndNext(
				session, term, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Term getByGroup_PrevAndNext(
		Session session, Term term, long groupId,
		OrderByComparator<Term> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TERM_WHERE);

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
			sb.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(term)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Term> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroup(long groupId) {
		for (Term term :
				findByGroup(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(term);
		}
	}

	/**
	 * Returns the number of terms where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching terms
	 */
	@Override
	public int countByGroup(long groupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TERM_WHERE);

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
		"term.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByCompany;
	private FinderPath _finderPathWithoutPaginationFindByCompany;
	private FinderPath _finderPathCountByCompany;

	/**
	 * Returns all the terms where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching terms
	 */
	@Override
	public List<Term> findByCompany(long companyId) {
		return findByCompany(
			companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	@Override
	public List<Term> findByCompany(long companyId, int start, int end) {
		return findByCompany(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Term> orderByComparator) {

		return findByCompany(companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Term> orderByComparator, boolean useFinderCache) {

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

		List<Term> list = null;

		if (useFinderCache) {
			list = (List<Term>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Term term : list) {
					if (companyId != term.getCompanyId()) {
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

			sb.append(_SQL_SELECT_TERM_WHERE);

			sb.append(_FINDER_COLUMN_COMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				list = (List<Term>)QueryUtil.list(
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
	 * Returns the first term in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByCompany_First(
			long companyId, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByCompany_First(companyId, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the first term in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByCompany_First(
		long companyId, OrderByComparator<Term> orderByComparator) {

		List<Term> list = findByCompany(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByCompany_Last(
			long companyId, OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByCompany_Last(companyId, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the last term in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByCompany_Last(
		long companyId, OrderByComparator<Term> orderByComparator) {

		int count = countByCompany(companyId);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByCompany(
			companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where companyId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term[] findByCompany_PrevAndNext(
			long termId, long companyId,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByCompany_PrevAndNext(
				session, term, companyId, orderByComparator, true);

			array[1] = term;

			array[2] = getByCompany_PrevAndNext(
				session, term, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Term getByCompany_PrevAndNext(
		Session session, Term term, long companyId,
		OrderByComparator<Term> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TERM_WHERE);

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
			sb.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(term)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Term> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompany(long companyId) {
		for (Term term :
				findByCompany(
					companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(term);
		}
	}

	/**
	 * Returns the number of terms where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching terms
	 */
	@Override
	public int countByCompany(long companyId) {
		FinderPath finderPath = _finderPathCountByCompany;

		Object[] finderArgs = new Object[] {companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TERM_WHERE);

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
		"term.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupAndCompany;
	private FinderPath _finderPathWithoutPaginationFindByGroupAndCompany;
	private FinderPath _finderPathCountByGroupAndCompany;

	/**
	 * Returns all the terms where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching terms
	 */
	@Override
	public List<Term> findByGroupAndCompany(long groupId, long companyId) {
		return findByGroupAndCompany(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	@Override
	public List<Term> findByGroupAndCompany(
		long groupId, long companyId, int start, int end) {

		return findByGroupAndCompany(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Term> orderByComparator) {

		return findByGroupAndCompany(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Term> orderByComparator, boolean useFinderCache) {

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

		List<Term> list = null;

		if (useFinderCache) {
			list = (List<Term>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Term term : list) {
					if ((groupId != term.getGroupId()) ||
						(companyId != term.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TERM_WHERE);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<Term>)QueryUtil.list(
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
	 * Returns the first term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByGroupAndCompany_First(
			groupId, companyId, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the first term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Term> orderByComparator) {

		List<Term> list = findByGroupAndCompany(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByGroupAndCompany_Last(
			groupId, companyId, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the last term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Term> orderByComparator) {

		int count = countByGroupAndCompany(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByGroupAndCompany(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term[] findByGroupAndCompany_PrevAndNext(
			long termId, long groupId, long companyId,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByGroupAndCompany_PrevAndNext(
				session, term, groupId, companyId, orderByComparator, true);

			array[1] = term;

			array[2] = getByGroupAndCompany_PrevAndNext(
				session, term, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Term getByGroupAndCompany_PrevAndNext(
		Session session, Term term, long groupId, long companyId,
		OrderByComparator<Term> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TERM_WHERE);

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
			sb.append(TermModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(term)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Term> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupAndCompany(long groupId, long companyId) {
		for (Term term :
				findByGroupAndCompany(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(term);
		}
	}

	/**
	 * Returns the number of terms where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching terms
	 */
	@Override
	public int countByGroupAndCompany(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupAndCompany;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TERM_WHERE);

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
		"term.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPANDCOMPANY_COMPANYID_2 =
		"term.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPrefixAndYear;
	private FinderPath _finderPathWithoutPaginationFindByPrefixAndYear;
	private FinderPath _finderPathCountByPrefixAndYear;

	/**
	 * Returns all the terms where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @return the matching terms
	 */
	@Override
	public List<Term> findByPrefixAndYear(String prefix, String year) {
		return findByPrefixAndYear(
			prefix, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms where prefix = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of matching terms
	 */
	@Override
	public List<Term> findByPrefixAndYear(
		String prefix, String year, int start, int end) {

		return findByPrefixAndYear(prefix, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms where prefix = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByPrefixAndYear(
		String prefix, String year, int start, int end,
		OrderByComparator<Term> orderByComparator) {

		return findByPrefixAndYear(
			prefix, year, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms where prefix = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching terms
	 */
	@Override
	public List<Term> findByPrefixAndYear(
		String prefix, String year, int start, int end,
		OrderByComparator<Term> orderByComparator, boolean useFinderCache) {

		prefix = Objects.toString(prefix, "");
		year = Objects.toString(year, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPrefixAndYear;
				finderArgs = new Object[] {prefix, year};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPrefixAndYear;
			finderArgs = new Object[] {
				prefix, year, start, end, orderByComparator
			};
		}

		List<Term> list = null;

		if (useFinderCache) {
			list = (List<Term>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Term term : list) {
					if (!prefix.equals(term.getPrefix()) ||
						!year.equals(term.getYear())) {

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

			sb.append(_SQL_SELECT_TERM_WHERE);

			boolean bindPrefix = false;

			if (prefix.isEmpty()) {
				sb.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_3);
			}
			else {
				bindPrefix = true;

				sb.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_2);
			}

			boolean bindYear = false;

			if (year.isEmpty()) {
				sb.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_3);
			}
			else {
				bindYear = true;

				sb.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TermModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPrefix) {
					queryPos.add(prefix);
				}

				if (bindYear) {
					queryPos.add(year);
				}

				list = (List<Term>)QueryUtil.list(
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
	 * Returns the first term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByPrefixAndYear_First(
			String prefix, String year,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByPrefixAndYear_First(prefix, year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("prefix=");
		sb.append(prefix);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the first term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByPrefixAndYear_First(
		String prefix, String year, OrderByComparator<Term> orderByComparator) {

		List<Term> list = findByPrefixAndYear(
			prefix, year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term
	 * @throws NoSuchTermException if a matching term could not be found
	 */
	@Override
	public Term findByPrefixAndYear_Last(
			String prefix, String year,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		Term term = fetchByPrefixAndYear_Last(prefix, year, orderByComparator);

		if (term != null) {
			return term;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("prefix=");
		sb.append(prefix);

		sb.append(", year=");
		sb.append(year);

		sb.append("}");

		throw new NoSuchTermException(sb.toString());
	}

	/**
	 * Returns the last term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching term, or <code>null</code> if a matching term could not be found
	 */
	@Override
	public Term fetchByPrefixAndYear_Last(
		String prefix, String year, OrderByComparator<Term> orderByComparator) {

		int count = countByPrefixAndYear(prefix, year);

		if (count == 0) {
			return null;
		}

		List<Term> list = findByPrefixAndYear(
			prefix, year, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the terms before and after the current term in the ordered set where prefix = &#63; and year = &#63;.
	 *
	 * @param termId the primary key of the current term
	 * @param prefix the prefix
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term[] findByPrefixAndYear_PrevAndNext(
			long termId, String prefix, String year,
			OrderByComparator<Term> orderByComparator)
		throws NoSuchTermException {

		prefix = Objects.toString(prefix, "");
		year = Objects.toString(year, "");

		Term term = findByPrimaryKey(termId);

		Session session = null;

		try {
			session = openSession();

			Term[] array = new TermImpl[3];

			array[0] = getByPrefixAndYear_PrevAndNext(
				session, term, prefix, year, orderByComparator, true);

			array[1] = term;

			array[2] = getByPrefixAndYear_PrevAndNext(
				session, term, prefix, year, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Term getByPrefixAndYear_PrevAndNext(
		Session session, Term term, String prefix, String year,
		OrderByComparator<Term> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TERM_WHERE);

		boolean bindPrefix = false;

		if (prefix.isEmpty()) {
			sb.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_3);
		}
		else {
			bindPrefix = true;

			sb.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_2);
		}

		boolean bindYear = false;

		if (year.isEmpty()) {
			sb.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_3);
		}
		else {
			bindYear = true;

			sb.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_2);
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
			sb.append(TermModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPrefix) {
			queryPos.add(prefix);
		}

		if (bindYear) {
			queryPos.add(year);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(term)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Term> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the terms where prefix = &#63; and year = &#63; from the database.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 */
	@Override
	public void removeByPrefixAndYear(String prefix, String year) {
		for (Term term :
				findByPrefixAndYear(
					prefix, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(term);
		}
	}

	/**
	 * Returns the number of terms where prefix = &#63; and year = &#63;.
	 *
	 * @param prefix the prefix
	 * @param year the year
	 * @return the number of matching terms
	 */
	@Override
	public int countByPrefixAndYear(String prefix, String year) {
		prefix = Objects.toString(prefix, "");
		year = Objects.toString(year, "");

		FinderPath finderPath = _finderPathCountByPrefixAndYear;

		Object[] finderArgs = new Object[] {prefix, year};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TERM_WHERE);

			boolean bindPrefix = false;

			if (prefix.isEmpty()) {
				sb.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_3);
			}
			else {
				bindPrefix = true;

				sb.append(_FINDER_COLUMN_PREFIXANDYEAR_PREFIX_2);
			}

			boolean bindYear = false;

			if (year.isEmpty()) {
				sb.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_3);
			}
			else {
				bindYear = true;

				sb.append(_FINDER_COLUMN_PREFIXANDYEAR_YEAR_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPrefix) {
					queryPos.add(prefix);
				}

				if (bindYear) {
					queryPos.add(year);
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

	private static final String _FINDER_COLUMN_PREFIXANDYEAR_PREFIX_2 =
		"term.prefix = ? AND ";

	private static final String _FINDER_COLUMN_PREFIXANDYEAR_PREFIX_3 =
		"(term.prefix IS NULL OR term.prefix = '') AND ";

	private static final String _FINDER_COLUMN_PREFIXANDYEAR_YEAR_2 =
		"term.year = ?";

	private static final String _FINDER_COLUMN_PREFIXANDYEAR_YEAR_3 =
		"(term.year IS NULL OR term.year = '')";

	public TermPersistenceImpl() {
		setModelClass(Term.class);

		setModelImplClass(TermImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(TermModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the term in the entity cache if it is enabled.
	 *
	 * @param term the term
	 */
	@Override
	public void cacheResult(Term term) {
		entityCache.putResult(
			TermModelImpl.ENTITY_CACHE_ENABLED, TermImpl.class,
			term.getPrimaryKey(), term);

		term.resetOriginalValues();
	}

	/**
	 * Caches the terms in the entity cache if it is enabled.
	 *
	 * @param terms the terms
	 */
	@Override
	public void cacheResult(List<Term> terms) {
		for (Term term : terms) {
			if (entityCache.getResult(
					TermModelImpl.ENTITY_CACHE_ENABLED, TermImpl.class,
					term.getPrimaryKey()) == null) {

				cacheResult(term);
			}
			else {
				term.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all terms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TermImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the term.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Term term) {
		entityCache.removeResult(
			TermModelImpl.ENTITY_CACHE_ENABLED, TermImpl.class,
			term.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Term> terms) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Term term : terms) {
			entityCache.removeResult(
				TermModelImpl.ENTITY_CACHE_ENABLED, TermImpl.class,
				term.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TermModelImpl.ENTITY_CACHE_ENABLED, TermImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new term with the primary key. Does not add the term to the database.
	 *
	 * @param termId the primary key for the new term
	 * @return the new term
	 */
	@Override
	public Term create(long termId) {
		Term term = new TermImpl();

		term.setNew(true);
		term.setPrimaryKey(termId);

		term.setCompanyId(CompanyThreadLocal.getCompanyId());

		return term;
	}

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param termId the primary key of the term
	 * @return the term that was removed
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term remove(long termId) throws NoSuchTermException {
		return remove((Serializable)termId);
	}

	/**
	 * Removes the term with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term that was removed
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term remove(Serializable primaryKey) throws NoSuchTermException {
		Session session = null;

		try {
			session = openSession();

			Term term = (Term)session.get(TermImpl.class, primaryKey);

			if (term == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTermException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(term);
		}
		catch (NoSuchTermException noSuchEntityException) {
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
	protected Term removeImpl(Term term) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(term)) {
				term = (Term)session.get(
					TermImpl.class, term.getPrimaryKeyObj());
			}

			if (term != null) {
				session.delete(term);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (term != null) {
			clearCache(term);
		}

		return term;
	}

	@Override
	public Term updateImpl(Term term) {
		boolean isNew = term.isNew();

		if (!(term instanceof TermModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(term.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(term);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in term proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Term implementation " +
					term.getClass());
		}

		TermModelImpl termModelImpl = (TermModelImpl)term;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (term.getCreateDate() == null)) {
			if (serviceContext == null) {
				term.setCreateDate(now);
			}
			else {
				term.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!termModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				term.setModifiedDate(now);
			}
			else {
				term.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (term.isNew()) {
				session.save(term);

				term.setNew(false);
			}
			else {
				term = (Term)session.merge(term);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!TermModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {termModelImpl.getPrefix()};

			finderCache.removeResult(_finderPathCountByPrefix, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPrefix, args);

			args = new Object[] {termModelImpl.getYear()};

			finderCache.removeResult(_finderPathCountByYear, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByYear, args);

			args = new Object[] {termModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			args = new Object[] {termModelImpl.getCompanyId()};

			finderCache.removeResult(_finderPathCountByCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCompany, args);

			args = new Object[] {
				termModelImpl.getGroupId(), termModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByGroupAndCompany, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupAndCompany, args);

			args = new Object[] {
				termModelImpl.getPrefix(), termModelImpl.getYear()
			};

			finderCache.removeResult(_finderPathCountByPrefixAndYear, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPrefixAndYear, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((termModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPrefix.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					termModelImpl.getOriginalPrefix()
				};

				finderCache.removeResult(_finderPathCountByPrefix, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPrefix, args);

				args = new Object[] {termModelImpl.getPrefix()};

				finderCache.removeResult(_finderPathCountByPrefix, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPrefix, args);
			}

			if ((termModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByYear.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {termModelImpl.getOriginalYear()};

				finderCache.removeResult(_finderPathCountByYear, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByYear, args);

				args = new Object[] {termModelImpl.getYear()};

				finderCache.removeResult(_finderPathCountByYear, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByYear, args);
			}

			if ((termModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					termModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {termModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}

			if ((termModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					termModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);

				args = new Object[] {termModelImpl.getCompanyId()};

				finderCache.removeResult(_finderPathCountByCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCompany, args);
			}

			if ((termModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupAndCompany.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					termModelImpl.getOriginalGroupId(),
					termModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);

				args = new Object[] {
					termModelImpl.getGroupId(), termModelImpl.getCompanyId()
				};

				finderCache.removeResult(
					_finderPathCountByGroupAndCompany, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupAndCompany, args);
			}

			if ((termModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPrefixAndYear.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					termModelImpl.getOriginalPrefix(),
					termModelImpl.getOriginalYear()
				};

				finderCache.removeResult(_finderPathCountByPrefixAndYear, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPrefixAndYear, args);

				args = new Object[] {
					termModelImpl.getPrefix(), termModelImpl.getYear()
				};

				finderCache.removeResult(_finderPathCountByPrefixAndYear, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPrefixAndYear, args);
			}
		}

		entityCache.putResult(
			TermModelImpl.ENTITY_CACHE_ENABLED, TermImpl.class,
			term.getPrimaryKey(), term, false);

		term.resetOriginalValues();

		return term;
	}

	/**
	 * Returns the term with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the term
	 * @return the term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTermException {

		Term term = fetchByPrimaryKey(primaryKey);

		if (term == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTermException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return term;
	}

	/**
	 * Returns the term with the primary key or throws a <code>NoSuchTermException</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term
	 * @throws NoSuchTermException if a term with the primary key could not be found
	 */
	@Override
	public Term findByPrimaryKey(long termId) throws NoSuchTermException {
		return findByPrimaryKey((Serializable)termId);
	}

	/**
	 * Returns the term with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param termId the primary key of the term
	 * @return the term, or <code>null</code> if a term with the primary key could not be found
	 */
	@Override
	public Term fetchByPrimaryKey(long termId) {
		return fetchByPrimaryKey((Serializable)termId);
	}

	/**
	 * Returns all the terms.
	 *
	 * @return the terms
	 */
	@Override
	public List<Term> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @return the range of terms
	 */
	@Override
	public List<Term> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of terms
	 */
	@Override
	public List<Term> findAll(
		int start, int end, OrderByComparator<Term> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the terms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TermModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terms
	 * @param end the upper bound of the range of terms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of terms
	 */
	@Override
	public List<Term> findAll(
		int start, int end, OrderByComparator<Term> orderByComparator,
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

		List<Term> list = null;

		if (useFinderCache) {
			list = (List<Term>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TERM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TERM;

				sql = sql.concat(TermModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Term>)QueryUtil.list(
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
	 * Removes all the terms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Term term : findAll()) {
			remove(term);
		}
	}

	/**
	 * Returns the number of terms.
	 *
	 * @return the number of terms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TERM);

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
		return "termId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TERM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TermModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the term persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByPrefix = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrefix",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPrefix = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrefix",
			new String[] {String.class.getName()},
			TermModelImpl.PREFIX_COLUMN_BITMASK |
			TermModelImpl.YEAR_COLUMN_BITMASK);

		_finderPathCountByPrefix = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrefix",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByYear = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByYear",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByYear = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] {String.class.getName()},
			TermModelImpl.YEAR_COLUMN_BITMASK);

		_finderPathCountByYear = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			TermModelImpl.GROUPID_COLUMN_BITMASK |
			TermModelImpl.YEAR_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCompany = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompany",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCompany = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompany",
			new String[] {Long.class.getName()},
			TermModelImpl.COMPANYID_COLUMN_BITMASK |
			TermModelImpl.YEAR_COLUMN_BITMASK);

		_finderPathCountByCompany = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompany",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupAndCompany = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupAndCompany",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupAndCompany = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()},
			TermModelImpl.GROUPID_COLUMN_BITMASK |
			TermModelImpl.COMPANYID_COLUMN_BITMASK |
			TermModelImpl.YEAR_COLUMN_BITMASK);

		_finderPathCountByGroupAndCompany = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupAndCompany",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByPrefixAndYear = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPrefixAndYear",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPrefixAndYear = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, TermImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPrefixAndYear",
			new String[] {String.class.getName(), String.class.getName()},
			TermModelImpl.PREFIX_COLUMN_BITMASK |
			TermModelImpl.YEAR_COLUMN_BITMASK);

		_finderPathCountByPrefixAndYear = new FinderPath(
			TermModelImpl.ENTITY_CACHE_ENABLED,
			TermModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPrefixAndYear",
			new String[] {String.class.getName(), String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(TermImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TERM = "SELECT term FROM Term term";

	private static final String _SQL_SELECT_TERM_WHERE =
		"SELECT term FROM Term term WHERE ";

	private static final String _SQL_COUNT_TERM =
		"SELECT COUNT(term) FROM Term term";

	private static final String _SQL_COUNT_TERM_WHERE =
		"SELECT COUNT(term) FROM Term term WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "term.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Term exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Term exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TermPersistenceImpl.class);

}