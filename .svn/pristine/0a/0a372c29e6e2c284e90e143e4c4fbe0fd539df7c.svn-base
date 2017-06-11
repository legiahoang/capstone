package vn.co.cex.bo.impl;

import java.util.List;

import vn.co.cex.bo.CompanyBO;
import vn.co.cex.orm.Company;

/**
 * @author QuyetVu
 *
 */
public class CompanyBOImpl extends BaseBOImpl implements CompanyBO {

	/**
	 * Get PaymentDetailBean By ID
	 */
	public Company getCompanyById(int id) {
		return companyDAO.getCompanyById(id);
	}

	/**
	 * Get PaymentDetailBean By Email
	 */
	public Company getCompanyByEmail(String email) {
		return companyDAO.getCompanyByEmail(email);
	}

	/**
	 * Update Company
	 */
	public boolean updateCompany(Company data) {
		return companyDAO.updateCompany(data);
	}

	/**
	 * Insert Company
	 */
	public boolean InsertCompany(Company data) {
		return companyDAO.InsertCompany(data);
	}
}
