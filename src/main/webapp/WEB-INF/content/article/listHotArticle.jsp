<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="tab_content">
	<s:iterator value="listWebArticles" var="item" status="s">
	<div class="layer">
		<div class="padding">
			<div class="right">
				<dl>
					<dt>
						<a href="index?m=article/detailWebArticle?id=${item.id}">${item.title}</a>
					</dt>
					<dd>
						<div class="tag">
							<s:iterator value="#item.webTopics" var="item1" status="s">
								<a href="javascript:void(0);" class="btn btn_white" data-role="webTopic" data-id="${item1.id}" data-introduction="${item1.introduction}" data-topicphoto="${item1.topicphoto}">${item1.name}</a>
							</s:iterator>

							<div class="popup_tag" style="width: 310px;display:none"> <em class="icon iarrow"></em>
								<div class="padding">
									<dl>
										<dt>
											<a data-role="focus" class="btn btn_white fr" href="javascript:void(0);"></a>
											<h2 data-role="name"></h2>
										</dt>
										<dd>
											<p data-role="introduction"></p>
										</dd>
									</dl>
									<a class="left" href="javascript:void(0);">
										<img width="60" data-role="topicphoto" /></a>
									<div class="clear">&nbsp;</div>
								</div>
							</div>
						</div>
					</dd>
					<dd>
						<p>
							${item.description}
						</p>
					</dd>
					<dd>
						<span class="time"><s:date name="#item.publishdate" format="HH:mm  M.dd"/></span>
						<span class="gray">${item.author}</span>
					</dd>
				</dl>
			</div>
			<div class="left">
				<a href="index?m=article/detailWebArticle?id=${item.id}">
					<img width="200" src="download?c=${item.articlephoto}" />
				</a>
			</div>
			<div class="clear">&nbsp;</div>
		</div>
	</div>
	</s:iterator>
</div>
<!--pavigation start-->
<div id="lastArticlePager"></div>
<!--pavigation end-->

<script type="text/javascript">
$("a[data-role=webTopic]").click(function() {
	if ($(this).hasClass("active")) {
		$(this).removeClass("active");
		$(this).siblings(".popup_tag").hide();
	} else {
		$("a[data-role=webTopic]").removeClass("active");
		$(".popup_tag").hide();
		$(this).addClass("active");
		var obj = $(this).siblings(".popup_tag");
		obj.find("[data-role=name]").html($(this).html());
		obj.find("[data-role=introduction]").html($(this).attr("data-introduction"));
		obj.find("[data-role=topicphoto]").attr({
			"src":"download?c="+$(this).attr("data-topicphoto"),
			"title":$(this).html(),
			"alt":$(this).html()
		});

		obj.find("[data-role=focus]").attr({
			"data-id":$(this).attr("data-id")
		});

		if($.inArray($(this).attr("data-id"), focusTopic) > -1){
			obj.find("[data-role=focus]").html("已关注");
		}else{
			obj.find("[data-role=focus]").html('<span class="red">+</span>&nbsp;关注');
		}

		obj.css("left", $(this).offset().left - $(this).parent().offset().left - 88 + $(this).width() / 2).show();

	}
});

$(".popup_tag").click(function(){
	$(this).hide().siblings("a[data-role=webTopic]").removeClass("active");
});

$("#lastArticlePager").pager("article/listLastArticle","articleList",${startIndex},${pageSize},${count},1);
</script>