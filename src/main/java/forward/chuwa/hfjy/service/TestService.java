package forward.chuwa.hfjy.service;

import java.util.List;

import forward.chuwa.hfjy.model.TestUser;

public interface TestService {
	
	public TestUser loadTestUser(Long id);
	
	public List<TestUser> findTestUsers(String condition);
}
