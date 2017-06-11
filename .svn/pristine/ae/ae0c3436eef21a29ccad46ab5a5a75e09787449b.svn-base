package vn.co.cex.bo;

import java.util.List;

import vn.co.cex.dto.CarrierAuctionDTO;
import vn.co.cex.dto.CarrierAuctionNotificationDTO;
import vn.co.cex.orm.CarrierAuction;

public interface CarrierAuctionBO extends BaseBO {
	/**
	 * Add new carrier auction
	 * @param data
	 * @return
	 */
	public boolean addNewCarrierAuction(CarrierAuction data);
	
	/**
	 * Update carrier auction
	 * @param data
	 * @return
	 */
	public boolean updateCarrierAuction(CarrierAuction data);
	/**
	 * Get carrier auction
	 * @param carrierId
	 * @param billOfLadingId
	 * @return
	 */
	public CarrierAuction getCarrierAuction(int carrierId, int billOfLadingId);
	
	/**
	 * 
	 * @param billOfLadingId
	 * @return
	 */
	public List<CarrierAuctionDTO> getCarrierAuctionList(int billOfLadingId);
	
	/**
	 * 
	 * @param billOfLadingId
	 * @return
	 */
	public CarrierAuctionDTO getCarrierAuctionSuccess(int billOfLadingId);
	
	/**
	 * Get carrier auction notification
	 * 
	 * @return
	 */
	public List<CarrierAuctionNotificationDTO> getCarrierAuctionNotification();
}
