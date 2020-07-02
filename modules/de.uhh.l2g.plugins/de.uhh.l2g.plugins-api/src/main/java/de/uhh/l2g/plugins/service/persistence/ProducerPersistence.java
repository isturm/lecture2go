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

import de.uhh.l2g.plugins.exception.NoSuchProducerException;
import de.uhh.l2g.plugins.model.Producer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the producer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see ProducerUtil
 * @generated
 */
@ProviderType
public interface ProducerPersistence extends BasePersistence<Producer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProducerUtil} to access the producer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the producers where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the matching producers
	 */
	public java.util.List<Producer> findByHost(long hostId);

	/**
	 * Returns a range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public java.util.List<Producer> findByHost(long hostId, int start, int end);

	/**
	 * Returns an ordered range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByHost(
		long hostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producers where hostId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param hostId the host ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByHost(
		long hostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByHost_First(
			long hostId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the first producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByHost_First(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the last producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByHost_Last(
			long hostId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the last producer in the ordered set where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByHost_Last(
		long hostId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the producers before and after the current producer in the ordered set where hostId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param hostId the host ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public Producer[] findByHost_PrevAndNext(
			long producerId, long hostId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Removes all the producers where hostId = &#63; from the database.
	 *
	 * @param hostId the host ID
	 */
	public void removeByHost(long hostId);

	/**
	 * Returns the number of producers where hostId = &#63;.
	 *
	 * @param hostId the host ID
	 * @return the number of matching producers
	 */
	public int countByHost(long hostId);

	/**
	 * Returns all the producers where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching producers
	 */
	public java.util.List<Producer> findByInstitution(long institutionId);

	/**
	 * Returns a range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public java.util.List<Producer> findByInstitution(
		long institutionId, int start, int end);

	/**
	 * Returns an ordered range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByInstitution(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producers where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByInstitution(
		long institutionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByInstitution_First(
			long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the first producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByInstitution_First(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the last producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByInstitution_Last(
			long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the last producer in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByInstitution_Last(
		long institutionId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the producers before and after the current producer in the ordered set where institutionId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public Producer[] findByInstitution_PrevAndNext(
			long producerId, long institutionId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Removes all the producers where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	public void removeByInstitution(long institutionId);

	/**
	 * Returns the number of producers where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching producers
	 */
	public int countByInstitution(long institutionId);

	/**
	 * Returns all the producers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the matching producers
	 */
	public java.util.List<Producer> findByStatus(int approved);

	/**
	 * Returns a range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public java.util.List<Producer> findByStatus(
		int approved, int start, int end);

	/**
	 * Returns an ordered range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByStatus(
		int approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producers where approved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param approved the approved
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByStatus(
		int approved, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByStatus_First(
			int approved,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the first producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByStatus_First(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the last producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByStatus_Last(
			int approved,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the last producer in the ordered set where approved = &#63;.
	 *
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByStatus_Last(
		int approved,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the producers before and after the current producer in the ordered set where approved = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param approved the approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public Producer[] findByStatus_PrevAndNext(
			long producerId, int approved,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Removes all the producers where approved = &#63; from the database.
	 *
	 * @param approved the approved
	 */
	public void removeByStatus(int approved);

	/**
	 * Returns the number of producers where approved = &#63;.
	 *
	 * @param approved the approved
	 * @return the number of matching producers
	 */
	public int countByStatus(int approved);

	/**
	 * Returns the producer where homeDir = &#63; or throws a <code>NoSuchProducerException</code> if it could not be found.
	 *
	 * @param homeDir the home dir
	 * @return the matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByDirectory(String homeDir)
		throws NoSuchProducerException;

	/**
	 * Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param homeDir the home dir
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByDirectory(String homeDir);

	/**
	 * Returns the producer where homeDir = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param homeDir the home dir
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByDirectory(String homeDir, boolean useFinderCache);

	/**
	 * Removes the producer where homeDir = &#63; from the database.
	 *
	 * @param homeDir the home dir
	 * @return the producer that was removed
	 */
	public Producer removeByDirectory(String homeDir)
		throws NoSuchProducerException;

	/**
	 * Returns the number of producers where homeDir = &#63;.
	 *
	 * @param homeDir the home dir
	 * @return the number of matching producers
	 */
	public int countByDirectory(String homeDir);

	/**
	 * Returns the producer where idNum = &#63; or throws a <code>NoSuchProducerException</code> if it could not be found.
	 *
	 * @param idNum the id num
	 * @return the matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByUID(String idNum) throws NoSuchProducerException;

	/**
	 * Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idNum the id num
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByUID(String idNum);

	/**
	 * Returns the producer where idNum = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idNum the id num
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByUID(String idNum, boolean useFinderCache);

	/**
	 * Removes the producer where idNum = &#63; from the database.
	 *
	 * @param idNum the id num
	 * @return the producer that was removed
	 */
	public Producer removeByUID(String idNum) throws NoSuchProducerException;

	/**
	 * Returns the number of producers where idNum = &#63;.
	 *
	 * @param idNum the id num
	 * @return the number of matching producers
	 */
	public int countByUID(String idNum);

	/**
	 * Returns all the producers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching producers
	 */
	public java.util.List<Producer> findByGroup(long groupId);

	/**
	 * Returns a range of all the producers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public java.util.List<Producer> findByGroup(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the producers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByGroup_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the first producer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the last producer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByGroup_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the last producer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the producers before and after the current producer in the ordered set where groupId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public Producer[] findByGroup_PrevAndNext(
			long producerId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Removes all the producers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of producers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching producers
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the producers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching producers
	 */
	public java.util.List<Producer> findByCompany(long companyId);

	/**
	 * Returns a range of all the producers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public java.util.List<Producer> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the producers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producers where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByCompany_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the first producer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the last producer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByCompany_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the last producer in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the producers before and after the current producer in the ordered set where companyId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public Producer[] findByCompany_PrevAndNext(
			long producerId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Removes all the producers where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of producers where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching producers
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the producers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching producers
	 */
	public java.util.List<Producer> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the producers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of matching producers
	 */
	public java.util.List<Producer> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the producers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producers where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching producers
	 */
	public java.util.List<Producer> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByGroupAndCompany_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the first producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByGroupAndCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the last producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer
	 * @throws NoSuchProducerException if a matching producer could not be found
	 */
	public Producer findByGroupAndCompany_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Returns the last producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching producer, or <code>null</code> if a matching producer could not be found
	 */
	public Producer fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns the producers before and after the current producer in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param producerId the primary key of the current producer
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public Producer[] findByGroupAndCompany_PrevAndNext(
			long producerId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Producer>
				orderByComparator)
		throws NoSuchProducerException;

	/**
	 * Removes all the producers where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of producers where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching producers
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the producer in the entity cache if it is enabled.
	 *
	 * @param producer the producer
	 */
	public void cacheResult(Producer producer);

	/**
	 * Caches the producers in the entity cache if it is enabled.
	 *
	 * @param producers the producers
	 */
	public void cacheResult(java.util.List<Producer> producers);

	/**
	 * Creates a new producer with the primary key. Does not add the producer to the database.
	 *
	 * @param producerId the primary key for the new producer
	 * @return the new producer
	 */
	public Producer create(long producerId);

	/**
	 * Removes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer that was removed
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public Producer remove(long producerId) throws NoSuchProducerException;

	public Producer updateImpl(Producer producer);

	/**
	 * Returns the producer with the primary key or throws a <code>NoSuchProducerException</code> if it could not be found.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer
	 * @throws NoSuchProducerException if a producer with the primary key could not be found
	 */
	public Producer findByPrimaryKey(long producerId)
		throws NoSuchProducerException;

	/**
	 * Returns the producer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param producerId the primary key of the producer
	 * @return the producer, or <code>null</code> if a producer with the primary key could not be found
	 */
	public Producer fetchByPrimaryKey(long producerId);

	/**
	 * Returns all the producers.
	 *
	 * @return the producers
	 */
	public java.util.List<Producer> findAll();

	/**
	 * Returns a range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @return the range of producers
	 */
	public java.util.List<Producer> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producers
	 */
	public java.util.List<Producer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the producers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProducerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of producers
	 * @param end the upper bound of the range of producers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of producers
	 */
	public java.util.List<Producer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Producer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the producers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of producers.
	 *
	 * @return the number of producers
	 */
	public int countAll();

}