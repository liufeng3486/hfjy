package forward.chuwa.hfjy.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.service.TopicService;

@Action("editWebTopic")
public class EditWebTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private SystemService systemService;
	
	private List<SysTopictype> listSysTopictypes;
	private List<SysProvince> listSysProvinces;
	
	private Long id;
	
	private String name;
	private Long topictypeid;
	private Long provinceid;
	private String pinyin;
	private Long parentid;
	
	
	public String execute() {
		listSysTopictypes = systemService.findSysTopictypes(" order by t.orderid");
		listSysProvinces = systemService.findSysProvinces(" and t.parentid != 0 ");
		return INPUT;
	}


	public TopicService getTopicService() {
		return topicService;
	}


	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}


	public SystemService getSystemService() {
		return systemService;
	}


	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}


	public List<SysTopictype> getListSysTopictypes() {
		return listSysTopictypes;
	}


	public void setListSysTopictypes(List<SysTopictype> listSysTopictypes) {
		this.listSysTopictypes = listSysTopictypes;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getTopictypeid() {
		return topictypeid;
	}


	public void setTopictypeid(Long topictypeid) {
		this.topictypeid = topictypeid;
	}


	public Long getProvinceid() {
		return provinceid;
	}


	public void setProvinceid(Long provinceid) {
		this.provinceid = provinceid;
	}


	public String getPinyin() {
		return pinyin;
	}


	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}


	public Long getParentid() {
		return parentid;
	}


	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}


	public List<SysProvince> getListSysProvinces() {
		return listSysProvinces;
	}


	public void setListSysProvinces(List<SysProvince> listSysProvinces) {
		this.listSysProvinces = listSysProvinces;
	}


	
	
}
