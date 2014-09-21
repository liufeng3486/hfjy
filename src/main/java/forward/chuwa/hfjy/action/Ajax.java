package forward.chuwa.hfjy.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.model.SysTopictype;
import forward.chuwa.hfjy.service.SystemService;


public class Ajax extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private SystemService systemService;
	
	@Action(value = "ajaxTopicType")
	public void topicType() {
		List<SysTopictype> list = systemService.findSysTopictypes(" order by orderid ");
		writeJson(list);
	}


}
