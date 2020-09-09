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

import de.uhh.l2g.plugins.exception.NoSuchOaiRecordException;
import de.uhh.l2g.plugins.model.OaiRecord;
import de.uhh.l2g.plugins.model.impl.OaiRecordImpl;
import de.uhh.l2g.plugins.model.impl.OaiRecordModelImpl;
import de.uhh.l2g.plugins.service.persistence.OaiRecordPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the oai record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class OaiRecordPersistenceImpl
	extends BasePersistenceImpl<OaiRecord> implements OaiRecordPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OaiRecordUtil</code> to access the oai record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OaiRecordImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByVideo;
	private FinderPath _finderPathCountByVideo;

	/**
	 * Returns the oai record where videoId = &#63; or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param videoId the video ID
	 * @return the matching oai record
	 * @throws NoSuchOaiRecordException if a matching oai record could not be found
	 */
	@Override
	public OaiRecord findByVideo(long videoId) throws NoSuchOaiRecordException {
		OaiRecord oaiRecord = fetchByVideo(videoId);

		if (oaiRecord == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("videoId=");
			sb.append(videoId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchOaiRecordException(sb.toString());
		}

		return oaiRecord;
	}

	/**
	 * Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param videoId the video ID
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	@Override
	public OaiRecord fetchByVideo(long videoId) {
		return fetchByVideo(videoId, true);
	}

	/**
	 * Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param videoId the video ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	@Override
	public OaiRecord fetchByVideo(long videoId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {videoId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByVideo, finderArgs, this);
		}

		if (result instanceof OaiRecord) {
			OaiRecord oaiRecord = (OaiRecord)result;

			if (videoId != oaiRecord.getVideoId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_OAIRECORD_WHERE);

			sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

				List<OaiRecord> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByVideo, finderArgs, list);
					}
				}
				else {
					OaiRecord oaiRecord = list.get(0);

					result = oaiRecord;

					cacheResult(oaiRecord);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByVideo, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (OaiRecord)result;
		}
	}

	/**
	 * Removes the oai record where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @return the oai record that was removed
	 */
	@Override
	public OaiRecord removeByVideo(long videoId)
		throws NoSuchOaiRecordException {

		OaiRecord oaiRecord = findByVideo(videoId);

		return remove(oaiRecord);
	}

	/**
	 * Returns the number of oai records where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching oai records
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = _finderPathCountByVideo;

		Object[] finderArgs = new Object[] {videoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OAIRECORD_WHERE);

			sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 =
		"oaiRecord.videoId = ?";

	private FinderPath _finderPathFetchByIdentifier;
	private FinderPath _finderPathCountByIdentifier;

	/**
	 * Returns the oai record where identifier = &#63; or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param identifier the identifier
	 * @return the matching oai record
	 * @throws NoSuchOaiRecordException if a matching oai record could not be found
	 */
	@Override
	public OaiRecord findByIdentifier(String identifier)
		throws NoSuchOaiRecordException {

		OaiRecord oaiRecord = fetchByIdentifier(identifier);

		if (oaiRecord == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("identifier=");
			sb.append(identifier);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchOaiRecordException(sb.toString());
		}

		return oaiRecord;
	}

	/**
	 * Returns the oai record where identifier = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param identifier the identifier
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	@Override
	public OaiRecord fetchByIdentifier(String identifier) {
		return fetchByIdentifier(identifier, true);
	}

	/**
	 * Returns the oai record where identifier = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param identifier the identifier
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	@Override
	public OaiRecord fetchByIdentifier(
		String identifier, boolean useFinderCache) {

		identifier = Objects.toString(identifier, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {identifier};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByIdentifier, finderArgs, this);
		}

		if (result instanceof OaiRecord) {
			OaiRecord oaiRecord = (OaiRecord)result;

			if (!Objects.equals(identifier, oaiRecord.getIdentifier())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_OAIRECORD_WHERE);

			boolean bindIdentifier = false;

			if (identifier.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_3);
			}
			else {
				bindIdentifier = true;

				sb.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdentifier) {
					queryPos.add(identifier);
				}

				List<OaiRecord> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByIdentifier, finderArgs, list);
					}
				}
				else {
					OaiRecord oaiRecord = list.get(0);

					result = oaiRecord;

					cacheResult(oaiRecord);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByIdentifier, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (OaiRecord)result;
		}
	}

	/**
	 * Removes the oai record where identifier = &#63; from the database.
	 *
	 * @param identifier the identifier
	 * @return the oai record that was removed
	 */
	@Override
	public OaiRecord removeByIdentifier(String identifier)
		throws NoSuchOaiRecordException {

		OaiRecord oaiRecord = findByIdentifier(identifier);

		return remove(oaiRecord);
	}

	/**
	 * Returns the number of oai records where identifier = &#63;.
	 *
	 * @param identifier the identifier
	 * @return the number of matching oai records
	 */
	@Override
	public int countByIdentifier(String identifier) {
		identifier = Objects.toString(identifier, "");

		FinderPath finderPath = _finderPathCountByIdentifier;

		Object[] finderArgs = new Object[] {identifier};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OAIRECORD_WHERE);

			boolean bindIdentifier = false;

			if (identifier.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_3);
			}
			else {
				bindIdentifier = true;

				sb.append(_FINDER_COLUMN_IDENTIFIER_IDENTIFIER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdentifier) {
					queryPos.add(identifier);
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

	private static final String _FINDER_COLUMN_IDENTIFIER_IDENTIFIER_2 =
		"oaiRecord.identifier = ?";

	private static final String _FINDER_COLUMN_IDENTIFIER_IDENTIFIER_3 =
		"(oaiRecord.identifier IS NULL OR oaiRecord.identifier = '')";

	public OaiRecordPersistenceImpl() {
		setModelClass(OaiRecord.class);

		setModelImplClass(OaiRecordImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(OaiRecordModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the oai record in the entity cache if it is enabled.
	 *
	 * @param oaiRecord the oai record
	 */
	@Override
	public void cacheResult(OaiRecord oaiRecord) {
		entityCache.putResult(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED, OaiRecordImpl.class,
			oaiRecord.getPrimaryKey(), oaiRecord);

		finderCache.putResult(
			_finderPathFetchByVideo, new Object[] {oaiRecord.getVideoId()},
			oaiRecord);

		finderCache.putResult(
			_finderPathFetchByIdentifier,
			new Object[] {oaiRecord.getIdentifier()}, oaiRecord);

		oaiRecord.resetOriginalValues();
	}

	/**
	 * Caches the oai records in the entity cache if it is enabled.
	 *
	 * @param oaiRecords the oai records
	 */
	@Override
	public void cacheResult(List<OaiRecord> oaiRecords) {
		for (OaiRecord oaiRecord : oaiRecords) {
			if (entityCache.getResult(
					OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
					OaiRecordImpl.class, oaiRecord.getPrimaryKey()) == null) {

				cacheResult(oaiRecord);
			}
			else {
				oaiRecord.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all oai records.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OaiRecordImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the oai record.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OaiRecord oaiRecord) {
		entityCache.removeResult(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED, OaiRecordImpl.class,
			oaiRecord.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((OaiRecordModelImpl)oaiRecord, true);
	}

	@Override
	public void clearCache(List<OaiRecord> oaiRecords) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OaiRecord oaiRecord : oaiRecords) {
			entityCache.removeResult(
				OaiRecordModelImpl.ENTITY_CACHE_ENABLED, OaiRecordImpl.class,
				oaiRecord.getPrimaryKey());

			clearUniqueFindersCache((OaiRecordModelImpl)oaiRecord, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				OaiRecordModelImpl.ENTITY_CACHE_ENABLED, OaiRecordImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		OaiRecordModelImpl oaiRecordModelImpl) {

		Object[] args = new Object[] {oaiRecordModelImpl.getVideoId()};

		finderCache.putResult(
			_finderPathCountByVideo, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByVideo, args, oaiRecordModelImpl, false);

		args = new Object[] {oaiRecordModelImpl.getIdentifier()};

		finderCache.putResult(
			_finderPathCountByIdentifier, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByIdentifier, args, oaiRecordModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		OaiRecordModelImpl oaiRecordModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {oaiRecordModelImpl.getVideoId()};

			finderCache.removeResult(_finderPathCountByVideo, args);
			finderCache.removeResult(_finderPathFetchByVideo, args);
		}

		if ((oaiRecordModelImpl.getColumnBitmask() &
			 _finderPathFetchByVideo.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				oaiRecordModelImpl.getOriginalVideoId()
			};

			finderCache.removeResult(_finderPathCountByVideo, args);
			finderCache.removeResult(_finderPathFetchByVideo, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {oaiRecordModelImpl.getIdentifier()};

			finderCache.removeResult(_finderPathCountByIdentifier, args);
			finderCache.removeResult(_finderPathFetchByIdentifier, args);
		}

		if ((oaiRecordModelImpl.getColumnBitmask() &
			 _finderPathFetchByIdentifier.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				oaiRecordModelImpl.getOriginalIdentifier()
			};

			finderCache.removeResult(_finderPathCountByIdentifier, args);
			finderCache.removeResult(_finderPathFetchByIdentifier, args);
		}
	}

	/**
	 * Creates a new oai record with the primary key. Does not add the oai record to the database.
	 *
	 * @param oaiRecordId the primary key for the new oai record
	 * @return the new oai record
	 */
	@Override
	public OaiRecord create(long oaiRecordId) {
		OaiRecord oaiRecord = new OaiRecordImpl();

		oaiRecord.setNew(true);
		oaiRecord.setPrimaryKey(oaiRecordId);

		return oaiRecord;
	}

	/**
	 * Removes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record that was removed
	 * @throws NoSuchOaiRecordException if a oai record with the primary key could not be found
	 */
	@Override
	public OaiRecord remove(long oaiRecordId) throws NoSuchOaiRecordException {
		return remove((Serializable)oaiRecordId);
	}

	/**
	 * Removes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the oai record
	 * @return the oai record that was removed
	 * @throws NoSuchOaiRecordException if a oai record with the primary key could not be found
	 */
	@Override
	public OaiRecord remove(Serializable primaryKey)
		throws NoSuchOaiRecordException {

		Session session = null;

		try {
			session = openSession();

			OaiRecord oaiRecord = (OaiRecord)session.get(
				OaiRecordImpl.class, primaryKey);

			if (oaiRecord == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOaiRecordException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(oaiRecord);
		}
		catch (NoSuchOaiRecordException noSuchEntityException) {
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
	protected OaiRecord removeImpl(OaiRecord oaiRecord) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(oaiRecord)) {
				oaiRecord = (OaiRecord)session.get(
					OaiRecordImpl.class, oaiRecord.getPrimaryKeyObj());
			}

			if (oaiRecord != null) {
				session.delete(oaiRecord);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (oaiRecord != null) {
			clearCache(oaiRecord);
		}

		return oaiRecord;
	}

	@Override
	public OaiRecord updateImpl(OaiRecord oaiRecord) {
		boolean isNew = oaiRecord.isNew();

		if (!(oaiRecord instanceof OaiRecordModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(oaiRecord.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(oaiRecord);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in oaiRecord proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom OaiRecord implementation " +
					oaiRecord.getClass());
		}

		OaiRecordModelImpl oaiRecordModelImpl = (OaiRecordModelImpl)oaiRecord;

		Session session = null;

		try {
			session = openSession();

			if (oaiRecord.isNew()) {
				session.save(oaiRecord);

				oaiRecord.setNew(false);
			}
			else {
				oaiRecord = (OaiRecord)session.merge(oaiRecord);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!OaiRecordModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED, OaiRecordImpl.class,
			oaiRecord.getPrimaryKey(), oaiRecord, false);

		clearUniqueFindersCache(oaiRecordModelImpl, false);
		cacheUniqueFindersCache(oaiRecordModelImpl);

		oaiRecord.resetOriginalValues();

		return oaiRecord;
	}

	/**
	 * Returns the oai record with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the oai record
	 * @return the oai record
	 * @throws NoSuchOaiRecordException if a oai record with the primary key could not be found
	 */
	@Override
	public OaiRecord findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOaiRecordException {

		OaiRecord oaiRecord = fetchByPrimaryKey(primaryKey);

		if (oaiRecord == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOaiRecordException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return oaiRecord;
	}

	/**
	 * Returns the oai record with the primary key or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record
	 * @throws NoSuchOaiRecordException if a oai record with the primary key could not be found
	 */
	@Override
	public OaiRecord findByPrimaryKey(long oaiRecordId)
		throws NoSuchOaiRecordException {

		return findByPrimaryKey((Serializable)oaiRecordId);
	}

	/**
	 * Returns the oai record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record, or <code>null</code> if a oai record with the primary key could not be found
	 */
	@Override
	public OaiRecord fetchByPrimaryKey(long oaiRecordId) {
		return fetchByPrimaryKey((Serializable)oaiRecordId);
	}

	/**
	 * Returns all the oai records.
	 *
	 * @return the oai records
	 */
	@Override
	public List<OaiRecord> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @return the range of oai records
	 */
	@Override
	public List<OaiRecord> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai records
	 */
	@Override
	public List<OaiRecord> findAll(
		int start, int end, OrderByComparator<OaiRecord> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the oai records.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecordModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai records
	 * @param end the upper bound of the range of oai records (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oai records
	 */
	@Override
	public List<OaiRecord> findAll(
		int start, int end, OrderByComparator<OaiRecord> orderByComparator,
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

		List<OaiRecord> list = null;

		if (useFinderCache) {
			list = (List<OaiRecord>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OAIRECORD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OAIRECORD;

				sql = sql.concat(OaiRecordModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<OaiRecord>)QueryUtil.list(
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
	 * Removes all the oai records from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OaiRecord oaiRecord : findAll()) {
			remove(oaiRecord);
		}
	}

	/**
	 * Returns the number of oai records.
	 *
	 * @return the number of oai records
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OAIRECORD);

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
		return "oaiRecordId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OAIRECORD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OaiRecordModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the oai record persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, OaiRecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, OaiRecordImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByVideo = new FinderPath(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, OaiRecordImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByVideo",
			new String[] {Long.class.getName()},
			OaiRecordModelImpl.VIDEOID_COLUMN_BITMASK);

		_finderPathCountByVideo = new FinderPath(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] {Long.class.getName()});

		_finderPathFetchByIdentifier = new FinderPath(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, OaiRecordImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByIdentifier",
			new String[] {String.class.getName()},
			OaiRecordModelImpl.IDENTIFIER_COLUMN_BITMASK);

		_finderPathCountByIdentifier = new FinderPath(
			OaiRecordModelImpl.ENTITY_CACHE_ENABLED,
			OaiRecordModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdentifier",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(OaiRecordImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OAIRECORD =
		"SELECT oaiRecord FROM OaiRecord oaiRecord";

	private static final String _SQL_SELECT_OAIRECORD_WHERE =
		"SELECT oaiRecord FROM OaiRecord oaiRecord WHERE ";

	private static final String _SQL_COUNT_OAIRECORD =
		"SELECT COUNT(oaiRecord) FROM OaiRecord oaiRecord";

	private static final String _SQL_COUNT_OAIRECORD_WHERE =
		"SELECT COUNT(oaiRecord) FROM OaiRecord oaiRecord WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "oaiRecord.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No OaiRecord exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No OaiRecord exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OaiRecordPersistenceImpl.class);

}