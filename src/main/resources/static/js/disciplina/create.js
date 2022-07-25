var create=(function($,document){


	var main=function(){
		console.log("Estas en create.js");
		viewEvents();
	};

	var viewEvents=function(){
		
	}




	var create=function(){};
	create.prototype={
		main:main
	};

	return create;
})(jQuery,document);

var createDoc=new create();
$(createDoc.main());