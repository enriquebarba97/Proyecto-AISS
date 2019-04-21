package aiss.model.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import aiss.model.reddit.Post;
import aiss.model.reddit.RedditModel;

public class RedditResourceTest {

	@Test
	public void testGetPostSearch() {
		String q = "Lord of the rings";
		RedditResource rs = new RedditResource();
		RedditModel<Post> search = rs.getPosts(q);
		
		assertNotNull("The search returned null", search);
		assertNotNull("The content of the search returned null", search.getData().getChildren());
		assertFalse("The content of the search is empty", search.getData().getChildren().size()==0);
		
		System.out.println("The search for " + q + "'s posts returned " + search.getData().getChildren().size() + " posts.");
	}
	

}
