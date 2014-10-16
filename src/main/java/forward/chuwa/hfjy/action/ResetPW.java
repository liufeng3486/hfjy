package forward.chuwa.hfjy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.service.UserService;

@Namespace("/")
@Action("resetPW")
public class ResetPW extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private UserService userService;
	
	private Long id;
	public String execute() {
		return INPUT;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
