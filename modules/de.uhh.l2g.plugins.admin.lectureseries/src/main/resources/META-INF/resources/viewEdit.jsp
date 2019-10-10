<%@include file="init.jsp"%>

<jsp:useBean id="categories" type="java.util.List<de.uhh.l2g.plugins.model.Category>" scope="request" />
<jsp:useBean id="lectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="institutions" type="java.util.LinkedHashMap" scope="request" />
<jsp:useBean id="institutionId" type="java.lang.Long" scope="request" />
<jsp:useBean id="backURL" type="java.lang.String" scope="request" />
<jsp:useBean id="terms" type="java.util.List<de.uhh.l2g.plugins.model.Term>" scope="request" />
<jsp:useBean id="term" type="de.uhh.l2g.plugins.model.Term" scope="request" />
<jsp:useBean id="producerIds" type="java.util.List" scope="request" />
<jsp:useBean id="allCreators" type="com.liferay.portal.kernel.json.JSONArray" scope="request" />
<jsp:useBean id="assignedCreators" type="java.lang.String" scope="request" />

<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionProducer" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionCoordinator" type="java.lang.Boolean" scope="request" />

<c:set var="lectureseriesId" value="${lectureseries.lectureseriesId}"/>
<c:set var="readOnly" value="false"/>

<c:choose>
	  <c:when test="${(permissionProducer && lectureseries.approved==1) || permissionAdmin || permissionCoordinator }">
			<c:set var="readOnly" value="<%=false%>"/>
	  </c:when>
	  <c:otherwise>
			<c:set var="readOnly" value="<%=true%>"/>
	  </c:otherwise>
</c:choose>

<c:choose>
	  <c:when test="${lectureseries.lectureseriesId > 0}">
		<portlet:actionURL name="edit" var="actionURL">
			<portlet:param name="lectureseriesId" value='${lectureseries.lectureseriesId}' />
			<portlet:param name="backURL" value='${backURL}' />
		</portlet:actionURL>
	  </c:when>
	  
	  <c:otherwise>
		<portlet:actionURL name="add" var="actionURL">
			<portlet:param name="backURL" value='${backURL}' />
		</portlet:actionURL>
	  </c:otherwise>
</c:choose>

<liferay-portlet:resourceURL id="getJSONCreator" var="getJSONCreatorURL" />
<liferay-portlet:resourceURL id="updateCreators" var="updateCreatorsURL" />

