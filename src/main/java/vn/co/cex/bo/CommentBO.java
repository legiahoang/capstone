package vn.co.cex.bo;

import java.util.List;

import vn.co.cex.dto.CommentDTO;
import vn.co.cex.orm.AnswerComment;
import vn.co.cex.orm.Comment;

public interface CommentBO extends BaseBO {
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
	 * add new answer comment
	 * 
	 * @param answerComment
	 * @return
	 */
	boolean addNewAnswerComment(AnswerComment answerComment);
}
