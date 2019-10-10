<%@include file="init.jsp"%>
 
<jsp:useBean id="parentInstitutionId" type="java.lang.Long" scope="request" />
<jsp:useBean id="institutionId" type="java.lang.Long" scope="request" />
<jsp:useBean id="termId" type="java.lang.Long" scope="request" />
<jsp:useBean id="categoryId" type="java.lang.Long" scope="request" />
<jsp:useBean id="creatorId" type="java.lang.Long" scope="request" />
<jsp:useBean id="findVideos" type="java.lang.String" scope="request" />
<jsp:useBean id="maxTerms" type="java.lang.Integer" scope="request" />
<jsp:useBean id="hasInstitutionFiltered" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="hasParentInstitutionFiltered" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="hasTermFiltered" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="hasCategoryFiltered" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="isSearched" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="reqLectureseries" type="java.util.List<Lectureseries>" scope="request" />
<jsp:useBean id="lectureseriesIds" type="java.util.ArrayList<Long>" scope="request" />
<jsp:useBean id="videoIds" type="java.util.ArrayList<Long>" scope="request" />

<jsp:useBean id="presentParentInstitutions" type="java.util.List<Institution>" scope="request" />
<jsp:useBean id="presentInstitutions" type="java.util.List<Institution>" scope="request" />
<jsp:useBean id="presentTerms" type="java.util.List<Term>" scope="request" />
<jsp:useBean id="presentCreators" type="java.util.List<Creator>" scope="request" />
<jsp:useBean id="presentCategories" type="java.util.List<Category>" scope="request" />

<jsp:useBean id="portletURL" type="javax.portlet.PortletURL" scope="request" />
<jsp:useBean id="resultSetEmpty" type="java.lang.Boolean" scope="request" />

<jsp:useBean id="insti" type="de.uhh.l2g.plugins.model.Institution" scope="request" />
<jsp:useBean id="pInst" type="de.uhh.l2g.plugins.model.Institution" scope="request" />
<jsp:useBean id="rInst" type="de.uhh.l2g.plugins.model.Institution" scope="request" />

<c:set var="portalURL" value="<%=PrefsPropsUtil.getString(company.getCompanyId(),PropsKeys.DEFAULT_LANDING_PAGE_PATH)%>"/>
<c:set var="pageName" value="<%=themeDisplay.getLayout().getName(themeDisplay.getLocale())%>"/>
<c:set var="displayTerms" value="<%=new DisplayTerms(renderRequest)%>"/>

<%
	// set page context for better use in taglibs
	pageContext.setAttribute("hasParentInstitutionFiltered", hasParentInstitutionFiltered);
	pageContext.setAttribute("hasInstitutionFiltered", hasInstitutionFiltered);
	pageContext.setAttribute("hasTermFiltered", hasTermFiltered);
	pageContext.setAttribute("hasCategoryFiltered", hasCategoryFiltered);
	pageContext.setAttribute("hasManyTerms", presentTerms.size() > maxTerms);
%>

	<portlet:renderURL var="backURL0">
		<portlet:param name="mvcRenderCommandName" value="/view/render/list" />
		<portlet:param name="parentInstitutionId" value="0"/>
		<portlet:param name="institutionId" value="0"/>
		<portlet:param name="termId" value="0"/>
		<portlet:param name="categoryId" value="0"/>
		<portlet:param name="creatorId" value="0"/>
	</portlet:renderURL>

	<portlet:resourceURL var="findVideosURL">
			<portlet:param name="task" value="findVideos" />
	</portlet:resourceURL>

<div style="display: none;" id="findVideosURL">${findVideosURL}</div> 
<div style="display: none;" id="portletNamespace"><portlet:namespace/></div> 

