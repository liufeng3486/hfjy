package forward.chuwa.hfjy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import forward.chuwa.hfjy.dao.WebArticleDao;
import forward.chuwa.hfjy.dao.WebArticleRecordDao;
import forward.chuwa.hfjy.dao.WebTopicDao;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebArticleRecord;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.utility.DictionaryUtil;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private WebArticleDao webArticleDao;
	@Autowired
	private WebTopicDao webTopicDao;
	@Autowired
	private WebArticleRecordDao webArticleRecordDao;
	

	@Transactional(propagation = Propagation.REQUIRED)
	public WebArticle createWebArticle(String title, String description,
			String articlephoto, String articleimg, String articlecontent,
			String provinceid, String gradeid, Date publishdate, String author,
			String seo, String relevantarticle, String selectedTopics) {
		Date now = new Date();
		WebArticle webArticle = new WebArticle();
		webArticle.setTitle(title);
		webArticle.setDescription(description);
		webArticle.setArticlephoto(articlephoto);
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
		
		if(!StringUtils.isEmpty(selectedTopics)){
			webArticle.setWebTopics(webTopicDao.find(" and t.id in ("+selectedTopics+") "));
		}else{
			webArticle.setWebTopics(new ArrayList<WebTopic>());
		}
		
		return webArticleDao.save(webArticle);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public WebArticle updateWebArticle(Long id, String title, String description,
			String articlephoto, String articleimg, String articlecontent,
			String provinceid, String gradeid, Date publishdate, String author,
			String seo, String relevantarticle, String selectedTopics) {
		WebArticle webArticle = webArticleDao.load(id);
		Date now = new Date();
		webArticle.setTitle(title);
		webArticle.setDescription(description);
		webArticle.setArticlephoto(articlephoto);
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
		
		if(!StringUtils.isEmpty(selectedTopics)){
			webArticle.setWebTopics(webTopicDao.find(" and t.id in ("+selectedTopics+") "));
		}else{
			webArticle.setWebTopics(new ArrayList<WebTopic>());
		}
		
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
		return webArticleDao.find(" and t.deleteflag = '"
				+ DictionaryUtil.DELETE_FLAG0 + "'" + condition);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<WebArticle> findWebArticles(String condition, int start, int length) {
		return webArticleDao.find(" and t.deleteflag = '"
				+ DictionaryUtil.DELETE_FLAG0 + "'" + condition, start, length);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long countWebArticles(String condition){
		return webArticleDao.count(" and t.deleteflag = '"
				+ DictionaryUtil.DELETE_FLAG0 + "'" + condition);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public WebArticleRecord createWebArticleRecord(Long articleid,Long createid){
		WebArticleRecord	webArticleRecord = new WebArticleRecord();
		webArticleRecord.setArticleid(articleid);
		webArticleRecord.setCreateid(createid);
		webArticleRecord.setCreatedate(new Date());
		return webArticleRecordDao.save(webArticleRecord);
	}
}
