package forward.chuwa.hfjy.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.model.SysGrade;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.model.WebUser;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.service.UserService;
import forward.chuwa.hfjy.utility.DictionaryUtil;
import forward.chuwa.hfjy.utility.Mail;
import forward.chuwa.hfjy.utility.UserInfo;

@Namespace("/")
@Action("index")
public class Index extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private UserService userService;
	
	private Long id;
	private String m = "main";
	
	private List<SysProvince> listSysProvinces;
	private List<SysGrade> listSysGrades;
	private String focusTopic;
	
	private String token;
	
	public String execute() {
		listSysProvinces = systemService.findSysProvinces(" order by orderid ");
		listSysGrades = systemService.findSysGrades(" order by orderid ");
		
		if (!StringUtils.isEmpty(token)) {
			if (userService.countWebUsers(" and t.dytoken = '" + token + "'") > 0) {
				WebUser webUser = userService.findWebUsers(
						" and t.dytoken = '" + token + "'").get(0);
				if (!StringUtils.equals(webUser.getIsconfirm(),
						DictionaryUtil.DELETE_FLAG1)) {
					userService.confirmWebUser(webUser.getId());
					m = "re";
				} else {
					m = "resetPW?id="+webUser.getId();
				}

				UserInfo userInfo = new UserInfo(webUser);
				getSession().setAttribute(KEY_USER_INFO, userInfo);
			}else{
				m = "re";
			}
		}
		
		if (getUserInfo() != null) {
			for (WebTopic webTopic : userService.loadWebUser(
					getUserInfo().getUserId()).getWebTopics()) {
				if (StringUtils.isEmpty(focusTopic)) {
					focusTopic = webTopic.getId() + "";
				} else {
					focusTopic += "," + webTopic.getId();
				}
			}
		}
		
		return INPUT;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getM() {
		return m;
	}

	public void setM(String m) {
		this.m = m;
	}

	public List<SysProvince> getListSysProvinces() {
		return listSysProvinces;
	}

	public void setListSysProvinces(List<SysProvince> listSysProvinces) {
		this.listSysProvinces = listSysProvinces;
	}

	public List<SysGrade> getListSysGrades() {
		return listSysGrades;
	}

	public void setListSysGrades(List<SysGrade> listSysGrades) {
		this.listSysGrades = listSysGrades;
	}

	public String getFocusTopic() {
		return focusTopic;
	}

	public void setFocusTopic(String focusTopic) {
		this.focusTopic = focusTopic;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
