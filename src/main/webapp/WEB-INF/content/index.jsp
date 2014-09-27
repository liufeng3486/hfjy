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
<script type="text/javascript" src="js/pager.js"></script>
<script type="text/javascript" src="js/default.js"></script>
<script type="text/javascript">
$(function(){
    $("#header").load("header");
    $("#footer").load("footer");
    $("#main").load("${m}");
});

</script>
</head>
<body>
<div id="header">

</div>

<div id="main">
  
</div>

<!--footer start-->
<div id="footer" class="footer"></div>
<!--footer end--> 
</body>
</html>


