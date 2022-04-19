package com.example.library.model;


import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserImages {
	
	@Id
	private String id;
	private String name;
	private Binary image;
	
	public UserImages() {}

	public UserImages(String id, String name, Binary image) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Binary getImage() {
		return image;
	}
	public void setImage(Binary image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "UserImages [id=" + id + ", name=" + name + ", image=" + image + "]";
		}
		
}


