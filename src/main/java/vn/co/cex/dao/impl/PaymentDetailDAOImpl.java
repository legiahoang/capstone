package vn.co.cex.dao.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;

import vn.co.cex.dao.PaymentDetailDAO;
import vn.co.cex.orm.PaymentDetail;
import vn.co.cex.orm.UsersAccount;

public class PaymentDetailDAOImpl extends BaseDAOImpl implements PaymentDetailDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5166337875796970702L;
	private static final Logger log = LogManager.getLogger(PaymentDetailDAOImpl.class);

	/**
	 * Add payment detail
	 */
	public boolean addPaymentDetail(PaymentDetail paymentDetail) {
		try {
			paymentDetail.setUsersAccount(new UsersAccount(paymentDetail.getUserId()));
			paymentDetail.setPaymentDate(new Date());

			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("SELECT Balance FROM usersaccount WHERE UserId = ? LIMIT 1");
			query.setParameter(0, paymentDetail.getUserId());
			Float balance = (Float) query.uniqueResult();

			paymentDetail.setBalance(balance);

			insert(paymentDetail);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Search user
	 */
	public List<PaymentDetail> searchPaymentDetailUser(Date beginPaymentDate, Date endPaymentDate, int userId,
			int pageSize, int pageIndex) {
		String formattedBeginPaymentDate = "";
		String formattedEndPaymentDate = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		List<PaymentDetail> result = new ArrayList<PaymentDetail>();
		try {
			StringBuilder sqlQueryString = new StringBuilder();
			sqlQueryString.append(" SELECT * FROM paymentdetail ");
			sqlQueryString.append(" WHERE UserId = ? ");
			if (beginPaymentDate != null) {
				formattedBeginPaymentDate = dateFormat.format(beginPaymentDate);
				sqlQueryString.append(" AND PaymentDate > '" + formattedBeginPaymentDate + "' ");
			}
			if (endPaymentDate != null) {
				formattedEndPaymentDate = dateFormat.format(endPaymentDate);
				sqlQueryString.append(" AND PaymentDate < '" + formattedEndPaymentDate + "' ");
			}
			sqlQueryString.append(" ORDER BY Id DESC ");
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setParameter(0, userId);
			query.setResultTransformer(new AliasToBeanResultTransformer(PaymentDetail.class));
			query.setMaxResults(pageSize);
			query.setFirstResult(pageIndex);

			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Count PaymentDetail User
	 */
	public int countPaymentDetailUser(Date beginPaymentDate, Date endPaymentDate, int userId) {

		BigInteger result = new BigInteger("0");
		String formattedBeginPaymentDate = "";
		String formattedEndPaymentDate = "";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			StringBuilder sqlQueryString = new StringBuilder();
			sqlQueryString.append(" SELECT COUNT(Id) FROM paymentdetail ");
			sqlQueryString.append(" WHERE UserId = ? ");
			if (beginPaymentDate != null) {
				formattedBeginPaymentDate = dateFormat.format(beginPaymentDate);

				sqlQueryString.append(" AND PaymentDate >= '" + formattedBeginPaymentDate + "' ");
			}
			if (endPaymentDate != null) {
				formattedEndPaymentDate = dateFormat.format(endPaymentDate);
				sqlQueryString.append(" AND PaymentDate <= '" + formattedEndPaymentDate + "' ");
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setParameter(0, userId);

			result = (BigInteger) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result.intValue();
	}
}
