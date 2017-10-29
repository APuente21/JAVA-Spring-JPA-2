package com.puente.domain;

import java.util.HashSet;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//use annotation to specify that this class is mapped to the CATEGORY table in the DB
@Entity

@Table(name = "CATEGORY")
public class Category {
	private String name;
	private Long id;
	private Set<Book> book = new HashSet<Book>();
	
	public void setName(String name) {
		this.name=name;
	}
	
	//Annotation @Column means that we are references the column NAME in the table, in the DB
	 @Column(name= "NAME")
	 public String getName() {
		 return this.name;
	 }
	
	public void setId(Long id) {
		this.id = id;
	}
	 
	 @Id
	 @GeneratedValue(strategy = IDENTITY) 
	 @Column(name ="ID")
	 public Long getId() {
		 return this.id;
	 }
	  
	 @OneToMany(mappedBy = "category", cascade=CascadeType.ALL,
			 orphanRemoval= true)
	 public Set<Book> getBook(){
		 return this.book;
	 }
	 
	 public void setBook(Set<Book> book) {
		 this.book = book;
	 }
	 
	 public void addBook(Book book) {
		 book.setCategory(this);
		 getBook().add(book);
	 }
	 
	 public void removeBookFromSet(Book book) {
		 getBook().remove(book);
	 }
	 
	 public String toString() {
		 return "Category -- ID: " + this.id + ", Name: " + this.name + " " ;
	 }	 
}
