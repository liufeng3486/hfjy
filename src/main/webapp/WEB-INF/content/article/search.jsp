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
                <span class="red">${count}</span>篇相关文章：
            </div>

            <div id="listArticle"></div>
        </div>

         <div class="clear">&nbsp;</div>
    </div>
</div>
6
<script type="text/javascript">
$("#right").load("right");
var url = "article/listWebArticle?searchContent=${searchContent}";
$("#listArticle").load(url).data("url",url);

$("#searchButton").click(function(){
    location.href = "index?m=article/search?searchContent="+$("#searchContent").val();
});
</script>