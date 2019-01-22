//$(document).ready(function() {
//        $('#userName').blur(function(event) {
//                var name = $('#userName').val();
//                $.get('GetUserServlet', {
//                        userName : name
//                }, function(responseText) {
//                        $('#ajaxGetUserServletResponse').text(responseText);
//                });
//        });
//});
//

function setAjax(year) {
	
	var sUrl = "";
	
	if (year == "2018"){
		sUrl = "/ServiceReporting/GraphManagement2018";
	}
		$.ajax({
			type: "POST",
			url : sUrl,
			dataType:"html", 
			data : {
				action : $('#reports').val(),
				
				reportMonth : $( "input:checked" ).val()
			},
			async:false, 
            cache:false,
            
			success : function(res) {
				//alert("SUCCESSSSSSSS");
				
				if ($('#reports').val() == "01")
				{	
					drawDemandGraph(res);
				
				}else if ($('#reports').val() == "02"){
				
					drawDemandUtilizationReport(res);
					
				}else if ($('#reports').val() == "03"){
					
					drawDeliveryModel(res);
					
				}else if ($('#reports').val() == "04"){
					
					drawTable(res);
					
				}else if ($('#reports').val() == "05"){
					
					drawGadgetCategory(res);
					
				
			}else if ($('#reports').val() == "06"){
				
				drawDemandType(res);
				
			}
		},
        error: function (err) {
        	
        	$.alert({
    		    title: 'Error in Ajax response!!',
    		    content: '-->'+err.statusText,
    		});
           // alert(err.statusText);
            
        }
    });

}