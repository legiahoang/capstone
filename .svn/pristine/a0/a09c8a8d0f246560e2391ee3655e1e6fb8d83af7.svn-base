package vn.co.cex.bo.impl;

import java.util.List;

import vn.co.cex.bo.UsersBO;
import vn.co.cex.dto.UsersDTO;
import vn.co.cex.orm.Users;

/**
 * @author QuyetVu
 *
 */
public class UsersBOImpl extends BaseBOImpl implements UsersBO {

	/**
	 * getUserById
	 */
	public Users getUserById(int id) {
		return usersDAO.getUserById(id);
	}

	/**
	 * Check Login
	 */
	public Users checkLogin(String email, String password) {
		return usersDAO.checkLogin(email, password);
	}

	/**
	 * updateUsers
	 */
	public boolean updateUsers(Users data) {
		return usersDAO.updateUsers(data);
	}

	/**
	 * Get user by email
	 */
	public Users getUserByEmail(String email) {
		return usersDAO.getUserByEmail(email);
	}

	/**
	 * register user
	 */
	public int register(Users user) {
		return usersDAO.register(user);
	}

	/**
	 * check Email already exited or not
	 */
	public boolean checkEmail(String email) {
		return usersDAO.checkEmail(email);
	}

	/**
	 * search User
	 */
	public List<UsersDTO> searchUser(String fullName, String email, String province, Integer role, int status,
			int pageSize, int pageIndex) {
		return usersDAO.searchUser(fullName, email, province, role, status, pageSize, pageIndex);
	}

	/**
	 * checkPhoneNumber
	 */
	public boolean checkPhoneNumber(String phoneNumber) {
		return usersDAO.checkPhoneNumber(phoneNumber);
	}

	/**
	 * checkIdentityCard
	 */
	public boolean checkIdentityCard(String identityCard) {
		return usersDAO.checkIdentityCard(identityCard);
	}

	/**
	 * Count users
	 */
	public int countUsers(String fullName, String email, String province, Integer role, int status) {
		return usersDAO.countUsers(fullName, email, province, role, status);
	}

	/**
	 * active the user
	 */
	public void activateUser(int user_id) {
		usersDAO.activateUser(user_id);
	}

	/**
	 * deactivate the user
	 */
	public void deactivateUser(int user_id) {
		usersDAO.deactivateUser(user_id);
	}
}
