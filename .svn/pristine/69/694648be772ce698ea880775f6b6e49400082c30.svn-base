package vn.co.cex.bo.impl;

import java.util.Date;
import java.util.List;

import vn.co.cex.bo.PaymentDetailBO;
import vn.co.cex.orm.PaymentDetail;

public class PaymentDetailBOImpl extends BaseBOImpl implements PaymentDetailBO {

	/**
	 * addPaymentDetail
	 */
	public boolean addPaymentDetail(PaymentDetail paymentDetail) {

		return paymentDetailDAO.addPaymentDetail(paymentDetail);
	}

	/**
	 * searchPaymentDetailUser
	 */
	public List<PaymentDetail> searchPaymentDetailUser(Date beginPaymentDate, Date endPaymentDate, int userId,
			int pageSize, int pageIndex) {
		return paymentDetailDAO.searchPaymentDetailUser(beginPaymentDate, endPaymentDate, userId, pageSize, pageIndex);
	}

	public int countPaymentDetailUser(Date beginPaymentDate, Date endPaymentDate, int userId) {
		return paymentDetailDAO.countPaymentDetailUser(beginPaymentDate, endPaymentDate, userId);
	}
}
