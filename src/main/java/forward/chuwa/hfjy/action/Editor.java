package forward.chuwa.hfjy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/")
@Action("editor")
public class Editor extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String c;
	public String execute() {
		return INPUT;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}
	

}
