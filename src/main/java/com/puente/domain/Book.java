package com.puente.domain;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@NamedQueries({
	@NamedQuery(name="Book.findAll", query="select b from Book b"),
	@NamedQuery(name="Book.findBookDetailsById", 
		query="select distinct b from Book b left join fetch b.category c left join fetch b.author a where b.id = :id"),
	@NamedQuery(name="Book.FindAllBooksDetail", 
		query="select distinct b from Book b left join fetch b.category c left join fetch b.author a")
})
@Table(name = "BOOK")
public class Book {
	private Long id;
	private int version;
	private String isbn;
	private String title;
	private float price;
	private Category category; //part of a many to one relationship with categories
	private Set<Author> author = new HashSet<Author>();// part of a many to many relationship wtih authors
	
	//method that sets the ID for the BOOK. This is the primary key in the DB
	public void setId(Long id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY) 
    @Column(name = "ID")
	public Long getId() {
		return this.id;
	}
	
	@Version
    @Column(name = "VERSION")
    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Column(name = "ISBN")
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name = "TITLE")
	public String getTitle() {
		return this.title;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Column(name = "PRICE")
	public float getPrice() {
		return this.price;
	}
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	public Category getCategory() {
		return this.category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void setAuthor(Set<Author> author) {
		this.author = author;
	}
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "author_book", //indicates the join table name
	    joinColumns = @JoinColumn(name = "BOOK_ID"), //the column that is foreign key to Books
	    inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")) //defines the foreign key to the other side
	public Set<Author> getAuthor() {
	    return this.author;
	}
	
	public void addAuthor(Author author) {
		this.author.add(author);
	}
	
	public void removeAuthor(Author author) {
		this.author.remove(author);
	}
	
	public String toString() {
		return "Book - Id: " + id + " Category Id: "  + category.getId() + ", ISBN: " + isbn + ", Title: " + title + ", Price: " + price;
	}
}

