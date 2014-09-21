package forward.chuwa.hfjy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.TestUserDao;
import forward.chuwa.hfjy.model.TestUser;
import forward.chuwa.hfjy.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestUserDao testUserDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TestUser createTestUser(String name, Date birthday, String address,
			String phone, String email) {
		TestUser user = new TestUser();
		user.setName(name);
		user.setBirthday(birthday);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		testUserDao.save(user);
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public TestUser updateTestUser(Long id, String name, Date birthday,
			String address, String phone, String email) {
		TestUser user = testUserDao.load(id);
		user.setName(name);
		user.setBirthday(birthday);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		testUserDao.update(user);
		return user;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteTestUser(Long id) {
		testUserDao.delete(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TestUser loadTestUser(Long id){
		return testUserDao.load(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TestUser> findTestUsers(String condition){
		return testUserDao.find(condition);
	}
}
