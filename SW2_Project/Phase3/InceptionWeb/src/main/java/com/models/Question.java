package com.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Question implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -4948676550321534494L;

	@Id
	private String label;

	private String one;
	private String two;
	private String three;
	private String rightAnswer;

	@ManyToOne
	Game game;

	public Question() {
	}

	public Question(String label, String one, String two, String three, String rightAnswer, String gamename) {
		super();
		this.label = label;
		this.one = one;
		this.two = two;
		this.three = three;
		this.rightAnswer = rightAnswer;
		this.game = new Game(gamename, "", "", "", 0);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isRight(String answer) {
		return (answer.equalsIgnoreCase(rightAnswer));
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getOne() {
		return one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public String toString() {
		return "Question [label=" + label + ", one=" + one + ", two=" + two + ", three=" + three + ", rightAnswer="
				+ rightAnswer + "]";
	}

}
