package vn.co.cex.dto;

import java.util.Date;

import vn.co.cex.orm.Comment;

public class AnswerCommentDTO {

	private Integer id;
	private String content;
	private int commentId;
	private Comment comment;
	private int createdUserId;
	private String userFullName;
	private Date created;
	
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
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
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
}
