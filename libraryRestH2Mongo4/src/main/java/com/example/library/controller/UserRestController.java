package com.example.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.User;
import com.example.library.service.UserService;

@RestController
@RequestMapping("api")
public class UserRestController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("users")
	public ResponseEntity<Iterable<User>> getAllUsers() {
		
		var headers = new HttpHeaders();
		headers.add("ResponseGet", "findAll users executed");
		headers.add("version", "1.0 Api Rest User Object");
		
		return ResponseEntity.accepted().headers(headers).body(userservice.findAll());
	}
	
	@PostMapping(path = "/addUser", consumes = "application/json" )
	public ResponseEntity<User> createUser( @RequestBody User user) {
		
		System.out.println("user" + user);
	
		User userSaved = userservice.save(user);
		
		var headers = new HttpHeaders();
		headers.add("ResponseCreate", "save User executed");
		headers.add("version", "1.0 Api Rest User Object");
		headers.add("Executed Output", "user created");
		
		return ResponseEntity.accepted().headers(headers).body(userSaved);
		
	}
	
	@DeleteMapping ("/deleteUser/{id}")
	public ResponseEntity<User> deleteBook  (@PathVariable String id ) {
		
		Optional<User> usertodelete = userservice.findOneById(id);
		String responsedelete = userservice.findAndDeleteById(id);

		var headers = new HttpHeaders();
		headers.add("ResponseDeleted", "deleteBook executed");
		headers.add("version", "1.0 Api Rest Book Object");
		headers.add("Executed Output", responsedelete);
		
		return ResponseEntity.accepted().headers(headers).body(usertodelete.get());
	}
	
	@PostMapping("/replaceUser/{id}")
	public ResponseEntity<User> updateUser (@PathVariable String id, @RequestBody User userFromRest ) {
		
		String responseUpdate = "";
		Optional<User> usertoUpdate = userservice.findOneById(id);
		User userToUpdate =null;
		
		if ( usertoUpdate.isPresent() ) {
		
			userToUpdate = usertoUpdate.get();
			
			//we are going to compare both books: 
			//bookFromRest vs bookToUpdate
			//we need to compare each field of our object
			responseUpdate += "book found";
			boolean updated = false;
			
			if  (userFromRest.getFirstName() != null) {
				responseUpdate += " - user name value updated: " + userFromRest.getFirstName() +  "( old value: " + userToUpdate.getFirstName() + ")" ;
				userToUpdate.setFirstName(userFromRest.getFirstName());
				updated = true;
			}
			if  (userFromRest.getLastName() != null) {
				responseUpdate += " - user surname value updated: " + userFromRest.getLastName() +  "( old value: " + userToUpdate.getLastName() + ")" ;
				userToUpdate.setLastName(userFromRest.getLastName());
				updated = true;
			}
			if  (userFromRest.getYear() != 0) {
				responseUpdate += " - year int value updated: " + userFromRest.getYear() +  "( old value: " + userToUpdate.getYear() + ")" ;
				userToUpdate.setYear(userFromRest.getYear());
				updated = true;
			}
			
		
			if (!updated) responseUpdate += " - try to update but any field updated - something wrong happened";
			else userservice.save (userToUpdate);
		
		} else {
			
			responseUpdate = responseUpdate + "user not found";}
		
		var headers = new HttpHeaders();
		headers.add("ResponseUpdate", "updateUser executed");
		headers.add("version", "1.0 Api Rest User Object");
		headers.add("Executed Output", responseUpdate);
		
		return ResponseEntity.accepted().headers(headers).body(userToUpdate);	
	}
	

}
