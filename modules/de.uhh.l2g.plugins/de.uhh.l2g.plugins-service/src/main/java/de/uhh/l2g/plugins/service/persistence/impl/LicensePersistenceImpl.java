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

import de.uhh.l2g.plugins.exception.NoSuchLicenseException;
import de.uhh.l2g.plugins.model.License;
import de.uhh.l2g.plugins.model.impl.LicenseImpl;
import de.uhh.l2g.plugins.model.impl.LicenseModelImpl;
import de.uhh.l2g.plugins.service.persistence.LicensePersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the license service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class LicensePersistenceImpl
	extends BasePersistenceImpl<License> implements LicensePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LicenseUtil</code> to access the license persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LicenseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBySelectable;
	private FinderPath _finderPathWithoutPaginationFindBySelectable;
	private FinderPath _finderPathCountBySelectable;

	/**
	 * Returns all the licenses where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @return the matching licenses
	 */
	@Override
	public List<License> findBySelectable(boolean selectable) {
		return findBySelectable(
			selectable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of matching licenses
	 */
	@Override
	public List<License> findBySelectable(
		boolean selectable, int start, int end) {

		return findBySelectable(selectable, start, end, null);
	}

	/**
	 * Returns an ordered range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licenses
	 */
	@Override
	public List<License> findBySelectable(
		boolean selectable, int start, int end,
		OrderByComparator<License> orderByComparator) {

		return findBySelectable(
			selectable, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the licenses where selectable = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param selectable the selectable
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching licenses
	 */
	@Override
	public List<License> findBySelectable(
		boolean selectable, int start, int end,
		OrderByComparator<License> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySelectable;
				finderArgs = new Object[] {selectable};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySelectable;
			finderArgs = new Object[] {
				selectable, start, end, orderByComparator
			};
		}

		List<License> list = null;

		if (useFinderCache) {
			list = (List<License>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (License license : list) {
					if (selectable != license.isSelectable()) {
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

			sb.append(_SQL_SELECT_LICENSE_WHERE);

			sb.append(_FINDER_COLUMN_SELECTABLE_SELECTABLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LicenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(selectable);

				list = (List<License>)QueryUtil.list(
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
	 * Returns the first license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching license
	 * @throws NoSuchLicenseException if a matching license could not be found
	 */
	@Override
	public License findBySelectable_First(
			boolean selectable, OrderByComparator<License> orderByComparator)
		throws NoSuchLicenseException {

		License license = fetchBySelectable_First(
			selectable, orderByComparator);

		if (license != null) {
			return license;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("selectable=");
		sb.append(selectable);

		sb.append("}");

		throw new NoSuchLicenseException(sb.toString());
	}

	/**
	 * Returns the first license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching license, or <code>null</code> if a matching license could not be found
	 */
	@Override
	public License fetchBySelectable_First(
		boolean selectable, OrderByComparator<License> orderByComparator) {

		List<License> list = findBySelectable(
			selectable, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching license
	 * @throws NoSuchLicenseException if a matching license could not be found
	 */
	@Override
	public License findBySelectable_Last(
			boolean selectable, OrderByComparator<License> orderByComparator)
		throws NoSuchLicenseException {

		License license = fetchBySelectable_Last(selectable, orderByComparator);

		if (license != null) {
			return license;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("selectable=");
		sb.append(selectable);

		sb.append("}");

		throw new NoSuchLicenseException(sb.toString());
	}

	/**
	 * Returns the last license in the ordered set where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching license, or <code>null</code> if a matching license could not be found
	 */
	@Override
	public License fetchBySelectable_Last(
		boolean selectable, OrderByComparator<License> orderByComparator) {

		int count = countBySelectable(selectable);

		if (count == 0) {
			return null;
		}

		List<License> list = findBySelectable(
			selectable, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the licenses before and after the current license in the ordered set where selectable = &#63;.
	 *
	 * @param licenseId the primary key of the current license
	 * @param selectable the selectable
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License[] findBySelectable_PrevAndNext(
			long licenseId, boolean selectable,
			OrderByComparator<License> orderByComparator)
		throws NoSuchLicenseException {

		License license = findByPrimaryKey(licenseId);

		Session session = null;

		try {
			session = openSession();

			License[] array = new LicenseImpl[3];

			array[0] = getBySelectable_PrevAndNext(
				session, license, selectable, orderByComparator, true);

			array[1] = license;

			array[2] = getBySelectable_PrevAndNext(
				session, license, selectable, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected License getBySelectable_PrevAndNext(
		Session session, License license, boolean selectable,
		OrderByComparator<License> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LICENSE_WHERE);

		sb.append(_FINDER_COLUMN_SELECTABLE_SELECTABLE_2);

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
			sb.append(LicenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(selectable);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(license)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<License> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the licenses where selectable = &#63; from the database.
	 *
	 * @param selectable the selectable
	 */
	@Override
	public void removeBySelectable(boolean selectable) {
		for (License license :
				findBySelectable(
					selectable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(license);
		}
	}

	/**
	 * Returns the number of licenses where selectable = &#63;.
	 *
	 * @param selectable the selectable
	 * @return the number of matching licenses
	 */
	@Override
	public int countBySelectable(boolean selectable) {
		FinderPath finderPath = _finderPathCountBySelectable;

		Object[] finderArgs = new Object[] {selectable};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LICENSE_WHERE);

			sb.append(_FINDER_COLUMN_SELECTABLE_SELECTABLE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(selectable);

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

	private static final String _FINDER_COLUMN_SELECTABLE_SELECTABLE_2 =
		"license.selectable = ?";

	public LicensePersistenceImpl() {
		setModelClass(License.class);

		setModelImplClass(LicenseImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(LicenseModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the license in the entity cache if it is enabled.
	 *
	 * @param license the license
	 */
	@Override
	public void cacheResult(License license) {
		entityCache.putResult(
			LicenseModelImpl.ENTITY_CACHE_ENABLED, LicenseImpl.class,
			license.getPrimaryKey(), license);

		license.resetOriginalValues();
	}

	/**
	 * Caches the licenses in the entity cache if it is enabled.
	 *
	 * @param licenses the licenses
	 */
	@Override
	public void cacheResult(List<License> licenses) {
		for (License license : licenses) {
			if (entityCache.getResult(
					LicenseModelImpl.ENTITY_CACHE_ENABLED, LicenseImpl.class,
					license.getPrimaryKey()) == null) {

				cacheResult(license);
			}
			else {
				license.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all licenses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LicenseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the license.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(License license) {
		entityCache.removeResult(
			LicenseModelImpl.ENTITY_CACHE_ENABLED, LicenseImpl.class,
			license.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<License> licenses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (License license : licenses) {
			entityCache.removeResult(
				LicenseModelImpl.ENTITY_CACHE_ENABLED, LicenseImpl.class,
				license.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				LicenseModelImpl.ENTITY_CACHE_ENABLED, LicenseImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new license with the primary key. Does not add the license to the database.
	 *
	 * @param licenseId the primary key for the new license
	 * @return the new license
	 */
	@Override
	public License create(long licenseId) {
		License license = new LicenseImpl();

		license.setNew(true);
		license.setPrimaryKey(licenseId);

		return license;
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license that was removed
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License remove(long licenseId) throws NoSuchLicenseException {
		return remove((Serializable)licenseId);
	}

	/**
	 * Removes the license with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license that was removed
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License remove(Serializable primaryKey)
		throws NoSuchLicenseException {

		Session session = null;

		try {
			session = openSession();

			License license = (License)session.get(
				LicenseImpl.class, primaryKey);

			if (license == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLicenseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(license);
		}
		catch (NoSuchLicenseException noSuchEntityException) {
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
	protected License removeImpl(License license) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(license)) {
				license = (License)session.get(
					LicenseImpl.class, license.getPrimaryKeyObj());
			}

			if (license != null) {
				session.delete(license);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (license != null) {
			clearCache(license);
		}

		return license;
	}

	@Override
	public License updateImpl(License license) {
		boolean isNew = license.isNew();

		if (!(license instanceof LicenseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(license.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(license);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in license proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom License implementation " +
					license.getClass());
		}

		LicenseModelImpl licenseModelImpl = (LicenseModelImpl)license;

		Session session = null;

		try {
			session = openSession();

			if (license.isNew()) {
				session.save(license);

				license.setNew(false);
			}
			else {
				license = (License)session.merge(license);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!LicenseModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {licenseModelImpl.isSelectable()};

			finderCache.removeResult(_finderPathCountBySelectable, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySelectable, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((licenseModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySelectable.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					licenseModelImpl.getOriginalSelectable()
				};

				finderCache.removeResult(_finderPathCountBySelectable, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySelectable, args);

				args = new Object[] {licenseModelImpl.isSelectable()};

				finderCache.removeResult(_finderPathCountBySelectable, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySelectable, args);
			}
		}

		entityCache.putResult(
			LicenseModelImpl.ENTITY_CACHE_ENABLED, LicenseImpl.class,
			license.getPrimaryKey(), license, false);

		license.resetOriginalValues();

		return license;
	}

	/**
	 * Returns the license with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the license
	 * @return the license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLicenseException {

		License license = fetchByPrimaryKey(primaryKey);

		if (license == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLicenseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return license;
	}

	/**
	 * Returns the license with the primary key or throws a <code>NoSuchLicenseException</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license
	 * @throws NoSuchLicenseException if a license with the primary key could not be found
	 */
	@Override
	public License findByPrimaryKey(long licenseId)
		throws NoSuchLicenseException {

		return findByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns the license with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param licenseId the primary key of the license
	 * @return the license, or <code>null</code> if a license with the primary key could not be found
	 */
	@Override
	public License fetchByPrimaryKey(long licenseId) {
		return fetchByPrimaryKey((Serializable)licenseId);
	}

	/**
	 * Returns all the licenses.
	 *
	 * @return the licenses
	 */
	@Override
	public List<License> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @return the range of licenses
	 */
	@Override
	public List<License> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licenses
	 */
	@Override
	public List<License> findAll(
		int start, int end, OrderByComparator<License> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the licenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LicenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of licenses
	 * @param end the upper bound of the range of licenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of licenses
	 */
	@Override
	public List<License> findAll(
		int start, int end, OrderByComparator<License> orderByComparator,
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

		List<License> list = null;

		if (useFinderCache) {
			list = (List<License>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LICENSE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LICENSE;

				sql = sql.concat(LicenseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<License>)QueryUtil.list(
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
	 * Removes all the licenses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (License license : findAll()) {
			remove(license);
		}
	}

	/**
	 * Returns the number of licenses.
	 *
	 * @return the number of licenses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LICENSE);

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
		return "licenseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LICENSE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LicenseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the license persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBySelectable = new FinderPath(
			LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySelectable",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySelectable = new FinderPath(
			LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, LicenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySelectable",
			new String[] {Boolean.class.getName()},
			LicenseModelImpl.SELECTABLE_COLUMN_BITMASK);

		_finderPathCountBySelectable = new FinderPath(
			LicenseModelImpl.ENTITY_CACHE_ENABLED,
			LicenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySelectable",
			new String[] {Boolean.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(LicenseImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LICENSE =
		"SELECT license FROM License license";

	private static final String _SQL_SELECT_LICENSE_WHERE =
		"SELECT license FROM License license WHERE ";

	private static final String _SQL_COUNT_LICENSE =
		"SELECT COUNT(license) FROM License license";

	private static final String _SQL_COUNT_LICENSE_WHERE =
		"SELECT COUNT(license) FROM License license WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "license.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No License exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No License exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LicensePersistenceImpl.class);

}