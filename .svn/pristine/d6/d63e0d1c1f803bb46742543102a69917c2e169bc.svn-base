package vn.co.cex.dao;

import java.util.List;

import vn.co.cex.dto.UsersDTO;
import vn.co.cex.orm.Users;

/**
 * @author QuyetVu
 *
 */
public interface UsersDAO extends BaseDAO {

	/**
	 * Get user by id
	 * 
	 * @param id
	 * @return
	 */
	public Users getUserById(int id);

	/**
	 * Validate Email and Password
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public Users checkLogin(String email, String password);

	/**
	 * Update users
	 * 
	 * @param data
	 * @return
	 */
	public boolean updateUsers(Users data);

	/**
	 * Get users by email
	 * 
	 * @param email
	 * @return
	 */
	public Users getUserByEmail(String email);

	/**
	 * Register user
	 * 
	 * @param u
	 * @return
	 */
	public int register(Users u);

	/**
	 * Check Email already exited or not.
	 * 
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email);

	/**
	 * Check phoneNumber
	 * 
	 * @param password
	 * @return
	 */
	public boolean checkPhoneNumber(String phoneNumber);

	/**
	 * Check IdentityCard
	 * 
	 * @param identityCard
	 * @return
	 */
	public boolean checkIdentityCard(String identityCard);

	/**
	 * Search user
	 * 
	 * @param fullName
	 * @param email
	 * @param province
	 * @param role
	 * @param status
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	public List<UsersDTO> searchUser(String fullName, String email, String province, Integer role, int status,
			int pageSize, int pageIndex);

	/**
	 * Count users
	 * 
	 * @param fullName
	 * @param email
	 * @param province
	 * @param role
	 * @param status
	 * @return
	 */
	public int countUsers(String fullName, String email, String province, Integer role, int status);
	
	/**
	 * activate user
	 * 
	 * @param id
	 * @return
	 */
	public void activateUser(int user_id);

	/**
	 * deactivate user
	 * 
	 * @param id
	 */
	public void deactivateUser(int user_id);
}
