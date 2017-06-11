package vn.co.cex.bean.operationfee;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.OperationFeeBO;
import vn.co.cex.orm.OperationFee;

/**
 * @author HoangLG
 *
 */
@ManagedBean(name = "operationFeeBean", eager = true)
@ViewScoped
public class OperationFeeBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(OperationFeeBean.class);
	@ManagedProperty(value = "#{operationFeeBO}")
	private OperationFeeBO operationFeeBO;
	
	private List<OperationFee> operationFees;
	private Integer status;

	/**
	 * Init data
	 */
	@PostConstruct
	public void init() {
		try {
			operationFees = operationFeeBO.getAllOperationFee(status);
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public OperationFeeBO getOperationFeeBO() {
		return operationFeeBO;
	}

	public void setOperationFeeBO(OperationFeeBO operationFeeBO) {
		this.operationFeeBO = operationFeeBO;
	}

	public List<OperationFee> getOperationFees() {
		return operationFees;
	}

	public void setOperationFees(List<OperationFee> operationFees) {
		this.operationFees = operationFees;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Search operation fee
	 */
	public void searchOperationFee() {
		try {
			operationFees = operationFeeBO.getAllOperationFee(status);
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
