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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.exception.NoSuchOaiRecordException;
import de.uhh.l2g.plugins.model.OaiRecord;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the oai record service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecordUtil
 * @generated
 */
@ProviderType
public interface OaiRecordPersistence extends BasePersistence<OaiRecord> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OaiRecordUtil} to access the oai record persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the oai record where videoId = &#63; or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param videoId the video ID
	 * @return the matching oai record
	 * @throws NoSuchOaiRecordException if a matching oai record could not be found
	 */
	public OaiRecord findByVideo(long videoId) throws NoSuchOaiRecordException;

	/**
	 * Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param videoId the video ID
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	public OaiRecord fetchByVideo(long videoId);

	/**
	 * Returns the oai record where videoId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param videoId the video ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	public OaiRecord fetchByVideo(long videoId, boolean useFinderCache);

	/**
	 * Removes the oai record where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @return the oai record that was removed
	 */
	public OaiRecord removeByVideo(long videoId)
		throws NoSuchOaiRecordException;

	/**
	 * Returns the number of oai records where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching oai records
	 */
	public int countByVideo(long videoId);

	/**
	 * Returns the oai record where identifier = &#63; or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param identifier the identifier
	 * @return the matching oai record
	 * @throws NoSuchOaiRecordException if a matching oai record could not be found
	 */
	public OaiRecord findByIdentifier(String identifier)
		throws NoSuchOaiRecordException;

	/**
	 * Returns the oai record where identifier = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param identifier the identifier
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	public OaiRecord fetchByIdentifier(String identifier);

	/**
	 * Returns the oai record where identifier = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param identifier the identifier
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching oai record, or <code>null</code> if a matching oai record could not be found
	 */
	public OaiRecord fetchByIdentifier(
		String identifier, boolean useFinderCache);

	/**
	 * Removes the oai record where identifier = &#63; from the database.
	 *
	 * @param identifier the identifier
	 * @return the oai record that was removed
	 */
	public OaiRecord removeByIdentifier(String identifier)
		throws NoSuchOaiRecordException;

	/**
	 * Returns the number of oai records where identifier = &#63;.
	 *
	 * @param identifier the identifier
	 * @return the number of matching oai records
	 */
	public int countByIdentifier(String identifier);

	/**
	 * Caches the oai record in the entity cache if it is enabled.
	 *
	 * @param oaiRecord the oai record
	 */
	public void cacheResult(OaiRecord oaiRecord);

	/**
	 * Caches the oai records in the entity cache if it is enabled.
	 *
	 * @param oaiRecords the oai records
	 */
	public void cacheResult(java.util.List<OaiRecord> oaiRecords);

	/**
	 * Creates a new oai record with the primary key. Does not add the oai record to the database.
	 *
	 * @param oaiRecordId the primary key for the new oai record
	 * @return the new oai record
	 */
	public OaiRecord create(long oaiRecordId);

	/**
	 * Removes the oai record with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record that was removed
	 * @throws NoSuchOaiRecordException if a oai record with the primary key could not be found
	 */
	public OaiRecord remove(long oaiRecordId) throws NoSuchOaiRecordException;

	public OaiRecord updateImpl(OaiRecord oaiRecord);

	/**
	 * Returns the oai record with the primary key or throws a <code>NoSuchOaiRecordException</code> if it could not be found.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record
	 * @throws NoSuchOaiRecordException if a oai record with the primary key could not be found
	 */
	public OaiRecord findByPrimaryKey(long oaiRecordId)
		throws NoSuchOaiRecordException;

	/**
	 * Returns the oai record with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiRecordId the primary key of the oai record
	 * @return the oai record, or <code>null</code> if a oai record with the primary key could not be found
	 */
	public OaiRecord fetchByPrimaryKey(long oaiRecordId);

	/**
	 * Returns all the oai records.
	 *
	 * @return the oai records
	 */
	public java.util.List<OaiRecord> findAll();

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
	public java.util.List<OaiRecord> findAll(int start, int end);

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
	public java.util.List<OaiRecord> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord>
			orderByComparator);

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
	public java.util.List<OaiRecord> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the oai records from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of oai records.
	 *
	 * @return the number of oai records
	 */
	public int countAll();

}