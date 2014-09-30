package forward.chuwa.hfjy.action.topic;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.TopicService;

@Action("detailWebTopic")
public class DetailWebTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private TopicService topicService;

	private Long id;
	private WebTopic webTopic;

	public String execute() {
		if (id != null && id > 0) {
			webTopic = topicService.loadWebTopic(id);
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

	public void setWebTopic(WebTopic webTopic) {
		this.webTopic = webTopic;
	}

}
