package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.idreambooks.AcclaimedBook;
import aiss.model.idreambooks.BookReviews;

public class IDreamBooksResource {
	private static final String API_KEY = "ae3e258c1c1207bf552763947a9d1e633fd42994";
	private static final String base_uri = "http://idreambooks.com/api/";
	private static final String reviews_uri = base_uri + "books/reviews.json?q=%q&country=ES&key="+API_KEY;
	private static final String acclaimed_uri = base_uri + "publications/recent_recos.json?&slug=%genre&key="+API_KEY;
	
	private static final Logger log = Logger.getLogger(IDreamBooksResource.class.getName());
	
	public BookReviews getReviews(String q) {
		BookReviews result = null;
		String uri = "";
		ClientResource cr = null;
		
		try {
			String query = URLEncoder.encode(q, "UTF-8");
			uri = reviews_uri.replace("%q", query);
			log.log(Level.FINE, "IDreamBooks uri: " + uri);
		}catch(UnsupportedEncodingException e) {
			log.warning("Error encoding the query");
			log.warning(e.getMessage());
			return null;
		}
		
		try {
			 cr = new ClientResource(uri);
			 result = cr.get(BookReviews.class);
			log.log(Level.FINE, "Reviews for the query " + q + "successfully retrieved");
		}catch (ResourceException e) {
			log.warning("Error retrieving the resource: " + cr.getResponse().getStatus());
		}
		
		
		return result;
	}
	
	
	// Posible extensión: Obtener libros relevantes y recientes de un género
	public List<AcclaimedBook> getAcclaimedBooks(String genre) {
		List<AcclaimedBook> result = null;
		String uri = "";
		ClientResource cr = null;
		try {
			String query = URLEncoder.encode(genre, "UTF-8");
			uri = acclaimed_uri.replace("%genre", query);
			log.log(Level.FINE, "IDreamBooks uri: " + uri);
		}catch(UnsupportedEncodingException e) {
			log.warning("Error encoding the query");
			log.warning(e.getMessage());
			return null;
		}
		
		try {
			cr = new ClientResource(uri);
			result = Arrays.asList(cr.get(AcclaimedBook[].class));
			log.log(Level.FINE, "Reviews for the genre " + genre + "successfully retrieved");
		}catch (ResourceException e) {
			log.warning("Error retrieving the resource: " + cr.getResponse().getStatus());
		}
		
		return result;
	}
}
