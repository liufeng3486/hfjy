package forward.chuwa.hfjy.action.article;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.service.ArticleService;
@Action("listHotArticle")
public class ListHotArticle extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private ArticleService articleService;
	
	
	private List<WebArticle> listWebArticles;
	
	public String execute() {
		listWebArticles = articleService.findWebArticles(getCookieCondition()
				+ " order by getArticleRecord(t.id) desc ", getStartIndex(),
				PAGE_SIZE);
		setCount(articleService.countWebArticles(getCookieCondition()));
		return INPUT;
	}

	public List<WebArticle> getListWebArticles() {
		return listWebArticles;
	}

	public void setListWebArticles(List<WebArticle> listWebArticles) {
		this.listWebArticles = listWebArticles;
	}
	
}
