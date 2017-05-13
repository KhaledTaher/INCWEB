package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.models.Question;
import com.repositories.QuestionRepository;

@Service
@Primary
public class QuestionJpaImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> findAll(String gamename) {
		List<Question> questions = new ArrayList<>();
		questionRepository.findByGameGameName(gamename).forEach(questions::add);
		return questions;
	}

	@Override
	public Question findByName(String name) {
		return this.questionRepository.findOne(name);
	}

	@Override
	public void add(Question question) {
		this.questionRepository.save(question);

	}

}
