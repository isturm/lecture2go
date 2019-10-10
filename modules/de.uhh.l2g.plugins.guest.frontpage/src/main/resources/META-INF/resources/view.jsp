<%@ include file="init.jsp" %>

<c:set var="latest" value="<%=LectureseriesLocalServiceUtil.getLatest(12, groupId, companyId)%>"/>
<c:set var="popular" value="<%=VideoLocalServiceUtil.getPopular(12)%>"/>

<portlet:resourceURL var="findVideosURL">
	<portlet:param name="task" value="findVideos"/> 
</portlet:resourceURL>

<div style="display: none;" id="findVideosURL">${findVideosURL}</div> 
<div style="display: none;" id="portletNamespace"><portlet:namespace/></div> 

<div class="front-page-teaser">
 	<div class="bg-video-container">
		<video id="bg-vid" autoplay loop poster="/o/de.uhh.l2g.themes.uhhci/images/background_still.jpg" preload="none" muted>
		    <!-- the video source is added dynamically to avoid unnecessary traffic -->
		    <img src="/o/de.uhh.l2g.themes.uhhci/images/background_still.jpg">
		</video>
		<div class="dark-overlay"></div>
		<div id="vid-control">
			<i class="icon-pause"></i>
		</div>
	</div>
	<div class="l2go-info-container">
		<div class="l2go-info">
			<div class="l2go-title">
				<c:choose>
				  <c:when test="${company.name == 'Lecture2Go'}">
						Lecture<span class="orange">2</span>Go
				  </c:when>
				  <c:otherwise>
				  		<c:out value="${company.name}"/>
				  </c:otherwise>
				</c:choose>			
			</div>

			<div class="l2go-subtitle">
				<p><liferay-ui:message key="l2go-description"/></p>
			</div>
			
			<%@ include file="includeSearch.jsp"%>	
			
			<br/>		    			
			<button id="outer-catalogue-button" class="catalogue-button" onclick="window.location='/web/vod/l2go';"><liferay-ui:message key="to-catalogue"/></button>
		</div>
	</div>
</div>

