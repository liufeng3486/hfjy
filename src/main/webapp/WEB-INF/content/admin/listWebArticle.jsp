<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div>
	<a href="javascript:void(0)"  data-url="editWebArticle" >新建文章</a>
</div>
<table>
	<tr>
		<th>
			序号
		</th>
		<th>
			标题
		</th>
		<th>
			摘要
		</th>
		<th>
			所属年级
		</th>
		<th>
			所属省份
		</th>
		<th>
			发表时间
		</th>
		<th>
			操作
		</th>
	</tr>
	<s:iterator value="listWebArticles" var="item" status="s">
	<tr>
		<td>
			${s.index + startIndex }
		</td>
		<td>
			${item.title }
		</td>
		<td>
			${item.description }
		</td>
		<td>
			${item.provinceName }
		</td>
		<td>
			${item.gradeName }
		</td>
		<td>
			<s:date name="#item.publishdate" format="yyyy-MM-dd"/>
		</td>
		<td>
			<a href="javascript:void(0)"  data-url="editWebArticle?id=${item.id}">编辑</a>
			<a href="javascript:void(0)" data-url="editWebArticle?id=${item.id}">删除</a>
		</td>
	</tr>
	</s:iterator>
</table>