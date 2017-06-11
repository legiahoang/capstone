package vn.co.cex.bean.report;

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
import vn.co.cex.bo.ReportBO;
import vn.co.cex.orm.Report;
import vn.co.cex.orm.Users;
import vn.co.cex.utils.ConstantUtils;
import vn.co.cex.utils.SessionUtils;

@SuppressWarnings("restriction")
@ManagedBean(name = "reportBean", eager = true)
@ViewScoped
public class ReportBean extends BaseBean {

	private static final Logger log = LogManager.getLogger(ReportBean.class);

	@ManagedProperty(value = "#{reportBO}")
	private ReportBO reportBO;

	private LazyDataModel<Report> reportList;
	// private Report report;

	private String userName;
	private String fullName;
	private Date reportDateBegin;
	private Date reportDateEnd;
	private String reportTitle;
	private String reportContent;
	private String reportReply;
	private boolean status;

	@PostConstruct
	public void init() {

		try {
			Users u = SessionUtils.getUser();
			HttpServletRequest request = super.getHTTPRequest();
			HttpServletResponse response = super.getHTTPResponse();
			if (u == null) {
				response.sendRedirect(request.getContextPath() + "/xhtml/Users/Login.xhtml");
				return;

			} else if (u.getRole() == ConstantUtils.USER_ADMIN) {
				searchReportForAdmin();

			} else {
				searchReportForUser();
			}
		} catch (Exception e) {
			log.debug(e);
		}
	}

	public ReportBean() {

	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the reportContent
	 */
	public String getReportContent() {
		return reportContent;
	}

	/**
	 * @param reportContent
	 *            the reportContent to set
	 */
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	/**
	 * @return the reportReply
	 */
	public String getReportReply() {
		return reportReply;
	}

	/**
	 * @param reportReply
	 *            the reportReply to set
	 */
	public void setReportReply(String reportReply) {
		this.reportReply = reportReply;
	}

	public ReportBO getReportBO() {
		return reportBO;
	}

	public void setReportBO(ReportBO reportBO) {
		this.reportBO = reportBO;
	}

	public LazyDataModel<Report> getReportList() {
		return reportList;
	}

	public void setReportList(LazyDataModel<Report> reportList) {
		this.reportList = reportList;
	}

	public Date getReportDateBegin() {
		return reportDateBegin;
	}

	public void setReportDateBegin(Date reportDateBegin) {
		this.reportDateBegin = reportDateBegin;
	}

	public Date getReportDateEnd() {
		return reportDateEnd;
	}

	public void setReportDateEnd(Date reportDateEnd) {
		this.reportDateEnd = reportDateEnd;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * Search report by condition
	 */
	public void searchReportForAdmin() {
		try {
			reportList = new LazyDataModel<Report>() {
				@Override
				public List<Report> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					List<Report> list = reportBO.searchReportByAdmin(userName, reportDateBegin, reportDateEnd,
							reportTitle, reportReply, pageSize, first);
					return list;
				}
			};
			int count = reportBO.countReportByAdmin(userName, reportDateBegin, reportDateEnd, reportTitle, reportReply);
			reportList.setRowCount(count);
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * Search report by condition from user
	 */
	public void searchReportForUser() {

		Users u = SessionUtils.getUser();
		final int uid = u.getId();

		try {
			reportList = new LazyDataModel<Report>() {
				@Override
				public List<Report> load(int first, int pageSize, String sortField, SortOrder sortOrder,
						Map<String, Object> filters) {
					List<Report> list = reportBO.searchReportByUser(uid, reportDateBegin, reportDateEnd, reportTitle,
							status, pageSize, first);
					return list;
				}
			};
			int count = reportBO.countReportByUser(uid, reportDateBegin, reportDateEnd, reportTitle, status);
			reportList.setRowCount(count);
		} catch (Exception e) {
			log.debug(e);
		}
	}

	/**
	 * delete report
	 */
	public void deleteReport() {
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext extContext = context.getExternalContext();
			Map<String, String> params = extContext.getRequestParameterMap();
			String report_id = params.get("report_id");
			reportBO.deleteReport(Integer.parseInt(report_id));
		}
		catch (Exception e) {
			log.debug(e);
		}
	}
}
