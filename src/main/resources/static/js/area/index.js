var index=(function($,document){


	var main=function(){
		eventsBody();
	};

	var eventsBody=function(){
	    $("#tableArea").on("click",".btn-activeOption",function(){
	        var area=$(this).attr("value");
	        console.log("Desabilitando");
            disableArea(area);
		});
		$("#tableArea").on("click",".btn-inactiveOption",function(){
        	var area=$(this).attr("value");
        	console.log("habilitando");
            enableArea(area);
        });
	}

  var disableArea=function(area){
//  url : '/areaService/disable',
         $.ajax(
          {
            url : '/area/disable',
            type: "POST",
            data :  jQuery.param({ id: area}) ,
                       success: function (response) {
                         console.log("Siiiii");
                         console.log(response);

                         if(response.code == "0"){
                            $("#OptionInactive-"+area).removeClass("btn-options-hide");
                            $("#OptionActive-"+area).removeClass("btn-options-active");

                            $("#OptionInactive-"+area).addClass("btn-options-active");
                            $("#OptionActive-"+area).addClass("btn-options-hide");

                         }else{
                            alert("No fue posible desabilitar el Area");

                         }

                       }
          });
    }

 var enableArea=function(area){
         $.ajax(
          {
            url : '/area/disable',
            type: "POST",
            data :  jQuery.param({ id: area}) ,
                       success: function (response) {
                         console.log("Siiiii");
                         console.log(response);

                         if(response.code == "0"){
                            $("#OptionInactive-"+area).removeClass("btn-options-active");
                            $("#OptionActive-"+area).removeClass("btn-options-hide");

                            $("#OptionInactive-"+area).addClass("btn-options-hide");
                            $("#OptionActive-"+area).addClass("btn-options-active");

                         }else{
                            alert.message("No fue posible habilitar el Area");

                         }

                       }
          });
    }


	var index=function(){};
	index.prototype={
		main:main
	};

	return index;
})(jQuery,document);

var indexDocument=new index();
$(indexDocument.main());