package com.models;

import java.io.Serializable;

public class ProgressComposite implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String student;
	private String game;

	public ProgressComposite() {

	}

	public ProgressComposite(String s, String g) {
		student = s;
		game = g;
	}

	public String getGame() {
		return game;
	}

	public String getStudent() {
		return student;
	}

}
