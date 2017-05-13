package com.services;

import com.models.Comment;

public interface CommentServiceJpaImpl {

	public void CreateComment(Comment c, String gname);
}
