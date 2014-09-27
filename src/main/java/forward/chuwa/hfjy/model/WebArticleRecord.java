package forward.chuwa.hfjy.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the test_user database table.
 * 
 */
@Entity
@Table(name="web_article_record")
@NamedQuery(name="WebArticleRecord.findAll", query="SELECT w FROM WebArticleRecord w")
public class WebArticleRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long articleid;
	private Long createid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getArticleid() {
		return articleid;
	}
	public void setArticleid(Long articleid) {
		this.articleid = articleid;
	}
	public Long getCreateid() {
		return createid;
	}
	public void setCreateid(Long createid) {
		this.createid = createid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	
}