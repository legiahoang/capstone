package vn.co.cex.dao.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import vn.co.cex.dao.UsersAccountDAO;
import vn.co.cex.orm.Users;
import vn.co.cex.orm.UsersAccount;

public class UsersAccountDAOImpl extends BaseDAOImpl implements UsersAccountDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6598850784711544334L;
	private static final Logger log = LogManager.getLogger(UsersAccountDAOImpl.class);

	/**
	 * Create new account
	 */
	public boolean createNewAccount(int userId) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			UsersAccount usersAccount = new UsersAccount();
			usersAccount.setUserId(userId);
			usersAccount.setUser(new Users(userId));
			usersAccount.setModified(new Date());
			session.save(usersAccount);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Get account by user id
	 */
	public UsersAccount getAccountByUserId(int userId) {
		UsersAccount result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			String sqlSelect = " SELECT * FROM UsersAccount WHERE UserId = ? LIMIT 1 ";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setParameter(0, userId);
			query.setResultTransformer(new AliasToBeanResultTransformer(UsersAccount.class));

			result = (UsersAccount) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Check account
	 */
	public float checkAccount(int userId) {
		BigDecimal result = new BigDecimal(0);
		try {
			Session session = getSessionFactory().getCurrentSession();
			String sqlSelect = " SELECT Balance FROM account where UserId = ? ";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setParameter(0, userId);
			result = (BigDecimal) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result.floatValue();
	}

	/**
	 * Plus money account
	 */
	public boolean plusMoneyAccount(int userId, float amount) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			String sqlSelect = " SELECT * FROM UsersAccount where UserId = ? LIMIT 1 ";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setParameter(0, userId);
			query.setResultTransformer(new AliasToBeanResultTransformer(UsersAccount.class));

			UsersAccount usersAccount = (UsersAccount) query.uniqueResult();
			float oldAmount = usersAccount.getBalance();
			float newAmount = oldAmount + amount;
			usersAccount.setBalance(newAmount);
			usersAccount.setModified(new Date());
			session.saveOrUpdate(usersAccount);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Minus money account
	 */
	public boolean minusMoneyAccount(int userId, float amount) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			String sqlSelect = " SELECT * FROM UsersAccount where UserId = ? LIMIT 1 ";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setParameter(0, userId);
			query.setResultTransformer(new AliasToBeanResultTransformer(UsersAccount.class));

			UsersAccount usersAccount = (UsersAccount) query.uniqueResult();
			float oldAmount = usersAccount.getBalance();
			float newAmount = oldAmount - amount;
			usersAccount.setBalance(newAmount);
			usersAccount.setModified(new Date());
			session.saveOrUpdate(usersAccount);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}
}
