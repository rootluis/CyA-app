var index=(function($,document){
    var btnProcessEnable=new BTNProcessEnable();

	var main=function(){
		
    		eventsBody();
    	};

    	var eventsBody=function(){
    	    $("#contTab").on("click",".btn-activeOption",function(){
    	        var discipline=$(this).attr("value");
                btnProcessEnable.Disable(discipline,"continuidad");
    		});
    		$("#contTab").on("click",".btn-inactiveOption",function(){
            	var discipline=$(this).attr("value");
                btnProcessEnable.Enable(discipline,"continuidad");
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