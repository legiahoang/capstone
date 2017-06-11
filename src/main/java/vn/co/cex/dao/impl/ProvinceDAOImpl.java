package vn.co.cex.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;

import vn.co.cex.dao.ProvinceDAO;
import vn.co.cex.orm.Province;

public class ProvinceDAOImpl extends BaseDAOImpl implements ProvinceDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5696418618703715134L;
	private static final Logger log = LogManager.getLogger(ProvinceDAOImpl.class);

	/**
	 * Get all province in Vietnam
	 */
	public List<Province> getAllProvince() {
		List<Province> result = new ArrayList<Province>();

		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" from Province order by Name");
		result = query.list();

		return result;
	}

	public Province getProvince(int id) {
		Province result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();

			Query query = session.createSQLQuery("select * from province where id = ?");
			query.setParameter(0, id);
			result = (Province) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Get province by code
	 */
	public Province getProcinveByCode(String code) {
		Province result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createSQLQuery("select * from province where code = ?");
			query.setParameter(0, code);
			query.setResultTransformer(new AliasToBeanResultTransformer(Province.class));
			result = (Province) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
