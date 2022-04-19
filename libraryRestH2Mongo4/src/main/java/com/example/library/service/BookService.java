package com.example.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public Iterable<Book> findAll() {
		
		//System.out.println ("Books" + books);
		
		return bookRepository.findAll();
	}
	
	public void save(Book book) {
		
		bookRepository.save(book);
		
		
	}
	
	public String findAndDeleteById(String id) {

		String response = "";
		Optional<Book> bookFound = bookRepository.findById(id);

		if (bookFound.isPresent()) {

			bookRepository.delete(bookFound.get());
			response += "book deleted";
		} else {

			response += "book not found";
		}

		return response;
	}

	public void deleteById(String id) {

		// String response = "";

		bookRepository.deleteById(id);

	}

	public String update(String id, Book book) {

		String response = "";
		Optional<Book> bookFound = bookRepository.findById(id);

		if (bookFound.isPresent()) {

			bookFound.get().setTitle(book.getTitle());
			bookRepository.save(bookFound.get());
			response += "book updated";

		} else {
			response += "book not found";
		}

		return response;

	}

	// other options
	public long count() {

		long quantity = bookRepository.count();

		return quantity;
	}

	public boolean existsById(String id) {

		boolean isBook = bookRepository.existsById(id);

		return isBook;
	}

	public Long countByLastname(String author) {

		long quantity = bookRepository.countByAuthor(author);

		return quantity;
	}

	public void deleteByLastname(String author) {

		bookRepository.deleteByAuthor(author);

	}

}
