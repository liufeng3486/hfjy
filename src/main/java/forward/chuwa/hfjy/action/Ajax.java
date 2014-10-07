package forward.chuwa.hfjy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.model.SysGrade;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebHot;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.model.WebUser;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.service.TopicService;
import forward.chuwa.hfjy.service.UserService;
import forward.chuwa.hfjy.utility.DictionaryUtil;
import forward.chuwa.hfjy.utility.UserInfo;


public class Ajax extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private UserService userService;
	
	private Long id;
	
	private String searchContent;
	
	private Long parentid;
	
	private String loginname;
	
	private String password;
	
	private String name;
	
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
	 * 省份列表
	 */
	@Action(value = "ajaxProvince")
	public void province() {
		StringBuilder sb = new StringBuilder();
		if(parentid != null){
			sb.append(" and t.parentid = "+parentid);
		}
		sb.append(" order by orderid ");
		List<SysProvince> list = systemService.findSysProvinces(sb.toString());
		writeJson(list);
	}
	
	/**
	 * 年级列表
	 */
	@Action(value = "ajaxGrade")
	public void grade() {
		StringBuilder sb = new StringBuilder();
		sb.append(" order by orderid ");
		List<SysGrade> list = systemService.findSysGrades(sb.toString());
		writeJson(list);
	}
	
	/**
	 * 话题的最新和最热文章
	 */
	@Action(value = "ajaxTopicDetail")
	public void topicDetail() {
		Map<String,Object> result = new HashMap<String,Object>();
		if(id !=null && id>0){
			WebTopic webTopic =topicService.loadWebTopic(id);
			Map<String,Object> item = new HashMap<String,Object>();
			item.put("id", webTopic.getId());
			item.put("name", webTopic.getName());
			item.put("introduction", webTopic.getIntroduction());
			item.put("topicphoto", webTopic.getTopicphoto());
			result.put("item", item);
			
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
	
	@Action(value = "ajaxLogin")
	public void login() {
		int result = 0;
		WebUser webUser = userService.login(loginname, password);
		if (webUser != null) {
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(webUser.getId());
			userInfo.setName(webUser.getName());
			userInfo.setEmail(webUser.getEmail());
			userInfo.setUserphoto(webUser.getUserphoto());
			userInfo.setGradename(webUser.getGradename());
			userInfo.setProvincename(webUser.getProvincename());
			getSession().setAttribute(KEY_USER_INFO, userInfo);
			result = 1;
		}
		writeJson(result);
	}
	
	@Action(value = "ajaxLogout")
	public void logout() {
		getSession().setAttribute(KEY_USER_INFO, null);
	}
	
	@Action(value = "ajaxRegister")
	public void register() {
		int result = 0;
		if (userService.findWebUsers(" and t.loginname ='" + loginname + "'")
				.size() > 0) {
		}else{
			userService.createWebUser(loginname, password, name, loginname, null, null, null);
			login();
			result = 1;
		}
		writeJson(result);
	}
	
	@Action(value = "ajaxAddFocusTopic")
	public void addFocusTopic() {
		int result = 0;
		if (getUserInfo() != null && id != null && id > 0) {
			userService.addFocusTopic(getUserInfo().getUserId(), id);
			result = 1;
		}
		writeJson(result);
	}

	@Action(value = "ajaxRemoveFocusTopic")
	public void removeFocusTopic() {
		int result = 0;
		if (getUserInfo() != null && id != null && id > 0) {
			userService.removeFocusTopic(getUserInfo().getUserId(), id);
			result = 1;
		}
		writeJson(result);
	}
	
	@Action(value = "ajaxAddFavArticle")
	public void addFavArticle() {
		int result = 0;
		if (getUserInfo() != null && id != null && id > 0) {
			userService.addFavArticle(getUserInfo().getUserId(), name, id);
			result = 1;
		}
		writeJson(result);
	}
	
	@Action(value = "ajaxRemoveFavArticle")
	public void removeFavArticle() {
		int result = 0;
		if (getUserInfo() != null && id != null && id > 0) {
			userService.removeFavArticle(getUserInfo().getUserId(), id);
			result = 1;
		}
		writeJson(result);
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

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