<div class="viewedit">
	<aui:form action="${actionURL}" commandName="model">
		<aui:container>
		        <aui:row>
		                <aui:col>
								<c:choose>
									  <c:when test="${readOnly}">
											<aui:input name="number" label="lectureseries-number" required="false" helpMessage="number-help-text" value="${lectureseries.number}" readonly="${readOnly}"/>
									  </c:when>
									  <c:otherwise>
											<aui:input name="number" label="lectureseries-number" required="false" helpMessage="number-help-text" value="${lectureseries.number}"/>
									  </c:otherwise>
								</c:choose>	
								<c:choose>
									  <c:when test="${readOnly}">
											<aui:input name="name" label="lectureseries-title" required="true" value="${lectureseries.name}" readonly="${readOnly}"/>
									  </c:when>
									  <c:otherwise>
									  		<aui:input name="name" label="lectureseries-title" required="true" value="${lectureseries.name}"/>
									  </c:otherwise>
								</c:choose>	
					
								<c:choose>
									  <c:when test="${!readOnly}">
											<aui:select size="1" name="categoryId" label="category" required="true">
												<aui:option value=""><liferay-ui:message key="select-category"/></aui:option>
												<c:forEach items="${categories}" var="item">
													<aui:option value='${item.categoryId}' selected="true">${item.name}</aui:option>
												</c:forEach>
											</aui:select>
									  </c:when>
									  <c:otherwise>
											<aui:input name="cat" label="category" required="true" value="${item.name}" readonly="${readOnly}"/>
											<aui:input type="hidden" name="categoryId" value="${lectureseries.categoryId}"/>
									  </c:otherwise>
								</c:choose>	
					
								<c:choose>
									  <c:when test="${!readOnly}">
											<aui:select size="1" name="institutionId" label="institution" required="true">
												<aui:option value=""><liferay-ui:message key="select-institution"/></aui:option>
												<c:forEach items="${institutions}" var="item"> 
													<c:choose>
														  <c:when test="${item.key == institutionId}">
																<aui:option value='${item.key}' selected="true" disabled="${!fn:startsWith(item.value, '----') && (permissionCoordinator || permissionProducer || permissionAdmin)}">${item.value}</aui:option>
														  </c:when>
														  <c:otherwise>
														  		<aui:option value='${item.key}' selected="false" disabled="${!fn:startsWith(item.value, '----') && (permissionCoordinator || permissionProducer || permissionAdmin)}">${item.value}</aui:option>
														  </c:otherwise>
													</c:choose>
												</c:forEach>
											</aui:select>
											<div class="facilCont">
												<c:set var="institutionsByLectureseries" value="<%=InstitutionLocalServiceUtil.getByLectureseriesId((Long)pageContext.getAttribute("lectureseriesId"), com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS, com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS)%>"/>
												<c:forEach items="${institutionsByLectureseries}" var="item">
													<div id='${item.institutionId}'> 
														${item.name} &nbsp;&nbsp;&nbsp;
														<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("${item.institutionId}").remove(); resetInstitution();'></a>
														<aui:input type="hidden" name="institutions" id="institutions" value="${item.institutionId}"/>
													</div>							
												</c:forEach>
											</div>
									  </c:when>
									  <c:otherwise>
											<aui:input type="hidden" name="institutions" id="institutions" value="${institutionId}"/>
											<aui:input type="hidden" name="institutionId" id="institutionId" value="${institutionId}"/>
									  </c:otherwise>
								</c:choose>									
								
								<c:choose>
									  <c:when test="${!permissionProducer}">
											<aui:select size="1" name="producerId" label="producer" required="true" helpMessage="please-add-at-lest-one-producer">
												<aui:option value=""><liferay-ui:message key="select-producer"/></aui:option>
												<c:forEach items="${producers}" var="item">
													<c:choose>
														  <c:when test="${item.producerId == producerIds.get(0)}">
																<aui:option value='${item.producerId}' selected="true"> ${item.lastName},  ${item.firstName}</aui:option>
														  </c:when>
														  <c:otherwise>
														  		<aui:option value='${item.producerId}' selected="false"> ${item.lastName},  ${item.firstName}</aui:option>
														  </c:otherwise>
													</c:choose>								
												</c:forEach>							
											</aui:select>	
					
											<div class="prodCont">
												<c:forEach items="${producerIds}" var="item">
													<c:if test="${item > 0}">
														<c:set var="p" value="<%=ProducerLocalServiceUtil.getProdUcer(new Long(pageContext.getAttribute("item")+""))%>"/>
														<div id='${p.producerId}'> 
															${p.lastName}, ${p.firstName} &nbsp;&nbsp;&nbsp; 
															<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("${p.producerId}").remove(); resetProducer();'></a>
															<aui:input type="hidden" name="producers" id="producers" value="${p.producerId}"/>
														</div>								
													</c:if>
												</c:forEach>
											</div>
									  </c:when>
									  <c:otherwise>
											<aui:input type="hidden" name="producers" id="producers" value="${producerId}"/>
											<aui:input type="hidden" name="producerId" id="producerId" value="${producerId}"/>				  
									  </c:otherwise>
								</c:choose>
					
								<c:choose>
									<c:when test="${readOnly}">
										<aui:input name="term" label="term" required="true" value='${term.prefix} ${term.year}' readonly="${readOnly}"/>
										<aui:input type="hidden" name="termId" value="${term.termId}"/>
									</c:when>
									<c:otherwise>
										<aui:select id="allterms" size="1" name="termId" label="term" required="true">
											<c:forEach items="${terms}" var="item">
												<c:choose>
													  <c:when test="${term.termId==item.termId}">
															<aui:option value='${item.termId}' selected="true">${item.prefix} ${item.year}</aui:option>
													  </c:when>
													  <c:otherwise>
													  		<aui:option value='${item.termId}' selected="false">${item.prefix} ${item.year}</aui:option>
													  </c:otherwise>
												</c:choose>						
											</c:forEach>
										</aui:select>
									</c:otherwise>
								</c:choose>
								
								<aui:input name="password" label="password" helpMessage="password-help-text" value="${lectureseries.password}"/>
								
								<aui:select id="videosort" size="1" name="videoSort" label="sortvideo">
									<c:choose>
										  <c:when test="${lectureseries.videoSort==1}">
										  		<c:set var="selected" value="true"/>
										  </c:when>
										  <c:otherwise>
										  		<c:set var="selected" value="false"/>
										  </c:otherwise>
									</c:choose>			
									<aui:option value="1" selected="${selected}" label="sortvideoAsc"></aui:option>		
									<aui:option value="0" selected="${!selected}" label="sortvideoDesc"></aui:option>		
								</aui:select>
				
								<c:choose>
									  <c:when test="${!readOnly}">
											<aui:field-wrapper label="description">
											    <liferay-ui:input-editor name="longDesc" toolbarSet="simple" initMethod="initEditor" cssClass="ta"/>
											    <script type="text/javascript">
											        function <portlet:namespace />initEditor() { return "${lectureseries.longDesc}";}
											    </script>
											</aui:field-wrapper>
									  </c:when>
									  <c:otherwise>
									  		<c:if test="${fn:length(lectureseries.longDesc)>0}">
									  			<aui:input type="textarea" name="longDesc" value="${lectureseries.longDesc}" label="description" readonly="true"/>
									  		</c:if>
									  </c:otherwise>
								</c:choose>		                    
		                </aui:col>
						<aui:col>
							<c:choose>
							  <c:when test="${lectureseries.lectureseriesId > 0}">
				                     <aui:button type="submit" value="edit" id="edit" onclick="<portlet:namespace />extractCodeFromEditor()"/>
							  </c:when>
							  <c:otherwise>
				                     <aui:button type="submit" value="add" id="add" onclick="<portlet:namespace />extractCodeFromEditor()"/>
							  </c:otherwise>
							</c:choose>		
							<aui:button type="cancel" value="cancel" href="${backURL}"/>
						</aui:col>
		        </aui:row>
		</aui:container>
	</aui:form>
