package forward.chuwa.hfjy.service;

import java.util.Date;
import java.util.List;

import forward.chuwa.hfjy.model.TestUser;

public interface TestService {
	
	public TestUser createTestUser(String name, Date birthday, String address,
			String phone, String email);

	public TestUser updateTestUser(Long id, String name, Date birthday,
			String address, String phone, String email);

	public void deleteTestUser(Long id);
	
	public TestUser loadTestUser(Long id);
	
	public List<TestUser> findTestUsers(String condition);
}
