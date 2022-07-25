var index=(function($,document){


	var main=function(){
    		eventsBody();
    	};

    	var eventsBody=function(){
    	    $("#technologyTab").on("click",".btn-activeOption",function(){
    	        var technology=$(this).attr("value");
    	        console.log("Desabilitando");
                disableTechnology(technology);
    		});
    		$("#technologyTab").on("click",".btn-inactiveOption",function(){
            	var technology=$(this).attr("value");
            	console.log("habilitando");
                enableTechnology(technology);
            });
    	}

      var disableTechnology=function(technology){

             $.ajax(
              {
                url : '/tecnologia/disable',
                type: "POST",
                data :  jQuery.param({ id: technology}) ,
                           success: function (response) {

                             if(response.code == "0"){
                                $("#OptionInactive-"+technology).removeClass("btn-options-hide");
                                $("#OptionActive-"+technology).removeClass("btn-options-active");

                                $("#OptionInactive-"+technology).addClass("btn-options-active");
                                $("#OptionActive-"+technology).addClass("btn-options-hide");

                             }else{
                                alert("No fue posible desabilitar la tecnologia");

                             }

                           }
              });
        }

     var enableTechnology=function(technology){
             $.ajax(
              {
                url : '/tecnologia/disable',
                type: "POST",
                data :  jQuery.param({ id: technology}) ,
                           success: function (response) {

                             if(response.code == "0"){
                                $("#OptionInactive-"+technology).removeClass("btn-options-active");
                                $("#OptionActive-"+technology).removeClass("btn-options-hide");

                                $("#OptionInactive-"+technology).addClass("btn-options-hide");
                                $("#OptionActive-"+technology).addClass("btn-options-active");

                             }else{
                                alert("No fue posible habilitar la tecnologia");

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