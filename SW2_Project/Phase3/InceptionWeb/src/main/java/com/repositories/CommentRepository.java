package com.repositories;

import org.springframework.data.repository.CrudRepository;

import com.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
