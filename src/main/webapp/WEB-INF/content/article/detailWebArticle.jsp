<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container">
  <div class="contain">
    <div id="right" class="rightsidebar"></div>

    <!--leftcontent start-->
    <div class="leftcontent">
      <div class="passage">
        <div class="block">
          <div class="align_center">
            <img src="download?c=${webArticle.articleimg}" />
          </div>
          <div class="padding">
            <h1>${webArticle.title}</h1>
            <div class="tag">
              <div  class="right">
                <a href="javascript:void(0);"> <em class="icon ifavorite"></em>
                </a>
              </div>
              <div class="left">
                <s:iterator value="webArticle.webTopics" var="item" status="s">
                  <a href="javascript:void(0);" class="btn btn_white" data-role="webTopic">${item.name}</a>
                </s:iterator>
              </div>
              <div class="clear">&nbsp;</div>
            </div>
            <div classs="content">
              ${webArticle.articlecontent}
              <div class="plus">
                <span class="time">
                  <s:date name="webArticle.publishdate" format="HH:mm  M.dd"/>
                </span>
                <span class="gray">${webArticle.author}</span>
              </div>
            </div>
            <div class="share">
              <div class="right">
                <a href="javascript:void(0);"> <em class="icon sweixin"></em>
                </a>
                <a href="javascript:void(0);">
                  <em class="icon sqzone"></em>
                </a>
                <a href="javascript:void(0);">
                  <em class="icon sweibo"></em>
                </a>
                <a href="javascript:void(0);">
                  <em class="icon srenren"></em>
                </a>
                <a href="javascript:void(0);">
                  <em class="icon sqq"></em>
                </a>
              </div>
              <div class="left">
                <s:if test="ifFav==1">
                  <a id="btn_removefav" href="javascript:void(0);" class="active"> <em class="icon ifavorite"></em>
                  </a>
                </s:if>
                <s:else>
                  <a id="btn_addfav" href="javascript:void(0);"> <em class="icon ifavorite"></em>
                  </a>
                </s:else>
                
                <div id="popup_favorite" class="popup_favorite" style="display:none;">
                  <em class="icon iarrow"></em>
                  <div class="padding">
                    <div>收藏到话题</div>
                    <hr />
                    <div class="tag">
                       <s:iterator value="listWebFavs" var="item" status="s">
                          <a data-role="webFav" href="javascript:void(0);" class="btn btn_white">${item.name}</a>
                      </s:iterator>
                    </div>
                    <div>收藏到新话题</div>
                    <input id="favName" type="text" placeholder="输入新话题名称" />

                    <hr />
                    <div class="align_center">
                      <a id="favoriteSubmit" class="btn btn_red" href="javascript:void(0);">收藏</a>
                    </div>
                  </div>
                </div>
              </div>

              <div class="clear">&nbsp;</div>
            </div>
          </div>
        </div>
        <div class="block show">
          <div class="padding">
            <s:iterator value="listWebArticles" var="item" status="s">
              <a href="javascript:void(0);">
                <div>
                  <img width="180" src="download?c=${item.articlephoto}" />
                </div>
                <div>${item.title}</div>
              </a>
            </s:iterator>
          </div>
        </div>
      </div>
    </div>

  </div>
</div>

<script type="text/javascript">
$("#right").load("right");
$("#btn_addfav").click(function(){
  $("#popup_favorite").show();
});

$("#btn_removefav").click(function(){
  $.post("ajaxRemoveFavArticle", {
    id: '${id}'
  }, function(data) {
    if (data == "1") {
      location.reload();
    }
  });
});

$("#favoriteSubmit").click(function(){
  $.post("ajaxAddFavArticle",{
    id:'${id}',
    name:$("#favName").val()
  },function(data){
    if(data == "1"){
      location.reload();
    }
  });
});

$("a[data-role=webFav]").click(function(){
  $("#favName").val($(this).html()).focus();
});
</script>