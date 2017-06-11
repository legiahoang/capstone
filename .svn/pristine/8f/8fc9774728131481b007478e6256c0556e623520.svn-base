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
import vn.co.cex.bo.GoodsTypeBO;
import vn.co.cex.orm.GoodsType;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

@ManagedBean(name = "referencePriceEditBean", eager = true)
@ViewScoped
public class ReferencePriceEditBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(ReferencePriceEditBean.class);

	@ManagedProperty(value = "#{goodsTypeBO}")
	private GoodsTypeBO goodsTypeBO;

	private GoodsType goodsType;

	private boolean isSuccess;

	public GoodsTypeBO getGoodsTypeBO() {
		return goodsTypeBO;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsTypeBO(GoodsTypeBO goodsTypeBO) {
		this.goodsTypeBO = goodsTypeBO;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
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

			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			Map<String, String> params = extContext.getRequestParameterMap();
			String id = params.get("id");
			if (id == null || id.equals("")) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Home.xhtml");
				return;
			}
			goodsType = goodsTypeBO.getGoodsType(Integer.parseInt(id));
			if (goodsType == null) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Home.xhtml");
				return;
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Update reference price
	 */
	public void updateReferencePrice() {
		try {
			if (goodsType != null) {
				goodsTypeBO.updateGoodsType(goodsType);
				isSuccess = true;
			}
		} catch (Exception e) {
			log.debug(e);
			isSuccess = false;
		}
	}

	/**
	 * Redirect to list reference price page
	 * 
	 * @return
	 */
	public String gotoListReferencePrice() {
		return "listReferencePrice";
	}
}
