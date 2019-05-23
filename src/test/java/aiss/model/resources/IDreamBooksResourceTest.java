package aiss.model.resources;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import aiss.model.idreambooks.AcclaimedBook;
import aiss.model.idreambooks.BookReviews;

@Ignore
public class IDreamBooksResourceTest {

	@Test
	public void testGetReviews() {
		String query = "lord of the rings";
		IDreamBooksResource rs = new IDreamBooksResource();
		BookReviews reviews = rs.getReviews(query);
		
		assertNotNull("The search returned null", reviews);
		assertNotNull("The review object is null", reviews.getBook().getCriticReviews());
		
		System.out.println("The search for " + query +"'s reviews returned " + reviews.getBook().getReviewCount() + " reviews");
		
	}

	@Test
	public void testGetAcclaimedBooks() {
		String genre = "fantasy";
		IDreamBooksResource rs = new IDreamBooksResource();
		List<AcclaimedBook> books = rs.getAcclaimedBooks(genre);
		
		assertNotNull("The search returned null", books);
		assertFalse("The search is empty", books.size()==0);
		
		System.out.println("The search for " + genre + " books returned " + books.size() + " books");
	}

}
