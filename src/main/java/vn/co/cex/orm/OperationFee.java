package vn.co.cex.orm;

import java.util.Date;

public class OperationFee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5398006186673680150L;
	private Integer id;
	private String code;
	private String feeName;
	private boolean type;
	private Float fee;
	private Float percent;
	private String description;
	private int status;
	private Date modified;
	private Date created;

	public OperationFee() {

	}

	public OperationFee(String code, String feeName, boolean type, Float fee, Float percent, String description,
			int status, Date modified, Date created) {
		super();
		this.code = code;
		this.feeName = feeName;
		this.type = type;
		this.fee = fee;
		this.percent = percent;
		this.description = description;
		this.status = status;
		this.modified = modified;
		this.created = created;
	}

	public OperationFee(Integer id, String code, String feeName, boolean type, Float fee, Float percent,
			String description, int status, Date modified, Date created) {
		super();
		this.id = id;
		this.code = code;
		this.feeName = feeName;
		this.type = type;
		this.fee = fee;
		this.percent = percent;
		this.description = description;
		this.status = status;
		this.modified = modified;
		this.created = created;
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

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}