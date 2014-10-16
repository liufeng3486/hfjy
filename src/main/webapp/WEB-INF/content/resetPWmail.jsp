<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<meta charset="utf-8" />
<title></title>
<style type="text/css">*{
font-size:14px;
color:#444;
}
.yz_teb{
width:760px;
height:550px;
}
.teb_top h1{
height:85px;
margin:0;
padding:0;
}
.teb_top h1 img{
margin-left:18px;
padding-top:10px;
}
.tebt_text{
border-top: 12px solid #ececec;
border-left: 12px solid #ececec;
border-right: 12px solid #ececec;
padding:30px 29px 17px 22px;
}
.tebt_text dl{
margin:0;
padding:0;
}
.tebt_text dt{
margin-bottom:22px;
}
.tebt_text dd{
margin-left:27px;
margin-right:34px;
margin-bottom:40px;
}
.l1{
line-height:65px;
}
.tebt_text dd a{
width:624px;
display:block;
word-wrap:break-word;
color:#3f99cd;
}
.tebt_text dl pre{
text-align:right;
color:#6a6a6a;
margin:0;
}
.bx{
background-color:#d00000;
line-height:40px;
color:#fff;
text-align:right;
padding-right:12px;
}
.yz_teb h2{
margin-top:16px;
color:#bdbdbd;
text-align:center;
font-weight:normal;
font-size:12px;
}
</style>
<div class="yz_teb">
<div class="teb_top">
<h1><a href="http://luqu.la"><img alt="" height="64" src="http://luqu.la/images/logo.png" width="134" /></a></h1>

<div class="tebt_text">
<dl>
<dt>亲爱的用户，您好！</dt>
<dd><span class="l1">您在${date}申请找回您的录取啦登陆密码，您可以通过以下链接进行重置密码</span><a href="http://localhost:8080/hfjy/index?token=${token}">http://localhost:8080/hfjy/index?token=${token}</a> <span class="l1">为保障您的账号安全，请在24小时之内点击该链接，您也可以将链接复制到浏览器地址栏访问。</span></dd>
</dl>
</div>

<div class="bx">国内首个高中升学资讯交流平台</div>
</div>

<h2>录取啦系统自动提醒，请勿回复</h2>
</div>