package vn.co.cex.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;

import vn.co.cex.dao.CompanyDAO;
import vn.co.cex.orm.Company;
import vn.co.cex.orm.Users;

/**
 * @author QuyetVu
 *
 */
public class CompanyDAOImpl extends BaseDAOImpl implements CompanyDAO {

	private static final long serialVersionUID = -5691057568506396123L;
	private static final Logger log = LogManager.getLogger(CompanyDAOImpl.class);

	/**
	 * Get PaymentDetailBean by id
	 */
	public Company getCompanyById(int id) {
		Company result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from company where id = ? LIMIT 1");
			query.setParameter(0, id);
			/*
			 * uniqueResult: Convenience method to return a single instance that
			 * matches the query, or null if the query returns no results
			 */
			query.setResultTransformer(new AliasToBeanResultTransformer(Company.class));
			result = (Company) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * get Company Information By Email
	 * 
	 * @param email
	 * @return Company
	 */
	public Company getCompanyByEmail(String email) {
		Company result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from company where email = ? LIMIT 1");
			query.setParameter(0, email);
			/*
			 * uniqueResult: Convenience method to return a single instance that
			 * matches the query, or null if the query returns no results
			 */
			query.setResultTransformer(new AliasToBeanResultTransformer(Company.class));
			result = (Company) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Update Company
	 */
	public boolean updateCompany(Company data) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			session.saveOrUpdate(data);

			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Insert Company
	 */
	public boolean InsertCompany(Company data) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			session.save(data);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}
}
