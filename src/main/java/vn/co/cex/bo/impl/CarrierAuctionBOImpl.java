package vn.co.cex.bo.impl;

import java.util.List;

import vn.co.cex.bo.CarrierAuctionBO;
import vn.co.cex.dto.CarrierAuctionDTO;
import vn.co.cex.dto.CarrierAuctionNotificationDTO;
import vn.co.cex.orm.CarrierAuction;

public class CarrierAuctionBOImpl extends BaseBOImpl implements CarrierAuctionBO {

	/**
	 * Add new carrier auction
	 */
	public boolean addNewCarrierAuction(CarrierAuction data) {
		return carrierAuctionDAO.addNewCarrierAuction(data);
	}

	/**
	 * Update carrier auction
	 */
	public boolean updateCarrierAuction(CarrierAuction data) {
		return carrierAuctionDAO.updateCarrierAuction(data);
	}

	/**
	 * Get carrier auction
	 */
	public CarrierAuction getCarrierAuction(int carrierId, int billOfLadingId) {
		return carrierAuctionDAO.getCarrierAuction(carrierId, billOfLadingId);
	}

	/**
	 * Get bill of lading list
	 */
	public List<CarrierAuctionDTO> getCarrierAuctionList(int billOfLadingId) {
		return carrierAuctionDAO.getCarrierAuctionList(billOfLadingId);
	}

	/**
	 * Get carrier auction success
	 */
	public CarrierAuctionDTO getCarrierAuctionSuccess(int billOfLadingId) {
		return carrierAuctionDAO.getCarrierAuctionSuccess(billOfLadingId);
	}

	/**
	 * Get carrier auction notification
	 */
	public List<CarrierAuctionNotificationDTO> getCarrierAuctionNotification() {
		return carrierAuctionDAO.getCarrierAuctionNotification();
	}
}
