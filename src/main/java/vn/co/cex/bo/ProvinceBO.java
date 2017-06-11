package vn.co.cex.bo;

import java.util.List;

import vn.co.cex.orm.Province;

public interface ProvinceBO extends BaseBO {
	/**
	 * Get all province
	 * 
	 * @return
	 */
	public List<Province> getAllProvince();

	/**
	 * Get province by code
	 * 
	 * @param code
	 * @return
	 */
	public Province getProcinveByCode(String code);
}
