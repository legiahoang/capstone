package vn.co.cex.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Comment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3213591267522517111L;
	private Integer id;
	private String content;
	private int billOfLadingId;
	private BillOfLading billOfLading;
	private int createdUserId;
	private Users user;
	private Date created;
	
	private Set<AnswerComment> answerComment = new HashSet<AnswerComment>();

	public Comment() {

	}

	public Comment(int id) {
		this.id = id;
	}

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

	public BillOfLading getBillOfLading() {
		return billOfLading;
	}

	public void setBillOfLading(BillOfLading billOfLading) {
		this.billOfLading = billOfLading;
	}

	public int getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(int createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<AnswerComment> getAnswerComment() {
		return answerComment;
	}

	public void setAnswerComment(Set<AnswerComment> answerComment) {
		this.answerComment = answerComment;
	}
}
