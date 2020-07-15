<%@include file="init.jsp" %>

<jsp:useBean id="parentInstitutionId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="institutionId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="termId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="categoryId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="creatorId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="mediaTypeId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="tag" type="java.lang.String" scope="request"/>
<jsp:useBean id="licenseId" type="java.lang.Long" scope="request"/>
<jsp:useBean id="searchType" type="java.lang.Integer" scope="request"/>
<jsp:useBean id="findVideos" type="java.lang.String" scope="request"/>
<jsp:useBean id="sortBy" type="java.lang.String" scope="request"/>
<jsp:useBean id="sortableFields" type="java.util.List<java.lang.String>" scope="request"/>
<jsp:useBean id="maxTerms" type="java.lang.Integer" scope="request"/>
<jsp:useBean id="hasInstitutionFiltered" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="hasParentInstitutionFiltered" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="hasTermFiltered" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="hasCreatorFiltered" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="hasCategoryFiltered" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="hasMediaTypeFiltered" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="hasTagFiltered" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="hasLicenseFiltered" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="isSearched" type="java.lang.Boolean" scope="request"/>
<jsp:useBean id="videoList" type="java.util.List<VideoListSearchResult>" scope="request"/>
<jsp:useBean id="lectureseriesIds" type="java.util.ArrayList<Long>" scope="request"/>
<jsp:useBean id="videoIds" type="java.util.ArrayList<Long>" scope="request"/>

<jsp:useBean id="presentParentInstitutions" type="java.util.List<Institution>" scope="request"/>
<jsp:useBean id="presentInstitutions" type="java.util.List<Institution>" scope="request"/>
<jsp:useBean id="presentTerms" type="java.util.List<Term>" scope="request"/>
<jsp:useBean id="presentCategories" type="java.util.List<Category>" scope="request"/>
<jsp:useBean id="presentMediaTypes" type="java.util.Set<de.uhh.l2g.plugins.model.MediaType>" scope="request"/>
<jsp:useBean id="presentLicenses" type="java.util.Set<de.uhh.l2g.plugins.model.License>" scope="request"/>

<jsp:useBean id="portletURL" type="javax.portlet.PortletURL" scope="request"/>
<jsp:useBean id="resultSetEmpty" type="java.lang.Boolean" scope="request"/>

<jsp:useBean id="insti" type="de.uhh.l2g.plugins.model.Institution" scope="request"/>
<jsp:useBean id="pInst" type="de.uhh.l2g.plugins.model.Institution" scope="request"/>
<jsp:useBean id="rInst" type="de.uhh.l2g.plugins.model.Institution" scope="request"/>

<c:set var="portalURL"
       value="<%=PrefsPropsUtil.getString(company.getCompanyId(),PropsKeys.DEFAULT_LANDING_PAGE_PATH)%>"/>
<c:set var="pageName" value="<%=themeDisplay.getLayout().getName(themeDisplay.getLocale())%>"/>
<c:set var="displayTerms" value="<%=new DisplayTerms(renderRequest)%>"/>

<%
    // set page context for better use in taglibs
    pageContext.setAttribute("hasParentInstitutionFiltered", hasParentInstitutionFiltered);
    pageContext.setAttribute("hasInstitutionFiltered", hasInstitutionFiltered);
    pageContext.setAttribute("hasTermFiltered", hasTermFiltered);
    pageContext.setAttribute("hasCreatorFiltered", hasCreatorFiltered);
    pageContext.setAttribute("hasCategoryFiltered", hasCategoryFiltered);
    pageContext.setAttribute("hasMediaTypeFiltered", hasMediaTypeFiltered);
    pageContext.setAttribute("hasTagFiltered", hasTagFiltered);
    pageContext.setAttribute("hasLicenseFiltered", hasLicenseFiltered);
    pageContext.setAttribute("hasManyTerms", presentTerms.size() > maxTerms);
%>

<portlet:renderURL var="backURL0">
    <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
    <portlet:param name="parentInstitutionId" value="0"/>
    <portlet:param name="institutionId" value="0"/>
    <portlet:param name="termId" value="0"/>
    <portlet:param name="categoryId" value="0"/>
    <portlet:param name="creatorId" value="0"/>
    <portlet:param name="mediaTypeId" value="0"/>
    <portlet:param name="tag" value="0"/>
    <portlet:param name="licenseId" value="0"/>
</portlet:renderURL>

