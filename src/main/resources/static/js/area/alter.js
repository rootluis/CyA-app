var alter=(function($,document){

	var main=function(){
		viewEvents();
	};

	var viewEvents=function(){
	}

	var alter=function(){};
	alter.prototype={
		main:main
	};

	return alter;
})(jQuery,document);

var alterDoc=new alter();
$(alterDoc.main());