<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title></title>

</head>
<body>
	<s:form>
		<s:hidden name="id" />
		<table>
			<tr>
				<td>姓名</td>
				<td><s:textfield name="name" maxlength="20" /></td>
			</tr>
			<tr>
				<td>出生日期</td>
				<td><s:textfield name="birthday" maxlength="10"
						cssClass="dateType" /></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><s:textfield name="address" maxlength="50" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><s:textfield name="phone" maxlength="20" /></td>
			</tr>
			<tr>
				<td>电子邮件</td>
				<td><s:textfield name="email" maxlength="20" /></td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2">
					<hr>
				</td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="保存" method="save" /> <s:submit
						value="删除" method="delete" /> <s:submit value="返回" method="back" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>

