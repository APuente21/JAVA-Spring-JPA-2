package com.puente.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name="Author.FindAuthor", 
query="select a from Author a left join fetch a.book group by a.id having count(*) > 1"),
@NamedQuery(name="Author.FindBookByAuthor", 
query="select b from Book b left join fetch b.author a left join fetch b.category c where a.id = :id")
})
@Table(name = "AUTHOR")
public class Author implements Serializable{
	private long id;
	private String frstName;
	private String lstName;
	private String description;
	private Set<Book> book = new HashSet<Book>();
	
	public void setId(long id) {
		this.id = id;
	}
	
	@Id
	@Column(name = "ID")
	public long getId() {
		return this.id;
	}
		
	public void setFrstName(String fName) {
		this.frstName = fName;
	}
	
	@Column(name = "FIRST_NAME")
	public String getFrstName() {
		return this.frstName;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}
	
	public void setLstName(String lstName) {
		this.lstName = lstName;
	}
	
	@Column(name = "LAST_NAME")
	public String getLstName() {
		return this.lstName;
	}
	
	
	public void setBook(Set<Book> book)	{
		this.book = book;
	}
	
	@ManyToMany
	 @JoinTable(name = "author_book", 
     joinColumns = @JoinColumn(name = "AUTHOR_ID"),
     inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	public Set<Book> getBook(){
		return this.book;
	}
	
	public void addBook(Book book) {
		this.book.add(book);
	}
	
	public void removeBook(Book book) {
		this.book.remove(book);
	}
	
	public String toString() {
		return "Author -- ID: " + id + ", First Name: " + frstName + ", Last Name: " + lstName
				+ ", Description: " + description;
	}
}
