package com.puente.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.puente.dao.PublishingService;
import com.puente.domain.Book;

/*
 * In this program I am querying the database for all the books, without including the author
 * or the category. 
 * */
public class FindAllBooksNativeQuery {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllBooksNativeQuery.class);
	
    public static void main(String[] args) {
    	//Create the bean factory and load the bean
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();
        
        //Instantiate the service object, by passing a bean for the PublishingServiceImp class.
        PublishingService pService = ctx.getBean("publishingService", PublishingService.class);
        //method queries the database and returns a list of all the books
        List<Book> books = pService.FindAllBooksNativeQuery();
        listBooks(books);
    }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
    
    //print all the books using logger
    private static void listBooks(List<Book> books) {
    	logger.info("");
    	logger.info("Listing book without details:");
    	for (Book book: books) {
    		logger.info(book.toString());
    		logger.info("");
    	}
    } 
}
