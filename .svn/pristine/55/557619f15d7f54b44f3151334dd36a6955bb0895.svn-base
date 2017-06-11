package vn.co.cex.bo;

import java.util.Date;
import java.util.List;

import vn.co.cex.dto.ReportDTO;
import vn.co.cex.orm.Report;

public interface ReportBO extends BaseBO {

	/**
	 * 
	 * @return
	 */
	List<Report> getAllReport();

	/**
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
	 * 
	 * @param parseInt
	 * @return
	 */
	ReportDTO getReportById(int parseInt);

	/**
	 * 
	 * @param updated
	 * @return
	 */
	public boolean updateReport(Report updated);

	/**
	 * search report for user
	 * 
	 * @param reportDateBegin
	 * @param reportDateEnd
	 * @param reportTitle
	 * @param status
	 * @return
	 */
	List<Report> searchReportByUser(int uid, Date reportDateBegin, Date reportDateEnd, String reportTitle,
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
	 * add new report from user
	 * 
	 * @param report
	 * @return
	 */
	public boolean addNewReport(Report report);

	/**
	 * get detail report by user id
	 * 
	 * @param id
	 * @return
	 */
	List<Report> getAllReportByUserId(int id);

	/**
	 * delete report
	 * 
	 * @param id
	 */
	void deleteReport(int report_id);
}
