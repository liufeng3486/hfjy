<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>录取啦</title>

<link href="style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/json.js"></script>
<script type="text/javascript" src="js/pager.js"></script>
<script type="text/javascript" src="js/default.js"></script>
<script type="text/javascript">

var provinceArray = [];
var gradeArray = [];
var userInfo = {};
var focusTopic = [];

function setCookie(){
    if(userInfo.province && userInfo.grade){
        $.cookie("userInfo", JSON.stringify(userInfo), {
           expires: 365
        });

        location.reload();
    }
}


$(function(){
    if (!$.cookie("userInfo")) {
        showShadow();
        $("#welcome").show();
    } else {
        userInfo = eval("(" + $.cookie("userInfo") + ")");
        focusTopic = $("#focusTopic").val().split(",");
    }

    $("#provinceList a").each(function(){
        var item = {};
        item.id = $(this).attr("data-id");
        item.parentid = $(this).attr("data-parentid");
        item.name = $(this).html();
        provinceArray.push(item);
    });

    $("#gradeList a").each(function(){
        var item = {};
        item.id = $(this).attr("data-id");
        item.name = $(this).html();
        gradeArray.push(item);
    });

    $("#showProvice").click(function(){
        $(this).addClass("active");
        $("#showGrade").removeClass("active");
        $("#gradeList").hide();
        if($(this).data("id")){
            $("#provinceList a[data-id="+$(this).data("id")+"]").addClass("active").siblings().removeClass("active");
            $("#provinceList a[data-id="+$(this).data("parentid")+"]").addClass("active").siblings().removeClass("active");
        }
        $("#provinceList").show();
    });

    $("#showGrade").click(function(){
        $(this).addClass("active");
        $("#showProvice").removeClass("active");
        $("#provinceList").hide();
        if($(this).data("id")){
            $("#gradeList a[data-id="+$(this).data("id")+"]").addClass("active").siblings().removeClass("active");
        }
        $("#gradeList").show();
    });

    $("#provinceList a").click(function(){
        if($(this).attr("data-parentid") == 0){
            $(this).addClass("active").siblings().removeClass("active");
            $("#provinceList a[data-parentid!=0]").hide();
            $("#provinceList a[data-parentid="+$(this).attr("data-id")+"]").show();
        }else{
            $("#provinceList").hide();
            $("#showProvice").data({
                "id":$(this).attr("data-id"),
                "parentid":$(this).attr("data-parentid")
            }).html($(this).html()).removeClass("active");

            userInfo.province = $("#showProvice").data("id");
            setCookie();
        }
    });

    $("#gradeList a").click(function(){
        $("#gradeList").hide();
        $("#showGrade").data({
            "id":$(this).attr("data-id")
        }).html($(this).html()).removeClass("active");

        userInfo.grade = $("#showGrade").data("id");
        setCookie();
    });

    $("#header").load("header");
    $("#footer").load("footer");
    $("#main").load("${m}");


});

</script>
</head>
<body>
<div id="header">

</div>

<div id="main">
  
</div>

<!--footer start-->
<div id="footer" class="footer"></div>
<!--footer end--> 
<input id="focusTopic" type="hidden" value="${focusTopic}" />

<div id="shadow" style="width:100%;height:100%;position:absolute;z-index:999;background-color:#000;opacity:.3;top:0;left:0;display:none;">&nbsp;</div>

<div class="popup w_h_m2" id="welcome" style="display:none;">
    <div class="welcome">
        <h2 class="red2">
            欢迎来到
            <img src="images/b_logo.png" />
        </h2>
        <p>通过选择省份和年级，</p>
        <p>
            我们可以为你 <b>提供更优质的服务</b>
        </p>
        <div class="p_tab">
            <a href="javascript:void(0);" id="showProvice">省份</a>
            <a href="javascript:void(0);" id="showGrade">年级</a>
            <div id="provinceList" class="p_tab_content" style="display:none;"> <em class="icon iarrow"></em>
                <div>
                    <s:iterator value="listSysProvinces" var="item" status="s">
                        <s:if test="#item.parentid==0">
                            <a href="javascript:void(0);" data-id="${item.id}" data-parentid="${item.parentid}">${item.name}</a>
                        </s:if>
                    </s:iterator>
                </div>
                <hr/>
                <div>
                    <s:iterator value="listSysProvinces" var="item" status="s">
                        <s:if test="#item.parentid!=0">
                            <a href="javascript:void(0);" data-id="${item.id}" data-parentid="${item.parentid}" style="display:none;">${item.name}</a>
                        </s:if>
                    </s:iterator>
                </div>
            </div>
            <div id="gradeList" class="p_tab_content p_senior" style="display:none;"> <em class="icon iarrow"></em>
                <s:iterator value="listSysGrades" var="item" status="s">
                    <a href="javascript:void(0);" data-id="${item.id}">${item.gradename}</a>
                </s:iterator>
            </div>
        </div>
    </div>
</div>

