package vn.co.cex.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import vn.co.cex.bo.DistrictBO;
import vn.co.cex.orm.District;

@SuppressWarnings("restriction")
@ManagedBean(name = "districtBean", eager = true)
@ViewScoped
public class DistrictBean extends BaseBean {

	@ManagedProperty(value = "#{districtBO}")
	private DistrictBO districtBO;

	private List<District> districtList;
	private List<District> districtList2;
	private String district;
	private String provinceCode;

	// /**
	// * Init data districtList
	// */
	// @PostConstruct
	// public void init(){
	// try{
	// districtList = districtBO.getAllDistrict();
	// }
	// catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public String getDistrict() {
		return district;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public DistrictBO getDistrictBO() {
		return districtBO;
	}

	public void setDistrictBO(DistrictBO districtBO) {
		this.districtBO = districtBO;
	}

	public List<District> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}

	public List<District> getDistrictList2() {
		return districtList2;
	}

	public void setDistrictList2(List<District> districtList2) {
		this.districtList2 = districtList2;
	}

	/**
	 * Get district by province code
	 */
	public List<District> getDistrictByProvinceCode(String provinceCode) {
		districtList = districtBO.getDistrictByProvinceCode(provinceCode);
		return districtList;
	}

	/**
	 * Get district by province code
	 */
	public List<District> getDistrict2ByProvinceCode(String provinceCode) {
		districtList2 = districtBO.getDistrictByProvinceCode(provinceCode);
		return districtList2;
	}

	public String getDistrictNameByCode(String code) {
		district = districtBO.getDistrictNameByCode(code);
		return district;
	}

	public String getProvinceCodeByCode(String code) {
		provinceCode = districtBO.getProvinceCodeByCode(code);
		return provinceCode;
	}
}