<div class="path-wide">
    <a href="${portalURL}" class="breadcrumb-item">${company.name}</a>
    <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    <a href="${backURL0}" class="breadcrumb-item">${pageName}</a>
    <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>

    <c:if test="${rInst.name.length()>0}">
        <A HREF="${backURL0}" class="breadcrumb-item">${rInst.name}</A>
    </c:if>

    <c:if test="${pInst.name.length()>0}">
        <portlet:renderURL var="backURL1">
            <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
            <portlet:param name="parentInstitutionId" value="${pInst.institutionId}\'\'"/>
            <portlet:param name="institutionId" value="0"/>
            <portlet:param name="termId" value="0"/>
            <portlet:param name="categoryId" value="0"/>
            <portlet:param name="creatorId" value="0"/>
            <portlet:param name="mediaTypeId" value="0"/>
            <portlet:param name="tag" value="0"/>
            <portlet:param name="licenseId" value="0"/>
        </portlet:renderURL>
        <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <A HREF="${backURL1}" class="breadcrumb-item">${pInst.name}</A>
    </c:if>

    <c:if test="${insti.name.length()>0}">
        <portlet:renderURL var="backURL2">
            <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
            <portlet:param name="parentInstitutionId" value="${pInst.institutionId}\'\'"/>
            <portlet:param name="institutionId" value="${insti.institutionId}\'\'"/>
            <portlet:param name="termId" value="0"/>
            <portlet:param name="categoryId" value="0"/>
            <portlet:param name="creatorId" value="0"/>
            <portlet:param name="mediaTypeId" value="0"/>
            <portlet:param name="tag" value="0"/>
            <portlet:param name="licenseId" value="0"/>
        </portlet:renderURL>
        <span class="uhh-icon-arrow-right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <A HREF="${backURL2}" class="breadcrumb-item">${insti.name}</A>
    </c:if>
</div>

<h1><liferay-ui:message key="video-catalog"/></h1>

<div class="sortByList">
	<c:forEach items="${sortableFields}" var="sortBySelect">
		<portlet:renderURL var="sort">
		    <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
		    <portlet:param name="parentInstitutionId" value='${parentInstitutionId}'/>
		    <portlet:param name="institutionId" value="${institutionId}"/>
		    <portlet:param name="termId" value="${termId}"/>
		    <portlet:param name="categoryId" value="${categoryId}"/>
		    <portlet:param name="creatorId" value="${creatorId}"/>
		    <portlet:param name="mediaTypeId" value="${mediaTypeId}"/>
		    <portlet:param name="tag" value="${tag}"/>
		    <portlet:param name="licenseId" value="${licenseId}"/>
		    <portlet:param name="searchType" value="${searchType}"/>
		    <portlet:param name="findVideos" value="${findVideos}"/>
		    <portlet:param name="previousSortBy" value="${sortBy}"/>
		    <portlet:param name="sortBy" value="${sortBySelect}"/>
		    <portlet:param name="sortByOrder" value="${sortByOrder}"/>
		</portlet:renderURL>
        <c:choose>
            <c:when test="${sortBySelect == sortBy}">
            	<a href="${sort}" class="selected"><liferay-ui:message key="sort-by-${sortBySelect}"/></a>
                <c:if test="${sortByOrder == 'ASC'}">
	                <i class="icon-chevron-up"></i>
	            </c:if>
                <c:if test="${sortByOrder == 'DESC'}">
	            	<i class="icon-chevron-down"></i>
	            </c:if>
            </c:when>
            <c:otherwise>
            	<a href="${sort}"><liferay-ui:message key="sort-by-${sortBySelect}"/></a>
            </c:otherwise>
        </c:choose>
		<span>|</span>
	</c:forEach>
</div>

