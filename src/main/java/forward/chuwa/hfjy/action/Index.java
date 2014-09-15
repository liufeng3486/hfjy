package forward.chuwa.hfjy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/")
@Action("index")
public class Index extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	private Long id;
	public String execute() {
		id = 1230L;
		return INPUT;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