<div id="front-page-content">

	<!-- latest videos -->
		<h4><liferay-ui:message key="last-added"/></h4>
			<div id="news-carousel" class="carousel slide" data-ride="carousel">
            <!-- Carousel items -->
	            <div class="carousel-inner">
	                <div class="carousel-item active">
						<div class="row-fluid video-box-list">
							<c:set var="count" value="0" scope="page" />
							<c:forEach items="${latest}" var="item">
								<c:set var="isVideo" value="false"/>
								<c:set var="oId" value=""/>
								<c:set var="vid" value="<%=VideoLocalServiceUtil.createVideo(0)%>"/>
								<c:choose>
									<c:when test="${item.latestOpenAccessVideoId<0}">
										<c:set var="isVideo" value="true"/>
										<c:set var="itemLectureseriesId" value="${item.lectureseriesId}"/>
										<c:set var="vid" value="<%=VideoLocalServiceUtil.getVideo((Long)pageContext.getAttribute("itemLectureseriesId"))%>"/>
										<c:set var="oId" value="${vid.videoId}"/>
									</c:when>
									<c:otherwise>
										<c:set var="oId" value="${item.lectureseriesId}"/>
										<c:set var="itemLatestOpenAccessVideoId" value="${item.latestOpenAccessVideoId}"/>
										<c:set var="vid" value="<%=VideoLocalServiceUtil.getVideo((Long)pageContext.getAttribute("itemLatestOpenAccessVideoId"))%>"/>
										<c:set var="isVideo" value="true"/>
									</c:otherwise>
								</c:choose>
					<c:if test='${count % 4 == 0 && count != 0}'>
							<!-- row-fluid -->
							</div>
					<!-- item -->
					</div>
						<div class="carousel-item">
		                    <div class="row-fluid video-box-list">
		        	</c:if>
								<div class="span3 video-box" onClick="window.location='${vid.url}'">											
									<div class="video-box-image-container">
										<div class="video-box-image">
											<img src="${vid.imageMedium}">
										</div>
									</div>

									<div class="video-box-content">
											<div class="date">${vid.simpleDate}</div>
											<div class="title-small dot-ellipsis dot-height-60 dot-resize-update ">${vid.title}</div>
											<div class="creator-small2 dot-ellipsis dot-height-25 dot-resize-update ">${vid.linkedCreators}</div>
											<div class="lectureseries-small dot-ellipsis dot-height-25 dot-resize-update">
												<c:choose>
													<c:when test="${!isVideo}">
														<c:out value="${item.name}"/>
													</c:when>
													<c:otherwise>
														<c:out value=" "/>
													</c:otherwise>
												</c:choose>
											</div> 
											
											<c:set var="vidVideoId" value="${vid.videoId}"/>
											<c:set var="vi" value="<%=Video_InstitutionLocalServiceUtil.getByVideo((Long)pageContext.getAttribute("vidVideoId"))%>"/>
											<!-- only get the first institution -->
											<c:set var="viInstitutionId" value="${vi[0].institutionId}"/>											
											
											<c:if test="${viInstitutionId>0}">
											<c:set var="inst" value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("viInstitutionId"))%>"/>
												<div class="labels">
											        <span class="label label-light2">
											        	<a href='/l2go/-/get/${inst.institutionId}/${inst.parentId}/0/0/0/'>${inst.name}</a>
											        </span>												
												</div>													
											</c:if>
									</div> 
								</div>
										
								<c:set var="count" value="${count + 1}" scope="page"/>
								<!-- span -->
							</c:forEach>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#news-carousel" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a> 
				<a class="carousel-control-next" href="#news-carousel" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
			</div>
	
	<!-- popular videos -->
		<h4><liferay-ui:message key="popular-videos"/></h4>
			<div id="popular-carousel" class="carousel slide" data-ride="carousel">
            <!-- Carousel items -->
	            <div class="carousel-inner">
	                <div class="carousel-item active">
						<div class="row-fluid video-box-list">
							<c:set var="count" value="0" scope="page" />
							<c:forEach items="${popular}" var="item">
								<c:set var="itemVideoId" value="${item.videoId}"/>
								<c:set var="vid" value="<%=VideoLocalServiceUtil.getVideo((Long)pageContext.getAttribute("itemVideoId"))%>"/>
								<c:choose>
									<c:when test="${vid.lectureseriesId<0}">
										<c:set var="isVideo" value="true"/>
									</c:when>
									<c:otherwise>
										<c:set var="isVideo" value="false"/>
										<c:set var="vidLectureseriesId" value="${vid.lectureseriesId}"/>
										<c:set var="lectureseries" value="<%=LectureseriesLocalServiceUtil.getLectureseries((Long)pageContext.getAttribute("vidLectureseriesId"))%>"/>
									</c:otherwise>
								</c:choose>
											
								<c:if test="${count % 4 == 0 && count != 0}">
									<!-- row-fluid -->
										</div>
										<!-- item -->
									</div>
									<div class="carousel-item active">
	                    				<div class="row-fluid video-box-list">
	                    		</c:if>
									<div class="span3 video-box" onClick="window.location='${vid.url}'">	
										<div class="video-box-image-container">
											<div class="video-box-image"> 
												<img src="${vid.imageMedium}">
											</div>
										</div>
	
										<div class="video-box-content"> 
											<div class="date">${vid.simpleDate}</div>
											<div class="title-small dot-ellipsis dot-height-60 dot-resize-update ">${vid.title}</div>
											<div class="creator-small2 dot-ellipsis dot-height-25 dot-resize-update ">${vid.linkedCreators}</div>
											<div class="lectureseries-small dot-ellipsis dot-height-25 dot-resize-update">
												<c:choose>
													<c:when test="${isVideo}">
														<c:out value="${lectureseries}"/>
													</c:when>
													<c:otherwise>
														<c:out value=" "/>
													</c:otherwise>
												</c:choose>
											</div>
											
											<c:set var="vidVideoId" value="${vid.videoId}"/>
											<c:set var="vi" value="<%=Video_InstitutionLocalServiceUtil.getByVideo((Long)pageContext.getAttribute("vidVideoId"))%>"/>
											<!-- only get the first institution -->
											<c:set var="viInstitutionId" value="${vi[0].institutionId}"/>											
											
											<c:if test="${viInstitutionId>0}">
											<c:set var="inst" value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("viInstitutionId"))%>"/>
												<div class="labels">
											        <span class="label label-light2">
											        	<a href='/l2go/-/get/${inst.institutionId}/${inst.parentId}/0/0/0/'>${inst.name}</a>
											        </span>												
												</div>													
											</c:if>
											
										</div>
									</div>
								<c:set var="count" value="${count + 1}" scope="page"/>
							</c:forEach>
						</div>
					</div>
				</div>
				<a class="carousel-control-prev" href="#popular-carousel" role="button" data-slide="prev"> <span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a> 
				<a class="carousel-control-next" href="#popular-carousel" role="button" data-slide="next"> <span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span> </a>
			</div>
</div>
