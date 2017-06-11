package vn.co.cex.orm;

import java.util.HashSet;
import java.util.Set;

public class District implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6745859651992652698L;
	private Integer id;
	private String code;
	private String name;
	private String type;
	private String provinceCode;
	private Province province;

	private Set<Users> users = new HashSet<Users>();

	public District() {
	}

	public District(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
}
