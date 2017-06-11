package vn.co.cex.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UsersAccount implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6731751145177534198L;
	private Integer userId;
	private Users user;
	private float balance;
	private Date modified;

	private Set<PaymentDetail> paymentDetail = new HashSet<PaymentDetail>();

	public UsersAccount() {

	}

	public UsersAccount(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Set<PaymentDetail> getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(Set<PaymentDetail> paymentDetail) {
		this.paymentDetail = paymentDetail;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
