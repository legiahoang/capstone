package vn.co.cex.dao;

import java.util.List;

import vn.co.cex.dto.CommentDTO;
import vn.co.cex.orm.AnswerComment;
import vn.co.cex.orm.Comment;

public interface CommentDAO extends BaseDAO {

	/**
	 * Get comments
	 * 
	 * @param billOfLadingId
	 * @return
	 */
	List<CommentDTO> getComments(int billOfLadingId);

	/**
	 * Add new comment
	 * 
	 * @param comment
	 * @return
	 */
	boolean addNewComment(Comment comment);

	/**
	 * Add new answer comment
	 * 
	 * @param answerComment
	 * @return
	 */
	boolean addNewAnswerComment(AnswerComment answerComment);
}
