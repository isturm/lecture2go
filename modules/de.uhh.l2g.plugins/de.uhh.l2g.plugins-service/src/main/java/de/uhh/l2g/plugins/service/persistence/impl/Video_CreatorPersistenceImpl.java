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

import de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.impl.Video_CreatorImpl;
import de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl;
import de.uhh.l2g.plugins.service.persistence.Video_CreatorPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the video_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
public class Video_CreatorPersistenceImpl
	extends BasePersistenceImpl<Video_Creator>
	implements Video_CreatorPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Video_CreatorUtil</code> to access the video_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Video_CreatorImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByVideo;
	private FinderPath _finderPathWithoutPaginationFindByVideo;
	private FinderPath _finderPathCountByVideo;

	/**
	 * Returns all the video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVideo;
				finderArgs = new Object[] {videoId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVideo;
			finderArgs = new Object[] {videoId, start, end, orderByComparator};
		}

		List<Video_Creator> list = null;

		if (useFinderCache) {
			list = (List<Video_Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Creator video_Creator : list) {
					if (videoId != video_Creator.getVideoId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

				list = (List<Video_Creator>)QueryUtil.list(
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
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByVideo_First(
			long videoId, OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = fetchByVideo_First(
			videoId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append("}");

		throw new NoSuchVideo_CreatorException(sb.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByVideo_First(
		long videoId, OrderByComparator<Video_Creator> orderByComparator) {

		List<Video_Creator> list = findByVideo(
			videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByVideo_Last(
			long videoId, OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = fetchByVideo_Last(
			videoId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append("}");

		throw new NoSuchVideo_CreatorException(sb.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByVideo_Last(
		long videoId, OrderByComparator<Video_Creator> orderByComparator) {

		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByVideo(
			videoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator[] findByVideo_PrevAndNext(
			long videoCreatorId, long videoId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByVideo_PrevAndNext(
				session, video_Creator, videoId, orderByComparator, true);

			array[1] = video_Creator;

			array[2] = getByVideo_PrevAndNext(
				session, video_Creator, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Creator getByVideo_PrevAndNext(
		Session session, Video_Creator video_Creator, long videoId,
		OrderByComparator<Video_Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

		sb.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(videoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						video_Creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Video_Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Video_Creator video_Creator :
				findByVideo(
					videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ creators
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = _finderPathCountByVideo;

		Object[] finderArgs = new Object[] {videoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

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
		"video_Creator.videoId = ?";

	private FinderPath _finderPathWithPaginationFindByCreator;
	private FinderPath _finderPathWithoutPaginationFindByCreator;
	private FinderPath _finderPathCountByCreator;

	/**
	 * Returns all the video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByCreator(long creatorId) {
		return findByCreator(
			creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByCreator(
		long creatorId, int start, int end) {

		return findByCreator(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return findByCreator(creatorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByCreator(
		long creatorId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCreator;
				finderArgs = new Object[] {creatorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCreator;
			finderArgs = new Object[] {
				creatorId, start, end, orderByComparator
			};
		}

		List<Video_Creator> list = null;

		if (useFinderCache) {
			list = (List<Video_Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Creator video_Creator : list) {
					if (creatorId != video_Creator.getCreatorId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(creatorId);

				list = (List<Video_Creator>)QueryUtil.list(
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
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByCreator_First(
			long creatorId, OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = fetchByCreator_First(
			creatorId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("creatorId=");
		sb.append(creatorId);

		sb.append("}");

		throw new NoSuchVideo_CreatorException(sb.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByCreator_First(
		long creatorId, OrderByComparator<Video_Creator> orderByComparator) {

		List<Video_Creator> list = findByCreator(
			creatorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByCreator_Last(
			long creatorId, OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = fetchByCreator_Last(
			creatorId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("creatorId=");
		sb.append(creatorId);

		sb.append("}");

		throw new NoSuchVideo_CreatorException(sb.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByCreator_Last(
		long creatorId, OrderByComparator<Video_Creator> orderByComparator) {

		int count = countByCreator(creatorId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByCreator(
			creatorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator[] findByCreator_PrevAndNext(
			long videoCreatorId, long creatorId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByCreator_PrevAndNext(
				session, video_Creator, creatorId, orderByComparator, true);

			array[1] = video_Creator;

			array[2] = getByCreator_PrevAndNext(
				session, video_Creator, creatorId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Creator getByCreator_PrevAndNext(
		Session session, Video_Creator video_Creator, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

		sb.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(creatorId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						video_Creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Video_Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 */
	@Override
	public void removeByCreator(long creatorId) {
		for (Video_Creator video_Creator :
				findByCreator(
					creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 */
	@Override
	public int countByCreator(long creatorId) {
		FinderPath finderPath = _finderPathCountByCreator;

		Object[] finderArgs = new Object[] {creatorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_CREATOR_CREATORID_2 =
		"video_Creator.creatorId = ?";

	private FinderPath _finderPathWithPaginationFindByVideoCreator;
	private FinderPath _finderPathWithoutPaginationFindByVideoCreator;
	private FinderPath _finderPathCountByVideoCreator;

	/**
	 * Returns all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId) {

		return findByVideoCreator(
			videoId, creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end) {

		return findByVideoCreator(videoId, creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return findByVideoCreator(
			videoId, creatorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(
		long videoId, long creatorId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVideoCreator;
				finderArgs = new Object[] {videoId, creatorId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVideoCreator;
			finderArgs = new Object[] {
				videoId, creatorId, start, end, orderByComparator
			};
		}

		List<Video_Creator> list = null;

		if (useFinderCache) {
			list = (List<Video_Creator>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Creator video_Creator : list) {
					if ((videoId != video_Creator.getVideoId()) ||
						(creatorId != video_Creator.getCreatorId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

			sb.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

				queryPos.add(creatorId);

				list = (List<Video_Creator>)QueryUtil.list(
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
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByVideoCreator_First(
			long videoId, long creatorId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = fetchByVideoCreator_First(
			videoId, creatorId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append(", creatorId=");
		sb.append(creatorId);

		sb.append("}");

		throw new NoSuchVideo_CreatorException(sb.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByVideoCreator_First(
		long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator) {

		List<Video_Creator> list = findByVideoCreator(
			videoId, creatorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByVideoCreator_Last(
			long videoId, long creatorId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = fetchByVideoCreator_Last(
			videoId, creatorId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("videoId=");
		sb.append(videoId);

		sb.append(", creatorId=");
		sb.append(creatorId);

		sb.append("}");

		throw new NoSuchVideo_CreatorException(sb.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByVideoCreator_Last(
		long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator) {

		int count = countByVideoCreator(videoId, creatorId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByVideoCreator(
			videoId, creatorId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator[] findByVideoCreator_PrevAndNext(
			long videoCreatorId, long videoId, long creatorId,
			OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByVideoCreator_PrevAndNext(
				session, video_Creator, videoId, creatorId, orderByComparator,
				true);

			array[1] = video_Creator;

			array[2] = getByVideoCreator_PrevAndNext(
				session, video_Creator, videoId, creatorId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Creator getByVideoCreator_PrevAndNext(
		Session session, Video_Creator video_Creator, long videoId,
		long creatorId, OrderByComparator<Video_Creator> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

		sb.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

		sb.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(videoId);

		queryPos.add(creatorId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						video_Creator)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Video_Creator> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where videoId = &#63; and creatorId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 */
	@Override
	public void removeByVideoCreator(long videoId, long creatorId) {
		for (Video_Creator video_Creator :
				findByVideoCreator(
					videoId, creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 */
	@Override
	public int countByVideoCreator(long videoId, long creatorId) {
		FinderPath finderPath = _finderPathCountByVideoCreator;

		Object[] finderArgs = new Object[] {videoId, creatorId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

			sb.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

			sb.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(videoId);

				queryPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2 =
		"video_Creator.videoId = ? AND ";

	private static final String _FINDER_COLUMN_VIDEOCREATOR_CREATORID_2 =
		"video_Creator.creatorId = ?";

	public Video_CreatorPersistenceImpl() {
		setModelClass(Video_Creator.class);

		setModelImplClass(Video_CreatorImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the video_ creator in the entity cache if it is enabled.
	 *
	 * @param video_Creator the video_ creator
	 */
	@Override
	public void cacheResult(Video_Creator video_Creator) {
		entityCache.putResult(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey(),
			video_Creator);

		video_Creator.resetOriginalValues();
	}

	/**
	 * Caches the video_ creators in the entity cache if it is enabled.
	 *
	 * @param video_Creators the video_ creators
	 */
	@Override
	public void cacheResult(List<Video_Creator> video_Creators) {
		for (Video_Creator video_Creator : video_Creators) {
			if (entityCache.getResult(
					Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
					Video_CreatorImpl.class, video_Creator.getPrimaryKey()) ==
						null) {

				cacheResult(video_Creator);
			}
			else {
				video_Creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ creators.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Video_CreatorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ creator.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Creator video_Creator) {
		entityCache.removeResult(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Creator> video_Creators) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Creator video_Creator : video_Creators) {
			entityCache.removeResult(
				Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Video_CreatorImpl.class, video_Creator.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Video_CreatorImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	 *
	 * @param videoCreatorId the primary key for the new video_ creator
	 * @return the new video_ creator
	 */
	@Override
	public Video_Creator create(long videoCreatorId) {
		Video_Creator video_Creator = new Video_CreatorImpl();

		video_Creator.setNew(true);
		video_Creator.setPrimaryKey(videoCreatorId);

		return video_Creator;
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator remove(long videoCreatorId)
		throws NoSuchVideo_CreatorException {

		return remove((Serializable)videoCreatorId);
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator remove(Serializable primaryKey)
		throws NoSuchVideo_CreatorException {

		Session session = null;

		try {
			session = openSession();

			Video_Creator video_Creator = (Video_Creator)session.get(
				Video_CreatorImpl.class, primaryKey);

			if (video_Creator == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_CreatorException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(video_Creator);
		}
		catch (NoSuchVideo_CreatorException noSuchEntityException) {
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
	protected Video_Creator removeImpl(Video_Creator video_Creator) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Creator)) {
				video_Creator = (Video_Creator)session.get(
					Video_CreatorImpl.class, video_Creator.getPrimaryKeyObj());
			}

			if (video_Creator != null) {
				session.delete(video_Creator);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (video_Creator != null) {
			clearCache(video_Creator);
		}

		return video_Creator;
	}

	@Override
	public Video_Creator updateImpl(Video_Creator video_Creator) {
		boolean isNew = video_Creator.isNew();

		if (!(video_Creator instanceof Video_CreatorModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(video_Creator.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					video_Creator);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in video_Creator proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Video_Creator implementation " +
					video_Creator.getClass());
		}

		Video_CreatorModelImpl video_CreatorModelImpl =
			(Video_CreatorModelImpl)video_Creator;

		Session session = null;

		try {
			session = openSession();

			if (video_Creator.isNew()) {
				session.save(video_Creator);

				video_Creator.setNew(false);
			}
			else {
				video_Creator = (Video_Creator)session.merge(video_Creator);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Video_CreatorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {video_CreatorModelImpl.getVideoId()};

			finderCache.removeResult(_finderPathCountByVideo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideo, args);

			args = new Object[] {video_CreatorModelImpl.getCreatorId()};

			finderCache.removeResult(_finderPathCountByCreator, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCreator, args);

			args = new Object[] {
				video_CreatorModelImpl.getVideoId(),
				video_CreatorModelImpl.getCreatorId()
			};

			finderCache.removeResult(_finderPathCountByVideoCreator, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideoCreator, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((video_CreatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					video_CreatorModelImpl.getOriginalVideoId()
				};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);

				args = new Object[] {video_CreatorModelImpl.getVideoId()};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);
			}

			if ((video_CreatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCreator.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					video_CreatorModelImpl.getOriginalCreatorId()
				};

				finderCache.removeResult(_finderPathCountByCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCreator, args);

				args = new Object[] {video_CreatorModelImpl.getCreatorId()};

				finderCache.removeResult(_finderPathCountByCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCreator, args);
			}

			if ((video_CreatorModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideoCreator.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					video_CreatorModelImpl.getOriginalVideoId(),
					video_CreatorModelImpl.getOriginalCreatorId()
				};

				finderCache.removeResult(_finderPathCountByVideoCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideoCreator, args);

				args = new Object[] {
					video_CreatorModelImpl.getVideoId(),
					video_CreatorModelImpl.getCreatorId()
				};

				finderCache.removeResult(_finderPathCountByVideoCreator, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideoCreator, args);
			}
		}

		entityCache.putResult(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey(),
			video_Creator, false);

		video_Creator.resetOriginalValues();

		return video_Creator;
	}

	/**
	 * Returns the video_ creator with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_CreatorException {

		Video_Creator video_Creator = fetchByPrimaryKey(primaryKey);

		if (video_Creator == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_CreatorException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return video_Creator;
	}

	/**
	 * Returns the video_ creator with the primary key or throws a <code>NoSuchVideo_CreatorException</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator findByPrimaryKey(long videoCreatorId)
		throws NoSuchVideo_CreatorException {

		return findByPrimaryKey((Serializable)videoCreatorId);
	}

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator fetchByPrimaryKey(long videoCreatorId) {
		return fetchByPrimaryKey((Serializable)videoCreatorId);
	}

	/**
	 * Returns all the video_ creators.
	 *
	 * @return the video_ creators
	 */
	@Override
	public List<Video_Creator> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of video_ creators
	 */
	@Override
	public List<Video_Creator> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ creators
	 */
	@Override
	public List<Video_Creator> findAll(
		int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Video_CreatorModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video_ creators
	 */
	@Override
	public List<Video_Creator> findAll(
		int start, int end, OrderByComparator<Video_Creator> orderByComparator,
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

		List<Video_Creator> list = null;

		if (useFinderCache) {
			list = (List<Video_Creator>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VIDEO_CREATOR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_CREATOR;

				sql = sql.concat(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Video_Creator>)QueryUtil.list(
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
	 * Removes all the video_ creators from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video_Creator video_Creator : findAll()) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators.
	 *
	 * @return the number of video_ creators
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VIDEO_CREATOR);

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
		return "videoCreatorId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VIDEO_CREATOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Video_CreatorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video_ creator persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByVideo = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideo = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideo", new String[] {Long.class.getName()},
			Video_CreatorModelImpl.VIDEOID_COLUMN_BITMASK);

		_finderPathCountByVideo = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCreator = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreator",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCreator = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreator", new String[] {Long.class.getName()},
			Video_CreatorModelImpl.CREATORID_COLUMN_BITMASK);

		_finderPathCountByCreator = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreator",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByVideoCreator = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideoCreator",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideoCreator = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideoCreator",
			new String[] {Long.class.getName(), Long.class.getName()},
			Video_CreatorModelImpl.VIDEOID_COLUMN_BITMASK |
			Video_CreatorModelImpl.CREATORID_COLUMN_BITMASK);

		_finderPathCountByVideoCreator = new FinderPath(
			Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoCreator",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(Video_CreatorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VIDEO_CREATOR =
		"SELECT video_Creator FROM Video_Creator video_Creator";

	private static final String _SQL_SELECT_VIDEO_CREATOR_WHERE =
		"SELECT video_Creator FROM Video_Creator video_Creator WHERE ";

	private static final String _SQL_COUNT_VIDEO_CREATOR =
		"SELECT COUNT(video_Creator) FROM Video_Creator video_Creator";

	private static final String _SQL_COUNT_VIDEO_CREATOR_WHERE =
		"SELECT COUNT(video_Creator) FROM Video_Creator video_Creator WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Creator.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Video_Creator exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Video_Creator exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Video_CreatorPersistenceImpl.class);

}