<div class="path-wide">
	<A HREF=${portalURL}>${company.name}</A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
	<A HREF="${backURL0}">${pageName}</A>
	<span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
	
	<c:if test="${rInst.name.length()>0}">
		<A HREF="${backURL0}">${rInst.name}</A>
	</c:if>
	
	<c:if test="${pInst.name.length()>0}">
		<portlet:renderURL var="backURL1" >
			<portlet:param name="mvcRenderCommandName" value="/view/render/list" />
			<portlet:param name="parentInstitutionId" value="${pInst.institutionId}\'\'"/>
			<portlet:param name="institutionId" value="0"/>
			<portlet:param name="termId" value="0"/>
			<portlet:param name="categoryId" value="0"/>
			<portlet:param name="creatorId" value="0"/>
		</portlet:renderURL>
		<span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
		<A HREF="${backURL1}">${pInst.name}</A>	
	</c:if>
	
	<c:if test="${insti.name.length()>0}">
			<portlet:renderURL var="backURL2">
				<portlet:param name="mvcRenderCommandName" value="/view/render/list" />
				<portlet:param name="parentInstitutionId" value="${pInst.institutionId}\'\'"/>
				<portlet:param name="institutionId" value="${insti.institutionId}\'\'"/>
				<portlet:param name="termId" value="0"/>
				<portlet:param name="categoryId" value="0"/>
				<portlet:param name="creatorId" value="0"/>
			</portlet:renderURL>	
			<span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
			<A HREF="${backURL2}">${insti.name}</A> 
	</c:if>
</div>

<h1><liferay-ui:message key="video-catalog"/></h1>
		    
<%@ include file="includeSearch.jsp"%>
		    
