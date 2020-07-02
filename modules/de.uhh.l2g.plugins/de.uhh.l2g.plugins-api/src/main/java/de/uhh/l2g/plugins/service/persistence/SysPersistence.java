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

import de.uhh.l2g.plugins.exception.NoSuchSysException;
import de.uhh.l2g.plugins.model.Sys;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the sys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see SysUtil
 * @generated
 */
@ProviderType
public interface SysPersistence extends BasePersistence<Sys> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SysUtil} to access the sys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the sys in the entity cache if it is enabled.
	 *
	 * @param sys the sys
	 */
	public void cacheResult(Sys sys);

	/**
	 * Caches the syses in the entity cache if it is enabled.
	 *
	 * @param syses the syses
	 */
	public void cacheResult(java.util.List<Sys> syses);

	/**
	 * Creates a new sys with the primary key. Does not add the sys to the database.
	 *
	 * @param sysId the primary key for the new sys
	 * @return the new sys
	 */
	public Sys create(int sysId);

	/**
	 * Removes the sys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys that was removed
	 * @throws NoSuchSysException if a sys with the primary key could not be found
	 */
	public Sys remove(int sysId) throws NoSuchSysException;

	public Sys updateImpl(Sys sys);

	/**
	 * Returns the sys with the primary key or throws a <code>NoSuchSysException</code> if it could not be found.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys
	 * @throws NoSuchSysException if a sys with the primary key could not be found
	 */
	public Sys findByPrimaryKey(int sysId) throws NoSuchSysException;

	/**
	 * Returns the sys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys, or <code>null</code> if a sys with the primary key could not be found
	 */
	public Sys fetchByPrimaryKey(int sysId);

	/**
	 * Returns all the syses.
	 *
	 * @return the syses
	 */
	public java.util.List<Sys> findAll();

	/**
	 * Returns a range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @return the range of syses
	 */
	public java.util.List<Sys> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of syses
	 */
	public java.util.List<Sys> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sys>
			orderByComparator);

	/**
	 * Returns an ordered range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SysModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of syses
	 */
	public java.util.List<Sys> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Sys> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the syses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of syses.
	 *
	 * @return the number of syses
	 */
	public int countAll();

}