package vn.co.cex.bean.admin;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.BillOfLadingBO;
import vn.co.cex.dto.BillOfLadingSummaryDTO;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

@SuppressWarnings("restriction")
@ManagedBean(name = "summaryBillOfLadingBean", eager = true)
@ViewScoped
public class SummaryBillOfLadingBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(SummaryBillOfLadingBean.class);

	@ManagedProperty(value = "#{billOfLadingBO}")
	private BillOfLadingBO billOfLadingBO;
	private BillOfLadingSummaryDTO billOfLadingSummaryDTO;
	private Users user;

	private Integer goodsTypeId;
	private Integer packFormId;
	private Float weight;
	private Float volume;
	private String departureProvince;
	private String arrivalProvince;
	private Date departureDate;
	private Date arrivalDate;

	@PostConstruct
	public void init() {
		try {
			Users user = SessionUtils.getUser();
			HttpServletRequest request = super.getHTTPRequest();
			HttpServletResponse response = super.getHTTPResponse();
			if (user == null || (user.getRole() != ConstantUtils.USER_ADMIN)) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Users/Login.xhtml");
				return;
			}
			billOfLadingSummaryDTO = billOfLadingBO.getBillOfLadingSummary();
			if (billOfLadingSummaryDTO == null) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Home.xhtml");
				return;
			}
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

	public BillOfLadingSummaryDTO getBillOfLadingSummaryDTO() {
		return billOfLadingSummaryDTO;
	}

	public void setBillOfLadingSummaryDTO(BillOfLadingSummaryDTO billOfLadingSummaryDTO) {
		this.billOfLadingSummaryDTO = billOfLadingSummaryDTO;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Integer getPackFormId() {
		return packFormId;
	}

	public void setPackFormId(Integer packFormId) {
		this.packFormId = packFormId;
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

	public String getDepartureProvince() {
		return departureProvince;
	}

	public void setDepartureProvince(String departureProvince) {
		this.departureProvince = departureProvince;
	}

	public String getArrivalProvince() {
		return arrivalProvince;
	}

	public void setArrivalProvince(String arrivalProvince) {
		this.arrivalProvince = arrivalProvince;
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

	/**
	 * Search bill of lading summary
	 */
	public void searchBillOfLadingSummary() {
		try {
			billOfLadingSummaryDTO = billOfLadingBO.searchBillOfLadingSummary(goodsTypeId, packFormId, weight, volume,
					departureProvince, arrivalProvince, departureDate, arrivalDate);
		} catch (Exception e) {
			log.debug(e);
		}

	}
}
