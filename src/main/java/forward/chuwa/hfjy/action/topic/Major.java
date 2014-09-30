package forward.chuwa.hfjy.action.topic;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.SysDictionary;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.service.TopicService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Action("major")
public class Major extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private SystemService systemService;
	
	@Autowired
	private TopicService topicService;
	
	private List<SysDictionary> listSubjecttypes;//高校类型
	private List<WebTopic> listParentTopics;

	public String execute() {
		listSubjecttypes = systemService.findSysDictionaryByType(DictionaryUtil.DICTIONARY_TYPE3);
		listParentTopics = topicService.findWebTopics(" and t.topictypeid = 2 and t.subjecttype is not null and t.parentid is null ");
		return INPUT;
	}

	public List<SysDictionary> getListSubjecttypes() {
		return listSubjecttypes;
	}

	public void setListSubjecttypes(List<SysDictionary> listSubjecttypes) {
		this.listSubjecttypes = listSubjecttypes;
	}

	public List<WebTopic> getListParentTopics() {
		return listParentTopics;
	}

	public void setListParentTopics(List<WebTopic> listParentTopics) {
		this.listParentTopics = listParentTopics;
	}

	
	
}
