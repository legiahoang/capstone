package vn.co.cex.orm;

import java.util.Date;

public class Report implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6345803177275117903L;
	private int id;
	private int userId;
	private Users user;
	private Date reportDate;
	private String reportTitle;
	private String reportQuestion;
	private String reportSolution;
	private String reportContent;
	private String reportReply;
	private boolean status;
	
	public Report() {
		
	}
	
	public Report(int id, int userId, Date reportDate,
			String reportTitle, String reportQuestion, 
			String reportSolution, String reportContent, String reportReply, boolean status) {
		super();
		this.id=id;
		this.userId = userId;
		this.reportDate = reportDate;
		this.reportTitle = reportTitle;
		this.reportQuestion = reportQuestion;
		this.reportSolution = reportSolution;
		this.reportContent = reportContent;
		this.reportReply = reportReply;
		this.status = status;
	}

	public Report(int userId, Date reportDate,
			String reportTitle, String reportQuestion, 
			String reportSolution, String reportContent, boolean status) {
		super();
		this.userId = userId;
		this.reportDate = reportDate;
		this.reportTitle = reportTitle;
		this.reportQuestion = reportQuestion;
		this.reportSolution = reportSolution;
		this.reportContent = reportContent;
		this.status = status;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
}
