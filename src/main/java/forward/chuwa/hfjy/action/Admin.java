package forward.chuwa.hfjy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/")
@Action("admin")
public class Admin extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	public String execute() {
		return INPUT;
	}
}
