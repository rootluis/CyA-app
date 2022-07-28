var index=(function($,document){
    var btnProcessEnable=new BTNProcessEnable();

	var main=function(){
		eventsBody();
	};

	var eventsBody=function(){
	    $("#tableArea").on("click",".btn-activeOption",function(){
	        var area=$(this).attr("value");
	        console.log("Desabilitando");
            btnProcessEnable.Disable(area,"area");
		});
		$("#tableArea").on("click",".btn-inactiveOption",function(){
        	var area=$(this).attr("value");
        	console.log("habilitando");
            btnProcessEnable.Enable(area,"area");
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