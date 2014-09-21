package forward.chuwa.hfjy.service;

import java.util.Date;
import java.util.List;

import forward.chuwa.hfjy.model.WebArticle;

public interface ArticleService {

	public WebArticle createWebArticle(String title, String description,
			String articleimg, String articlecontent, Long provinceid,
			Long gradeid, Date publishdate, String author, String seo,
			String relevantarticle,String selectedTopics);

	public WebArticle updateWebArticle(Long id, String title, String description,
			String articleimg, String articlecontent, Long provinceid,
			Long gradeid, Date publishdate, String author, String seo,
			String relevantarticle,String selectedTopics);

	public void deleteWebArticle(Long id);

	public WebArticle loadWebArticle(Long id);

	public List<WebArticle> findWebArticles(String condition);

	public List<WebArticle> findWebArticles(String condition, int start,
			int length);
}
