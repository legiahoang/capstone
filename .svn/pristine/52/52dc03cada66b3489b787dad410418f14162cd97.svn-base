package vn.co.cex.bo.impl;

import java.util.List;

import vn.co.cex.bo.CommentBO;
import vn.co.cex.dto.CommentDTO;
import vn.co.cex.orm.AnswerComment;
import vn.co.cex.orm.Comment;

public class CommentBOImpl extends BaseBOImpl implements CommentBO {

	/**
	 * Get comments
	 */
	public List<CommentDTO> getComments(int billOfLadingId) {

		return commentDAO.getComments(billOfLadingId);
	}

	/**
	 * Add new comment
	 */
	public boolean addNewComment(Comment comment) {
		
		return commentDAO.addNewComment(comment);
	}

	public boolean addNewAnswerComment(AnswerComment answerComment){
		return commentDAO.addNewAnswerComment(answerComment);
	}
}
