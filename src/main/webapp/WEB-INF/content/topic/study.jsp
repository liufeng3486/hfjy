<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container container2">
  <div class="contain">
    <div class="rightsidebar"> 
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
      <div class="title"><em class="icon is"></em><h1>学习</h1></div>
      <div id="listTopic"></div>
    </div>
    <!--leftcontent end-->
    <div class="clear">&nbsp;</div>
  </div>
</div>

<script type="text/javascript">
$("#listTopic").data("url","topic/listWebTopic?typeid=4").load("topic/listWebTopic?typeid=4");

for (var i = 0; i < 26; i++) {
  var link = $('<a href="javascript:void(0);" data-role="pinyin">' + String.fromCharCode((65 + i)) + '</a>');
  $("#listPinyin").append(link);
}
$("a[data-role=pinyin]").click(function(){
  $(this).toggleClass("active");
  searchTopic();
});
function searchTopic(){
  var pinyin = $("a[data-role=pinyin].active").map(function() {
    return "'"+$(this).html()+"'";
  }).get().join(",");
  var url = "topic/listWebTopic?typeid=4";
  if (pinyin) {
    url += "&pinyin=" + pinyin;
  }
  $("#listTopic").data("url",url).load(url);
}
</script> 