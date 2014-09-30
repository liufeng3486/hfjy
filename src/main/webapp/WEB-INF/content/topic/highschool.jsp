<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container container2">
  <div class="contain">
    <div class="rightsidebar">
      <!--省份 start-->
      <div class="block">
        <div class="title"><em class="icon ip"></em><h1>省份</h1></div>
        <div class="content">
          <div class="link">
            <s:iterator value="listSysProvinces" var="item" status="s">
              <a href="javascript:void(0);" data-id="${item.id}" data-role="province">${item.name}</a>
            </s:iterator>
          </div>
        </div>
      </div>
      <!--省份 end-->  
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
      <div class="title"><em class="icon ih"></em><h1>高中</h1></div>
      <div id="listTopic"></div>
    </div>
    <!--leftcontent end-->
    <div class="clear">&nbsp;</div>
  </div>
</div>

<script type="text/javascript">
$("#listTopic").data("url","topic/listWebTopic?typeid=3").load("topic/listWebTopic?typeid=3");

for (var i = 0; i < 26; i++) {
  var link = $('<a href="javascript:void(0);" data-role="pinyin">' + String.fromCharCode((65 + i)) + '</a>');
  $("#listPinyin").append(link);
}

$("a[data-role=province]").click(function(){
  $(this).toggleClass("active");
  searchTopic();
});
$("a[data-role=pinyin]").click(function(){
  $(this).toggleClass("active");
  searchTopic();
});
function searchTopic(){
  var province = $("a[data-role=province].active").map(function() {
    return $(this).attr("data-id");
  }).get().join(",");
  
  var pinyin = $("a[data-role=pinyin].active").map(function() {
    return "'"+$(this).html()+"'";
  }).get().join(",");
  var url = "topic/listWebTopic?typeid=3";
  if (province) {
    url += "&province=" + province;
  }
  if (pinyin) {
    url += "&pinyin=" + pinyin;
  }
  $("#listTopic").data("url",url).load(url);
}
</script> 