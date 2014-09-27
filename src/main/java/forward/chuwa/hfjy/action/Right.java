package forward.chuwa.hfjy.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.service.ArticleService;

@Namespace("/")
@Action("right")
public class Right extends BaseAction {

	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private ArticleService articleService;
	
	
	private List<WebArticle> listWebArticles;
	
	public String execute() {
		listWebArticles = articleService.findWebArticles(" order by getArticleRecord(t.id) desc ",0,5);
		return INPUT;
	}

	public List<WebArticle> getListWebArticles() {
		return listWebArticles;
	}

	public void setListWebArticles(List<WebArticle> listWebArticles) {
		this.listWebArticles = listWebArticles;
	}
	
	

}
