package aiss.model.resources;

import java.util.logging.*;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.reddit.Post;
import aiss.model.reddit.RedditModel;

public class RedditResource {
	private static final String uriBooks = "https://www.reddit.com/r/books/search.json";
	private static final Logger log = Logger.getLogger(RedditResource.class.getName());
	
	public RedditModel<Post> getPosts(String q) {
		String uri = uriBooks + "?q=" + q + "&limit=5&restrict_sr=true";
		log.log(Level.FINE, "Reddit search URI: " + uri);
		RedditModel<Post> result = null;
		ClientResource cr = new ClientResource(uri);
		
		try {
			result = cr.get(RedditModel.class);
		}catch (ResourceException e) {
			log.warning("Error retrieving posts from Reddit");
			log.warning(e.getMessage());
		}
		
		return result;
	}
}
