package forward.chuwa.hfjy.action.topic;


import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.TopicService;
import forward.chuwa.hfjy.service.UserService;

@Action("detailWebTopic")
public class DetailWebTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private TopicService topicService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;

	private Long id;
	private WebTopic webTopic;
	
	private Long articleCount;
	private Long userCount;

	public String execute() {
		if (id != null && id > 0) {
			webTopic = topicService.loadWebTopic(id);
			articleCount = articleService
					.countWebArticles(" and exists (from t.webTopics t1 where t1.id = "
							+ id + ") ");
			userCount = userService.countWebUsers(" and exists (from t.webTopics t1 where t1.id = "
							+ id + ") ");
			if (getUserInfo() != null) {
				if (topicService.countWebTopics(" and t.id = "
						+ webTopic.getId()
						+ " and exists (from t.webUsers t1 where t1.id = "
						+ getUserInfo().getUserId() + " )  ") > 0) {
					webTopic.setProtype("1");
				}
			}
		}
		return INPUT;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WebTopic getWebTopic() {
		return webTopic;
	}

	public Long getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Long articleCount) {
		this.articleCount = articleCount;
	}

	public Long getUserCount() {
		return userCount;
	}

	public void setUserCount(Long userCount) {
		this.userCount = userCount;
	}

	public void setWebTopic(WebTopic webTopic) {
		this.webTopic = webTopic;
	}

}
