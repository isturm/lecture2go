<%@include file="init.jsp"%>

<jsp:useBean id="reqLectureseries" type="de.uhh.l2g.plugins.model.Lectureseries" scope="request" />
<jsp:useBean id="reqLicenseList" type="java.util.List<de.uhh.l2g.plugins.model.License>" scope="request" />
<jsp:useBean id="reqLicense" type="de.uhh.l2g.plugins.model.License" scope="request" />
<jsp:useBean id="reqProducer" type="de.uhh.l2g.plugins.model.Producer" scope="request" />
<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />
<jsp:useBean id="reqMetadata" type="de.uhh.l2g.plugins.model.Metadata" scope="request" />
<jsp:useBean id="reqSubInstitutions" type="java.util.List<de.uhh.l2g.plugins.model.Video_Institution>" scope="request" />
<jsp:useBean id="reqHost" type="de.uhh.l2g.plugins.model.Host" scope="request" />
<jsp:useBean id="languages" type="java.lang.String"  scope="request" />

<jsp:useBean id="permissionAdmin" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionProducer" type="java.lang.Boolean" scope="request" />
<jsp:useBean id="permissionCoordinator" type="java.lang.Boolean" scope="request" />

<jsp:useBean id="remoteUser" type="com.liferay.portal.kernel.model.User" scope="request" />
<jsp:useBean id="allCreatorsJSON" type="com.liferay.portal.kernel.json.JSONArray" scope="request" />
<jsp:useBean id="terms" type="java.util.List<de.uhh.l2g.plugins.model.Term>" scope="request" />
<jsp:useBean id="categories" type="java.util.List<de.uhh.l2g.plugins.model.Category>"  scope="request" />
<jsp:useBean id="uploadRepository" type="java.lang.String"  scope="request" />
<jsp:useBean id="backURL" type="java.lang.String"  scope="request" />
<jsp:useBean id="assignedCreators" type="com.liferay.portal.json.JSONArrayImpl"  scope="request" />

<liferay-portlet:resourceURL id="updateVideoFileName" var="updateVideoFileNameURL" />
<liferay-portlet:resourceURL id="handleVttUpload" var="handleVttUploadURL" />
<liferay-portlet:resourceURL id="videoFileNameExists" var="videoFileNameExistsURL" />
<liferay-portlet:resourceURL id="deleteFile" var="deleteFileURL" />
<liferay-portlet:resourceURL id="isFirstUpload" var="isFirstUploadURL" />
<liferay-portlet:resourceURL id="updateCreators" var="updateCreatorsURL" />
<liferay-portlet:resourceURL id="getJSONCreator" var="getJSONCreatorURL" />
<liferay-portlet:resourceURL id="videoUpdateGenerationDate" var="videoUpdateGenerationDateURL" />
<liferay-portlet:resourceURL id="getGenerationDate" var="getGenerationDateURL" />
<liferay-portlet:resourceURL id="videoUpdateFirstTitle" var="videoUpdateFirstTitleURL" />
<liferay-portlet:resourceURL id="getFileName" var="getFileNameURL" />
<liferay-portlet:resourceURL id="getShare" var="getShareURL" />
<liferay-portlet:resourceURL id="updateThumbnail" var="updateThumbnailURL" />
<liferay-portlet:resourceURL id="getJSONVideo" var="getJSONVideoURL" />
<liferay-portlet:resourceURL id="updateHtaccess" var="updateHtaccessURL" />
<liferay-portlet:resourceURL id="defaultContainer" var="defaultContainerURL" />
<liferay-portlet:resourceURL id="updateAll" var="updateAllURL" />
<liferay-portlet:resourceURL id="firstStepUpload" var="firstStepUploadURL" />
<liferay-portlet:resourceURL id="secondStepUpload" var="secondStepUploadURL" />
<liferay-portlet:resourceURL id="getJSONUploadedVideos" var="getJSONUploadedVideosURL" />

<c:set var="uploadProgressId" value="<%=PwdGenerator.getPassword(PwdGenerator.KEY3, 4)%>"/>
<c:if test="${reqVideo.openAccess==1}">
	<c:set var="vurl" value="${reqVideo.url}"/>
</c:if>
<c:if test="${reqVideo.openAccess==0}">
	<c:set var="vurl" value="${reqVideo.secureUrl}"/>
</c:if>
<c:set var="jsonReqVideo" value="<%=VideoLocalServiceUtil.getJSONVideo(reqVideo.getVideoId()).toJSONString()%>"/>

<script id="htmlTitle" type="text/x-tmpl">
	${reqVideo.title}
</script>

<aui:input name="ajresult" id="ajresult" type="hidden"></aui:input>

