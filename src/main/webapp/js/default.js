var baseUrl, content;

function pageLoad(url, target) {
	if(baseUrl){
		url = baseUrl + "/" + url;
	}
	if(!content){
		content = $("body");
	}
	if (target && $("#" + target).size() > 0) {
		$("#" + target).load(url).data("data-url", url);
	} else {
		content.load(url).data("data-url", url);
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
