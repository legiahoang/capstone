package vn.co.cex.bean.operationfee;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
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

@ManagedBean(name = "operationFeeEditBean", eager = true)
@ViewScoped
public class OperationFeeEditBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(ReferencePriceEditBean.class);
	@ManagedProperty(value = "#{operationFeeBO}")
	private OperationFeeBO operationFeeBO;

	private OperationFee operationFee;

	private boolean isSuccess;

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

	public boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**
	 * Init data
	 */
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

			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			Map<String, String> params = extContext.getRequestParameterMap();
			String id = params.get("id");
			operationFee = operationFeeBO.getOperationFeeById(Integer.parseInt(id));
			if (operationFee == null) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Home.xhtml");
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Edit operation fee
	 */
	public void editFee() {
		try {
			OperationFee oldFee = operationFeeBO.getOperationFeeById(operationFee.getId());
			oldFee.setStatus(ConstantUtils.OPERATIONFEE_INACTIVE);
			operationFeeBO.updateOperationFee(oldFee);
			operationFee.setId(null);
			isSuccess = operationFeeBO.addNewOperationFee(operationFee);
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
