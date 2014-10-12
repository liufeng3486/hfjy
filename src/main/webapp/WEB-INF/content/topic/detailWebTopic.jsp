<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container">
  <div class="contain">
    <div id="right" class="rightsidebar"></div>
    <!--leftcontent start-->
    <div class="leftcontent">
      <!--subject start-->
      <div class="subject">
        <div class="banner">
          <img src="download?c=${webTopic.topicimg}" />
        </div>

        <div class="content">
          <div id="description" class="right" >
            <h1>${webTopic.name}</h1>
            <p>${webTopic.introduction}</p>
            <hr />
            <p style="text-align:right;"><a id="showAll" style="display:none;" href="javascript:void(0)">显示全部</a></p>
            <div>
              ${webTopic.description}
            </div>
          </div>
          <div class="left">
            <div class="logo align_center">
              <img width="85" src="download?c=${webTopic.topicphoto}" />
            </div>
            <span class="count">
              <span class="red">${articleCount}</span>
              <span>文章</span>
            </span>
            <span class="count">
              <span class="red">${userCount}</span>
              <span>关注者</span>
            </span>
            <div class="align_center">
              <s:if test="webTopic.protype==1">
                <a href="javascript:void(0);" class="btn btn_white" data-role="focus" data-id="${webTopic.id}">已关注</a>
              </s:if>
              <s:else>
                <a href="javascript:void(0);" class="btn btn_white" data-role="focus" data-id="${webTopic.id}">
                  <span class="red">+</span>
                  &nbsp;关注
                </a>
              </s:else>
            </div>
          </div>
          <div class="clear">&nbsp;</div>
        </div>
      </div>
      <!--subject end-->
      <div id="listArticle"></div>
    </div>
    <!--leftcontent end-->
    <div class="clear">&nbsp;</div>
  </div>
</div>

<script type="text/javascript">
$("#right").load("right");
var url = "article/listWebArticle?topicid=${webTopic.id}";
$("#listArticle").load(url).data("url",url);

if ($("#description").innerHeight() < $("#description")[0].scrollHeight) {
  $("#showAll").show().click(function(){
    $("#description").toggleClass("active");
  });
}
</script>