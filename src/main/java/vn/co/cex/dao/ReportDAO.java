package vn.co.cex.dao;

import java.util.Date;
import java.util.List;

import vn.co.cex.dto.ReportDTO;
import vn.co.cex.orm.Report;

public interface ReportDAO extends BaseDAO {

	/**
	 * Get all report
	 * 
	 * @return
	 */
	public List<Report> getAllReport();

	/**
	 * Search report
	 * 
	 * @param id
	 * @param userId
	 * @param userName
	 * @param reportDateBegin
	 * @param reportDateEnd
	 * @param reportTitle
	 * @param reportQuestion
	 * @param reportSolution
	 * @param reportContent
	 * @param reportReply
	 * @param status
	 * @return
	 */
	public List<Report> searchReportByAdmin(String userName, Date reportDateBegin, Date reportDateEnd,
			String reportTitle, String reportReply, int pageSize, int pageIndex);

	/**
	 * Count report
	 * 
	 * @param userName
	 * @param reportDateBegin
	 * @param reportDateEnd
	 * @param reportTitle
	 * @param reportReply
	 * @return
	 */
	public int countReportByAdmin(String userName, Date reportDateBegin, Date reportDateEnd, String reportTitle,
			String reportReply);

	/**
	 * Get report
	 * 
	 * @param id
	 * @return
	 */
	public ReportDTO getReportById(int id);

	/**
	 * Update report
	 * 
	 * @param data
	 * @return
	 */
	public boolean updateReport(Report data);

	/**
	 * Search report by user
	 * 
	 * @param uid
	 * @param reportDateBegin
	 * @param reportDateEnd
	 * @param reportTitle
	 * @param status
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	public List<Report> searchReportByUser(int uid, Date reportDateBegin, Date reportDateEnd, String reportTitle,
			boolean status, int pageSize, int pageIndex);

	/**
	 * Count report by user
	 * 
	 * @param reportDateBegin
	 * @param reportDateEnd
	 * @param reportTitle
	 * @param status
	 * @return
	 */
	public int countReportByUser(int uid, Date reportDateBegin, Date reportDateEnd, String reportTitle, boolean status);

	/**
	 * Add new report
	 * 
	 * @param report
	 * @return
	 */
	public boolean addNewReport(Report report);

	/**
	 * Get all report by user id
	 * 
	 * @param id
	 * @return
	 */
	public List<Report> getAllReportByUserId(int id);

	/**
	 * delete report
	 * 
	 * @param id
	 */
	public void deleteReport(int report_id);
}
