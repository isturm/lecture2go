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

import de.uhh.l2g.plugins.exception.NoSuchVideo_MediaTypeException;
import de.uhh.l2g.plugins.model.Video_MediaType;
import de.uhh.l2g.plugins.model.impl.Video_MediaTypeImpl;
import de.uhh.l2g.plugins.model.impl.Video_MediaTypeModelImpl;
import de.uhh.l2g.plugins.service.persistence.Video_MediaTypePersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence implementation for the video_ media type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Video_MediaTypePersistenceImpl
	extends BasePersistenceImpl<Video_MediaType>
	implements Video_MediaTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Video_MediaTypeUtil</code> to access the video_ media type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Video_MediaTypeImpl.class.getName();

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
	 * Returns all the video_ media types where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideo(long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	@Deprecated
	@Override
	public List<Video_MediaType> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean useFinderCache) {

		return findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByVideo;
			finderArgs = new Object[] {videoId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByVideo;
			finderArgs = new Object[] {videoId, start, end, orderByComparator};
		}

		List<Video_MediaType> list =
			(List<Video_MediaType>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_MediaType video_MediaType : list) {
				if ((videoId != video_MediaType.getVideoId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_MEDIATYPE_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Video_MediaTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_MediaType>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_MediaType>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType findByVideo_First(
			long videoId, OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = fetchByVideo_First(
			videoId, orderByComparator);

		if (video_MediaType != null) {
			return video_MediaType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append("}");

		throw new NoSuchVideo_MediaTypeException(msg.toString());
	}

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType fetchByVideo_First(
		long videoId, OrderByComparator<Video_MediaType> orderByComparator) {

		List<Video_MediaType> list = findByVideo(
			videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType findByVideo_Last(
			long videoId, OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = fetchByVideo_Last(
			videoId, orderByComparator);

		if (video_MediaType != null) {
			return video_MediaType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append("}");

		throw new NoSuchVideo_MediaTypeException(msg.toString());
	}

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType fetchByVideo_Last(
		long videoId, OrderByComparator<Video_MediaType> orderByComparator) {

		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_MediaType> list = findByVideo(
			videoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ media types before and after the current video_ media type in the ordered set where videoId = &#63;.
	 *
	 * @param videoMediaTypeId the primary key of the current video_ media type
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	@Override
	public Video_MediaType[] findByVideo_PrevAndNext(
			long videoMediaTypeId, long videoId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = findByPrimaryKey(videoMediaTypeId);

		Session session = null;

		try {
			session = openSession();

			Video_MediaType[] array = new Video_MediaTypeImpl[3];

			array[0] = getByVideo_PrevAndNext(
				session, video_MediaType, videoId, orderByComparator, true);

			array[1] = video_MediaType;

			array[2] = getByVideo_PrevAndNext(
				session, video_MediaType, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_MediaType getByVideo_PrevAndNext(
		Session session, Video_MediaType video_MediaType, long videoId,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_MEDIATYPE_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_MediaTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						video_MediaType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video_MediaType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ media types where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Video_MediaType video_MediaType :
				findByVideo(
					videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video_MediaType);
		}
	}

	/**
	 * Returns the number of video_ media types where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ media types
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = _finderPathCountByVideo;

		Object[] finderArgs = new Object[] {videoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_MEDIATYPE_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 =
		"video_MediaType.videoId = ?";

	private FinderPath _finderPathWithPaginationFindByMediaType;
	private FinderPath _finderPathWithoutPaginationFindByMediaType;
	private FinderPath _finderPathCountByMediaType;

	/**
	 * Returns all the video_ media types where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @return the matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByMediaType(long MediaTypeId) {
		return findByMediaType(
			MediaTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end) {

		return findByMediaType(MediaTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByMediaType(long, int, int, OrderByComparator)}
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	@Deprecated
	@Override
	public List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean useFinderCache) {

		return findByMediaType(MediaTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ media types where MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByMediaType(
		long MediaTypeId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByMediaType;
			finderArgs = new Object[] {MediaTypeId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByMediaType;
			finderArgs = new Object[] {
				MediaTypeId, start, end, orderByComparator
			};
		}

		List<Video_MediaType> list =
			(List<Video_MediaType>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_MediaType video_MediaType : list) {
				if ((MediaTypeId != video_MediaType.getMediaTypeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_MEDIATYPE_WHERE);

			query.append(_FINDER_COLUMN_MEDIATYPE_MEDIATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Video_MediaTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MediaTypeId);

				if (!pagination) {
					list = (List<Video_MediaType>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_MediaType>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType findByMediaType_First(
			long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = fetchByMediaType_First(
			MediaTypeId, orderByComparator);

		if (video_MediaType != null) {
			return video_MediaType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MediaTypeId=");
		msg.append(MediaTypeId);

		msg.append("}");

		throw new NoSuchVideo_MediaTypeException(msg.toString());
	}

	/**
	 * Returns the first video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType fetchByMediaType_First(
		long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator) {

		List<Video_MediaType> list = findByMediaType(
			MediaTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType findByMediaType_Last(
			long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = fetchByMediaType_Last(
			MediaTypeId, orderByComparator);

		if (video_MediaType != null) {
			return video_MediaType;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("MediaTypeId=");
		msg.append(MediaTypeId);

		msg.append("}");

		throw new NoSuchVideo_MediaTypeException(msg.toString());
	}

	/**
	 * Returns the last video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType fetchByMediaType_Last(
		long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator) {

		int count = countByMediaType(MediaTypeId);

		if (count == 0) {
			return null;
		}

		List<Video_MediaType> list = findByMediaType(
			MediaTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ media types before and after the current video_ media type in the ordered set where MediaTypeId = &#63;.
	 *
	 * @param videoMediaTypeId the primary key of the current video_ media type
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	@Override
	public Video_MediaType[] findByMediaType_PrevAndNext(
			long videoMediaTypeId, long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = findByPrimaryKey(videoMediaTypeId);

		Session session = null;

		try {
			session = openSession();

			Video_MediaType[] array = new Video_MediaTypeImpl[3];

			array[0] = getByMediaType_PrevAndNext(
				session, video_MediaType, MediaTypeId, orderByComparator, true);

			array[1] = video_MediaType;

			array[2] = getByMediaType_PrevAndNext(
				session, video_MediaType, MediaTypeId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_MediaType getByMediaType_PrevAndNext(
		Session session, Video_MediaType video_MediaType, long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_MEDIATYPE_WHERE);

		query.append(_FINDER_COLUMN_MEDIATYPE_MEDIATYPEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_MediaTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(MediaTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						video_MediaType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video_MediaType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ media types where MediaTypeId = &#63; from the database.
	 *
	 * @param MediaTypeId the media type ID
	 */
	@Override
	public void removeByMediaType(long MediaTypeId) {
		for (Video_MediaType video_MediaType :
				findByMediaType(
					MediaTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video_MediaType);
		}
	}

	/**
	 * Returns the number of video_ media types where MediaTypeId = &#63;.
	 *
	 * @param MediaTypeId the media type ID
	 * @return the number of matching video_ media types
	 */
	@Override
	public int countByMediaType(long MediaTypeId) {
		FinderPath finderPath = _finderPathCountByMediaType;

		Object[] finderArgs = new Object[] {MediaTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_MEDIATYPE_WHERE);

			query.append(_FINDER_COLUMN_MEDIATYPE_MEDIATYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(MediaTypeId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MEDIATYPE_MEDIATYPEID_2 =
		"video_MediaType.MediaTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByVideoMediaType;
	private FinderPath _finderPathWithoutPaginationFindByVideoMediaType;
	private FinderPath _finderPathCountByVideoMediaType;

	/**
	 * Returns all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @return the matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId) {

		return findByVideoMediaType(
			videoId, MediaTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end) {

		return findByVideoMediaType(videoId, MediaTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideoMediaType(long,long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ media types
	 */
	@Deprecated
	@Override
	public List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean useFinderCache) {

		return findByVideoMediaType(
			videoId, MediaTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ media types
	 */
	@Override
	public List<Video_MediaType> findByVideoMediaType(
		long videoId, long MediaTypeId, int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByVideoMediaType;
			finderArgs = new Object[] {videoId, MediaTypeId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByVideoMediaType;
			finderArgs = new Object[] {
				videoId, MediaTypeId, start, end, orderByComparator
			};
		}

		List<Video_MediaType> list =
			(List<Video_MediaType>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_MediaType video_MediaType : list) {
				if ((videoId != video_MediaType.getVideoId()) ||
					(MediaTypeId != video_MediaType.getMediaTypeId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VIDEO_MEDIATYPE_WHERE);

			query.append(_FINDER_COLUMN_VIDEOMEDIATYPE_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOMEDIATYPE_MEDIATYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Video_MediaTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(MediaTypeId);

				if (!pagination) {
					list = (List<Video_MediaType>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_MediaType>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType findByVideoMediaType_First(
			long videoId, long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = fetchByVideoMediaType_First(
			videoId, MediaTypeId, orderByComparator);

		if (video_MediaType != null) {
			return video_MediaType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", MediaTypeId=");
		msg.append(MediaTypeId);

		msg.append("}");

		throw new NoSuchVideo_MediaTypeException(msg.toString());
	}

	/**
	 * Returns the first video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType fetchByVideoMediaType_First(
		long videoId, long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator) {

		List<Video_MediaType> list = findByVideoMediaType(
			videoId, MediaTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType findByVideoMediaType_Last(
			long videoId, long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = fetchByVideoMediaType_Last(
			videoId, MediaTypeId, orderByComparator);

		if (video_MediaType != null) {
			return video_MediaType;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", MediaTypeId=");
		msg.append(MediaTypeId);

		msg.append("}");

		throw new NoSuchVideo_MediaTypeException(msg.toString());
	}

	/**
	 * Returns the last video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ media type, or <code>null</code> if a matching video_ media type could not be found
	 */
	@Override
	public Video_MediaType fetchByVideoMediaType_Last(
		long videoId, long MediaTypeId,
		OrderByComparator<Video_MediaType> orderByComparator) {

		int count = countByVideoMediaType(videoId, MediaTypeId);

		if (count == 0) {
			return null;
		}

		List<Video_MediaType> list = findByVideoMediaType(
			videoId, MediaTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ media types before and after the current video_ media type in the ordered set where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoMediaTypeId the primary key of the current video_ media type
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	@Override
	public Video_MediaType[] findByVideoMediaType_PrevAndNext(
			long videoMediaTypeId, long videoId, long MediaTypeId,
			OrderByComparator<Video_MediaType> orderByComparator)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = findByPrimaryKey(videoMediaTypeId);

		Session session = null;

		try {
			session = openSession();

			Video_MediaType[] array = new Video_MediaTypeImpl[3];

			array[0] = getByVideoMediaType_PrevAndNext(
				session, video_MediaType, videoId, MediaTypeId,
				orderByComparator, true);

			array[1] = video_MediaType;

			array[2] = getByVideoMediaType_PrevAndNext(
				session, video_MediaType, videoId, MediaTypeId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_MediaType getByVideoMediaType_PrevAndNext(
		Session session, Video_MediaType video_MediaType, long videoId,
		long MediaTypeId, OrderByComparator<Video_MediaType> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_MEDIATYPE_WHERE);

		query.append(_FINDER_COLUMN_VIDEOMEDIATYPE_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOMEDIATYPE_MEDIATYPEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_MediaTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(MediaTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						video_MediaType)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video_MediaType> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ media types where videoId = &#63; and MediaTypeId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 */
	@Override
	public void removeByVideoMediaType(long videoId, long MediaTypeId) {
		for (Video_MediaType video_MediaType :
				findByVideoMediaType(
					videoId, MediaTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(video_MediaType);
		}
	}

	/**
	 * Returns the number of video_ media types where videoId = &#63; and MediaTypeId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param MediaTypeId the media type ID
	 * @return the number of matching video_ media types
	 */
	@Override
	public int countByVideoMediaType(long videoId, long MediaTypeId) {
		FinderPath finderPath = _finderPathCountByVideoMediaType;

		Object[] finderArgs = new Object[] {videoId, MediaTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_MEDIATYPE_WHERE);

			query.append(_FINDER_COLUMN_VIDEOMEDIATYPE_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOMEDIATYPE_MEDIATYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(MediaTypeId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEOMEDIATYPE_VIDEOID_2 =
		"video_MediaType.videoId = ? AND ";

	private static final String _FINDER_COLUMN_VIDEOMEDIATYPE_MEDIATYPEID_2 =
		"video_MediaType.MediaTypeId = ?";

	public Video_MediaTypePersistenceImpl() {
		setModelClass(Video_MediaType.class);

		setModelImplClass(Video_MediaTypeImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the video_ media type in the entity cache if it is enabled.
	 *
	 * @param video_MediaType the video_ media type
	 */
	@Override
	public void cacheResult(Video_MediaType video_MediaType) {
		entityCache.putResult(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeImpl.class, video_MediaType.getPrimaryKey(),
			video_MediaType);

		video_MediaType.resetOriginalValues();
	}

	/**
	 * Caches the video_ media types in the entity cache if it is enabled.
	 *
	 * @param video_MediaTypes the video_ media types
	 */
	@Override
	public void cacheResult(List<Video_MediaType> video_MediaTypes) {
		for (Video_MediaType video_MediaType : video_MediaTypes) {
			if (entityCache.getResult(
					Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
					Video_MediaTypeImpl.class,
					video_MediaType.getPrimaryKey()) == null) {

				cacheResult(video_MediaType);
			}
			else {
				video_MediaType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ media types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Video_MediaTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ media type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_MediaType video_MediaType) {
		entityCache.removeResult(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeImpl.class, video_MediaType.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_MediaType> video_MediaTypes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_MediaType video_MediaType : video_MediaTypes) {
			entityCache.removeResult(
				Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
				Video_MediaTypeImpl.class, video_MediaType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ media type with the primary key. Does not add the video_ media type to the database.
	 *
	 * @param videoMediaTypeId the primary key for the new video_ media type
	 * @return the new video_ media type
	 */
	@Override
	public Video_MediaType create(long videoMediaTypeId) {
		Video_MediaType video_MediaType = new Video_MediaTypeImpl();

		video_MediaType.setNew(true);
		video_MediaType.setPrimaryKey(videoMediaTypeId);

		return video_MediaType;
	}

	/**
	 * Removes the video_ media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type that was removed
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	@Override
	public Video_MediaType remove(long videoMediaTypeId)
		throws NoSuchVideo_MediaTypeException {

		return remove((Serializable)videoMediaTypeId);
	}

	/**
	 * Removes the video_ media type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ media type
	 * @return the video_ media type that was removed
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	@Override
	public Video_MediaType remove(Serializable primaryKey)
		throws NoSuchVideo_MediaTypeException {

		Session session = null;

		try {
			session = openSession();

			Video_MediaType video_MediaType = (Video_MediaType)session.get(
				Video_MediaTypeImpl.class, primaryKey);

			if (video_MediaType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_MediaTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(video_MediaType);
		}
		catch (NoSuchVideo_MediaTypeException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Video_MediaType removeImpl(Video_MediaType video_MediaType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_MediaType)) {
				video_MediaType = (Video_MediaType)session.get(
					Video_MediaTypeImpl.class,
					video_MediaType.getPrimaryKeyObj());
			}

			if (video_MediaType != null) {
				session.delete(video_MediaType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_MediaType != null) {
			clearCache(video_MediaType);
		}

		return video_MediaType;
	}

	@Override
	public Video_MediaType updateImpl(Video_MediaType video_MediaType) {
		boolean isNew = video_MediaType.isNew();

		if (!(video_MediaType instanceof Video_MediaTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(video_MediaType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					video_MediaType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in video_MediaType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Video_MediaType implementation " +
					video_MediaType.getClass());
		}

		Video_MediaTypeModelImpl video_MediaTypeModelImpl =
			(Video_MediaTypeModelImpl)video_MediaType;

		Session session = null;

		try {
			session = openSession();

			if (video_MediaType.isNew()) {
				session.save(video_MediaType);

				video_MediaType.setNew(false);
			}
			else {
				video_MediaType = (Video_MediaType)session.merge(
					video_MediaType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Video_MediaTypeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				video_MediaTypeModelImpl.getVideoId()
			};

			finderCache.removeResult(_finderPathCountByVideo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideo, args);

			args = new Object[] {video_MediaTypeModelImpl.getMediaTypeId()};

			finderCache.removeResult(_finderPathCountByMediaType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByMediaType, args);

			args = new Object[] {
				video_MediaTypeModelImpl.getVideoId(),
				video_MediaTypeModelImpl.getMediaTypeId()
			};

			finderCache.removeResult(_finderPathCountByVideoMediaType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideoMediaType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((video_MediaTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					video_MediaTypeModelImpl.getOriginalVideoId()
				};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);

				args = new Object[] {video_MediaTypeModelImpl.getVideoId()};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);
			}

			if ((video_MediaTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByMediaType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					video_MediaTypeModelImpl.getOriginalMediaTypeId()
				};

				finderCache.removeResult(_finderPathCountByMediaType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMediaType, args);

				args = new Object[] {video_MediaTypeModelImpl.getMediaTypeId()};

				finderCache.removeResult(_finderPathCountByMediaType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByMediaType, args);
			}

			if ((video_MediaTypeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideoMediaType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					video_MediaTypeModelImpl.getOriginalVideoId(),
					video_MediaTypeModelImpl.getOriginalMediaTypeId()
				};

				finderCache.removeResult(
					_finderPathCountByVideoMediaType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideoMediaType, args);

				args = new Object[] {
					video_MediaTypeModelImpl.getVideoId(),
					video_MediaTypeModelImpl.getMediaTypeId()
				};

				finderCache.removeResult(
					_finderPathCountByVideoMediaType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideoMediaType, args);
			}
		}

		entityCache.putResult(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeImpl.class, video_MediaType.getPrimaryKey(),
			video_MediaType, false);

		video_MediaType.resetOriginalValues();

		return video_MediaType;
	}

	/**
	 * Returns the video_ media type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ media type
	 * @return the video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	@Override
	public Video_MediaType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_MediaTypeException {

		Video_MediaType video_MediaType = fetchByPrimaryKey(primaryKey);

		if (video_MediaType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_MediaTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return video_MediaType;
	}

	/**
	 * Returns the video_ media type with the primary key or throws a <code>NoSuchVideo_MediaTypeException</code> if it could not be found.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type
	 * @throws NoSuchVideo_MediaTypeException if a video_ media type with the primary key could not be found
	 */
	@Override
	public Video_MediaType findByPrimaryKey(long videoMediaTypeId)
		throws NoSuchVideo_MediaTypeException {

		return findByPrimaryKey((Serializable)videoMediaTypeId);
	}

	/**
	 * Returns the video_ media type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoMediaTypeId the primary key of the video_ media type
	 * @return the video_ media type, or <code>null</code> if a video_ media type with the primary key could not be found
	 */
	@Override
	public Video_MediaType fetchByPrimaryKey(long videoMediaTypeId) {
		return fetchByPrimaryKey((Serializable)videoMediaTypeId);
	}

	/**
	 * Returns all the video_ media types.
	 *
	 * @return the video_ media types
	 */
	@Override
	public List<Video_MediaType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @return the range of video_ media types
	 */
	@Override
	public List<Video_MediaType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video_ media types
	 */
	@Deprecated
	@Override
	public List<Video_MediaType> findAll(
		int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ media types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_MediaTypeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ media types
	 * @param end the upper bound of the range of video_ media types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ media types
	 */
	@Override
	public List<Video_MediaType> findAll(
		int start, int end,
		OrderByComparator<Video_MediaType> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Video_MediaType> list =
			(List<Video_MediaType>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEO_MEDIATYPE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_MEDIATYPE;

				if (pagination) {
					sql = sql.concat(Video_MediaTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_MediaType>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_MediaType>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the video_ media types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video_MediaType video_MediaType : findAll()) {
			remove(video_MediaType);
		}
	}

	/**
	 * Returns the number of video_ media types.
	 *
	 * @return the number of video_ media types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEO_MEDIATYPE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
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
		return "videoMediaTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VIDEO_MEDIATYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Video_MediaTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video_ media type persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED,
			Video_MediaTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED,
			Video_MediaTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByVideo = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED,
			Video_MediaTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideo = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED,
			Video_MediaTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] {Long.class.getName()},
			Video_MediaTypeModelImpl.VIDEOID_COLUMN_BITMASK);

		_finderPathCountByVideo = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByMediaType = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED,
			Video_MediaTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByMediaType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByMediaType = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED,
			Video_MediaTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMediaType",
			new String[] {Long.class.getName()},
			Video_MediaTypeModelImpl.MEDIATYPEID_COLUMN_BITMASK);

		_finderPathCountByMediaType = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMediaType",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByVideoMediaType = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED,
			Video_MediaTypeImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideoMediaType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideoMediaType = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED,
			Video_MediaTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideoMediaType",
			new String[] {Long.class.getName(), Long.class.getName()},
			Video_MediaTypeModelImpl.VIDEOID_COLUMN_BITMASK |
			Video_MediaTypeModelImpl.MEDIATYPEID_COLUMN_BITMASK);

		_finderPathCountByVideoMediaType = new FinderPath(
			Video_MediaTypeModelImpl.ENTITY_CACHE_ENABLED,
			Video_MediaTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoMediaType",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(Video_MediaTypeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VIDEO_MEDIATYPE =
		"SELECT video_MediaType FROM Video_MediaType video_MediaType";

	private static final String _SQL_SELECT_VIDEO_MEDIATYPE_WHERE =
		"SELECT video_MediaType FROM Video_MediaType video_MediaType WHERE ";

	private static final String _SQL_COUNT_VIDEO_MEDIATYPE =
		"SELECT COUNT(video_MediaType) FROM Video_MediaType video_MediaType";

	private static final String _SQL_COUNT_VIDEO_MEDIATYPE_WHERE =
		"SELECT COUNT(video_MediaType) FROM Video_MediaType video_MediaType WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "video_MediaType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Video_MediaType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Video_MediaType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Video_MediaTypePersistenceImpl.class);

}