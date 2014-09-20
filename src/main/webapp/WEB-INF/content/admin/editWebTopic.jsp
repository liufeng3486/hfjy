<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div>
	<input id="save" type="button" value="保存" /> <a
		href="javascript:void(0);" data-url="listWebTopic">返回</a>
</div>
<form id="editForm">
	<input name="id" value="${id }" type="hidden" />
	<input id="file" name="file" type="file" style="visibility: hidden; display: none;">
	<table>
		<tr>
			<td>话题名称</td>
			<td><input name="name" value="${name }" /></td>
		</tr>
		<tr>
			<td>所属类型</td>
			<td><select id="topictypeid" name="topictypeid">
					<s:iterator value="listSysTopictypes" var="item">
						<s:if test="#item.id==topictypeid">
							<option value="${item.id }" selected>${item.typename }</option>
						</s:if>
						<s:else>
							<option value="${item.id }">${item.typename }</option>
						</s:else>
					</s:iterator>
			</select></td>
		</tr>
		<tr>
			<td>拼音首字母</td>
			<td><input name="pinyin" value="${pinyin }" /></td>
		</tr>
		<tr>
			<td>头图</td>
			<td>
				<a href="javascript:void(0)" data-role="upload">上传</a>
				<img style="max-width:500px;" />
				<input id="topicimg" name="topicimg" type="hidden" value="${topicimg}" />
			</td>
		</tr>
		<tr>
			<td>头像</td>
			<td>
				<a href="javascript:void(0)" data-role="upload">上传</a>
				<img  style="max-width:500px;" />
				<input id="topicphoto" name="topicphoto" type="hidden" value="${topicphoto}" />
			</td>
		</tr>
		<tr>
			<td>介绍</td>
			<td>
				<textarea name="description" id="description" rows="10" cols="80">${description }</textarea>
			</td>
		</tr>
		
		<tr id="provinceid_tr">
			<td>所属省份</td>
			<td><select name="provinceid">
					<option value="">请选择</option>
					<s:iterator value="listSysProvinces" var="item">
						<s:if test="#item.id==provinceid">
							<option value="${item.id }" selected>${item.name }</option>
						</s:if>
						<s:else>
							<option value="${item.id }">${item.name }</option>
						</s:else>
					</s:iterator>
			</select></td>
		</tr>
		<tr id="unitype_tr">
			<td>类型</td>
			<td><select name="unitype">
					<option value="">请选择</option>
					<s:iterator value="listUnitypes" var="item">
						<s:if test="#item.dickey==unitype">
							<option value="${item.dickey }" selected>${item.dicvalue }</option>
						</s:if>
						<s:else>
							<option value="${item.dickey }">${item.dicvalue }</option>
						</s:else>
					</s:iterator>
			</select></td>
		</tr>
		<tr id="unilevel_tr">
			<td>层次</td>
			<td><select name="unilevel">
					<option value="">请选择</option>
					<s:iterator value="listUnilevels" var="item">
						<s:if test="#item.dickey==unilevel">
							<option value="${item.dickey }" selected>${item.dicvalue }</option>
						</s:if>
						<s:else>
							<option value="${item.dickey }">${item.dicvalue }</option>
						</s:else>
					</s:iterator>
			</select></td>
		</tr>
		<tr id="subjecttype_tr">
			<td>学科</td>
			<td><select name="subjecttype">
					<option value="">请选择</option>
					<s:iterator value="listSubjecttypes" var="item">
						<s:if test="#item.dickey==subjecttype">
							<option value="${item.dickey }" selected>${item.dicvalue }</option>
						</s:if>
						<s:else>
							<option value="${item.dickey }">${item.dicvalue }</option>
						</s:else>
					</s:iterator>
			</select></td>
		</tr>
		<tr id="protype_tr">
			<td>专业类别</td>
			<td><select name="protype">
					<option value="">请选择</option>
					<s:iterator value="listProtypes" var="item">
						<s:if test="#item.dickey==protype">
							<option value="${item.dickey }" selected>${item.dicvalue }</option>
						</s:if>
						<s:else>
							<option value="${item.dickey }">${item.dicvalue }</option>
						</s:else>
					</s:iterator>
			</select></td>
		</tr>
		<tr id="parentid_tr">
			<td>父话题</td>
			<td><s:set name="parentid" value="parentid" /> <select
				name="parentid">
					<option value="">请选择</option>
					<s:iterator value="listParentWebTopics" var="item">
						<s:if test="#item.id==#parentid ">
							<option value="${item.id }" selected>${item.name }</option>
						</s:if>
						<s:else>
							<option value="${item.id }">${item.name }</option>
						</s:else>
					</s:iterator>
			</select></td>
		</tr>
	</table>
</form>
<script src="js/ckeditor/ckeditor.js"></script>
<script>
	$("#topictypeid").change(function() {
		if ($(this).val() == "1" || $(this).val() == "3") {
			$("#provinceid_tr").show().find("select").prop("disabled", false);
		} else {
			$("#provinceid_tr").hide().find("select").prop("disabled", true);
		}

		if ($(this).val() == "1") {
			$("#unitype_tr").show().find("select").prop("disabled", false);
			$("#unilevel_tr").show().find("select").prop("disabled", false);
		} else {
			$("#unitype_tr").hide().find("select").prop("disabled", true);
			$("#unilevel_tr").hide().find("select").prop("disabled", true);
		}

		if ($(this).val() == "2") {
			$("#subjecttype_tr").show().find("select").prop("disabled", false);
			$("#protype_tr").show().find("select").prop("disabled", false);
			$("#parentid_tr").show().find("select").prop("disabled", false);
		} else {
			$("#subjecttype_tr").hide().find("select").prop("disabled", true);
			$("#protype_tr").hide().find("select").prop("disabled", true);
			$("#parentid_tr").hide().find("select").prop("disabled", true);
		}
	});
	$("#topictypeid").change();

	$("#save").click(function() {
		if (confirm("确认提交？")) {
			$("#description").val(CKEDITOR.instances.description.getData());
			$.post(baseUrl + "/editWebTopic!save", $('#editForm').serialize(), function() {
				pageLoad("listWebTopic");
			});
		}
	});
	
	CKEDITOR.replace('description');
	if('${topicimg}'){
		$("#topicimg").prev().attr("src","download?c=${topicimg}");
	}
	if('${topicphoto}'){
		$("#topicphoto").prev().attr("src","download?c=${topicphoto}");
	}
</script>