<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container container2">
  <div class="contain">
    <div class="rightsidebar">
      <div id="userInfo"></div>
       <!--分类 start-->
      <div class="block">
        <div class="title"><em class="icon ic"></em><h1>分类</h1></div>
        <div class="content">
          <div class="link link3">
            <s:iterator value="listWebFavs" var="item" status="s">
              <a data-role="webFav" data-id="${item.id}" href="javascript:void(0);">${item.name}</a>
            </s:iterator>
          </div>
        </div>
      </div>
      <!--分类 end--> 
    </div>
    
    <!--leftcontent start-->
    <div class="leftcontent"> 
      <div class="title"><em class="icon if"></em><h1>收藏</h1></div>

      <div id="listArticle"></div>
    </div>
    <!--leftcontent end-->
    <div class="clear">&nbsp;</div>
  </div>
</div>
<script type="text/javascript">
$("#userInfo").load("userInfo");
$("a[data-role=webFav]").click(function(){
  $(this).addClass("active").siblings().removeClass("active");
  var url = "article/listWebArticle?fav="+$(this).attr("data-id");
  $("#listArticle").load(url).data("url",url);
}).eq(0).click();
</script>