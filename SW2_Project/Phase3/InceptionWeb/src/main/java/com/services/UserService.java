package com.services;

import java.util.List;

import com.models.IUser;

public interface UserService {
	List<IUser> findAll();

	IUser findByName(String name);

	IUser findbyNameAndPassword(String username, String password);

	IUser register(IUser u);

}