<div class="catalogue-container">
	<div class="row-fluid">
	<c:if test="${!resultSetEmpty}">
		<div class="span3">
			<liferay-ui:panel-container>
				<!-- 	parentinstitution filter -->
				<c:if test="${presentParentInstitutions.size()>0}">
					<liferay-ui:panel extended="true" title="institution" cssClass='${hasParentInstitutionFiltered ? "filtered" : "notFiltered"}'>
						<ul>
						<c:forEach items="${presentParentInstitutions}" var="parentInstitution">
							<portlet:renderURL var="filterByParentInstitution">
								<portlet:param name="mvcRenderCommandName" value="/view/render/list" />
								<portlet:param name="parentInstitutionId" value='${hasParentInstitutionFiltered ? "0" : parentInstitution.institutionId}'/>
								<portlet:param name="institutionId" value="${institutionId}"/>				
								<portlet:param name="termId" value="${termId}"/>
								<portlet:param name="categoryId" value="${categoryId}"/>
								<portlet:param name="creatorId" value="${creatorId}"/>
								<portlet:param name="findVideos" value="${findVideos}"/>	
							</portlet:renderURL>
							<li class="filter-menu"><a href="${filterByParentInstitution}"><div class="filter-menu-link"><span ${hasParentInstitutionFiltered ? 'class="icon-large icon-remove"' : ''}></span>${parentInstitution.name}</div></a></li>
						</c:forEach>
						</ul>
					</liferay-ui:panel>
				</c:if>
				
			 	<!-- institution filter  -->
				<c:if test="${hasParentInstitutionFiltered}">
					<c:if test="${presentInstitutions.size()>0}">
						<liferay-ui:panel extended="true" title="sub-institution" cssClass='${hasInstitutionFiltered ? "filtered" : "notFiltered"}'>
							<ul>
							<c:forEach items="${presentInstitutions}" var="institution">
								<portlet:renderURL var="filterByInstitution">
									<portlet:param name="mvcRenderCommandName" value="/view/render/list" />
									<portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
									<portlet:param name="institutionId" value='${hasInstitutionFiltered ? "0" : institution.institutionId}'/>
									<portlet:param name="termId" value="${termId}"/>
									<portlet:param name="categoryId" value="${categoryId}"/>
									<portlet:param name="creatorId" value="${creatorId}"/>
									<portlet:param name="findVideos" value="${findVideos}"/>	
								</portlet:renderURL>
								<li class="filter-menu"><a href="${filterByInstitution}"><div class="filter-menu-link"><span ${hasInstitutionFiltered ? 'class="icon-large icon-remove"' : ''}></span>${institution.name}</div></a></li>
							</c:forEach>
							</ul>
						</liferay-ui:panel>
					</c:if>
				</c:if>
				
				<!-- 	terms filter -->
				<c:if test="${presentTerms.size()>0}">
					<liferay-ui:panel extended="true" title="term" cssClass='${hasTermFiltered ? "filtered" : "notFiltered"}'>
						<ul class="terms">
						<c:forEach items="${presentTerms}" var="term">
							<portlet:renderURL var="filterByTerm">
								<portlet:param name="mvcRenderCommandName" value="/view/render/list" />
								<portlet:param name="institutionId" value="${institutionId}"/>
								<portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>	
								<portlet:param name="termId" value='${hasTermFiltered ? "0" : term.termId}'/>
								<portlet:param name="categoryId" value="${categoryId}"/>
								<portlet:param name="creatorId" value="${creatorId}"/>
								<portlet:param name="findVideos" value="${findVideos}"/>	
							</portlet:renderURL>
							<li class="filter-menu"><a href="${filterByTerm}"><div class="filter-menu-link"><span ${hasTermFiltered ? 'class="icon-large icon-remove"' : ''}></span><c:choose><c:when test="${term.termName==''}"><liferay-ui:message key="no-term"/></c:when><c:otherwise>${term.termName}</c:otherwise></c:choose></div></a></li>
						</c:forEach>
						</ul>
						<c:if test="${hasManyTerms}">
							<div id="loadMoreTerms"><liferay-ui:message key="more"/></div>
						</c:if>
					</liferay-ui:panel>
				</c:if>
				
				<!-- category filter -->
				<c:if test="${presentCategories.size()>0}">
					<liferay-ui:panel extended="true" title="category" cssClass='${hasCategoryFiltered ? "filtered" : "notFiltered"}'>
						<ul>
						<c:forEach items="${presentCategories}" var="category">
				    		<portlet:renderURL var="filterByCategory">
								<portlet:param name="mvcRenderCommandName" value="/view/render/list" />
								<portlet:param name="institutionId" value="${institutionId}"/>
								<portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
								<portlet:param name="termId" value="${termId}"/>
								<portlet:param name="categoryId" value='${hasCategoryFiltered ? "0" : category.categoryId}'/>
								<portlet:param name="creatorId" value="${creatorId}"/>	
								<portlet:param name="findVideos" value="${findVideos}"/>	
							</portlet:renderURL>
							<li class="filter-menu"><a href="${filterByCategory}"><div class="filter-menu-link"><span ${hasCategoryFiltered ? 'class="icon-large icon-remove"' : ''}></span>${category.name}</div></a></li>
						</c:forEach>
						</ul>
					</liferay-ui:panel>
				</c:if>
			</liferay-ui:panel-container>
		<!-- span3 -->
		</div>
	</c:if>
	
