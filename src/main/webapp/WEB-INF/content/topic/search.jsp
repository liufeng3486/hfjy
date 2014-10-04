<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container">
    <div class="contain">
        <div id="right" class="rightsidebar"></div>

        <div class="leftcontent">
            <div class="bsearch">
                <a href="javascript:void(0);" id="searchButton"> <em class="icon ibsearch"></em>
                </a>
                <input id="searchContent" type="text" value="${searchContent}" />
            </div>
            <div class="bsearch_result">
                你搜索的<span class="red">${searchContent}</span>，共有
                <span class="red">${count}</span>个相关话题：
            </div>

            <div id="listTopic"></div>
        </div>

         <div class="clear">&nbsp;</div>
    </div>
</div>

<script type="text/javascript">
$("#right").load("right");
var url = "topic/listWebTopic?searchContent=${searchContent}";
$("#listTopic").load(url).data("url",url);

$("#searchButton").click(function(){
    location.href = "index?m=topic/search?searchContent="+$("#searchContent").val();
});
</script>