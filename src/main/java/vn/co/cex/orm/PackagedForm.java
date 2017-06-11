package vn.co.cex.orm;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

public class PackagedForm implements java.io.Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 6229382415683190967L;
	private Integer id;
	private String code;
	private String name;
	private String description;
	
	@Cascade({CascadeType.PERSIST})
	private Set<BillOfLading> billOfLading = new HashSet<BillOfLading>(0);

	public PackagedForm() {
	}
	
	public PackagedForm(Integer id) {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<BillOfLading> getBillOfLading() {
		return billOfLading;
	}

	public void setBillOfLading(Set<BillOfLading> billOfLading) {
		this.billOfLading = billOfLading;
	}
}
