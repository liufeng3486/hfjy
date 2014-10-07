var baseUrl, content;

function pageLoad(url, target) {
	if(baseUrl){
		url = baseUrl + "/" + url;
	}
	if(!content){
		content = $("body");
	}
	if(baseUrl == "admin"){
		showShadow();
	}
	if (target && $("#" + target).size() > 0) {
		$("#" + target).load(url,function(){
			if(baseUrl == "admin"){
				hideShadow();
			}
		}).data("data-url", url);
	} else {
		content.load(url,function(){
			if(baseUrl == "admin"){
				hideShadow();
			}
		}).data("data-url", url);
	}
}

function getParam(url){
	var result = {};
	if(url.indexOf("?")>-1){
		var p = url.split("?")[1].split("&");
		for (var i = 0; i < p.length; i++) {
			result[p[i].split("=")[0]] = p[i].split("=")[1];
		}

	}
	return result;
}

$(document).on("click", "[data-url]", function() {
	pageLoad($(this).attr("data-url"), $(this).attr("data-target"));
});

function showShadow(popupid){
	$("#shadow").show();
	if(popupid){
		$("#shadow").one("click",function(){
			hideShadow();
			$("#"+popupid).hide();
		});
	}
}

function hideShadow(){
	$("#shadow").hide();
}

$(document).ajaxStart(function(){
	//showShadow();
});

$(document).ajaxStop(function(){
	//hideShadow();
});

var resizeShadow = setInterval(function(){
	$("#shadow").height(Math.max($(window).height(),$(document).height()));
}, 200);
