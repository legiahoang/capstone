package vn.co.cex.dao.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.FloatType;
import org.hibernate.type.IntegerType;
import org.springframework.transaction.annotation.Transactional;
import vn.co.cex.dao.BillOfLadingDAO;
import vn.co.cex.dto.BillOfLadingDTO;
import vn.co.cex.dto.BillOfLadingNotificationDTO;
import vn.co.cex.dto.BillOfLadingSummaryDTO;
import vn.co.cex.dto.ChartViewDTO;
import vn.co.cex.orm.GoodsType;
import vn.co.cex.orm.OperationFee;
import vn.co.cex.orm.PackagedForm;
import vn.co.cex.orm.PaymentDetail;
import vn.co.cex.orm.Users;
import vn.co.cex.orm.UsersAccount;
import vn.co.cex.orm.BillOfLading;
import vn.co.cex.orm.CarrierAuction;
import vn.co.cex.utils.ConstantUtils;

/**
 * @author DUONGLV
 *
 */
public class BillOfLadingDAOImpl extends BaseDAOImpl implements BillOfLadingDAO {

	private static final Logger log = LogManager.getLogger(BillOfLadingDAOImpl.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 697166325646229506L;

	/**
	 * Count total bill of lading
	 */
	public int countTotalBillOfLading(int status) {
		int result = 0;
		try {
			Session session = getSessionFactory().getCurrentSession();

			String sqlSelect = "SELECT COUNT(*) FROM billoflading WHERE status = ?";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setParameter(0, status);
			result = (Integer) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Search bill of lading by condition
	 */
	@Transactional
	public List<BillOfLadingDTO> searchBillOfLading(Integer goodsTypeId, Integer packagedFormId, Float weight,
			Float volume, String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate,
			Integer status, int pageSize, int pageIndex) {
		List<BillOfLadingDTO> result = new ArrayList<BillOfLadingDTO>();
		try {
			StringBuilder sqlQueryString = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sqlQueryString.append(" SELECT gt.Name AS 'GoodsTypeName', pf.Name AS 'PackagedFormName',  bol.* ");
			sqlQueryString.append(" FROM billoflading bol ");
			sqlQueryString.append(" JOIN goodstype gt ON bol.GoodsTypeId = gt.id ");
			sqlQueryString.append(" JOIN packagedform pf ON bol.PackagedFormId = pf.id ");
			sqlQueryString.append(" WHERE bol.status = ? ");
			if (goodsTypeId != null && goodsTypeId > 0) {
				sqlQueryString.append(String.format(" AND bol.goodsTypeId = %s ", goodsTypeId));
			}
			if (packagedFormId != null && packagedFormId > 0) {
				sqlQueryString.append(String.format(" AND bol.packagedFormId = %s ", packagedFormId));
			}
			if (departureProvince != null && !departureProvince.equals("")) {
				sqlQueryString.append(String.format(" AND bol.departureProvince = '%s' ", departureProvince));
			}
			if (arrivalProvince != null && !arrivalProvince.equals("")) {
				sqlQueryString.append(String.format(" AND bol.arrivalProvince = '%s' ", arrivalProvince));
			}
			if (weight != null && weight > 0) {
				sqlQueryString.append(String.format(" AND bol.weight <= %s ", weight));
			}
			if (volume != null && volume > 0) {
				sqlQueryString.append(String.format(" AND bol.volume <= %s ", volume));
			}
			if (departureDate != null) {
				String date = sdf.format(departureDate);
				sqlQueryString.append(String.format(" AND DATE(bol.departureDate) = '%s' ", date));
			}
			if (arrivalDate != null) {
				String date = sdf.format(arrivalDate);
				sqlQueryString.append(String.format(" AND DATE(bol.arrivalDate) = '%s' ", date));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setResultTransformer(new AliasToBeanResultTransformer(BillOfLadingDTO.class));
			if (status != null && status > 0) {
				query.setParameter(0, status);
			} else {
				query.setParameter(0, ConstantUtils.BILLOFLADING_BIDDING);
			}
			query.setFirstResult(pageIndex);
			query.setMaxResults(pageSize);

			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Add new bill of lading
	 */
	@Transactional
	public boolean addNewBillOfLading(BillOfLading data) {
		boolean result = false;
		try {
			Session session = getSessionFactory().getCurrentSession();
			data.setGoodsType(new GoodsType(data.getGoodsTypeId()));
			data.setPackagedForm(new PackagedForm(data.getPackagedFormId()));
			data.setUser(new Users(data.getCreatedUserId()));
			data.setStatus(ConstantUtils.BILLOFLADING_BIDDING);
			data.setCreated(new Date());
			session.save(data);
			result = true;
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Update bill of lading
	 */
	public boolean updateBillOfLading(BillOfLading data) {
		try {
			Session session = getSessionFactory().getCurrentSession();

			data.setPackagedForm(new PackagedForm(data.getPackagedFormId()));
			data.setGoodsType(new GoodsType(data.getGoodsTypeId()));
			data.setUser(new Users(data.getCreatedUserId()));
			data.setModified(new Date());

			session.saveOrUpdate(data);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Get bill of lading by id
	 */
	public BillOfLading getBillOfLadingById(int id) {
		BillOfLading result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();

			String sqlSelect = "SELECT * FROM billoflading WHERE id = ?";
			SQLQuery query = session.createSQLQuery(sqlSelect);
			query.setParameter(0, id);
			query.setResultTransformer(new AliasToBeanResultTransformer(BillOfLading.class));
			result = (BillOfLading) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Get bill of lading by id
	 */
	public BillOfLadingDTO getBillOfLadingDTOById(int id) {
		BillOfLadingDTO result = null;
		try {
			Session session = getSessionFactory().getCurrentSession();
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append(" SELECT gt.Name AS 'GoodsTypeName', pf.Name AS 'PackagedFormName', ");
			sqlQuery.append(" u.Email AS 'CreatedUser', bol.* ");
			sqlQuery.append(" FROM billoflading bol ");
			sqlQuery.append(" JOIN goodstype gt ON bol.GoodsTypeId = gt.id ");
			sqlQuery.append(" JOIN packagedform pf ON bol.PackagedFormId = pf.id ");
			sqlQuery.append(" JOIN users u ON bol.createdUserId = u.id ");
			sqlQuery.append(" WHERE bol.id = ? ");
			
			SQLQuery query = session.createSQLQuery(sqlQuery.toString());
			query.setParameter(0, id);
			query.setResultTransformer(new AliasToBeanResultTransformer(BillOfLadingDTO.class));
			result = (BillOfLadingDTO) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Search bill of lading by user
	 */
	public List<BillOfLadingDTO> searchBillOfLadingOfGoodsOwner(Integer goodsTypeId, Integer packagedFormId,
			Float weight, Float volume, String departureProvince, String arrivalProvince, Date departureDate,
			Date arrivalDate, int userId, int pageSize, int pageIndex) {
		List<BillOfLadingDTO> result = new ArrayList<BillOfLadingDTO>();
		try {
			StringBuilder sqlQueryString = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			sqlQueryString.append(" select gt.Name as 'GoodsTypeName', pf.Name as 'PackagedFormName',  bol.* ");
			sqlQueryString.append(" from billoflading bol ");
			sqlQueryString.append(" join goodstype gt on bol.GoodsTypeId = gt.id ");
			sqlQueryString.append(" join packagedform pf on bol.PackagedFormId = pf.id ");
			sqlQueryString.append(" where bol.createdUserId = ? ");
			if (goodsTypeId != null && goodsTypeId > 0) {
				sqlQueryString.append(String.format(" and bol.goodsTypeId = %s ", goodsTypeId));
			}
			if (packagedFormId != null && packagedFormId > 0) {
				sqlQueryString.append(String.format(" and bol.packagedFormId = %s ", packagedFormId));
			}
			if (departureProvince != null && !departureProvince.equals("")) {
				sqlQueryString.append(String.format(" and bol.departureProvince = '%s' ", departureProvince));
			}
			if (arrivalProvince != null && !arrivalProvince.equals("")) {
				sqlQueryString.append(String.format(" and bol.arrivalProvince = '%s' ", arrivalProvince));
			}
			if (weight != null && weight > 0) {
				sqlQueryString.append(String.format(" and bol.weight <= %s ", weight));
			}
			if (volume != null && volume > 0) {
				sqlQueryString.append(String.format(" and bol.volume <= %s ", volume));
			}
			if (departureDate != null) {
				String date = sdf.format(departureDate);
				sqlQueryString.append(String.format(" and DATE(bol.departureDate) = '%s' ", date));
			}
			if (arrivalDate != null) {
				String date = sdf.format(arrivalDate);
				sqlQueryString.append(String.format(" and DATE(bol.arrivalDate) = '%s' ", date));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setParameter(0, userId);
			query.setResultTransformer(new AliasToBeanResultTransformer(BillOfLadingDTO.class));

			query.setFirstResult(pageIndex);
			query.setMaxResults(pageSize);

			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Count bill of lading goods owner
	 * 
	 * @param goodsTypeId
	 * @param packagedFormId
	 * @param weight
	 * @param volume
	 * @param departureProvince
	 * @param arrivalProvince
	 * @param departureDate
	 * @param arrivalDate
	 * @param userId
	 * @return
	 */
	public int countBillOfLadingOfGoodsOwner(Integer goodsTypeId, Integer packagedFormId, Float weight, Float volume,
			String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate, int userId) {
		BigInteger result = new BigInteger("0");
		try {
			StringBuilder sqlQueryString = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			sqlQueryString.append(" select count(*) ");
			sqlQueryString.append(" from billoflading bol ");
			sqlQueryString.append(" join goodstype gt on bol.GoodsTypeId = gt.id ");
			sqlQueryString.append(" join packagedform pf on bol.PackagedFormId = pf.id ");
			sqlQueryString.append(" where bol.createdUserId = ? ");
			if (goodsTypeId != null && goodsTypeId > 0) {
				sqlQueryString.append(String.format(" and bol.goodsTypeId = %s ", goodsTypeId));
			}
			if (packagedFormId != null && packagedFormId > 0) {
				sqlQueryString.append(String.format(" and bol.packagedFormId = %s ", packagedFormId));
			}
			if (departureProvince != null && !departureProvince.equals("")) {
				sqlQueryString.append(String.format(" and bol.departureProvince = '%s' ", departureProvince));
			}
			if (arrivalProvince != null && !arrivalProvince.equals("")) {
				sqlQueryString.append(String.format(" and bol.arrivalProvince = '%s' ", arrivalProvince));
			}
			if (weight != null && weight > 0) {
				sqlQueryString.append(String.format(" and bol.weight <= %s ", weight));
			}
			if (volume != null && volume > 0) {
				sqlQueryString.append(String.format(" and bol.volume <= %s ", volume));
			}
			if (departureDate != null) {
				String date = sdf.format(departureDate);
				sqlQueryString.append(String.format(" and DATE(bol.departureDate) = '%s' ", date));
			}
			if (arrivalDate != null) {
				String date = sdf.format(arrivalDate);
				sqlQueryString.append(String.format(" and DATE(bol.arrivalDate) = '%s' ", date));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setParameter(0, userId);

			result = (BigInteger) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result.intValue();
	}

	/**
	 * Search bill of lading by carrier
	 */
	public List<BillOfLadingDTO> searchBillOfLadingByCarrier(Integer goodsTypeId, Integer packagedFormId, Float weight,
			Float volume, String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate,
			int carrierId, int pageSize, int pageIndex) {
		List<BillOfLadingDTO> result = new ArrayList<BillOfLadingDTO>();
		try {
			StringBuilder sqlQueryString = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			sqlQueryString.append(" SELECT gt.Name AS 'GoodsTypeName', pf.Name AS 'PackagedFormName',  bol.*, ");
			sqlQueryString.append(" ca.AuctionPrice AS 'AuctionPrice', ca.Status AS 'AuctionStatus' ");
			sqlQueryString.append(" FROM billoflading bol ");
			sqlQueryString.append(" JOIN goodstype gt ON bol.GoodsTypeId = gt.id ");
			sqlQueryString.append(" JOIN packagedform pf ON bol.PackagedFormId = pf.id ");
			sqlQueryString.append(" JOIN carrierauction ca ON ca.BillOfLadingId = bol.id ");
			sqlQueryString.append(" WHERE ca.CarrierId = ? AND ca.Status <> 7 ");
			if (goodsTypeId != null && goodsTypeId > 0) {
				sqlQueryString.append(String.format(" and bol.goodsTypeId = %s ", goodsTypeId));
			}
			if (packagedFormId != null && packagedFormId > 0) {
				sqlQueryString.append(String.format(" and bol.packagedFormId = %s ", packagedFormId));
			}
			if (departureProvince != null && !departureProvince.equals("")) {
				sqlQueryString.append(String.format(" and bol.departureProvince = '%s' ", departureProvince));
			}
			if (arrivalProvince != null && !arrivalProvince.equals("")) {
				sqlQueryString.append(String.format(" and bol.arrivalProvince = '%s' ", arrivalProvince));
			}
			if (weight != null && weight > 0) {
				sqlQueryString.append(String.format(" and bol.weight <= %s ", weight));
			}
			if (volume != null && volume > 0) {
				sqlQueryString.append(String.format(" and bol.volume <= %s ", volume));
			}
			if (departureDate != null) {
				String date = sdf.format(departureDate);
				sqlQueryString.append(String.format(" and DATE(bol.departureDate) = '%s' ", date));
			}
			if (arrivalDate != null) {
				String date = sdf.format(arrivalDate);
				sqlQueryString.append(String.format(" and DATE(bol.arrivalDate) = '%s' ", date));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setParameter(0, carrierId);
			query.setResultTransformer(new AliasToBeanResultTransformer(BillOfLadingDTO.class));

			query.setFirstResult(pageIndex);
			query.setMaxResults(pageSize);

			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Count Bill Of Lading Of Carrier
	 */
	public int countBillOfLadingOfCarrier(Integer goodsTypeId, Integer packagedFormId, Float weight, Float volume,
			String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate, int carrierId) {
		BigInteger result = new BigInteger("0");
		try {
			StringBuilder sqlQueryString = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			sqlQueryString.append(" SELECT COUNT(*) ");
			sqlQueryString.append(" FROM billoflading bol ");
			sqlQueryString.append(" JOIN goodstype gt ON bol.GoodsTypeId = gt.id ");
			sqlQueryString.append(" JOIN packagedform pf ON bol.PackagedFormId = pf.id ");
			sqlQueryString.append(" JOIN carrierauction ca ON ca.BillOfLadingId = bol.id ");
			sqlQueryString.append(" WHERE ca.CarrierId = ? AND ca.Status <> 7 ");
			if (goodsTypeId != null && goodsTypeId > 0) {
				sqlQueryString.append(String.format(" and bol.goodsTypeId = %s ", goodsTypeId));
			}
			if (packagedFormId != null && packagedFormId > 0) {
				sqlQueryString.append(String.format(" and bol.packagedFormId = %s ", packagedFormId));
			}
			if (departureProvince != null && !departureProvince.equals("")) {
				sqlQueryString.append(String.format(" and bol.departureProvince = '%s' ", departureProvince));
			}
			if (arrivalProvince != null && !arrivalProvince.equals("")) {
				sqlQueryString.append(String.format(" and bol.arrivalProvince = '%s' ", arrivalProvince));
			}
			if (weight != null && weight > 0) {
				sqlQueryString.append(String.format(" and bol.weight <= %s ", weight));
			}
			if (volume != null && volume > 0) {
				sqlQueryString.append(String.format(" and bol.volume <= %s ", volume));
			}
			if (departureDate != null) {
				String date = sdf.format(departureDate);
				sqlQueryString.append(String.format(" and DATE(bol.departureDate) = '%s' ", date));
			}
			if (arrivalDate != null) {
				String date = sdf.format(arrivalDate);
				sqlQueryString.append(String.format(" and DATE(bol.arrivalDate) = '%s' ", date));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setParameter(0, carrierId);
			result = (BigInteger) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result.intValue();
	}

	/**
	 * Get bill of lading summary
	 */
	public BillOfLadingSummaryDTO getBillOfLadingSummary() {
		BillOfLadingSummaryDTO billOfLadingSummaryDTO = new BillOfLadingSummaryDTO();
		try {
			Session session = getSessionFactory().getCurrentSession();
			StringBuilder sqlQuery = new StringBuilder("SELECT count(*) FROM billoflading");
			SQLQuery query = session.createSQLQuery(sqlQuery.toString());
			BigInteger totalBillOfLading = (BigInteger) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT count(*) FROM billoflading WHERE status = 1");
			query = session.createSQLQuery(sqlQuery.toString());
			BigInteger billOfLadingAuctionBidding = (BigInteger) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT count(*) FROM billoflading WHERE status = 2");
			query = session.createSQLQuery(sqlQuery.toString());
			BigInteger billOfLadingAuctionSuccess = (BigInteger) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT count(*) FROM billoflading WHERE status = 3");
			query = session.createSQLQuery(sqlQuery.toString());
			BigInteger billOfLadingAuctionCompletion = (BigInteger) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT count(*) FROM billoflading WHERE status = 4");
			query = session.createSQLQuery(sqlQuery.toString());
			BigInteger billOfLadingAuctionFailure = (BigInteger) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT count(*) FROM billoflading WHERE status = 5");
			query = session.createSQLQuery(sqlQuery.toString());
			BigInteger billOfLadingAuctionCarrierCanceled = (BigInteger) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT count(*) FROM billoflading WHERE status = 6");
			query = session.createSQLQuery(sqlQuery.toString());
			BigInteger billOfLadingAuctionGoodsOwnerCanceled = (BigInteger) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT Created FROM billoflading ORDER BY Created LIMIT 1");
			query = session.createSQLQuery(sqlQuery.toString());
			Date dateTimeFrom = (Date) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT Created FROM billoflading ORDER BY Created DESC LIMIT 1");
			query = session.createSQLQuery(sqlQuery.toString());
			Date dateTimeTo = (Date) query.uniqueResult();

			sqlQuery = new StringBuilder("SELECT SUM(Price) FROM billoflading");
			query = session.createSQLQuery(sqlQuery.toString());
			double totalValue = (Double) query.uniqueResult();

			billOfLadingSummaryDTO.setTotalBillOfLading(totalBillOfLading.intValue());
			billOfLadingSummaryDTO.setBillOfLadingAuctionBidding(billOfLadingAuctionBidding.intValue());
			billOfLadingSummaryDTO.setBillOfLadingAuctionSuccess(billOfLadingAuctionSuccess.intValue());
			billOfLadingSummaryDTO.setBillOfLadingAuctionCompletion(billOfLadingAuctionCompletion.intValue());
			billOfLadingSummaryDTO.setBillOfLadingAuctionFailure(billOfLadingAuctionFailure.intValue());
			billOfLadingSummaryDTO.setBillOfLadingAuctionCarrierCanceled(billOfLadingAuctionCarrierCanceled.intValue());
			billOfLadingSummaryDTO
					.setBillOfLadingAuctionGoodsOwnerCanceled(billOfLadingAuctionGoodsOwnerCanceled.intValue());
			billOfLadingSummaryDTO.setDateTimeFrom(dateTimeFrom);
			billOfLadingSummaryDTO.setDateTimeTo(dateTimeTo);
			billOfLadingSummaryDTO.setTotalValue(totalValue);
		} catch (Exception e) {
			log.debug(e);
		}
		return billOfLadingSummaryDTO;
	}

	/**
	 * Search bill of lading summary
	 */
	public BillOfLadingSummaryDTO searchBillOfLadingSummary(Integer goodsTypeId, Integer packFormId, Float weight,
			Float volume, String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate) {
		BillOfLadingSummaryDTO billOfLadingSummaryDTO = new BillOfLadingSummaryDTO();
		try {
			List<BillOfLading> billOfLadingList = searchBillOfLadingSummaryByCondition(goodsTypeId, packFormId, weight,
					volume, departureProvince, arrivalProvince, departureDate, arrivalDate,
					ConstantUtils.BILLOFLADING_NOT_OWNER);

			int totalBillOfLading = billOfLadingList.size();
			double totalValue = 0;

			int billOfLadingAuctionBidding = 0;
			int billOfLadingAuctionSuccess = 0;
			int billOfLadingAuctionCompletion = 0;
			int billOfLadingAuctionFailure = 0;
			int billOfLadingAuctionCarrierCanceled = 0;
			int billOfLadingAuctionGoodsOwnerCanceled = 0;
			for (BillOfLading item : billOfLadingList) {
				if (item.getStatus() == ConstantUtils.BILLOFLADING_BIDDING) {
					billOfLadingAuctionBidding++;
				} else if (item.getStatus() == ConstantUtils.BILLOFLADING_SUCCESS) {
					billOfLadingAuctionSuccess++;
				} else if (item.getStatus() == ConstantUtils.BILLOFLADING_COMPLETION) {
					billOfLadingAuctionCompletion++;
				} else if (item.getStatus() == ConstantUtils.BILLOFLADING_FAILURE) {
					billOfLadingAuctionFailure++;
				} else if (item.getStatus() == ConstantUtils.BILLOFLADING_GOODSOWNER_CANCELED) {
					billOfLadingAuctionGoodsOwnerCanceled++;
				} else if (item.getStatus() == ConstantUtils.BILLOFLADING_CARRIER_CANCELED) {
					billOfLadingAuctionCarrierCanceled++;
				}
				totalValue += item.getPrice();
			}

			billOfLadingSummaryDTO.setTotalBillOfLading(totalBillOfLading);
			billOfLadingSummaryDTO.setBillOfLadingAuctionBidding(billOfLadingAuctionBidding);
			billOfLadingSummaryDTO.setBillOfLadingAuctionSuccess(billOfLadingAuctionSuccess);
			billOfLadingSummaryDTO.setBillOfLadingAuctionCompletion(billOfLadingAuctionCompletion);
			billOfLadingSummaryDTO.setBillOfLadingAuctionFailure(billOfLadingAuctionFailure);
			billOfLadingSummaryDTO.setBillOfLadingAuctionCarrierCanceled(billOfLadingAuctionCarrierCanceled);
			billOfLadingSummaryDTO.setBillOfLadingAuctionGoodsOwnerCanceled(billOfLadingAuctionGoodsOwnerCanceled);
			if (departureDate != null) {
				billOfLadingSummaryDTO.setDateTimeFrom(departureDate);
			} else {
				if (billOfLadingList != null && billOfLadingList.size() > 0) {
					billOfLadingSummaryDTO.setDateTimeFrom(billOfLadingList.get(0).getCreated());
				}
			}
			if (arrivalDate != null) {
				billOfLadingSummaryDTO.setDateTimeTo(arrivalDate);
			} else {
				if (billOfLadingList != null && billOfLadingList.size() > 0) {
					billOfLadingSummaryDTO
							.setDateTimeTo(billOfLadingList.get(billOfLadingList.size() - 1).getCreated());
				}
			}
			if (departureProvince == null || departureProvince.equals("")) {
				billOfLadingSummaryDTO.setDepartureProvince(null);
			} else {
				billOfLadingSummaryDTO.setDepartureProvince(departureProvince);
			}
			if (arrivalProvince == null || arrivalProvince.equals("")) {
				billOfLadingSummaryDTO.setArrivalProvince(null);
			} else {
				billOfLadingSummaryDTO.setArrivalProvince(arrivalProvince);
			}
			billOfLadingSummaryDTO.setTotalValue(totalValue);
		} catch (Exception e) {
			log.debug(e);
		}
		return billOfLadingSummaryDTO;
	}

	/**
	 * Support function
	 * 
	 * @param goodsTypeId
	 * @param packFormId
	 * @param weight
	 * @param volume
	 * @param departureProvince
	 * @param arrivalProvince
	 * @param departureDate
	 * @param arrivalDate
	 * @param status
	 * @return
	 */
	private List<BillOfLading> searchBillOfLadingSummaryByCondition(Integer goodsTypeId, Integer packFormId,
			Float weight, Float volume, String departureProvince, String arrivalProvince, Date departureDate,
			Date arrivalDate, int status) {
		List<BillOfLading> result = new ArrayList<BillOfLading>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			Session session = getSessionFactory().getCurrentSession();
			StringBuilder sqlQueryString = new StringBuilder("SELECT bol.id, bol.status, bol.price, bol.created ");
			sqlQueryString.append("FROM billoflading bol WHERE bol.status > ? ");
			if (goodsTypeId != null && goodsTypeId > 0) {
				sqlQueryString.append(String.format(" AND bol.goodsTypeId = %s ", goodsTypeId));
			}
			if (packFormId != null && packFormId > 0) {
				sqlQueryString.append(String.format(" AND bol.packagedFormId = %s ", packFormId));
			}
			if (departureProvince != null && !departureProvince.equals("")) {
				sqlQueryString.append(String.format(" AND bol.departureProvince = '%s' ", departureProvince));
			}
			if (arrivalProvince != null && !arrivalProvince.equals("")) {
				sqlQueryString.append(String.format(" AND bol.arrivalProvince = '%s' ", arrivalProvince));
			}
			if (weight != null && weight > 0) {
				sqlQueryString.append(String.format(" AND bol.weight <= %s ", weight));
			}
			if (volume != null && volume > 0) {
				sqlQueryString.append(String.format(" AND bol.volume <= %s ", volume));
			}
			if (departureDate != null) {
				String date = sdf.format(departureDate);
				sqlQueryString.append(String.format(" AND DATE(bol.created) > '%s' ", date));
			}
			if (arrivalDate != null) {
				String date = sdf.format(arrivalDate);
				sqlQueryString.append(String.format(" AND DATE(bol.created) < '%s' ", date));
			}
			sqlQueryString.append("ORDER BY bol.created ");
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			query.setParameter(0, status);
			query.setResultTransformer(new AliasToBeanResultTransformer(BillOfLading.class));
			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Get chart view
	 */
	public List<ChartViewDTO> getChartView() {
		List<ChartViewDTO> result = new ArrayList<ChartViewDTO>();
		try {
			// Select current time
			Session session = getSessionFactory().getCurrentSession();
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			int year = cal.get(Calendar.YEAR);

			// Select total of value and number of bill of lading success
			StringBuilder sqlSelectSuccess = new StringBuilder();
			sqlSelectSuccess.append(" SELECT months.Month AS 'month', ");
			sqlSelectSuccess.append(" COUNT(ca.Id) AS 'billOfLadingSucceeded', ");
			sqlSelectSuccess.append(" SUM(ca.AuctionPrice) AS 'totalValue' ");
			sqlSelectSuccess.append(" FROM  ( SELECT  1 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  2 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  3 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  4 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  5 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  6 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  7 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  8 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  9 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  10 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  11 AS 'Month' UNION ALL ");
			sqlSelectSuccess.append(" SELECT  12 AS 'Month' ) months ");
			sqlSelectSuccess.append(" LEFT JOIN carrierauction ca ");
			sqlSelectSuccess.append(" ON months.Month = MONTH(ca.AuctionDate) ");
			sqlSelectSuccess.append(" AND YEAR(ca.AuctionDate) = :year ");
			sqlSelectSuccess.append(" AND (ca.Status = 2 OR ca.Status = 3) ");
			sqlSelectSuccess.append(" GROUP BY months.Month ");
			sqlSelectSuccess.append(" ORDER BY months.Month ");
			SQLQuery query = session.createSQLQuery(sqlSelectSuccess.toString());
			query.setInteger("year", year);
			query.addScalar("totalValue", new FloatType());
			query.addScalar("billOfLadingSucceeded", new IntegerType());
			query.addScalar("month", new IntegerType());
			query.setResultTransformer(new AliasToBeanResultTransformer(ChartViewDTO.class));
			List<ChartViewDTO> charViewSuccess = query.list();

			// Select number of bill of lading failure
			StringBuilder sqlSelectFailure = new StringBuilder();
			sqlSelectFailure.append(" SELECT months.Month AS 'month', COUNT(bol.Id) AS 'billOfLadingFailed' ");
			sqlSelectFailure.append(" FROM  ( SELECT  1 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  2 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  3 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  4 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  5 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  6 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  7 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  8 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  9 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  10 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  11 AS 'Month' UNION ALL ");
			sqlSelectFailure.append(" SELECT  12 AS 'Month' ) months ");
			sqlSelectFailure.append(" LEFT JOIN billoflading bol ");
			sqlSelectFailure.append(" ON months.Month = MONTH(bol.AuctionPeriod) AND bol.Status > 3 ");
			sqlSelectFailure.append(" AND YEAR(bol.AuctionPeriod) = :year ");
			sqlSelectFailure.append(" GROUP BY months.Month ");
			sqlSelectFailure.append(" ORDER BY months.Month ");
			SQLQuery queryFailure = session.createSQLQuery(sqlSelectFailure.toString());
			queryFailure.setInteger("year", year);
			queryFailure.addScalar("billOfLadingFailed", new IntegerType());
			queryFailure.addScalar("month", new IntegerType());
			queryFailure.setResultTransformer(new AliasToBeanResultTransformer(ChartViewDTO.class));

			List<ChartViewDTO> charViewFailure = queryFailure.list();

			// Combine to chart view object
			if (charViewSuccess != null && charViewFailure != null) {
				for (int i = 0; i < charViewSuccess.size(); i++) {
					charViewSuccess.get(i).setBillOfLadingFailed(charViewFailure.get(i).getBillOfLadingFailed());
					charViewSuccess.get(i).setTotalBillOfLading(charViewSuccess.get(i).getBillOfLadingSucceeded()
							+ charViewFailure.get(i).getBillOfLadingFailed());
					if (charViewSuccess.get(i).getTotalValue() == null) {
						charViewSuccess.get(i).setTotalValue(new Float(0));
					}
				}
			}
			// Set result
			result.addAll(charViewSuccess);
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Count bill of lading
	 */
	public int countBillOfLading(Integer goodsTypeId, Integer packagedFormId, Float weight, Float volume,
			String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate, Integer status) {
		BigInteger result = new BigInteger("0");
		try {
			StringBuilder sqlQueryString = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			sqlQueryString.append(" SELECT COUNT(*) ");
			sqlQueryString.append(" FROM billoflading bol ");
			sqlQueryString.append(" JOIN goodstype gt ON bol.GoodsTypeId = gt.id ");
			sqlQueryString.append(" JOIN packagedform pf ON bol.PackagedFormId = pf.id ");
			sqlQueryString.append(" WHERE bol.status = ? ");
			if (goodsTypeId != null && goodsTypeId > 0) {
				sqlQueryString.append(String.format(" AND bol.goodsTypeId = %s ", goodsTypeId));
			}
			if (packagedFormId != null && packagedFormId > 0) {
				sqlQueryString.append(String.format(" AND bol.packagedFormId = %s ", packagedFormId));
			}
			if (departureProvince != null && !departureProvince.equals("")) {
				sqlQueryString.append(String.format(" AND bol.departureProvince = '%s' ", departureProvince));
			}
			if (arrivalProvince != null && !arrivalProvince.equals("")) {
				sqlQueryString.append(String.format(" AND bol.arrivalProvince = '%s' ", arrivalProvince));
			}
			if (weight != null && weight > 0) {
				sqlQueryString.append(String.format(" AND bol.weight <= %s ", weight));
			}
			if (volume != null && volume > 0) {
				sqlQueryString.append(String.format(" AND bol.volume <= %s ", volume));
			}
			if (departureDate != null) {
				String date = sdf.format(departureDate);
				sqlQueryString.append(String.format(" AND DATE(bol.departureDate) = '%s' ", date));
			}
			if (arrivalDate != null) {
				String date = sdf.format(arrivalDate);
				sqlQueryString.append(String.format(" AND DATE(bol.arrivalDate) = '%s' ", date));
			}
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery query = session.createSQLQuery(sqlQueryString.toString());
			if (status != null && status > 0) {
				query.setParameter(0, status);
			} else {
				query.setParameter(0, ConstantUtils.BILLOFLADING_BIDDING);
			}
			result = (BigInteger) query.uniqueResult();
		} catch (Exception e) {
			log.debug(e);
		}
		return result.intValue();
	}

	/**
	 * Bill of lading process
	 */
	@Transactional
	public void billOfLadingProcess() {
		try {
			Session session = getSessionFactory().getCurrentSession();
			List<BillOfLading> billOfLadings = getBillOfLadingExpired();
			// Find the Carrier bid success
			for (BillOfLading billOfLading : billOfLadings) {
				List<CarrierAuction> carrierAuctions = getCarrierAuctionExpired(billOfLading.getId());
				boolean isSuccess = false;
				if (carrierAuctions != null && !carrierAuctions.isEmpty()) {
					for (CarrierAuction carrierAuction : carrierAuctions) {
						if (!isSuccess) {
							// Has Carrier bid success
							carrierAuction.setStatus(ConstantUtils.CARRIER_AUCTION_SUCCESS);
							carrierAuction.setBillOfLading(new BillOfLading(carrierAuction.getBillOfLadingId()));
							carrierAuction.setUser(new Users(carrierAuction.getCarrierId()));

							billOfLading.setStatus(ConstantUtils.BILLOFLADING_SUCCESS);
							billOfLading.setPackagedForm(new PackagedForm(billOfLading.getPackagedFormId()));
							billOfLading.setGoodsType(new GoodsType(billOfLading.getGoodsTypeId()));
							billOfLading.setUser(new Users(billOfLading.getCreatedUserId()));

							session.update(billOfLading);
							session.update(carrierAuction);
							isSuccess = true;
						} else {
							// Carrier bid failure
							carrierAuction.setStatus(ConstantUtils.CARRIER_AUCTION_FAILURE);
							carrierAuction.setBillOfLading(new BillOfLading(carrierAuction.getBillOfLadingId()));
							carrierAuction.setUser(new Users(carrierAuction.getCarrierId()));

							session.update(carrierAuction);
							// Return earnest money
							returnEarnestMoneyCarrier(carrierAuction.getAuctionPrice(), carrierAuction.getCarrierId(),
									carrierAuction.getBillOfLadingId());
						}
					}
				} else {
					// Bill of lading bid failure
					billOfLading.setStatus(ConstantUtils.BILLOFLADING_FAILURE);
					billOfLading.setPackagedForm(new PackagedForm(billOfLading.getPackagedFormId()));
					billOfLading.setGoodsType(new GoodsType(billOfLading.getGoodsTypeId()));
					billOfLading.setUser(new Users(billOfLading.getCreatedUserId()));

					session.update(billOfLading);
					// Return earnest money
					returnEarnestMoneyGoodsOwner(billOfLading.getPrice(), billOfLading.getCreatedUserId(),
							billOfLading.getId());
				}
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Get bill of lading expired
	 * 
	 * @return
	 */
	private List<BillOfLading> getBillOfLadingExpired() {
		List<BillOfLading> billOfLadings = new ArrayList<BillOfLading>();
		try {
			Session session = getSessionFactory().getCurrentSession();
			// Get Bill Of Lading is bidding expires
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			StringBuilder sqlQueryBillOfLading = new StringBuilder();
			sqlQueryBillOfLading.append("SELECT * FROM billoflading WHERE status = :status ");
			sqlQueryBillOfLading.append(" AND AuctionPeriod <= :auction_period LIMIT 2 ");
			SQLQuery queryBillOfLading = session.createSQLQuery(sqlQueryBillOfLading.toString());
			queryBillOfLading.setInteger("status", ConstantUtils.BILLOFLADING_BIDDING);
			queryBillOfLading.setString("auction_period", sdf.format(new Date()));
			queryBillOfLading.setResultTransformer(new AliasToBeanResultTransformer(BillOfLading.class));

			billOfLadings = queryBillOfLading.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return billOfLadings;
	}

	/**
	 * Get carrier auction expired
	 * 
	 * @param billOfLadingId
	 * @return
	 */
	private List<CarrierAuction> getCarrierAuctionExpired(int billOfLadingId) {
		List<CarrierAuction> carrierAuctions = new ArrayList<CarrierAuction>();
		try {
			Session session = getSessionFactory().getCurrentSession();
			StringBuilder sqlQueryCarrierAuction = new StringBuilder();
			sqlQueryCarrierAuction.append(" SELECT * FROM carrierauction WHERE status = :status ");
			sqlQueryCarrierAuction
					.append(" AND billOfLadingId = :bill_of_lading_id ORDER BY AuctionPrice, AuctionDate");
			SQLQuery queryCarrierAuction = session.createSQLQuery(sqlQueryCarrierAuction.toString());
			queryCarrierAuction.setInteger("status", ConstantUtils.CARRIER_AUCTION_BIDDING);
			queryCarrierAuction.setInteger("bill_of_lading_id", billOfLadingId);
			queryCarrierAuction.setResultTransformer(new AliasToBeanResultTransformer(CarrierAuction.class));

			carrierAuctions = queryCarrierAuction.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return carrierAuctions;
	}

	/**
	 * Return earnest money carrier bid failure
	 * 
	 * @param auctionPrice
	 * @param carrierId
	 * @param billOfLadingId
	 */
	private void returnEarnestMoneyCarrier(float auctionPrice, int carrierId, int billOfLadingId) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			// Return earnest money
			SQLQuery queryFee = session.createSQLQuery(" SELECT * FROM operationfee WHERE Code = ? LIMIT 1 ");
			queryFee.setString(0, ConstantUtils.EARNEST_MONEY_OF_CARRIER);
			queryFee.setResultTransformer(new AliasToBeanResultTransformer(OperationFee.class));
			OperationFee fee = (OperationFee) queryFee.uniqueResult();

			float amount = (fee.getPercent() / 100) * auctionPrice;

			SQLQuery queryAccount = session.createSQLQuery(" SELECT * FROM usersaccount WHERE UserId = ? LIMIT 1 ");
			queryAccount.setInteger(0, carrierId);
			queryAccount.setResultTransformer(new AliasToBeanResultTransformer(UsersAccount.class));
			UsersAccount account = (UsersAccount) queryAccount.uniqueResult();

			float newBalance = account.getBalance() + amount;
			account.setBalance(newBalance);
			session.update(account);
			// Add payment detail
			PaymentDetail paymentDetail = new PaymentDetail();
			paymentDetail.setAmounts(amount);
			paymentDetail.setBalance(newBalance);
			paymentDetail.setBillOfLadingId(billOfLadingId);
			paymentDetail.setDescription("Hoàn tiền đặt cọc khi đấu thầu thất bại.");
			paymentDetail.setType(ConstantUtils.PAYMENT_PLUS);
			paymentDetail.setUserId(carrierId);
			paymentDetail.setUsersAccount(new UsersAccount(carrierId));
			paymentDetail.setPaymentDate(new Date());
			insert(paymentDetail);
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Return earnest money goods owner bid failure
	 * 
	 * @param auctionPrice
	 * @param goodsOwnerId
	 * @param billOfLadingId
	 */
	private void returnEarnestMoneyGoodsOwner(float auctionPrice, int goodsOwnerId, int billOfLadingId) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			SQLQuery queryFee = session.createSQLQuery(" SELECT * FROM operationfee WHERE Code = ? LIMIT 1 ");
			queryFee.setString(0, ConstantUtils.EARNEST_MONEY_OF_GOODSOWNER);
			queryFee.setResultTransformer(new AliasToBeanResultTransformer(OperationFee.class));
			OperationFee fee = (OperationFee) queryFee.uniqueResult();

			float amount = (fee.getPercent() / 100) * auctionPrice;

			SQLQuery queryAccount = session.createSQLQuery(" SELECT * FROM usersaccount WHERE UserId = ? LIMIT 1 ");
			queryAccount.setInteger(0, goodsOwnerId);
			queryAccount.setResultTransformer(new AliasToBeanResultTransformer(UsersAccount.class));
			UsersAccount account = (UsersAccount) queryAccount.uniqueResult();

			float newBalance = account.getBalance() + amount;
			account.setBalance(newBalance);
			session.update(account);

			// Add payment detail
			PaymentDetail paymentDetail = new PaymentDetail();
			paymentDetail.setAmounts(amount);
			paymentDetail.setBalance(newBalance);
			paymentDetail.setBillOfLadingId(billOfLadingId);
			paymentDetail.setDescription("Hoàn tiền đặt cọc khi đấu thầu thất bại.");
			paymentDetail.setType(ConstantUtils.PAYMENT_PLUS);
			paymentDetail.setUserId(goodsOwnerId);
			paymentDetail.setUsersAccount(new UsersAccount(goodsOwnerId));
			paymentDetail.setPaymentDate(new Date());

			insert(paymentDetail);
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Get bill of lading notification
	 */
	public List<BillOfLadingNotificationDTO> getBillOfLadingNotification() {
		List<BillOfLadingNotificationDTO> result = new ArrayList<BillOfLadingNotificationDTO>();
		try {
			Session session = getSessionFactory().getCurrentSession();

			StringBuilder sqlSelect = new StringBuilder();
			sqlSelect.append("SELECT bol.id AS 'billOfLadingId', bol.status, ");
			sqlSelect.append("u.id AS 'userId', u.fullName as 'username', u.email ");
			sqlSelect.append("FROM billoflading bol ");
			sqlSelect.append("JOIN users u ON bol.createdUserId = u.id ");
			sqlSelect.append("WHERE bol.Notification = 0 AND bol.Status <> 1 ");
			SQLQuery query = session.createSQLQuery(sqlSelect.toString());
			query.setResultTransformer(new AliasToBeanResultTransformer(BillOfLadingNotificationDTO.class));
			result = query.list();
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}
}
