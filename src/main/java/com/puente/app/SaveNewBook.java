package com.puente.app;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.puente.dao.PublishingService;
import com.puente.domain.Author;
import com.puente.domain.Book;
import com.puente.domain.Category;

public class SaveNewBook {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllBooks.class);
	
    public static void main(String[] args) {
    	//Create the bean factory and load the bean
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();
        
        //Instantiate the Data access object, by passing a bean for the PublishingDaoImp class.
        PublishingService pService = ctx.getBean("publishingService", PublishingService.class);
        
        //Create new Book
        Book newBook = new Book();
        newBook.setTitle("The Wheel of Time1");
        newBook.setPrice((float)30.99);
        newBook.setIsbn("9783661");
        
        //Create Category
        Category newCategory = new Category();
        newCategory.setId((long)2);
        newBook.setCategory(newCategory);//add Category to Book
        newCategory.getBook().add(newBook);
   
        //Create new Author
        Author newAuthor = new Author();
        newAuthor.setFrstName("Robert");//set author first name
        newAuthor.setLstName("Jordan");// set author last name
        newAuthor.setDescription("May he rest in peace"); // set author description
        newAuthor.setId(20L);
        newAuthor.addBook(newBook);
        newBook.addAuthor(newAuthor);
  
        pService.save(newBook); // add new book to DB
        List<Book> books = pService.FindAllBooksDetail();
        listBooksWithDetail(books);
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    
    //print all the books using logger
    private static void listBooksWithDetail(List<Book> books) {
	logger.info("");
	logger.info("Listing Books with details:");
	logger.info("---------------------------------");
	for (Book book: books) {
	    logger.info(book.toString());
	    if (book.getCategory() != null) {
			logger.info(book.getCategory().toString());
	        
	    }
	    
	    if (book.getAuthor() != null) {
	        for (Author hobby: book.getAuthor()) {
	           logger.info(hobby.toString());
	        }
             }
             logger.info("---------------------------------");
             
        }  
     }
}
