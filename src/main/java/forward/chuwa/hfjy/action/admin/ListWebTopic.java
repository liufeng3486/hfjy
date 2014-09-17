package forward.chuwa.hfjy.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.TopicService;

@Action("listWebTopic")
public class ListWebTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private TopicService topicService;
	
	
	private List<WebTopic> listWebTopics;
	
	public String execute() {
		listWebTopics = topicService.findWebTopics("", startIndex-1, PAGE_SIZE);
		return INPUT;
	}

	public List<WebTopic> getListWebTopics() {
		return listWebTopics;
	}

	public void setListWebTopics(List<WebTopic> listWebTopics) {
		this.listWebTopics = listWebTopics;
	}
	
	
}
