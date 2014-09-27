package forward.chuwa.hfjy.action.article;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.service.ArticleService;
@Action("listLastArticle")
public class ListLastArticle extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private ArticleService articleService;
	
	
	private List<WebArticle> listWebArticles;
	
	public String execute() {
		listWebArticles = articleService.findWebArticles(" order by publishdate desc ",getStartIndex(),PAGE_SIZE);
		setCount(articleService.countWebArticles(""));
		return INPUT;
	}

	public List<WebArticle> getListWebArticles() {
		return listWebArticles;
	}

	public void setListWebArticles(List<WebArticle> listWebArticles) {
		this.listWebArticles = listWebArticles;
	}
	
}