<div>
		
	<liferay-ui:search-container emptyResultsMessage="no-lectureseries-or-videos-found" delta="20" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
			
			<liferay-ui:search-container-results>
				<%
				    searchContainer.setTotal(reqLectureseries.size());		 
				    searchContainer.setResults(ListUtil.subList(reqLectureseries, searchContainer.getStart(), searchContainer.getEnd()));		
				%>
			</liferay-ui:search-container-results>
	
			<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Lectureseries" keyProperty="lectureseriesId" modelVar="lectser">
						<c:set var="oId" value=""/>
						<c:set var="isVideo" value="<%=false%>"/>
						<c:set var="vidDummy" value="<%=VideoLocalServiceUtil.createVideo(0)%>"/>
						<c:choose>
							<c:when test="${lectser.latestOpenAccessVideoId<0 && lectser.lectureseriesId>0}">
								<c:set var="isVideo" value="<%=true%>"/>
								<%try{%><c:set var="vidDummy" value="<%=VideoLocalServiceUtil.getVideo(lectser.getLectureseriesId())%>"/><%}catch(Exception e){};%>	
								<c:set var="oId" value="${vidDummy.videoId}"/>
							</c:when>
							<c:otherwise>
								<%try{%><c:set var="vidDummy" value="<%=VideoLocalServiceUtil.getVideo(lectser.getPreviewVideoId())%>"/><%}catch(Exception e){};%>				
								<c:set var="oId" value="${lectser.lectureseriesId}"/>
							</c:otherwise>
						</c:choose>
						<c:set var="videoCount" value="${lectser.numberOfOpenAccessVideos}"/>
						<c:set var="vl" value="<%=new ArrayList<Video>()%>"/>
						
						<c:choose>
							<c:when test="${videoCount>0 && isSearched}">
								<!-- get videos by search word and lecture series -->
								<c:set var="vl" value="<%=VideoLocalServiceUtil.getBySearchWordAndLectureseriesId(findVideos, (Long)pageContext.getAttribute("oId"))%>"/>
							</c:when>
							<c:otherwise>
								<!-- get all videos of the lecture series -->
								<c:set var="vl" value="<%=VideoLocalServiceUtil.getByLectureseriesAndOpenaccess((Long)pageContext.getAttribute("oId"), 1)%>"/>
							</c:otherwise>
						</c:choose>		
				
						<liferay-ui:search-container-column-text>
										<portlet:renderURL var="view1URL">
											<portlet:param name="mvcRenderCommandName" value="/view/render/details" />
											<portlet:param name="objectId" value="${oId}"/>											
											<c:if test="${isVideo}"><portlet:param name="objectType" value="v"/></c:if>
											<c:if test="${!isVideo}"><portlet:param name="objectType" value="l"/></c:if>
										</portlet:renderURL>
										
										<div class="videotile wide" onClick="window.location='${view1URL}'">
											<c:choose>
												<c:when test="${videoCount==0 && isVideo}">
																<div class="video-image-wrapper">
																   <img class="video-image-big" src="${vidDummy.getImageMedium()}"/>
																</div>
																<div class="video-content-wrapper">
																		<div class="video-content">
																			<%try{%>
																			<c:set var="term" value="<%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName()%>"/>
																			<span class="term-of-creation">${term}</span>
																			<%}catch(Exception e){}%>
																	        <div class="lectureseries-title dot-ellipsis dot-resize-update">
																	        	<a href="${view1URL}">${lectser.name}</a>
																	        </div>
																			
																			<div class="allcreators">
																				${vidDummy.linkedCreators}
																			</div>
																		</div>
																		<div class="video-content-footer">
																	        <div class="labels">
																	        	<c:set var="cat" value=""/>
																	        	<c:set var="vId" value="${vidDummy.videoId}"/>
																	        	<c:set var="vi" value="<%=Video_InstitutionLocalServiceUtil.getByVideo((Long)pageContext.getAttribute("vId"))%>"/>
																	        	<%try{%>
																	        	<c:set var="cId" value="<%=Video_CategoryLocalServiceUtil.getByVideo(lectser.getLectureseriesId()).get(0).getCategoryId()%>"/>
																	        	<c:set var="cat"><a href='/l2go/-/get/0/0/${cId}/0/0/'><%=CategoryLocalServiceUtil.getById((Long)pageContext.getAttribute("cId")).getName()%></a></c:set>
																	          	<span class="label label-light2">${cat}</span>
																	          	<c:set var="iId" value="${vi.get(0).institutionId}"/>
																	          	<c:set var="inst" value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("iId"))%>"/>
																				<c:set var="instLink"><a href='/l2go/-/get/${inst.institutionId}/${inst.parentId}/0/0/0/'>${inst.name}</a></a></c:set>
																	          	<%}catch(Exception e){}%>
																	        </div>
																        </div>	
															     </div>
											</c:when>
											<c:otherwise>
														<!-- multiple videos in lecture series -->
														<div class="video-image-wrapper">
														       <img class="video-image-big layered-paper darker" src="${vidDummy.imageMedium}"/>
															   <span class="badge">${videoCount}</span>
														       <span class="tri"></span>
														       <span class="overlay"></span>
														</div>
														     
														<div class="video-content-wrapper">
																<div class="video-content">
																	<%try{%>
																	<c:set var="term" value="<%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName()%>"/>
																	<span class="term-of-creation">${term}</span>
																    <%}catch(Exception e){}%>
																	<div class="lectureseries-title dot-ellipsis dot-resize-update dot-height-40">
															        	<a href="${view1URL}">${lectser.name}</a>
															        </div>
														        	<c:set var="lId" value="${vidDummy.lectureseriesId}"/>
																	<c:set var="allcreators" value="<%=CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators((Long)pageContext.getAttribute("lId"), 3)%>"/>
																	<div class="allcreators">
																		${allcreators}
																	</div>
																</div>
																
																<div class="video-content-footer">
															        <div class="labels">
																        <c:set var="cat"><a href='/l2go/-/get/0/0/${lectser.categoryId}/0/0/'><%=CategoryLocalServiceUtil.getById(lectser.getCategoryId()).getName()%></a></c:set>
																        <c:set var="li" value="<%=Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectser.getLectureseriesId())%>"/>
																        <span class="label label-light2">${cat}</span>
																        <c:set var="iId" value="${li.get(0).institutionId}"/>
																        <c:set var="inst" value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("iId"))%>"/>
																        <c:set var="instLink"><a href='/l2go/-/get/${inst.institutionId}/${inst.parentId}/0/0/0/'>${inst.name}</a></c:set>
															            <span class="label label-light2">${instLink}</span>
															        </div>
															   </div>
													    </div>
												</c:otherwise>						
											</c:choose>
										<!-- videotile  end-->
										</div>
										<!-- sublist for videos -->
										<c:set var="videoDivTitle" value=""/>
										<c:if test="${videoCount>0}">
											<div class='videolist'>
										        <button id="b${oId}" >
													<span class="lfr-icon-menu-text">
														<i class="icon-chevron-up"></i>
													</span>	
												</button>
												<ul id="p${oId}">
													<c:forEach items="${vl}" var="v">
														<portlet:renderURL var="vURL">
															<portlet:param name="mvcRenderCommandName" value="/view/render/details" />
															<portlet:param name="objectType" value="v"/>
															<portlet:param name="objectId" value="${v.videoId}"/>
														</portlet:renderURL>				
						
														<li class="videotile small" onClick="window.location='${vURL}'">
																<div class="videotile metainfolist small">
																	<div class="video-image-wrapper-small">
																		<img class="video-image" src="${v.imageSmall}">
																	</div>
																</div>
																<%try{%>
																<c:set var="date" value="${v.simpleDate.trim()}"/>
																<c:set var="dur" value="${v.duration.trim().substring(0, 8)}"/>
																<%}catch(Exception e){}%>
																<div class="metainfo-small">
								              						<div class="generation-date">${date}</div>
																	<div class="title-small">${v.title}</div>		              							
									              					<div class="allcreators">		              							
								              							${v.linkedCreators}
								              						</div>
							              						</div>
														</li>
													</c:forEach>
													<c:if test="${isSearched && (videoCount>1)}">
														<li class="videotile small show-all" onClick="window.location='${view1URL}'">
															<liferay-ui:message key="all-videos"/>
														</li>
													</c:if>
												</ul>
											</div>
										</c:if>		
										<!-- sublist for videos end-->							
											
						</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
				
		<liferay-ui:search-iterator />
		
		</liferay-ui:search-container>
		<!-- span9 -->
		</div>
	<!-- row-fluid -->
	</div>
<!-- catalogue-container -->
</div>
 