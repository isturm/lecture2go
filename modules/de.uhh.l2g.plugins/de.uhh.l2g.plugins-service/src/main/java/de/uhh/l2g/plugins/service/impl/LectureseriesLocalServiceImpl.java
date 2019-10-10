/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import de.uhh.l2g.plugins.model.Lectureseries;
import de.uhh.l2g.plugins.model.Term;
import de.uhh.l2g.plugins.model.Video;
import de.uhh.l2g.plugins.model.impl.LectureseriesImpl;
import de.uhh.l2g.plugins.model.impl.VideoImpl;
import de.uhh.l2g.plugins.service.CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.Lectureseries_CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.TermLocalServiceUtil;
import de.uhh.l2g.plugins.service.VideoLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_CategoryLocalServiceUtil;
import de.uhh.l2g.plugins.service.Video_LectureseriesLocalServiceUtil;
import de.uhh.l2g.plugins.service.base.LectureseriesLocalServiceBaseImpl;

/**
 * The implementation of the lectureseries local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.uhh.l2g.plugins.service.LectureseriesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Iavor Sturm
 * @see de.uhh.l2g.plugins.service.base.LectureseriesLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil
 */
public class LectureseriesLocalServiceImpl extends LectureseriesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link de.uhh.l2g.plugins.service.LectureseriesLocalServiceUtil} to access the lectureseries local service.
	 */
	
	@Override
	public Lectureseries updateLectureseries(Lectureseries lectureseries){
		Lectureseries l = new LectureseriesImpl();
		if(lectureseries.getLectureseriesId()>0)
			try {
				l=super.updateLectureseries(lectureseries);
			} catch (SystemException e) {
				//e.printStackTrace();
			}
		return l;
	}
	
	public List<Lectureseries> getFilteredByApprovedSemesterFacultyProducer(Integer approved, Long semester, Long facultyId, Long producerId, Long groupId, Long companyId) {
		List<Lectureseries> l = lectureseriesFinder.findFilteredByApprovedSemesterFacultyProducer(approved, semester, facultyId, producerId, groupId, companyId);
		try{
			l.isEmpty();//check
		}catch(NullPointerException npe){
			l = new ArrayList<Lectureseries>();
		}
		return l;
	}
	
	public Map<Term, List<Lectureseries>> getFilteredByApprovedSemesterFacultyProducerAsTreeMapSortedByTerm(Integer approved, Long semester, Long facultyId, Long producerId, Long groupId, Long companyId) {
		List<Lectureseries> l = getFilteredByApprovedSemesterFacultyProducer(approved, semester, facultyId, producerId, groupId, companyId);
		Map<Term, List<Lectureseries>> lectureseriesTreeMapSortedByTerm = new TreeMap<Term, List<Lectureseries>>(new Comparator<Term>() {
			@Override
			public int compare(Term t1, Term t2) {
				return t2.getYear().compareTo(t1.getYear());
			}
		});
		for (Lectureseries singleLectureseries: l) {
			try{
				Term t = TermLocalServiceUtil.getTerm(singleLectureseries.getTermId());
				List<Lectureseries> tmp = lectureseriesTreeMapSortedByTerm.get(t);
			    if(tmp == null){
			    	// no object with this series before, so create new one
			        tmp = new ArrayList<Lectureseries>();
			        lectureseriesTreeMapSortedByTerm.put(t, tmp);
			    }
			    tmp.add(singleLectureseries);
			}catch(Exception e){}
		}

		return lectureseriesTreeMapSortedByTerm;
	}
	

	public List<Lectureseries> getAll() throws SystemException{
		return lectureseriesPersistence.findAll();
	}
	
	public List<Lectureseries> getAllLectureseriesWhithOpenaccessVideos(){
		return lectureseriesFinder.findAllLectureseriesWhithOpenaccessVideos();
	}
	
	public List<Lectureseries> getAllLectureseriesWhithPassword(){
		return lectureseriesFinder.findAllLectureseriesWhithPassword();
	}
	
	public List<Lectureseries> getAllForVideo(Video video){
		return lectureseriesFinder.findAllLectureseriesForVideo(video);
	}
	
	
	public List<Lectureseries> getByTerm(Long termId) throws SystemException{
		return lectureseriesPersistence.findByTerm(termId);
	} 
	
	public List<Lectureseries> getByLatestVideoId(Long latestVideoId) throws SystemException{
		return lectureseriesPersistence.findByLatestOpenAccessVideo(latestVideoId);
	} 
	
	
	public void updateOpenAccess(Video video, Lectureseries lectureseries) throws SystemException{
		// video lecture series table by video
		Video_LectureseriesLocalServiceUtil.updateOpenAccessByVideo(video);
		
		//lecture series
		Video latestOpenAccessVideo = VideoLocalServiceUtil.getLatestOpenAccessVideoForLectureseries(lectureseries.getLectureseriesId());
		lectureseries.setLatestOpenAccessVideoId(latestOpenAccessVideo.getVideoId());
		lectureseries.setLatestVideoUploadDate(latestOpenAccessVideo.getUploadDate());
		lectureseries.setLatestVideoGenerationDate(latestOpenAccessVideo.getGenerationDate());
		LectureseriesLocalServiceUtil.updateLectureseries(lectureseries);
		
		// update old entries in the lecture series table for video
		List<Lectureseries> ls = new ArrayList<Lectureseries>();
		ls = LectureseriesLocalServiceUtil.getByLatestVideoId(video.getVideoId());
		ListIterator<Lectureseries> it = ls.listIterator();
		while(it.hasNext()){
			Lectureseries l = it.next();
			Video ov = VideoLocalServiceUtil.getLatestOpenAccessVideoForLectureseries(l.getLectureseriesId());
			l.setLatestOpenAccessVideoId(ov.getVideoId());
			lectureseries.setLatestVideoUploadDate(ov.getUploadDate());
			lectureseries.setLatestVideoGenerationDate(ov.getGenerationDate());			
			LectureseriesLocalServiceUtil.updateLectureseries(l);
		}
	}

	public void updatePreviewVideoOpenAccess(Lectureseries lectureseries) throws SystemException{
		List<Video> openAccessVideosOfLectureseries = VideoLocalServiceUtil.getByLectureseriesAndOpenaccess(lectureseries.getLectureseriesId(), 1);
		
		if (lectureseries.getVideoSort() == 1) {
			//sort ascending
			Collections.sort(openAccessVideosOfLectureseries,
					new Comparator<Video>() {
						@Override
						public int compare(Video v1, Video v2) {
							return v1.getGenerationDate().compareTo(
									v2.getGenerationDate());
						}
					});
		} else {
            //sort descending
			Collections.sort(openAccessVideosOfLectureseries,
					new Comparator<Video>() {
						@Override
						public int compare(Video v1, Video v2) {
							return v2.getGenerationDate().compareTo(
									v1.getGenerationDate());
						}
					});
		}
		
		if(openAccessVideosOfLectureseries.size() < 1)
        	return;
				
		Video previewVideo = openAccessVideosOfLectureseries.get(0);			
		lectureseries.setPreviewVideoId(previewVideo.getVideoId());
		LectureseriesLocalServiceUtil.updateLectureseries(lectureseries);						
	}
	
	public void updateUploadAndGenerationDate() throws SystemException{
		List<Lectureseries> all = getAll();
		ListIterator<Lectureseries> itAll = all.listIterator();
		while(itAll.hasNext()){
			Lectureseries l = itAll.next();
			Video v = new VideoImpl();
			try {
				v = VideoLocalServiceUtil.getVideo(l.getLatestOpenAccessVideoId());
				l.setLatestVideoGenerationDate(v.getGenerationDate());
				if(v.getUploadDate()!=null)l.setLatestVideoUploadDate(v.getUploadDate());
				else {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
					Date d = new Date();
					try {
						d = format.parse(v.getGenerationDate());
						l.setLatestVideoUploadDate(d);
					} catch (ParseException e) {
						//e.printStackTrace();
					}
				}
				LectureseriesLocalServiceUtil.updateLectureseries(l);
			} catch (PortalException e) {
				//e.printStackTrace();
			}
		}
	}
	
	public void updateCategoryForLectureseries(Long lectureseriesId, Long newCategoryId) throws NoSuchModelException, SystemException{
		Lectureseries lectureseries = lectureseriesPersistence.findByPrimaryKey(lectureseriesId);
		//for related categories to this lecture, table Lectureseries_Category
		Lectureseries_CategoryLocalServiceUtil.updateCategoryByLectureseriesAndCategory(lectureseries.getLectureseriesId(), lectureseries.getCategoryId(), newCategoryId);
		//for related videos to this lecture, table Video_Category
		List<Video> vl = VideoLocalServiceUtil.getByLectureseries(lectureseries.getLectureseriesId());
		ListIterator<Video> vli = vl.listIterator();
		while(vli.hasNext()){
			Video v = vli.next();
			Video_CategoryLocalServiceUtil.updateCategoryByVideoAndCategory(v.getVideoId(), lectureseries.getCategoryId(), newCategoryId);
		}
		//for lecture series itself
		lectureseries.setCategoryId(newCategoryId);
		lectureseriesPersistence.update(lectureseries);
	}

	public List<Lectureseries> getByKeyWordsAndCompanyId(String keywords, Long companyId) throws SystemException {
		List<Lectureseries> lectureseriesList = Collections.emptyList();
		//
		final Junction disjunction = RestrictionsFactoryUtil.disjunction(); //OR
		final Junction conjunction = RestrictionsFactoryUtil.conjunction(); //AND
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(de.uhh.l2g.plugins.model.impl.LectureseriesImpl.class, "lect");
		//
		if (Validator.isDigit(keywords)){
			Criterion equalsCategoryId = PropertyFactoryUtil.forName("lect.lectureseriesId").eq(Long.valueOf(keywords));  
			disjunction.add(equalsCategoryId);
		}
		else {
			Criterion likeName = PropertyFactoryUtil.forName("lect.name").like(StringPool.PERCENT + HtmlUtil.escape(keywords) + StringPool.PERCENT); 
			disjunction.add(likeName);
		}
		//
		Criterion equalsGroupId = PropertyFactoryUtil.forName("lect.companyId").eq(Long.valueOf(companyId));  
		conjunction.add(equalsGroupId);
		//
		dynamicQuery.add(conjunction);
		dynamicQuery.add(disjunction);
		try {
			lectureseriesList = CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		} catch (final SystemException e) {
		}
		return lectureseriesList;
	}
	
	public List<Lectureseries> getFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(Long institutionId, Long parentInstitutionId, Long termId, Long categoryId, Long creatorId, String searchQuery, Long groupId, Long companyId){
		return lectureseriesFinder.findFilteredByInstitutionParentInstitutionTermCategoryCreatorSearchString(institutionId, parentInstitutionId, termId, categoryId, creatorId, searchQuery, groupId, companyId);
	}
	
	public List<Lectureseries> getLatest(int limit, Long groupId, Long companyId){
		return lectureseriesFinder.findLatest(limit, groupId, companyId); 
	}	
	
	public Lectureseries getByUSID(String usid){
		Lectureseries l = new LectureseriesImpl();
		try {
			l = lectureseriesPersistence.findByUSID(usid).get(0);
		} catch (SystemException e) {
			//e.printStackTrace();
		}
		return l;
	}
}