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

import de.uhh.l2g.plugins.exception.NoSuchLectureseries_CreatorException;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the lectureseries_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CreatorUtil
 * @generated
 */
@ProviderType
public interface Lectureseries_CreatorPersistence
	extends BasePersistence<Lectureseries_Creator> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Lectureseries_CreatorUtil} to access the lectureseries_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId);

	/**
	 * Returns a range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLectureseries(long, int, int, OrderByComparator)}
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Deprecated
	public java.util.List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator findByLectureseries_First(
			long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator fetchByLectureseries_First(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator findByLectureseries_Last(
			long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator fetchByLectureseries_Last(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param lectureseriesId the lectureseries ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public Lectureseries_Creator[] findByLectureseries_PrevAndNext(
			long lectureseriesCreatorId, long lectureseriesId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Removes all the lectureseries_ creators where lectureseriesId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 */
	public void removeByLectureseries(long lectureseriesId);

	/**
	 * Returns the number of lectureseries_ creators where lectureseriesId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @return the number of matching lectureseries_ creators
	 */
	public int countByLectureseries(long lectureseriesId);

	/**
	 * Returns all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByCreator(long creatorId);

	/**
	 * Returns a range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCreator(long, int, int, OrderByComparator)}
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Deprecated
	public java.util.List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureseries_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator findByCreator_First(
			long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Returns the first lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator fetchByCreator_First(
		long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator findByCreator_Last(
			long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Returns the last lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator fetchByCreator_Last(
		long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public Lectureseries_Creator[] findByCreator_PrevAndNext(
			long lectureseriesCreatorId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Removes all the lectureseries_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 */
	public void removeByCreator(long creatorId);

	/**
	 * Returns the number of lectureseries_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching lectureseries_ creators
	 */
	public int countByCreator(long creatorId);

	/**
	 * Returns all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @return the matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId);

	/**
	 * Returns a range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByLectureseriesCreator(long,long, int, int, OrderByComparator)}
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lectureseries_ creators
	 */
	@Deprecated
	public java.util.List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findByLectureseriesCreator(
		long lectureseriesId, long creatorId, int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator findByLectureseriesCreator_First(
			long lectureseriesId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Returns the first lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator fetchByLectureseriesCreator_First(
		long lectureseriesId, long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator findByLectureseriesCreator_Last(
			long lectureseriesId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Returns the last lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lectureseries_ creator, or <code>null</code> if a matching lectureseries_ creator could not be found
	 */
	public Lectureseries_Creator fetchByLectureseriesCreator_Last(
		long lectureseriesId, long creatorId,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Returns the lectureseries_ creators before and after the current lectureseries_ creator in the ordered set where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesCreatorId the primary key of the current lectureseries_ creator
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public Lectureseries_Creator[] findByLectureseriesCreator_PrevAndNext(
			long lectureseriesCreatorId, long lectureseriesId, long creatorId,
			OrderByComparator<Lectureseries_Creator> orderByComparator)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Removes all the lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63; from the database.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 */
	public void removeByLectureseriesCreator(
		long lectureseriesId, long creatorId);

	/**
	 * Returns the number of lectureseries_ creators where lectureseriesId = &#63; and creatorId = &#63;.
	 *
	 * @param lectureseriesId the lectureseries ID
	 * @param creatorId the creator ID
	 * @return the number of matching lectureseries_ creators
	 */
	public int countByLectureseriesCreator(
		long lectureseriesId, long creatorId);

	/**
	 * Caches the lectureseries_ creator in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Creator the lectureseries_ creator
	 */
	public void cacheResult(Lectureseries_Creator lectureseries_Creator);

	/**
	 * Caches the lectureseries_ creators in the entity cache if it is enabled.
	 *
	 * @param lectureseries_Creators the lectureseries_ creators
	 */
	public void cacheResult(
		java.util.List<Lectureseries_Creator> lectureseries_Creators);

	/**
	 * Creates a new lectureseries_ creator with the primary key. Does not add the lectureseries_ creator to the database.
	 *
	 * @param lectureseriesCreatorId the primary key for the new lectureseries_ creator
	 * @return the new lectureseries_ creator
	 */
	public Lectureseries_Creator create(long lectureseriesCreatorId);

	/**
	 * Removes the lectureseries_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator that was removed
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public Lectureseries_Creator remove(long lectureseriesCreatorId)
		throws NoSuchLectureseries_CreatorException;

	public Lectureseries_Creator updateImpl(
		Lectureseries_Creator lectureseries_Creator);

	/**
	 * Returns the lectureseries_ creator with the primary key or throws a <code>NoSuchLectureseries_CreatorException</code> if it could not be found.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator
	 * @throws NoSuchLectureseries_CreatorException if a lectureseries_ creator with the primary key could not be found
	 */
	public Lectureseries_Creator findByPrimaryKey(long lectureseriesCreatorId)
		throws NoSuchLectureseries_CreatorException;

	/**
	 * Returns the lectureseries_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lectureseriesCreatorId the primary key of the lectureseries_ creator
	 * @return the lectureseries_ creator, or <code>null</code> if a lectureseries_ creator with the primary key could not be found
	 */
	public Lectureseries_Creator fetchByPrimaryKey(long lectureseriesCreatorId);

	/**
	 * Returns all the lectureseries_ creators.
	 *
	 * @return the lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findAll();

	/**
	 * Returns a range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @return the range of lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lectureseries_ creators
	 */
	@Deprecated
	public java.util.List<Lectureseries_Creator> findAll(
		int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the lectureseries_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Lectureseries_CreatorModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of lectureseries_ creators
	 * @param end the upper bound of the range of lectureseries_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lectureseries_ creators
	 */
	public java.util.List<Lectureseries_Creator> findAll(
		int start, int end,
		OrderByComparator<Lectureseries_Creator> orderByComparator);

	/**
	 * Removes all the lectureseries_ creators from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lectureseries_ creators.
	 *
	 * @return the number of lectureseries_ creators
	 */
	public int countAll();

}