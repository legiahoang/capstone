package vn.co.cex.bo.impl;

import java.util.Date;
import java.util.List;

import vn.co.cex.bo.ReportBO;
import vn.co.cex.dto.ReportDTO;
import vn.co.cex.orm.Report;

public class ReportBOImpl extends BaseBOImpl implements ReportBO {

	/**
	 * get all report
	 */
	public List<Report> getAllReport() {
		return reportDAO.getAllReport();
	}

	/**
	 * search report for admin
	 */
	public List<Report> searchReportByAdmin(String userName, Date reportDateBegin, Date reportDateEnd,
			String reportTitle, String reportReply, int pageSize, int pageIndex) {
		return reportDAO.searchReportByAdmin(userName, reportDateBegin, reportDateEnd, reportTitle, reportReply,
				pageSize, pageIndex);
	}

	/**
	 *
	 */
	public int countReportByAdmin(String userName, Date reportDateBegin, Date reportDateEnd, String reportTitle,
			String reportReply) {
		return reportDAO.countReportByAdmin(userName, reportDateBegin, reportDateEnd, reportTitle, reportReply);
	}

	/**
	 * get detail report by id
	 */
	public ReportDTO getReportById(int id) {
		return reportDAO.getReportById(id);
	}

	/**
	 * update
	 */
	public boolean updateReport(Report data) {
		return reportDAO.updateReport(data);
	}

	/**
	 * Search report for user
	 */
	public List<Report> searchReportByUser(int id, Date reportDateBegin, Date reportDateEnd, String reportTitle,
			boolean status, int pageSize, int pageIndex) {
		return reportDAO.searchReportByUser(id, reportDateBegin, reportDateEnd, reportTitle, status, pageSize,
				pageIndex);
	}

	/**
	 * Count report by user
	 */
	public int countReportByUser(int uid, Date reportDateBegin, Date reportDateEnd, String reportTitle,
			boolean status) {
		return reportDAO.countReportByUser(uid, reportDateBegin, reportDateEnd, reportTitle, status);
	}

	/**
	 * add new report from user
	 */
	public boolean addNewReport(Report report) {
		return reportDAO.addNewReport(report);
	}

	/**
	 * get all report for user
	 */
	public List<Report> getAllReportByUserId(int id) {
		return reportDAO.getAllReportByUserId(id);
	}

	/**
	 * delete report
	 */
	public void deleteReport(int report_id) {
		reportDAO.deleteReport(report_id);
	}

}
