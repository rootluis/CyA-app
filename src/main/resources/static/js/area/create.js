var create=(function($,document){

	var main=function(){
		console.log("Estas en create.js");
		viewEvents();
	};

	var viewEvents=function(){
		$(".card-body").on("keyup","#name",function(){
			var textvalue=$(this).val();

			if(textvalue != ""){
				textvalue=textvalue.replace(/ /g,"_");
				textvalue="#"+textvalue;
			}

			$("#code").val(textvalue);
			$("#codeBck").val(textvalue);

		});
	}

	var create=function(){};
	create.prototype={
		main:main
	};

	return create;
})(jQuery,document);

var createDoc=new create();
$(createDoc.main());
