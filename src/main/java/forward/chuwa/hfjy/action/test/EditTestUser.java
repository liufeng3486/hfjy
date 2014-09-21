package forward.chuwa.hfjy.action.test;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.TestUser;
import forward.chuwa.hfjy.service.TestService;

@Action("editTestUser")
@Results({ @Result(name = "success", location = "listTestUser", type = "redirect"),
	@Result(name = "back", location = "listTestUser", type="redirect") })
public class EditTestUser extends BaseAction {

	private static final long serialVersionUID = 8670581058377241931L;

	private long id = -1;

	private String name;

	private Date birthday;

	private String address;

	private String phone;

	private String email;

	@Autowired
	private TestService testService;

	public String execute() {
		if (id != -1) {
			TestUser user = testService.loadTestUser(id);
			setName(user.getName());
			setBirthday(user.getBirthday());
			setAddress(user.getAddress());
			setPhone(user.getPhone());
			setEmail(user.getEmail());
		}

		return INPUT;
	}

	public String save() {
		if (id != -1) {
			testService.updateTestUser(id, name, birthday, address, phone,
					email);
		} else {
			testService.createTestUser(name, birthday, address, phone, email);
		}

		return SUCCESS;
	}

	public String delete() {
		if (id != -1) {
			testService.deleteTestUser(id);
		}

		return SUCCESS;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
