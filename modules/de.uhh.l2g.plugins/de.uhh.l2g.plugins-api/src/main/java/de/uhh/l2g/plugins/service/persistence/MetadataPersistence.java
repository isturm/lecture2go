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
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.exception.NoSuchMetadataException;
import de.uhh.l2g.plugins.model.Metadata;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the metadata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see MetadataUtil
 * @generated
 */
@ProviderType
public interface MetadataPersistence extends BasePersistence<Metadata> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MetadataUtil} to access the metadata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the metadatas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching metadatas
	 */
	public java.util.List<Metadata> findByGroup(long groupId);

	/**
	 * Returns a range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	public java.util.List<Metadata> findByGroup(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroup(long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	@Deprecated
	public java.util.List<Metadata> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	public java.util.List<Metadata> findByGroup(
		long groupId, int start, int end,
		OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public Metadata findByGroup_First(
			long groupId, OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public Metadata fetchByGroup_First(
		long groupId, OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public Metadata findByGroup_Last(
			long groupId, OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public Metadata fetchByGroup_Last(
		long groupId, OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where groupId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public Metadata[] findByGroup_PrevAndNext(
			long metadataId, long groupId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Removes all the metadatas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of metadatas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching metadatas
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the metadatas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching metadatas
	 */
	public java.util.List<Metadata> findByCompany(long companyId);

	/**
	 * Returns a range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	public java.util.List<Metadata> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCompany(long, int, int, OrderByComparator)}
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	@Deprecated
	public java.util.List<Metadata> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the metadatas where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	public java.util.List<Metadata> findByCompany(
		long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the first metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public Metadata findByCompany_First(
			long companyId, OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Returns the first metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public Metadata fetchByCompany_First(
		long companyId, OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the last metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public Metadata findByCompany_Last(
			long companyId, OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Returns the last metadata in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public Metadata fetchByCompany_Last(
		long companyId, OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where companyId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public Metadata[] findByCompany_PrevAndNext(
			long metadataId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Removes all the metadatas where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of metadatas where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching metadatas
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching metadatas
	 */
	public java.util.List<Metadata> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of matching metadatas
	 */
	public java.util.List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByGroupAndCompany(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching metadatas
	 */
	@Deprecated
	public java.util.List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching metadatas
	 */
	public java.util.List<Metadata> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public Metadata findByGroupAndCompany_First(
			long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Returns the first metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public Metadata fetchByGroupAndCompany_First(
		long groupId, long companyId,
		OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata
	 * @throws NoSuchMetadataException if a matching metadata could not be found
	 */
	public Metadata findByGroupAndCompany_Last(
			long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Returns the last metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching metadata, or <code>null</code> if a matching metadata could not be found
	 */
	public Metadata fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		OrderByComparator<Metadata> orderByComparator);

	/**
	 * Returns the metadatas before and after the current metadata in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param metadataId the primary key of the current metadata
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public Metadata[] findByGroupAndCompany_PrevAndNext(
			long metadataId, long groupId, long companyId,
			OrderByComparator<Metadata> orderByComparator)
		throws NoSuchMetadataException;

	/**
	 * Removes all the metadatas where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of metadatas where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching metadatas
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the metadata in the entity cache if it is enabled.
	 *
	 * @param metadata the metadata
	 */
	public void cacheResult(Metadata metadata);

	/**
	 * Caches the metadatas in the entity cache if it is enabled.
	 *
	 * @param metadatas the metadatas
	 */
	public void cacheResult(java.util.List<Metadata> metadatas);

	/**
	 * Creates a new metadata with the primary key. Does not add the metadata to the database.
	 *
	 * @param metadataId the primary key for the new metadata
	 * @return the new metadata
	 */
	public Metadata create(long metadataId);

	/**
	 * Removes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public Metadata remove(long metadataId) throws NoSuchMetadataException;

	public Metadata updateImpl(Metadata metadata);

	/**
	 * Returns the metadata with the primary key or throws a <code>NoSuchMetadataException</code> if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	public Metadata findByPrimaryKey(long metadataId)
		throws NoSuchMetadataException;

	/**
	 * Returns the metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata, or <code>null</code> if a metadata with the primary key could not be found
	 */
	public Metadata fetchByPrimaryKey(long metadataId);

	/**
	 * Returns all the metadatas.
	 *
	 * @return the metadatas
	 */
	public java.util.List<Metadata> findAll();

	/**
	 * Returns a range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of metadatas
	 */
	public java.util.List<Metadata> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of metadatas
	 */
	@Deprecated
	public java.util.List<Metadata> findAll(
		int start, int end, OrderByComparator<Metadata> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>MetadataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadatas
	 */
	public java.util.List<Metadata> findAll(
		int start, int end, OrderByComparator<Metadata> orderByComparator);

	/**
	 * Removes all the metadatas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of metadatas.
	 *
	 * @return the number of metadatas
	 */
	public int countAll();

}