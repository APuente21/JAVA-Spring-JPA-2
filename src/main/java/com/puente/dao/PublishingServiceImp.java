package com.puente.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.puente.domain.Author;
import com.puente.domain.Book;
import com.puente.domain.Book_;
import com.puente.domain.Author_;
import com.puente.domain.Category_;


@Service("publishingService")
@Transactional 
@Repository
public class PublishingServiceImp implements PublishingService {
	private static Logger logger = LoggerFactory.getLogger(PublishingServiceImp.class);
	final static String ALL_CONTACT_NATIVE_QUERY =
	        "select * from book";
	
    @PersistenceContext
    private EntityManager em; 
    
    /*Method returns a list of all the books in the dabase
     * */
    @Transactional(readOnly=true)
    public List<Book> findAllBooks() {
        List<Book> books = em.createNamedQuery("Book.findAll",     
            Book.class).getResultList();
        return books;
    }

    /*
     * Method uses the FindAllBooksDetail query, which is located in the Book class, to retrieve
     * all books in the database. It also instantiates all authors and categories, that pertain
     * to each book
     */
    @Transactional(readOnly=true)
    public List<Book> FindAllBooksDetail() {
        List<Book> books = em.createNamedQuery(
            "Book.FindAllBooksDetail", Book.class).getResultList();
        return books;
    }
    
    @Transactional(readOnly=true)
    public Book findBookDetailsById(long id) {
    	//Create criteria builder instance
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = cb.createQuery(Book.class);
        //Query root forms the basis of the path expression
        Root<Book> bookRoot = criteriaQuery.from(Book.class);
        
        //enforces eager fetching of the associations
        bookRoot.fetch(Book_.category, JoinType.LEFT);
        bookRoot.fetch(Book_.author, JoinType.LEFT);
        
        //pass the root querry to the select
        criteriaQuery.select(bookRoot);
        
        //create predicates
        Predicate criteria = cb.conjunction();
        Predicate p = cb.equal(bookRoot.get(Book_.id),id);
        criteria = cb.and(criteria, p);
        criteriaQuery.where(criteria);

        return em.createQuery(criteriaQuery).getSingleResult();
    }

    
    
    //Method takes in a Book and adds it to the DB
    public Book save(Book book) {
        if (book.getId() == null) {
            logger.info("Inserting new book");
            em.persist(book);
        } else {
            em.merge(book);
            logger.info("Updating existing book");
        }

        logger.info("Book saved with id: " + book.getId());

        return book;
    }
    
    //method deletes a book from the DB
    public void delete(Book book) {
    	Book mergeBook = em.merge(book);
    	mergeBook.getCategory().getBook().remove(mergeBook);
    	mergeBook.getAuthor().iterator().next().getBook().remove(mergeBook);
    	if (!em.contains(mergeBook))
    		mergeBook = em.merge(mergeBook);
    	
    	em.remove(mergeBook);
        logger.info("Book deleted with id: " + book.getId());   
    }
    
    /*
     * Method uses the FindBookByAuthor SQL query located in the Author class to retrieve
     * all the books written by a certain author, specified by author id
     */
    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    public List<Book> findBooksByAuthorCount(Long id){
    	List<Book> book =  (List<Book>) em.createNamedQuery(
                "Author.FindBookByAuthor").
                setParameter("id", id).getResultList();
    	return book;
    }
    
    /*
     * Method uses the FindAuthor SQL query, specified in the Author class, to retrieve
     * all authors who have written more than one book in the database.
     */
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    public List<Author> findAuthorCount(){
    	return em.createNamedQuery(
                "Author.FindAuthor", Author.class).getResultList();
    }
    
    @Transactional(readOnly=true)
    public List<Book> FindAllBooksNativeQuery(){
    	return em.createNativeQuery(ALL_CONTACT_NATIVE_QUERY, 
        		Book.class).getResultList();
    }
}
