package forward.chuwa.hfjy.action.article;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.service.ArticleService;

@Action("listWebArticle")
public class ListWebArticle extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private ArticleService articleService;

	private List<WebArticle> listWebArticles;
	private Long topicid;
	private String searchContent;
	
	private Long fav;

	public String execute() {
		listWebArticles = articleService.findWebArticles(getCondition()
				+ " order by publishdate desc ", getStartIndex(), PAGE_SIZE);
		setCount(articleService.countWebArticles(getCondition()));
		return INPUT;
	}

	public String getCondition() {
		StringBuilder sb = new StringBuilder();
		sb.append(getCookieCondition());
		
		if (topicid != null && topicid > 0) {
			sb.append(" and exists (from t.webTopics t1 where t1.id = "
					+ topicid + " )  ");
		}
		if (!StringUtils.isEmpty(searchContent)) {
			sb.append(" and t.title like '%" + searchContent + "%' ");
		}
		
		if (fav != null && fav > 0) {
			sb.append(" and exists (from t.webFavs t1 where t1.id = " + fav
					+ " ) ");
		}
		return sb.toString();
	}

	public List<WebArticle> getListWebArticles() {
		return listWebArticles;
	}

	public void setListWebArticles(List<WebArticle> listWebArticles) {
		this.listWebArticles = listWebArticles;
	}

	public Long getTopicid() {
		return topicid;
	}

	public void setTopicid(Long topicid) {
		this.topicid = topicid;
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public Long getFav() {
		return fav;
	}

	public void setFav(Long fav) {
		this.fav = fav;
	}

}
