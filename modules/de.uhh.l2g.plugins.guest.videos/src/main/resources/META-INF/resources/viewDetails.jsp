<%@include file="init.jsp"%> 

<jsp:useBean id="video" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="relatedVideos" type="java.util.List<de.uhh.l2g.plugins.model.Video>" scope="request" />
<jsp:useBean id="segments" type="java.util.List<de.uhh.l2g.plugins.model.Segment>" scope="request" />
<jsp:useBean id="videoLectureseries" type="java.util.List<de.uhh.l2g.plugins.model.Video_Lectureseries>" scope="request" />
<jsp:useBean id="videoInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />
<jsp:useBean id="videoMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<jsp:useBean id="lectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="objectType" type="java.lang.String" scope="request" />
<jsp:useBean id="objectId" type="java.lang.String" scope="request" />

<jsp:useBean id="timeStart" type="java.lang.Long" scope="request" />
<jsp:useBean id="timeEnd" type="java.lang.Long" scope="request" />

<portlet:renderURL var="backURL0">
	<portlet:param name="mvcRenderCommandName" value="/view/list" />
	<portlet:param name="parentInstitutionId" value="0"/>
	<portlet:param name="institutionId" value="0"/>
	<portlet:param name="termId" value="0"/>
	<portlet:param name="categoryId" value="0"/>
	<portlet:param name="creatorId" value="0"/>
</portlet:renderURL>
  
<c:set var="tags" value="<%=video.getTags().length()>0 ? " - "+video.getTags()+" - " : ""%>"/>
<c:set var="pageTitle" value="<%=video.getTitle() +" - "+lectureseries.getName()+" - "+CreatorLocalServiceUtil.getCommaSeparatedCreatorsByVideoIdAndMaxCreators(video.getVideoId(), 200) + " - Universität Hamburg" + (String)pageContext.getAttribute("tags")%>"/>
<c:set var="portalURL" value="<%=PrefsPropsUtil.getString(company.getCompanyId(),PropsKeys.DEFAULT_LANDING_PAGE_PATH)%>"/>
<c:set var="isCitation2Go" value="false"/>
<c:if test="${timeStart>0 && timeEnd>timeStart && video.citation2go==1}">
	<c:set var="isCitation2Go" value="true"/>
</c:if>

<c:set var="pageName" value="${themeDisplay.getLayout().getName(themeDisplay.getLocale())}"/>
<%PortalUtil.setPageTitle((String)pageContext.getAttribute("pageTitle"), request);%>

<portlet:resourceURL var="findVideos">
	<portlet:param name="task" value="findVideos"/> 
</portlet:resourceURL>

<div style="display: none;" id="findVideosURL">${findVideos}</div> 
<div style="display: none;" id="portletNamespace"><portlet:namespace/></div> 

