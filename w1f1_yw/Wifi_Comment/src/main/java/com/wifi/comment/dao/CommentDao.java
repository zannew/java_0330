package com.wifi.comment.dao;

import java.util.List;
import java.util.Map;

import com.wifi.comment.model.Comment;

public interface CommentDao {

	// 댓글 등록
	int insertComment(Comment comment);

	// 총 댓글 수
	int totalCountByiidx(Map<String, Object> search);

	// 해당 공구에 달린 댓글들
	List<Comment> selectCommentByiidx(Map<String, Object> search);

	// 댓글 삭제
	int deleteComment(int cidx);

	// 댓글 수정
	int editComment(Comment comment);

}
