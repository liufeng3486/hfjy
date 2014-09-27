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
								<a href="javascript:void(0);" class="btn btn_white" data-role="webTopic">${item1.name}</a>
							</s:iterator>
							
							<div class="popup_tag" style="width: 310px;display:none"> <em class="icon iarrow"></em>
								<div class="padding">
									<dl>
										<dt>
											<a class="btn btn_white fr" href="javascript:void(0);">已关注</a>
											<h2>复旦大学</h2>
										</dt>
										<dd>
											<p>简介假字简介假字简介假字简介假字简介假字简介假字简介假字简介假字。</p>
										</dd>
									</dl>
									<a class="left" href="javascript:void(0);">
										<img title="复旦大学" alt="复旦大学" src="images/icon/fudan_logo.png"></a>
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
					<img width="200" src="download?c=${item.articleimg}" />
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
		$(this).siblings(".popup_tag").css("left", $(this).offset().left + $(this).width() / 2 - 805).show();
	}
});

$(".popup_tag").click(function(){
	$(this).hide().siblings("a[data-role=webTopic]").removeClass("active");
});

$("#lastArticlePager").pager("article/listLastArticle","articleList",${startIndex},${pageSize},${count},1);
</script>