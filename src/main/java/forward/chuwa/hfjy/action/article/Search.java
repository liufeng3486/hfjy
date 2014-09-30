package forward.chuwa.hfjy.action.article;


import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.service.ArticleService;

@Action("search")
public class Search extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private ArticleService articleService;

	private String searchContent;

	public String execute() {
		setCount(articleService.countWebArticles(getCondition()));
		return INPUT;
	}

	public String getCondition() {
		StringBuilder sb = new StringBuilder();
		if (!StringUtils.isEmpty(searchContent)) {
			sb.append(" and t.title like '%" + searchContent + "%'");
		}
		return sb.toString();
	}

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

}
