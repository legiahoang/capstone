package vn.co.cex.bo.impl;

import vn.co.cex.bo.UsersAccountBO;
import vn.co.cex.orm.UsersAccount;

public class UsersAccountBOImpl extends BaseBOImpl implements UsersAccountBO {

	/**
	 * Create new account
	 */
	public boolean createNewAccount(int userId) {

		return usersAccountDAO.createNewAccount(userId);
	}

	/**
	 * Get account by user id
	 */
	public UsersAccount getAccountByUserId(int userId) {

		return usersAccountDAO.getAccountByUserId(userId);
	}

	/**
	 * Check account
	 */
	public float checkAccount(int userId) {

		return checkAccount(userId);
	}

	/**
	 * Plus money account
	 */
	public boolean plusMoneyAccount(int userId, float amount) {

		return usersAccountDAO.plusMoneyAccount(userId, amount);
	}

	/**
	 * Minus money account
	 */
	public boolean minusMoneyAccount(int userId, float amount) {

		return usersAccountDAO.minusMoneyAccount(userId, amount);
	}
}
