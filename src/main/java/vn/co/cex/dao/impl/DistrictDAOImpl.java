package vn.co.cex.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import vn.co.cex.dao.DistrictDAO;
import vn.co.cex.orm.District;

public class DistrictDAOImpl extends BaseDAOImpl implements DistrictDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6555485226790140363L;
	private static final Logger log = LogManager.getLogger(DistrictDAOImpl.class);
	
	/**
	 * Get all District
	 */
	public List<District> getAllDistrict() {
		List<District> result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createQuery(" from District");
			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}
	
	/**
	 * Get district by province code
	 */
	public List<District> getDistrictByProvinceCode(String provinceCode){
		List<District> result = null;
		try{
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createQuery(" from District where ProvinceCode = ? order by Name");
			query.setParameter(0, provinceCode);
			result = query.list();
		}
		catch (Exception e) {
			log.debug(e);
		}
		return result;
	}
	/**
	 * get District Name by code
	 * 
	 * @param code
	 * @return
	 */
	public String getDistrictNameByCode(String code) {
		String result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("select name from District where code = ? LIMIT 1");
			query.setParameter(0, code);
			result = (String) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}
	
	/**
	 * get Province Code by code
	 * 
	 * @param code
	 * @return
	 */
	public String getProvinceCodeByCode(String code) {
		String result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("select provincecode from District where code = ? LIMIT 1");
			query.setParameter(0, code);
			result = (String) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}
}
