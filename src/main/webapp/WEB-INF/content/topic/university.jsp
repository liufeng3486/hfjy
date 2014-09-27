<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container container2">
  <div class="contain">
    <div class="rightsidebar">
      <!--省份 start-->
      <div class="block">
        <div class="title"><em class="icon ip"></em><h1>省份</h1></div>
        <div class="content">
          <div class="link">
            <a href="javascript:void(0);">天津</a><a href="javascript:void(0);" >辽宁</a><a href="javascript:void(0);">福建</a><a href="javascript:void(0);">河南</a><a href="javascript:void(0);">北京</a><a href="javascript:void(0);">天津</a><a href="javascript:void(0);" >辽宁</a><a href="javascript:void(0);">福建</a><a href="javascript:void(0);">河南</a><a href="javascript:void(0);">北京</a><a href="javascript:void(0);">天津</a><a href="javascript:void(0);" >辽宁</a><a href="javascript:void(0);">福建</a><a href="javascript:void(0);">河南</a><a href="javascript:void(0);">北京</a><a href="javascript:void(0);">天津</a><a href="javascript:void(0);" >辽宁</a><a href="javascript:void(0);">福建</a><a href="javascript:void(0);">河南</a><a href="javascript:void(0);">北京</a><a href="javascript:void(0);" class="active">上海</a><a href="javascript:void(0);">天津</a><a href="javascript:void(0);" >辽宁</a><a href="javascript:void(0);">福建</a><a href="javascript:void(0);">河南</a><a href="javascript:void(0);">北京</a><a href="javascript:void(0);">天津</a><a href="javascript:void(0);" >辽宁</a><a href="javascript:void(0);">福建</a><a href="javascript:void(0);">河南</a><a href="javascript:void(0);">北京</a><a href="javascript:void(0);" >辽宁</a><a href="javascript:void(0);">福建</a><a href="javascript:void(0);">河南</a><a href="javascript:void(0);">黑龙江</a>
          </div>
        </div>
      </div>
      <!--省份 end--> 
      <!--类型 start-->
      <div class="block">
        <div class="title"><em class="icon it"></em><h1>类型</h1></div>
        <div class="content">
          <div class="link">
            <a href="javascript:void(0);">综合</a><a href="javascript:void(0);" >体育</a><a href="javascript:void(0);">军事</a><a href="javascript:void(0);">师范</a><a href="javascript:void(0);">财经</a><a href="javascript:void(0);">政法</a><a href="javascript:void(0);" >医药</a><a href="javascript:void(0);">财政</a><a href="javascript:void(0);">商学院</a><a href="javascript:void(0);">农林</a><a href="javascript:void(0);">伊苏</a><a href="javascript:void(0);" >民族</a><a href="javascript:void(0);">语言</a></div>
        </div>
      </div>
      <!--类型 end--> 
      <!--拼音 start-->
      <div class="block">
        <div class="title"><em class="icon is"></em><h1>拼音</h1></div>
        <div class="content">
          <div class="link link2">
            <a href="javascript:void(0);">A</a><a href="javascript:void(0);" >B</a><a href="javascript:void(0);">C</a><a href="javascript:void(0);">D</a><a href="javascript:void(0);">E</a><a href="javascript:void(0);">F</a><a href="javascript:void(0);" >G</a><a href="javascript:void(0);">H</a><a href="javascript:void(0);">I</a><a href="javascript:void(0);">J</a><a href="javascript:void(0);">K</a><a href="javascript:void(0);" >L</a><a href="javascript:void(0);">M</a><a href="javascript:void(0);">N</a><a href="javascript:void(0);" >O</a><a href="javascript:void(0);">P</a><a href="javascript:void(0);">Q</a><a href="javascript:void(0);">R</a><a href="javascript:void(0);">S</a><a href="javascript:void(0);" >T</a><a href="javascript:void(0);">U</a><a href="javascript:void(0);">V</a><a href="javascript:void(0);">W</a><a href="javascript:void(0);">X</a><a href="javascript:void(0);" >Y</a><a href="javascript:void(0);">Z</a></div>
        </div>
      </div>
      <!--拼音 end-->       
      <!--层次 start-->
      <div class="block">
        <div class="title"><em class="icon il"></em><h1>层次</h1></div>
        <div class="content">
          <div class="link">
            <a href="javascript:void(0);" >911</a><a href="javascript:void(0);">211</a></div>
        </div>
      </div>
      <!--层次 end--> 
    </div>
    <!--leftcontent start-->
    <div class="leftcontent"> 
      <div class="title"><em class="icon iu"></em><h1>学校</h1></div>
      <div id="university" class="university">
        <s:iterator value="listWebTopics" var="item" status="s">
          <div class="layer" data-id="${item.id}">
            <div class="gray_title">
              <h1 class="red2">${item.name}</h1>
              <div class="describe">
                <p class="red2">
                  <a href="javascript:void(0);">${item.introduction}</a>
                </p>
              </div>
            </div>
            <div class="padding">
              <div class="right">
                <div class="describe">
                  <h2>最新文章</h2>
                  <p>
                    <a href="javascript:void(0);" data-role="lastArticle"></a>
                  </p>
                </div>
                <hr />        
                <div class="describe">
                  <h2>重点资讯</h2>
                  <p>
                    <a href="javascript:void(0);" data-role="hotArticle"></a>
                  </p>
                </div>
              </div>
              <div class="left">
                <a href="javascript:void(0);">
                  <img width="80" src="download?c=${item.topicphoto}" />        
                </a>
              </div>
              <div class="clear">&nbsp;</div>
            </div>
          </div>
        </s:iterator>
      </div>
      <!--pavigation start-->
      <div class="pavigation">
        <div class="gray align_right">1/10</div>
        <div class="btn_group"><a href="javascript:void(0);" class="btn right">下一页&nbsp;&gt;</a> <a href="javascript:void(0);" class="btn  unactive left">&lt;&nbsp;上一页</a>
          <div class="clear">&nbsp;</div>
        </div>
      </div>
      <!--pavigation end--> 
    </div>
    <!--leftcontent end-->
    <div class="clear">&nbsp;</div>
  </div>
</div>

<script type="text/javascript">
$("#university .layer").each(function(index,element){
  $.get("ajaxTopicDetail?id="+$(element).attr("data-id"), function(data) {
    data = eval("(" + data + ")");
    if(data.last){
      $(element).find("a[data-role=lastArticle]").html(data.last.title).attr("href","index?m=article/detailWebArticle?id="+data.last.id);
    }
    if(data.hot){
      $(element).find("a[data-role=hotArticle]").html(data.hot.title).attr("href","index?m=article/detailWebArticle?id="+data.hot.id);
    }
  });
});
</script>