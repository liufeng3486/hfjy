package forward.chuwa.hfjy.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.utility.DictionaryUtil;
@Action("listWebArticle")
public class ListWebArticle extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private SystemService systemService;
	
	
	private List<WebArticle> listWebArticles;
	
	public String execute() {
		listWebArticles = articleService.findWebArticles("", getStartIndex(), PAGE_SIZE);
		setCount(articleService.countWebArticles(""));
		getTop();
		return INPUT;
	}
	
	public void getTop() {
		for (WebArticle webArticle : listWebArticles) {
			if (systemService.countWebHots(DictionaryUtil.HOT_TYPE1,
					DictionaryUtil.RELATION_TYPE2, webArticle.getId()) > 0) {
				webArticle.setSeo("1");
			} else {
				webArticle.setSeo("0");
			}
		}
	}

	public List<WebArticle> getListWebArticles() {
		return listWebArticles;
	}

	public void setListWebArticles(List<WebArticle> listWebArticles) {
		this.listWebArticles = listWebArticles;
	}
	
}
