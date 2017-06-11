package vn.co.cex.bean.usersAccount;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.UsersAccountBO;
import vn.co.cex.bo.UsersBO;
import vn.co.cex.dao.impl.CompanyDAOImpl;
import vn.co.cex.orm.Users;
import vn.co.cex.orm.UsersAccount;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

@SuppressWarnings("restriction")
@ManagedBean(name = "usersAccountBean", eager = true)
@ViewScoped
public class UsersAccountBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(CompanyDAOImpl.class);
	@ManagedProperty(value = "#{usersAccountBO}")

	private UsersAccountBO usersAccountBO;
	private UsersAccount usersAccount;
	
	@ManagedProperty(value = "#{usersBO}")
	private UsersBO usersBO;

	private UsersAccountBean usersAccountBean;
	private Users user;

	private boolean isSuccess;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public UsersBO getUsersBO() {
		return usersBO;
	}

	public void setUsersBO(UsersBO usersBO) {
		this.usersBO = usersBO;
	}
	public UsersAccountBO getUsersAccountBO() {
		return usersAccountBO;
	}

	public void setUsersAccountBO(UsersAccountBO usersAccountBO) {
		this.usersAccountBO = usersAccountBO;
	}

	public UsersAccountBean getUsersAccountBean() {
		return usersAccountBean;
	}

	public void setUsersAccountBean(UsersAccountBean usersAccountBean) {
		this.usersAccountBean = usersAccountBean;
	}

	public UsersAccount getUsersAccount() {
		return usersAccount;
	}

	public void setUsersAccount(UsersAccount usersAccount) {
		this.usersAccount = usersAccount;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@PostConstruct
	public void init() {
		try {
			Users userLogin = SessionUtils.getUser();
			HttpServletRequest request = super.getHTTPRequest();
			HttpServletResponse response = super.getHTTPResponse();
			// authorize
			if (userLogin == null) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Users/Login.xhtml");
				return;
			}
			// Get user
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			Map<String, String> params = extContext.getRequestParameterMap();
			String id = params.get("id");
			if (id != null) {
				user = usersBO.getUserById(Integer.parseInt(id));
				// Validate data
				if (user == null) {
					response.sendRedirect(request.getContextPath() + "/xhtml/Home.xhtml");
					return;
				}
			} else {
				user = userLogin;
			}
			//get user account by id
			int userId = user.getId();
			userName = user.getFullName();
			usersAccount = usersAccountBO.getAccountByUserId(userId);
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	/**
	 * Redirect to Users Account Information page
	 * 
	 * @return
	 */
	public String redirectUsersAccountInformation() {
		return ConstantUtils.USERS_ACCOUNT_INFORMATION;
	}
}
