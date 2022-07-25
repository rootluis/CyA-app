var alter=(function($,document){


	var main=function(){
		console.log("Estas en alter.js");
		viewEvents();
	};

	var viewEvents=function(){
//		$(".card-body").on("keyup","#name",function(){
//			var textvalue=$(this).val();
//
//			if(textvalue != ""){
//				textvalue=textvalue.replace(" ","_");
//				textvalue="#"+textvalue;
//			}
//
//			$("#code").val(textvalue);
//			$("#hi-code").val(textvalue);
//		});
	}




	var alter=function(){};
	alter.prototype={
		main:main
	};

	return alter;
})(jQuery,document);

var alterDoc=new alter();
$(alterDoc.main());