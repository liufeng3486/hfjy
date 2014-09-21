<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
	<table>
			<thead>
				<tr>
					<td width="50">序号</td>
					<td width="150">姓名</td>
					<td width="150">出生日期</td>
					<td width="150">地址</td>
					<td width="150">电话</td>
					<td width="150">电子邮件</td>
					<td><s:url var="url" action="editTestUser" /> <s:a
							href="%{url}">新增</s:a></td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="testUsers" status="status" var="item">
					<tr>
						<td>${status.index + startIndex}</td>
						<td><s:property value="name" /></td>
						<td><s:property value="birthday" /></td>
						<td><s:property value="address" /></td>
						<td><s:property value="phone" /></td>
						<td><s:property value="email" /></td>
						<td><s:url var="url" action="editTestUser">
								<s:param name="id" value="#item.id" />
							</s:url> <s:a href="%{url}">编辑</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
</body>
</html>


