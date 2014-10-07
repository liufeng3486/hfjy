package forward.chuwa.hfjy.action.article;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebFav;
import forward.chuwa.hfjy.service.UserService;

@Action("favArticle")
public class FavArticle extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private UserService userService;
	
	private List<WebFav> listWebFavs;

	public String execute() {
		listWebFavs = userService.findWebFavs(" and t.userid ="
				+ getUserInfo().getUserId());
		return INPUT;
	}

	public List<WebFav> getListWebFavs() {
		return listWebFavs;
	}

	public void setListWebFavs(List<WebFav> listWebFavs) {
		this.listWebFavs = listWebFavs;
	}

	

}
