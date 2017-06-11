package vn.co.cex.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;

import vn.co.cex.dao.CarrierAuctionDAO;
import vn.co.cex.dto.CarrierAuctionDTO;
import vn.co.cex.dto.CarrierAuctionNotificationDTO;
import vn.co.cex.orm.BillOfLading;
import vn.co.cex.orm.CarrierAuction;
import vn.co.cex.orm.Users;

public class CarrierAuctionDAOImpl extends BaseDAOImpl implements CarrierAuctionDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8470917989028494048L;
	/**
	 * 
	 */
	private static final Logger log = LogManager.getLogger(CarrierAuctionDAOImpl.class);

	/**
	 * Add new carrier auction
	 */
	public boolean addNewCarrierAuction(CarrierAuction data) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			data.setUser(new Users(data.getCarrierId()));
			data.setBillOfLading(new BillOfLading(data.getBillOfLadingId()));
			session.save(data);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Update carrier auction
	 */
	public boolean updateCarrierAuction(CarrierAuction data) {
		try {
			Session session = getSessionFactory().getCurrentSession();

			data.setBillOfLading(new BillOfLading(data.getBillOfLadingId()));
			data.setUser(new Users(data.getCarrierId()));
			data.setModified(new Date());

			session.saveOrUpdate(data);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Get carrier auction
	 */
	public CarrierAuction getCarrierAuction(int carrierId, int billOfLadingId) {
		CarrierAuction result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			StringBuilder sqlSelect = new StringBuilder();
			sqlSelect.append(" SELECT ca_au.* FROM carrierauction ca_au ");
			sqlSelect.append(" JOIN billoflading bol on ca_au.BillOfLadingId = bol.Id ");
			sqlSelect.append(" WHERE ca_au.CarrierId = ? AND bol.Id = ? AND ca_au.Status <> 7 ");
			sqlSelect.append(" ORDER BY ca_au.AuctionDate DESC LIMIT 1");
			SQLQuery query = session.createSQLQuery(sqlSelect.toString());
			query.setResultTransformer(new AliasToBeanResultTransformer(CarrierAuction.class));
			query.setParameter(0, carrierId);
			query.setParameter(1, billOfLadingId);
			result = (CarrierAuction) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Get carrier auction list
	 */
	public List<CarrierAuctionDTO> getCarrierAuctionList(int transactionsId) {
		List<CarrierAuctionDTO> result = new ArrayList<CarrierAuctionDTO>();
		try {
			Session session = getSessionFactory().getCurrentSession();
			StringBuilder sqlSelect = new StringBuilder();
			sqlSelect.append("SELECT u.FullName as 'carrierFullName', u.Email as 'carrierEmail', ");
			sqlSelect.append("u.PhoneNumber as 'carrierPhoneNumber', ca_au.* ");
			sqlSelect.append("FROM carrierauction ca_au ");
			sqlSelect.append("JOIN users u on ca_au.CarrierId = u.Id ");
			sqlSelect.append("WHERE ca_au.BillOfLadingId = ? AND ca_au.Status <> 7 ");
			SQLQuery query = session.createSQLQuery(sqlSelect.toString());
			query.setResultTransformer(new AliasToBeanResultTransformer(CarrierAuctionDTO.class));
			query.setParameter(0, transactionsId);
			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Get carrier auction success
	 */
	public CarrierAuctionDTO getCarrierAuctionSuccess(int billOfLadingId) {
		CarrierAuctionDTO result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			StringBuilder sqlSelect = new StringBuilder();
			sqlSelect.append("SELECT u.FullName as 'carrierFullName', u.Email as 'carrierEmail', ");
			sqlSelect.append("u.PhoneNumber as 'carrierPhoneNumber', ca_au.* ");
			sqlSelect.append("FROM carrierauction ca_au ");
			sqlSelect.append("JOIN users u on ca_au.CarrierId = u.Id ");
			sqlSelect.append("WHERE ca_au.BillOfLadingId = ? AND ca_au.Status IN (2,3) LIMIT 1 ");
			SQLQuery query = session.createSQLQuery(sqlSelect.toString());
			query.setResultTransformer(new AliasToBeanResultTransformer(CarrierAuctionDTO.class));
			query.setParameter(0, billOfLadingId);
			result = (CarrierAuctionDTO) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Get carrier auction notification
	 */
	public List<CarrierAuctionNotificationDTO> getCarrierAuctionNotification() {
		List<CarrierAuctionNotificationDTO> result = new ArrayList<CarrierAuctionNotificationDTO>();
		try {
			Session session = getSessionFactory().getCurrentSession();

			StringBuilder sqlSelect = new StringBuilder();
			sqlSelect.append("SELECT ca.id AS 'carrierAuctionId' , ca.billOfLadingId AS 'billOfLadingId', ");
			sqlSelect.append("ca.status, u.id AS 'userId', u.fullName AS 'username', u.email ");
			sqlSelect.append("FROM carrierauction ca ");
			sqlSelect.append("JOIN users u ON ca.carrierId = u.id ");
			sqlSelect.append("WHERE ca.Notification = 0 AND ca.Status NOT IN (1, 7) ");
			SQLQuery query = session.createSQLQuery(sqlSelect.toString());
			query.setResultTransformer(new AliasToBeanResultTransformer(CarrierAuctionNotificationDTO.class));
			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}
}
