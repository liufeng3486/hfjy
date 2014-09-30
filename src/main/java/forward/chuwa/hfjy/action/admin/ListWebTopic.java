package forward.chuwa.hfjy.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.service.TopicService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Action("listWebTopic")
public class ListWebTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private TopicService topicService;
	@Autowired
	private SystemService systemService;
	
	
	private List<WebTopic> listWebTopics;
	
	public String execute() {
		listWebTopics = topicService.findWebTopics("", getStartIndex(), PAGE_SIZE);
		setCount(topicService.countWebTopics(""));
		getHot();
		return INPUT;
	}
	
	public void getHot() {
		for (WebTopic webTopic : listWebTopics) {
			if (systemService.countWebHots(DictionaryUtil.HOT_TYPE2,
					DictionaryUtil.RELATION_TYPE1, webTopic.getId()) > 0) {
				webTopic.setProtype("1");
			} else {
				webTopic.setProtype("0");
			}
		}
	}

	public List<WebTopic> getListWebTopics() {
		return listWebTopics;
	}

	public void setListWebTopics(List<WebTopic> listWebTopics) {
		this.listWebTopics = listWebTopics;
	}
	
	
}
