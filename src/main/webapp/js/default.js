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

$(document).on("click", "a[data-url]", function() {
	pageLoad($(this).attr("data-url"), $(this).attr("data-target"));
});
