package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	long countByLastName(String lastname);

	void deleteByLastName(String lastname);

	

}
