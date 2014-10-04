package forward.chuwa.hfjy.action.topic;


import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.service.TopicService;

@Action("search")
public class Search extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private TopicService topicService;

	private String searchContent;

	public String execute() {
		setCount(topicService.countWebTopics(getCondition()));
		return INPUT;
	}

	public String getCondition() {
		StringBuilder sb = new StringBuilder();
		if (!StringUtils.isEmpty(searchContent)) {
			sb.append(" and t.name like '%" + searchContent + "%'");
		}
		return sb.toString();
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

}
