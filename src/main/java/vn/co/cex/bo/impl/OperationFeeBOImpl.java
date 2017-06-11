package vn.co.cex.bo.impl;

import java.util.Date;
import java.util.List;

import vn.co.cex.bo.OperationFeeBO;
import vn.co.cex.orm.OperationFee;

public class OperationFeeBOImpl extends BaseBOImpl implements OperationFeeBO {
	
	/* (non-Javadoc)
	 * @see vn.co.cex.bo.OperationFeeBO#getAllOperationFee()
	 */
	public List<OperationFee> getAllOperationFee(Integer status) {
		return operationFeeDAO.getAllOperationFee(status);
	};
	
	/*
	 * (non-Javadoc)
	 * @see vn.co.cex.bo.OperationFeeBO#addNewOperationFee(vn.co.cex.orm.OperationFee)
	 */
	public boolean addNewOperationFee(OperationFee operationFee){
		return operationFeeDAO.addNewOperationFee(operationFee);
	}

	/* (non-Javadoc)
	 * @see vn.co.cex.bo.OperationFeeBO#saveOrUpdateOperationFee(vn.co.cex.orm.OperationFee)
	 */
	public boolean updateOperationFee(OperationFee operationFee) {
		return operationFeeDAO.updateOperationFee(operationFee);
	}
	
	/*
	 * (non-Javadoc)
	 * @see vn.co.cex.bo.OperationFeeBO#getOperationFeeById(int)
	 */
	public OperationFee getOperationFeeById(int id){
		return operationFeeDAO.getOperationFeeById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see vn.co.cex.bo.OperationFeeBO#getOperationFeeByCode(java.lang.String)
	 */
	public OperationFee getOperationFeeByCode(String code) {
		return operationFeeDAO.getOperationFeeByCode(code);
	}
}
