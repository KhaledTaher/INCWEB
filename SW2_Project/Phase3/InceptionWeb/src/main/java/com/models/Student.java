package com.models;

import javax.persistence.Entity;

@Entity
public class Student extends IUser {

	/**
	 *
	 */
	private static final long serialVersionUID = -2017971558474362724L;

	public Student() {
		super();
	}

	public Student(String fullname, String gender, String email, String username, String password) {
		super(username, password, fullname, email, gender);
		setTeacher(false);
	}

}