</div>

<script>
	var c = 0;
	/* these variables are set here but used in the external autocomplete-creator.js file, be sure to include this js AFTER the jsp is rendered*/
	var allCreatorsInJQueryAutocompleteFormat = ${allCreators};
	var getJSONCreatorURL = "${getJSONCreatorURL}";
	var namespace = "<portlet:namespace/>";
	<c:if test="${fn:length(assignedCreators)>0}">assignedCreators = ${assignedCreators} </c:if>
	
	function remb(c){
		$("#"+c).remove();
	}
	$(function () {
		autocompleteCreator($("#<portlet:namespace/>creator"));
	});
	
	$('#<portlet:namespace></portlet:namespace>cancel').click(function(){
		   window.location.href="${backURL}";
	});
	
	AUI().use('aui-node',
	  
	function(A) {
		// Select the node(s) using a css selector string
	    var contProduc = A.one('.prodCont');
	    var contFacil = A.one('.facilCont');
	    var producerId = A.one('#<portlet:namespace/>producerId');
	    var crId = A.one('#<portlet:namespace/>crId');
	    var institutionId = A.one('#<portlet:namespace/>institutionId');
	    var newSemester = A.one('#<portlet:namespace/>newSemester');
	    var allSemesters = A.one('#<portlet:namespace/>allSemesters');
	    
	    producerId.on(
	      	'change',
	      	function(A) {
	  			if(producerId.get('value')>0){
	  	   	 		var n = producerId.get(producerId.get('selectedIndex')).get('value');
	  	    		var t = producerId.get(producerId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
	  	  			contProduc.append("<div id='"+n+"'> "+t+" <a class='icon-large icon-remove' style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove(); resetProducer();'></a><input id='<portlet:namespace></portlet:namespace>producers' name='<portlet:namespace></portlet:namespace>producers' value='"+n+"' type='hidden'/></div>");
	  			}
	      	}
	    );
	
	    institutionId.on(
	      	'change',
	      	function(A) {
	  			if(institutionId.get('value')>0){
	  	   	 		var n = institutionId.get(institutionId.get('selectedIndex')).get('value');
	  	    		var t = institutionId.get(institutionId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
	  	    		contFacil.append("<div id='"+n+"'> "+t+" <a class='icon-large icon-remove' style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove(); resetInstitution();'></a><input id='<portlet:namespace></portlet:namespace>institutions' name='<portlet:namespace></portlet:namespace>institutions' value='"+n+"' type='hidden'/></div>");
	  			}
	      	}
	    );
	    
	  }
	);
	
	function updateCreatorOnServer(jsonArray) {
		//set parameter to server for update 
		$.ajax({
			  type: "POST",
			  url: "${updateCreatorsURL}",
			  dataType: 'json',
			  data: {
			 	   	<portlet:namespace/>creator: JSON.stringify(jsonArray)
			  },
			  global: false,
			  async: true,
			  success: function(data) {
			    //remove all creators 
			    $( "#creators" ).empty();
			    //and show new creators list
			    showCreatorsList(data);    
			  }
		})
	}
	
	function resetInstitution(){
		var l = $(".facilCont div").length;
	    if(l==0){
	    	$('#<portlet:namespace/>institutionId').prop('selectedIndex',0);
	    }
	}
	
	function resetProducer(){
		var l = $(".prodCont div").length;
	    if(l==0){
	    	$('#<portlet:namespace/>producerId').prop('selectedIndex',0);
	    }
	}
	
	function resetCreator(){
		var l = $(".creators div").length;
	    if(l==0){
	    	$('#<portlet:namespace/>crId').prop('selectedIndex',0);
	    }
	}
</script>

<%@include file="includeCreatorTemplates.jsp" %>