package vn.co.cex.bo;

import java.util.Date;
import java.util.List;
import vn.co.cex.dto.BillOfLadingDTO;
import vn.co.cex.dto.BillOfLadingNotificationDTO;
import vn.co.cex.dto.BillOfLadingSummaryDTO;
import vn.co.cex.dto.ChartViewDTO;
import vn.co.cex.orm.BillOfLading;

public interface BillOfLadingBO extends BaseBO {

	/**
	 * Count total bill of lading
	 * 
	 * @param status
	 * @return
	 */
	int countTotalBillOfLading(int status);

	/**
	 * Get bill of lading summary
	 * 
	 * @return
	 */
	BillOfLadingSummaryDTO getBillOfLadingSummary();

	/**
	 * Search bill of lading summary
	 * 
	 * @param goodsTypeId
	 * @param packFormId
	 * @param weight
	 * @param volume
	 * @param departureProvince
	 * @param arrivalProvince
	 * @param departureDate
	 * @param arrivalDate
	 * @return
	 */
	BillOfLadingSummaryDTO searchBillOfLadingSummary(Integer goodsTypeId, Integer packFormId, Float weight, Float volume,
			String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate);

	/**
	 * Get char view
	 * 
	 * @return
	 */
	List<ChartViewDTO> getChartView();

	/**
	 * Add new bill of lading
	 * 
	 * @return
	 */
	boolean addNewBillOfLading(BillOfLading data);

	/**
	 * Update bill of lading
	 * 
	 * @param data
	 * @return
	 */
	public boolean updateBillOfLading(BillOfLading data);

	/**
	 * Get bill of lading by id
	 * 
	 * @param id
	 * @return
	 */
	public BillOfLading getBillOfLadingById(int id);

	/**
	 * Get bill of lading by id
	 * 
	 * @param id
	 * @return
	 */
	public BillOfLadingDTO getBillOfLadingDTOById(int id);

	/**
	 * Search bill of lading
	 * 
	 * @param goodsTypeId
	 * @param packagedFormId
	 * @param weight
	 * @param volume
	 * @param departureProvince
	 * @param arrivalProvince
	 * @param departureDate
	 * @param arrivalDate
	 * @param status
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	public List<BillOfLadingDTO> searchBillOfLading(Integer goodsTypeId, Integer packagedFormId, Float weight,
			Float volume, String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate,
			Integer status, int pageSize, int pageIndex);

	/**
	 * Search bill of lading of goods owner by condition
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
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	public List<BillOfLadingDTO> searchBillOfLadingOfGoodsOwner(Integer goodsTypeId, Integer packagedFormId,
			Float weight, Float volume, String departureProvince, String arrivalProvince, Date departureDate,
			Date arrivalDate, int userId, int pageSize, int pageIndex);

	/**
	 * Count bill of lading of goods owner
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
			String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate, int userId);

	/**
	 * Search bill of lading by carrier
	 * 
	 * @param goodsTypeId
	 * @param packagedFormId
	 * @param weight
	 * @param volume
	 * @param departureProvinceCode
	 * @param arrivalProvinceCode
	 * @param departureDate
	 * @param arrivalDate
	 * @param carrierId
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	public List<BillOfLadingDTO> searchBillOfLadingByCarrier(Integer goodsTypeId, Integer packagedFormId, Float weight,
			Float volume, String departureProvinceCode, String arrivalProvinceCode, Date departureDate,
			Date arrivalDate, int carrierId, int pageSize, int pageIndex);

	/**
	 * Count Bill Of Lading Of Carrier
	 * 
	 * @param goodsTypeId
	 * @param packagedFormId
	 * @param weight
	 * @param volume
	 * @param departureProvince
	 * @param arrivalProvince
	 * @param departureDate
	 * @param arrivalDate
	 * @param carrierId
	 * @return
	 */
	public int countBillOfLadingOfCarrier(Integer goodsTypeId, Integer packagedFormId, Float weight, Float volume,
			String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate, int carrierId);

	/**
	 * Count bill of lading
	 * 
	 * @param goodsTypeId
	 * @param packagedFormId
	 * @param weight
	 * @param volume
	 * @param departureProvince
	 * @param arrivalProvince
	 * @param departureDate
	 * @param arrivalDate
	 * @param status
	 * @return
	 */
	public int countBillOfLading(Integer goodsTypeId, Integer packagedFormId, Float weight, Float volume,
			String departureProvince, String arrivalProvince, Date departureDate, Date arrivalDate, Integer status);

	/**
	 * Bill of lading process
	 */
	public void billOfLadingProcess();

	/**
	 * Get bill of lading notification
	 * 
	 * @return
	 */
	public List<BillOfLadingNotificationDTO> getBillOfLadingNotification();
}
