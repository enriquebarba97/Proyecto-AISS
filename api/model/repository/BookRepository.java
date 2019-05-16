package aiss.api.model.repository;

import java.util.Collection;

import aiss.api.model.Book;
import aiss.api.model.Review;


public interface BookRepository {

	//Reviews
	public void addReview(Review r);
	public Collection<Review> getAllReviews();
	public Review getReview(String id);
	public void updateReview(Review r);
	public void deleteReview(String id);
	
	//Books
	public void addBook(Book b);
	public Collection<Book> getAllBooks();
	public Book getBook(String isbn);
	public Collection<Book> getBooksAuthor(String author);
	public void updateBook(Book b);
	public void deleteBook(String isbn);
	public void deleteBooksPerAuthor(String author);
	public Collection<Review> getAll(String isbn);
	public void addReview(String isbn, String id);
	public void removeReview(String isbn, String author); 
	public Collection<Review>getReviewsPerTitle(String title);
	
}
