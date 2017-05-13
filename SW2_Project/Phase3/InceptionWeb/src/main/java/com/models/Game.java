package com.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Game implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 4637459274080499509L;

	@Id
	private String gameName;
	private String gameCourse;
	private String gameOwner;
	private String description;
	private int numberOfQuestions;
	private boolean isCancelled;

	@ManyToOne
	private Course course;

	@ManyToOne
	private Teacher teacher;

	@ManyToMany
	@JoinTable(name = "gameContributers", joinColumns = @JoinColumn(name = "gameName"), inverseJoinColumns = @JoinColumn(name = "username"))
	private List<Teacher> gameContributers;

	@OneToMany(mappedBy = "game")
	private List<Comment> gameComments;

	public List<Teacher> getGameContributers() {
		return gameContributers;
	}

	public void setGameContributers(List<Teacher> gameContributers) {
		this.gameContributers = gameContributers;
	}

	public List<Comment> getGameComments() {
		return gameComments;
	}

	public void setGameComments(List<Comment> gameComments) {
		this.gameComments = gameComments;
	}

	public Game() {
	}

	public Game(String gameName, String gameCourse, String gameOwner, String description, int numberOfQuestions) {
		super();
		this.gameName = gameName;
		this.gameCourse = gameCourse;
		this.gameOwner = gameOwner;
		this.description = description;
		this.numberOfQuestions = numberOfQuestions;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameCourse() {
		return gameCourse;
	}

	public void setGameCourse(String gameCourse) {
		this.gameCourse = gameCourse;
	}

	public String getGameOwner() {
		return gameOwner;
	}

	public void setGameOwner(String gameOwner) {
		this.gameOwner = gameOwner;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCancelled() {
		return isCancelled;
	}

	public void setCancelled(boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

}
