package forward.chuwa.hfjy.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the test_user database table.
 * 
 */
@Entity
@Table(name="sys_user")
@NamedQuery(name="SysUser.findAll", query="SELECT s FROM SysUser s")
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String loginname;
	private String password;
	private String name;
	private String deleteflag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
}