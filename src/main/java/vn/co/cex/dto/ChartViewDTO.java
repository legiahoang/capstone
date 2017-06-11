package vn.co.cex.dto;

public class ChartViewDTO extends BaseDTO {

	private int totalBillOfLading;
	private int billOfLadingFailed;
	private int billOfLadingSucceeded;
	private Float totalValue;
	private int month;

	public int getTotalBillOfLading() {
		return totalBillOfLading;
	}

	public void setTotalBillOfLading(int totalBillOfLading) {
		this.totalBillOfLading = totalBillOfLading;
	}

	public int getBillOfLadingFailed() {
		return billOfLadingFailed;
	}

	public void setBillOfLadingFailed(int billOfLadingFailed) {
		this.billOfLadingFailed = billOfLadingFailed;
	}

	public int getBillOfLadingSucceeded() {
		return billOfLadingSucceeded;
	}

	public void setBillOfLadingSucceeded(int billOfLadingSucceeded) {
		this.billOfLadingSucceeded = billOfLadingSucceeded;
	}

	public Float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Float totalValue) {
		this.totalValue = totalValue;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
