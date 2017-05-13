package com.repositories;

import javax.transaction.Transactional;

import com.models.IUser;

@Transactional
public interface UserRepository extends UserMainRepository<IUser> {

	IUser findByUsernameAndPassword(String username, String password);
}
