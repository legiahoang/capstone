package vn.co.cex.dto;

import java.util.Date;

import vn.co.cex.orm.CarrierAuction;

public class CarrierAuctionDTO extends BaseDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3981535577399214334L;
	private int id;
	private int billOfLadingId;
	private int carrierId;
	private String carrierFullName;
	private String carrierEmail;
	private String carrierPhoneNumber;
	private Date auctionDate;
	private Date modified;
	private float auctionPrice;
	private int status;
	private boolean notification;
	private String note;

	public CarrierAuction toCarrierAuction() {
		CarrierAuction result = new CarrierAuction();
		result.setId(id);
		result.setBillOfLadingId(billOfLadingId);
		result.setCarrierId(carrierId);
		result.setAuctionDate(auctionDate);
		result.setModified(modified);
		result.setAuctionPrice(auctionPrice);
		result.setStatus(status);
		result.setNotification(notification);
		result.setNote(note);
		return result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBillOfLadingId() {
		return billOfLadingId;
	}

	public void setBillOfLadingId(int billOfLadingId) {
		this.billOfLadingId = billOfLadingId;
	}

	public int getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(int carrierId) {
		this.carrierId = carrierId;
	}

	public String getCarrierFullName() {
		return carrierFullName;
	}

	public void setCarrierFullName(String carrierFullName) {
		this.carrierFullName = carrierFullName;
	}

	public String getCarrierEmail() {
		return carrierEmail;
	}

	public void setCarrierEmail(String carrierEmail) {
		this.carrierEmail = carrierEmail;
	}

	public String getCarrierPhoneNumber() {
		return carrierPhoneNumber;
	}

	public void setCarrierPhoneNumber(String carrierPhoneNumber) {
		this.carrierPhoneNumber = carrierPhoneNumber;
	}

	public Date getAuctionDate() {
		return auctionDate;
	}

	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public float getAuctionPrice() {
		return auctionPrice;
	}

	public void setAuctionPrice(float auctionPrice) {
		this.auctionPrice = auctionPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
