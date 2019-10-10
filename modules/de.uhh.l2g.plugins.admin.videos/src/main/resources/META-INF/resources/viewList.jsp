<%@include file="init.jsp"%>

<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionProducer" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionCoordinator" type="java.lang.Boolean" scope="request" />

<jsp:useBean id="producerId" type="java.lang.Long" scope="request" />
<jsp:useBean id="lectureseriesId" type="java.lang.Long" scope="request" />
<jsp:useBean id="coordinators" type="java.util.List<Coordinator>" scope="request" />
<jsp:useBean id="coordinatorId" type="java.lang.Long" scope="request" />
<jsp:useBean id="producers" type="java.util.List<Producer>" scope="request" />
<jsp:useBean id="tempVideosList" type="java.util.List<Video>" scope="request" />
<jsp:useBean id="portletURL" type="javax.portlet.PortletURL" scope="request" />
<jsp:useBean id="remoteUser" type="com.liferay.portal.kernel.model.User" scope="request" />
<jsp:useBean id="displayTerms" type="de.uhh.l2g.plugins.admin.videos.search.VideoDisplayTerms" scope="request" />
<jsp:useBean id="videoSearchContainer" type="de.uhh.l2g.plugins.admin.videos.search.VideoSearchContainer" scope="request" />

<c:set var="pageName" value="<%=themeDisplay.getLayout().getName(themeDisplay.getLocale())%>"/>
<c:set var="contextPath" value="<%=config.getServletContext().getContextPath() %>"/>			
<c:set var="application" value="<%=application%>"/>

<liferay-portlet:renderURL varImpl="videosSearchURL">
    <portlet:param name="mvcPath" value="/viewList.jsp" />
</liferay-portlet:renderURL>

