package com.services;

import java.util.List;

import com.models.Game;

public interface GameService {

	List<Game> findAll(String coursename);

	Game findByName(String name);

	void add(Game game);

	void Edit(String gameName, String newDescription);

	void AddContributer(String teacherName, String gameName);

	void Cancel(String gameName);

	void UnCancel(String gameName);

	void Copy(String courseName, String gameName);
}
