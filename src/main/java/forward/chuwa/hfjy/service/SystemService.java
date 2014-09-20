package forward.chuwa.hfjy.service;

import java.util.List;

import forward.chuwa.hfjy.model.SysDictionary;
import forward.chuwa.hfjy.model.SysGrade;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.SysTopictype;

public interface SystemService {
	public List<SysTopictype> findSysTopictypes(String condition);
	
	public List<SysProvince> findSysProvinces(String condition);
	
	public List<SysGrade> findSysGrades(String condition);
	
	public List<SysDictionary> findSysDictionaryByType(String dictype);
}
