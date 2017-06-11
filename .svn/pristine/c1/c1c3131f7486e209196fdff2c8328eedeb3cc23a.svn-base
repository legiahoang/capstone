package vn.co.cex.bean.operationfee;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.OperationFeeBO;
import vn.co.cex.orm.OperationFee;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

@ManagedBean(name = "operationFeeAddBean", eager = true)
@ViewScoped
public class OperationFeeAddBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(OperationFeeAddBean.class);
	@ManagedProperty(value = "#{operationFeeBO}")
	private OperationFeeBO operationFeeBO;

	private OperationFee operationFee;

	private int isSuccess;

	public OperationFeeBO getOperationFeeBO() {
		return operationFeeBO;
	}

	public void setOperationFeeBO(OperationFeeBO operationFeeBO) {
		this.operationFeeBO = operationFeeBO;
	}

	public OperationFee getOperationFee() {
		return operationFee;
	}

	public void setOperationFee(OperationFee operationFee) {
		this.operationFee = operationFee;
	}

	public int getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}

	@PostConstruct
	public void init() {
		try {
			Users user = SessionUtils.getUser();
			HttpServletRequest request = super.getHTTPRequest();
			HttpServletResponse response = super.getHTTPResponse();
			// authorize
			if (user == null || (user.getRole() != ConstantUtils.USER_ADMIN)) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Users/Login.xhtml");
				return;
			}
			operationFee = new OperationFee();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add new operation
	 */
	public void addNewFee() {
		try {
			if (operationFeeBO.getOperationFeeByCode(operationFee.getCode()) == null) {
				operationFee.setStatus(ConstantUtils.OPERATIONFEE_ACTIVE);
				boolean result = operationFeeBO.addNewOperationFee(operationFee);
				if(result) isSuccess = 1; //Success
			} else {
				isSuccess = -1; //FeeCode have already existed
				FacesMessage facesMessage = new FacesMessage("Mã chi phí đã được sử dụng!");
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
			/*
			 * if (isSuccess) { RequestContext.getCurrentInstance().execute(
			 * "PF('message_dlg').show()"); }
			 */
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Redirect to list operation fee page
	 * 
	 * @return
	 */
	public String gotoListOperationFee() {
		return "listOperationFee";
	}
}
