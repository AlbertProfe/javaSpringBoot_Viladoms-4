package com.example.library.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Optional;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.library.model.UserImages;
import com.example.library.repository.UserImagesRepository;

@RestController
@RequestMapping("/apiImages")
public class UserImagesController { 
	
	@Autowired
	UserImagesRepository userImagesRepository;
	
	@PostMapping("/createUserImage")
	public UserImages createUserImages (@RequestParam String name, @RequestParam MultipartFile file) throws IOException  {
		
		UserImages userImages  = new UserImages();
		userImages.setName(name);
		userImages.setImage( new Binary(file.getBytes() ));
		
		userImagesRepository.save(userImages); 
		
		return userImages;
	}

	@GetMapping("/getUserImagesData")
	public String getUserImagesData (@RequestParam String id) {
		
		System.out.println("id..." + id);
		Optional<UserImages> userImage = userImagesRepository.findById(id);
		Encoder encoder = Base64.getEncoder();
		
		return encoder.encodeToString( userImage.get().getImage().getData() );
	}
	
	@GetMapping("/getUserImage")
		public ResponseEntity<byte[]> getEmployeeImage (@RequestParam String id) {
			
			Optional<UserImages> userImage = userImagesRepository.findById(id);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			
			return new ResponseEntity<>( userImage.get().getImage().getData(), headers, HttpStatus.OK );
	}	
}


