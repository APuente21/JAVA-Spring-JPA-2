package com.puente.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.puente.dao.PublishingService;
import com.puente.domain.Author;
import com.puente.domain.Book;


public class FindBookDeatilsById {
	private static Logger logger = LoggerFactory.getLogger(
			FindBookDeatilsById.class);
			
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context-annotation.xml");
        ctx.refresh();

        PublishingService pService = ctx.getBean("publishingService", PublishingService.class);
        long id = 3;
        
        //get Book from DB by using JPA criteria query
        Book book = pService.findBookDetailsById(id);
        
        //Print book, category, and author(s)
        logger.info("Find Book by ID = " + id);
        logger.info("--------------------------");
        logger.info(book.toString());
        logger.info(book.getCategory().toString());
        for (Author author: book.getAuthor()) {
        	logger.info(author.toString());
        }
    } 
}
