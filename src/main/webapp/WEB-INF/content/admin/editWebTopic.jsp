<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<table>
	<tr>
		<td>话题名称</td>
		<td><input id="name"  value="${name }" /></td>
	</tr>
	<tr>
		<td>所属类型</td>
		<td>
			<select id="topictypeid">
				<s:iterator value="listSysTopictypes" var="item">
					<s:if test="#item.id==topictypeid">
						<option value="${item.id }" selected>${item.typename }</option>
					</s:if>
					<s:else>
						<option value="${item.id }">${item.typename }</option>
					</s:else>
				</s:iterator>
			</select>
		</td>
	</tr>
	<tr>
		<td>所属类型</td>
		<td>
			<select id="provinceid">
				<s:iterator value="listSysProvinces" var="item">
					<s:if test="#item.id==provinceid">
						<option value="${item.id }" selected>${item.name }</option>
					</s:if>
					<s:else>
						<option value="${item.id }">${item.name }</option>
					</s:else>
				</s:iterator>
			</select>
		</td>
	</tr>
</table>