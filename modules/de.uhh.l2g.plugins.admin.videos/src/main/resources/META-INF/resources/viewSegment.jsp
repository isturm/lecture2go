<%@include file="/init.jsp"%>

<jsp:useBean id="reqVideo" type="de.uhh.l2g.plugins.model.Video" scope="request" />

<liferay-portlet:resourceURL id="addSegment" var="addSegmentURL" />
<liferay-portlet:resourceURL id="deleteSegment" var="deleteSegmentURL" />
<liferay-portlet:resourceURL id="showSegments" var="segmentsURL" />

<c:set var="backURL" value="<%=request.getAttribute("backURL").toString()%>"/>

<div class="noresponsive">
	<aui:fieldset column="true" label="${reqVideo.title}">
		<div class="player-segment">
			<%@ include file="/player/includePlayer.jsp" %>
		</div>
				
		<div id="set-segments">
			<aui:form  name="fm">
				<aui:input name="chortTitle" label="title" required="true" id="chortTitle"/>
							
				<div class="segment-time">
					<aui:input name="timeStart" label="start" required="true" id="timeStart" />
				</div>
						
				<div class="segment-time">
					<aui:input name="timeEnd" label="end" required="true" id="timeEnd" />
				</div>
							
				<aui:input name="videoId" type="hidden" value="${reqVideo.videoId}"/>
					
				<div id="segment-input-add">
					<aui:button-row>
						<aui:button type="button" value="add" onClick="addSegment()" />
					</aui:button-row>
				</div>
							
				<div id="segment-input-cancel">
					<aui:button-row>
						<aui:button type="cancel" value="cancel" href="${backURL}"/>
					</aui:button-row>				
				</div>
			</aui:form>	
		</div>
	</aui:fieldset>
	
	<div id="segments-wide">
		<div id="segments"></div>
	</div>
</div>

<script type="text/javascript">
	$( document ).ready(function() {
		AUI().use('aui-io-request', function(A){
			A.io.request('${segmentsURL}', {
	            method: 'post',
	            dataType: 'json',
	    	    data: {
	    	 	   	<portlet:namespace/>videoId: "${reqVideo.videoId}"
	    	    },
	            on: {
	                 success: function() {
	                	 //json array
	                	 var json =  this.get('responseData');
	                	 drawAllSegments(json);
	                 }
	            }
	         });
		});
	});

	function deleteSegment(segmentId){	
		AUI().use('aui-io-request', function(A){
			A.io.request('${deleteSegmentURL}', {
	            method: 'post',
	            dataType: 'json',
			    data: {
			 	   	<portlet:namespace/>segmentId: segmentId,
			 	   	<portlet:namespace/>videoId: "${reqVideo.videoId}",
			    },
	            on: {
	                 success: function() {
	                	 //json object
	                	 var json =  this.get('responseData');
	                	 $("#"+json.segmentId).remove();
	                 }
	            }
	         });
		});		
	}

	function addSegment(){
		AUI().use('aui-io-request', function(A){
			A.io.request('${addSegmentURL}', {
	            method: 'post',
	            dataType: 'json',
	            form: {
	                id: '<portlet:namespace />fm'
	            },
	            on: {
	                 success: function() {
	                	 //json object
	                	 var json =  this.get('responseData');
	                     drawAnSegment(json);
	                 }
	            }
	         });
		});
	}
	
	function drawAllSegments(data) {
		for (var i = 0; i < data.length; i++) {
			drawAnSegment(data[i]);
	    }
	}

	function drawAnSegment(segment) {
	   	// segment is a chapter
	   	var newRow = '<div class="chaptertile" id="' + segment.segmentId + '">'+
		'<a><img width="130px" height="63px" class="imgsmall" src="'+segment.image+'"/></a>'+
		'<span class="time">'+segment.start +' - '+segment.end+'</span>'+
		'<a><span class="segment-title">'+segment.title+'</span></a>'+
		'<span class="icon-large icon-remove" alt="delete" onclick="deleteSegment('+segment.segmentId+')" ></span></div>';
		
		if(segment.previousSegmentId == -1){
			$("#segments").append(newRow);
		}else{
			$(newRow).insertAfter("#"+ segment.previousSegmentId);
		}
	}
</script>




