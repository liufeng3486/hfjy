<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container container2">
  <div class="contain">
    <div class="rightsidebar"> 
       <!--学科 start-->
      <div class="block">
        <div class="title"><em class="icon is"></em><h1>学科</h1></div>
        <div class="content">
          <div class="link link3">
            <s:iterator value="listSubjecttypes" var="item" status="s">
              <a href="javascript:void(0);" data-id="${item.dickey}" data-role="subjecttype">${item.dicvalue}</a>
            </s:iterator>
          </div>
        </div>
      </div>
      <!--学科 end--> 
      <!--专业类别 start-->
      <div class="block">
        <div class="title"> <em class="icon ic"></em>
          <h1>专业类别</h1>
        </div>
        <div class="content">
          <div class="link link4">
            <s:iterator value="listParentTopics" var="item" status="s">
              <a href="javascript:void(0);" data-id="${item.id}" data-role="parentid">${item.name}</a>
            </s:iterator>
          </div>
        </div>
      </div>
      <!--专业类别 end-->
      <!--拼音 start-->
      <div class="block">
        <div class="title"><em class="icon is"></em><h1>拼音</h1></div>
        <div class="content">
          <div id="listPinyin" class="link link2">
          </div>
        </div>
      </div>
      <!--拼音 end-->       
      
    </div>
    <!--leftcontent start-->
    <div class="leftcontent"> 
      <div class="title"><em class="icon ic"></em><h1>专业类别</h1></div>
      <div id="listMajor"></div> 
      <div class="btn_choice align_center"><a href="javascript:void(0);"><em class="icon ibarrow_down"></em></a></div>
      <div class="title"><em class="icon in"></em><h1>专业名称</h1></div> 
      <div id="listTopic"></div>
    </div>
    <!--leftcontent end-->
    <div class="clear">&nbsp;</div>
  </div>
</div>

<script type="text/javascript">
$("#listTopic").data("url","topic/listWebTopic?typeid=2").load("topic/listWebTopic?typeid=2");
$("#listMajor").data("url","topic/listMajor?typeid=2").load("topic/listMajor?typeid=2");

for (var i = 0; i < 26; i++) {
  var link = $('<a href="javascript:void(0);" data-role="pinyin">' + String.fromCharCode((65 + i)) + '</a>');
  $("#listPinyin").append(link);
}
$("a[data-role=pinyin]").click(function(){
  $(this).toggleClass("active");
  searchTopic();
  searchMajor();
});

$("a[data-role=subjecttype]").click(function(){
  $(this).toggleClass("active");
  searchMajor();
});

$("a[data-role=parentid]").click(function(){
  $(this).toggleClass("active");
  searchTopic();
});

function searchTopic() {
  var pinyin = $("a[data-role=pinyin].active").map(function() {
    return "'" + $(this).html() + "'";
  }).get().join(",");
  var parentid = $("a[data-role=parentid].active").map(function() {
    return $(this).attr("data-id");
  }).get().join(",");
  var url = "topic/listWebTopic?typeid=2";
  if (pinyin) {
    url += "&pinyin=" + pinyin;
  }
    if (parentid) {
    url += "&parentid=" + parentid;
  }
  $("#listTopic").data("url", url).load(url);
}

function searchMajor() {
  var pinyin = $("a[data-role=pinyin].active").map(function() {
    return "'" + $(this).html() + "'";
  }).get().join(",");
  var subjecttype = $("a[data-role=subjecttype].active").map(function() {
    return $(this).attr("data-id");
  }).get().join(",");
  var url = "topic/listMajor?typeid=2";
  if (pinyin) {
    url += "&pinyin=" + pinyin;
  }
  if (subjecttype) {
    url += "&subjecttype=" + subjecttype;
  }
  $("#listMajor").data("url", url).load(url);
}
</script> 