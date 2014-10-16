package forward.chuwa.hfjy.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.model.WebUser;
import forward.chuwa.hfjy.service.UserService;
import forward.chuwa.hfjy.utility.Mail;

@Namespace("/")
@Action("confirmUser")
@Results({
	@Result(name = "success", location = "resetPWmail.jsp") })
public class ConfirmUser extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	
	@Autowired
	private UserService userService;
	
	private Long id;
	private String name;
	private String token;
	
	private int type;
	private String date;
	
	public String execute() {
		WebUser webUser = userService.loadWebUser(id);
		name = webUser.getName();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		date = sdf.format(new Date());
		token = Mail.MD5(webUser.getId() + "_"+sdf.format(new Date()));
		userService.updateToken(webUser.getId(),token);
		if(type ==0){
			return INPUT;
		}else{
			return SUCCESS;
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
