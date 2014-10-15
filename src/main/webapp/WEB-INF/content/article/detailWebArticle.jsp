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
                  <s:if test="ifFav==1">
                    <a data-role="btn_removefav" href="javascript:void(0);" class="active"> <em class="icon ifavorite"></em>
                    </a>
                  </s:if>
                  <s:else>
                    <a data-role="btn_addfav" href="javascript:void(0);"> <em class="icon ifavorite"></em>
                    </a>
                  </s:else>
                  <div class="popup_favorite" style="display:none;left: 466px;"> <em class="icon iarrow"></em>
                    <div class="padding">
                      <div>收藏到话题</div>
                      <hr />                  
                      <div class="tag">
                        <s:iterator value="listWebFavs" var="item" status="s">
                          <a data-role="webFav" href="javascript:void(0);" class="btn btn_white">${item.name}</a>
                        </s:iterator>
                      </div>
                      <div>收藏到新话题</div>
                      <input data-role="favName" type="text" placeholder="输入新话题名称" />                  

                      <hr />                  
                      <div class="align_center">
                        <a data-role="favoriteSubmit" class="btn btn_red" href="javascript:void(0);">收藏</a>
                      </div>
                    </div>
                  </div>
              </div>
              <div class="left">
                <s:iterator value="webArticle.webTopics" var="item" status="s">
                  <a href="javascript:void(0);" class="btn btn_white" data-role="webTopic" data-id="${item.id}" data-introduction="${item.introduction}" data-topicphoto="${item.topicphoto}">${item.name}</a>
                </s:iterator>

                <div class="popup_tag" style="width: 310px;top:50px;display:none">
                  <em class="icon iarrow" style="width:14px;width: 40px;"></em>
                  <div class="padding">
                    <dl>
                      <dt>
                        <a data-role="focus" class="btn btn_white fr" href="javascript:void(0);"></a>
                        <h2 data-role="name"></h2>
                      </dt>
                      <dd>
                        <p data-role="introduction"></p>
                      </dd>
                    </dl>
                    <a class="left" href="javascript:void(0);" style="width:auto;">
                      <img width="60" data-role="topicphoto" />              
                    </a>
                    <div class="clear">&nbsp;</div>
                  </div>
                </div>

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
                  <a data-role="btn_removefav" href="javascript:void(0);" class="active"> <em class="icon ifavorite"></em>
                  </a>
                </s:if>
                <s:else>
                  <a data-role="btn_addfav" href="javascript:void(0);"> <em class="icon ifavorite"></em>
                  </a>
                </s:else>
              </div>

              <div class="clear">&nbsp;</div>

              <div class="popup_favorite" style="display:none;">
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
                    <input data-role="favName" type="text" placeholder="输入新话题名称" />

                    <hr />
                    <div class="align_center">
                      <a data-role="favoriteSubmit" class="btn btn_red" href="javascript:void(0);">收藏</a>
                    </div>
                  </div>
              </div>
            </div>
          </div>
        </div>
        <div class="block show">
          <div class="padding">
            <s:iterator value="listWebArticles" var="item" status="s">
              <a href="index?m=article/detailWebArticle?id=${item.id}">
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
$("a[data-role=btn_addfav]").click(function(){
  if($("#btn_logout").size() == 0){
    $("#btn_login").click();
    return false;
  }
  $(this).next(".popup_favorite").toggle();
});


$("a[data-role=btn_removefav").click(function(){
  $.post("ajaxRemoveFavArticle", {
    id: '${id}'
  }, function(data) {
    if (data == "1") {
      location.reload();
    }
  });
});

$("a[data-role=favoriteSubmit]").click(function(){
  var f = $(this).parents(".popup_favorite").find("[data-role=favName]").val();
  $.post("ajaxAddFavArticle",{
    id:'${id}',
    name:f
  },function(data){
    if(data == "1"){
      location.reload();
    }
  });
});

$("a[data-role=webFav]").click(function(){
  $(this).parents(".popup_favorite").find("[data-role=favName]").val($(this).html()).focus();
});

$("a[data-role=webTopic]").click(function() {
  if ($(this).hasClass("active")) {
    $(this).removeClass("active");
    $(this).siblings(".popup_tag").hide();
  } else {
    $("a[data-role=webTopic]").removeClass("active");
    $(".popup_tag").hide();
    $(this).addClass("active");
    var obj = $(this).siblings(".popup_tag");
    obj.find("[data-role=name]").html($(this).html());
    obj.find("[data-role=introduction]").html($(this).attr("data-introduction"));
    obj.find("[data-role=topicphoto]").attr({
      "src":"download?c="+$(this).attr("data-topicphoto"),
      "title":$(this).html(),
      "alt":$(this).html()
    });

    obj.find("[data-role=focus]").attr({
      "data-id":$(this).attr("data-id")
    });

    if($.inArray($(this).attr("data-id"), focusTopic) > -1){
      obj.find("[data-role=focus]").html("已关注");
    }else{
      obj.find("[data-role=focus]").html('<span class="red">+</span>&nbsp;关注');
    }

    obj.css("left", $(this).offset().left - $(this).parent().offset().left - 88 ).show();

  }
});
</script>