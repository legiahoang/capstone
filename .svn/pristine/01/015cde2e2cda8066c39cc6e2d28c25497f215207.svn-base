package vn.co.cex.bo;

import vn.co.cex.orm.UsersAccount;

public interface UsersAccountBO extends BaseBO {
	/**
	 * Create new account
	 * 
	 * @param userId
	 * @return
	 */
	boolean createNewAccount(int userId);

	/**
	 * Get account by user id
	 * 
	 * @param userId
	 * @return
	 */
	UsersAccount getAccountByUserId(int userId);

	/**
	 * Check account
	 * 
	 * @param userId
	 * @return
	 */
	float checkAccount(int userId);

	/**
	 * Plus money account
	 * 
	 * @param userId
	 * @param amount
	 * @return
	 */
	boolean plusMoneyAccount(int userId, float amount);

	/**
	 * Minus money account
	 * 
	 * @param userId
	 * @param amount
	 * @return
	 */
	boolean minusMoneyAccount(int userId, float amount);
}
