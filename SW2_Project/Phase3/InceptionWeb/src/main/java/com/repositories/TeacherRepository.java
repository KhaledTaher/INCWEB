package com.repositories;

import javax.transaction.Transactional;

import com.models.Teacher;

@Transactional
public interface TeacherRepository extends UserMainRepository<Teacher> {
}
