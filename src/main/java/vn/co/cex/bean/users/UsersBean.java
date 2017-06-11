package vn.co.cex.bean.users;

import java.util.Date;
import java.util.List;
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
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.co.cex.bean.BaseBean;
import vn.co.cex.bo.UsersBO;
import vn.co.cex.dto.UsersDTO;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

@SuppressWarnings("restriction")
@ManagedBean(name = "usersBean", eager = true)
@ViewScoped
public class UsersBean extends BaseBean {
	
	private static final Logger log = LogManager.getLogger(UsersBean.class);

	@ManagedProperty(value = "#{usersBO}")
	private UsersBO usersBO;

	private LazyDataModel<UsersDTO> usersList;

	private Integer id;
	private String code;
	private String fullName;
	private String email;
	private String password;
	private String phoneNumber;
	private String address;
	private String province;
	private String district;
	private String identityCard;
	private String identityCardPlace;
	private Date identityCardDate;
	private Integer role;
	private int status;
	private Date created;
	private int companyId;

	@PostConstruct
	public void init() {

		try {
			Users user = SessionUtils.getUser();
			HttpServletRequest request = super.getHTTPRequest();
			HttpServletResponse response = super.getHTTPResponse();
			if (user == null) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Users/Login.xhtml");
				return;
			} else if (user.getRole() == ConstantUtils.USER_ADMIN) {
				searchUser();
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * @return the companyId
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the usersBO
	 */
	public UsersBO getUsersBO() {
		return usersBO;
	}

	/**
	 * @param usersBO
	 *            the usersBO to set
	 */
	public void setUsersBO(UsersBO usersBO) {
		this.usersBO = usersBO;
	}

	/**
	 * @return the usersList
	 */
	public LazyDataModel<UsersDTO> getUsersList() {
		return usersList;
	}

	/**
	 * @param usersList
	 *            the usersList to set
	 */
	public void setUsersList(LazyDataModel<UsersDTO> usersList) {
		this.usersList = usersList;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName
	 *            the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province
	 *            the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the identityCard
	 */
	public String getIdentityCard() {
		return identityCard;
	}

	/**
	 * @param identityCard
	 *            the identityCard to set
	 */
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	/**
	 * @return the identityCardPlace
	 */
	public String getIdentityCardPlace() {
		return identityCardPlace;
	}

	/**
	 * @param identityCardPlace
	 *            the identityCardPlace to set
	 */
	public void setIdentityCardPlace(String identityCardPlace) {
		this.identityCardPlace = identityCardPlace;
	}

	/**
	 * @return the identityCardDate
	 */
	public Date getIdentityCardDate() {
		return identityCardDate;
	}

	/**
	 * @param identityCardDate
	 *            the identityCardDate to set
	 */
	public void setIdentityCardDate(Date identityCardDate) {
		this.identityCardDate = identityCardDate;
	}

	/**
	 * @return the role
	 */
	public Integer getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Integer role) {
		this.role = role;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Search user by condition
	 */
	public void searchUser() {
		try {
			usersList = new LazyDataModel<UsersDTO>() {
				@Override
				public List<UsersDTO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					List<UsersDTO> list = usersBO.searchUser(fullName, email, province, role, status, pageSize, first);
					return list;
				}
			};

			// Count users
			int count = usersBO.countUsers(fullName, email, province, role, status);
			usersList.setRowCount(count);
		} catch (Exception e) {
			log.debug(e);
		}
	}
	
	/**
	 * activate user
	 */
	public void activateUser() {
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			Map<String, String> params = extContext.getRequestParameterMap();
			String user_id = params.get("user_id");
			usersBO.activateUser(Integer.parseInt(user_id));
		}
		catch (Exception e) {
			log.debug(e);
		}
	}
	
	/**
	 * deactivate user
	 */
	public void deactivateUser() {
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			Map<String, String> params = extContext.getRequestParameterMap();
			String user_id = params.get("user_id");
			usersBO.deactivateUser(Integer.parseInt(user_id));
		}
		catch (Exception e) {
			log.debug(e);
		}
	}

}
