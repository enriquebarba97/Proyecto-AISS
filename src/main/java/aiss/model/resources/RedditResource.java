package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.*;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.reddit.Post;
import aiss.model.reddit.RedditModel;

public class RedditResource {
	private static final String uriBooks = "https://www.reddit.com/r/books/search.json";
	private static final Logger log = Logger.getLogger(RedditResource.class.getName());
	
	public RedditModel<Post> getPosts(String q) {
		String uri = "";
		RedditModel<Post> result = null;
		ClientResource cr = null;
		
		try {
			String query = URLEncoder.encode(q, "UTF-8");
			uri = uriBooks + "?q=" + query + "&limit=5&restrict_sr=true";
			log.log(Level.FINE, "Reddit search URI: " + uri);
		}catch(UnsupportedEncodingException e) {
			log.warning("Error encoding the query");
			log.warning(e.getMessage());
			return null;
		}
					
		try {
			cr = new ClientResource(uri);
			result = cr.get(RedditModel.class);
		}catch (ResourceException e) {
			log.warning("Error retrieving posts from Reddit: " + cr.getResponse().getStatus());
		}
		
		return result;
	}
}
