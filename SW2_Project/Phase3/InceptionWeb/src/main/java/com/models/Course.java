package com.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 8342285309593273058L;

	@Id
	private String courseName;

	private String courseOwner;

	public Course() {
	}

	public Course(String c) {
		courseName = c;
	}

	public String getCourseOwner() {
		return courseOwner;
	}

	public void setCourseOwner(String courseOwner) {
		this.courseOwner = courseOwner;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}