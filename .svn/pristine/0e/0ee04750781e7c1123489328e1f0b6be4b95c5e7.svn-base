package vn.co.cex.orm;

import java.util.HashSet;
import java.util.Set;


public class GoodsType implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2582917554363985451L;
	private Integer id;
	private String code;
	private String name;
	private String description;
	private Float referencePrice;
	
	private Set<BillOfLading> billOfLading = new HashSet<BillOfLading>();
	
	public GoodsType(){
		
	}
	
	public GoodsType(Integer id) {
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

	public Float getReferencePrice() {
		return referencePrice;
	}

	public void setReferencePrice(Float referencePrice) {
		this.referencePrice = referencePrice;
	}

	public Set<BillOfLading> getBillOfLading() {
		return billOfLading;
	}
	
	public void setBillOfLading(Set<BillOfLading> billOfLading) {
		this.billOfLading = billOfLading;
	}
}
