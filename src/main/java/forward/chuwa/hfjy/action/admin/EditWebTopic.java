package forward.chuwa.hfjy.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.SysDictionary;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.service.TopicService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Action("editWebTopic")
public class EditWebTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private SystemService systemService;
	
	private List<SysTopictype> listSysTopictypes;//话题分类
	private List<SysProvince> listSysProvinces;//省份
	private List<SysDictionary> listUnitypes;//高校类型
	private List<SysDictionary> listUnilevels;	//高校层次
	private List<SysDictionary> listSubjecttypes;//学科
	private List<SysDictionary> listProtypes;//专业类别
	
	private List<WebTopic> listParentWebTopics;//父话题
	
	private Long id;
	
	private String name;
	private Long topictypeid;
	private Long provinceid;
	private String pinyin;
	private String unitype;
	private String unilevel;
	private String subjecttype;
	private String protype;
	private Long parentid;
	private String introduction;
	private String description;
	private String topicimg;
	private String topicphoto;
	
	
	public String execute() {
		listSysTopictypes = systemService.findSysTopictypes(" order by t.orderid");
		listSysProvinces = systemService.findSysProvinces(" and t.parentid != 0 ");
		listUnitypes = systemService.findSysDictionaryByType(DictionaryUtil.DICTIONARY_TYPE1);
		listUnilevels = systemService.findSysDictionaryByType(DictionaryUtil.DICTIONARY_TYPE2);
		listSubjecttypes = systemService.findSysDictionaryByType(DictionaryUtil.DICTIONARY_TYPE3);
		listProtypes = systemService.findSysDictionaryByType(DictionaryUtil.DICTIONARY_TYPE4);
		StringBuilder sb = new StringBuilder();
		sb.append(" and ( t.parentid = 0 or t.parentid is null ) ");
		
		if(id!=null && id >0){
			WebTopic webTopic = topicService.loadWebTopic(id);
			name = webTopic.getName();
			topictypeid = webTopic.getTopictypeid();
			provinceid = webTopic.getProvinceid();
			pinyin = webTopic.getPinyin();
			unitype = webTopic.getUnitype();
			unilevel = webTopic.getUnilevel();
			subjecttype = webTopic.getSubjecttype();
			protype = webTopic.getProtype();
			parentid = webTopic.getParentid();
			introduction = webTopic.getIntroduction();
			description = webTopic.getDescription();
			topicimg =  webTopic.getTopicimg();
			topicphoto = webTopic.getTopicphoto();
			sb.append(" and t.id != " + id);
		}
		
		listParentWebTopics = topicService.findWebTopics(sb.toString());
		return INPUT;
	}
	
	public void save(){
		if (id != null && id > 0) {
			topicService.updateWebTopic(id, name, topictypeid, provinceid,
					pinyin, parentid, unitype, unilevel, subjecttype, protype,
					topicimg, topicphoto,introduction,description);
		} else {
			topicService.createWebTopic(name, topictypeid, provinceid, pinyin,
					parentid, unitype, unilevel, subjecttype, protype, topicimg, topicphoto,
					introduction,description);
		}
	}


	public List<SysDictionary> getListUnitypes() {
		return listUnitypes;
	}


	public void setListUnitypes(List<SysDictionary> listUnitypes) {
		this.listUnitypes = listUnitypes;
	}


	public List<SysDictionary> getListUnilevels() {
		return listUnilevels;
	}


	public void setListUnilevels(List<SysDictionary> listUnilevels) {
		this.listUnilevels = listUnilevels;
	}


	public List<SysDictionary> getListSubjecttypes() {
		return listSubjecttypes;
	}


	public void setListSubjecttypes(List<SysDictionary> listSubjecttypes) {
		this.listSubjecttypes = listSubjecttypes;
	}


	public List<SysDictionary> getListProtypes() {
		return listProtypes;
	}


	public void setListProtypes(List<SysDictionary> listProtypes) {
		this.listProtypes = listProtypes;
	}


	public List<WebTopic> getListParentWebTopics() {
		return listParentWebTopics;
	}


	public void setListParentWebTopics(List<WebTopic> listParentWebTopics) {
		this.listParentWebTopics = listParentWebTopics;
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


	public String getSubjecttype() {
		return subjecttype;
	}


	public void setSubjecttype(String subjecttype) {
		this.subjecttype = subjecttype;
	}


	public String getProtype() {
		return protype;
	}


	public void setProtype(String protype) {
		this.protype = protype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTopicimg() {
		return topicimg;
	}

	public void setTopicimg(String topicimg) {
		this.topicimg = topicimg;
	}

	public String getTopicphoto() {
		return topicphoto;
	}

	public void setTopicphoto(String topicphoto) {
		this.topicphoto = topicphoto;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	
}
