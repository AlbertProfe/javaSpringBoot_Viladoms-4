package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.model.Borrow;


public interface BorrowRepository extends CrudRepository <Borrow, String>{

	void deleteById(String id);

}
