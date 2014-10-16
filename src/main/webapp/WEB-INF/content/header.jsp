<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="header clearfix">
  <div class="contain">
    <div class="right">
      <s:if test="#request.userInfo==null">
        <a href="javascript:void(0);" id="btn_login">登录</a>
        <a href="javascript:void(0);" id="btn_register">注册</a>
      </s:if>
      <s:else>
        <a class="name" href="index?m=topic/focusTopic">
          <img src="images/icon/avator_small.png">${userInfo.name}</a>
        <a href="javascript:void(0);" id="btn_logout">退出</a>
      </s:else>
    </div>

    <div class="left">
      <a href="index">
        <img src="images/logo.png" alt="录取啦" title="录取啦" />      
      </a>
      <span class="location">
        <span>地区：</span>
        <a href="javascript:void(0);" id="showHeaderProvince">
          <span id="headerProvince">请选择</span><em class="icon sarrow_down"></em>
        </a>
        <span>年级：</span>
        <a href="javascript:void(0);" id="showHeaderGrade">
          <span id="headerGrade">请选择</span><em class="icon sarrow_down"></em>
        </a>
      </span>
      <div id="headerProvinceList" class="popup_location" style="display:none;"> <em class="icon iarrow"></em>
        <div class="padding">
          <div class="box">
            
          </div>
          <div class="align_center">
            <a href="javascript:void(0);"> <em class="icon iarrow_down"></em>
            </a>
          </div>
          <div class="box">
            
          </div>
        </div>
      </div>
      <div id="headerGradeList" class="popup_senior" style="display:none;"> <em class="icon iarrow"></em>
        <div class="padding">
          <div class="box">
          </div>
        </div>
      </div>
    </div>
    <div class="clear">&nbsp;</div>
  </div>
</div>


<div class="nav">
  <div class="contain">
    <div class="right">
      <div class="search blue_border"><a href="javascript:void(0);" ><em class="icon isearch"></em></a>
        <input id="searchInput" type="text" placeholder="学校、专业、地区" />
        <div class="popup_search" id="searchPopup" style="display:none;"> <em class="icon iarrow"></em>
          <div class="padding">
            <div class="top" id="searchTopic" style="cursor:pointer;" >
              搜<span class="red"></span>相关话题
            </div>
            <hr />
            <div class="content">
              <div id="searchArticle" style="cursor:pointer;" >
                搜<span class="red"></span>相关文章
              </div>
              <div class="related">
                <ul id="searchArticleResult">
                  
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div id="topicTypeList" class="left">
     
    </div>
    <div class="clear">&nbsp;</div>
  </div>
</div>

<script type="text/javascript">
var sysTopicTypes;
$.get("ajaxTopicType",function(data){
    sysTopicTypes = eval("(" + data + ")");
    renderTopicTypeList();
});

$(provinceArray).map(function(){
  if (this.parentid == 0) {
    $("#headerProvinceList .box:eq(0)").append('<a href="javascript:void(0);" data-id="' + this.id + '" data-parentid="' + this.parentid + '">' + this.name + '</a>');
  } else {
    $("#headerProvinceList .box:eq(1)").append('<a href="javascript:void(0);" data-id="' + this.id + '" data-parentid="' + this.parentid + '" style="display:none;">' + this.name + '</a>');
  }
  
  if(this.id == userInfo.province){
    $("#headerProvince").html(this.name);
  }
});

$(gradeArray).map(function() {
  $("#headerGradeList .box:eq(0)").append('<a href="javascript:void(0);" data-id="' + this.id + '" >' + this.name + '</a>');

  if (this.id == userInfo.grade) {
    $("#headerGrade").html(this.name);
  }
});

$("#showHeaderProvince").click(function(){
  $("#showHeaderGrade").removeClass("red");
  $("#headerGradeList").hide();
  $(this).addClass("red");

  var p = $("#headerProvinceList .box a[data-id="+userInfo.province+"]").addClass("active").attr("data-parentid");
  $("#headerProvinceList .box a[data-id="+p+"]").addClass("active").click();

  $("#headerProvinceList").show();
});

$("#showHeaderGrade").click(function(){
  $("#showHeaderProvince").removeClass("red");
  $("#headerProvinceList").hide();
  $(this).addClass("red");

  $("#headerGradeList .box a[data-id="+userInfo.grade+"]").addClass("active");

  $("#headerGradeList").show();
});

$("#headerProvinceList a").click(function(){
  if($(this).attr("data-parentid") == 0){
      $(this).addClass("active").siblings().removeClass("active");
      $("#headerProvinceList .box a[data-parentid!=0]").hide();
      $("#headerProvinceList .box a[data-parentid="+$(this).attr("data-id")+"]").show();
  }else{
      userInfo.province = $(this).attr("data-id");
      setCookie();
  }
});

