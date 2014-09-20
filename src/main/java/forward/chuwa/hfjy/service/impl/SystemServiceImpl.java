package forward.chuwa.hfjy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.SysDictionaryDao;
import forward.chuwa.hfjy.dao.SysProvinceDao;
import forward.chuwa.hfjy.dao.SysTopictypeDao;
import forward.chuwa.hfjy.model.SysDictionary;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService{

	@Autowired
	private SysTopictypeDao sysTopictypeDao;
	@Autowired
	private SysProvinceDao sysProvinceDao;
	@Autowired
	private SysDictionaryDao sysDictionaryDao;


	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<SysTopictype> findSysTopictypes(String condition){
		return sysTopictypeDao.find(condition);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<SysProvince> findSysProvinces(String condition){
		return sysProvinceDao.find(condition);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<SysDictionary> findSysDictionaryByType(String dictype) {
		return sysDictionaryDao.find(" and t.dictype ='" + dictype
				+ "' order by t.orderid ");
	}
}
