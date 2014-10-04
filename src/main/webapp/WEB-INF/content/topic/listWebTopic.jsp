<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

 <div class="university">
 <s:iterator value="listWebTopics" var="item" status="s">
   <div class="layer" data-id="${item.id}" onclick="location.href='index?m=topic/detailWebTopic?id=${item.id}'">
     <div class="gray_title">
       <h1 class="red2">${item.name}</h1>
       <div class="describe">
         <p class="red2">
           <a href="javascript:void(0);">${item.introduction}</a>
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
           <img width="80" src="download?c=${item.topicphoto}" /> 
         </a>
       </div>
       <div class="clear">&nbsp;</div>
     </div>
   </div>
 </s:iterator>
</div>


<!--pavigation start-->
  <div id="pager"></div>
<!--pavigation end-->

 <script type="text/javascript">

$("#pager").pager($("#listTopic").data("url"),"listTopic",${startIndex},${pageSize},${count},1);

$("#listTopic .layer").each(function(index,element){
  $.get("ajaxTopicDetail?id="+$(element).attr("data-id"), function(data) {
    data = eval("(" + data + ")");
    if(data.last){
      $(element).find("a[data-role=lastArticle]").html(data.last.title).attr("href","index?m=article/detailWebArticle?id="+data.last.id);
    }
    if(data.hot){
      $(element).find("a[data-role=hotArticle]").html(data.hot.title).attr("href","index?m=article/detailWebArticle?id="+data.hot.id);
    }
  });
});

 </script>