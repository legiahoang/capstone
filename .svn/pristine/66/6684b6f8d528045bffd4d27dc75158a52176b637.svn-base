package vn.co.cex.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.transaction.annotation.Transactional;

import vn.co.cex.dao.CommentDAO;
import vn.co.cex.dto.AnswerCommentDTO;
import vn.co.cex.dto.CommentDTO;
import vn.co.cex.orm.AnswerComment;
import vn.co.cex.orm.BillOfLading;
import vn.co.cex.orm.Comment;
import vn.co.cex.orm.Users;

public class CommentDAOImpl extends BaseDAOImpl implements CommentDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4584503446622277241L;
	private static final Logger log = LogManager.getLogger(CommentDAOImpl.class);

	/**
	 * Get comments
	 */
	@Transactional
	public List<CommentDTO> getComments(int billOfLadingId) {
		List<CommentDTO> result = new ArrayList<CommentDTO>();
		try {
			Session session = getSessionFactory().getCurrentSession();

			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append(" SELECT u.FullName as 'userFullName', c.* FROM comment c ");
			sqlQuery.append(" JOIN users u ON c.createdUserId = u.id WHERE c.billOfLadingId  = ? ");
			sqlQuery.append(" ORDER BY c.Created ");
			SQLQuery queryData = session.createSQLQuery(sqlQuery.toString());
			queryData.setParameter(0, billOfLadingId);
			queryData.setResultTransformer(new AliasToBeanResultTransformer(CommentDTO.class));
			result = queryData.list();
			for (CommentDTO commentDTO : result) {
				sqlQuery = new StringBuilder(" SELECT u.FullName as 'userFullName', ac.* FROM answercomment ac ");
				sqlQuery.append(" JOIN users u ON ac.createdUserId = u.id WHERE ac.commentId  = ? ");
				sqlQuery.append(" ORDER BY ac.Created ");
				queryData = session.createSQLQuery(sqlQuery.toString());
				queryData.setParameter(0, commentDTO.getId());
				queryData.setResultTransformer(new AliasToBeanResultTransformer(AnswerCommentDTO.class));
				List<AnswerComment> tmp = queryData.list();
				commentDTO.setAnswerComment(tmp);
			}
		} catch (Exception e) {
			log.debug(e);
		}
		return result;
	}

	/**
	 * Add new comment
	 */
	public boolean addNewComment(Comment comment) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			comment.setBillOfLading(new BillOfLading(comment.getBillOfLadingId()));
			comment.setUser(new Users(comment.getCreatedUserId()));
			comment.setCreated(new Date());
			session.save(comment);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}

	/**
	 * Add new answer comment
	 */
	public boolean addNewAnswerComment(AnswerComment answerComment) {
		try {
			Session session = getSessionFactory().getCurrentSession();
			answerComment.setComment(new Comment(answerComment.getCommentId()));
			answerComment.setUser(new Users(answerComment.getCreatedUserId()));
			answerComment.setCreated(new Date());
			session.save(answerComment);
			return true;
		} catch (Exception e) {
			log.debug(e);
		}
		return false;
	}
}
