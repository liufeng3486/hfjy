package forward.chuwa.hfjy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebHot;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.utility.DictionaryUtil;


public class Ajax extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private ArticleService articleService;
	
	private Long id;
	
	private String searchContent;
	
	/**
	 * 首页导航分类
	 */
	@Action(value = "ajaxTopicType")
	public void topicType() {
		List<SysTopictype> list = systemService
				.findSysTopictypes(" and t.isShow = '"
						+ DictionaryUtil.DELETE_FLAG1 + "' order by orderid ");
		writeJson(list);
	}
	
	/**
	 * 话题的最新和最热文章
	 */
	@Action(value = "ajaxTopicDetail")
	public void topicDetail() {
		Map<String,Object> result = new HashMap<String,Object>();
		if(id !=null && id>0){
			List<WebArticle> list = articleService.findWebArticles(
					" and exists (from t.webTopics t1 where t1.id = " + id
							+ " ) order by t.publishdate desc ", 0, 1);
			if (list != null && list.size() > 0) {
				Map<String,Object> last = new HashMap<String,Object>();
				last.put("id", list.get(0).getId());
				last.put("title", list.get(0).getTitle());
				result.put("last", last);
			}

			list = articleService.findWebArticles(
					" and exists (from t.webTopics t1 where t1.id = " + id
							+ " ) order by getArticleRecord(t.id) desc ", 0, 1);
			if (list != null && list.size() > 0) {
				Map<String,Object> hot = new HashMap<String,Object>();
				hot.put("id", list.get(0).getId());
				hot.put("title", list.get(0).getTitle());
				result.put("hot", hot);
			}
		}
		writeJson(result);
	}
	
	/**
	 * 设置首页海报
	 */
	@Action(value = "ajaxSetTop")
	public void setTop() {
		int result = 0;
		if (id != null && id > 0) {
			systemService.createWebHot(DictionaryUtil.HOT_TYPE1,
					DictionaryUtil.RELATION_TYPE2, id);
			result = 1;
		}
		writeJson(result);
	}

	/**
	 * 取消设置首页海报
	 */
	@Action(value = "ajaxRemoveTop")
	public void removeTop() {
		int result = 0;
		if (id != null && id > 0) {
			systemService.deleteWebHot(DictionaryUtil.HOT_TYPE1,
					DictionaryUtil.RELATION_TYPE2, id);
			result = 1;
		}
		writeJson(result);
	}
	
	/**
	 * 设置推荐话题
	 */
	@Action(value = "ajaxSetHotTopic")
	public void setHotTopic() {
		int result = 0;
		if (id != null && id > 0) {
			systemService.createWebHot(DictionaryUtil.HOT_TYPE2,
					DictionaryUtil.RELATION_TYPE1, id);
			result = 1;
		}
		writeJson(result);
	}

	/**
	 * 取消设置推荐话题
	 */
	@Action(value = "ajaxRemoveHotTopic")
	public void removeHotTopic() {
		int result = 0;
		if (id != null && id > 0) {
			systemService.deleteWebHot(DictionaryUtil.HOT_TYPE2,
					DictionaryUtil.RELATION_TYPE1, id);
			result = 1;
		}
		writeJson(result);
	}
	
	@Action(value = "ajaxListTop")
	public void listTop(){
		List<WebArticle> listTop = new ArrayList<WebArticle>();
		for (WebHot webHot : systemService.findWebHots(" and t.hottype = '"
				+ DictionaryUtil.HOT_TYPE1 + "' and t.relationtype = '"
				+ DictionaryUtil.RELATION_TYPE2 + "' ", 0, 4)) {
			WebArticle webArticle = articleService.loadWebArticle(webHot
					.getRelationid());
			listTop.add(webArticle);
		}
		writeJson(listTop);
	}
	
	@Action(value = "ajaxSearchArticle")
	public void searchArticle() {
		List<WebArticle> list = new ArrayList<WebArticle>();
		if (!StringUtils.isEmpty(searchContent)) {
			list = articleService.findWebArticles(" and t.title like '%"
					+ searchContent
					+ "%' order by getArticleRecord(t.id) desc ", 0, 2);
		}
		writeJson(list);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	
	
}
