<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="container">
    <div class="contain">
        <div id="right" class="rightsidebar"></div>

        <!--leftcontent start-->
        <div class="leftcontent">
            <!--banner start-->
            <div class="banner">
                <div class="img">
                    <div class="right">
                        <a href="javascript:void(0);" class="layer">
                            <img src="images/img/banner1_small.png" />
                            <div class="shadow"></div>
                            <p>复旦大学2015年将增加招生500人，清华、浙大表示不会跟风</p>
                        </a>
                        <a href="javascript:void(0);" class="layer">
                            <img src="images/img/banner2_small.png" />
                            <div class="shadow"></div>
                            <p>基于知识型笔记的生产力工具，打造精华知识分享社区</p>
                        </a>
                        <a href="javascript:void(0);" class="layer">
                            <img src="images/img/banner3_small.png" />
                            <div class="shadow"></div>
                            <p>又一个打算用大数据预防疾病的项目——Google Bas-eline Study</p>
                        </a>
                    </div>
                    <div class="left">
                        <a href="javascript:void(0);">
                            <img src="images/img/banner1.png" />
                            <p>
                                同济“苗圃计划”试点中学百余学子今造访同济大学
                                <br/>
                                参加2014年夏令营
                            </p>
                        </a>
                    </div>
                    <div class="clear">&nbsp;</div>
                </div>
            </div>
            <!--banner end-->
            <div id="banner" class="title tab">
                <a href="javascript:void(0);" class="active" data-url="article/listLastArticle" data-target="articleList"> <em class="icon il"></em>
                    <h1>最新</h1>
                </a>
                <a href="javascript:void(0);" data-url="article/listHotArticle" data-target="articleList"> <em class="icon ih"></em>
                    <h1>最热</h1>
                </a>
            </div>
            <div id="articleList"></div>

        </div>
        <!--leftcontent end-->
        <div class="clear">&nbsp;</div>
    </div>
</div>


<script type="text/javascript">
$("#right").load("right");

  $("#articleList").load("article/listLastArticle");

  $("#banner a").click(function(){
    $(this).addClass("active").siblings().removeClass("active");
  });
</script>