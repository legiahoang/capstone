package vn.co.cex.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.transaction.annotation.Transactional;

import vn.co.cex.dao.UsersDAO;
import vn.co.cex.dto.UsersDTO;
import vn.co.cex.orm.Company;
import vn.co.cex.orm.District;
import vn.co.cex.orm.Users;

/**
 * @author QuyetVu
 *
 */
public class UsersDAOImpl extends BaseDAOImpl implements UsersDAO {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3036475055302245993L;
	private static final Logger log = LogManager.getLogger(UsersDAOImpl.class);

	/**
	 * Get user by id
	 */
	public Users getUserById(int id) {
		Users result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createQuery(" from Users where id = ? ");
			query.setParameter(0, id);
			/*
			 * uniqueResult: Convenience method to return a single instance that
			 * matches the query, or null if the query returns no results
			 */
			query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			result = (Users) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Check login
	 */
	@Transactional
	public Users checkLogin(String email, String password) {
		Users result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createQuery("from Users where email = ? and password = ?");
			query.setString(0, email);
			query.setString(1, password);
			query.setMaxResults(1);

			query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			result = (Users) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Update users
	 */
	public boolean updateUsers(Users data) {
		try {
			Session session = getSessionFactory().getCurrentSession();

			if (data.getCompanyId() != null) {
				data.setCompany(new Company(data.getCompanyId()));
			}
			Query query = session.createQuery(" FROM District WHERE Code = ? ");
			query.setParameter(0, data.getDistrictCode());
			query.setMaxResults(1);
			District district = (District) query.uniqueResult();
			data.setDistrict(district);
			session.saveOrUpdate(data);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Get users by email
	 */
	public Users getUserByEmail(String email) {
		Users result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM Users where email = ? LIMIT 1");
			query.setParameter(0, email);
			query.setResultTransformer(new AliasToBeanResultTransformer(Users.class));
			result = (Users) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Register user
	 */
	public int register(Users user) {
		int result = 0;
		try {
			Session session = getSessionFactory().getCurrentSession();

			Query query = session.createQuery(" FROM District WHERE Code = ? ");
			query.setParameter(0, user.getDistrictCode());
			query.setMaxResults(1);
			District district = (District) query.uniqueResult();
			user.setDistrict(district);

			result = (Integer) session.save(user);
			return result;
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	// Check Email already exited or not.
	public boolean checkEmail(String email) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("SELECT email FROM Users WHERE email = ? LIMIT 1");
			query.setResultTransformer(new AliasToBeanResultTransformer(Users.class));
			query.setParameter(0, email);
			Object result = query.uniqueResult();
			// Email already exited in database
			if (result == null) {
				return true;
			}
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	// Check phoneNumber
	public boolean checkPhoneNumber(String phoneNumber) {

		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("SELECT PhoneNumber FROM Users WHERE PhoneNumber = ? LIMIT 1");
			query.setResultTransformer(new AliasToBeanResultTransformer(Users.class));
			query.setParameter(0, phoneNumber);
			Object result = query.uniqueResult();
			// phoneNumber already exits
			if (result == null) {
				return true;
			}
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	// Check IdentityCard
	public boolean checkIdentityCard(String identityCard) {

		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("SELECT IdentityCard FROM Users WHERE IdentityCard = ? LIMIT 1");
			query.setResultTransformer(new AliasToBeanResultTransformer(Users.class));
			query.setParameter(0, identityCard);
			Object result = query.uniqueResult();
			// IdentityCard already exits
			if (result == null) {
				return true;
			}
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Search user
	 */
	public List<UsersDTO> searchUser(String fullName, String email, String province, Integer role, int status,
			int pageSize, int pageIndex) {

		List<UsersDTO> result = new ArrayList<UsersDTO>();

		try {
			StringBuilder sqlQueryString = new StringBuilder();
			sqlQueryString.append(" SELECT u.*, dt.name as 'districtName', pr.name as 'provinceName' FROM users u ");
			sqlQueryString.append(" JOIN district dt ON u.DistrictCode = dt.Code ");
			sqlQueryString.append(" JOIN province pr ON dt.ProvinceCode = pr.Code ");
			sqlQueryString.append(" WHERE u.Status IN (1,2,3) ");
			if (fullName != null && !fullName.equals("")) {
				sqlQueryString.append("AND u.fullName LIKE '%" + searchStringFormat(fullName) + "%' ");
			}
			if (email != null && !email.equals("")) {
				sqlQueryString.append("AND u.Email LIKE '%" + searchStringFormat(email) + "%' ");
			}
			if (province != null && !province.equals("")) {
				sqlQueryString.append("AND pr.Name LIKE '%" + searchStringFormat(province) + "%' ");
			}
			if (role != null && role != 0) {
				sqlQueryString.append(String.format("AND u.Role = %d ", role));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setFirstResult(pageIndex);
			query.setMaxResults(pageSize);
			query.setResultTransformer(new AliasToBeanResultTransformer(UsersDTO.class));

			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	public int countUsers(String fullName, String email, String province, Integer role, int status) {
		BigInteger result = new BigInteger("0");

		try {
			StringBuilder sqlQueryString = new StringBuilder();
			sqlQueryString.append(" SELECT COUNT(u.Id) FROM users u ");
			sqlQueryString.append(" JOIN district dt ON u.DistrictCode = dt.Code ");
			sqlQueryString.append(" JOIN province pr ON dt.ProvinceCode = pr.Code ");
			sqlQueryString.append("WHERE status IN (1,2,3) ");
			if (fullName != null && !fullName.equals("")) {
				sqlQueryString.append("AND u.FullName LIKE '%" + searchStringFormat(fullName) + "%' ");
			}
			if (email != null && !email.equals("")) {
				sqlQueryString.append("AND u.Email LIKE '%" + searchStringFormat(email) + "%' ");
			}
			if (province != null && !province.equals("")) {
				sqlQueryString.append("AND pr.Name LIKE '%" + searchStringFormat(province) + "%' ");
			}
			if (role != null && role != 0) {
				sqlQueryString.append(String.format("AND u.Role = %d ", role));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());

			result = (BigInteger) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result.intValue();
	}

	/**
	 * activate user
	 */
	public void activateUser(int user_id) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("update users set status = 2 where id = ?");
			query.setParameter(0, user_id);
			// execute update query
			query.executeUpdate();
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * deactivate the user
	 */
	public void deactivateUser(int user_id) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("update users set status = 1 where id = ?");
			query.setParameter(0, user_id);
			// execute update query
			query.executeUpdate();
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
