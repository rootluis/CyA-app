var index=(function($,document){
    var btnProcessEnable=new BTNProcessEnable();

	var main=function(){
    		eventsBody();
    	};

    	var eventsBody=function(){
    	    $("#technologyTab").on("click",".btn-activeOption",function(){
    	        var technology=$(this).attr("value");
    	        btnProcessEnable.Disable(technology,"tecnologia");
    		});
    		$("#technologyTab").on("click",".btn-inactiveOption",function(){
            	var technology=$(this).attr("value");
            	btnProcessEnable.Enable(technology,"tecnologia");
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