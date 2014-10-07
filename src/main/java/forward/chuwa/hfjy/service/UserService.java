package forward.chuwa.hfjy.service;

import java.util.List;


import forward.chuwa.hfjy.model.WebUser;

public interface UserService {

	public WebUser loadWebUser(Long id);

	public WebUser login(String loginname, String password);

	public List<WebUser> findWebUsers(String condition);

	public WebUser createWebUser(String loginname, String password,
			String name, String email, Long provinceid, Long gradeid,
			String userphoto);
	
	
	public WebUser addFocusTopic(Long userid,Long topicid);
	
	public WebUser removeFocusTopic(Long userid,Long topicid);
	
	public Long countWebUsers(String condition);
}
