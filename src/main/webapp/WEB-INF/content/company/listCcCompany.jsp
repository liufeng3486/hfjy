<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>listCcCompany</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
	<table>
		<tr>
			<th>序号</th>
			<th>名称</th>
			<th>地址</th>
			<th>简称</th>
			<th>电话</th>
		</tr>
		<s:iterator value="listCcCompany" status="s">
			<tr>
				<td>${s.index+1 }</td>
				<td>${name }</td>
				<td>${address }</td>
				<td>${shortName }</td>
				<td>${phone }</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>


