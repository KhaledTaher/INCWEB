package com.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Comment;
import com.models.Game;
import com.repositories.CommentRepository;
import com.repositories.GameRepository;

@Service
public class CommentService implements CommentServiceJpaImpl {

	@Autowired
	private GameRepository gameRepository;

	// @Autowired
	// private NotificationService notificationService;

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public void CreateComment(Comment comment, String gname) {
		Game game = gameRepository.findOne(gname);
		comment.setGame(game);
		comment.setDate(new Date().getTime());
		// notificationService.commentNotification(gameName);
		commentRepository.save(comment);
	}
}
