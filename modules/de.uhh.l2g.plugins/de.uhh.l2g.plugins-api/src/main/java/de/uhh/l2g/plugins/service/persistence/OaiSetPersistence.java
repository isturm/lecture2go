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

import de.uhh.l2g.plugins.exception.NoSuchOaiSetException;
import de.uhh.l2g.plugins.model.OaiSet;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the oai set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiSetUtil
 * @generated
 */
@ProviderType
public interface OaiSetPersistence extends BasePersistence<OaiSet> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OaiSetUtil} to access the oai set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the oai set in the entity cache if it is enabled.
	 *
	 * @param oaiSet the oai set
	 */
	public void cacheResult(OaiSet oaiSet);

	/**
	 * Caches the oai sets in the entity cache if it is enabled.
	 *
	 * @param oaiSets the oai sets
	 */
	public void cacheResult(java.util.List<OaiSet> oaiSets);

	/**
	 * Creates a new oai set with the primary key. Does not add the oai set to the database.
	 *
	 * @param oaiSetId the primary key for the new oai set
	 * @return the new oai set
	 */
	public OaiSet create(long oaiSetId);

	/**
	 * Removes the oai set with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set that was removed
	 * @throws NoSuchOaiSetException if a oai set with the primary key could not be found
	 */
	public OaiSet remove(long oaiSetId) throws NoSuchOaiSetException;

	public OaiSet updateImpl(OaiSet oaiSet);

	/**
	 * Returns the oai set with the primary key or throws a <code>NoSuchOaiSetException</code> if it could not be found.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set
	 * @throws NoSuchOaiSetException if a oai set with the primary key could not be found
	 */
	public OaiSet findByPrimaryKey(long oaiSetId) throws NoSuchOaiSetException;

	/**
	 * Returns the oai set with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param oaiSetId the primary key of the oai set
	 * @return the oai set, or <code>null</code> if a oai set with the primary key could not be found
	 */
	public OaiSet fetchByPrimaryKey(long oaiSetId);

	/**
	 * Returns all the oai sets.
	 *
	 * @return the oai sets
	 */
	public java.util.List<OaiSet> findAll();

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
	public java.util.List<OaiSet> findAll(int start, int end);

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
	public java.util.List<OaiSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiSet>
			orderByComparator);

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
	public java.util.List<OaiSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<OaiSet>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the oai sets from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of oai sets.
	 *
	 * @return the number of oai sets
	 */
	public int countAll();

}