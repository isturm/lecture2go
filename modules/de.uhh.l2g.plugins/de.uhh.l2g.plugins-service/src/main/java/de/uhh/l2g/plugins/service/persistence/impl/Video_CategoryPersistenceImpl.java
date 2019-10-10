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

import de.uhh.l2g.plugins.exception.NoSuchVideo_CategoryException;
import de.uhh.l2g.plugins.model.Video_Category;
import de.uhh.l2g.plugins.model.impl.Video_CategoryImpl;
import de.uhh.l2g.plugins.model.impl.Video_CategoryModelImpl;
import de.uhh.l2g.plugins.service.persistence.Video_CategoryPersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence implementation for the video_ category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class Video_CategoryPersistenceImpl
	extends BasePersistenceImpl<Video_Category>
	implements Video_CategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Video_CategoryUtil</code> to access the video_ category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Video_CategoryImpl.class.getName();

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
	 * Returns all the video_ categories where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ categories
	 */
	@Override
	public List<Video_Category> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ categories where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 */
	@Override
	public List<Video_Category> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideo(long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ categories
	 */
	@Deprecated
	@Override
	public List<Video_Category> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator,
		boolean useFinderCache) {

		return findByVideo(videoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 */
	@Override
	public List<Video_Category> findByVideo(
		long videoId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

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

		List<Video_Category> list = (List<Video_Category>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Category video_Category : list) {
				if ((videoId != video_Category.getVideoId())) {
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

			query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Category>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Category>)QueryUtil.list(
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
	 * Returns the first video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	@Override
	public Video_Category findByVideo_First(
			long videoId, OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = fetchByVideo_First(
			videoId, orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append("}");

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	@Override
	public Video_Category fetchByVideo_First(
		long videoId, OrderByComparator<Video_Category> orderByComparator) {

		List<Video_Category> list = findByVideo(
			videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	@Override
	public Video_Category findByVideo_Last(
			long videoId, OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = fetchByVideo_Last(
			videoId, orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append("}");

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	@Override
	public Video_Category fetchByVideo_Last(
		long videoId, OrderByComparator<Video_Category> orderByComparator) {

		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Category> list = findByVideo(
			videoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where videoId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	@Override
	public Video_Category[] findByVideo_PrevAndNext(
			long videoCategoryId, long videoId,
			OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = findByPrimaryKey(videoCategoryId);

		Session session = null;

		try {
			session = openSession();

			Video_Category[] array = new Video_CategoryImpl[3];

			array[0] = getByVideo_PrevAndNext(
				session, video_Category, videoId, orderByComparator, true);

			array[1] = video_Category;

			array[2] = getByVideo_PrevAndNext(
				session, video_Category, videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Category getByVideo_PrevAndNext(
		Session session, Video_Category video_Category, long videoId,
		OrderByComparator<Video_Category> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

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
			query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
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
						video_Category)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ categories where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Video_Category video_Category :
				findByVideo(
					videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video_Category);
		}
	}

	/**
	 * Returns the number of video_ categories where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ categories
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = _finderPathCountByVideo;

		Object[] finderArgs = new Object[] {videoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_CATEGORY_WHERE);

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
		"video_Category.videoId = ?";

	private FinderPath _finderPathWithPaginationFindByCategory;
	private FinderPath _finderPathWithoutPaginationFindByCategory;
	private FinderPath _finderPathCountByCategory;

	/**
	 * Returns all the video_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching video_ categories
	 */
	@Override
	public List<Video_Category> findByCategory(long categoryId) {
		return findByCategory(
			categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 */
	@Override
	public List<Video_Category> findByCategory(
		long categoryId, int start, int end) {

		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCategory(long, int, int, OrderByComparator)}
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ categories
	 */
	@Deprecated
	@Override
	public List<Video_Category> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator,
		boolean useFinderCache) {

		return findByCategory(categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 */
	@Override
	public List<Video_Category> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCategory;
			finderArgs = new Object[] {categoryId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCategory;
			finderArgs = new Object[] {
				categoryId, start, end, orderByComparator
			};
		}

		List<Video_Category> list = (List<Video_Category>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Category video_Category : list) {
				if ((categoryId != video_Category.getCategoryId())) {
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

			query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Video_Category>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Category>)QueryUtil.list(
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
	 * Returns the first video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	@Override
	public Video_Category findByCategory_First(
			long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = fetchByCategory_First(
			categoryId, orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the first video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	@Override
	public Video_Category fetchByCategory_First(
		long categoryId, OrderByComparator<Video_Category> orderByComparator) {

		List<Video_Category> list = findByCategory(
			categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	@Override
	public Video_Category findByCategory_Last(
			long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = fetchByCategory_Last(
			categoryId, orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the last video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	@Override
	public Video_Category fetchByCategory_Last(
		long categoryId, OrderByComparator<Video_Category> orderByComparator) {

		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<Video_Category> list = findByCategory(
			categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where categoryId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	@Override
	public Video_Category[] findByCategory_PrevAndNext(
			long videoCategoryId, long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = findByPrimaryKey(videoCategoryId);

		Session session = null;

		try {
			session = openSession();

			Video_Category[] array = new Video_CategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(
				session, video_Category, categoryId, orderByComparator, true);

			array[1] = video_Category;

			array[2] = getByCategory_PrevAndNext(
				session, video_Category, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Category getByCategory_PrevAndNext(
		Session session, Video_Category video_Category, long categoryId,
		OrderByComparator<Video_Category> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

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
			query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						video_Category)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByCategory(long categoryId) {
		for (Video_Category video_Category :
				findByCategory(
					categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video_Category);
		}
	}

	/**
	 * Returns the number of video_ categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching video_ categories
	 */
	@Override
	public int countByCategory(long categoryId) {
		FinderPath finderPath = _finderPathCountByCategory;

		Object[] finderArgs = new Object[] {categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 =
		"video_Category.categoryId = ?";

	private FinderPath _finderPathWithPaginationFindByVideoCategory;
	private FinderPath _finderPathWithoutPaginationFindByVideoCategory;
	private FinderPath _finderPathCountByVideoCategory;

	/**
	 * Returns all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @return the matching video_ categories
	 */
	@Override
	public List<Video_Category> findByVideoCategory(
		long videoId, long categoryId) {

		return findByVideoCategory(
			videoId, categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of matching video_ categories
	 */
	@Override
	public List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end) {

		return findByVideoCategory(videoId, categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByVideoCategory(long,long, int, int, OrderByComparator)}
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching video_ categories
	 */
	@Deprecated
	@Override
	public List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator,
		boolean useFinderCache) {

		return findByVideoCategory(
			videoId, categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ categories
	 */
	@Override
	public List<Video_Category> findByVideoCategory(
		long videoId, long categoryId, int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByVideoCategory;
			finderArgs = new Object[] {videoId, categoryId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByVideoCategory;
			finderArgs = new Object[] {
				videoId, categoryId, start, end, orderByComparator
			};
		}

		List<Video_Category> list = (List<Video_Category>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Video_Category video_Category : list) {
				if ((videoId != video_Category.getVideoId()) ||
					(categoryId != video_Category.getCategoryId())) {

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

			query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOCATEGORY_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOCATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Video_Category>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Category>)QueryUtil.list(
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
	 * Returns the first video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	@Override
	public Video_Category findByVideoCategory_First(
			long videoId, long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = fetchByVideoCategory_First(
			videoId, categoryId, orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the first video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	@Override
	public Video_Category fetchByVideoCategory_First(
		long videoId, long categoryId,
		OrderByComparator<Video_Category> orderByComparator) {

		List<Video_Category> list = findByVideoCategory(
			videoId, categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category
	 * @throws NoSuchVideo_CategoryException if a matching video_ category could not be found
	 */
	@Override
	public Video_Category findByVideoCategory_Last(
			long videoId, long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = fetchByVideoCategory_Last(
			videoId, categoryId, orderByComparator);

		if (video_Category != null) {
			return video_Category;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchVideo_CategoryException(msg.toString());
	}

	/**
	 * Returns the last video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ category, or <code>null</code> if a matching video_ category could not be found
	 */
	@Override
	public Video_Category fetchByVideoCategory_Last(
		long videoId, long categoryId,
		OrderByComparator<Video_Category> orderByComparator) {

		int count = countByVideoCategory(videoId, categoryId);

		if (count == 0) {
			return null;
		}

		List<Video_Category> list = findByVideoCategory(
			videoId, categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ categories before and after the current video_ category in the ordered set where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoCategoryId the primary key of the current video_ category
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	@Override
	public Video_Category[] findByVideoCategory_PrevAndNext(
			long videoCategoryId, long videoId, long categoryId,
			OrderByComparator<Video_Category> orderByComparator)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = findByPrimaryKey(videoCategoryId);

		Session session = null;

		try {
			session = openSession();

			Video_Category[] array = new Video_CategoryImpl[3];

			array[0] = getByVideoCategory_PrevAndNext(
				session, video_Category, videoId, categoryId, orderByComparator,
				true);

			array[1] = video_Category;

			array[2] = getByVideoCategory_PrevAndNext(
				session, video_Category, videoId, categoryId, orderByComparator,
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

	protected Video_Category getByVideoCategory_PrevAndNext(
		Session session, Video_Category video_Category, long videoId,
		long categoryId, OrderByComparator<Video_Category> orderByComparator,
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

		query.append(_SQL_SELECT_VIDEO_CATEGORY_WHERE);

		query.append(_FINDER_COLUMN_VIDEOCATEGORY_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOCATEGORY_CATEGORYID_2);

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
			query.append(Video_CategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						video_Category)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Video_Category> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ categories where videoId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByVideoCategory(long videoId, long categoryId) {
		for (Video_Category video_Category :
				findByVideoCategory(
					videoId, categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(video_Category);
		}
	}

	/**
	 * Returns the number of video_ categories where videoId = &#63; and categoryId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param categoryId the category ID
	 * @return the number of matching video_ categories
	 */
	@Override
	public int countByVideoCategory(long videoId, long categoryId) {
		FinderPath finderPath = _finderPathCountByVideoCategory;

		Object[] finderArgs = new Object[] {videoId, categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_CATEGORY_WHERE);

			query.append(_FINDER_COLUMN_VIDEOCATEGORY_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOCATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_VIDEOCATEGORY_VIDEOID_2 =
		"video_Category.videoId = ? AND ";

	private static final String _FINDER_COLUMN_VIDEOCATEGORY_CATEGORYID_2 =
		"video_Category.categoryId = ?";

	public Video_CategoryPersistenceImpl() {
		setModelClass(Video_Category.class);

		setModelImplClass(Video_CategoryImpl.class);
		setModelPKClass(long.class);
		setEntityCacheEnabled(Video_CategoryModelImpl.ENTITY_CACHE_ENABLED);
	}

	/**
	 * Caches the video_ category in the entity cache if it is enabled.
	 *
	 * @param video_Category the video_ category
	 */
	@Override
	public void cacheResult(Video_Category video_Category) {
		entityCache.putResult(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryImpl.class, video_Category.getPrimaryKey(),
			video_Category);

		video_Category.resetOriginalValues();
	}

	/**
	 * Caches the video_ categories in the entity cache if it is enabled.
	 *
	 * @param video_Categories the video_ categories
	 */
	@Override
	public void cacheResult(List<Video_Category> video_Categories) {
		for (Video_Category video_Category : video_Categories) {
			if (entityCache.getResult(
					Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
					Video_CategoryImpl.class, video_Category.getPrimaryKey()) ==
						null) {

				cacheResult(video_Category);
			}
			else {
				video_Category.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Video_CategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Category video_Category) {
		entityCache.removeResult(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryImpl.class, video_Category.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Category> video_Categories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Category video_Category : video_Categories) {
			entityCache.removeResult(
				Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
				Video_CategoryImpl.class, video_Category.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ category with the primary key. Does not add the video_ category to the database.
	 *
	 * @param videoCategoryId the primary key for the new video_ category
	 * @return the new video_ category
	 */
	@Override
	public Video_Category create(long videoCategoryId) {
		Video_Category video_Category = new Video_CategoryImpl();

		video_Category.setNew(true);
		video_Category.setPrimaryKey(videoCategoryId);

		return video_Category;
	}

	/**
	 * Removes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category that was removed
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	@Override
	public Video_Category remove(long videoCategoryId)
		throws NoSuchVideo_CategoryException {

		return remove((Serializable)videoCategoryId);
	}

	/**
	 * Removes the video_ category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ category
	 * @return the video_ category that was removed
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	@Override
	public Video_Category remove(Serializable primaryKey)
		throws NoSuchVideo_CategoryException {

		Session session = null;

		try {
			session = openSession();

			Video_Category video_Category = (Video_Category)session.get(
				Video_CategoryImpl.class, primaryKey);

			if (video_Category == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_CategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(video_Category);
		}
		catch (NoSuchVideo_CategoryException nsee) {
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
	protected Video_Category removeImpl(Video_Category video_Category) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Category)) {
				video_Category = (Video_Category)session.get(
					Video_CategoryImpl.class,
					video_Category.getPrimaryKeyObj());
			}

			if (video_Category != null) {
				session.delete(video_Category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Category != null) {
			clearCache(video_Category);
		}

		return video_Category;
	}

	@Override
	public Video_Category updateImpl(Video_Category video_Category) {
		boolean isNew = video_Category.isNew();

		if (!(video_Category instanceof Video_CategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(video_Category.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					video_Category);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in video_Category proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Video_Category implementation " +
					video_Category.getClass());
		}

		Video_CategoryModelImpl video_CategoryModelImpl =
			(Video_CategoryModelImpl)video_Category;

		Session session = null;

		try {
			session = openSession();

			if (video_Category.isNew()) {
				session.save(video_Category);

				video_Category.setNew(false);
			}
			else {
				video_Category = (Video_Category)session.merge(video_Category);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Video_CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {video_CategoryModelImpl.getVideoId()};

			finderCache.removeResult(_finderPathCountByVideo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideo, args);

			args = new Object[] {video_CategoryModelImpl.getCategoryId()};

			finderCache.removeResult(_finderPathCountByCategory, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCategory, args);

			args = new Object[] {
				video_CategoryModelImpl.getVideoId(),
				video_CategoryModelImpl.getCategoryId()
			};

			finderCache.removeResult(_finderPathCountByVideoCategory, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByVideoCategory, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((video_CategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideo.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					video_CategoryModelImpl.getOriginalVideoId()
				};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);

				args = new Object[] {video_CategoryModelImpl.getVideoId()};

				finderCache.removeResult(_finderPathCountByVideo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideo, args);
			}

			if ((video_CategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCategory.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					video_CategoryModelImpl.getOriginalCategoryId()
				};

				finderCache.removeResult(_finderPathCountByCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategory, args);

				args = new Object[] {video_CategoryModelImpl.getCategoryId()};

				finderCache.removeResult(_finderPathCountByCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategory, args);
			}

			if ((video_CategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByVideoCategory.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					video_CategoryModelImpl.getOriginalVideoId(),
					video_CategoryModelImpl.getOriginalCategoryId()
				};

				finderCache.removeResult(_finderPathCountByVideoCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideoCategory, args);

				args = new Object[] {
					video_CategoryModelImpl.getVideoId(),
					video_CategoryModelImpl.getCategoryId()
				};

				finderCache.removeResult(_finderPathCountByVideoCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByVideoCategory, args);
			}
		}

		entityCache.putResult(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryImpl.class, video_Category.getPrimaryKey(),
			video_Category, false);

		video_Category.resetOriginalValues();

		return video_Category;
	}

	/**
	 * Returns the video_ category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ category
	 * @return the video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	@Override
	public Video_Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_CategoryException {

		Video_Category video_Category = fetchByPrimaryKey(primaryKey);

		if (video_Category == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_CategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return video_Category;
	}

	/**
	 * Returns the video_ category with the primary key or throws a <code>NoSuchVideo_CategoryException</code> if it could not be found.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category
	 * @throws NoSuchVideo_CategoryException if a video_ category with the primary key could not be found
	 */
	@Override
	public Video_Category findByPrimaryKey(long videoCategoryId)
		throws NoSuchVideo_CategoryException {

		return findByPrimaryKey((Serializable)videoCategoryId);
	}

	/**
	 * Returns the video_ category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCategoryId the primary key of the video_ category
	 * @return the video_ category, or <code>null</code> if a video_ category with the primary key could not be found
	 */
	@Override
	public Video_Category fetchByPrimaryKey(long videoCategoryId) {
		return fetchByPrimaryKey((Serializable)videoCategoryId);
	}

	/**
	 * Returns all the video_ categories.
	 *
	 * @return the video_ categories
	 */
	@Override
	public List<Video_Category> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @return the range of video_ categories
	 */
	@Override
	public List<Video_Category> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of video_ categories
	 */
	@Deprecated
	@Override
	public List<Video_Category> findAll(
		int start, int end, OrderByComparator<Video_Category> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the video_ categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>Video_CategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ categories
	 * @param end the upper bound of the range of video_ categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ categories
	 */
	@Override
	public List<Video_Category> findAll(
		int start, int end,
		OrderByComparator<Video_Category> orderByComparator) {

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

		List<Video_Category> list = (List<Video_Category>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEO_CATEGORY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_CATEGORY;

				if (pagination) {
					sql = sql.concat(Video_CategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Category>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Category>)QueryUtil.list(
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
	 * Removes all the video_ categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video_Category video_Category : findAll()) {
			remove(video_Category);
		}
	}

	/**
	 * Returns the number of video_ categories.
	 *
	 * @return the number of video_ categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEO_CATEGORY);

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
		return "videoCategoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VIDEO_CATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Video_CategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video_ category persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByVideo = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideo = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideo", new String[] {Long.class.getName()},
			Video_CategoryModelImpl.VIDEOID_COLUMN_BITMASK);

		_finderPathCountByVideo = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCategory = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCategory",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCategory = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCategory", new String[] {Long.class.getName()},
			Video_CategoryModelImpl.CATEGORYID_COLUMN_BITMASK);

		_finderPathCountByCategory = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByVideoCategory = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideoCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByVideoCategory = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED,
			Video_CategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideoCategory",
			new String[] {Long.class.getName(), Long.class.getName()},
			Video_CategoryModelImpl.VIDEOID_COLUMN_BITMASK |
			Video_CategoryModelImpl.CATEGORYID_COLUMN_BITMASK);

		_finderPathCountByVideoCategory = new FinderPath(
			Video_CategoryModelImpl.ENTITY_CACHE_ENABLED,
			Video_CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoCategory",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(Video_CategoryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VIDEO_CATEGORY =
		"SELECT video_Category FROM Video_Category video_Category";

	private static final String _SQL_SELECT_VIDEO_CATEGORY_WHERE =
		"SELECT video_Category FROM Video_Category video_Category WHERE ";

	private static final String _SQL_COUNT_VIDEO_CATEGORY =
		"SELECT COUNT(video_Category) FROM Video_Category video_Category";

	private static final String _SQL_COUNT_VIDEO_CATEGORY_WHERE =
		"SELECT COUNT(video_Category) FROM Video_Category video_Category WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Category.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Video_Category exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Video_Category exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		Video_CategoryPersistenceImpl.class);

}