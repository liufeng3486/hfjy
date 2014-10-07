package forward.chuwa.hfjy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.SysGradeDao;
import forward.chuwa.hfjy.dao.SysProvinceDao;
import forward.chuwa.hfjy.dao.WebUserDao;
import forward.chuwa.hfjy.model.WebUser;
import forward.chuwa.hfjy.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private WebUserDao webUserDao;

	@Autowired
	private SysProvinceDao sysProvinceDao;

	@Autowired
	private SysGradeDao sysGradeDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public WebUser loadWebUser(Long id) {
		return webUserDao.load(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public WebUser login(String loginname, String password) {
		List<WebUser> listWebUsers = webUserDao.find(" and t.loginname = '"
				+ loginname + "' and t.password = '" + password + "' ");
		if (listWebUsers != null && listWebUsers.size() > 0) {
			WebUser webUser = listWebUsers.get(0);
			webUser.setLastlogindate(new Date());
			return webUserDao.update(webUser);
		} else {
			return null;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebUser> findWebUsers(String condition) {
		return webUserDao.find(condition);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public WebUser createWebUser(String loginname, String password,
			String name, String email, Long provinceid, Long gradeid,
			String userphoto) {
		Date now = new Date();
		WebUser webUser = new WebUser();
		webUser.setLoginname(loginname);
		webUser.setPassword(password);
		webUser.setName(name);
		webUser.setEmail(email);
		webUser.setProvinceid(provinceid);

		if (provinceid != null && provinceid > 0) {
			webUser.setProvincename(sysProvinceDao.load(provinceid).getName());
		}

		webUser.setGradeid(gradeid);

		if (gradeid != null && gradeid > 0) {
			webUser.setGradename(sysGradeDao.load(gradeid).getGradename());
		}

		webUser.setUserphoto(userphoto);
		webUser.setCreatedate(now);
		webUser.setLastlogindate(now);
		return webUserDao.save(webUser);
	}
}
