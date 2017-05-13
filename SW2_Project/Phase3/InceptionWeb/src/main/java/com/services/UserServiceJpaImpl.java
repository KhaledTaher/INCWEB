package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.models.IUser;
import com.models.Student;
import com.models.Teacher;
import com.repositories.StudentRepository;
import com.repositories.TeacherRepository;
import com.repositories.UserRepository;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<IUser> findAll() {
		List<IUser> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public IUser findByName(String name) {
		return this.userRepository.findOne(name);
	}

	public boolean userExist(String username) {
		if (userRepository.findByUsername(username) == null)
			return false;
		return true;
	}

	public boolean mailExist(String email) {
		if (userRepository.findByEmail(email) == null)
			return false;
		return true;
	}

	@Override
	public IUser findbyNameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public void add(IUser u) {
		if (u.isTeacher()) {
			Teacher t = new Teacher(u.getFullName(), u.getGender(), u.getEmail(), u.getUsername(), u.getPassword());
			teacherRepository.save(t);
		} else {
			Student s = new Student(u.getFullName(), u.getGender(), u.getEmail(), u.getUsername(), u.getPassword());
			studentRepository.save(s);
		}
	}

	@Override
	public IUser register(IUser u) {
		if (!userExist(u.getUsername())) {
			if ((u.isTeacher() && !u.getEmail().contains(".edu")) || mailExist(u.getEmail()))
				return null;
			add(u);
			return u;
		}
		return null;
	}

}
