package vn.co.cex.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.co.cex.orm.AnswerComment;

public class CommentDTO extends BaseDTO {
	
	private Integer id;
	private String content;
	private int billOfLadingId;
	private int createdUserId;
	private String userFullName;
	private Date created;
	private List<AnswerComment> answerComment = new ArrayList<AnswerComment>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBillOfLadingId() {
		return billOfLadingId;
	}
	public void setBillOfLadingId(int billOfLadingId) {
		this.billOfLadingId = billOfLadingId;
	}
	public int getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(int createdUserId) {
		this.createdUserId = createdUserId;
	}
	
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public List<AnswerComment> getAnswerComment() {
		return answerComment;
	}
	public void setAnswerComment(List<AnswerComment> answerComment) {
		this.answerComment = answerComment;
	}
}
