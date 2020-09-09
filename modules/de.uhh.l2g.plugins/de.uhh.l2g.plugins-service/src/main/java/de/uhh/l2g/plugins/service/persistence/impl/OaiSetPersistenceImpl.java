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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchOaiSetException;
import de.uhh.l2g.plugins.model.OaiSet;
import de.uhh.l2g.plugins.model.impl.OaiSetImpl;
import de.uhh.l2g.plugins.model.impl.OaiSetModelImpl;
import de.uhh.l2g.plugins.service.persistence.OaiSetPersistence;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the oai set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class OaiSetPersistenceImpl
	extends BasePersistenceImpl<OaiSet> implements OaiSetPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OaiSetUtil</code> to access the oai set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OaiSetImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public OaiSetPersistenceImpl() {
		setModelClass(OaiSet.class);

		setModelImplClass(OaiSetImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(OaiSetModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the oai set in the entity cache if it is enabled.
	 *
	 * @param oaiSet the oai set
	 */
	@Override
	public void cacheResult(OaiSet oaiSet) {
		entityCache.putResult(
			OaiSetModelImpl.ENTITY_CACHE_ENABLED, OaiSetImpl.class,
			oaiSet.getPrimaryKey(), oaiSet);

		oaiSet.resetOriginalValues();
	}

	/**
	 * Caches the oai sets in the entity cache if it is enabled.
	 *
	 * @param oaiSets the oai sets
	 */
	@Override
	public void cacheResult(List<OaiSet> oaiSets) {
		for (OaiSet oaiSet : oaiSets) {
			if (entityCache.getResult(
					OaiSetModelImpl.ENTITY_CACHE_ENABLED, OaiSetImpl.class,
					oaiSet.getPrimaryKey()) == null) {

				cacheResult(oaiSet);
			}
			else {
				oaiSet.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all oai sets.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OaiSetImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the oai set.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OaiSet oaiSet) {
		entityCache.removeResult(
			OaiSetModelImpl.ENTITY_CACHE_ENABLED, OaiSetImpl.class,
			oaiSet.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OaiSet> oaiSets) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OaiSet oaiSet : oaiSets) {
			entityCache.removeResult(
				OaiSetModelImpl.ENTITY_CACHE_ENABLED, OaiSetImpl.class,
				oaiSet.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				OaiSetModelImpl.ENTITY_CACHE_ENABLED, OaiSetImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new oai set with the primary key. Does not add the oai set to the database.
	 *
	 * @param oaiSetId the primary key for the new oai set
	 * @return the new oai set
	 */
	@Override
	public OaiSet create(long oaiSetId) {
		OaiSet oaiSet = new OaiSetImpl();

		oaiSet.setNew(true);
		oaiSet.setPrimaryKey(oaiSetId);

		return oaiSet;
	}

	/**
	 * Removes the oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set that was removed
	 * @throws NoSuchOaiSetException if a oai set with the primary key could not be found
	 */
	@Override
	public OaiSet remove(long oaiSetId) throws NoSuchOaiSetException {
		return remove((Serializable)oaiSetId);
	}

	/**
	 * Removes the oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the oai set
	 * @return the oai set that was removed
	 * @throws NoSuchOaiSetException if a oai set with the primary key could not be found
	 */
	@Override
	public OaiSet remove(Serializable primaryKey) throws NoSuchOaiSetException {
		Session session = null;

		try {
			session = openSession();

			OaiSet oaiSet = (OaiSet)session.get(OaiSetImpl.class, primaryKey);

			if (oaiSet == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOaiSetException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(oaiSet);
		}
		catch (NoSuchOaiSetException noSuchEntityException) {
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
	protected OaiSet removeImpl(OaiSet oaiSet) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(oaiSet)) {
				oaiSet = (OaiSet)session.get(
					OaiSetImpl.class, oaiSet.getPrimaryKeyObj());
			}

			if (oaiSet != null) {
				session.delete(oaiSet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (oaiSet != null) {
			clearCache(oaiSet);
		}

		return oaiSet;
	}

	@Override
	public OaiSet updateImpl(OaiSet oaiSet) {
		boolean isNew = oaiSet.isNew();

		Session session = null;

		try {
			session = openSession();

			if (oaiSet.isNew()) {
				session.save(oaiSet);

				oaiSet.setNew(false);
			}
			else {
				oaiSet = (OaiSet)session.merge(oaiSet);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			OaiSetModelImpl.ENTITY_CACHE_ENABLED, OaiSetImpl.class,
			oaiSet.getPrimaryKey(), oaiSet, false);

		oaiSet.resetOriginalValues();

		return oaiSet;
	}

	/**
	 * Returns the oai set with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai set
	 * @return the oai set
	 * @throws NoSuchOaiSetException if a oai set with the primary key could not be found
	 */
	@Override
	public OaiSet findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOaiSetException {

		OaiSet oaiSet = fetchByPrimaryKey(primaryKey);

		if (oaiSet == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOaiSetException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return oaiSet;
	}

	/**
	 * Returns the oai set with the primary key or throws a <code>NoSuchOaiSetException</code> if it could not be found.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set
	 * @throws NoSuchOaiSetException if a oai set with the primary key could not be found
	 */
	@Override
	public OaiSet findByPrimaryKey(long oaiSetId) throws NoSuchOaiSetException {
		return findByPrimaryKey((Serializable)oaiSetId);
	}

	/**
	 * Returns the oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set, or <code>null</code> if a oai set with the primary key could not be found
	 */
	@Override
	public OaiSet fetchByPrimaryKey(long oaiSetId) {
		return fetchByPrimaryKey((Serializable)oaiSetId);
	}

	/**
	 * Returns all the oai sets.
	 *
	 * @return the oai sets
	 */
	@Override
	public List<OaiSet> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @return the range of oai sets
	 */
	@Override
	public List<OaiSet> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai sets
	 */
	@Override
	public List<OaiSet> findAll(
		int start, int end, OrderByComparator<OaiSet> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai sets
	 * @param end the upper bound of the range of oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oai sets
	 */
	@Override
	public List<OaiSet> findAll(
		int start, int end, OrderByComparator<OaiSet> orderByComparator,
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

		List<OaiSet> list = null;

		if (useFinderCache) {
			list = (List<OaiSet>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OAISET);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OAISET;

				sql = sql.concat(OaiSetModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OaiSet>)QueryUtil.list(
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
	 * Removes all the oai sets from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OaiSet oaiSet : findAll()) {
			remove(oaiSet);
		}
	}

	/**
	 * Returns the number of oai sets.
	 *
	 * @return the number of oai sets
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OAISET);

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
		return "oaiSetId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OAISET;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OaiSetModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the oai set persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetModelImpl.FINDER_CACHE_ENABLED, OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetModelImpl.FINDER_CACHE_ENABLED, OaiSetImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			OaiSetModelImpl.ENTITY_CACHE_ENABLED,
			OaiSetModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(OaiSetImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OAISET =
		"SELECT oaiSet FROM OaiSet oaiSet";

	private static final String _SQL_COUNT_OAISET =
		"SELECT COUNT(oaiSet) FROM OaiSet oaiSet";

	private static final String _ORDER_BY_ENTITY_ALIAS = "oaiSet.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OaiSet exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		OaiSetPersistenceImpl.class);

}