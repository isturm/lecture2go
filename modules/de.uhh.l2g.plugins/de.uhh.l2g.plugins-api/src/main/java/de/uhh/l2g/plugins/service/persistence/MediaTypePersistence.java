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

import de.uhh.l2g.plugins.exception.NoSuchMediaTypeException;
import de.uhh.l2g.plugins.model.MediaType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the media type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see MediaTypeUtil
 * @generated
 */
@ProviderType
public interface MediaTypePersistence extends BasePersistence<MediaType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MediaTypeUtil} to access the media type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the media types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching media types
	 */
	public java.util.List<MediaType> findByGroup(long groupId);

	/**
	 * Returns a range of all the media types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of matching media types
	 */
	public java.util.List<MediaType> findByGroup(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the media types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching media types
	 */
	public java.util.List<MediaType> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the media types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching media types
	 */
	public java.util.List<MediaType> findByGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public MediaType findByGroup_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Returns the first media type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public MediaType fetchByGroup_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns the last media type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public MediaType findByGroup_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Returns the last media type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public MediaType fetchByGroup_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns the media types before and after the current media type in the ordered set where groupId = &#63;.
	 *
	 * @param mediaTypeId the primary key of the current media type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media type
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public MediaType[] findByGroup_PrevAndNext(
			long mediaTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Removes all the media types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroup(long groupId);

	/**
	 * Returns the number of media types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching media types
	 */
	public int countByGroup(long groupId);

	/**
	 * Returns all the media types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching media types
	 */
	public java.util.List<MediaType> findByCompany(long companyId);

	/**
	 * Returns a range of all the media types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of matching media types
	 */
	public java.util.List<MediaType> findByCompany(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the media types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching media types
	 */
	public java.util.List<MediaType> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the media types where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching media types
	 */
	public java.util.List<MediaType> findByCompany(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public MediaType findByCompany_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Returns the first media type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public MediaType fetchByCompany_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns the last media type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public MediaType findByCompany_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Returns the last media type in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public MediaType fetchByCompany_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns the media types before and after the current media type in the ordered set where companyId = &#63;.
	 *
	 * @param mediaTypeId the primary key of the current media type
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media type
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public MediaType[] findByCompany_PrevAndNext(
			long mediaTypeId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Removes all the media types where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompany(long companyId);

	/**
	 * Returns the number of media types where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching media types
	 */
	public int countByCompany(long companyId);

	/**
	 * Returns all the media types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching media types
	 */
	public java.util.List<MediaType> findByGroupAndCompany(
		long groupId, long companyId);

	/**
	 * Returns a range of all the media types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of matching media types
	 */
	public java.util.List<MediaType> findByGroupAndCompany(
		long groupId, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the media types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching media types
	 */
	public java.util.List<MediaType> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the media types where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching media types
	 */
	public java.util.List<MediaType> findByGroupAndCompany(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public MediaType findByGroupAndCompany_First(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Returns the first media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public MediaType fetchByGroupAndCompany_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns the last media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type
	 * @throws NoSuchMediaTypeException if a matching media type could not be found
	 */
	public MediaType findByGroupAndCompany_Last(
			long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Returns the last media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media type, or <code>null</code> if a matching media type could not be found
	 */
	public MediaType fetchByGroupAndCompany_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns the media types before and after the current media type in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param mediaTypeId the primary key of the current media type
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media type
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public MediaType[] findByGroupAndCompany_PrevAndNext(
			long mediaTypeId, long groupId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<MediaType>
				orderByComparator)
		throws NoSuchMediaTypeException;

	/**
	 * Removes all the media types where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByGroupAndCompany(long groupId, long companyId);

	/**
	 * Returns the number of media types where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching media types
	 */
	public int countByGroupAndCompany(long groupId, long companyId);

	/**
	 * Caches the media type in the entity cache if it is enabled.
	 *
	 * @param mediaType the media type
	 */
	public void cacheResult(MediaType mediaType);

	/**
	 * Caches the media types in the entity cache if it is enabled.
	 *
	 * @param mediaTypes the media types
	 */
	public void cacheResult(java.util.List<MediaType> mediaTypes);

	/**
	 * Creates a new media type with the primary key. Does not add the media type to the database.
	 *
	 * @param mediaTypeId the primary key for the new media type
	 * @return the new media type
	 */
	public MediaType create(long mediaTypeId);

	/**
	 * Removes the media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type that was removed
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public MediaType remove(long mediaTypeId) throws NoSuchMediaTypeException;

	public MediaType updateImpl(MediaType mediaType);

	/**
	 * Returns the media type with the primary key or throws a <code>NoSuchMediaTypeException</code> if it could not be found.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type
	 * @throws NoSuchMediaTypeException if a media type with the primary key could not be found
	 */
	public MediaType findByPrimaryKey(long mediaTypeId)
		throws NoSuchMediaTypeException;

	/**
	 * Returns the media type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mediaTypeId the primary key of the media type
	 * @return the media type, or <code>null</code> if a media type with the primary key could not be found
	 */
	public MediaType fetchByPrimaryKey(long mediaTypeId);

	/**
	 * Returns all the media types.
	 *
	 * @return the media types
	 */
	public java.util.List<MediaType> findAll();

	/**
	 * Returns a range of all the media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @return the range of media types
	 */
	public java.util.List<MediaType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of media types
	 */
	public java.util.List<MediaType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of media types
	 * @param end the upper bound of the range of media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of media types
	 */
	public java.util.List<MediaType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MediaType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the media types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of media types.
	 *
	 * @return the number of media types
	 */
	public int countAll();

}