<div class="catalogue-container row">
    <!-- catalogue-container -->
    <div class="col-md-8 col-12">

        <liferay-ui:search-container emptyResultsMessage="no-lectureseries-or-videos-found" delta="20"
                                     iteratorURL="${portletURL}" displayTerms="${displayTerms}">

            <liferay-ui:search-container-results>
                <%
                    searchContainer.setTotal(videoList.size());
                    searchContainer.setResults(ListUtil.subList(videoList, searchContainer.getStart(), searchContainer.getEnd()));
                %>
            </liferay-ui:search-container-results>

            <liferay-ui:search-container-row className="de.uhh.l2g.plugins.model.VideoListSearchResult"
                                             keyProperty="lectureseriesId" modelVar="lectser">
                <c:set var="oId" value=""/>
                <c:set var="isVideo" value="<%=false%>"/>
                <c:set var="vidDummy" value="<%=VideoLocalServiceUtil.createVideo(0)%>"/>
                <c:choose>
                    <c:when test="${lectser.videoId>0}">
                        <c:set var="isVideo" value="<%=true%>"/>
                        <%try {%><c:set var="vidDummy"
                                        value="<%=VideoLocalServiceUtil.getCurrentlyValidVideo(lectser.getVideoId())%>"/><%
                        } catch (Exception e) {
                        }
                        ;
                    %>
                        <c:set var="oId" value="${vidDummy.videoId}"/>
                    </c:when>
                    <c:otherwise>
                        <%try {%><c:set var="vidDummy"
                                        value="<%=VideoLocalServiceUtil.getCurrentlyValidVideo(lectser.getPreviewVideoId())%>"/><%
                        } catch (Exception e) {
                        }
                        ;
                    %>
                        <c:set var="oId" value="${lectser.lectureseriesId}"/>
                    </c:otherwise>
                </c:choose>
                <c:set var="videoCount" value="${lectser.numberOfOpenAccessVideos}"/>
                <c:if test="${videoCount>0 && isSearched && lectser.videoIds.size() > 0}">
                    <!-- get videos by id list -->
                    <c:set var="vl" value="${lectser.getVideoIds()}"/>
                </c:if>

                <liferay-ui:search-container-column-text>
                    <portlet:renderURL var="view1URL">
                        <portlet:param name="mvcRenderCommandName" value="/view/render/details"/>
                        <portlet:param name="objectId" value="${oId}"/>
                        <c:if test="${isVideo}"><portlet:param name="objectType" value="v"/></c:if>
                        <c:if test="${!isVideo}"><portlet:param name="objectType" value="l"/></c:if>
                    </portlet:renderURL>

                    <div id="vt${oId}" data-vl="${vl}" class="row videotile load-video-sublist" <c:if test="${videoCount==0}">
                        onClick="window.location='${view1URL}'"
                    </c:if>>
                        <c:choose>
                            <c:when test="${videoCount==0 && isVideo}">
                                <div class="video-image-wrapper col-md-4">
                                    <img class="video-image" src="${vidDummy.getImageMedium()}"/>
                                </div>
                                <div class="video-content-wrapper col-md-8">
                                    <div class="video-content">
                                        <div class="video-label">
                                            <c:set var="cat" value=""/>
                                            <c:set var="vId" value="${vidDummy.videoId}"/>
                                            <c:set var="vi"
                                                   value="<%=Video_InstitutionLocalServiceUtil.getByVideo((Long)pageContext.getAttribute("vId"))%>"/>
                                            <%try {%>
                                            <c:set var="cId"
                                                   value="<%=Video_CategoryLocalServiceUtil.getByVideo(lectser.getLectureseriesId()).get(0).getCategoryId()%>"/>
                                            <c:set var="cat"><a
                                                    href='/l2go/-/get/0/0/${cId}/0/0/0/'><%=CategoryLocalServiceUtil.getById((Long) pageContext.getAttribute("cId")).getName()%>
                                            </a></c:set>
                                                ${cat}
                                            <c:set var="iId" value="${vi.get(0).institutionId}"/>
                                            <c:set var="inst"
                                                   value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("iId"))%>"/>
                                            <c:set var="instLink"><a
                                                    href='/l2go/-/get/${inst.institutionId}/${inst.parentId}/0/0/0/0/'>${inst.name}</a></a></c:set>
                                            <%
                                                } catch (Exception e) {
                                                }
                                            %>
                                            <%try {%>
                                            <c:set var="term"
                                                   value="<%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName()%>"/>
                                            <span class="term-of-creation col-3">${term}</span>
                                            <%
                                                } catch (Exception e) {
                                                }
                                            %>
                                        </div>
                                        <div class="video-title dot-ellipsis dot-resize-update">
                                            <a href="${view1URL}">${lectser.name}</a>
                                        </div>

                                        <div class="allcreators">
                                                ${vidDummy.linkedCreators}
                                        </div>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <!-- multiple videos in lecture series -->
                                <div class="video-image-wrapper col-md-4">
                                    <div class="badge mr-3">${videoCount}</div>
                                    <img class="video-image-big layered-paper darker" src="${vidDummy.imageMedium}"/>
                                    <span class="tri"></span>
                                    <span class="overlay"></span>
                                </div>

                                <div class="video-content-wrapper col-md-8">
                                    <div class="video-content">
                                        <div class="video-label">
                                            <c:set var="cat">
                                                <a href='/l2go/-/get/0/0/${lectser.categoryId}/0/0/0/'><%=CategoryLocalServiceUtil.getById(lectser.getCategoryId()).getName()%>
                                                </a>
                                            </c:set>
                                            <c:set var="li"
                                                   value="<%=Lectureseries_InstitutionLocalServiceUtil.getByLectureseries(lectser.getLectureseriesId())%>"/>
                                                ${cat}
                                            <c:set var="iId" value="${li.get(0).institutionId}"/>
                                            <c:set var="inst"
                                                   value="<%=InstitutionLocalServiceUtil.getById((Long)pageContext.getAttribute("iId"))%>"/>
                                            <span class="separator">|</span>
                                            <c:set var="instLink"><a
                                                    href='/l2go/-/get/${inst.institutionId}/${inst.parentId}/0/0/0/0/'>${inst.name}</a></c:set>
                                                ${instLink}
                                            <%try {%>
                                            <c:set var="term"
                                                   value="<%=TermLocalServiceUtil.getTerm(lectser.getTermId()).getTermName()%>"/>
                                            <span class="term-of-creation col-3">${term}</span>
                                        </div>
                                        <%
                                            } catch (Exception e) {
                                            }
                                        %>
                                        <div class="video-title dot-ellipsis dot-resize-update dot-height-40">
                                            <a href="${view1URL}">${lectser.name}</a>
                                        </div>
                                        <c:set var="lId" value="${vidDummy.lectureseriesId}"/>
                                        <c:set var="allcreators"
                                               value="<%=CreatorLocalServiceUtil.getCommaSeparatedLinkedCreatorsByLectureseriesIdAndMaxCreators((Long)pageContext.getAttribute("lId"), 3)%>"/>
                                        <div class="allcreators">
                                                ${allcreators}
                                        </div>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                        <!-- videotile end-->
                    </div>
                    <!-- sublist for videos -->
                    <c:if test="${videoCount>0}">
                        <div class='videolist'>
                            <button id="b${oId}">
								<span class="lfr-icon-menu-text">
									<i class="icon-chevron-right"></i>
								</span>
                            </button>
                            <ul id="p${oId}" class="${lectser.isDummy() ? 'showOnLoad' : 'hideOnLoad'}">
                                <div class="sublist-container">
	                                <!-- show video list for dummy lecture series (i.e. from search) -->
		                            <c:if test="${lectser.isDummy()}">
		                            	<c:set var="videoList" value="<%=VideoLocalServiceUtil.getByVideoIds(ConverterUtil.idListToArray(lectser.getVideoIds()))%>"/>
		                                <c:forEach items="${videoList}" var="v">
		                                    <portlet:renderURL var="vURL">
		                                        <portlet:param name="mvcRenderCommandName" value="/view/render/details"/>
		                                        <portlet:param name="objectType" value="v"/>
		                                        <portlet:param name="objectId" value="${v.videoId}"/>
		                                    </portlet:renderURL>
		
		                                    <li class="videotile small" onClick="window.location='${vURL}'">
		                                        <c:set var="date" value="${v.simpleDate.trim()}"/>
		                                        <div class="col-md-3 video-image-wrapper">
		                                            <img class="video-image" src="${v.imageSmall}">
		                                            <div class="term-of-creation-mobile">${date}</div>
		                                        </div>
		                                        <%try {%>
		                                        <c:set var="dur" value="${v.duration.trim().substring(0, 8)}"/>
		                                        <%
		                                            } catch (Exception e) {
		                                            }
		                                        %>
		                                        <div class="col-md-9 metainfo-small">
		                                            <div class="row">
		                                                <div class="title-small col-8">${v.title}</div>
		                                                <div class="term-of-creation col-4">${date}</div>
		                                            </div>
		                                            <div class="allcreators">
		                                                    ${v.linkedCreators}
		                                            </div>
		                                        </div>
		                                    </li>
		                                </c:forEach>
		                            </c:if>
	                            </div>
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

            <liferay-ui:search-iterator/>

        </liferay-ui:search-container>
        <!-- span9 -->
    </div>

    <!-- filter -->
    <c:if test="${!resultSetEmpty}">
        <div class="col-md-4 col-12">
            <liferay-ui:panel-container>
                <!-- parentinstitution filter -->
                <c:if test="${presentParentInstitutions.size()>0}">
                    <liferay-ui:panel defaultState='${hasParentInstitutionFiltered ? "open" : "collapsed"}' extended="true" title="institution"
                                      cssClass='${hasParentInstitutionFiltered ? "filtered" : "notFiltered"}'>
                        <ul class="colored-bullets">
                            <c:forEach items="${presentParentInstitutions}" var="parentInstitution">
                                <portlet:renderURL var="filterByParentInstitution">
                                    <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
                                    <portlet:param name="parentInstitutionId"
                                                   value='${hasParentInstitutionFiltered ? "0" : parentInstitution.institutionId}'/>
                                    <portlet:param name="institutionId" value="${institutionId}"/>
                                    <portlet:param name="termId" value="${termId}"/>
                                    <portlet:param name="categoryId" value="${categoryId}"/>
                                    <portlet:param name="creatorId" value="${creatorId}"/>
                                    <portlet:param name="mediaTypeId" value="${mediaTypeId}"/>
                                    <portlet:param name="tag" value="${tag}"/>
                                    <portlet:param name="licenseId" value="${licenseId}"/>
                                    <portlet:param name="searchType" value="${searchType}"/>
                                    <portlet:param name="findVideos" value="${findVideos}"/>
                                </portlet:renderURL>
                                <li class="filter-menu">
                                    <a href="${filterByParentInstitution}" class="row">
                                        <div class="filter-menu-link">
                                                ${parentInstitution.name}
                                        </div>
                                        <div class="autofit-col-expand"></div>
                                        <span ${hasParentInstitutionFiltered ? 'class="icon-large icon-remove"' : ''}></span>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </liferay-ui:panel>
                </c:if>

                <!-- institution filter -->
                <c:if test="${hasParentInstitutionFiltered}">
                    <c:if test="${presentInstitutions.size()>0}">
                        <liferay-ui:panel defaultState='${hasInstitutionFiltered ? "open" : "collapsed"}' extended="true" title="sub-institution"
                                          cssClass='${hasInstitutionFiltered ? "filtered" : "notFiltered"}'>
                            <ul class="colored-bullets">
                                <c:forEach items="${presentInstitutions}" var="institution">
                                    <portlet:renderURL var="filterByInstitution">
                                        <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
                                        <portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
                                        <portlet:param name="institutionId"
                                                       value='${hasInstitutionFiltered ? "0" : institution.institutionId}'/>
                                        <portlet:param name="termId" value="${termId}"/>
                                        <portlet:param name="categoryId" value="${categoryId}"/>
                                        <portlet:param name="creatorId" value="${creatorId}"/>
                                        <portlet:param name="mediaTypeId" value="${mediaTypeId}"/>
                                        <portlet:param name="tag" value="${tag}"/>
                                        <portlet:param name="licenseId" value="${licenseId}"/>
                                        <portlet:param name="searchType" value="${searchType}"/>
                                        <portlet:param name="findVideos" value="${findVideos}"/>
                                    </portlet:renderURL>
                                    <li class="filter-menu">
                                        <a href="${filterByInstitution}" class="row">
                                            <div class="filter-menu-link">
                                                    ${institution.name}
                                            </div>
                                            <div class="autofit-col-expand"></div>
                                            <span ${hasInstitutionFiltered ? 'class="icon-large icon-remove"' : ''}></span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </liferay-ui:panel>
                    </c:if>
                </c:if>

                <!-- terms filter -->
                <c:if test="${presentTerms.size()>0}">
                    <liferay-ui:panel defaultState='${hasTermFiltered ? "open" : "collapsed"}' extended="true" title="term"
                                      cssClass='${hasTermFiltered ? "filtered" : "notFiltered"}'>
                        <ul class="terms colored-bullets">
                            <c:forEach items="${presentTerms}" var="term">
                                <portlet:renderURL var="filterByTerm">
                                    <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
                                    <portlet:param name="institutionId" value="${institutionId}"/>
                                    <portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
                                    <portlet:param name="termId" value='${hasTermFiltered ? "0" : term.termId}'/>
                                    <portlet:param name="categoryId" value="${categoryId}"/>
                                    <portlet:param name="creatorId" value="${creatorId}"/>
                                    <portlet:param name="mediaTypeId" value="${mediaTypeId}"/>
                                    <portlet:param name="tag" value="${tag}"/>
                                    <portlet:param name="licenseId" value="${licenseId}"/>
                                    <portlet:param name="searchType" value="${searchType}"/>
                                    <portlet:param name="findVideos" value="${findVideos}"/>
                                </portlet:renderURL>
                                <li class="filter-menu">
                                    <a href="${filterByTerm}" class="row">
                                        <div class="filter-menu-link">
                                                ${term.termName}
                                        </div>
                                        <div class="autofit-col-expand"></div>
                                        <span ${hasTermFiltered ? 'class="icon-large icon-remove"' : ''}></span>
                                    </a>
                                    <c:choose>
                                        <c:when test="${term.termName==''}">
                                            <liferay-ui:message key="no-term"/>
                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>
                                    </c:choose>
                                </li>
                            </c:forEach>
                        </ul>
                        <c:if test="${hasManyTerms}">
                            <a id="loadMoreTerms" class="load-more-link"><liferay-ui:message key="more"/></a>
                        </c:if>
                    </liferay-ui:panel>
                </c:if>

                <!-- category filter -->
                <c:if test="${presentCategories.size()>0}">
                    <liferay-ui:panel defaultState='${hasCategoryFiltered ? "open" : "collapsed"}' extended="true" title="category"
                                      cssClass='${hasCategoryFiltered ? "filtered" : "notFiltered"}'>
                        <ul class="colored-bullets">
                            <c:forEach items="${presentCategories}" var="category">
                                <portlet:renderURL var="filterByCategory">
                                    <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
                                    <portlet:param name="institutionId" value="${institutionId}"/>
                                    <portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
                                    <portlet:param name="termId" value="${termId}"/>
                                    <portlet:param name="categoryId"
                                                   value='${hasCategoryFiltered ? "0" : category.categoryId}'/>
                                    <portlet:param name="creatorId" value="${creatorId}"/>
                                    <portlet:param name="mediaTypeId" value="${mediaTypeId}"/>
                                    <portlet:param name="tag" value="${tag}"/>
                                    <portlet:param name="licenseId" value="${licenseId}"/>
                                    <portlet:param name="searchType" value="${searchType}"/>
                                    <portlet:param name="findVideos" value="${findVideos}"/>
                                </portlet:renderURL>
                                <li class="filter-menu">
                                    <a href="${filterByCategory}" class="row">
                                        <div class="filter-menu-link">
                                                ${category.name}
                                        </div>
                                        <div class="autofit-col-expand"></div>
                                        <span ${hasCategoryFiltered ? 'class="icon-large icon-remove"' : ''}></span>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </liferay-ui:panel>
                </c:if>

                <!-- creator filter -->
                <liferay-ui:panel defaultState='${hasCreatorFiltered ? "open" : "collapsed"}' extended="true" title="creator"
                                  cssClass='${hasCreatorFiltered ? "filtered" : "notFiltered"}'>
                    <div class="firstCharacterSelector" id="firstCharacterSelector"></div>

                    <div id="creator-list"></div>
                    <a class="load-more-link all-characters" data-character="*" data-entity="creator">
                        <liferay-ui:message key="more"/>
                    </a>
                </liferay-ui:panel>

                <!-- media type filter -->
                <c:if test="${presentMediaTypes.size()>0}">
                    <liferay-ui:panel defaultState='${hasMediaTypeFiltered ? "open" : "collapsed"}' extended="true" title="media-types"
                                      cssClass='${hasMediaTypeFiltered ? "filtered" : "notFiltered"}'>

                        <div class="media-types">
                            <ul class="colored-bullets">
                                <c:forEach items="${presentMediaTypes}" var="mediaType">
                                    <portlet:renderURL var="filterByMediaType">
                                        <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
                                        <portlet:param name="institutionId" value="${institutionId}"/>
                                        <portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
                                        <portlet:param name="termId" value='${termId}'/>
                                        <portlet:param name="categoryId" value="${categoryId}"/>
                                        <portlet:param name="creatorId" value='${creatorId}'/>
                                        <portlet:param name="mediaTypeId" value='${hasMediaTypeFiltered ? "0" : mediaType.mediaTypeId}'/>
                                        <portlet:param name="tag" value='${tag}'/>
                                        <portlet:param name="licenseId" value="${licenseId}"/>
                                        <portlet:param name="searchType" value="${searchType}"/>
                                        <portlet:param name="findVideos" value="${findVideos}"/>
                                    </portlet:renderURL>
                                    <li class="videoIds">
                                        <a href="${filterByMediaType}" class="row">
                                            <div class="filter-menu-link">
                                                    ${mediaType.mediaTypeName}
                                            </div>
                                            <div class="autofit-col-expand"></div>
                                            <span ${hasMediaTypeFiltered ? 'class="icon-large icon-remove"' : ''}></span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </liferay-ui:panel>
                </c:if>

                <!-- tag filter -->
                <liferay-ui:panel defaultState='${hasTagFiltered ? "open" : "collapsed"}' extended="true" title="tags"
                                  cssClass='${hasTagFiltered ? "filtered" : "notFiltered"}'>
                    <div class="firstCharacterSelector" id="firstCharacterSelectorTags"></div>
                    <div id="tag-list"></div>
                    <a class="load-more-link all-characters" data-character="*" data-entity="tag">
                        <liferay-ui:message key="more"/>
                    </a>
                </liferay-ui:panel>

                <!-- license filter -->
                <c:if test="${presentLicenses.size()>0}">
                    <liferay-ui:panel defaultState='${hasLicenseFiltered ? "open" : "collapsed"}' extended="true" title="licenses"
                                      cssClass='${hasLicensesFiltered ? "filtered" : "notFiltered"}'>

                        <div class="licenses">
                            <ul class="colored-bullets">
                                <c:forEach items="${presentLicenses}" var="license">
                                    <portlet:renderURL var="filterByLicense">
                                        <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
                                        <portlet:param name="institutionId" value="${institutionId}"/>
                                        <portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
                                        <portlet:param name="termId" value='${termId}'/>
                                        <portlet:param name="categoryId" value="${categoryId}"/>
                                        <portlet:param name="creatorId" value='${creatorId}'/>
                                        <portlet:param name="mediaTypeId" value='${mediaTypeId}'/>
                                        <portlet:param name="tag" value='${tag}'/>
                                        <portlet:param name="licenseId" value='${hasLicenseFiltered ? "0" : license.licenseId}'/>
                                        <portlet:param name="searchType" value="${searchType}"/>
                                        <portlet:param name="findVideos" value="${findVideos}"/>
                                    </portlet:renderURL>
                                    <li class="videoIds">
                                        <a href="${filterByLicense}" class="row">
                                            <div class="filter-menu-link">
                                                    ${license.shortIdentifier}
                                            </div>
                                            <div class="autofit-col-expand"></div>
                                            <span ${hasLicenseFiltered ? 'class="icon-large icon-remove"' : ''}></span>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </liferay-ui:panel>
                </c:if>
            </liferay-ui:panel-container>
            <!-- span3 -->
        </div>
    </c:if>
