package forward.chuwa.hfjy.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.SysUser;
import forward.chuwa.hfjy.service.SystemService;

public class Ajax extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SystemService systemService;

	private String loginname;

	private String password;

	@Action(value = "ajaxLogin")
	public void changePW() {
		Long result = 0L;
		List<SysUser> listSysUser = systemService
				.findSysUsers(" and t.loginname = '" + loginname
						+ "' and t.password = '" + password + "' ");
		if (listSysUser != null && listSysUser.size() > 0) {
			result = listSysUser.get(0).getId();
		}
		writeJson(result);
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
