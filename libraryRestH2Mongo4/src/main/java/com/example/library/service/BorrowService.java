package com.example.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Borrow;
import com.example.library.repository.BorrowRepository;

@Service
public class BorrowService {
	
	@Autowired
	BorrowRepository borrowRepository;

	// crud basic operations
	public Iterable<Borrow> findAll() {
		return borrowRepository.findAll();
	}

	public Borrow save(Borrow borrow) {
		borrowRepository.save(borrow);

		return borrow;
	}


	public void deleteById(String id) {

		// String response = "";

		borrowRepository.deleteById(id);

	}

	

}
