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
	<div class="content">
		<div class="layer">
			<dl>
				<dt>
					<a href="javascript:void(0);" class="btn btn_white right">已关注</a>
					<h2>复旦大学</h2>
				</dt>
				<dd>
					<p>简介假字简介假字简介假字简介假字简介假字简介假字简介假字简介假字。</p>
				</dd>
			</dl>
			<a href="javascript:void(0);" class="left">
				<img src="images/icon/fudan_logo.png" alt="复旦大学" title="复旦大学" />
			</a>
			<div class="clear">&nbsp;</div>
		</div>
		<div class="layer">
			<dl>
				<dt>
					<a href="javascript:void(0);" class="btn btn_white right">已关注</a>
					<h2>同济大学</h2>
				</dt>
				<dd>
					<p>简介假字简介假字简介假字简介假字简介假字简介假字简介假字简介假字。</p>
				</dd>
			</dl>
			<a href="javascript:void(0);" class="left">
				<img src="images/icon/tongji_logo.png" alt="同济大学" title="同济大学" />
			</a>
			<div class="clear">&nbsp;</div>
		</div>
		<div class="layer last">
			<dl>
				<dt>
					<a href="javascript:void(0);" class="btn btn_white right">
						<span class="red">&plus;</span>
						&nbsp;关注
					</a>
					<h2>高考</h2>
				</dt>
				<dd>
					<p>简介假字简介假字简介假字简介假字简介假字简介假字简介假字简介假字。</p>
				</dd>
			</dl>
			<a href="javascript:void(0);" class="left">
				<img src="images/icon/gaokao_logo.png" alt="高考" title="高考" />
			</a>
			<div class="clear">&nbsp;</div>
		</div>
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
</script>