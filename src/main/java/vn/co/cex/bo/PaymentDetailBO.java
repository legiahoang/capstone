package vn.co.cex.bo;

import java.util.Date;
import java.util.List;

import vn.co.cex.orm.PaymentDetail;

public interface PaymentDetailBO extends BaseBO {

	/**
	 * Add payment detail
	 * 
	 * @param paymentDetail
	 * @return
	 */
	public boolean addPaymentDetail(PaymentDetail paymentDetail);

	/**
	 * searchPaymentDetailUser
	 * 
	 * @param beginPaymentDate
	 * @param endPaymentDate
	 * @return
	 */
	public List<PaymentDetail> searchPaymentDetailUser(Date beginPaymentDate, Date endPaymentDate, int userId,
			int pageSize, int pageIndex);

	/**
	 * countPaymentDetailUser
	 * 
	 * @param beginPaymentDate
	 * @param endPaymentDate
	 * @param userId
	 * @return
	 */
	public int countPaymentDetailUser(Date beginPaymentDate, Date endPaymentDate, int userId);
}
