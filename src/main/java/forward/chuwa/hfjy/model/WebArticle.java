package forward.chuwa.hfjy.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Formula;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the test_user database table.
 * 
 */
@Entity
@Table(name="web_article")
@NamedQuery(name="WebArticle.findAll", query="SELECT w FROM WebArticle w")
public class WebArticle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String description;
	private String articlephoto;
	private String articleimg;
	private String articlecontent;
	private String provinceid;
	private String gradeid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date publishdate;
	private String author;
	private String seo;
	private String relevantarticle;
	private String deleteflag;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	private Long createid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedate;
	private Long updateid;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "web_article_topic",
		joinColumns = {@JoinColumn(name = "articleid", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "topicid", referencedColumnName ="id")})
	private List<WebTopic> webTopics;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "web_user_article",
		joinColumns = {@JoinColumn(name = "articleid", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "userid", referencedColumnName ="id")})
	private List<WebUser> webUsers;
	
	public List<WebUser> getWebUsers() {
		return webUsers;
	}
	public void setWebUsers(List<WebUser> webUsers) {
		this.webUsers = webUsers;
	}
	@Formula("(select group_concat(t.name) from sys_province t where CONCAT(',',IFNULL(provinceid,''),',') like CONCAT('%,',t.id,',%') )")
	private String provinceName;
	
	@Formula("(select group_concat(t.gradename) from sys_grade t where CONCAT(',',IFNULL(gradeid,''),',') like CONCAT('%,',t.id,',%') )")
	private String gradeName;
	
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
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getGradeid() {
		return gradeid;
	}
	public void setGradeid(String gradeid) {
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
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Long getCreateid() {
		return createid;
	}
	public void setCreateid(Long createid) {
		this.createid = createid;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public Long getUpdateid() {
		return updateid;
	}
	public void setUpdateid(Long updateid) {
		this.updateid = updateid;
	}
	public List<WebTopic> getWebTopics() {
		return webTopics;
	}
	public void setWebTopics(List<WebTopic> webTopics) {
		this.webTopics = webTopics;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public String getArticlephoto() {
		return articlephoto;
	}
	public void setArticlephoto(String articlephoto) {
		this.articlephoto = articlephoto;
	}

	
	
}