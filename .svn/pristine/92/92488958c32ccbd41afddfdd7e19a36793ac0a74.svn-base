package vn.co.cex.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import vn.co.cex.dao.PackagedFormDAO;
import vn.co.cex.orm.PackagedForm;

public class PackagedFormDAOImpl extends BaseDAOImpl implements PackagedFormDAO {


	private static final Logger log = LogManager.getLogger(PackagedFormDAOImpl.class);
	@Transactional
	public List<PackagedForm> getAllPackagedForm() {
		List<PackagedForm> result = new ArrayList<PackagedForm>();

		Session session = getSessionFactory().getCurrentSession();
		Query query = session.createQuery(" from PackagedForm");
		result = query.list();

		return result;
	}
	
	public PackagedForm getPackagedForm(int id){
		PackagedForm result = null;
		Session session = getSessionFactory().getCurrentSession();
		SQLQuery query = session.createSQLQuery("select * from packagedForm where id = ?");
		query.setParameter(0, id);
		result = (PackagedForm) query.uniqueResult();
		return result;
	}

}
