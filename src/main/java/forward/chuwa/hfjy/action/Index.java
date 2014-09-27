package forward.chuwa.hfjy.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

@Namespace("/")
@Action("index")
public class Index extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	private Long id;
	private String l = "left";
	public String execute() {
		return INPUT;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getL() {
		return l;
	}

	public void setL(String l) {
		this.l = l;
	}
	

}
