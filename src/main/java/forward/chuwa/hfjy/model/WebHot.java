package forward.chuwa.hfjy.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the test_user database table.
 * 
 */
@Entity
@Table(name="web_hot")
@NamedQuery(name="WebHot.findAll", query="SELECT w FROM WebHot w")
public class WebHot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String hottype;
	private String relationtype;
	private Long relationid;
	private int orderid;
	private Long createid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHottype() {
		return hottype;
	}
	public void setHottype(String hottype) {
		this.hottype = hottype;
	}
	public String getRelationtype() {
		return relationtype;
	}
	public void setRelationtype(String relationtype) {
		this.relationtype = relationtype;
	}
	public Long getRelationid() {
		return relationid;
	}
	public void setRelationid(Long relationid) {
		this.relationid = relationid;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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