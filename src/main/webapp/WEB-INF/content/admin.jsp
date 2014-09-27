<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>录取啦</title>

<link href="css/flick/jquery-ui.min.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/pager.js"></script>
<script type="text/javascript" src="js/default.js"></script>
<script type="text/javascript" src="js/jquery-ui/jquery-ui.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" >

	function uploadFile(obj) {
		var file = $("#file");	
		file.off("change");
		file.on("change", function() {
			file.off("change");
			$.ajaxFileUpload({
				url : 'upload',
				secureuri : false,
				fileElementId : "file",
				dataType : 'json',
				success : function(data, status) {
					obj.next().attr("src","download?c="+data)
						.next().val(data);
				},
				error : function(data, status, e) { 
					
				}
			});
		});

		file.click();
	}

	$(function(){
		baseUrl = "admin";
		content  = $("#content");
		
		$(document).on("click", "a[data-role=upload]", function() {
			uploadFile($(this));
		});
	});
</script>
</head>
<body>
<div id="nav">
	<a href="javascript:void(0)"  data-url="">用户管理</a>
	<a href="javascript:void(0)"  data-url="listWebTopic">话题管理</a>
	<a href="javascript:void(0)"  data-url="listWebArticle">文章管理</a>
</div>
<div id="content">

</div>
</body>
</html>


