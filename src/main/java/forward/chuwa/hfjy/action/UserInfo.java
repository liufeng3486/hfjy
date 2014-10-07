package forward.chuwa.hfjy.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.TopicService;

@Namespace("/")
@Action("userInfo")
public class UserInfo extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private TopicService topicService;
	
	private Long focusTopicCount;
	
	private Long favarticleCount;
	
	public String execute() {
		focusTopicCount = topicService.countWebTopics(" and exists (from t.webUsers t1 where t1.id = "
				+ getUserInfo().getUserId() + " )  ");
		favarticleCount = articleService.countWebArticles(" and exists (from t.webUsers t1 where t1.id = "
				+ getUserInfo().getUserId() + " )  ");
		return INPUT;
	}

	public Long getFocusTopicCount() {
		return focusTopicCount;
	}

	public void setFocusTopicCount(Long focusTopicCount) {
		this.focusTopicCount = focusTopicCount;
	}

	public Long getFavarticleCount() {
		return favarticleCount;
	}

	public void setFavarticleCount(Long favarticleCount) {
		this.favarticleCount = favarticleCount;
	}
	
}
