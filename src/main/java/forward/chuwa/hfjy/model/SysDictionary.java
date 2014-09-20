package forward.chuwa.hfjy.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the test_user database table.
 * 
 */
@Entity
@Table(name="sys_dictionary")
@NamedQuery(name="SysDictionary.findAll", query="SELECT s FROM SysDictionary s")
public class SysDictionary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String dictype;
	private String dickey;
	private String dicvalue;
	private String parentkey;
	private int orderid;
	private String remark;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDictype() {
		return dictype;
	}
	public void setDictype(String dictype) {
		this.dictype = dictype;
	}
	public String getDickey() {
		return dickey;
	}
	public void setDickey(String dickey) {
		this.dickey = dickey;
	}
	public String getDicvalue() {
		return dicvalue;
	}
	public void setDicvalue(String dicvalue) {
		this.dicvalue = dicvalue;
	}
	public String getParentkey() {
		return parentkey;
	}
	public void setParentkey(String parentkey) {
		this.parentkey = parentkey;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}