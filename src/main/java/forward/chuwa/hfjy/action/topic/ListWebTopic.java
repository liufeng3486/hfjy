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
@Action("listWebTopic")
public class ListWebTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private TopicService topicService;
	
	private Long typeid; 
	
	private List<WebTopic> listWebTopics;
	
	private String province;
	private String unitype;
	private String unilevel;
	private String pinyin;
	
	public String execute() {
		listWebTopics = topicService.findWebTopics(getCondition(),
				getStartIndex(), PAGE_SIZE);
		setCount(topicService.countWebTopics(getCondition()));
		return INPUT;
	}
	
	public String getCondition(){
		StringBuilder sb= new StringBuilder();
		if (typeid != null && typeid > 0) {
		sb.append(" and t.topictypeid = "
					+ typeid);
		}
		
		if (!StringUtils.isEmpty(province)) {
			sb.append(" and t.provinceid in ( " + province + ") ");
		}
		
		if (!StringUtils.isEmpty(unitype)) {
			sb.append(" and t.unitype in ( " + unitype + ") ");
		}
		
		if (!StringUtils.isEmpty(unilevel)) {
			sb.append(" and t.unilevel in ( " + unilevel + ") ");
		}
		
		if (!StringUtils.isEmpty(pinyin)) {
			sb.append(" and t.pinyin in ( " + pinyin + ") ");
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getUnitype() {
		return unitype;
	}

	public void setUnitype(String unitype) {
		this.unitype = unitype;
	}

	public String getUnilevel() {
		return unilevel;
	}

	public void setUnilevel(String unilevel) {
		this.unilevel = unilevel;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	
	
}
