package vn.co.cex.dto;

import java.util.Date;

import vn.co.cex.orm.Report;

public class ReportDTO {
	private int Id;
	private int userId;
	private String UserName;
	private String FullName;
	private Date reportDate;
	private String reportTitle;
	private String reportQuestion;
	private String reportSolution;
	private String reportContent;
	private String reportReply;
	private boolean status;
	
	
	/**
	 * @return the reportContent
	 */
	public String getReportContent() {
		return reportContent;
	}
	/**
	 * @param reportContent the reportContent to set
	 */
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return FullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the reportDate
	 */
	public Date getReportDate() {
		return reportDate;
	}
	/**
	 * @param reportDate the reportDate to set
	 */
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	/**
	 * @return the reportTitle
	 */
	public String getReportTitle() {
		return reportTitle;
	}
	/**
	 * @param reportTitle the reportTitle to set
	 */
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	/**
	 * @return the reportQuestion
	 */
	public String getReportQuestion() {
		return reportQuestion;
	}
	/**
	 * @param reportQuestion the reportQuestion to set
	 */
	public void setReportQuestion(String reportQuestion) {
		this.reportQuestion = reportQuestion;
	}
	/**
	 * @return the reportSolution
	 */
	public String getReportSolution() {
		return reportSolution;
	}
	/**
	 * @param reportSolution the reportSolution to set
	 */
	public void setReportSolution(String reportSolution) {
		this.reportSolution = reportSolution;
	}
	/**
	 * @return the reportReply
	 */
	public String getReportReply() {
		return reportReply;
	}
	/**
	 * @param reportReply the reportReply to set
	 */
	public void setReportReply(String reportReply) {
		this.reportReply = reportReply;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Report toReport() {
		Report result = new Report();
		result.setId(Id);
		result.setUserId(userId);
		result.setReportDate(reportDate);
		result.setReportTitle(reportTitle);
		result.setReportQuestion(reportQuestion);
		result.setReportSolution(reportSolution);
		result.setReportContent(reportContent);
		result.setReportReply(reportReply);
		result.setStatus(status);
		
		return result;
		
	}
	public Report toNewReport() {
		Report result = new Report();
		@SuppressWarnings("unused")
		Date dateFormat;
		result.setId(Id);
		result.setUserId(userId);
		result.setReportDate(reportDate);
		result.setReportTitle(reportTitle);
		result.setReportQuestion(reportQuestion);
		result.setReportSolution(reportSolution);
		result.setReportContent(reportContent);
		result.setReportReply(reportReply);
		result.setStatus(true);
		
		return result;
	}
	
}
