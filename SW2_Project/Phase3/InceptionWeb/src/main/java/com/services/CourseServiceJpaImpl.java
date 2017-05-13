package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.models.Course;
import com.repositories.CourseRepository;

@Service
@Primary
public class CourseServiceJpaImpl implements CourseService {

	@Autowired 
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		List <Course> courses = new ArrayList<>();
		courseRepository.findAll().forEach(courses::add);
		return courses;
	}

	@Override
	public Course findByName(String name) {
		 return this.courseRepository.findOne(name);
	}


	@Override
	public void add(Course course) {
		this.courseRepository.save(course);
		
	}

}
