package vn.co.cex.dao;

import java.util.List;

import vn.co.cex.dto.CarrierAuctionDTO;
import vn.co.cex.dto.CarrierAuctionNotificationDTO;
import vn.co.cex.orm.CarrierAuction;

public interface CarrierAuctionDAO extends BaseDAO {

	/**
	 * Add new auction transactions
	 * 
	 * @param data
	 * @return
	 */
	public boolean addNewCarrierAuction(CarrierAuction data);

	/**
	 * Update auction transaction
	 * 
	 * @param data
	 * @return
	 */
	public boolean updateCarrierAuction(CarrierAuction data);

	/**
	 * Get carrier auction
	 * 
	 * @param carrierId
	 * @param transactionsId
	 * @return
	 */
	public CarrierAuction getCarrierAuction(int carrierId, int transactionsId);

	/**
	 * Get carrier auction list
	 * 
	 * @param transactionId
	 * @return
	 */
	public List<CarrierAuctionDTO> getCarrierAuctionList(int transactionsId);

	/**
	 * Get carrier auction success
	 * 
	 * @param transactionId
	 * @return
	 */
	public CarrierAuctionDTO getCarrierAuctionSuccess(int transactionsId);

	/**
	 * Get carrier auction notification
	 * 
	 * @return
	 */
	public List<CarrierAuctionNotificationDTO> getCarrierAuctionNotification();
}
