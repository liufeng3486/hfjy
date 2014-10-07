<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="conduct">
	<a href="javascript:void(0);">
		<img src="images/img/img1.png" />
	</a>
</div>
<!--话题 start-->
<div class="block" id="contact">
	<div class="title"> <em class="icon it"></em>
		<h1>话题</h1>
		<span class="dotted">
			<a href="javascript:void(0);" class="active"></a>
			<a href="javascript:void(0);" class=""></a>
			<a href="javascript:void(0);" class=""></a>
		</span>
	</div>
	<div id="listHotTopic" class="content">
		<s:iterator value="listHotTopics" var="item" status="s">
			<div class="layer">
				<dl>
					<dt>
						<s:if test="#item.protype==1">
							<a href="javascript:void(0);" class="btn btn_white right" data-role="focus" data-id="${item.id}">已关注</a>
						</s:if>
						<s:else>
							<a href="javascript:void(0);" class="btn btn_white right" data-role="focus" data-id="${item.id}">
								<span class="red">+</span>
								&nbsp;关注
							</a>
						</s:else>
						<h2 onclick="location.href='index?m=topic/detailWebTopic?id=${item.id}'">${item.name}</h2>
					</dt>
					<dd>
						<p>${item.introduction}</p>
					</dd>
				</dl>
				<a href="index?m=topic/detailWebTopic?id=${item.id}" class="left" >
					<img width="60" src="download?c=${item.topicphoto}" alt="${item.name}" title="${item.name}" />
				</a>
				<div class="clear">&nbsp;</div>
			</div>
		</s:iterator>
	</div>
</div>
<!--话题 end-->
<!--大家都在看 start-->
<div class="block">
	<div class="title"> <em class="icon ih"></em>
		<h1>大家都在看</h1>
	</div>
	<div id="everybody" class="content">
		<s:iterator value="listWebArticles" var="item" status="s">
			<div class="newer">
				<a href="index?m=article/detailWebArticle?id=${item.id}"> <em class="icon idotted"></em>
					<span>${item.title}</span>
					<div class="clear">&nbsp;</div>
				</a>
			</div>
		</s:iterator>
	</div>
</div>
<!--大家都在看 end-->

<script type="text/javascript">
$("#everybody>div").last().addClass("last");
$("#listHotTopic>div").last().addClass("last");
</script>