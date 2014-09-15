package forward.chuwa.hfjy.action.test;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.TestUser;
import forward.chuwa.hfjy.service.TestService;

@Action("listTestUser")
public class ListTestUser extends BaseAction {
	private static final long serialVersionUID = 9102483320610408478L;

	@Autowired
	private TestService testService;

	private List<TestUser> testUsers;

	public String execute() throws Exception {
		testUsers = testService.findTestUsers("");
		return INPUT;
	}

	public List<TestUser> getTestUsers() {
		return testUsers;
	}

	public void setTestUsers(List<TestUser> testUsers) {
		this.testUsers = testUsers;
	}
}
