<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title></title>
<script src="js/ckeditor/ckeditor.js"></script>
</head>
<body>
	<textarea name="editor1" id="editor1" rows="10" cols="80"></textarea>
	<script>
		CKEDITOR.replace('editor1');
	</script>
</body>
</html>


