package forward.chuwa.hfjy.action.topic;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.TopicService;

@Action("university")
public class University extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private TopicService topicService;

	private Long typeid = 1L;

	private List<WebTopic> listWebTopics;

	public String execute() {
		if (typeid != null && typeid > 0) {
			listWebTopics = topicService.findWebTopics(" and t.topictypeid = "
					+ typeid, getStartIndex(), PAGE_SIZE);
		}
		return INPUT;
	}

	public Long getTypeid() {
		return typeid;
	}

	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}

	public List<WebTopic> getListWebTopics() {
		return listWebTopics;
	}

	public void setListWebTopics(List<WebTopic> listWebTopics) {
		this.listWebTopics = listWebTopics;
	}

}
