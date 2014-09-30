<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="header clearfix">
  <div class="contain">
    <div class="right">
      <a href="javascript:void(0);" id="btn_login">登录</a>
      <a href="javascript:void(0);">注册</a>
    </div>

    <div class="left">
      <a href="index">
        <img src="images/logo.png" alt="录取啦" title="录取啦" />      
      </a>
      <span class="location">
        <span>地区：</span>
        <a href="javascript:void(0);" class="red">
          乌鲁木齐 <em class="icon sarrow_down"></em>
        </a>
        <span>年级：</span>
        <a href="javascript:void(0);">
          高三 <em class="icon sarrow_down"></em>
        </a>
      </span>
      <div class="popup_location" style="display:none;"> <em class="icon iarrow"></em>
        <div class="padding">
          <div class="box"><a href="javascript:void(0);">华东</a><a href="javascript:void(0);" class="active">华南</a><a href="javascript:void(0);">华北</a><a href="javascript:void(0);">西北</a><a href="javascript:void(0);">东北</a><a href="javascript:void(0);">港澳台</a><a href="javascript:void(0);">华北</a><a href="javascript:void(0);">西北</a><a href="javascript:void(0);">东北</a><a href="javascript:void(0);">港澳台</a></div>
          <div class="align_center"><a href="javascript:void(0);"><em class="icon iarrow_down"></em></a></div>
          <div class="box"><a href="javascript:void(0);" class="active">上海</a><a href="javascript:void(0);">北京</a><a href="javascript:void(0);">杭州</a><a href="javascript:void(0);">天津</a><a href="javascript:void(0);">苏州</a><a href="javascript:void(0);">浙江</a></div>
        </div>
      </div>
      <div class="popup_senior" style="display:none;"> <em class="icon iarrow"></em>
        <div class="padding">
          <div class=""><a href="javascript:void(0);">高一</a><a href="javascript:void(0);" class="active">高二</a><a href="javascript:void(0);">高三</a></div>
        </div>
      </div>
    </div>
    <div class="clear">&nbsp;</div>
  </div>
</div>


<div class="nav">
  <div class="contain">
    <div class="right">
      <div class="search blue_border"><a href="javascript:void(0);" ><em class="icon isearch"></em></a>
        <input id="searchInput" type="text" placeholder="学校、专业、地区" />
        <div class="popup_search" id="searchPopup" style="display:none;"> <em class="icon iarrow"></em>
          <div class="padding">
            <div class="top" id="searchTopic" style="cursor:pointer;" >
              搜<span class="red"></span>相关话题
            </div>
            <hr />            
            <div class="content">
              <div id="searchArticle" style="cursor:pointer;" >
                搜<span class="red"></span>相关文章
              </div>
              <div class="related">
                <ul id="searchArticleResult">
                  
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div id="topicTypeList" class="left">
     
    </div>
    <div class="clear">&nbsp;</div>
  </div>
</div>

<script type="text/javascript">
var sysTopicTypes;
$.get("ajaxTopicType",function(data){
    sysTopicTypes = eval("(" + data + ")");
    renderTopicTypeList();
});

function renderTopicTypeList(){
    var obj = $("#topicTypeList").empty();

    $(sysTopicTypes).map(function() {
        var link = $("<a></a>").attr({
            "href": this.icon ? "index?m=topic/"+this.icon:"index"
        }).html(this.typename).appendTo(obj);

        if (this.icon && location.search.indexOf(this.icon) > -1) {
          link.addClass("active");
        }
    });
}

$("#searchInput").keyup(function() {
  if ($(this).val().replace(" ", "") != "") {
    $("#searchTopic .red,#searchArticle .red").html($(this).val());
    $("#searchArticleResult").empty();
    var searchContent = $(this).val();
    $.get("ajaxSearchArticle?searchContent=" + searchContent, function(data) {
      data = eval("(" + data + ")");
      $(data).map(function() {
        $("#searchArticleResult").append('<li style="cursor:pointer;" onclick="location.href=\'index?m=article/detailWebArticle?id='+this.id+'\'">' + this.title.replace(searchContent, '<span class="red">' + searchContent + '</span>') + '</li>');
      });
    });
    $("#searchPopup").show();
  } else {
    $("#searchPopup").hide();
  }
});
$("#searchInput").blur(function(){
  setTimeout(function(){
    $(this).val("");
    $("#searchPopup").hide();
  },500);
});

$("#searchArticle").click(function(){
  location.href = "index?m=article/search?searchContent="+$("#searchInput").val();
});
</script>