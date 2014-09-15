package forward.chuwa.hfjy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import forward.chuwa.hfjy.dao.TestUserDao;
import forward.chuwa.hfjy.model.TestUser;
import forward.chuwa.hfjy.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private TestUserDao testUserDao;
	
	public TestUser loadTestUser(Long id){
		return testUserDao.load(id);
	}
	
	public List<TestUser> findTestUsers(String condition){
		return testUserDao.find(condition);
	}
}
