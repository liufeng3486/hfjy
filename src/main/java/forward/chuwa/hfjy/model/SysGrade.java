package forward.chuwa.hfjy.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the test_user database table.
 * 
 */
@Entity
@Table(name="sys_grade")
@NamedQuery(name="SysGrade.findAll", query="SELECT s FROM SysGrade s")
public class SysGrade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String gradename;
	private String gradetype;
	private int orderid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGradename() {
		return gradename;
	}
	public void setGradename(String gradename) {
		this.gradename = gradename;
	}
	public String getGradetype() {
		return gradetype;
	}
	public void setGradetype(String gradetype) {
		this.gradetype = gradetype;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	} 
	
	
}