package vn.co.cex.orm;

import java.util.HashSet;
import java.util.Set;

public class Province implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8899726962324099233L;
	private Integer id;
	private String code;
	private String name;
	private String type;
	
	private Set<District> district = new HashSet<District>();
	
	public Province(){
		
	}
	
	public Province(Integer id){
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
	public Set<District> getDistrict() {
		return district;
	}
	public void setDistrict(Set<District> district) {
		this.district = district;
	}
}
