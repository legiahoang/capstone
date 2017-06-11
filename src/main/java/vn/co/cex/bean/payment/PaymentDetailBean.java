package vn.co.cex.bean.payment;

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
import vn.co.cex.bo.PaymentDetailBO;
import vn.co.cex.bo.UsersAccountBO;
import vn.co.cex.bo.UsersBO;
import vn.co.cex.orm.PaymentDetail;
import vn.co.cex.orm.Users;
import vn.co.cex.orm.UsersAccount;
import vn.co.cex.utils.SessionUtils;

@SuppressWarnings("restriction")
@ManagedBean(name = "paymentDetailBean", eager = true)

@ViewScoped
public class PaymentDetailBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(PaymentDetailBean.class);
	@ManagedProperty(value = "#{paymentDetailBO}")
	private PaymentDetailBO paymentDetailBO;
	@ManagedProperty(value = "#{usersBO}")
	private UsersBO usersBO;
	private Users user;
	private LazyDataModel<PaymentDetail> paymentDetailList;
	@ManagedProperty(value = "#{usersAccountBO}")
	private UsersAccountBO usersAccountBO;
	private UsersAccount usersAccount;

	public LazyDataModel<PaymentDetail> getPaymentDetailList() {
		return paymentDetailList;
	}

	public void setPaymentDetailList(LazyDataModel<PaymentDetail> paymentDetailList) {
		this.paymentDetailList = paymentDetailList;
	}

	private Integer id;
	private float amounts;
	private Date paymentDate;
	private boolean type;
	private String description;
	private int userId;
	private Date beginPaymentDate;
	private Date endPaymentDate;

	public UsersAccountBO getUsersAccountBO() {
		return usersAccountBO;
	}

	public void setUsersAccountBO(UsersAccountBO usersAccountBO) {
		this.usersAccountBO = usersAccountBO;
	}

	public Date getBeginPaymentDate() {
		return beginPaymentDate;
	}

	public UsersAccount getUsersAccount() {
		return usersAccount;
	}

	public void setUsersAccount(UsersAccount usersAccount) {
		this.usersAccount = usersAccount;
	}

	public void setBeginPaymentDate(Date beginPaymentDate) {
		this.beginPaymentDate = beginPaymentDate;
	}

	public Date getEndPaymentDate() {
		return endPaymentDate;
	}

	public void setEndPaymentDate(Date endPaymentDate) {
		this.endPaymentDate = endPaymentDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getAmounts() {
		return amounts;
	}

	public void setAmounts(float amounts) {
		this.amounts = amounts;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public PaymentDetailBO getPaymentDetailBO() {
		return paymentDetailBO;
	}

	public void setPaymentDetailBO(PaymentDetailBO paymentDetailBO) {
		this.paymentDetailBO = paymentDetailBO;
	}

	public UsersBO getUsersBO() {
		return usersBO;
	}

	public void setUsersBO(UsersBO usersBO) {
		this.usersBO = usersBO;
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
			usersAccount = usersAccountBO.getAccountByUserId(user.getId());
			searchPaymentDetailUser();
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * searchPaymentDetailUser
	 */
	public void searchPaymentDetailUser() {
		try {
			paymentDetailList = new LazyDataModel<PaymentDetail>() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 4673403860583525423L;

				@Override
				public List<PaymentDetail> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					List<PaymentDetail> list = paymentDetailBO.searchPaymentDetailUser(beginPaymentDate, endPaymentDate,
							user.getId(), pageSize, first);
					return list;
				}
			};
			int count = paymentDetailBO.countPaymentDetailUser(beginPaymentDate, endPaymentDate, user.getId());
			paymentDetailList.setRowCount(count);
		} catch (Exception e) {
			log.debug(e);
		}
	}
}
