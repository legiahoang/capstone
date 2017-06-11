package vn.co.cex.dao.impl;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import vn.co.cex.dao.BaseDAO;

public class BaseDAOImpl implements BaseDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2915519940433009871L;

	public BaseDAOImpl() {
		// TODO Auto-generated constructor stub

	}
	// private final static String THIS = "BaseDAO";

	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory asessionFactory) {
		// logger.info("setSessionFactory()");
		this.sessionFactory = asessionFactory;
	}

	/**
	 * Update an object in Session
	 * 
	 * @param obj
	 * @param session
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}

	/**
	 * 
	 * @param obj
	 * @param session
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(Object obj) {
		sessionFactory.getCurrentSession().persist(obj);

	}

	/**
	 * 
	 * @param obj
	 * @param session
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}

	// Replace tring "" by "", and "" by "" for searching to avoid SQL query
	// error: char _ and % using is "like" in sql query
	protected String searchStringFormat(String searchString) {
		if (searchString == null) {
			return null;
		}
		searchString = searchString.replace("_", "\\_").replace("%", "\\%").replace("'", "\\'");
		return searchString;
	}

	protected <T> List<T> transform(List list, Class<T> classOfT) {
		Gson gson = new Gson();
		Type collectionType = new TypeToken<Collection<T>>() {
		}.getType();
		String json = gson.toJson(list);
		return gson.fromJson(json, collectionType);
	}

}
