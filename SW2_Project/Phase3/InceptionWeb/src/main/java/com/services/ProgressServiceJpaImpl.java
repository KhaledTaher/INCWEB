package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Progress;
import com.repositories.GameRepository;
import com.repositories.ProgressRepository;
import com.repositories.StudentRepository;

@Service
public class ProgressServiceJpaImpl implements ProgressService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ProgressRepository progressRepository;

	@Autowired
	private GameRepository gameRepository;

	@Override
	public void addProgress(int score, String username, String gameName) {
		Progress prog = new Progress(score, studentRepository.findByUsername(username),
				gameRepository.findOne(gameName));
		progressRepository.save(prog);
	}

	@Override
	public List<Progress> showProgress(String username) {
		return progressRepository.findByStudentUsername(username);
	}

}
