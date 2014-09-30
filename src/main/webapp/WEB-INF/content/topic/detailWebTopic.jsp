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
          <div class="right active" >
            <h1>${webTopic.name}</h1>
            <p>${webTopic.introduction}</p>
            <hr />
            <div>
              ${webTopic.description}
            </div>
          </div>
          <div class="left">
            <div class="logo align_center">
              <img src="images/icon/orange_fudan_logo.png" />
            </div>
            <span class="count">
              <span class="red">123</span>
              <span>文章</span>
            </span>
            <span class="count">
              <span class="red">6789</span>
              <span>关注者</span>
            </span>
            <div class="align_center">
              <a href="javascript:void(0);" class="btn btn_white">
                <span class="red">&plus;</span>
                关注
              </a>
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
</script>