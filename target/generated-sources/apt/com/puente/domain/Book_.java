package com.puente.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Float> price;
	public static volatile SetAttribute<Book, Author> author;
	public static volatile SingularAttribute<Book, String> isbn;
	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Category> category;
	public static volatile SingularAttribute<Book, Integer> version;

}