</div>

<liferay-portlet:resourceURL id="getVideosForLectureSeries" var="getVideosForLectureSeriesURL" />
<liferay-portlet:resourceURL id="getCreators" var="getCreatorsURL" />
<liferay-portlet:resourceURL id="getTags" var="getTagsURL" />

<portlet:renderURL var="filterByCreator">
    <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
    <portlet:param name="institutionId" value="${institutionId}"/>
    <portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
    <portlet:param name="termId" value='${termId}'/>
    <portlet:param name="categoryId" value="${categoryId}"/>
    <portlet:param name="mediaTypeId" value="${mediaTypeId}"/>
    <portlet:param name="tag" value="${tag}"/>
    <portlet:param name="licenseId" value="${licenseId}"/>
    <portlet:param name="searchType" value="${searchType}"/>
    <portlet:param name="findVideos" value="${findVideos}"/>
</portlet:renderURL>

<portlet:renderURL var="filterByTag">
    <portlet:param name="mvcRenderCommandName" value="/view/render/list"/>
    <portlet:param name="institutionId" value="${institutionId}"/>
    <portlet:param name="parentInstitutionId" value="${parentInstitutionId}"/>
    <portlet:param name="termId" value='${termId}'/>
    <portlet:param name="categoryId" value="${categoryId}"/>
    <portlet:param name="mediaTypeId" value="${mediaTypeId}"/>
    <portlet:param name="creatorId" value="${creatorId}"/>
    <portlet:param name="licenseId" value="${licenseId}"/>
    <portlet:param name="searchType" value="${searchType}"/>
    <portlet:param name="findVideos" value="${findVideos}"/>
