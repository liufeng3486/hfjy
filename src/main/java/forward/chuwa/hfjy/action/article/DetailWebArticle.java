package forward.chuwa.hfjy.action.article;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebFav;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.UserService;

@Action("detailWebArticle")
public class DetailWebArticle extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private UserService userService;

	private Long id;
	private WebArticle webArticle;
	private List<WebArticle> listWebArticles;// 相关话题

	private List<WebFav> listWebFavs;// 收藏夹

	private String ifFav = "0";

	public String execute() {
		if (id != null && id > 0) {
			webArticle = articleService.loadWebArticle(id);
			articleService.createWebArticleRecord(id, null);

			if (!StringUtils.isEmpty(webArticle.getRelevantarticle())) {
				listWebArticles = articleService
						.findWebArticles(" and t.id in ("
								+ webArticle.getRelevantarticle() + ") ");
			} else {
				listWebArticles = articleService.findWebArticles(
						" order by getArticleRecord(t.id) desc ", 0, 3);
			}

			if (getUserInfo() != null) {
				listWebFavs = userService.findWebFavs(" and t.userid = "
						+ getUserInfo().getUserId());
				if (userService.countWebfavs(" and t.userid ="
						+ getUserInfo().getUserId()
						+ " and exists (from t.webArticles t1 where t1.id = "
						+ id + " ) ") > 0) {
					ifFav = "1";
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

	public WebArticle getWebArticle() {
		return webArticle;
	}

	public void setWebArticle(WebArticle webArticle) {
		this.webArticle = webArticle;
	}

	public List<WebArticle> getListWebArticles() {
		return listWebArticles;
	}

	public void setListWebArticles(List<WebArticle> listWebArticles) {
		this.listWebArticles = listWebArticles;
	}

	public List<WebFav> getListWebFavs() {
		return listWebFavs;
	}

	public void setListWebFavs(List<WebFav> listWebFavs) {
		this.listWebFavs = listWebFavs;
	}

	public String getIfFav() {
		return ifFav;
	}

	public void setIfFav(String ifFav) {
		this.ifFav = ifFav;
	}

}
