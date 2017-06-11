package vn.co.cex.dao;

import java.util.List;

import vn.co.cex.orm.OperationFee;

/**
 * @author HoangLG
 *
 */
public interface OperationFeeDAO extends BaseDAO {
	/**
	 * get list all operation fee from OperationFee table
	 * @param status
	 * @return list of all operation fee
	 */
	public List<OperationFee> getAllOperationFee(Integer status);

	/**
	 * Add new operation fee
	 * 
	 * @param operationFee
	 * @return
	 */
	public boolean addNewOperationFee(OperationFee operationFee);

	/**
	 * Update operation fee
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
