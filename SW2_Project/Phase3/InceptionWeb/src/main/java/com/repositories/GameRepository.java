package com.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.models.Game;

public interface GameRepository extends CrudRepository<Game, String> {
	List<Game> findByCourseCourseName(String coursename);

}
