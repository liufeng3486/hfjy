package forward.chuwa.hfjy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.SysDictionaryDao;
import forward.chuwa.hfjy.dao.SysGradeDao;
import forward.chuwa.hfjy.dao.SysProvinceDao;
import forward.chuwa.hfjy.dao.SysTopictypeDao;
import forward.chuwa.hfjy.dao.WebHotDao;
import forward.chuwa.hfjy.model.SysDictionary;
import forward.chuwa.hfjy.model.SysGrade;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.model.WebHot;
import forward.chuwa.hfjy.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {

	@Autowired
	private SysTopictypeDao sysTopictypeDao;
	@Autowired
	private SysProvinceDao sysProvinceDao;
	@Autowired
	private SysGradeDao sysGradeDao;
	@Autowired
	private SysDictionaryDao sysDictionaryDao;
	@Autowired
	private WebHotDao webHotDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<SysTopictype> findSysTopictypes(String condition) {
		return sysTopictypeDao.find(condition);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<SysProvince> findSysProvinces(String condition) {
		return sysProvinceDao.find(condition);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<SysGrade> findSysGrades(String condition) {
		return sysGradeDao.find(condition);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<SysDictionary> findSysDictionaryByType(String dictype) {
		return sysDictionaryDao.find(" and t.dictype ='" + dictype
				+ "' order by t.orderid ");
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public WebHot createWebHot(String hottype, String relationtype,
			Long relationid) {
		WebHot webHot = new WebHot();
		webHot.setHottype(hottype);
		webHot.setRelationtype(relationtype);
		webHot.setRelationid(relationid);
		webHot.setCreateid(1L);
		webHot.setCreatedate(new Date());
		return webHotDao.save(webHot);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteWebHot(String hottype, String relationtype,
			Long relationid) {
		List<WebHot> listWebHot = webHotDao.find(" and t.hottype = '" + hottype
				+ "' and t.relationtype = '" + relationtype
				+ "' and t.relationid = " + relationid);
		
		for(WebHot webHot:listWebHot){
			webHotDao.delete(webHot.getId());
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long countWebHots(String hottype,String relationtype,Long relationid){
		return webHotDao.count(" and t.hottype = '" + hottype
				+ "' and t.relationtype = '" + relationtype
				+ "' and t.relationid = " + relationid);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebHot> findWebHots(String condition, int start, int length) {
		return webHotDao.find(condition, start, length);
	}
}
