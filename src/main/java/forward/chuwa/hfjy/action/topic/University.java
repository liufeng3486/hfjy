package forward.chuwa.hfjy.action.topic;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.SysDictionary;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Action("university")
public class University extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private SystemService systemService;
	
	private List<SysProvince> listSysProvinces;//省份
	private List<SysDictionary> listUnitypes;//高校类型
	private List<SysDictionary> listUnilevels;	//高校层次

	public String execute() {
		listSysProvinces = systemService.findSysProvinces(" and t.parentid != 0 ");
		listUnitypes = systemService.findSysDictionaryByType(DictionaryUtil.DICTIONARY_TYPE1);
		listUnilevels = systemService.findSysDictionaryByType(DictionaryUtil.DICTIONARY_TYPE2);
		return INPUT;
	}

	public List<SysProvince> getListSysProvinces() {
		return listSysProvinces;
	}

	public void setListSysProvinces(List<SysProvince> listSysProvinces) {
		this.listSysProvinces = listSysProvinces;
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

	
}
