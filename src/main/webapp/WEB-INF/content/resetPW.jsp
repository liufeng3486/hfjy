<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container">
	<div class="contain">
		<div class="rightsidebar"></div>
		<!--leftcontent start-->
		<div class="leftcontent">
			<div class="login password">
				<div class="layer">
					<div class="padding">
						<dl class="input">
							<dt>
								<em class="icon ipw active"></em>
							</dt>
							<dd>
								<div class="padding">
									<em class="icon ieye"></em>
									<input id="password1" type="password" placeholder="新密码" />
								</div>
							</dd>
						</dl>
						<div class="clear">&nbsp;</div>
						<dl class="input">
							<dt>
								<em class="icon ipw"></em>
							</dt>
							<dd>
								<div class="padding" >
									<em class="icon ieye"></em>
									<input id="password2" type="password" placeholder="确认新密码" />
									<p class="red" data-role="different_password" style="display:none;">两次密码输入不一致！</p>
								</div>
							</dd>
						</dl>
						<div class="align_center">
							<a href="javascript:void(0);" class="btn btn_red" id="submit">重置密码</a>
						</div>

						<div class="clear">&nbsp;</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clear">&nbsp;</div>
	</div>
</div>
<input id="id" type="hidden" value="${id}" />

<script type="text/javascript">
	$("input").focus(function(){
		$(this).parents(".input").eq(0).addClass("blue_border");
	}).blur(function(){
		$(this).parents(".input").eq(0).removeClass("blue_border");
	});

	$("#submit").click(function(){
		if($("#password1").val() != $("#password2").val()){
			$(".red[data-role=different_password]").show();
		}else{
			$.post("ajaxChangePW",{
				id:$("#id").val(),
				password :$("#password1").val()
			},function(data){
				if(data==1){
					location.href = "index?m=re";
				}
			});
		}
	});
</script>