<div id="login" class="popup w_h_m" style="display:none;">
  <form>
    <div class="login">
      <div class="padding">
        <dl class="input">
          <dt><em class="icon iuser"></em></dt>
          <dd>
            <div  class="padding">
              <input id="loginname" type="text" placeholder="邮箱" />
            </div>
          </dd>
        </dl>
        <div class="clear">&nbsp;</div>
        <dl  class="input">
          <dt><em class="icon ipw active"></em></dt>
          <dd>
            <div class="padding"><em class="icon ieye"></em>
              <input id="password" type="password" placeholder="密码" />
              <p class="red" data-role="message" style="display:none;">密码输入错误！</p>
            </div>
          </dd>
        </dl>
        <div class="clear">&nbsp;</div>
        <div class="align_center"><a id="loginSubmit" href="javascript:void(0);" class="btn btn_red">登录</a></div>
        <div class="group">
          <div class="link"><a href="javascript:void(0);" onclick="$('#shadow').click();$('#btn_register').click();">注册</a><a href="javascript:void(0);">忘记密码？</a></div>
          <div class="rand"> <img src="images/rand.png" /> <span class="gray">微信登录</span> </div>
          <div class="clear">&nbsp;</div>
        </div>
        <div class="clear">&nbsp;</div>
      </div>
    </div>
  </form>
</div>

<div id="register" class="popup w_h_m3" style="display:none;">
    <div class="login regsiter" >
        <div class="padding">
            <dl class="input">
                <dt> <em class="icon semail"></em>
                </dt>
                <dd>
                    <div class="padding">
                        <input id="register_email" type="text" placeholder="邮箱" />
                        <p class="red" data-role="message" style="display:none;">该邮箱已被注册！</p>
                    </div>
                </dd>
            </dl>
            <div class="clear">&nbsp;</div>
            <dl class="input">
                <dt> <em class="icon suser active"></em>
                </dt>
                <dd>
                    <div class="padding">
                        <input id="register_name" type="text" placeholder="昵称" />
                    </div>
                </dd>
            </dl>
            <div class="clear">&nbsp;</div>
            <dl class="input">
                <dt>
                    <em class="icon spw active"></em>
                </dt>
                <dd>
                    <div  class="padding" >
                        <em class="icon seye"></em>
                        <input id="register_password" type="password" placeholder="密码" />
                        <p class="red" style="display:none;">密码输入错误！</p>
                    </div>
                </dd>
            </dl>
            <div class="clear">&nbsp;</div>
            <dl class="input">
                <dt>
                    <em class="icon slocation"></em>
                </dt>
                <dd>
                    <div class="padding">
                        <span class="fill"> <b id="register_province"></b>
                        </span>
                        <a id="register_province_btn" href="javascript:void(0);">
                            <em class="icon sedit"></em>
                        </a>
                        <div id="register_province_popup" class="popup_location" style="display:none;">
                            <em class="icon iarrow"></em>
                            <div class="padding">
                                <div class="box">
                                    <s:iterator value="listSysProvinces" var="item" status="s">
                                        <s:if test="#item.parentid==0">
                                            <a href="javascript:void(0);" data-id="${item.id}" data-parentid="${item.parentid}">${item.name}</a>
                                        </s:if>
                                    </s:iterator>
   
                                </div>
                                <div class="align_center">
                                    <a href="javascript:void(0);">
                                        <em class="icon iarrow_down"></em>
                                    </a>
                                </div>
                                <div class="box">
                                    <s:iterator value="listSysProvinces" var="item" status="s">
                                        <s:if test="#item.parentid!=0">
                                            <a href="javascript:void(0);" data-id="${item.id}" data-parentid="${item.parentid}" style="display:none;">${item.name}</a>
                                        </s:if>
                                    </s:iterator>
                                </div>
                            </div>
                        </div>
                    </div>
                </dd>
            </dl>
            <div class="clear">&nbsp;</div>
            <dl class="input">
                <dt>
                    <em class="icon sdate"></em>
                </dt>
                <dd>
                    <div class="padding">
                        <span class="fill">
                            高中毕业于 <b id="register_grade" class="margin">2014</b>
                            年
                        </span>
                        <a href="javascript:void(0);" id="register_grade_btn">
                            <em class="icon sedit"></em>
                        </a>
                    </div>
                </dd>
            </dl>
            <div class="clear">&nbsp;</div>
            <div class="btn_group_login align_center">
                <a href="javascript:void(0);" class="btn btn_red" id="registerSubmit">注册</a>
                <a href="javascript:void(0);" onclick="$('#shadow').click();$('#btn_login').click();">登录</a>
            </div>
            <p class="gray align_center"><a target="_blank" href="index">点击“注册”表示您同意《“录取啦”用户使用协议》</a></p>
        </div>
    </div>
</div>

<div class="popup w_h_m4" style="display:none;">
    <div class="login regsiter" >
        <div class="padding">
            <dl class="input">
                <dt> <em class="icon semail"></em>
                </dt>
                <dd>
                    <div class="padding">
                        <input id="" type="text" placeholder="注册的邮箱" />
                        <p class="red" data-role="" style="display:none;">邮箱输入的格式不正确！</p>
                    </div>
                </dd>
            </dl>
            <div class="clear">&nbsp;</div>
            <div class="random">
                <dl class="input">
                    <dd>
                        <div class="padding">
                            <input id="" type="text" placeholder="验证码" />
                        </div>
                    </dd>
                </dl>
                 <div class="right"><a href="#"><img src="images/rand.png" alt="验证码" /></a></div>
                <div class="clear">&nbsp;</div>
             </div>
            <div class="btn_group_login align_center">
                <a href="javascript:void(0);" class="btn btn_red" id="registerSubmit">注册</a>
                <a href="javascript:void(0);" onclick="$('#shadow').click();$('#btn_login').click();">登录</a>
            </div>            
        </div>    
    </div>

</div>
</body>
</html>


