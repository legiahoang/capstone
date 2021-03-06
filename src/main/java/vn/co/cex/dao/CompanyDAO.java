package vn.co.cex.dao;

import java.util.List;

import vn.co.cex.orm.Company;

/**
 * @author QuyetVu
 *
 */
public interface CompanyDAO extends BaseDAO {

	/**
	 * Get PaymentDetailBean by id
	 * 
	 * @param id
	 * @return
	 */
	public Company getCompanyById(int id);

	/**
	 * Get PaymentDetailBean by email
	 * 
	 * @param email
	 * @return
	 */
	public Company getCompanyByEmail(String email);

	/**
	 * Update Company Information
	 * 
	 * @param data
	 * @return
	 */
	public boolean updateCompany(Company data);

	/**
	 * Insert Company Information
	 * 
	 * @param data
	 * @return
	 */

	public boolean InsertCompany(Company data);
}