<c:if test="${video.videoId>0}">
	<c:choose>
		<c:when test="${video.accessPermitted==1}">
				<c:if test="${video.openAccess==1 || video.openAccess==0}">
					<div class="col-xs-10 col-md-10">
						<c:if test="${relatedVideos.size()>1}"> <div class="path"></c:if>
					    <c:if test="${relatedVideos.size()<=1}"> <div class="path-wide"></c:if>
					    	
					    	<c:choose>
					    		<c:when test="${video.lectureseriesId>0}">
						    			<c:set var="lec" value="<%=LectureseriesLocalServiceUtil.getLectureseries(video.getLectureseriesId())%>"/>
						    			<c:set var="institutions" value="<%=InstitutionLocalServiceUtil.getByLectureseriesId(video.getLectureseriesId(), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS)%>"/>
						    			<c:forEach var = "j" begin = "0" end = "0">
						    				<c:set var="insti" value="${institutions.get(0)}"/>
						    				<c:set var="iId" value="${insti.institutionId}"/>
								         	<c:set var="pInstId" value="${insti.parentId}"/>
								         	<c:set var="pInst" value="<%=InstitutionLocalServiceUtil.getInstitution((Long)pageContext.getAttribute("pInstId"))%>"/>
								         	<c:set var="rInstId" value="${pInst.parentId}"/>
								         	<c:set var="rInst" value="<%=InstitutionLocalServiceUtil.getInstitution((Long)pageContext.getAttribute("rInstId"))%>"/>
											<portlet:renderURL var="backURL1">
												<portlet:param name="mvcRenderCommandName" value="/view/list" />
												<portlet:param name="parentInstitutionId" value="${pInst.institutionId}"/>
												<portlet:param name="institutionId" value="0"/>
												<portlet:param name="termId" value="0"/>
												<portlet:param name="categoryId" value="0"/>
												<portlet:param name="creatorId" value="0"/>
											</portlet:renderURL>					
											<portlet:renderURL var="backURL2">
												<portlet:param name="mvcRenderCommandName" value="/view/list" />
												<portlet:param name="parentInstitutionId" value="${pInst.institutionId}"/>
												<portlet:param name="institutionId" value="${insti.institutionId}"/>
												<portlet:param name="termId" value="0"/>
												<portlet:param name="categoryId" value="0"/>
												<portlet:param name="creatorId" value="0"/>
											</portlet:renderURL>	
											<A HREF="${portalURL}">${company.name}</A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
											<A HREF="${backURL0}">${pageName}</A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
											<A HREF="${backURL0}">${rInst.name}</A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
									    	<A HREF="${backURL1}">${pInst.name}</A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
									    	<A HREF="${backURL2}">${insti.name}</A>
									    	<c:if test="${lec.lectureseriesId>0}">
									    		<span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <SPAN>${lec.name}</SPAN>
									    	</c:if>
									    	<br/>						         	
								      	</c:forEach>
					    		</c:when>
					    		<c:otherwise>
					    			<c:forEach items="${videoInstitutions}" var="vi">
					    				<c:set var="iId" value="${vi.institutionId}"/>
					    				<c:set var="iPId" value="${vi.institutionParentId}"/>
					    				<c:set var="insti" value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("iId"))%>"/>
					    				<c:set var="pInst" value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("iPId"))%>"/>
					    				<c:set var="ipId" value="${pInst.parentId}"/>
					    				<c:set var="rInst" value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("ipId"))%>"/>
										<portlet:renderURL var="backURL3">
											<portlet:param name="mvcRenderCommandName" value="/view/list" />
											<portlet:param name="parentInstitutionId" value="${pInst.institutionId}"/>
											<portlet:param name="institutionId" value="0"/>
											<portlet:param name="termId" value="0"/>
											<portlet:param name="categoryId" value="0"/>
											<portlet:param name="creatorId" value="0"/>
										</portlet:renderURL>					
										<portlet:renderURL var="backURL4">
											<portlet:param name="mvcRenderCommandName" value="/view/list" />
											<portlet:param name="parentInstitutionId" value="${pInst.institutionId}"/>
											<portlet:param name="institutionId" value="${insti.institutionId}"/>
											<portlet:param name="termId" value="0"/>
											<portlet:param name="categoryId" value="0"/>
											<portlet:param name="creatorId" value="0"/>
										</portlet:renderURL>		    	
										    	
			   							<A HREF="/">${company.name}</A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
										<A HREF="${backURL0}">${pageName}</A><span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
										<A HREF="${backURL0}">${rInst.name}</A> <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 
										
										<c:if test="${pInst.level>0}">
											<A HREF="${backURL3}">${pInst.name}</A>
										   	<span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> 								
										</c:if>
										<A HREF="${backURL4}">${insti.name}</A>	
										<br/> 
					    			</c:forEach>
					    		</c:otherwise>
					    	</c:choose>
					    </div>
				</c:if>

				<h1><liferay-ui:message key="video-catalog"/></h1>
				    
				<%@ include file="includeSearch.jsp"%>		

				<c:set var="lTermId" value="${lectureseries.termId}"/>
				<%try{%>
				<c:set var="term" value="<%=TermLocalServiceUtil.getById((Long)pageContext.getAttribute("lTermId"))%>"/>
				<c:choose>
					<c:when test="${lTermId > 1}">
						<c:set var="termMetadata" value="(${term.prefix} ${term.year})"/>		
					</c:when>
					<c:otherwise>
						<c:set var="termMetadata" value=""/>
					</c:otherwise>
				</c:choose>
				<%}catch(Exception e){}%>
				<c:set var="series" value="${lectureseries.name}${termMetadata}"/>
				<div class="col-md-7">
				    <div id="main" >
				       <c:if test="${relatedVideos.size()>1}"><div class="player"></c:if>
					   <c:if test="${relatedVideos.size()<=1}"><div class="player-wide"></c:if>
					   		<c:set var="lecture2goWebRoot" value="<%=PropsUtil.get("lecture2go.web.root")%>"/>
							<%@ include file="player/includePlayer.jsp"%>
						   	
						   	<div class="license">
						    	<c:choose>
						    		<c:when test="${videoLicense.l2go==1}">
								      	<a href="/license-l2go" title="<liferay-ui:message key='l2go-license-click-for-info'/>"><liferay-ui:message key="license"/>: <liferay-ui:message key='l2go-license'/></a>
						    		</c:when>
						    		<c:otherwise>
										<a href="https://creativecommons.org/licenses/by-nc-sa/3.0/" title="<liferay-ui:message key='cc-license-click-for-info'/>"><liferay-ui:message key="license"/>: <liferay-ui:message key='cy-nc-sa-license'/></a> 		
						    		</c:otherwise>
						    	</c:choose>
						  	</div>
					       
					       <div class="views"><liferay-ui:message key="views"/>: ${video.hits}</div>	
					       	
							  <c:if test="${relatedVideos.size()>1}"> <div class="meta-video-info"></c:if>
							  <c:if test="${relatedVideos.size()<=1}"> <div class="meta-video-info-wide"></c:if>
							    <div class="meta-title">
									<c:if test="${isCitation2Go}">
										<div class="c2go-title"><liferay-ui:message key='citation-of'/></div>
									</c:if>
								    ${video.title}
							    </div>
						      	<div class="meta-creators">
						      		<c:set var="date1" value=""/>
						      		<c:set var="creators" value="<%=CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByVideoIdAndMaxCreators(video.getVideoId(), 100)%>"/>
									<%try{%>
									<c:set var="date1" value="${video.date.trim().substring(0, 10)}"/>
									<%}catch(Exception e){}%>
									${creators}
									<div class="date">${date1}</div>
								</div>
							    <div class="lectureseries-small">${series}</div>
								<div class="meta-description-container">
									<div class="meta-description">
										<c:choose>
											<c:when test="${videoMetadata.description.trim().length()>0}">
												${videoMetadata.description}
											</c:when>
											<c:otherwise>
												${lectureseries.longDesc}
											</c:otherwise>
										</c:choose>
									</div>
								</div>
							</div>
						    
						    <c:if test="${timeEnd==0 || timeEnd<timeStart || video.citation2go==0}">
							    <c:if test="${relatedVideos.size()>1}"><div class="metainfo"></c:if>
							    <c:if test="${relatedVideos.size()<=1}"><div class="metainfo-wide"></c:if>
									<ul id="tabs" class="nav nav-tabs" data-tabs="tabs">
									    <c:if test="${video.downloadLink==1}">
										    <li id="down"><a href="#download" data-toggle="tab"><liferay-ui:message key="download"/></a></li>
									    </c:if>
									    <c:if test="${video.openAccess==1}">
									   	 	<li><a href="#share" data-toggle="tab"><liferay-ui:message key="share"/></a></li>
									    </c:if>
									    <li><a href="#support" data-toggle="tab"><liferay-ui:message key="support"/></a></li>
									    <c:if test="${video.hasChapters}">
									    	<li><a href="#chapters" data-toggle="tab"><liferay-ui:message key="chapters"/></a></li>
									    </c:if>
									</ul>
									    
									<div id="my-tab-content" class="tab-content">
										<c:if test="${video.downloadLink==1}">
											<div class="tab-pane" id="download">
										        <p><%@ include file="includeDownload.jsp" %></p>
										    </div>
										</c:if>
										<c:if test="${video.openAccess==1}">
										    <div class="tab-pane" id="share">
										        <p><%@ include file="includeShare.jsp" %></p>
										    </div>
										</c:if>
		
										<div class="tab-pane" id="support">
										        	<c:set var="facultyId" value="${video.rootInstitutionId}"/>
										        	<c:set var="institut" value="Fakultätübergreifend"/>
										        	<c:set var="option1" value="<%=PortalUtil.getOriginalServletRequest(request).getParameter("option1")%>"/>
													
													<c:if test="${facultyId==3}"><c:set var="institut" value="UHH-Jura"/></c:if>
													<c:if test="${facultyId==4}"><c:set var="institut" value="UHH-WiSo"/></c:if>
													<c:if test="${facultyId==5}"><c:set var="institut" value="UHH-Medizin"/></c:if>
													<c:if test="${facultyId==6}"><c:set var="institut" value="UHH-EW"/></c:if>
													<c:if test="${facultyId==7}"><c:set var="institut" value="UHH-GWiss"/></c:if>
													<c:if test="${facultyId==8}"><c:set var="institut" value="UHH-MIN"/></c:if>
													<c:if test="${facultyId==203}"><c:set var="institut" value="UHH-PB"/></c:if>
													<c:if test="${facultyId==204}"><c:set var="institut" value="UHH-BWL"/></c:if>
													
													<c:set var="url" value="${video.url}"/>
													<c:if test="${video.openAccess==0}">
														<c:set var="url" value="${video.secureUrl}"/>
													</c:if>
		
													<div id="meta-share">
														<c:if test="${option1!=null}">
																<script type="text/javascript">
																	$(function() {
																		// activate contact tab
																		$("#tabs li a").eq(-1).click();
																		
																		// Scrolling must happen in onload, because otherwise the Player is not yet loaded and the position would be wrong
																		window.onload = function () {
																			var pos = $("#tabs").offset().top;
																			$('html, body').animate({scrollTop: pos - 10}, 1000, "easeInOutCubic");	
																		}
																		
																	 });
																</script>
														</c:if>
													</div>		        
										</div>
										<c:if test="${video.hasChapters || video.hasComments}">
											<ul class="tab-pane" id="chapters">
									    		<c:forEach items="<%=segments %>" var="segment">
										    		<li class="chaptertile" id="${segment.segmentId}" begin="${segment.start}" end="${segment.end}">
														<div class="image">
													    	<a><img src="${segment.image}"></a>
													    </div>
													    <div class="title">
													    	<a><b>${segment.start} </b> ${segment.title}</a>
													    </div>
												    </li>
										    	</c:forEach>
								    		</ul>
										</c:if>
									</div>    
								</div>
						    </c:if> 
					  </div>
		
					  <c:if test="${relatedVideos.size()>1}">
						    <div class="related">
								<div class="col-md-5">
									<div class="related-lectureseries-name"><liferay-ui:message key="lecture-series"/> &nbsp;<a target="_blank" class="icon-small icon-rss" href="${video.mp4RssLink}"></a> </div>
									<ul class="ul-related">
										<c:forEach items="${relatedVideos}" var="vid">
											<c:choose>
												<c:when test="${vid.openAccess==1}">
													<c:set var="oId" value="${vid.videoId}"/>
												</c:when>
												<c:otherwise>
													<c:set var="oId" value="${vid.sPreffix}"/>
												</c:otherwise>
											</c:choose>
		
											<portlet:renderURL var="viewOpenAccessVideoURL1">
												<portlet:param name="mvcRenderCommandName" value="/view/render/details" />
												<portlet:param name="objectId" value="${oId}"/>
												<portlet:param name="objectType" value="v"/>
											</portlet:renderURL>
											
											<%-- test for the active video and highlight it --%>
											<c:set value="" var="activeClass"></c:set>
											<c:if test='${video.videoId == vid.videoId}'> 
			  									<c:set value="active" var="activeClass"></c:set>
											</c:if>
											<li class="videotile small related ${activeClass}" onClick="window.location='${viewOpenAccessVideoURL1}'">
													<div class="video-image-wrapper-small related">
														<img class="video-image related" src="${vid.imageSmall}">
													</div>
													<div class="metainfo-small related">
														<%try{ %>
														<c:set var="date" value="${vid.date.trim().substring(0, 10)}"/>
										       			<%}catch(Exception e){}%>
														<div class="title-small related">${vid.title}</div>
										       			<p class="creator-small2 related">
															${vid.linkedCreators}
										       			</p>
										           		<div class="date related">${date}</div> 
									            	</div>
											</li>
										</c:forEach>
									  </ul>
								</div>
						    </div>
					  </c:if>
				</div>
				
				<c:if test="${video.openAccess==0}">
					<!-- coockie start -->
					<script type="text/javascript">
						$(function(){
							//cookie
							$.cookie("L2G_LSID", "${lectureseries.lectureseriesId}", { path: "/" });
						});
					</script>		
					<!-- coockie end -->
				</c:if>						
		</c:when>
		<c:otherwise>
			<c:if test="${video.accessPermitted==0}">
				<portlet:renderURL var="viewOpenAccessVideoURL2">
					<portlet:param name="objectId" value="${objectId}"/>
					<c:if test="${objectType.equals('v')}">
						<portlet:param name="objectType" value="v"/>
					</c:if>
					<c:if test="${objectType.equals('l')}">
						<portlet:param name="objectType" value="l"/>
					</c:if>
				</portlet:renderURL>
				<aui:form action="${viewOpenAccessVideoURL2.toString()}" method="post">
					<aui:fieldset helpMessage="enter-password" column="true" label="l2go-video-password">
						<aui:input name="password" label="password" required="true" value=""/>
						<aui:button type="submit" value="enter"/>
					</aui:fieldset>
				</aui:form>					
			</c:if>
		</c:otherwise>		
	</c:choose>
</c:if>

<script type="text/javascript">
    $(function() {
        $('#tabs').tabs();
        $('[data-toggle=tab]').click(function(e){
    	    if ($(this).parent().hasClass('active')){
                $(this).parent().removeClass('active');
    		    $($(this).attr("href")).removeClass('active');
                // do not trigger the opening sequence from the tabs widget
    		    e.stopPropagation();
            }
    	});
    });
    
    $(document).ready(function(){
		$('.meta-description').readmore({
			collapsedHeight: 60,
		  	moreLink: '<a href="#"><div><liferay-ui:message key="more"/><img class ="down_up" src="/lecture2go-theme/images/arrow_down.svg"/></div></a>',
		  	lessLink: '<a href="#"><div><liferay-ui:message key="less"/><img class ="down_up" src="/lecture2go-theme/images/arrow_up.svg"/></div></a>'
		});
	}); 
</script> 

<style type="text/css">
	.aui #breadcrumbs .breadcrumb {
	    display: none;
	}
	.current-page{
		display: none;
	}
</style>  		
