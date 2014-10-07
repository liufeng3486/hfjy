<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container container2">
  <div class="contain">
    <div id="right" class="rightsidebar"> 

    </div>
    <!--leftcontent start-->
    <div class="leftcontent">
      <div class="title"><em class="icon it"></em>
        <h1>订阅的话题</h1>
      </div>
      <div class="block order" id="contact">
        <div class="content">
          <s:iterator value="listWebTopics" var="item" status="s">
            <div class="layer" data-id="${item.id}">
              <dl>
                <dt>
                  <a class="btn btn_white right" href="javascript:void(0);" data-role="focus" data-id="${item.id}">已关注</a>
                  <h2 onclick="location.href='index?m=topic/detailWebTopic?id=${item.id}'">${item.name}</h2>
                </dt>
                <dd>
                  <p>${item.introduction}</p>
                </dd>
              </dl>
              <a class="left" href="index?m=topic/detailWebTopic?id=${item.id}">
                <img width="60" title="${item.name}" alt="${item.name}" src="download?c=${item.topicphoto}" />          
              </a>
              <div class="clear">&nbsp;</div>
            </div>
          </s:iterator>

          <div class="clear">&nbsp;</div>
        </div>
      </div>
      <!--pavigation start-->
      <div id="pager" class="pavigation margin_l"></div>
      <!--pavigation end--> 
    </div>
    <!--leftcontent end-->
    <div class="clear">&nbsp;</div>
  </div>
</div>

<script type="text/javascript">
$("#right").load("userInfo");
$("#pager").pager("topic/focusTopic","content",${startIndex},${pageSize},${count},1);
</script>