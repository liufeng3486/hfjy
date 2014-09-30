<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="tab_content">
  <s:iterator value="listWebArticles" var="item" status="s">
    <div class="layer">
      <div class="padding">
        <div class="right">
          <dl>
            <dt>
              <a href="index?m=article/detailWebArticle?id=${item.id}">${item.title}</a>
            </dt>
            <dd>
              <div class="tag">
              <s:iterator value="#item.webTopics" var="item1" status="s">
                <a href="javascript:void(0);" class="btn btn_white" data-role="webTopic">${item1.name}</a>
              </s:iterator>
            </div>
            </dd>
            <dd>
              <p>
                ${item.description}
              </p>
            </dd>
            <dd>
              <span class="time"><s:date name="#item.publishdate" format="HH:mm  M.dd"/></span>
              <span class="gray">${item.author}</span>
            </dd>
          </dl>
        </div>
        <div class="left">
        <a href="index?m=article/detailWebArticle?id=${item.id}">
          <img width="200" src="download?c=${item.articlephoto}" />
        </a>
      </div>
        <div class="clear">&nbsp;</div>
      </div>
    </div>
  </s:iterator>
</div>
<!--pavigation start-->
<div id="pager"></div>

<script type="text/javascript">
$("#pager").pager($("#listArticle").data("url"),"listArticle",${startIndex},${pageSize},${count},1);
</script>