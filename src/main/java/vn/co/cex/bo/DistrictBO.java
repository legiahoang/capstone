package vn.co.cex.bo;

import java.util.List;

import vn.co.cex.orm.District;

public interface DistrictBO extends BaseBO {

	/**
	 * Get district list
	 * 
	 * @return
	 */
	public List<District> getAllDistrict();

	/**
	 * Get district by province code
	 */
	public List<District> getDistrictByProvinceCode(String provinceCode);

	/**
	 * get District Name By Code
	 * 
	 * @param code
	 * @return
	 */
	public String getDistrictNameByCode(String code);

	/**
	 * getProvinceCodeByCode
	 * 
	 * @param code
	 * @return
	 */
	public String getProvinceCodeByCode(String code);
}
