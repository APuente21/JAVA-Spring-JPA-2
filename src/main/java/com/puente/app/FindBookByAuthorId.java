package com.puente.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.puente.dao.PublishingService;
import com.puente.domain.Author;
import com.puente.domain.Book;

/*This method finds all authors who have written more than one book. It
 * then access the database to retrieve all of the books they have written 
 */


public class FindBookByAuthorId {
	private static Logger logger = LoggerFactory.getLogger(DeleteBook.class);
	
    public static void main(String[] args) {
    	
    	//Create bean factor and load bean
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        //create interface object
        PublishingService pService = ctx.getBean("publishingService", PublishingService.class);
        
        //get list of authors who wrote more than 1 book
        List<Author> authors = pService.findAuthorCount();
        
        //for each author, get id and retrieve all books in db that they wrote
        for (Author author: authors) {
        	long id = author.getId();
        	//get List of books with author ID = 3
            List<Book> book = pService.findBooksByAuthorCount(id);	
         	
            //Print all books, authors, categories from DB
            logger.info("Listing Books by author id: " + id);
            listBooksWithDetail(book);     
        }
    } 
    
    //print all the books using logger
    private static void listBooksWithDetail(List<Book> books) {
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
         logger.info("");
    	}  
     }
}

