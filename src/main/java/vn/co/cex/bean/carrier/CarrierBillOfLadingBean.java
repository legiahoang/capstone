package vn.co.cex.bean.carrier;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.BillOfLadingBO;
import vn.co.cex.dto.BillOfLadingDTO;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

@SuppressWarnings("restriction")
@ManagedBean(name = "carrierBillOfLadingBean", eager = true)
@ViewScoped
public class CarrierBillOfLadingBean extends BaseBean {
	
	private static final Logger log = LogManager.getLogger(CarrierBillOfLadingBean.class);
	@ManagedProperty(value = "#{billOfLadingBO}")
	private BillOfLadingBO billOfLadingBO;

	private Users user;

	private LazyDataModel<BillOfLadingDTO> billOfLadings;
	private Integer goodsTypeId;
	private Integer packagedFormId;
	private Float weight;
	private Float volume;
	private String departureProvinceCode;
	private String arrivalProvinceCode;
	private Date departureDate;
	private Date arrivalDate;
	private int timeRemaining;

	@PostConstruct
	public void init() {
		try {
			user = SessionUtils.getUser();
			HttpServletRequest request = super.getHTTPRequest();
			HttpServletResponse response = super.getHTTPResponse();
			if (user == null || (user.getRole() == ConstantUtils.USER_GOODS_OWNER)) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Users/Login.xhtml");
				return;
			}
			searchBillOfLadingByCarrier();
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public BillOfLadingBO getBillOfLadingBO() {
		return billOfLadingBO;
	}

	public void setBillOfLadingBO(BillOfLadingBO billOfLadingBO) {
		this.billOfLadingBO = billOfLadingBO;
	}

	public LazyDataModel<BillOfLadingDTO> getBillOfLadings() {
		return billOfLadings;
	}

	public void setBillOfLadings(LazyDataModel<BillOfLadingDTO> billOfLadings) {
		this.billOfLadings = billOfLadings;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Integer getPackagedFormId() {
		return packagedFormId;
	}

	public void setPackagedFormId(Integer packagedFormId) {
		this.packagedFormId = packagedFormId;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Float getVolume() {
		return volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}

	public String getDepartureProvinceCode() {
		return departureProvinceCode;
	}

	public void setDepartureProvinceCode(String departureProvinceCode) {
		this.departureProvinceCode = departureProvinceCode;
	}

	public String getArrivalProvinceCode() {
		return arrivalProvinceCode;
	}

	public void setArrivalProvinceCode(String arrivalProvinceCode) {
		this.arrivalProvinceCode = arrivalProvinceCode;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Calculate time to auction
	 * 
	 * @param date
	 * @return
	 */
	public long secondsRemaining(Date date) {
		Date dateNow = new Date();
		long secondsRemaining = (date.getTime() - dateNow.getTime()) / 1000;
		return secondsRemaining;
	}

	/**
	 * Search transactions by condition
	 */
	public void searchBillOfLadingByCarrier() {
		try {
			billOfLadings = new LazyDataModel<BillOfLadingDTO>() {

				/**
				 * 
				 */
				private static final long serialVersionUID = -6935485298528007165L;

				@Override
				public List<BillOfLadingDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					// Pass parameters to DAO
					List<BillOfLadingDTO> list = billOfLadingBO.searchBillOfLadingByCarrier(goodsTypeId, packagedFormId,
							weight, volume, departureProvinceCode, arrivalProvinceCode, departureDate, arrivalDate,
							user.getId(), pageSize, first);
					return list;
				}
			};
			// Count total items
			int count = billOfLadingBO.countBillOfLadingOfCarrier(goodsTypeId, packagedFormId, weight, volume,
					departureProvinceCode, arrivalProvinceCode, departureDate, arrivalDate, user.getId());
			billOfLadings.setRowCount(count);
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
