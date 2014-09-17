package forward.chuwa.hfjy.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the test_user database table.
 * 
 */
@Entity
@Table(name="web_topic")
@NamedQuery(name="WebTopic.findAll", query="SELECT w FROM WebTopic w")
public class WebTopic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Long topictypeid;
	private Long provinceid;
	private String pinyin;
	private Long parentid;
	private String parentname;
	private String unitype;
	private String unilevel;
	private String prosubject;
	private String topicimg;
	private String topicphoto;
	private String description;
	private String deleteflag;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	private Long createid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedate;
	private Long updateid;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "web_article_topic",
		joinColumns = {@JoinColumn(name = "topicid", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "articleid", referencedColumnName ="id")})
	private List<WebArticle> webArticles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTopictypeid() {
		return topictypeid;
	}
	public void setTopictypeid(Long topictypeid) {
		this.topictypeid = topictypeid;
	}
	public Long getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(Long provinceid) {
		this.provinceid = provinceid;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	public String getUnitype() {
		return unitype;
	}
	public void setUnitype(String unitype) {
		this.unitype = unitype;
	}
	public String getUnilevel() {
		return unilevel;
	}
	public void setUnilevel(String unilevel) {
		this.unilevel = unilevel;
	}
	public String getProsubject() {
		return prosubject;
	}
	public void setProsubject(String prosubject) {
		this.prosubject = prosubject;
	}
	public String getTopicimg() {
		return topicimg;
	}
	public void setTopicimg(String topicimg) {
		this.topicimg = topicimg;
	}
	public String getTopicphoto() {
		return topicphoto;
	}
	public void setTopicphoto(String topicphoto) {
		this.topicphoto = topicphoto;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	
	
}