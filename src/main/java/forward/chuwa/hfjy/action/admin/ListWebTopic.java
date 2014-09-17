package forward.chuwa.hfjy.action.admin;

import org.apache.struts2.convention.annotation.Action;

import forward.chuwa.hfjy.action.BaseAction;

@Action("listWebTopic")
public class ListWebTopic extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	public String execute() {
		return INPUT;
	}
}
