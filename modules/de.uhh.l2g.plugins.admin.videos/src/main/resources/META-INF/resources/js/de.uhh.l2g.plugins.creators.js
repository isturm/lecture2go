function autocompleteCreator($creatorInputObject, validationFunction) {
	avoidClosing = false;
	$creatorInputObject.autocomplete({
	    source: function(request, response) {
	        var results = $.ui.autocomplete.filter(allCreatorsInJQueryAutocompleteFormat, request.term);
	        response(results.slice(0, 10));
	    },
	    messages: {
	        noResults: '',
	        results: function() {}
	    },
		minLength: 1,
		open: function(event, ui) {
			$('.ui-autocomplete').append('<li id="addNewCreator" class="newcreator">' + Liferay.Language.get('add-new-creator') + ' <span class="icon-large icon-plus-sign"></span></li>');
			$( "#addNewCreator" ).on( "click", function() {
				/* empty the creator input field */
				$creatorInputObject.val('');
				$("#creators").loadTemplate("#newCreator", "", { append: true, elemPerPage: 20 });
				if( typeof validationFunction == "function" ) {
					validationFunction();
				}
				$creatorInputObject.autocomplete('close');
			});
		},
        response: function(event, ui) {
            if (ui.content.length === 0) {
            	avoidClosing = true;
	        }
        },
        close: function(event, ui) {
        	if (avoidClosing) {
        		$("ul.ui-autocomplete li:not(:last)").remove();
            	$("ul.ui-autocomplete").show();
            	avoidClosing = false;
        	}
        },
		select: function (event, ui) {
			if(ui.item.id>0){
  		        var vars = getJSONCreator(ui.item.id);
  		        $("#creators").loadTemplate("#created", vars, { append: true, elemPerPage: 20 });
  		        if( typeof validationFunction == "function" )
					validationFunction();
  				/* empty the creator input field */
  		     	ui.item.value="";
  			}
		}
	});
}

function getJSONCreator (data){
	var ret;
	/* we can not access the portlet nameSpace from the external js file directly so we need to build the variable property name this way: */
	var creatorId = nameSpace + "creatorId";
	var dataJSON = {};
	dataJSON[creatorId] = data;
	
	$.ajax({
		  type: "POST",
		  url: getJSONCreatorURL,
		  dataType: 'json',
		  data: dataJSON,
		  global: false,
		  async:false,
		  success: function(data) {
		    ret = data;
		  }
	})
	return ret;
}


function getJsonCreatorsArray(){
	var jsonCreatorsArray = [];
	var n = 0;
	$('#creators').children().each(function(n){
		var parameters = {};
		var $div = $(this);
		//get inputs for this div
		
		var cId ="#"+nameSpace+"creatorId";
		//
		$div.children(cId).each(function(index){
			$creator = $(this);
			$creatorId = $(this).attr("value");
			
			if ($creatorId > 0){ 
				//creator exists
				parameters = getJSONCreator($creatorId);
			}else{ 
				//create new creator
				parameters['creatorId'] = "0";
				parameters['firstName'] = $div.find('input[name = '+nameSpace+'firstName]').val().trim();
				parameters['lastName'] = $div.find('input[name = '+nameSpace+'lastName]').val().trim();
				parameters['middleName'] = $div.find('input[name = '+nameSpace+'middleName]').val().trim();
				parameters['jobTitle'] = $div.find('input[name = '+nameSpace+'jobTitle]').val().trim();
				parameters['gender'] = "";
				parameters['fullName'] = (parameters['jobTitle'].trim()+" "+(parameters['firstName'].trim()+" "+parameters['middleName'].trim()).trim()+" "+parameters['lastName'].trim()).trim();						
			}
		});
		//
		if(parameters['firstName'].length>0 && parameters['lastName'].length>0){
			jsonCreatorsArray[n]=parameters;
		}
	});
	return jsonCreatorsArray;
}
