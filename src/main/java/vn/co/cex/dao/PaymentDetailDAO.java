package vn.co.cex.dao;

import java.util.Date;
import java.util.List;

import vn.co.cex.orm.PaymentDetail;

public interface PaymentDetailDAO extends BaseDAO {

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
	 * @param endPaymentDateint
	 * @param userId
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	public List<PaymentDetail> searchPaymentDetailUser(Date beginPaymentDate, Date endPaymentDateint, int userId,
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