<div class="noresponsive">
	<label class="edit-video-lable">${pageName}</label>
	
	<aui:fieldset helpMessage="" column="true" cssClass="list">
		<c:if test="${permissionAdmin}">
			<portlet:renderURL var="sortByCoordinator">
				<portlet:param name="jspPage" value="/viewList.jsp" />
				<portlet:param name="producerId" value="${producerId}"/>
				<portlet:param name="lectureseriesId" value="${lectureseriesId}"/>
			</portlet:renderURL>
			<aui:form action="${sortByCoordinator}" method="post">
				<aui:select name="coordinatorId" label="" onChange="submit();">
					<aui:option value=""><liferay-ui:message key="select-coordinator"/></aui:option>
					<c:forEach items="${coordinators}" var="item">
						<aui:option value='${item.coordinatorId}'>${item.lastName}, ${item.firstName}</aui:option>
					</c:forEach>
				</aui:select>
			</aui:form>				
		</c:if>

		<c:if test="${permissionCoordinator || (permissionAdmin && coordinatorId>0)}">
			<portlet:renderURL var="sortByProducer">
				<portlet:param name="jspPage" value="/viewList.jsp" />
				<portlet:param name="coordinatorId" value="${coordinatorId}"/>
				<portlet:param name="lectureseriesId" value="${lectureseriesId}"/>
			</portlet:renderURL>
			<aui:form action="${sortByProducer}" method="post">
				<aui:select name="producerId" label="" onChange="submit();">
					<aui:option value=""><liferay-ui:message key="select-producer"/></aui:option>
					<c:forEach items="${producers}" var="item">
						<aui:option value='${item.producerId}'>${item.lastName}, ${item.firstName}</aui:option>
					</c:forEach>
				</aui:select>
			</aui:form>				
		</c:if>	
		
		<c:if test="${ ((permissionAdmin || permissionCoordinator) && producerId>0  && coordinatorId>0) || permissionProducer }">
			<portlet:renderURL var="sortByLectureseries">
				<portlet:param name="jspPage" value="/viewList.jsp" />
				<portlet:param name="coordinatorId" value="${coordinatorId}"/>
				<portlet:param name="producerId" value="${producerId}"/>
			</portlet:renderURL>
			<aui:form action="${sortByLectureseries}" method="post">
				<aui:select name="lectureseriesId" label="" onChange="submit();">
					<aui:option value="0">-<liferay-ui:message key="without-lecture-series"/>-</aui:option>
					<c:forEach items="${lectureseriesAsTreeList}" var="item">
						<aui:option value=''>&#9472; ${item.key.termName} &#9472;</aui:option>
						<c:forEach items="${item.value}" var="lecture">
							<aui:option value='${lecture.lectureseriesId}'>${lecture.name}</aui:option>
						</c:forEach>
					</c:forEach>
				</aui:select>
			</aui:form>		
		</c:if>
	</aui:fieldset>
	
	<c:if test="${producerId>0}">
		<portlet:actionURL name="addVideo" var="addVideoURL">
			<portlet:param name="lectureseriesId" value='${lectureseriesId}'/>
				<portlet:param name="producerId" value='${producerId}'/>
				<portlet:param name="backURL" value="${portletURL}"/>	
			</portlet:actionURL>	
			<a href="${addVideoURL}" class="add-link">
			    <liferay-ui:message key="add-video"/> <span class="icon-large icon-plus-sign"/>
			</a>
	</c:if>
	
	<aui:form action="${videosSearchURL}" method="post" name="fm">
		<liferay-ui:search-container emptyResultsMessage="no-videos-found" delta="10" iteratorURL="${portletURL}" displayTerms="${displayTerms}">
				<liferay-ui:search-container-results>
				<div id="modifiedSearch">
					<liferay-ui:search-form page="/viewSearch.jsp" servletContext="<%= application %>" />
				</div>
				
				<%
					String keywords = displayTerms.getKeywords(); 
					searchContainer.setTotal(VideoSearchHelper.getTotalVideoCount(displayTerms,videoSearchContainer.getStart(), videoSearchContainer.getEnd()));		 
					searchContainer.setResults(VideoSearchHelper.getVideo(displayTerms,videoSearchContainer.getStart(), videoSearchContainer.getEnd()));
				%>
				</liferay-ui:search-container-results>
			
				<liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.Video" keyProperty="videoId" modelVar="video">
						<c:set var="vid" value="<%=VideoLocalServiceUtil.getVideo(video.getVideoId())%>"/>
						<c:set var="url" value=""/>
						<c:if test="${vid.getOpenAccess()==1}">
							<c:set var="url" value="${vid.url}"/>
						</c:if>
						<c:if test="${vid.getOpenAccess()==0}">
							<c:set var="url" value="${vid.secureUrl}"/>
						</c:if>
						<portlet:actionURL name="viewVideo" var="viewURL">
							<portlet:param name="videoId" value="${video.videoId}" />
						</portlet:actionURL>
						<liferay-ui:search-container-column-text name="">
							<div class="adminrow wide">
									<c:set var="ls" value="<%=LectureseriesLocalServiceUtil.createLectureseries(0)%>"/>
									<c:if test="${vid.getLectureseriesId()>0}">
										<c:set var="ls" value="<%=LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId())%>"/>
									</c:if>
			
									<c:set var="lName" value=""/>
									<c:if test="${ls.name}">
										<c:set var="lName" value="${ls.name}"/>
									</c:if>
			
									<c:set var="lTerm" value="0"/>
									<c:if test="${ls.termId>0}">
										<c:set var="lTerm" value="${ls.termId}"/>
									</c:if>
			
									<c:set var="vName" value="${vid.title}"/>
									<c:if test="${fn:length(vName)==0}">
										<c:set var="vName" value="<%=LanguageUtil.get(request, "no-title")%>"/>
									</c:if>
									
									<c:set var="creators" value="<%=CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(video.getVideoId(), 100)%>"/>
									<c:if test="${fn:length(creators)==0}">
										<c:set var="creators" value="<%=LanguageUtil.get(request, "no-creators")%>"/>
									</c:if>
									
									<c:set var="onClick" value="#"/>
									<c:if test="${fn:length(vid.filename)>0}">
										<c:set var="onClick" value="window.open('${url}')"/>
									</c:if>		
									
									<div class="video-image-wrapper" onClick="${onClick}">
									    <img class="video-image-big" src="${vid.imageMedium}"/>
									</div>
									
									<div class="admintile wide video-content-wrapper">
										<div class="admin-videolist-video-title" onClick="${onClick}">
											${vName}
										</div>
										
										<div class="admin-videolist-creator-title">
											${creators}
										</div>
										
										<c:if test="${fn:length(lName)>0}">
											<div class="admin-videolist-lectureseries-title">
												${lName} (${lTerm})
											</div>
										</c:if>
										
										<c:if test="${fn:length(vid.filename)>0}">
											<div class="format">
												<c:if test="${vid.mp4File.isFile()}">
													<liferay-ui:message key="mp4-video"/> &nbsp;
												</c:if>
												
												<c:if test="${vid.mp3File.isFile()}">
													<liferay-ui:message key="mp3-audio"/> &nbsp;
												</c:if>
												
												<c:if test="${vid.m4aFile.isFile()}">
													<liferay-ui:message key="m4a-audio"/> &nbsp;
												</c:if>
												
												<c:if test="${vid.m4vFile.isFile()}">
													<liferay-ui:message key="m4v-video"/> &nbsp;
												</c:if>
												
												<c:if test="${vid.vttFile.isFile()}">
													<liferay-ui:message key="vtt-caption"/> &nbsp;
												</c:if>
											</div>																
										</c:if>
		
										<div class="admin-videolist-date">
											${vid.date} | <liferay-ui:message key="hits"/>: ${vid.hits}
										</div>
									</div>
									
									<div class="video-edit-wrapper">
										
										<c:set var="primKey" value="<%=String.valueOf(video.getPrimaryKey())%>" />
						
										<portlet:renderURL var="editURL">
											<portlet:param name="videoId" value="${primKey}" />
											<portlet:param name="backURL" value="${portletURL}"/>
											<portlet:param name="mvcPath" value="/viewEdit.jsp" />
										</portlet:renderURL>
										
										
										<portlet:actionURL name="lockVideo" var="lockURL">
											<portlet:param name="videoId" value="${primKey}" />
											<portlet:param name="backURL" value="${portletURL}"/>	
										</portlet:actionURL>
										
										<portlet:actionURL name="unlockVideo" var="unlockURL">
											<portlet:param name="videoId" value="${primKey}" />
											<portlet:param name="backURL" value="${portletURL}"/>	
										</portlet:actionURL>
										
										<portlet:actionURL name="activateDownload" var="activateDowonloadURL">
											<portlet:param name="videoId" value="${primKey}" />
											<portlet:param name="backURL" value="${portletURL}"/>	
										</portlet:actionURL>
										
										<portlet:actionURL name="deactivateDownload" var="deactivateDowonloadURL">
											<portlet:param name="videoId" value="${primKey}" />
											<portlet:param name="backURL" value="${portletURL}"/>	
										</portlet:actionURL>
										
										<portlet:renderURL var="segmentURL">
											<portlet:param name="videoId" value="${primKey}" />
											<portlet:param name="backURL" value="${portletURL}"/>		
											<portlet:param name="mvcPath" value="/viewSegment.jsp" />
										</portlet:renderURL>
					
										<portlet:actionURL name="removeVideo" var="removeURL">
											<portlet:param name="videoId" value="${primKey}" />
											<portlet:param name="backURL" value="${portletURL}"/>	
										</portlet:actionURL>
										
										<a href="${editURL}" title="<liferay-ui:message key='edit'/>" alt="<liferay-ui:message key='edit'/>">
										   <span class="icon-large icon-pencil"></span>
										</a>
										
										<c:if test="${fn:length(vid.filename)>0}">
											<c:if test="${vid.openAccess==1}">
												<a href="${lockURL}" title="<liferay-ui:message key='lock-help'/>" alt="<liferay-ui:message key='lock-help'/>">
												   <span class="icon-large icon-unlock" onclick="return confirm('<liferay-ui:message key="really-lock-question"/>')"></span>
												</a>
											</c:if>
											
											<c:if test="${vid.openAccess==0}">
												<a href="${unlockURL}" title="<liferay-ui:message key='unlock-help'/>" alt="<liferay-ui:message key='unlock-help'/>">
												    <span class="icon-large icon-lock" onclick="return confirm('<liferay-ui:message key="really-unlock-question"/>')"></span>
												 </a>
											</c:if>
											
											<c:if test="${vid.downloadLink==1}">
												 <a href="${deactivateDowonloadURL}" title="<liferay-ui:message key='deaktivate-download-help'/>" alt="<liferay-ui:message key='deaktivate-download-help'/>">
												    <span class="icon-large icon-download-alt" onclick="return confirm('<liferay-ui:message key="really-deactivate-download-question"/>')"></span>
												 </a>
											</c:if>
											
											<c:if test="${vid.downloadLink==0}">
												 <a href="${activateDowonloadURL}" title="<liferay-ui:message key='aktivate-download-help'/>" alt="<liferay-ui:message key='aktivate-download-help'/>">
												    <span class="icon-large icon-download"></span>
												 </a>		
											</c:if>
											
											<c:set var="segments" value="<%=SegmentLocalServiceUtil.getSegmentsByVideoId(video.getVideoId())%>"/>
											<c:if test="${segments.size()>0}">
												<a href="${segmentURL}" title="<liferay-ui:message key='comment-video-help'/>" alt="<liferay-ui:message key='comment-video-help'/>">
												    <span class="icon-large icon-comment"></span>
												 </a>	
											</c:if>
											
											<c:if test="${segments.size()==0}">
												<a href="${segmentURL}" title="<liferay-ui:message key='comment-video-help'/>" alt="<liferay-ui:message key='comment-video-help'/>">
												   <span class="icon-large icon-align-justify"></span>
												</a>
											</c:if>
										</c:if>
										
										<a href="${removeURL}" title="<liferay-ui:message key='delete'/>">
											<span class="icon-large icon-remove" onclick="return confirm('<liferay-ui:message key="really-delete-question"/>')"></span>
										</a>
									</div>
							</div>		
						</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
		
		<aui:input name="coordinatorId" type="hidden" value="${coordinatorId}"/>
		<c:if test="${coordinatorId>0}">
			<aui:input name="producerId" type="hidden" value="${producerId}"/>
		</c:if>
		<c:if test="${producerId>0}">
			<aui:input name="lectureseriesId" type="hidden" value="${lectureseriesId}"/>
		</c:if>
	</aui:form>
</div>