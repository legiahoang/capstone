/**
 * 
 */
package vn.co.cex.bo;

import java.util.List;

import vn.co.cex.orm.OperationFee;

/**
 * @author HoangLG
 *
 */
public interface OperationFeeBO extends BaseBO {

	/**
	 * Get list all operation fee from OperationFee table
	 * 
	 * @return list of all operation fee
	 */
	List<OperationFee> getAllOperationFee(Integer status);

	/**
	 * Add new operation fee
	 * 
	 * @param operationFee
	 * @return
	 */
	public boolean addNewOperationFee(OperationFee operationFee);

	/**
	 * Update operation fee into OperationFee table
	 * 
	 * @param operationFee
	 */
	public boolean updateOperationFee(OperationFee operationFee);

	/**
	 * Get operation fee by id
	 * 
	 * @param id
	 * @return
	 */
	public OperationFee getOperationFeeById(int id);

	/**
	 * Get operation fee by code
	 * 
	 * @param code
	 * @return
	 */
	public OperationFee getOperationFeeByCode(String code);
}
