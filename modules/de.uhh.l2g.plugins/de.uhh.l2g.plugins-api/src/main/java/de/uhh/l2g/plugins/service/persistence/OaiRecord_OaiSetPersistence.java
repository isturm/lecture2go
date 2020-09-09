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

import de.uhh.l2g.plugins.exception.NoSuchOaiRecord_OaiSetException;
import de.uhh.l2g.plugins.model.OaiRecord_OaiSet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the oai record_ oai set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiRecord_OaiSetUtil
 * @generated
 */
@ProviderType
public interface OaiRecord_OaiSetPersistence
	extends BasePersistence<OaiRecord_OaiSet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OaiRecord_OaiSetUtil} to access the oai record_ oai set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @return the matching oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findByoaiSet(long oaiSetId);

	/**
	 * Returns a range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of matching oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end);

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiSetId the oai set ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findByoaiSet(
		long oaiSetId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	public OaiRecord_OaiSet findByoaiSet_First(
			long oaiSetId,
			com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
				orderByComparator)
		throws NoSuchOaiRecord_OaiSetException;

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	public OaiRecord_OaiSet fetchByoaiSet_First(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator);

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	public OaiRecord_OaiSet findByoaiSet_Last(
			long oaiSetId,
			com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
				orderByComparator)
		throws NoSuchOaiRecord_OaiSetException;

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	public OaiRecord_OaiSet fetchByoaiSet_Last(
		long oaiSetId,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator);

	/**
	 * Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiSetId = &#63;.
	 *
	 * @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	 * @param oaiSetId the oai set ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	public OaiRecord_OaiSet[] findByoaiSet_PrevAndNext(
			long oaiRecordOaiSetId, long oaiSetId,
			com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
				orderByComparator)
		throws NoSuchOaiRecord_OaiSetException;

	/**
	 * Removes all the oai record_ oai sets where oaiSetId = &#63; from the database.
	 *
	 * @param oaiSetId the oai set ID
	 */
	public void removeByoaiSet(long oaiSetId);

	/**
	 * Returns the number of oai record_ oai sets where oaiSetId = &#63;.
	 *
	 * @param oaiSetId the oai set ID
	 * @return the number of matching oai record_ oai sets
	 */
	public int countByoaiSet(long oaiSetId);

	/**
	 * Returns all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @return the matching oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findByoaiRecord(long oaiRecordId);

	/**
	 * Returns a range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of matching oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end);

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param oaiRecordId the oai record ID
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findByoaiRecord(
		long oaiRecordId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	public OaiRecord_OaiSet findByoaiRecord_First(
			long oaiRecordId,
			com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
				orderByComparator)
		throws NoSuchOaiRecord_OaiSetException;

	/**
	 * Returns the first oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	public OaiRecord_OaiSet fetchByoaiRecord_First(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator);

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a matching oai record_ oai set could not be found
	 */
	public OaiRecord_OaiSet findByoaiRecord_Last(
			long oaiRecordId,
			com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
				orderByComparator)
		throws NoSuchOaiRecord_OaiSetException;

	/**
	 * Returns the last oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching oai record_ oai set, or <code>null</code> if a matching oai record_ oai set could not be found
	 */
	public OaiRecord_OaiSet fetchByoaiRecord_Last(
		long oaiRecordId,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator);

	/**
	 * Returns the oai record_ oai sets before and after the current oai record_ oai set in the ordered set where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordOaiSetId the primary key of the current oai record_ oai set
	 * @param oaiRecordId the oai record ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	public OaiRecord_OaiSet[] findByoaiRecord_PrevAndNext(
			long oaiRecordOaiSetId, long oaiRecordId,
			com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
				orderByComparator)
		throws NoSuchOaiRecord_OaiSetException;

	/**
	 * Removes all the oai record_ oai sets where oaiRecordId = &#63; from the database.
	 *
	 * @param oaiRecordId the oai record ID
	 */
	public void removeByoaiRecord(long oaiRecordId);

	/**
	 * Returns the number of oai record_ oai sets where oaiRecordId = &#63;.
	 *
	 * @param oaiRecordId the oai record ID
	 * @return the number of matching oai record_ oai sets
	 */
	public int countByoaiRecord(long oaiRecordId);

	/**
	 * Caches the oai record_ oai set in the entity cache if it is enabled.
	 *
	 * @param oaiRecord_OaiSet the oai record_ oai set
	 */
	public void cacheResult(OaiRecord_OaiSet oaiRecord_OaiSet);

	/**
	 * Caches the oai record_ oai sets in the entity cache if it is enabled.
	 *
	 * @param oaiRecord_OaiSets the oai record_ oai sets
	 */
	public void cacheResult(java.util.List<OaiRecord_OaiSet> oaiRecord_OaiSets);

	/**
	 * Creates a new oai record_ oai set with the primary key. Does not add the oai record_ oai set to the database.
	 *
	 * @param oaiRecordOaiSetId the primary key for the new oai record_ oai set
	 * @return the new oai record_ oai set
	 */
	public OaiRecord_OaiSet create(long oaiRecordOaiSetId);

	/**
	 * Removes the oai record_ oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set that was removed
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	public OaiRecord_OaiSet remove(long oaiRecordOaiSetId)
		throws NoSuchOaiRecord_OaiSetException;

	public OaiRecord_OaiSet updateImpl(OaiRecord_OaiSet oaiRecord_OaiSet);

	/**
	 * Returns the oai record_ oai set with the primary key or throws a <code>NoSuchOaiRecord_OaiSetException</code> if it could not be found.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set
	 * @throws NoSuchOaiRecord_OaiSetException if a oai record_ oai set with the primary key could not be found
	 */
	public OaiRecord_OaiSet findByPrimaryKey(long oaiRecordOaiSetId)
		throws NoSuchOaiRecord_OaiSetException;

	/**
	 * Returns the oai record_ oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiRecordOaiSetId the primary key of the oai record_ oai set
	 * @return the oai record_ oai set, or <code>null</code> if a oai record_ oai set with the primary key could not be found
	 */
	public OaiRecord_OaiSet fetchByPrimaryKey(long oaiRecordOaiSetId);

	/**
	 * Returns all the oai record_ oai sets.
	 *
	 * @return the oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findAll();

	/**
	 * Returns a range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @return the range of oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator);

	/**
	 * Returns an ordered range of all the oai record_ oai sets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OaiRecord_OaiSetModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of oai record_ oai sets
	 * @param end the upper bound of the range of oai record_ oai sets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of oai record_ oai sets
	 */
	public java.util.List<OaiRecord_OaiSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiRecord_OaiSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the oai record_ oai sets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of oai record_ oai sets.
	 *
	 * @return the number of oai record_ oai sets
	 */
	public int countAll();

}