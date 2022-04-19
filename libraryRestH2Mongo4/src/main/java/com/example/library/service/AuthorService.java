package com.example.library.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;


@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;

	// crud basic operations
	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}

	public Author save(Author author) {
		
		
		authorRepository.save(author);

		return author;
	}

	public String findAndDeleteById(String id) {

		String response = "";
		Optional<Author> authorFound = authorRepository.findById(id);

		if (authorFound.isPresent()) {

			authorRepository.delete(authorFound.get());
			response += "author deleted";
		} else {

			response += "author not found";
		}

		return response;
	}

	public void deleteById(String id) {

		// String response = "";

		authorRepository.deleteById(id);

	}

	public String update(String id, Author author) {

		String response = "";
		Optional<Author> authorFound = authorRepository.findById(id);

		if (authorFound.isPresent()) {

			authorFound.get().setName(author.getName());
			authorRepository.save(authorFound.get());
			response += "author updated";

		} else {
			response += "author not found";
		}

		return response;

	}

	// other options
	public long count() {

		long quantity = authorRepository.count();

		return quantity;
	}

	public boolean existsById(String id) {

		boolean isAuthor = authorRepository.existsById(id);

		return isAuthor;
	}

	public Long countByLastname(String lastname) {

		long quantity = authorRepository.countByName(lastname);

		return quantity;
	}

	public void deleteByLastname(String lastname) {

		authorRepository.deleteByName(lastname);

	}


}
