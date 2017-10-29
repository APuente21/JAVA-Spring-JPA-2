package com.puente.app;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.puente.dao.PublishingService;
import com.puente.domain.Author;
import com.puente.domain.Book;


public class DeleteBook {
	private static Logger logger = LoggerFactory.getLogger(DeleteBook.class);
			
    public static void main(String[] args) {
    	
    	//Create bean factor and load bean
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        //create interface object
        PublishingService pService = ctx.getBean("publishingService", PublishingService.class);
        
        //Get book with ID 8
        Book book = pService.findBookDetailsById(8L);
        //Delete book from DB
        pService.delete(book);
        List<Book> books = pService.FindAllBooksDetail();	
     	
        //Print all books, authors, categories from DB
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