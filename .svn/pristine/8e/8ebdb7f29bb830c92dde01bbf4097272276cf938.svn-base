package vn.co.cex.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.transaction.annotation.Transactional;

import vn.co.cex.dao.GoodsTypeDAO;
import vn.co.cex.dto.BillOfLadingPriceDTO;
import vn.co.cex.orm.GoodsType;

/**
 * @author DUONGLV
 *
 */
public class GoodsTypeDAOImpl extends BaseDAOImpl implements GoodsTypeDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4173545138348799726L;
	private static final Logger log = LogManager.getLogger(GoodsTypeDAOImpl.class);

	/**
	 * Get all goods type item
	 */
	@Transactional
	public List<GoodsType> getAllGoodsType() {
		List<GoodsType> result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			Query query = session.createQuery(" from GoodsType");
			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public GoodsType getGoodsType(int id) {
		GoodsType result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery("SELECT * FROM GoodsType WHERE id = ?");
			query.setParameter(0, id);
			query.setResultTransformer(new AliasToBeanResultTransformer(GoodsType.class));
			result = (GoodsType) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}

		return result;
	}

	/**
	 * Update goods type
	 */
	public boolean updateGoodsType(GoodsType goodsType) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			session.update(goodsType);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Update reference price
	 */
	public void updateReferencePrice() {
		try {
			StringBuilder queryBillOfLading = new StringBuilder();
			queryBillOfLading.append(" SELECT gt.id AS 'GoodsTypeId', gt.Name AS 'GoodsTypeName', ");
			queryBillOfLading.append(" COUNT(*) AS 'NumberOfBill', SUM(bol.Price) AS 'TotalPrice', ");
			queryBillOfLading.append(" SUM(bol.Distance) 'TotalDistance', SUM(bol.Weight) AS 'TotalWeight' ");
			queryBillOfLading.append(" FROM billoflading bol ");
			queryBillOfLading.append(" JOIN goodstype gt on bol.GoodsTypeId = gt.id ");
			queryBillOfLading.append(" JOIN carrierauction ca on ca.BillOfLadingId = bol.Id ");
			queryBillOfLading.append(" WHERE ca.Status IN (2,3) AND bol.Status IN (2,3) ");
			queryBillOfLading.append(" GROUP BY GoodsTypeId ");
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(queryBillOfLading.toString());
			query.setResultTransformer(new AliasToBeanResultTransformer(BillOfLadingPriceDTO.class));
			query.addScalar("GoodsTypeId", new IntegerType());
			query.addScalar("GoodsTypeName", new StringType());
			query.addScalar("NumberOfBill", new IntegerType());
			query.addScalar("TotalPrice", new FloatType());
			query.addScalar("TotalDistance", new FloatType());
			query.addScalar("TotalWeight", new FloatType());
			List<BillOfLadingPriceDTO> billOfLadingPriceList = query.list();
			
			//Update reference price
			for (BillOfLadingPriceDTO billOfLadingPriceDTO : billOfLadingPriceList) {
				GoodsType goodsType = getGoodsType(billOfLadingPriceDTO.getGoodsTypeId());
				double priceUnit = ((billOfLadingPriceDTO.getTotalPrice() / billOfLadingPriceDTO.getTotalDistance())
						/ billOfLadingPriceDTO.getTotalWeight());
				float referencePrice = (float)(Math.ceil(priceUnit) * 1000);
				goodsType.setReferencePrice(referencePrice);
				update(goodsType);
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