<div class="noresponsive">
	<div id="upload">
		<aui:container>
			<aui:row>
				<aui:col>
						<label class="edit-video-lable"><liferay-ui:message key="upload"/></label>
						<div id="date-time-form">
							<aui:fieldset column="true">
									<div id="first-title">
										<aui:input id="firsttitle" name="firsttitle" label="first-title" value="${reqVideo.title}" />
										<aui:button-row>
											<aui:button id="apply-first-title" name="apply-first-title" value="apply-first-title" onClick="applyFirstTitle();"/>
										</aui:button-row>
									</div>
									<div id="date-time">
										<aui:input id="datetimepicker" name="datetimepicker" label="select-date-time-bevor-upload"/>
										<aui:button-row>
											<aui:button id="apply-date-time" name="apply-date-time" value="apply-date-time" onClick="applyDateTime();"/>
										</aui:button-row>
									</div>
							</aui:fieldset>
						</div>
						<div id="upload-form">
							<aui:fieldset column="true">
									<div>
										<input id="fileupload" type="file" name="files[]" data-url="/servlet-file-upload/upload" multiple/>
										<input type="hidden" id="l2gDateTime" value=""/>
										<br/>
										<div id="progress" class="progress" style="width:0%;">
									    	<div class="bar" style="width:0%;"></div>
											<div id="percent" style="float:right;"></div>
										</div>
										<div id="uploaded-files"></div>
										<div id="new-files"></div>
									</div>
							</aui:fieldset>
						</div>
				</aui:col>
			</aui:row>
		</aui:container>
	</div>
	<div class="viewedit">
			<aui:form action="" commandName="model" name="metadata" id="metadata">
					<aui:container>
					        <aui:row>
					                <aui:col>
											<label class="edit-video-lable" id="edit-video-lable-1">
												<i id="l1" class="aui icon-chevron-down thumb"></i>
												<liferay-ui:message key="metadata"/>
											</label>
											<div id="metadata-upload">
												<aui:input id="stayhere" name="stayhere" label="" required="true" value="" type="hidden"/>
												
												<div id="titledefault"><aui:input id="title" name="title" label="title" required="true" value="${reqVideo.title}" /></div>
												
												<div id="creators-custom">
													<aui:input id="creator" name="creator" label="creators-required" helpMessage="creator-explanation"/>
													<div id="creators"></div>
												</div>		
														
												<aui:select size="1" name="lectureseriesId" label="lecture-series" helpMessage="video-with-or-without-lectureseries" onChange="toggleLectureseries()">
													<aui:option value="0">-<liferay-ui:message key="without-lecture-series"/>-</aui:option>
													<c:forEach items="${lectureseriesAsTreeList}" var="item">
														<aui:option value='0' disabled="true">&#9472; ${item.key.termName} &#9472;</aui:option>
														<c:forEach items="${item.value}" var="lect">
															<c:set var="selected" value="false"/>
															<c:if test="${lect.lectureseriesId==reqVideo.lectureseriesId}">
																<c:set var="selected" value="true"/>
															</c:if>
															<aui:option value='${lect.lectureseriesId}' selected="${selected}">${lect.name}</aui:option>
														</c:forEach>
													</c:forEach>
												</aui:select>
												
												<div id="options">
													<aui:select id="subInstitutionId" size="1" name="subInstitutionId" label="sub-institution">
														<aui:option value="" selected="true"><liferay-ui:message key="select-sub-institution"/></aui:option>
														<c:forEach items="${reqSubInstitutions}" var="item">
															<aui:option value='${item.institutionId}'>${item.institutionId}</aui:option>
														</c:forEach>
													</aui:select>
													
													<div class="subInstitutions" >
														<c:forEach items="${reqSubInstitutions}" var="item">
																<div id='${item.institutionId}'> 
																	${item.institutionId} &nbsp;&nbsp;&nbsp; 
																	<a class="icon-large icon-remove" style='cursor:pointer;' onClick='document.getElementById("${item.institutionId}").remove();'></a>
																	<aui:input type="hidden" name="institutions" id="institutions" value="${item.institutionId}"/>
																</div>
														</c:forEach>							
													</div>	
																
													<aui:select size="1" id="termId" name="termId" label="term" required="true">
														<c:forEach items="${terms}" var="item">
															<aui:option value='${item.termId}'>${item.prefix} &nbsp; ${item.year}</aui:option>
														</c:forEach>						
													</aui:select>
									
													<aui:select size="1" id="categoryId" name="categoryId" label="category" required="true">
														<c:forEach items="${categories}" var="item">
															<aui:option value='${item.categoryId}'>${item.name}</aui:option>
														</c:forEach>	
													</aui:select>
												</div>
									
												<aui:select size="1" name="language" label="language" required="true">
													<c:forEach items="${languages}" var="item">
														<aui:option value='${item}'>${item}</aui:option>
													</c:forEach>					
												</aui:select>
												
												<div id="l2gdate"></div>
									
												<aui:input name="tags" label="tags" required="false" value="${reqVideo.tags}"/>
									
												<aui:input name="publisher" label="publisher" required="false" value="${reqMetadata.publisher}"/>
												
												<aui:field-wrapper label="description" name="description">
												    <liferay-ui:input-editor  name="longDesc" toolbarSet="simple" initMethod="initEditor" onChangeMethod="setDescriptionData" cssClass="ta"/>
												    <script type="text/javascript">
												        function <portlet:namespace />initEditor() { return "<%= UnicodeFormatter.toString(reqMetadata.getDescription()) %>"; }
												    </script>
												</aui:field-wrapper>
											</div>
											<script>
												$( "#edit-video-lable-1" ).click(function() {
												  $( "#metadata-upload" ).slideToggle( "slow" );
												  $("#l1", this).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
											
											<div id="permissions">
												<label class="edit-video-lable" id="edit-video-lable-2">
													<i id="l2" class="aui icon-chevron-down thumb"></i>
													<liferay-ui:message key="permissions"/>
												</label>
												<div id="permissions-content">
													<c:if test="${reqVideo.getOpenAccess()==0}">
														<div>
															<aui:input id="password" name="password" label="password" required="false" value="${reqVideo.password}" />
														</div>
													</c:if>
													<c:if test="${reqVideo.getOpenAccess()==1}">
														<aui:input name="password" id="password" type="hidden" value="${reqVideo.password}"/>
													</c:if>
													<div id="c2g">
														<c:if test="${reqVideo.citation2go==0}">
													  		<aui:input name="citationAllowedCheckbox" type="checkbox" label="citation-allowed" id="citationAllowedCheckbox"></aui:input>
														</c:if>
														<c:if test="${reqVideo.citation2go==1}">
														  	<aui:input name="citationAllowedCheckbox" type="checkbox" label="citation-allowed" id="citationAllowedCheckbox" checked="true"></aui:input>
														</c:if>
													</div>
												</div>
											</div>
											<script>
												$( "#edit-video-lable-2" ).click( function() {
												  	$( "#permissions-content" ).slideToggle( "slow" );
												  	$("#l2", this).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
											
											<div id="license">
												<label class="edit-video-lable" id="edit-video-lable-3">
													<i id="l3" class="aui icon-chevron-down thumb"></i>
													<liferay-ui:message key="license"/>
												</label>
												
												<div id="license-content">
													<c:forEach items="${reqLicenseList}" var="license">
														<c:choose>
															<c:when test="${license.selectable}" >
															<div>
																<aui:input name="license" label="" value="${license.licenseId}" checked="${license.licenseId == reqLicense.licenseId ? 'true' : 'false'}" type="radio"/>
																<a href="${license.url}" title="${license.fullName}" target="_blank">${license.shortIdentifier} </a>	 	      
															</div>
															</c:when>
														    <c:otherwise>
														    	<!-- previously chosen but not selectable any more -->
														    	<c:if test="${license.licenseId == reqLicense.licenseId}">
														    		<div>
														    			<aui:input name="license" label="" value="${license.licenseId}" checked="true" type="radio" disabled="true"/>
																		<a href="${license.url}" class="disabled" title="${license.fullName}" target="_blank">${license.shortIdentifier} </a>	
														    		</div>
														    	</c:if>
															</c:otherwise>
														</c:choose>	
													</c:forEach>
												</div>
											</div>
											
											<script>
												$( "#edit-video-lable-3" ).click( function() {
												  	$( "#license-content" ).slideToggle( "slow" );
												  	$( "#l3", this ).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
							
											<div id="embed">
												<label class="edit-video-lable" id="edit-video-lable-4">
													<i id="l4" class="aui icon-chevron-down"></i>
													<liferay-ui:message key="share"/>
												</label>
												<div id="embed-content">
													<!-- embed start -->
													<aui:input name="embed_code3" label="video-url" helpMessage="about-video-url" required="false" id="embed_code3" readonly="true" value="${vurl}" onclick="selectEmbed()"/>
													<aui:input name="embed_code" label="embed-iframe" helpMessage="about-iframe-embed" required="false" id="embed_code" readonly="true" value="${reqVideo.embedIframe}" onclick="selectEmbed()"/>
													<c:if test="${reqVideo.downloadLink==1}">
														<aui:input name="embed_code1" label="embed-html5" helpMessage="about-html5-embed" required="false" id="embed_code1" readonly="true" value="${reqVideo.embedHtml5}" onclick="selectEmbed()"/>							
													</c:if>
													<aui:input name="embed_code4" label="embed-commsy" helpMessage="about-commsy-embed" required="false" id="embed_code4" readonly="true" value="${reqVideo.embedCommsy}" onclick="selectEmbed()"/>
													<!-- embed end -->	      	      
												</div>
											</div>
											<script>
												$( "#edit-video-lable-4" ).click( function() {
												  	$( "#embed-content" ).slideToggle( "slow" );
												  	$( "#l4", this).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
							
											<div id="video-thumbnail">
												<label class="edit-video-lable" id="edit-video-lable-5">
													<i id="l5" class="aui icon-chevron-right"></i>
													<liferay-ui:message key="video-thumbnail" />
												</label> 
												
												<div id="thumbnail-content">
													<!-- thumbnail start --> 
														<liferay-ui:message key="video-thumbnail-about"/>
														<div id="player1"></div>
													<!-- thumbnail end -->	      	      
												</div>
											</div>
											<script>
												$(function(){ $( "#thumbnail-content" ).hide(); });
												$( "#edit-video-lable-5" ).click( function() {
												  	$( "#thumbnail-content" ).slideToggle( "slow" );
												  	$( "#l5", this).toggleClass("icon-chevron-down icon-chevron-right");
												});
											</script>
									</aui:col>
									<aui:col>
										<aui:button type="submit" value="apply-changes" onclick="updateAll()" cssClass="btn-primary"/>	
										<aui:button type="cancel" value="cancel" href="${backURL}" id="cancel"/>
										<aui:input name="videoId" type="hidden" value="${reqVideo.videoId}"/>
										<aui:input name="fileName" type="hidden" value="${reqVideo.filename}"/>
										<aui:input name="secureFileName" type="hidden" value="${reqVideo.secureFilename}"/>
									</aui:col>
					        </aui:row>
					</aui:container>		
			</aui:form>								
	</div>
</div>

<script>
	var nameSpace = "<portlet:namespace></portlet:namespace>";
	var videoId ="${reqVideo.videoId}";
	var $options = $( "#options" );
	var getGenerationDateURL = "${getGenerationDateURL}";
	var getShareURL = "${getShareURL}";
	var getFileNameURL = "${getFileNameURL}";
	var updateHtaccessURL = "${updateHtaccessURL}";
	var assignedCreators = ${assignedCreators};
	var uploadRepository = "${uploadRepository}";
	var videoFileNameExistsURL = "${videoFileNameExistsURL}";
	var c = 0;
	var vidtitle = $('#htmlTitle').text();
	var videoOpenAccess = "${reqVideo.openAccess}";
	var lectureSeriesNumber = "${reqLectureseries.number}";
	var getShareURL = "${getShareURL}";
	var allCreatorsInJQueryAutocompleteFormat = ${allCreatorsJSON.toString()};
	var getJSONCreatorURL = "${getJSONCreatorURL}";	
	var videoUpdateGenerationDateURL = "${videoUpdateGenerationDateURL}";	
	var videoUpdateFirstTitleURL = "${videoUpdateFirstTitleURL}";	
	var $nameSpaceFirstTitle = "<portlet:namespace/>firsttitle";	
	
    //load upload function 
	lecture2goFileUpload();
	
	$(function () {
		var videoFilename = "${reqVideo.filename}";
		var videoGenerationDate = "${reqVideo.generationDate}";
		//
		
		if(videoFilename.length==0 && videoGenerationDate.length==0){
			$("#date-time-form").show();
		    $("#upload-form").hide();
		    $("#l2gdate").hide();
		    $("#<portlet:namespace/>metadata").hide();
			//
		    if(vidtitle.trim()>""){
			   	$("#first-title").hide();
			   	$("#date-time").show();
			}else{
				$("#date-time").hide();
		  	}
		}else{
			$("#date-time-form").hide();
			$("#upload-form").show(); 	
			$("#<portlet:namespace/>metadata").show();
			if(videoFilename.length > 0){
				//load player
				initializePlayer();
				//load uploaded files
				loadUploadedFiles();
			}
			if(videoGenerationDate.length > 0){
				$("#<portlet:namespace/>lecture2go-date").val(videoGenerationDate);
			}
			//load the date and time to another div
			loadDateTimepickerToTheMetadataSkeleton();
		}
		  
		//load date time picker
		$('#<portlet:namespace/>datetimepicker').datetimepicker({
		   	format:'Y-m-d_H-i',
		   	dayOfWeekStart : 1,
		   	lang:'en',
		   	startDate:	new Date(),
		   	value: videoGenerationDate,
		   	maxDate: '+1970/01/30',
		   	minDate: false,
		   	step:15
		});
		    
		//load creators
		autocompleteCreator($("#<portlet:namespace/>creator"), validate);
	    if(assignedCreators) {
			$("#creators").loadTemplate("#created", assignedCreators, {error: function(e) { console.log(e); }});
	    }
		    		
		function remb(c){
			//TODO remove sub ids
			$("#"+c).remove();
		}	
	});
	
	//AJAX
	var checkFirstUpload = $.ajax({
		url: "${isFirstUploadURL}",
		method: "POST",
		dataType: 'json',
	});
	
	var getDBFilename = $.ajax({
		url: "${getFileNameURL}",
		method: "POST",
		dataType: 'json',
	});
	
	var getShare = $.ajax({
		url: "${getShareURL}",
		method: "POST",
		dataType: 'json',
	});
	
	var getDateTime = $.ajax({
		url: "${getGenerationDateURL}",
		method: "POST",
		dataType: 'json',
	});
	
	function loadDateTimepickerToTheMetadataSkeleton(){
		 $('#date-time').appendTo('#l2gdate');
	     $('#date-time .button-holder').hide();//hide button because not used!
		 //change the lable
		 $('#date-time .control-label').text("<liferay-ui:message key='lecture2go-date'/>"); 	
	}

	function loadDateTimepickerToFirstTitle(){
		 $('#date-time').appendTo('#date-time-form');
		 $('#date-time').show();
	     $('#date-time .button-holder').show();//hide button because not used!
		 //change the lable
		 $('#date-time .control-label').text("<liferay-ui:message key='select-date-time-bevor-upload'/>"); 	
	}

	function applyDateTime(){
		var genDate = $('#'+nameSpace+'datetimepicker').val();
		$.ajax({
			url: "${videoUpdateGenerationDateURL}",
			method: "POST",
			dataType: 'json',
			data: {
				"<portlet:namespace/>generationDate": genDate
			},
			success: function(res) {
	  			$('#date-time-form').hide();
				$("#upload-form").fadeIn(500); 	
				loadDateTimepickerToTheMetadataSkeleton();
				$("#l2gdate").fadeIn(1000);
				$("#<portlet:namespace/>metadata").show(); 
				//
				getDateTime.done(function( res ) {
	     		    $("#tm").text(res.generationDate);
				});
			}
		});
	}
	
	function toggleShare(){
		getDBFilename.done(function( res ) {
		    var mediaFilename = res.fileName;
		    getShare.done(function( res ) {
			    var data = res;
				if(mediaFilename.length>0){
					 $("#embed").show();
					 $("#<portlet:namespace/>embed_code").val(data.iframeEmbed);//iframe
					 $("#<portlet:namespace/>embed_code1").val(data.html5Embed);//html5
					 $("#<portlet:namespace/>embed_code3").val(data.url);//url
					 $("#<portlet:namespace/>embed_code4").val(data.commsyEmbed);//commsy
				}else{
					 $("#embed").hide();
				}
			});
		});
	}
	
	function loadUploadedFiles(){
		$.ajax({
			url: "${getJSONUploadedVideosURL}",
			method: "POST",
			dataType: 'json',
			data:{"<portlet:namespace/>videoId" : videoId},
			success: function(vars) {
				$("#uploaded-files").loadTemplate("#remove-video-file", vars, {error: function(e) { console.log(e); }});  
			}
		});
	}
	
	function applyFirstTitle(){
		var title = $("#<portlet:namespace/>firsttitle").val(); 
		//
		$.ajax({
			url: "${videoUpdateFirstTitleURL}",
			method: "POST",
			dataType: "json",
			data: {
				"<portlet:namespace/>firsttitle" : title 
			},
			success: function(res) {
				if(!res.firsttitle){
					alert('<liferay-ui:message key="please-enter-a-title"/>');
				}else{
					$('#first-title').hide();
					loadDateTimepickerToFirstTitle();
					$("#<portlet:namespace/>title").val(res.firsttitle);
				} 
			}
		});
	}
	
	function toggleLectureseries(){
		var selector = "#<portlet:namespace/>lectureseriesId option:selected";
		var $lId = $( selector ).val();
		//
		if($lId==0){
			$options.fadeIn( 500 ); 	
		}else{
			$options.hide();
		}
	}
	
	function fileUploadAllowed(data){
		var ret = false;
	    var acceptFileTypes = /(mp4|m4v|m4a|audio\/mp3|audio\/mpeg|audio|pdf)$/i;//allowed file types
	    data.forEach(function(entry) {
	    	if(acceptFileTypes.test(entry['type'])){
	        	ret = true;
	        }
	    });
	    return ret;
	}

	function selectEmbed(){
		$("input[type='text']").on("click", function () {
			   $(this).select();
		});		
	}
	
	function handleVttUpload (){
		var ret = 0;
		$.ajax({
			  type: "POST",
			  url: "${handleVttUploadURL}",
			  dataType: 'json',
			  data: {
				  <portlet:namespace/>videoId: "<%=reqVideo.getVideoId()%>"
			  },
			  global: false,
			  async: false,
			  success: function(data) {
			    ret = 1;
			  }
		});
		return ret;
	}

	function updateVideoFileName(file){
		$.ajax({
			url: "${updateVideoFileNameURL}",
			method: "POST",
			dataType: "json",
			data: {
		 		"<portlet:namespace/>videoId": videoId,
	  			"<portlet:namespace/>fileName": file.fileName, 
	  			"<portlet:namespace/>secureFileName": file.secureFileName, 
	  			"<portlet:namespace/>generationDate": file.generationDate 
	 		},
			success: function(res) {
           	 	toggleShare();
			}
		});
	}	

	function updateAll(){
		var license = $("input[name=<portlet:namespace/>license]:checked").val();
		var creatorsJsonArray = JSON.stringify(getJsonCreatorsArray());
		var jsonSubInstitutionsArray = JSON.stringify(getJsonSubInstitutionsArray());
    	var termId=0;
		var categoryId=0;
		var chebox;
		//
		$('#<portlet:namespace/>citationAllowedCheckbox').prop("checked") ? chebox=1 : chebox=0;
		
		if (!$("#options").is(':hidden')) {
			   termId = $('#<portlet:namespace/>termId').val();
			   categoryId = $('#<portlet:namespace/>categoryId').val();
		}
		//action
		$.ajax({
			url: "${updateAllURL}",
			method: "POST",
			dataType: "json",
			data: {
	            	"<portlet:namespace/>videoId": videoId,
	            	"<portlet:namespace/>description": descData,
	            	"<portlet:namespace/>license": license,
	            	"<portlet:namespace/>creatorsJsonArray": creatorsJsonArray, 
	            	"<portlet:namespace/>subInstitutions": jsonSubInstitutionsArray,
	            	//metadata start
			 	   	"<portlet:namespace/>lectureseriesId": $('#<portlet:namespace/>lectureseriesId').val(),
			 	   	"<portlet:namespace/>language": $('#<portlet:namespace/>language').val(),
			 	   	"<portlet:namespace/>title": $('#<portlet:namespace/>title').val(),
			 	   	"<portlet:namespace/>tags": $('#<portlet:namespace/>tags').val(),
			 	   	"<portlet:namespace/>publisher": $('#<portlet:namespace/>publisher').val(),
			 	   	"<portlet:namespace/>datetimepicker": $('#<portlet:namespace/>datetimepicker').val(),
			 	   	"<portlet:namespace/>citationAllowedCheckbox": chebox,
			 	   	"<portlet:namespace/>categoryId": categoryId,
			 	   	"<portlet:namespace/>termId": termId,
			 	   	"<portlet:namespace/>password": $('#<portlet:namespace/>password').val()
			 	   	//metadata end
	 		},
			success: function(res) {
	           	 //update the thumb nail
	           	 updateThumbnail();
	           	 //json object
	           	 if(res.errorsCount==0){
	           		 alert("<liferay-ui:message key='changes-applied'/>");	                		 
	           	 }else{
	           		 alert("<liferay-ui:message key='changes-applied-with-warnings'/>");
	           	 }
			}
		});
	} 
	
	var descData=$('#htmlTemplate').text();
	function <portlet:namespace/>setDescriptionData(data){
		descData = data;
	}
	
	function validate(){
		AUI().use(
				'aui-node',
				function(A) {
					var selector = "#"+nameSpace+"cancel";
					if($("#creators > div").length==0){
					    //update creator class
					    $("#creators-custom").css({"background-color": "#b50303", "color": "white"});
					    $("#creators-custom .control-label").css({"color": "white"});
						$('html, body').animate({
			                   scrollTop: $("#creators-custom").offset().top
			               }, 1000);
				        if($(selector).is(":visible")){
				        	$(selector).hide();	
				        }	
						//alert("<liferay-ui:message key='please-add-creators'/>");
					}else{
						$(selector).show();
					}
				}
		);
	}

	function deleteFile(fileName){
		if(confirm('<liferay-ui:message key="really-delete-question"/>')){
			$.ajax({
				url: "${deleteFileURL}",
				method: "POST",
				dataType: "json",
				data: {
			 	   	"<portlet:namespace/>videoId": videoId,
			 	   	"<portlet:namespace/>fileName": fileName
			    },
				success: function(res) {
    		         //since we are using jQuery, you don't need to parse response
    		         for (var i = 0; i < res.length; i++) {
    		             var obj = res[i];
    			         var id = "#"+obj.fileId;
    			         $(id).remove();
    		         }
    		         //
    		         //update view
    		         checkFirstUpload.done(function( res ) {
    		        	 var isFirstUpload=res.firstUpload;
	     		         if (isFirstUpload==1){
	     		      	   	 $('#date-time-form').fadeIn( 500 );
	     		    	  	 $("#upload-form").hide(); 
	     		    	  	 $("#date-time").hide();
	     		    	  	 $("#first-title").show();
	     		    	  	 $("#<portlet:namespace/>metadata").hide();
	     		         }
    		         });
    		         
    		         //player.remove();
    		         //initialize and show player
    			     initializePlayer();
    		         //hide date fild
    		         $("#l2gdate").hide();
    		         //toggle share
    		         toggleShare();	 
		        }
			});
		}
	}

	function lecture2goFileUpload(){
		//file upload 
	    $('#fileupload').fileupload({
	            dataType: 'json',
	            add: function(e, data) {
	                var uploadErrors = [];
	    			var acceptFileTypes = /(mp4|mp3|pdf)$/i;//file types
	    			//
	    			for(i=0;i<data.originalFiles.length; i++){
	    				var file = data.originalFiles[i]['name'];
	    				var extension = file.substr( (file.lastIndexOf('.') +1) );
	    	            if (!acceptFileTypes.test(extension)) {
	    	                uploadErrors.push('<liferay-ui:message key="not-an-accepted-file-type"/>');
	    	            }
	    	            // if ( data.originalFiles[i]['size'] > 5368709120) { //5 GB
	    	            //     uploadErrors.push('<liferay-ui:message key="max-file-size"/>');
	    	            // }
	    			}
	              	//check for first upload
	              	checkFirstUpload.done(function( dat ) {
		     		    var isFirstUpload=dat.firstUpload;
		     	        if (isFirstUpload==1) {
			    	        if (!fileUploadAllowed(data.originalFiles)){
			    	        	uploadErrors.push('<liferay-ui:message key="first-upload-requirements"/>');   
			    	        } else {
			    	        	//check file name exists in the database
			    	        	$.ajax({
			    	        		url: videoFileNameExistsURL,
			    	        		method: 'post',
			    	                dataType: 'json',
			    	          		data: {
			    	          			"<portlet:namespace/>fileName": data.originalFiles[0]['name']
			    	        		}, 
			    	        		success: function(res) {
			    	        			var fileNameExistsInTheDataBase=res.exist; 
			    	        			if(fileNameExistsInTheDataBase==1) uploadErrors.push('<liferay-ui:message key="file-exists-in-database"/>');
			    	        		}
			    	        	});
			    	        }
		    	        }
		     		});
	              	//
	                if (uploadErrors.length > 0) {
	                    alert(uploadErrors.join("\n"));
	                } else {
	                    data.submit();
	                }
	            },
	            done: function (e, data) {
	               var vars = data.jqXHR.responseJSON;
	               checkFirstUpload.done(function( data ) {
		     		   var isFirstUpload=data.firstUpload;
		               if(isFirstUpload==1){//update
		            	   	var f1 = "mp4";
		               		var f2 = "mp3";
		               		var f3 = vars[0].fileName;
		               		//mp4 file
		               		if(f3.indexOf(f1) > -1){
		    	           		updateVideoFileName(vars[0]);
		    	           		validate();
		               		}
		               		//mp3 file, do not trigger the post processing
		               		if(f3.indexOf(f2) > -1){
		    	           		updateVideoFileName(vars[0]);
		    	           		validate();
		               		}
		               }else{ 
		    				//update only for mp3 and mp4, but without changing the container
		    				$.ajax({
									url: "${defaultContainerURL}",
									method: "POST",
									dataType: "json",
									data: {
								 		"<portlet:namespace/>videoId": videoId
							 		},
							 		success: function(res) {
					    				var f1 = vars[0].fileName;
					    				var f2 = res.containerFormat;
					    				var f3 = "mp4";
					    				//for mp3 and mp4 files
					    				if(f1.indexOf(f2) > -1 || f1.indexOf(f3) > -1){
					    	           		updateVideoFileName(vars[0]);
					    	           		validate();
					    				}					    		         
							        }							 		
							});	
							//
		               }
		     	   });
	               
	               // handle subtitle file if existing
	               handleVttUpload();
	      
	               //htaccess update function for physical file protectiom
	               updateHtaccess();
	           	   var st = false;
	               
	           	   //
	           	   //jwplayer().remove();
	               //initialize and show player
	               setTimeout(
	    	           function(){
	    	        	   initializePlayer();
	    	        	   jwplayer().seek(0);
	    	        	   jwplayer().on('play',function(){
	    	            		  if(st==false){
	    	            			  jwplayer().pause();
	    	            			   st=true;
	    	            		  }
	    	     		   });	        	   
	    	           }, 2000
	               );
	               
			       //hide progress bar
			       $('#percent').text("0%");
	   		       $('#progress').css("width", "0%"); 
	   		        
	   		       //load uploaded files
	   		       loadUploadedFiles();
	            },
	            progressall: function (e, data) {
	    	        var progress = parseInt(data.loaded / data.total * 100, 10);
	    	        if (progress==100){
	    		        $('#percent').text("100%");
	    		        $('#progress').css("width", "100%"); 
	    	        }else{
	    		        var selector = "#"+nameSpace+"cancel";
	    		        var o = progress+ "%";
	    		        $('#percent').text(o);
	    		        $('#progress').css("width", progress + "%");
	    		        if($(selector).is(":visible")){
	    		        	$(selector).hide();	
	    		        }
	    	        }
	       		},
	    		dropZone: $('#dropzone')
	        }).bind('fileuploadsubmit', function (e, data) {
	            	// The example input, doesn't have to be part of the upload form:
	            	var selectorDate = "#"+nameSpace+"datetimepicker";
	            	var selectorFileName = "#"+nameSpace+"fileName";
	            	var selectorSecureFileName = "#"+nameSpace+"secureFileName";
	            	//
	            	data.formData = {
	            	    repository: uploadRepository,
	            		openaccess: videoOpenAccess,
	            		lectureseriesNumber: lectureSeriesNumber,
	            		fileName: $(selectorFileName).val(),
	            		secureFileName: $(selectorSecureFileName).val(),
	            		l2gDateTime: $(selectorDate).val(),
	            		videoId: videoId
	            };        
	        });	    
	}

	function updateHtaccess (){
		$.ajax({
			  type: "POST",
			  url: updateHtaccessURL,
			  dataType: 'json',
			  data: {
				  "<portlet:namespace/>videoId": videoId
			  }
		});
	}

	function getJsonSubInstitutionsArray(){
		var namespace="<portlet:namespace/>";
		var jsonArray = [];
		$('.subInstitutions').children().each(function(n){
			var parameters = {};
			var $div = $(this);
			var id = $div.attr('id');
			parameters['institutionId'] = id;
			jsonArray[n]=parameters;
		});
		return jsonArray;
	}

	function updateThumbnail(){
		$.ajax({
			url: "${updateThumbnailURL}",
			method: "POST",
			dataType: "json",
			data: {
	 	   		"<portlet:namespace/>videoId": videoId,
	 	   		"<portlet:namespace/>inputTime": Math.floor(jwplayer().getPosition())
	  		}
		});
	}

	function remb(c){
		$("#"+nameSpace+c).remove();
	}

	//load subinstitution 
	AUI().use('aui-node',
			  function(A){
				// Select the node(s) using a css selector string
			    var subInstitutionId = A.one('#<portlet:namespace/>subInstitutionId');
			    var subInstitutions = A.one('.subInstitutions');
			    
			    subInstitutionId.on(
			          'change',
			          function(A) {
			      			if(subInstitutionId.get('value')>0){
			      	   	 		var n = subInstitutionId.get(subInstitutionId.get('selectedIndex')).get('value');
			      	    		var t = subInstitutionId.get(subInstitutionId.get('selectedIndex')).get('text')+"&nbsp;&nbsp;&nbsp;";
			      	    		subInstitutions.append("<div id='"+n+"'> "+t+" <a class='icon-large icon-remove style='cursor:pointer;' onClick='document.getElementById(&quot;"+n+"&quot;).remove();'/><input id='<portlet:namespace></portlet:namespace>institutions' name='<portlet:namespace></portlet:namespace>institutions' value='"+n+"' type='hidden'/></div>");
			      			}
			          }
			     );
			 
			  }
	);
	
	function loadPlayer(vidJ){
		jwplayer('player1').setup({
	        width: "100%",
	        aspectratio: "16:9",
	        playbackRateControls: [0.75, 1, 1.25, 1.5],
	        image: vidJ.thumbnail,
	        sources: vidJ.playerUris,
	        hlshtml: true,
	        androidhls: true
	    });
	} 

	function initializePlayer(){
		AUI().use('aui-io-request', function(A){
			A.io.request("${getJSONVideoURL}", {
		            method: 'post',
		            dataType: 'json',
		            sync: true,
			  		data: {
			  			"<portlet:namespace/>videoId": "${reqVideo.videoId}"
			  		},
		            on: {
		                 success: function() {
		                	 //json object
		                	 var data =  this.get('responseData');
		                	 loadPlayer(data);
		                 }
		            }
		     });
		});
	}
	
</script>

<!-- Template -->
<script id="htmlTemplate" type="text/html">
    ${reqMetadata.description} 
</script>

<!-- Template -->
<script type="text/html" id="newCreator">
	<div class="<portlet:namespace/>creatorId">
		<input type="hidden" id="<portlet:namespace/>creatorId" value="0"/>
		<aui:input name="jobTitle" type="text" helpMessage="job-title-help-text"/>
		<aui:input name="firstName" type="text"/>
		<aui:input name="middleName" type="text"/>
		<aui:input name="lastName" type="text"/>
		<a class="icon-large icon-remove" onclick="remb($(this).closest('.<portlet:namespace/>creatorId').remove())"></a>
	</div>
</script>

<!-- Template -->
<script type="text/html" id="created">
   	<div class="<portlet:namespace/>creatorId" data-value="creatorId">
		<input type="hidden" id="<portlet:namespace/>creatorId" data-value="creatorId"/>
		<input type="hidden" id="<portlet:namespace/>jobTitle" data-value="jobTitle"/>
		<input type="hidden" id="<portlet:namespace/>firstName" data-value="firstName"/>
		<input type="hidden" id="<portlet:namespace/>middleName" data-value="middleName"/>
		<input type="hidden" id="<portlet:namespace/>lastName" data-value="lastName"/>
		<input type="hidden" id="<portlet:namespace/>fullName" data-value="fullName"/>
    	<div data-content="fullName"/> <a class="icon-large icon-remove" onclick="remb($(this).closest('.<portlet:namespace/>creatorId').remove())"></a>
	</div>
</script>

<!-- Template -->
<script type="text/html" id="remove-video-file">
   	<div data-id="id">
    	<div data-content="name"/> <a class="icon-large icon-remove" onclick="deleteFile($(this).closest('div').text())"></a>
	</div>
</script>
