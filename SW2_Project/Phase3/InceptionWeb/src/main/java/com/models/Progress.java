package com.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "progress")
@IdClass(ProgressComposite.class)
public class Progress implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 2529646368199385913L;

	@Column(name = "score")
	private int score;

	@Id
	@ManyToOne
	@JoinColumn(name = "gameName")
	private Game game;

	@Id
	@ManyToOne
	@JoinColumn(name = "studentUsername")
	private Student student;

	public Progress(int score, Student s, Game g) {
		super();
		student = s;
		this.score = score;
		game = g;
	}

	Progress() {
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game gameinAch) {
		this.game = gameinAch;
	}

}