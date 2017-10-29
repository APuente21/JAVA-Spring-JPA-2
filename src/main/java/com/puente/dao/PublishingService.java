package com.puente.dao;


import java.util.List;

import com.puente.domain.Author;
import com.puente.domain.Book;
import com.puente.domain.Category;

/*Interface that specifies the methods that will be used to interact with the
 * database. PublishingDaoImp is the class that implements the interface.
 */
public interface PublishingService {
	List<Book> findAllBooks();
	List<Book> FindAllBooksDetail();
	Book findBookDetailsById(long id);
	Book save(Book book);
	void delete(Book book);
	List<Book> findBooksByAuthorCount(Long id);
	List<Author> findAuthorCount();
	List<Book> FindAllBooksNativeQuery();
}
