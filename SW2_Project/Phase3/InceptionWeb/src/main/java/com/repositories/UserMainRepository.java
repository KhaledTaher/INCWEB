package com.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.models.IUser;

@NoRepositoryBean
public interface UserMainRepository<T extends IUser> extends CrudRepository<T, String> {
	T findByEmail(String email);

	T findByUsername(String username);
}
