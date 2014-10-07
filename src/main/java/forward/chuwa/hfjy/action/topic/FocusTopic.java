package forward.chuwa.hfjy.action.topic;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.TopicService;

@Action("focusTopic")
public class FocusTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private TopicService topicService;
	
	private List<WebTopic> listWebTopics;

	public String execute() {
		listWebTopics = topicService.findWebTopics(
				" and exists (from t.webUsers t1 where t1.id = "
						+ getUserInfo().getUserId() + " )  ", getStartIndex(),
				PAGE_SIZE);
		setCount(topicService
				.countWebTopics(" and exists (from t.webUsers t1 where t1.id = "
						+ getUserInfo().getUserId() + ") "));
		return INPUT;
	}

	public List<WebTopic> getListWebTopics() {
		return listWebTopics;
	}

	public void setListWebTopics(List<WebTopic> listWebTopics) {
		this.listWebTopics = listWebTopics;
	}

	

}
