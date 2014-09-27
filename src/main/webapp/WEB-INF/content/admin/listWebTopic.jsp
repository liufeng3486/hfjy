<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div>
	<a href="javascript:void(0)"  data-url="editWebTopic" >新建话题</a>
</div>
<table>
	<tr>
		<th>
			序号
		</th>
		<th>
			话题名称
		</th>
		<th>
			所属类型
		</th>
		<th>
			父话题名称
		</th>
		<th>
			操作
		</th>
	</tr>
	<s:iterator value="listWebTopics" var="item" status="s">
	<tr>
		<td>
			${s.index + startIndex +1}
		</td>
		<td>
			${item.name }
		</td>
		<td>
			${item.topictypeName }
		</td>
		<td>
			${item.parentname }
		</td>
		<td>
			<a href="javascript:void(0)"  data-url="editWebTopic?id=${item.id}">编辑</a>
			<a href="javascript:void(0)" data-url="editWebTopic?id=${item.id}">删除</a>
		</td>
	</tr>
	</s:iterator>
</table>
<div id="pager"></div>

<script type="text/javascript">
$("#pager").pager("listWebTopic","content",${startIndex},${pageSize},${count},0);
</script>

