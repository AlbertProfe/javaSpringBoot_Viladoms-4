package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.model.Author;
import com.example.library.model.User;

public interface AuthorRepository extends CrudRepository<Author,String> {

	void save(User author);

	void deleteByName(String lastname);

	long countByName(String lastname);

}