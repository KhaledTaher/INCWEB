package com.repositories;

import org.springframework.data.repository.CrudRepository;

import com.models.Course;
import com.services.CourseService;;
public interface CourseRepository extends CrudRepository<Course ,String> {

}
