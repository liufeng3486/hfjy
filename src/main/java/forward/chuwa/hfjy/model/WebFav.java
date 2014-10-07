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
@Table(name="web_fav")
@NamedQuery(name="WebFav.findAll", query="SELECT w FROM WebFav w")
public class WebFav implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Long userid;
	
	private String name;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "web_fav_article",
		joinColumns = {@JoinColumn(name = "favid", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "articleid", referencedColumnName ="id")})
	private List<WebArticle> webArticles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WebArticle> getWebArticles() {
		return webArticles;
	}

	public void setWebArticles(List<WebArticle> webArticles) {
		this.webArticles = webArticles;
	}
	
	
}