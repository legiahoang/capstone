package vn.co.cex.bean.billoflading;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.BillOfLadingBO;
import vn.co.cex.dto.BillOfLadingDTO;

@SuppressWarnings("restriction")
@ManagedBean(name = "commonBean", eager = true)
@ViewScoped
public class CommonBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(CommonBean.class);

	@ManagedProperty(value = "#{billOfLadingBO}")
	private BillOfLadingBO billOfLadingBO;

	private LazyDataModel<BillOfLadingDTO> billOfLadings;
	private Integer goodsTypeId;
	private Integer packagedFormId;
	private Float weight;
	private Float volume;
	private String departureProvinceCode;
	private String arrivalProvinceCode;
	private Date departureDate;
	private Date arrivalDate;
	private Integer status;
	private int timeRemaining;

	@PostConstruct
	public void init() {
		try {
			searchBillOfLading();
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Count remaining time for bill of lading
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
	public void searchBillOfLading() {
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
					List<BillOfLadingDTO> list = billOfLadingBO.searchBillOfLading(goodsTypeId, packagedFormId, weight,
							volume, departureProvinceCode, arrivalProvinceCode, departureDate, arrivalDate, status,
							pageSize, first);
					return list;
				}
			};
			// Count total items
			int count = billOfLadingBO.countBillOfLading(goodsTypeId, packagedFormId, weight, volume,
					departureProvinceCode, arrivalProvinceCode, departureDate, arrivalDate, status);
			billOfLadings.setRowCount(count);
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
