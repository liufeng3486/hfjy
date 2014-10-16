package forward.chuwa.hfjy.service;

import java.util.List;

import forward.chuwa.hfjy.model.SysDictionary;
import forward.chuwa.hfjy.model.SysGrade;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.model.SysUser;
import forward.chuwa.hfjy.model.WebHot;

public interface SystemService {
	public List<SysTopictype> findSysTopictypes(String condition);
	
	public List<SysProvince> findSysProvinces(String condition);
	
	public List<SysGrade> findSysGrades(String condition);
	
	public List<SysDictionary> findSysDictionaryByType(String dictype);
	
	
	public WebHot createWebHot(String hottype,String relationtype,Long relationid);
	
	public void deleteWebHot(String hottype,String relationtype,Long relationid);
	
	public Long countWebHots(String hottype,String relationtype,Long relationid);
	
	public List<WebHot> findWebHots(String condition, int start,
			int length);
	
	public List<SysUser> findSysUsers(String condition);
}
