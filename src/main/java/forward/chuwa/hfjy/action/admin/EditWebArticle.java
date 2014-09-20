package forward.chuwa.hfjy.action.admin;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import forward.chuwa.hfjy.action.BaseAction;
import forward.chuwa.hfjy.model.SysGrade;
import forward.chuwa.hfjy.model.SysProvince;
import forward.chuwa.hfjy.model.WebArticle;
import forward.chuwa.hfjy.model.WebTopic;
import forward.chuwa.hfjy.service.ArticleService;
import forward.chuwa.hfjy.service.SystemService;
import forward.chuwa.hfjy.service.TopicService;

@Action("editWebArticle")
public class EditWebArticle extends BaseAction {
	private static final long serialVersionUID = 7546855866601189738L;

	@Autowired
	private TopicService topicService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private SystemService systemService;

	private List<WebTopic> listWebTopics;// 话题
	private List<SysProvince> listSysProvinces;// 省份
	private List<SysGrade> listSysGrades;// 年级
	private List<WebArticle> listWebArticles;//相关文章

	private Long id;

	private String title;
	private String description;
	private String articleimg;
	private String articlecontent;
	private Long provinceid;
	private Long gradeid;
	private Date publishdate;
	private String author;
	private String seo;
	private String relevantarticle;

	public String execute() {
		listSysProvinces = systemService
				.findSysProvinces(" and t.parentid != 0 ");
		listSysGrades = systemService.findSysGrades(" order by orderid ");
		listWebTopics = topicService.findWebTopics("");

		StringBuilder sb = new StringBuilder();
		
		if (id != null && id > 0) {
			WebArticle webArticle = articleService.loadWebArticle(id);
			title = webArticle.getTitle();
			description = webArticle.getDescription();
			articleimg = webArticle.getArticleimg();
			articlecontent = webArticle.getArticlecontent();
			provinceid = webArticle.getProvinceid();
			gradeid = webArticle.getGradeid();
			publishdate = webArticle.getPublishdate();
			author = webArticle.getAuthor();
			seo = webArticle.getSeo();
			relevantarticle = webArticle.getRelevantarticle();
			sb.append(" and t.id != " + id);
		}
		listWebArticles = articleService.findWebArticles(sb.toString());
		
		return INPUT;
	}

	public void save() {
		if (id != null && id > 0) {
			articleService.updateWebArticle(id, title, description, articleimg,
					articlecontent, provinceid, gradeid, publishdate, author,
					seo, relevantarticle);
		} else {
			articleService.createWebArticle(title, description, articleimg,
					articlecontent, provinceid, gradeid, publishdate, author,
					seo, relevantarticle);
		}
	}

	public List<WebTopic> getListWebTopics() {
		return listWebTopics;
	}

	public void setListWebTopics(List<WebTopic> listWebTopics) {
		this.listWebTopics = listWebTopics;
	}

	public List<SysProvince> getListSysProvinces() {
		return listSysProvinces;
	}

	public void setListSysProvinces(List<SysProvince> listSysProvinces) {
		this.listSysProvinces = listSysProvinces;
	}

	public List<SysGrade> getListSysGrades() {
		return listSysGrades;
	}

	public void setListSysGrades(List<SysGrade> listSysGrades) {
		this.listSysGrades = listSysGrades;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getArticleimg() {
		return articleimg;
	}

	public void setArticleimg(String articleimg) {
		this.articleimg = articleimg;
	}

	public String getArticlecontent() {
		return articlecontent;
	}

	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}

	public Long getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(Long provinceid) {
		this.provinceid = provinceid;
	}

	public Long getGradeid() {
		return gradeid;
	}

	public void setGradeid(Long gradeid) {
		this.gradeid = gradeid;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getRelevantarticle() {
		return relevantarticle;
	}

	public void setRelevantarticle(String relevantarticle) {
		this.relevantarticle = relevantarticle;
	}

	public List<WebArticle> getListWebArticles() {
		return listWebArticles;
	}

	public void setListWebArticles(List<WebArticle> listWebArticles) {
		this.listWebArticles = listWebArticles;
	}

}
