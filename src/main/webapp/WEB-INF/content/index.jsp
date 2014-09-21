<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>录取啦</title>

<link href="style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
<div class="header clearfix">
  <div class="contain">
    <div class="right">
      <a href="javascript:void(0);" id="btn_login">登录</a>
      <a href="javascript:void(0);">注册</a>
    </div>

    <div class="left">
      <a href="index.html">
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
        <input type="text" placeholder="学校、专业、地区" />
      </div>
    </div>
    <div id="topicTypeList" class="left">
     
    </div>
    <div class="clear">&nbsp;</div>
  </div>
</div>

<div class="container">
  <div class="contain">
    <div class="rightsidebar">
      <div class="conduct"><a href="javascript:void(0);"><img src="images/img/img1.png" /></a></div>
      <!--话题 start-->
      <div class="block" id="contact">
        <div class="title"><em class="icon it"></em>
          <h1>话题</h1>
          <span class="dotted"><a href="javascript:void(0);" class="active"></a><a href="javascript:void(0);" class=""></a><a href="javascript:void(0);" class=""></a></span></div>
        <div class="content">
          <div class="layer">
            <dl>
              <dt><a href="javascript:void(0);" class="btn btn_white right">已关注</a>
                <h2>复旦大学</h2>
              </dt>
              <dd>
                <p>简介假字简介假字简介假字简介假字简介假字简介假字简介假字简介假字。</p>
              </dd>
            </dl>
            <a href="javascript:void(0);" class="left"><img src="images/icon/fudan_logo.png" alt="复旦大学" title="复旦大学" /></a>
            <div class="clear">&nbsp;</div>
          </div>
          <div class="layer">
            <dl>
              <dt><a href="javascript:void(0);" class="btn btn_white right">已关注</a>
                <h2>同济大学</h2>
              </dt>
              <dd>
                <p>简介假字简介假字简介假字简介假字简介假字简介假字简介假字简介假字。</p>
              </dd>
            </dl>
            <a href="javascript:void(0);" class="left"><img src="images/icon/tongji_logo.png" alt="同济大学" title="同济大学" /></a>
            <div class="clear">&nbsp;</div>
          </div>
          <div class="layer last">
            <dl>
              <dt><a href="javascript:void(0);" class="btn btn_white right"><span class="red">&plus;</span>&nbsp;关注</a>
                <h2>高考</h2>
              </dt>
              <dd>
                <p>简介假字简介假字简介假字简介假字简介假字简介假字简介假字简介假字。</p>
              </dd>
            </dl>
            <a href="javascript:void(0);" class="left"><img src="images/icon/gaokao_logo.png" alt="高考" title="高考" /></a>
            <div class="clear">&nbsp;</div>
          </div>
        </div>
      </div>
      <!--话题 end--> 
      <!--大家都在看 start-->
      <div class="block">
        <div class="title"><em class="icon ih"></em>
          <h1>大家都在看</h1>
        </div>
        <div class="content">
          <div class="newer"><a href="javascript:void(0);"><em class="icon idotted"></em><span>是去大公司呢还是继续呆在小公司</span>
            <div class="clear">&nbsp;</div>
            </a></div>
          <div class="newer"><a href="javascript:void(0);"><em class="icon idotted"></em><span>最牛的商业模式：4个人公司年净赚七千万</span>
            <div class="clear">&nbsp;</div>
            </a> </div>
          <div class="newer"><a href="javascript:void(0);"><em class="icon idotted"></em><span>是去大公司呢还是继续呆在小公司</span>
            <div class="clear">&nbsp;</div>
            </a> </div>
          <div class="newer"><a href="javascript:void(0);"><em class="icon idotted"></em><span>最牛的商业模式：4个人公司年净赚七千万</span>
            <div class="clear">&nbsp;</div>
            </a></div>
          <div class="newer last"><a href="javascript:void(0);"><em class="icon idotted"></em><span>是去大公司呢还是继续呆在小公司</span>
            <div class="clear">&nbsp;</div>
            </a> </div>
        </div>
      </div>
      <!--大家都在看 end--> 
    </div>
    <!--leftcontent start-->
    <div class="leftcontent"> 
      <!--banner start-->
      <div class="banner">
        <div class="img">
          <div class="right"> <a href="javascript:void(0);" class="layer"><img src="images/img/banner1_small.png" />
            <div class="shadow"></div>
            <p>复旦大学2015年将增加招生500人，清华、浙大表示不会跟风</p>
            </a> <a href="javascript:void(0);" class="layer"><img src="images/img/banner2_small.png" />
            <div class="shadow"></div>
            <p>基于知识型笔记的生产力工具，打造精华知识分享社区</p>
            </a> <a href="javascript:void(0);" class="layer"><img src="images/img/banner3_small.png" />
            <div class="shadow"></div>
            <p>又一个打算用大数据预防疾病的项目——Google Bas-eline Study</p>
            </a> </div>
          <div class="left"><a href="javascript:void(0);"><img src="images/img/banner1.png" />
            <p>同济“苗圃计划”试点中学百余学子今造访同济大学<br/>
              参加2014年夏令营</p>
            </a> </div>
          <div class="clear">&nbsp;</div>
        </div>
      </div>
      <!--banner end-->
      <div class="title tab"><a href="javascript:void(0);" class="active"><em class="icon il"></em>
        <h1>最新</h1>
        </a><a href="javascript:void(0);"><em class="icon ih"></em>
        <h1>最热</h1>
        </a></div>
      <div class="tab_content">
        <div class="layer">
          <div class="padding">
            <div class="right">
              <dl>
                <dt><a href="javascript:void(0);">复旦大学2015年将增加招生500人，清华、浙大等表示不会跟风</a></dt>
                <dd>
                  <div class="tag"><a href="javascript:void(0);" class="btn btn_white  active">复旦大学</a><a href="javascript:void(0);" class="btn btn_white">同济大学</a><a href="javascript:void(0);" class="btn btn_white">招生</a>
                    <div class="popup_tag"> <em class="icon iarrow"></em>
                      <div class="padding">
                        <dl>
                          <dt><a class="btn btn_white fr" href="javascript:void(0);">已关注</a>
                            <h2>复旦大学</h2>
                          </dt>
                          <dd>
                            <p>简介假字简介假字简介假字简介假字简介假字简介假字简介假字简介假字。</p>
                          </dd>
                        </dl>
                        <a class="left" href="javascript:void(0);"><img title="复旦大学" alt="复旦大学" src="images/icon/fudan_logo.png"></a>
                        <div class="clear">&nbsp;</div>
                      </div>
                    </div>
                  </div>
                </dd>
                <dd>
                  <p>不论是厦门跨桥环海的每年一跑（其中不乏许多中学生），还是越来越有特色的各样跑步活动，都在说明人们正追寻一种更健康和更个性的生活方式，而这背后则代表了一些新的机会。</p>
                </dd>
                <dd><span class="time">14:00&nbsp;&nbsp;7.14</span><span class="gray">中华人民共和国教育部</span></dd>
              </dl>
            </div>
            <div class="left"><a href="javascript:void(0);"><img src="images/img/tag1.png" /></a></div>
            <div class="clear">&nbsp;</div>
          </div>
        </div>
        <div class="layer">
          <div class="padding">
            <div class="right">
              <dl>
                <dt><a href="javascript:void(0);">复旦大学2015年将增加招生500人，清华、浙大等表示不会跟风</a></dt>
                <dd>
                  <div class="tag"><a href="javascript:void(0);" class="btn btn_white">复旦大学</a><a href="javascript:void(0);" class="btn btn_white">同济大学</a><a href="javascript:void(0);" class="btn btn_white">招生</a></div>
                </dd>
                <dd>
                  <p>不论是厦门跨桥环海的每年一跑（其中不乏许多中学生），还是越来越有特色的各样跑步活动，都在说明人们正追寻一种更健康和更个性的生活方式，而这背后则代表了一些新的机会。</p>
                </dd>
                <dd><span class="time">14:00&nbsp;&nbsp;7.14</span><span class="gray">中华人民共和国教育部</span></dd>
              </dl>
            </div>
            <div class="left"><a href="javascript:void(0);"><img src="images/img/tag1.png" /></a></div>
            <div class="clear">&nbsp;</div>
          </div>
        </div>
        <div class="layer">
          <div class="padding">
            <div class="right">
              <dl>
                <dt><a href="javascript:void(0);">复旦大学2015年将增加招生500人，清华、浙大等表示不会跟风</a></dt>
                <dd>
                  <div class="tag"><a href="javascript:void(0);" class="btn btn_white">复旦大学</a><a href="javascript:void(0);" class="btn btn_white">同济大学</a><a href="javascript:void(0);" class="btn btn_white">招生</a></div>
                </dd>
                <dd>
                  <p>不论是厦门跨桥环海的每年一跑（其中不乏许多中学生），还是越来越有特色的各样跑步活动，都在说明人们正追寻一种更健康和更个性的生活方式，而这背后则代表了一些新的机会。</p>
                </dd>
                <dd><span class="time">14:00&nbsp;&nbsp;7.14</span><span class="gray">中华人民共和国教育部</span></dd>
              </dl>
            </div>
            <div class="left"><a href="javascript:void(0);"><img src="images/img/tag1.png" /></a></div>
            <div class="clear">&nbsp;</div>
          </div>
        </div>
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

<!--footer start-->
<div class="footer">
  <div class="contain">
    <div class="block right">
      <a href="javascript:void(0);"> <em class="icon weixin"></em>
      </a>
      <a href="javascript:void(0);"> <em class="icon weibo"></em>
      </a>
      <a href="javascript:void(0);">
        <em class="icon renren"></em>
      </a>
      <a href="javascript:void(0);">
        <em class="icon qzone"></em>
      </a>
    </div>
    <div class="block link">
      <a href="javascript:void(0);">我们是谁</a>
      <a href="javascript:void(0);">加入海风</a>
      <a href="javascript:void(0);">联系我们</a>
    </div>
    <div class="block left">
      <img src="images/footer_logo.png" />
      <div class="copyright">
        <p>京公网安备11010802012285号</p>
        <p>海风教育旗下网站，版权所有</p>
        <p>Copyright © 2014  All Rights Reserved.</p>
      </div>
      <div class="clear">&nbsp;</div>
    </div>
  </div>
</div>
<!--footer end--> 
</body>
</html>


