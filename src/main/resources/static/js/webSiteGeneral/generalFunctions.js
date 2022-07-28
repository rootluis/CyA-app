var BTNProcessEnable=(function($,document){

  var disable=function(idObject,moduleName){
        console.log("Datos a procesar URL: /"+moduleName+"/disable, idObject: "+idObject+", Nombre del modulo: "+moduleName);
         $.ajax(
          {
            url : '/'+moduleName+'/disable',
            type: "POST",
            data :  jQuery.param({ id: idObject}) ,
                       success: function (response) {
                         console.log("Siiiii");
                         console.log(response);

                         if(response.code == "0"){
                            $("#OptionInactive-"+idObject).removeClass("btn-options-hide");
                            $("#OptionActive-"+idObject).removeClass("btn-options-active");

                            $("#OptionInactive-"+idObject).addClass("btn-options-active");
                            $("#OptionActive-"+idObject).addClass("btn-options-hide");

                         }else{
                            alert("No fue posible desabilitar el Area");

                         }

                       }
          });
    }
 var enable=function(idObject,moduleName){
    console.log("Datos a procesar URL: /"+moduleName+"/disable, idObject: "+idObject+", Nombre del modulo: "+moduleName);
    $.ajax(
        {
            url : '/'+moduleName+'/disable',
            type: "POST",
            data :  jQuery.param({ id: idObject}) ,
                       success: function (response) {
                         console.log("Siiiii");
                         console.log(response);

                         if(response.code == "0"){
                            $("#OptionInactive-"+idObject).removeClass("btn-options-active");
                            $("#OptionActive-"+idObject).removeClass("btn-options-hide");

                            $("#OptionInactive-"+idObject).addClass("btn-options-hide");
                            $("#OptionActive-"+idObject).addClass("btn-options-active");

                         }else{
                            alert.message("No fue posible habilitar el Area");

                         }

                       }
          });
    }


	var index=function(){};
	index.prototype={
        Disable:disable,
        Enable:enable
	};

	return index;
})(jQuery,document);