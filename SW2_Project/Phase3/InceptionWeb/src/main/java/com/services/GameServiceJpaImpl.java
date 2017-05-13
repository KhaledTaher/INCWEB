package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.models.Course;
import com.models.Game;
import com.models.Teacher;
import com.repositories.CourseRepository;
import com.repositories.GameRepository;
import com.repositories.TeacherRepository;

@Service
@Primary
public class GameServiceJpaImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private GameRepository GameRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<Game> findAll(String coursename) {
		List<Game> games = new ArrayList<>();
		GameRepository.findByCourseCourseName(coursename).forEach(games::add);
		return games;
	}

	@Override
	public Game findByName(String name) {
		return this.gameRepository.findOne(name);
	}

	@Override
	public void add(Game game) {
		this.gameRepository.save(game);

	}

	@Override
	public void Edit(String gameName, String newDescription) {
		Game game = this.gameRepository.findOne(gameName);
		game.setDescription(newDescription);
		this.gameRepository.save(game);

	}

	@Override
	public void AddContributer(String teacherName, String gameName) {
		Game game = this.gameRepository.findOne(gameName);
		Teacher teacher = this.teacherRepository.findByUsername(teacherName);
		List<Teacher> Cont = game.getGameContributers();
		Cont.add(teacher);
		this.gameRepository.save(game);
	}

	@Override
	public void Cancel(String gameName) {
		Game game = this.gameRepository.findOne(gameName);
		game.setCancelled(false);
		this.gameRepository.save(game);

	}

	@Override
	public void UnCancel(String gameName) {
		Game game = this.gameRepository.findOne(gameName);
		game.setCancelled(true);
		this.gameRepository.save(game);

	}

	@Override
	public void Copy(String courseName, String gameName) {
		Course course = courseRepository.findOne(courseName);
		String owner = course.getCourseOwner();
		Game original = gameRepository.findOne(gameName);
		Game copy = new Game(original.getGameName(), courseName, owner, original.getDescription(),
				original.getNumberOfQuestions());
		copy.setCourse(course);
		this.gameRepository.save(copy);

	}

}
