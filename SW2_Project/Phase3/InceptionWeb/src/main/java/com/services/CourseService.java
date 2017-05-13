package com.services;

import com.models.Course;
import com.models.Game;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findByName(String name);
	void add(Course course);
}
