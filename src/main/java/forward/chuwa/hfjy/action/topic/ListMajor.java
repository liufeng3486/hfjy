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
@Action("listMajor")
public class ListMajor extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private TopicService topicService;
	
	private Long typeid; 
	
	private List<WebTopic> listWebTopics;
	
	private String pinyin;
	
	private String subjecttype;
	
	public String execute() {
		listWebTopics = topicService.findWebTopics(getCondition(),
				getStartIndex(), PAGE_SIZE);
		setCount(topicService.countWebTopics(getCondition()));
		return INPUT;
	}
	
	public String getCondition(){
		StringBuilder sb= new StringBuilder();
		
		sb.append(" and t.subjecttype is not null and t.parentid is null ");
		
		if (typeid != null && typeid > 0) {
			sb.append(" and t.topictypeid = " + typeid);
		}
		
		if (!StringUtils.isEmpty(pinyin)) {
			sb.append(" and t.pinyin in ( " + pinyin + ") ");
		}
		
		if (!StringUtils.isEmpty(subjecttype)) {
			sb.append(" and t.subjecttype in ( " + subjecttype + ") ");
		}
		return sb.toString();
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

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getSubjecttype() {
		return subjecttype;
	}

	public void setSubjecttype(String subjecttype) {
		this.subjecttype = subjecttype;
	}

	
	
}