</portlet:renderURL>

<script type="text/javascript">
	$(function() {
	    loadCreatorList();
	    loadTagList();

		// decode the search query to plain text (via an in cache div)
		highlightSearchWord();

        // click handler for loading video sublist
        $('div[id^="vt"]').click(function() {
            loadVideoSublist(this.id.substring(2));
        });

        $('button[id^="b"]').click(function() {
            loadVideoSublist(this.id.substring(1));
        });
	});

	function highlightSearchWord() {
        var searchQuery = $('<div/>').html('<%= findVideos %>').text();
        var markOptions = {
            "separateWordSearch": false
        };
        if (searchQuery) {
            $(".videotile").mark(searchQuery, markOptions);
        }
    }

    function loadCreatorList(){
	    const hasCreatorFiltered = "${hasCreatorFiltered}";
	    const creatorId = "${creatorId}";
	    const lectureSeriesIds = "${lectureseriesIds}";
	    const videoIds = "${videoIds}";
        const firstCharacterSelector = $('#firstCharacterSelector');

        firstCharacterSelector.append('<div id="loading-spinner-creators" class="loading-spinner"><i class="icon-spinner"></i></div>');

        $.ajax({
            type: "POST",
            url: "${getCreatorsURL}",
            dataType: 'json',
            async: true,
            data: {
                "<portlet:namespace/>hasCreatorFiltered": hasCreatorFiltered,
                "<portlet:namespace/>creatorId": creatorId,
                "<portlet:namespace/>lectureSeriesIds": lectureSeriesIds,
                "<portlet:namespace/>videoIds": videoIds
            },
            success: function(data) {
                data.forEach(result => {
                    for (const [key, value] of Object.entries(result)) {
                        if (value.length > 0) {
                            firstCharacterSelector.append('<a class="select-character" ' +
                                'data-character="'+ key +'" data-entity="creator">' + key + '</a>');
                            $('#creator-list').append('<div class="alphabet-list" data-character="'+key+'" ' +
                                'data-entity="creator"><ul class="colored-bullets" data-character="'+key+'" ' +
                                'data-entity="creator"></ul></div>');
                            value.forEach(creator => {
                                let creatorName = creator.lastName;
                                if (creator.middleName !== '' && creator.jobTitle !== '') {
                                    creatorName = creatorName + ', ' + creator.firstName + ' ' + creator.middleName +
                                        ', ' + creator.jobTitle;
                                } else if (creator.middleName === '' && creator.jobTitle !== '') {
                                    creatorName = creatorName + ', ' + creator.firstName + ', ' + creator.jobTitle;
                                } else if (creator.middleName !== '' && creator.jobTitle === '') {
                                    creatorName = creatorName + ', ' + creator.firstName + ' ' + creator.middleName;
                                } else {
                                    creatorName = creatorName + ', ' + creator.firstName;
                                }

                                let creatorURL = '${filterByCreator}&<portlet:namespace/>creatorId=';
                                if ("${hasCreatorFiltered}" === "true") {
                                    creatorURL = creatorURL + 0;
                                } else {
                                    creatorURL = creatorURL + creator.creatorId;
                                }

                                $('.colored-bullets[data-entity="creator"][data-character="'+key+'"')
                                    .append('<li class="videoIds"><a href="'+creatorURL+'" class="row">' +
                                        '<div class="filter-menu-link">'+ creatorName + '</div>' +
                                        '<div class="autofit-col-expand"></div>\n' +
                                        '<span ${hasCreatorFiltered ? 'class="icon-large icon-remove"' : ''}></span>' +
                                        '</a></li>');
                            });
                            $('.alphabet-list[data-character="' + key +'"][data-entity="creator"]')
                                .append('<a class="load-more-link all-characters" data-character="'+key+'" ' +
                                    'data-entity="creator"><liferay-ui:message key="more"/></a>');
                        } else {
                            firstCharacterSelector.append('<span>' + key + '</span>');
                        }
                    }
                    firstCharacterSelector
                        .append('<a class="select-character selected" data-character="*" data-entity="creator">Alle</a>');
                });

                toggleEntriesForCharacter('*', 'creator');
                updateClickHandlers();
                $('#loading-spinner-creators').remove();
            }
        });
    }

    function loadTagList(){
	    const hasTagFiltered = "${hasTagFiltered}";
	    const tag = "${tag}";
	    const lectureSeriesIds = "${lectureseriesIds}";
	    const videoIds = "${videoIds}";
        const firstCharacterSelector = $('#firstCharacterSelectorTags');

        firstCharacterSelector.append('<div id="loading-spinner-tags"><i class="icon-spinner"></i></div>');

        $.ajax({
            type: "POST",
            url: "${getTagsURL}",
            dataType: 'json',
            async: true,
            data: {
                "<portlet:namespace/>hasTagFiltered": hasTagFiltered,
                "<portlet:namespace/>tag": tag,
                "<portlet:namespace/>lectureSeriesIds": lectureSeriesIds,
                "<portlet:namespace/>videoIds": videoIds
            },
            success: function(data) {
                data.forEach(result => {
                    for (const [key, value] of Object.entries(result)) {
                        if (value.length > 0) {
                            firstCharacterSelector.append('<a class="select-character" ' +
                                'data-character="'+ key +'" data-entity="tag">' + key + '</a>');
                            $('#tag-list').append('<div class="alphabet-list" data-character="'+key+'" ' +
                                'data-entity="tag"><ul class="colored-bullets" data-character="'+key+'" ' +
                                'data-entity="tag"></ul></div>');
                            value.forEach(tag => {
                                let tagURL = '${filterByTag}&<portlet:namespace/>tag=';
                                if ("${hasTagFiltered}" === "true") {
                                    tagURL = tagURL + 0;
                                } else {
                                    tagURL = tagURL + tag;
                                }

                                $('.colored-bullets[data-entity="tag"][data-character="'+key+'"')
                                    .append('<li class="videoIds"><a href="'+tagURL+'" class="row">' +
                                        '<div class="filter-menu-link">'+ tag + '</div>' +
                                        '<div class="autofit-col-expand"></div>\n' +
                                        '<span ${hasTagFiltered ? 'class="icon-large icon-remove"' : ''}></span>' +
                                        '</a></li>');
                            });
                            $('.alphabet-list[data-character="' + key +'"][data-entity="tag"]')
                                .append('<a class="load-more-link all-characters" data-character="'+key+'" ' +
                                    'data-entity="tag"><liferay-ui:message key="more"/></a>');
                        } else {
                            firstCharacterSelector.append('<span>' + key + '</span>');
                        }
                    }
                    firstCharacterSelector
                        .append('<a class="select-character selected" data-character="*" data-entity="tag">Alle</a>');
                });

                toggleEntriesForCharacter('*', 'tag');
                updateClickHandlers();
                $('#loading-spinner-tags').remove();
            }
        });
    }

    function updateClickHandlers() {
        $('.load-more-link').click(function (event) {
            expandEntries(event.target.dataset.character, event.target.dataset.entity);
        });

        $('.select-character').click(function(event) {
            const target = event.target;
            $('a.select-character.selected[data-entity="' + target.dataset.entity + '"]').removeClass('selected');
            target.classList.add('selected');
            const character = target.dataset.character.toString();
            const entity = target.dataset.entity.toString();
            toggleEntriesForCharacter(character, entity);
        });
    }

    function loadVideoSublist(lectureSeriesId) {
        if (lectureSeriesId > 0) {
            const sublistDom = $('ul#p' + lectureSeriesId + '> .sublist-container');
            const sublistDomLength = sublistDom.children('li').length;
            const videoIds = $('div#vt' + lectureSeriesId)[0].dataset.vl;

            if (sublistDomLength === 0) {
                sublistDom.append('<div class="loading-spinner" id="loading-spinner-sublist"><i class="icon-spinner"></i></div>');

                $.ajax({
                    type: "GET",
                    url: "${getVideosForLectureSeriesURL}",
                    dataType: 'json',
                    async: true,
                    data: {
                        "<portlet:namespace/>objectId": lectureSeriesId,
                        "<portlet:namespace/>videoIds": videoIds
                    },
                    success: function(data) {
                        $('#loading-spinner-sublist').remove();
                        data.forEach(sublist => {
                            sublist.forEach(video => {
                                sublistDom.append('<li class="videotile small" ' +
                                    'onClick="window.location=\'' + video.url + '\'">' +
                                    '<div class="col-md-3 video-image-wrapper">' +
                                    '<img class="video-image" src="' + video.imageSmall + '">' +
                                    '<div class="term-of-creation-mobile">' + video.simpleDate + '</div>' +
                                    '</div><div class="col-md-9 metainfo-small"><div class="row">' +
                                    '<div class="title-small col-8">' + video.title + '</div>' +
                                    '<div class="term-of-creation col-4">' + video.simpleDate + '</div></div>' +
                                    '<div class="allcreators">' + video.linkedCreators + '</div></div></li>');
                            })
                        });
                        highlightSearchWord();
                    },
                    error: error => {
                        console.error(error);
                    }
                });
            }
        }
    }

    function toggleEntriesForCharacter(character, entity) {
        const maxEntries = 4;
        let hiddenEntries;

        if (character === '*') {
            $('div.alphabet-list[data-entity="' + entity + '"]').show();
            $('div.alphabet-list[data-entity="' + entity + '"] > ul > li').slice(maxEntries).hide();
            hiddenEntries = $('div.alphabet-list[data-entity="' + entity + '"] > ul > li:hidden');
        } else {
            $('div.alphabet-list[data-entity="' + entity + '"]').hide();
            $('div.alphabet-list[data-entity="' + entity + '"][data-character="' + character + '"]').show();
            const listEntries = $('div.alphabet-list[data-entity="' + entity + '"][data-character="' + character + '"] > ul > li');
            listEntries.slice(0, maxEntries).show();
            listEntries.slice(maxEntries).hide();
            hiddenEntries = $('div.alphabet-list[data-entity="' + entity + '"][data-character="' + character + '"] > ul > li:hidden');
        }

        $('a.load-more-link[data-entity="' + entity + '"]').hide();
        if (hiddenEntries.length > maxEntries) {
            $('.load-more-link[data-entity="' + entity + '"][data-character="' + character + '"]').show();
        }
    }

    function expandEntries(character, entity) {
        let hiddenEntries = $('div.alphabet-list[data-entity="' + entity + '"] > ul > li:hidden');
        if (character === '*') {
            if (hiddenEntries.length <= 50) {
                hiddenEntries.show();
                $('.load-more-link[data-entity="' + entity + '"]').hide();
            } else {
                for (let i=0; i<50; i++) {
                    hiddenEntries.eq(i).show();
                }
            }
        } else {
            hiddenEntries = $('div.alphabet-list[data-entity="' + entity + '"][data-character="' + character + '"] > ul > li:hidden');
            if (hiddenEntries.length <= 50) {
                hiddenEntries.show();
                $('.load-more-link[data-character="' + character + '"][data-entity="' + entity + '"]').hide();
            } else {
                for (let i=0; i<50; i++) {
                    hiddenEntries.eq(i).show();
                }
            }
        }
    }
</script>
