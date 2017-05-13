package com.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.models.Question;

public interface QuestionRepository extends CrudRepository<Question, String> {
	List<Question> findByGameGameName(String gamename);

}
