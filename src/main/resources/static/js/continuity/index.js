var index=(function($,document){


	var main=function(){
		
    		eventsBody();
    	};

    	var eventsBody=function(){
    	    $("#contTab").on("click",".btn-activeOption",function(){
    	        var discipline=$(this).attr("value");
    	        console.log("Desabilitando");
                disable(discipline);
    		});
    		$("#contTab").on("click",".btn-inactiveOption",function(){
            	var discipline=$(this).attr("value");
            	console.log("habilitando");
                enable(discipline);
            });
    	}

      var disable=function(discipline){

             $.ajax(
              {
                url : '/continuidad/disable',
                type: "POST",
                data :  jQuery.param({ id: discipline}) ,
                           success: function (response) {

                             if(response.code == "0"){
                                $("#OptionInactive-"+discipline).removeClass("btn-options-hide");
                                $("#OptionActive-"+discipline).removeClass("btn-options-active");

                                $("#OptionInactive-"+discipline).addClass("btn-options-active");
                                $("#OptionActive-"+discipline).addClass("btn-options-hide");

                             }else{
                                alert("No fue posible desabilitar la continuidad");

                             }

                           }
              });
        }

     var enable=function(discipline){
             $.ajax(
              {
                url : '/continuidad/disable',
                type: "POST",
                data :  jQuery.param({ id: discipline}) ,
                           success: function (response) {

                             if(response.code == "0"){
                                $("#OptionInactive-"+discipline).removeClass("btn-options-active");
                                $("#OptionActive-"+discipline).removeClass("btn-options-hide");

                                $("#OptionInactive-"+discipline).addClass("btn-options-hide");
                                $("#OptionActive-"+discipline).addClass("btn-options-active");

                             }else{
                                alert("No fue posible habilitar la continuidad");

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