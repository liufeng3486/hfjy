package forward.chuwa.hfjy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.WebArticleDao;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private WebArticleDao webArticleDao;
	

	@Transactional(propagation = Propagation.REQUIRED)
	public WebArticle createWebArticle(String title, String description,
			String articleimg, String articlecontent, Long provinceid,
			Long gradeid, Date publishdate, String author, String seo,
			String relevantarticle) {
		Date now = new Date();
		WebArticle webArticle = new WebArticle();
		webArticle.setTitle(title);
		webArticle.setDescription(description);
		webArticle.setArticleimg(articleimg);
		webArticle.setArticlecontent(articlecontent);
		webArticle.setProvinceid(provinceid);
		webArticle.setGradeid(gradeid);
		webArticle.setPublishdate(publishdate);
		webArticle.setAuthor(author);
		webArticle.setSeo(seo);
		webArticle.setRelevantarticle(relevantarticle);
		webArticle.setDeleteflag(DictionaryUtil.DELETE_FLAG0);
		webArticle.setCreatedate(now);
		webArticle.setUpdatedate(now);
		webArticle.setCreateid(1L);
		webArticle.setUpdateid(1L);
		return webArticleDao.save(webArticle);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public WebArticle updateWebArticle(Long id, String title, String description,
			String articleimg, String articlecontent, Long provinceid,
			Long gradeid, Date publishdate, String author, String seo,
			String relevantarticle) {
		WebArticle webArticle = webArticleDao.load(id);
		Date now = new Date();
		webArticle.setTitle(title);
		webArticle.setDescription(description);
		webArticle.setArticleimg(articleimg);
		webArticle.setArticlecontent(articlecontent);
		webArticle.setProvinceid(provinceid);
		webArticle.setGradeid(gradeid);
		webArticle.setPublishdate(publishdate);
		webArticle.setAuthor(author);
		webArticle.setSeo(seo);
		webArticle.setRelevantarticle(relevantarticle);
		webArticle.setUpdatedate(now);
		webArticle.setUpdateid(1L);
		return webArticleDao.update(webArticle);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteWebArticle(Long id) {
		WebArticle webArticle = webArticleDao.load(id);
		webArticle.setDeleteflag(DictionaryUtil.DELETE_FLAG1);
		webArticleDao.update(webArticle);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public WebArticle loadWebArticle(Long id) {
		return webArticleDao.load(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebArticle> findWebArticles(String condition) {
		return webArticleDao.find(condition);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebArticle> findWebArticles(String condition, int start, int length) {
		return webArticleDao.find(condition, start, length);
	}
}
