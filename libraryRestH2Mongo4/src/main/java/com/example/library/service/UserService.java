package com.example.library.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.User;
import com.example.library.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// crud basic operations
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public User save(User user) {
		userRepository.save(user);

		return user;
	}

	public String findAndDeleteById(String id) {

		String response = "";
		Optional<User> customerFound = userRepository.findById(id);

		if (customerFound.isPresent()) {

			userRepository.delete(customerFound.get());
			response += "customer deleted";
		} else {

			response += "customer not found";
		}

		return response;
	}

	public void deleteById(String id) {

		// String response = "";

		userRepository.deleteById(id);

	}

	public String update(String id, User user) {

		String response = "";
		Optional<User> customerFound = userRepository.findById(id);

		if (customerFound.isPresent()) {

			customerFound.get().setFirstName(user.getFirstName());
			userRepository.save(customerFound.get());
			response += "customer updated";

		} else {
			response += "customer not found";
		}

		return response;

	}

	// other options
	public long count() {

		long quantity = userRepository.count();

		return quantity;
	}

	public boolean existsById(String id) {

		boolean isCustomer = userRepository.existsById(id);

		return isCustomer;
	}

	public Long countByLastname(String lastname) {

		long quantity = userRepository.countByLastName(lastname);

		return quantity;
	}

	public void deleteByLastname(String lastname) {

		userRepository.deleteByLastName(lastname);

	}

	public Optional<User> findOneById(String id) {
		
		Optional<User> customerFound = userRepository.findById(id);
		
		return customerFound;
	}

}
