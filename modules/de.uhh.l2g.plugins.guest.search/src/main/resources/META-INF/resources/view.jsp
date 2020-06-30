<%@include file="init.jsp"%>

<portlet:resourceURL var="findVideosURL">
    <portlet:param name="task" value="findVideos"/>
</portlet:resourceURL>

<div style="display: none;" id="<portlet:namespace/>findVideosURL">${findVideosURL}</div>

<aui:form action="/web/vod/l2go/-/get/0/0/0/0/0/0/" method="POST" name="submitForm">
	<aui:input name="findVideos" id="findVideos" placeholder="Suche nach Videos, Veranstaltungen, Dozierenden, ..." label="" inlineField="true" value="${memberDTO.findVideos}"/>
	<input type="submit"/>
</aui:form>		

<script type="text/javascript">
	$(document).ready( function() {
		//---prepare auto complete results start
		//set here your portlet name space.
		var autoCompleteList;
		//auto complete list for findVideos
		AUI().use('autocomplete-list', 'aui-base', 'aui-io-request', 'autocomplete-filters', 'autocomplete-highlighters', function(A) {
		    //URL for call serverResource method
		    var findVideosURL = A.one('#<portlet:namespace/>findVideosURL').get('text');
		    //findVideos name
		    //call serverResource method with ajax which give in response.
	        //create autocomplete object for findVideos input box
	    	var inputField = '#<portlet:namespace/>findVideos';
	    	console.log(inputField);
	        autoCompleteList = new A.AutoCompleteList({
	            inputNode: inputField,
	            resultTextLocator: 'word',
	            render: 'true',
	            resultHighlighter: 'subWordMatch',
	            resultFilters: ['subWordMatch'],
	            source: function(query, callback) {
	            	var searchURL = Liferay.PortletURL.createURL(findVideosURL);
	            	searchURL.setParameter("searchText", A.one(inputField).get('value'));
	            	searchURL.setParameter("resultLimit", 10);
	            	A.io.request(searchURL.toString(), {
	            		dataType: 'json',
	        	        method: 'POST',
	        	        sync: false,
	        	        on: {
		                    success:function(){
		                       callback(this.get('responseData'));
		                    }
		                }
	            	});
	            },
	            typeAhead: true,
	            maxResults: 10,
	            minQueryLength: 3
	        });
	        
	        //submit selected search word
	        autoCompleteList.on('select',
	        		function(event) {
	        			var searchWord=event.result.text;
	        			$(inputField).val(searchWord);
	        			$('#<portlet:namespace/>submitForm').attr('action', '/web/vod/l2go/-/get/0/0/0/0/0/0/0/1/' + encodeURIComponent(searchWord).replace(/\./g, '%2E'));
	        			$('#<portlet:namespace/>submitForm').submit();
	        		}
	        );
	        
	        A.one('#<portlet:namespace/>submitForm').on('submit',
	        		function(event) {
	        			var searchWord=$(inputField).val();
	        			$('#<portlet:namespace/>submitForm').attr('action', '/web/vod/l2go/-/get/0/0/0/0/0/0/0/0/' + encodeURIComponent(searchWord).replace(/\./g, '%2E'));
	        		}
	        );
		});	
		//---prepare auto complete results end
	});
</script>