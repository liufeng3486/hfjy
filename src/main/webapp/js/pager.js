
$.fn.extend({
	pager: function(url, target, startIndex, pageSize, count,type) {
		if(url.indexOf("?") > -1){
			url += "&pager.offset=";
		}else{
			url += "?pager.offset=";
		}

		var _init = function(obj) {
			
			var pageCount = parseInt((count - 1) / pageSize) + 1,
				currentPage = parseInt(startIndex / pageSize) + 1;
				
			var pageInfo = $('<div class="gray align_right"></div>').html(currentPage+"/"+pageCount),
				pageGroup = $('<div class="btn_group"></div>');

			if (pageCount > 1) {
				if (type == 1) {

					var nextLink = $('<a href="#' + target + '" class="btn right">下一页&nbsp;&gt;</a>'),
						prevLink = $('<a href="#' + target + '" class="btn left">&lt;&nbsp;上一页</a>');

					if (currentPage == 1) {
						prevLink.addClass("unactive");
					} else {
						prevLink.attr({
							"data-url": url + parseInt(startIndex - pageSize),
							"data-target": target
						});
					}

					if (currentPage == pageCount) {
						nextLink.addClass("unactive");
					} else {
						nextLink.attr({
							"data-url": url + parseInt(startIndex + pageSize),
							"data-target": target
						});
					}

					pageGroup.append(prevLink).append(nextLink).append('<div class="clear">&nbsp;</div>');



				} else {
					var firstLink = $("<a href='javascript:void(0);' style='display:inline-block;width:auto;padding:5px;'>首页</a>"),
						prevLink = $("<a href='javascript:void(0);' style='display:inline-block;width:auto;padding:5px;'>上一页</a>"),
						nextLink = $("<a href='javascript:void(0);' style='display:inline-block;width:auto;padding:5px;'>下一页</a>"),
						lastLink = $("<a href='javascript:void(0);' style='display:inline-block;width:auto;padding:5px;'>尾页</a>");

					if (currentPage == 1) {
						prevLink.css("color","#ccc");
						firstLink.css("color","#ccc");
					} else {
						firstLink.attr({
							"data-url": url + 0,
							"data-target": target
						});
						prevLink.attr({
							"data-url": url + parseInt(startIndex - pageSize),
							"data-target": target
						});
					}

					if (currentPage == pageCount) {
						nextLink.css("color","#ccc");
						lastLink.css("color","#ccc");
					} else {
						nextLink.attr({
							"data-url": url + parseInt(startIndex + pageSize),
							"data-target": target
						});
						lastLink.attr({
							"data-url": url + parseInt(pageSize * (pageCount - 1)),
							"data-target": target
						});
					}

					pageGroup.append(firstLink).append(prevLink)
							.append(nextLink).append(lastLink)
							.append('<div class="clear">&nbsp;</div>');
				}
			}

			$(obj).addClass("pavigation")
				.append(pageInfo)
				.append(pageGroup);
		};


		$(this).each(function() {
			_init(this);
		});
	}
});