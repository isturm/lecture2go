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

package de.uhh.l2g.plugins.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;

import de.uhh.l2g.plugins.model.Creator;
import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Lectureseries_Creator;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.Lectureseries_CreatorImpl;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CreatorLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.CreatorLocalServiceBaseImpl;

/**
 * The implementation of the creator local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.CreatorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.CreatorLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.CreatorLocalServiceUtil
 */
public class CreatorLocalServiceImpl extends CreatorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.CreatorLocalServiceUtil} to access the creator local service.
	 */

	public List<Creator> getAll() throws SystemException{
		List<Creator> cl = new ArrayList<Creator>();
		cl = creatorPersistence.findAll();
		return cl;
	}
	
	public List<Creator> getAllByCompany(Long companyId) throws SystemException{
		List<Creator> cl = new ArrayList<Creator>();
		cl = creatorPersistence.findByCompany(companyId);
		return cl;
	}
	
	public List<Creator> getAllByGroup(Long groupId) throws SystemException{
		List<Creator> cl = new ArrayList<Creator>();
		cl = creatorPersistence.findByCompany(groupId);
		return cl;
	}
	
	public List<Creator> getCreatorsByLectureseriesId(Long lectureseriesId){
		List<Creator> cl = creatorFinder.findCreatorsByLectureseries(lectureseriesId);
		return cl;
	}

	public List<Creator> getCreatorsByLectureseriesIdForOpenAccessVideosOnly(Long lectureseriesId){
		List<Video> vl = new ArrayList<Video>();
		List<Creator> cl = new ArrayList<Creator>();
		try {
			vl = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(lectureseriesId, 1);
			ListIterator<Video> ivl = vl.listIterator();
			while(ivl.hasNext()){
				Video v = ivl.next();
				List<Creator> currcreatlist = new ArrayList<Creator>();
				currcreatlist= getCreatorsByVideoId(v.getVideoId());
				ListIterator<Creator> it = currcreatlist.listIterator();
				while(it.hasNext()){
					Creator obj = it.next();
					if(!cl.contains(obj))cl.add(obj);
				}
			}
		} catch (Exception e) {}
		return cl;
	}
	
	public String getCommaSeparatedCreatorsByLectureseriesIdAndMaxCreators(Long lectureseriesId, int maxCreators){
		List<Creator> creatorList = getCreatorsByLectureseriesIdForOpenAccessVideosOnly(lectureseriesId);
		String creators = createCommaSeparatedStringFromCreatorList(creatorList, maxCreators);
		return creators;
	}

	public String getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators(Long lectureseriesId, int maxCreators){
		List<Creator> creatorList = getCreatorsByLectureseriesIdForOpenAccessVideosOnly(lectureseriesId);
		String creators = createCommaSeparatedLinkedStringFromCreatorList(creatorList, maxCreators);
		return creators;
	}
	
	public List<Creator> getCreatorsByVideoId(Long videoId){
		List<Creator> cl = creatorFinder.findCreatorsByVideo(videoId);
		return cl;
	}
	
	public List<Creator> getCreatorsForLectureseriesOverTheAssigenedVideos(Long lectureseriesId){
		List<Creator> cl = creatorFinder.findCreatorsForLectureseriesOverTheAssigenedVideos(lectureseriesId);
		return cl;
	}
	
	public List<Creator> updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(Long lectureseriesId) throws SystemException{
		//remove all creators
		lectureseries_CreatorPersistence.removeByLectureseries(lectureseriesId);
		//add new creators to database
		List<Creator> cl = creatorFinder.findCreatorsForLectureseriesOverTheAssigenedVideos(lectureseriesId);
		ListIterator<Creator> ic = cl.listIterator();
		while (ic.hasNext()){
			Creator c = ic.next();
			Lectureseries_Creator lc = new Lectureseries_CreatorImpl();
			lc.setCreatorId(c.getCreatorId());
			lc.setLectureseriesId(lectureseriesId);
			if(!c.getFirstName().equals("N.") && !c.getLastName().equals("N."))Lectureseries_CreatorLocalServiceUtil.addLectureseries_Creator(lc);
		}
		return cl;
	}

	public void updateAllCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId() {
		List<Lectureseries> all = new ArrayList<Lectureseries>();
		try {
			all = LectureseriesLocalServiceUtil.getAll();
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		
		for (Lectureseries lectureseries: all) {
			try {
				updateCreatorsForLectureseriesOverTheAssigenedVideosByLectureseriesId(lectureseries.getLectureseriesId());
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	}

	public String getCommaSeparatedCreatorsByVideoIdAndMaxCreators(Long videoId, int maxCreators){
		List<Creator> creatorList = getCreatorsByVideoId(videoId);
		String creators = createCommaSeparatedStringFromCreatorList(creatorList, maxCreators);
		return creators;
	}

	public String getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(Long videoId, int maxCreators){
		List<Creator> creatorList = getCreatorsByVideoId(videoId);
		String creators = createCommaSeparatedLinkedStringFromCreatorList(creatorList, maxCreators);
		return creators;
	}
	
	private String createCommaSeparatedStringFromCreatorList(List<Creator> creatorList, int maxCreators) {
		String ret ="";
		try {
			List<String> creatorFullnameList = new ArrayList<String>();
			int i=0;
			for (Creator creator: creatorList) { 
				creatorFullnameList.add(creator.getFullName());
				i++;
				if(i==maxCreators)break;
			}
			
			String creators = com.liferay.portal.kernel.util.StringUtil.merge(creatorFullnameList,", ");
			if (creatorList.size() > maxCreators) {
				creators += " et al.";
			}
			ret = creators;
		}catch(Exception e) {}
		return ret;
	}
	
	private String createCommaSeparatedLinkedStringFromCreatorList(List<Creator> creatorList, int maxCreators) {
		String ret ="";
		try {
			List<String> creatorFullnameList = new ArrayList<String>();
			int i=0;
			for (Creator creator: creatorList) { 
				String fn = creator.getFullName();
				//?_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery=Prof. Dr. Marc Frey
				String fnLink = "<a href='/l2go/-/get/0/0/0/0/0/?_lgopenaccessvideos_WAR_lecture2goportlet_searchQuery="+fn+"'>"+fn+"</a>";;
				creatorFullnameList.add(fnLink);
				i++;
				if(i==maxCreators)break;
			}
			
			String creators = com.liferay.portal.kernel.util.StringUtil.merge(creatorFullnameList,", ");
			if (creatorList.size() > maxCreators) {
				creators += " et al.";
			}
			ret= creators;
		}catch (Exception e) {}
		return ret;
	}
	
	public  com.liferay.portal.kernel.json.JSONArray getJSONCreatorsByVideoId(Long videoId){
		List<Creator> cl = getCreatorsByVideoId(videoId);
		ListIterator<Creator> i = cl.listIterator();
		JSONArray json = JSONFactoryUtil.createJSONArray();
		while(i.hasNext()){
			Creator cr = i.next();
			JSONObject c = JSONFactoryUtil.createJSONObject();
			c.put("creatorId", cr.getCreatorId());
			c.put("firstName", cr.getFirstName());
			c.put("lastName", cr.getLastName());
			c.put("middleName", cr.getMiddleName());
			c.put("jobTitle", cr.getJobTitle());
			c.put("gender", cr.getGender());
			c.put("fullName", cr.getFullName());
			json.put(c);
		}
		return json;
	}
	
	public com.liferay.portal.kernel.json.JSONArray getJSONCreatorsByLectureseriesId(Long lectureseriesId){
		List<Creator> cl = getCreatorsByLectureseriesId(lectureseriesId);
		ListIterator<Creator> i = cl.listIterator();
		JSONArray json = JSONFactoryUtil.createJSONArray();
		while(i.hasNext()){
			Creator cr = i.next();
			JSONObject c = JSONFactoryUtil.createJSONObject();
			c.put("creatorId", cr.getCreatorId());
			c.put("firstName", cr.getFirstName());
			c.put("lastName", cr.getLastName());
			c.put("middleName", cr.getMiddleName());
			c.put("jobTitle", cr.getJobTitle());
			c.put("gender", cr.getGender());
			c.put("fullName", cr.getFullName());
			json.put(c);
		}
		return json;
	}
	
	public com.liferay.portal.kernel.json.JSONArray getJSONCreatorArray(Long creatorId) throws PortalException, SystemException{
		Creator cr = getCreator(creatorId);
		JSONArray json = JSONFactoryUtil.createJSONArray();
		JSONObject c = JSONFactoryUtil.createJSONObject();
		c.put("creatorId", cr.getCreatorId());
		c.put("firstName", cr.getFirstName());
		c.put("lastName", cr.getLastName());
		c.put("middleName", cr.getMiddleName());
		c.put("jobTitle", cr.getJobTitle());
		c.put("gender", cr.getGender());
		c.put("fullName", cr.getFullName());
		json.put(c);
		return json;
	}
	
	public com.liferay.portal.kernel.json.JSONObject getJSONCreatorObject(Long creatorId) throws PortalException, SystemException{
		Creator cr = getCreator(creatorId);
		JSONObject c = JSONFactoryUtil.createJSONObject();
		c.put("creatorId", cr.getCreatorId());
		c.put("firstName", cr.getFirstName());
		c.put("lastName", cr.getLastName());
		c.put("middleName", cr.getMiddleName());
		c.put("jobTitle", cr.getJobTitle());
		c.put("gender", cr.getGender());
		c.put("fullName", cr.getFullName());
		return c;
	}
	
	public List<Creator> getByFullName(String fullName) throws SystemException{
		return creatorPersistence.findByFullName(fullName);
	}
	
	public List<Creator> getCreatorsFromLectureseriesIdsAndVideoIds(ArrayList<Long> lectureseriesIds, ArrayList<Long> videoIds) {
		return creatorFinder.findCreatorsByLectureseriesIdsAndVideoIds(lectureseriesIds, videoIds);
	}
	
	public void deleteById(Long id) throws NoSuchModelException, SystemException{
		video_CreatorPersistence.removeByCreator(id);
		lectureseries_CreatorPersistence.removeByCreator(id);
		creatorPersistence.remove(id);
	}

	public List<Creator> getByJobTitleFirstNameMiddleNameLastNameFullName(String jobTitle, String firstName, String middleName, String lastName, String fullName, boolean isAndOperator) throws SystemException {
		return getByJobTitleFirstNameMiddleNameLastNameFullNameAndCompanyId( jobTitle,  firstName,  middleName,  lastName,  fullName,  new Long(0),  isAndOperator);
	}

	public List<Creator> getByJobTitleFirstNameMiddleNameLastNameFullNameAndCompanyId(String jobTitle, String firstName, String middleName, String lastName, String fullName, Long companyId, boolean isAndOperator) throws SystemException {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(de.uhh.l2g.plugins.model.impl.CreatorImpl.class, "creat");
		Junction junction = null;
		List<Creator> creatorList = Collections.emptyList();

		// OR or AND junction 
		if (isAndOperator) junction = RestrictionsFactoryUtil.conjunction();
		else junction = RestrictionsFactoryUtil.disjunction();
		//title search
		if (!jobTitle.isEmpty()) junction.add(PropertyFactoryUtil.forName("creat.jobTitle").like(StringPool.PERCENT + HtmlUtil.escape(jobTitle) + StringPool.PERCENT));
		//firstName search
		if (!firstName.isEmpty()) junction.add(PropertyFactoryUtil.forName("creat.firstName").like(StringPool.PERCENT + HtmlUtil.escape(firstName) + StringPool.PERCENT));
		//middleName search
		if (!middleName.isEmpty()) junction.add(PropertyFactoryUtil.forName("creat.middleName").like(StringPool.PERCENT + HtmlUtil.escape(middleName) + StringPool.PERCENT));
		//familyName search
		if (!lastName.isEmpty()) junction.add(PropertyFactoryUtil.forName("creat.lastName").like(StringPool.PERCENT + HtmlUtil.escape(lastName) + StringPool.PERCENT));
		//fullName search
		if (!fullName.isEmpty()) junction.add(PropertyFactoryUtil.forName("creat.fullName").like(StringPool.PERCENT + HtmlUtil.escape(fullName) + StringPool.PERCENT));
		//
		dynamicQuery.add(junction);
		
		// AND junction
		// for companyId
		if (companyId>0){
			Junction conjunction = RestrictionsFactoryUtil.conjunction();
			conjunction.add(PropertyFactoryUtil.forName("creat.companyId").eq(companyId));
			dynamicQuery.add(conjunction);
		}
		//
		try {
			creatorList = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {}
		//
		return creatorList;
	}
	
	public List<Creator> getByKeyWordsAnd(String keywords) throws SystemException {
		return getByKeyWordsAndCompanyId(keywords, new Long(0));
	}
	
	public List<Creator> getByKeyWordsAndCompanyId(String keywords, Long companyId) throws SystemException {
		List<Creator> creatorList = Collections.emptyList();
		final Junction junction = RestrictionsFactoryUtil.disjunction();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(de.uhh.l2g.plugins.model.impl.CreatorImpl.class, "creat");
		Criterion criterion = null;
		//title search
		junction.add(PropertyFactoryUtil.forName("creat.jobTitle").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT));
		//firstName search
		junction.add(PropertyFactoryUtil.forName("creat.firstName").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT));
		//middleName search
		junction.add(PropertyFactoryUtil.forName("creat.middleName").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT));
		//lastName search
		junction.add(PropertyFactoryUtil.forName("creat.lastName").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT));
		//fullName search
		junction.add(PropertyFactoryUtil.forName("creat.fullName").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT));
		//
		dynamicQuery.add(junction);
		
		// AND junction
		// for companyId
		if (companyId>0){
			Junction conjunction = RestrictionsFactoryUtil.conjunction();
			conjunction.add(PropertyFactoryUtil.forName("creat.companyId").eq(companyId));
			dynamicQuery.add(conjunction);
		}
		//		
		try {
			creatorList = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {}
		//
		return creatorList;
	}
}