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
        userInfo = eval("(" + $.cookie("userInfo") + ")")
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

</body>
</html>


