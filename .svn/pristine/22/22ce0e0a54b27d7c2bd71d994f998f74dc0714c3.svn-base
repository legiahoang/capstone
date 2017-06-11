package vn.co.cex.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.transaction.annotation.Transactional;
import vn.co.cex.dao.OperationFeeDAO;
import vn.co.cex.orm.OperationFee;

public class OperationFeeDAOImpl extends BaseDAOImpl implements OperationFeeDAO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 310281440873897961L;
	private static final Logger log = LogManager.getLogger(OperationFeeDAOImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.co.cex.dao.OperationFeeDAO#getAllOperationFee()
	 */
	@Transactional
	public List<OperationFee> getAllOperationFee(Integer status) {
		List<OperationFee> operationFees = new ArrayList<OperationFee>();
		try {
			Session session = getSessionFactory().getCurrentSession();
			StringBuilder sqlSelect = new StringBuilder();
			sqlSelect.append(" SELECT * FROM OperationFee ");
			if (status == null) {
				sqlSelect.append(" WHERE Status = 1 ORDER BY Code ");
			} else {
				if (status == 0) {
					sqlSelect.append(" WHERE Status = 0 ORDER BY Code ");
				} else if (status == 1) {
					sqlSelect.append(" WHERE Status = 1 ORDER BY Code ");
				} else {
					sqlSelect.append(" ORDER BY Code ");
				}
			}
			SQLQuery query = session.createSQLQuery(sqlSelect.toString());
			query.addEntity(OperationFee.class);
			operationFees = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return operationFees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.co.cex.dao.OperationFeeDAO#addNewOperationFee(vn.co.cex.orm.
	 * OperationFee)
	 */
	public boolean addNewOperationFee(OperationFee operationFee) {
		try {
			operationFee.setCreated(new Date());
			operationFee.setModified(new Date());
			insert(operationFee);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.co.cex.dao.OperationFeeDAO#updateOperationFee(vn.co.cex.orm.
	 * OperationFee)
	 */
	public boolean updateOperationFee(OperationFee operationFee) {
		try {
			operationFee.setModified(new Date());
			update(operationFee);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see vn.co.cex.dao.OperationFeeDAO#getOperationFeeById(int)
	 */
	public OperationFee getOperationFeeById(int id) {
		OperationFee result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			String sqlQuery = "SELECT * FROM operationfee WHERE Id = ? LIMIT 1";
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setInteger(0, id);
			query.setResultTransformer(new AliasToBeanResultTransformer(OperationFee.class));
			result = (OperationFee) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.co.cex.dao.OperationFeeDAO#getOperationFeeByCode(java.lang.String)
	 */
	public OperationFee getOperationFeeByCode(String code) {
		OperationFee result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			String sqlQuery = "SELECT * FROM operationfee WHERE Code = ? LIMIT 1";
			SQLQuery query = session.createSQLQuery(sqlQuery);
			query.setParameter(0, code);
			query.setResultTransformer(new AliasToBeanResultTransformer(OperationFee.class));
			result = (OperationFee) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}
}