$("#headerGradeList a").click(function(){
  userInfo.grade = $(this).attr("data-id");
  setCookie();
});

$("#headerProvinceList").mouseleave(function(){
  $(this).hide();
  $("#showHeaderProvince").removeClass("red");
});

$("#headerGradeList").mouseleave(function(){
  $(this).hide();
  $("#showHeaderGrade").removeClass("red");
});

function renderTopicTypeList(){
    var obj = $("#topicTypeList").empty();

    $(sysTopicTypes).map(function() {
        var link = $("<a></a>").attr({
            "href": this.icon ? "index?m=topic/"+this.icon:"index"
        }).html(this.typename).appendTo(obj);

        if (this.icon && location.search.indexOf(this.icon) > -1) {
          link.addClass("active");
        }
    });
}

$("#searchInput").keyup(function() {
  if ($(this).val().replace(" ", "") != "") {
    $("#searchTopic .red,#searchArticle .red").html($(this).val());
    $("#searchArticleResult").empty();
    var searchContent = $(this).val();
    $.get("ajaxSearchArticle?searchContent=" + searchContent, function(data) {
      data = eval("(" + data + ")");
      $(data).map(function() {
        $("#searchArticleResult").append('<li style="cursor:pointer;" onclick="location.href=\'index?m=article/detailWebArticle?id='+this.id+'\'">' + this.title.replace(searchContent, '<span class="red">' + searchContent + '</span>') + '</li>');
      });
    });
    $("#searchPopup").show();
  } else {
    $("#searchPopup").hide();
  }
});
$("#searchInput").blur(function(){
  setTimeout(function(){
    $(this).val("");
    $("#searchPopup").hide();
  },500);
});

$("#searchArticle").click(function(){
  location.href = "index?m=article/search?searchContent="+$("#searchInput").val();
});

$("#searchTopic").click(function(){
  location.href = "index?m=topic/search?searchContent="+$("#searchInput").val();
});

$("#btn_login").click(function(){
  showShadow("login");
  $("#login").show();
});

$("#loginname,#password,#register_email,#register_name,#register_password").focus(function(){
  $(".input").removeClass("blue_border");
  $(this).parents(".input").eq(0).addClass("blue_border");
});

$("#loginSubmit").click(function(){
  $.post("ajaxLogin",{
    loginname:$("#loginname").val(),
    password:$("#password").val()
  },function(data){
    if(data == "0"){
      $("#login [data-role=message]").show();
    }else{
      location.reload();
    }
  });
});

$("#btn_logout").click(function(){
  $.post("ajaxLogout",function(){
    location.href = "index";
  });
});

$("#btn_register").click(function(){
  showShadow("register");
  $("#register").show();
});

$("#registerSubmit").click(function() {
  $.post("ajaxRegister", {
    loginname: $("#register_email").val(),
    password: $("#register_password").val(),
    name: $("#register_name").val()
  }, function(data) {
    if (data == "0") {
      $("#register [data-role=message]").show();
    } else {
      location.reload();
    }
  });
});


$("#register_province_btn").click(function(){
    $("#register_province_popup").toggle();
});

$("#register_province_popup a").click(function(){
  $(this).addClass("active").siblings().removeClass("active");
  if($(this).attr("data-parentid") == 0){
      $("#register_province_popup .box a[data-parentid!=0]").hide();
      $("#register_province_popup .box a[data-parentid="+$(this).attr("data-id")+"]").show();
  }else{
      $("#register_province").html($(this).html()).data("province",$(this).attr("data-id"));
      $("#register_province_popup").hide();
  }
});

$("#register_grade_btn").click(function() {
  var obj = $("#register_grade");
  if (obj.find("input").size() > 0) {
    obj.html(obj.find("input").val());
  } else {
    obj.html("<input type='text' value='" + obj.html() + "' style='width:110px' />");
    obj.find("input").focus();
    obj.find("input").blur(function(){
      $("#register_grade_btn").click();
    });
  }
});

$("#forgetpw").click(function(){
  $("#shadow").click();
  showShadow("reset");
  $("#reset").show();
});

$("#resetSubmit").click(function(){
  $("#reset .red[data-role=randomCode]").hide();
  $("#reset .red[data-role=email]").hide();

  $.post("ajaxResetPW",{
    loginname:$("#resetemail").val(),
    password:$("#resetrandom").val()
  },function(data){
    if(data == 1){
      location.href = "index";
    }else if(data == -1){
      $("#reset .red[data-role=randomCode]").show();
    }else if(data == -2){
      $("#reset .red[data-role=email]").html("邮箱输入的格式不正确！").show();
    }else if(data == -3){
      $("#reset .red[data-role=email]").html("邮箱未验证！").show();
    }
  });
});
</script>