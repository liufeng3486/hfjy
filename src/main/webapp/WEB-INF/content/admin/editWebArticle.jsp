<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div>
	<input id="save" type="button" value="保存" /> <a
		href="javascript:void(0);" data-url="listWebArticle">返回</a>
</div>
<form id="editForm">
	<input name="id" value="${id }" type="hidden" />
	<input id="file" name="file" type="file" style="visibility: hidden; display: none;">
	<table>
		<tr>
			<td>标题</td>
			<td><input name="title" value="${title }" /></td>
		</tr>
		<tr>
			<td>摘要</td>
			<td><input name="description" value="${description }" /></td>
		</tr>
		<tr>
			<td>所属省份</td>
			<td><select name="provinceid">
					<option value="">全部</option>
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
		<tr>
			<td>所属年级</td>
			<td><select name="gradeid">
					<option value="">全部</option>
					<s:iterator value="listSysGrades" var="item">
						<s:if test="#item.id==gradeid">
							<option value="${item.id }" selected>${item.gradename }</option>
						</s:if>
						<s:else>
							<option value="${item.id }">${item.gradename }</option>
						</s:else>
					</s:iterator>
			</select></td>
		</tr>
		<tr>
			<td>缩略图</td>
			<td>
				<a href="javascript:void(0)" data-role="upload">上传</a>
				<img style="max-width:500px;" />
				<input id="articlephoto" name="articlephoto" type="hidden" value="${articlephoto}" />
			</td>
		</tr>
		<tr>
			<td>头图</td>
			<td>
				<a href="javascript:void(0)" data-role="upload">上传</a>
				<img style="max-width:500px;" />
				<input id="articleimg" name="articleimg" type="hidden" value="${articleimg}" />
			</td>
		</tr>
		<tr>
			<td>正文</td>
			<td>
				<textarea name="articlecontent" id="articlecontent" rows="10" cols="80">${articlecontent }</textarea>
			</td>
		</tr>
		<tr>
			<td>发表时间</td>
			<td><input id="publishdate" name="publishdate" value='<s:date name="publishdate" format="yyyy-MM-dd"/>'></input></td>
		</tr>
		<tr>
			<td>作者（来源）</td>
			<td><input name="author" value="${author }" /></td>
		</tr>
		<tr>
			<td>SEO描述</td>
			<td><input name="seo" value="${seo }" /></td>
		</tr>
		<tr>
			<td>所属话题</td>
			<td>
				<input id="selectedTopics" type="hidden" name="selectedTopics" value="${selectedTopics }" />
				<s:iterator value="listWebTopics" var="item" status="s">
					<div style="width:300px;float:left;padding:10px;marin-right:10px;" >
						<input class="selectedTopics" type="checkbox" value="${item.id}" />${item.name}
					</div>
				</s:iterator>
				<div style="clear:both;"></div>
			</td>
		</tr>
		<tr>
			<td>相关文章</td>
			<td>
				<input id="relevantarticle" type="hidden" name="relevantarticle" value="${relevantarticle }" />
				<s:iterator value="listWebArticles" var="item" status="s">
					<div style="width:300px;float:left;padding:10px;marin-right:10px;" >
						<input class="relevantarticle" type="checkbox" value="${item.id}" />${item.title}
					</div>
				</s:iterator>
				<div style="clear:both;"></div>
			</td>
		</tr>
	</table>
</form>
<script src="js/ckeditor/ckeditor.js"></script>
<script>
	$("#save").click(function() {
		if (confirm("确认提交？")) {
			$("#articlecontent").val(CKEDITOR.instances.articlecontent.getData());

			var relevantarticle = [];
			$(".relevantarticle:checked").each(function(){
				relevantarticle.push($(this).val());
			});

			$("#relevantarticle").val(relevantarticle.join(","));

			var selectedTopics = [];
			$(".selectedTopics:checked").each(function(){
				selectedTopics.push($(this).val());
			});

			$("#selectedTopics").val(selectedTopics.join(","));
			
			$.post(baseUrl + "/editWebArticle!save", $('#editForm').serialize(), function() {
				pageLoad("listWebArticle");
			});
		}
	});
	
	CKEDITOR.replace('articlecontent');
	if('${articleimg}'){
		$("#articleimg").prev().attr("src","download?c=${articleimg}");
	}

	if('${articlephoto}'){
		$("#articlephoto").prev().attr("src","download?c=${articlephoto}");
	}

	if('${relevantarticle}'){
		$('${relevantarticle}'.split(",")).map(function(){
			$(".relevantarticle[value="+this+"]").prop("checked",true);
		});
	}

	if('${selectedTopics}'){
		$('${selectedTopics}'.split(",")).map(function(){
			$(".selectedTopics[value="+this+"]").prop("checked",true);
		});
	}

	$("#publishdate").datepicker({ 
		dateFormat: 'yy-mm-dd' 
	});
</script>