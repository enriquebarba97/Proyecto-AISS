package aiss.model.resources;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.googlebooks.BookSearch;
import aiss.model.googlebooks.Item;



public class GoogleBooksResource {
	private static final String GOOGLE_API="AIzaSyD2ZTG4c7WhtH7QIGg3nubyA_5d1opjqQw";
	private static final String URI_ESTANT= "https://www.googleapis.com/books/v1/mylibrary/bookshelves/";
	private static final Logger log = Logger.getLogger(GoogleBooksResource.class.getName());
	private String token;
	
	
	public GoogleBooksResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoogleBooksResource(String token) {
		this.token=token;
	}
	
	public BookSearch getBooks(String query) throws UnsupportedEncodingException {
		BookSearch m = null;
		//Poner parametro de entrada en formato correcto
		String titulo= URLEncoder.encode(query, "UTF-8");
		//Introducir url de consulta
		String uri="https://www.googleapis.com/books/v1/volumes?q="+titulo+"&printType=books&country=ES&key="+GOOGLE_API;
		log.log(Level.FINE,"Google_uri:"+uri);
		//Hacer peticion al servicio REST
		ClientResource cr= new ClientResource(uri);
		//Convertir ese objeto JSON a objeto JAVA
		try {
			m= cr.get(BookSearch.class);
			log.info("Search succesful");
		}catch (ResourceException e) {
			log.warning("Error during the search: " + e.getResponse().getStatus());
		}
		//Regresar objeto
	    return m;
	}
	public Item getBook(String volumeID) throws UnsupportedEncodingException{
		
		String uri="https://www.googleapis.com/books/v1/volumes/"+volumeID+"?country=ES&projection=full&key="+GOOGLE_API;
		ClientResource cr= new ClientResource(uri);
		Item m = null;
		
		log.info("Retrieving book with id " + volumeID);
		try {
			m= cr.get(Item.class);
			log.info("Book recovered successfully");
		}catch (ResourceException e) {
			log.warning("Error recovering the book's info: " + e.getResponse().getStatus());
		}
		return m;
	}
	///Recuperar Lista completa de libros
	public List<Item> getListaEstanteria(Integer idEstanteria) {
		List<Item> res= new ArrayList<>();
		try {
			BookSearch actual= getListaEstanteria(idEstanteria, 0, 40);
			if(actual.getItems()!=null) {
				Integer i=0;
				Integer j=40;
				Integer max= actual.getTotalItems()/40;
				res.addAll(actual.getItems());
				while(i<max) {
					actual=getListaEstanteria(idEstanteria, j, 40);
					i++;
					j+=40;
				}
			}
		} catch(NullPointerException e) {
			log.warning("The shelf search returned null: " + e.getMessage());
		}
		
		
		return res;
		
	}
	//Limitada a 40
	public BookSearch getListaEstanteria(Integer idEstanteria, Integer startIndex, Integer maxresult) {
		String uri= URI_ESTANT+idEstanteria+"/volumes?startIndex="+startIndex+"&maxResults="+maxresult+"&key="+ GOOGLE_API ;		
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		BookSearch m = null;
		chr.setRawValue(token);
		cr.setChallengeResponse(chr);
		
		log.info("Retrieving books from shelf with id " + idEstanteria);
		try {
			m= cr.get(BookSearch.class);
		}catch (ResourceException e) {
			log.warning("Error retrieving the resource: " + cr.getResponse().getStatus());
		}
		return m;
		
	}

	public boolean addBook(String volumeId, Integer idEstanteria ) {
		boolean result = false;
		String uri= URI_ESTANT+idEstanteria+"/addVolume?volumeId="+volumeId+"&key="+GOOGLE_API;
		ClientResource cr =  new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(token);
		cr.setChallengeResponse(chr);
		
		log.info("Adding the book with ID: " + volumeId);
		try {
			cr.post("");
			log.info("Response: "+ cr.getResponse().getStatus());
			result = true;
		}catch (ResourceException e) {
			log.warning("Error adding the resource: " + cr.getResponse().getStatus());
		}
		
		return result;
	}
	public boolean removeBook(String volumeId, Integer idEstanteria) {
		boolean result = false;
		String uri= URI_ESTANT+idEstanteria+"/removeVolume?volumeId="+volumeId+"&key="+GOOGLE_API;
		ClientResource cr =  new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(token);
		cr.setChallengeResponse(chr);
		log.info("Removing the book with ID: " + volumeId);
		try {
			cr.post("");
			log.info("Response: "+ cr.getResponse().getStatus());
			result = true;
		} catch (ResourceException e) {
			log.warning("Error removing the resource: " + cr.getResponse().getStatus());
		}
		
		return result;
	}

}
