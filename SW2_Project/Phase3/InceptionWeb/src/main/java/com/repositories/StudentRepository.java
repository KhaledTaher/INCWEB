package com.repositories;

import javax.transaction.Transactional;

import com.models.Student;

@Transactional
public interface StudentRepository extends UserMainRepository<Student> {
}
