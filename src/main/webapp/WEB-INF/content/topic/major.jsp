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
              <a style="display:none" href="javascript:void(0);" data-id="${item.id}" data-role="parentid" data-type="${subjecttype}">${item.name}</a>
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
      <div id="showMajor">
         <div class="university">
           <div class="layer" style="display:none;">
             <div class="gray_title">
               <h1 class="red2" data-role="name"></h1>
               <div class="describe">
                 <p class="red2">
                   <a href="javascript:void(0);" data-role="introduction"></a>
                 </p>
               </div>
             </div>
             <div class="padding">
               <div class="right">
                 <div class="describe">
                   <h2>最新文章</h2>
                   <p>
                     <a href="javascript:void(0);" data-role="lastArticle"></a>
                   </p>
                 </div>
                 <hr />         
                 <div class="describe">
                   <h2>重点资讯</h2>
                   <p>
                     <a href="javascript:void(0);" data-role="hotArticle"></a>
                   </p>
                 </div>
               </div>
               <div class="left">
                 <a href="javascript:void(0);">
                   <img width="80" data-role="topicphoto" src="" />         
                 </a>
               </div>
               <div class="clear">&nbsp;</div>
             </div>
           </div>
         </div>
      </div> 
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
});

$("a[data-role=parentid]").click(function(){
  $(this).addClass("active").siblings().removeClass("active");
  showMajor();
  searchTopic();
});

$("a[data-role=subjecttype]").click(function(){
  $(this).addClass("active").siblings().removeClass("active");
  $("a[data-role=parentid]").removeClass("active").hide();
  $("a[data-role=parentid][data-type='"+$(this).attr("data-id")+"']").show().eq(0).click();
}).eq(0).click();

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

function showMajor(){
  var obj = $("#showMajor .layer").hide().attr("data-id",$("a[data-role=parentid].active").attr("data-id"));

  $.get("ajaxTopicDetail?id="+$(obj).attr("data-id"), function(data) {
    data = eval("(" + data + ")");
    $(obj).unbind("click").bind("click",function(){
      location.href='index?m=topic/detailWebTopic?id='+$(obj).attr("data-id");
    });
    $(obj).find("[data-role=name]").html(data.item.name);
    $(obj).find("[data-role=introduction]").html(data.item.introduction);
    $(obj).find("[data-role=topicphoto]").attr("src","download?c="+data.item.topicphoto);

    if(data.last){
      $(obj).find("a[data-role=lastArticle]").html(data.last.title).attr("href","index?m=article/detailWebArticle?id="+data.last.id);
    }
    if(data.hot){
      $(obj).find("a[data-role=hotArticle]").html(data.hot.title).attr("href","index?m=article/detailWebArticle?id="+data.hot.id);
    }

    $(obj).show();
  });
}
</script> 