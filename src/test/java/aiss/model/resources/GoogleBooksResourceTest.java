package aiss.model.resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.googlebooks.BookSearch;

public class GoogleBooksResourceTest {

	@Test
	public void testGetBooks() throws UnsupportedEncodingException{
		String title = "Lord of the Rings";
		GoogleBooksResource rs = new GoogleBooksResource();
		BookSearch result = rs.getBooks(title);
		
		assertNotNull("The search returned null", result);
		assertNotNull("The search returned null", result.getItems());
		assertFalse("The number of books of " + title + " is zero", result.getItems().size()==0);
		
		System.out.println("The search for " + title + "'s books returned " + result.getItems().size() + " books.");
	}

}
