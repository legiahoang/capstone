package vn.co.cex.bo.impl;

import java.util.List;

import vn.co.cex.bo.ProvinceBO;
import vn.co.cex.orm.Province;

public class ProvinceBOImpl extends BaseBOImpl implements ProvinceBO {

	/**
	 * Get all province
	 */
	public List<Province> getAllProvince() {

		return provinceDAO.getAllProvince();
	}

	public Province getProcinveByCode(String code) {
		return provinceDAO.getProcinveByCode(code);
	}
}
