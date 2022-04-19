package com.example.library.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


//POJO this class is used to create objects which i use to populate our array
@Entity
public class Book {

	@Id
	private String id;
	private String title;
	private String author;
	private int pages;
	private int year;
	private String ISBN;
	
	// toborrow, borrowed, lost, inbackoffice 
	private String status;
	//bestseller, oldbook, regularbook
	private String type; 
	

	
	@ManyToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Author> authors = new ArrayList<Author>();
	
	
	

	public Book() {
	}

	public Book(String id, String title, String author, int pages, int year, String ISBN) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.year = year;
		this.ISBN = ISBN;
	}

	// getter from Books List
	public List<Author> getAuthors() {
		return authors;
	}

	public void addAuthor(Author author) {
		this.authors.add(author);
		//author.addBook(this);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", pages=" + pages + ", year=" + year + ", ISBN=" + ISBN
				+  "]";
	}

}
