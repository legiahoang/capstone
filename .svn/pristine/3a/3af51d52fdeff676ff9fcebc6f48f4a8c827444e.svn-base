package vn.co.cex.bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import vn.co.cex.bo.UsersBO;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.mail.MailerBean;

@ManagedBean(name = "confirmRegisterBean", eager = true)
public class ConfirmRegisterBean extends BaseBean {

	@ManagedProperty(value = "#{mailerBean}")
	private MailerBean mailerBean;

	@ManagedProperty(value = "#{usersBO}")
	private UsersBO usersBO;

	private int status;

	public MailerBean getMailerBean() {
		return mailerBean;
	}

	public void setMailerBean(MailerBean mailerBean) {
		this.mailerBean = mailerBean;
	}

	public UsersBO getUsersBO() {
		return usersBO;
	}

	public void setUsersBO(UsersBO usersBO) {
		this.usersBO = usersBO;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@PostConstruct
	public void init() {

	}

	/**
	 * Confirm account register
	 */
	public void confirmRegister() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext extContext = context.getExternalContext();
		Map<String, String> params = extContext.getRequestParameterMap();
		String code = params.get("code");

		final String salt = code.substring(0, 16);

		// Decrypt
		TextEncryptor decryptor = Encryptors.text(ConstantUtils.PASSWORD_KEY, salt);
		String decryptedText = decryptor.decrypt(code.substring(16));

		String email = decryptedText.substring(0, decryptedText.indexOf('\\'));
		String datetime = decryptedText.substring(decryptedText.indexOf('\\') + 1);

		Users user = usersBO.getUserByEmail(email);

		if (user.getStatus() == ConstantUtils.USER_STATUS_UNCONFIRM) {
			status = user.getStatus();
			user.setStatus(ConstantUtils.USER_STATUS_CONFIRM);
			usersBO.updateUsers(user);
		} else if (user.getStatus() == ConstantUtils.USER_STATUS_CONFIRM) {
			status = user.getStatus();
		} else {
			status = ConstantUtils.USER_STATUS_INVALID;
		}
	}
}
