package forward.chuwa.hfjy.action.topic;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.SysDictionary;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Action("highschool")
public class Highschool extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private SystemService systemService;
	
	private List<SysProvince> listSysProvinces;//省份

	public String execute() {
		listSysProvinces = systemService.findSysProvinces(" and t.parentid != 0 ");
		return INPUT;
	}

	public List<SysProvince> getListSysProvinces() {
		return listSysProvinces;
	}

	public void setListSysProvinces(List<SysProvince> listSysProvinces) {
		this.listSysProvinces = listSysProvinces;
	}
	
}
