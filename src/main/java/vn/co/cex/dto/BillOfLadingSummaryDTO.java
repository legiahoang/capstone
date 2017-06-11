package vn.co.cex.dto;

import java.util.Date;

public class BillOfLadingSummaryDTO extends BaseDTO {

	private int totalBillOfLading;
	private double totalValue;
	private int billOfLadingAuctionBidding;
	private int billOfLadingAuctionSuccess;
	private int billOfLadingAuctionCompletion;
	private int billOfLadingAuctionFailure;
	private int billOfLadingAuctionCarrierCanceled;
	private int billOfLadingAuctionGoodsOwnerCanceled;

	private String goodsType;
	private String packForm;
	
	private String departureProvince;
	private String arrivalProvince;

	private Date dateTimeFrom;
	private Date dateTimeTo;

	public int getTotalBillOfLading() {
		return totalBillOfLading;
	}

	public void setTotalBillOfLading(int totalBillOfLading) {
		this.totalBillOfLading = totalBillOfLading;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public int getBillOfLadingAuctionBidding() {
		return billOfLadingAuctionBidding;
	}

	public void setBillOfLadingAuctionBidding(int billOfLadingAuctionBidding) {
		this.billOfLadingAuctionBidding = billOfLadingAuctionBidding;
	}

	public int getBillOfLadingAuctionSuccess() {
		return billOfLadingAuctionSuccess;
	}

	public void setBillOfLadingAuctionSuccess(int billOfLadingAuctionSuccess) {
		this.billOfLadingAuctionSuccess = billOfLadingAuctionSuccess;
	}

	public int getBillOfLadingAuctionCompletion() {
		return billOfLadingAuctionCompletion;
	}

	public void setBillOfLadingAuctionCompletion(int billOfLadingAuctionCompletion) {
		this.billOfLadingAuctionCompletion = billOfLadingAuctionCompletion;
	}

	public int getBillOfLadingAuctionFailure() {
		return billOfLadingAuctionFailure;
	}

	public void setBillOfLadingAuctionFailure(int billOfLadingAuctionFailure) {
		this.billOfLadingAuctionFailure = billOfLadingAuctionFailure;
	}

	public int getBillOfLadingAuctionCarrierCanceled() {
		return billOfLadingAuctionCarrierCanceled;
	}

	public void setBillOfLadingAuctionCarrierCanceled(int billOfLadingAuctionCarrierCanceled) {
		this.billOfLadingAuctionCarrierCanceled = billOfLadingAuctionCarrierCanceled;
	}

	public int getBillOfLadingAuctionGoodsOwnerCanceled() {
		return billOfLadingAuctionGoodsOwnerCanceled;
	}

	public void setBillOfLadingAuctionGoodsOwnerCanceled(int billOfLadingAuctionGoodsOwnerCanceled) {
		this.billOfLadingAuctionGoodsOwnerCanceled = billOfLadingAuctionGoodsOwnerCanceled;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getPackForm() {
		return packForm;
	}

	public void setPackForm(String packForm) {
		this.packForm = packForm;
	}

	public String getDepartureProvince() {
		return departureProvince;
	}

	public void setDepartureProvince(String departureProvince) {
		this.departureProvince = departureProvince;
	}

	public String getArrivalProvince() {
		return arrivalProvince;
	}

	public void setArrivalProvince(String arrivalProvince) {
		this.arrivalProvince = arrivalProvince;
	}

	public Date getDateTimeFrom() {
		return dateTimeFrom;
	}

	public void setDateTimeFrom(Date dateTimeFrom) {
		this.dateTimeFrom = dateTimeFrom;
	}

	public Date getDateTimeTo() {
		return dateTimeTo;
	}

	public void setDateTimeTo(Date dateTimeTo) {
		this.dateTimeTo = dateTimeTo;
	}
}
