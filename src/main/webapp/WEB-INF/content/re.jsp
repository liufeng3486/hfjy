<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container">
	<div class="contain">
		<div class="rightsidebar"></div>

		<!--leftcontent start-->
		<div class="leftcontent">
			<div class="password_success">
				<div class="layer">
					<div class="padding"><img src="images/pw_success_text.png" /></div>

				</div>
				<p class="red align_center">( <span id="count"></span> 秒后自动跳转到首页)</p>
			</div>
		</div>
		<div class="clear">&nbsp;</div>
	</div>
</div>
<script type="text/javascript">
	var count = 5;
	function renderCount(){
		$("#count").html(count);
	}
	renderCount();
	setInterval(function(){
		count--;
		if(count == 0){
			location.href = "index";
		}
		renderCount();
	},1000);
</script>