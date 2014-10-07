<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!--人名 start-->      
<div class="block">
  <div class="title"> <em class="icon ii"></em>
    <h1>${userInfo.name}（用户名）</h1>
  </div>
  <div class="content">
    <div class="avator">
      <div class="padding">
        <div class="right">
          <a href="index?m=article/favArticle" class="count">
            <span class="red">${favarticleCount}</span>
            <span>收藏</span>
          </a>
          <a href="index?m=topic/focusTopic" class="count">
            <span class="red">${focusTopicCount}</span>
            <span>订阅</span>
          </a>
        </div>
        <img src="images/icon/avator.png" />      
        <div class="clear">&nbsp;</div>
      </div>
      <hr />      
      <div class="avator_content">
        <div class="padding">
          <dl>
            <dd>${userInfo.name}</dd>
            <dd>${userInfo.email}</dd>
          </dl>
          <hr />      
          <dl>
            <dd id="userInfo_province"></dd>
            <dd id="userInfo_grade"></dd>
          </dl>
          <hr />
          <dl>
            <dd>
              <a href="#">修改密码</a>
            </dd>
          </dl>
        </div>
      </div>
    </div>
  </div>
</div>
<!--人名 end-->
<script type="text/javascript">
$("#userInfo_province").html($("#headerProvince").html());
$("#userInfo_grade").html($("#headerGrade").html());
</script>