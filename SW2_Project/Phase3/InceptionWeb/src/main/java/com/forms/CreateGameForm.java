package com.forms;

public class CreateGameForm {

	private String gamename;
	private String gamecourse;
	private String description;
	private int questions;

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public int getQuestions() {
		return questions;
	}

	public void setQuestions(int questions) {
		this.questions = questions;
	}

	public String getGamecourse() {
		return gamecourse;
	}

	public void setGamecourse(String gamecourse) {
		this.gamecourse = gamecourse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
