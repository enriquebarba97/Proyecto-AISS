package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.googlebooks.BookSearch;
import aiss.model.googlebooks.Item;



public class GoogleBooksResource {
	private static final String GOOGLE_API="AIzaSyD2ZTG4c7WhtH7QIGg3nubyA_5d1opjqQw";  // TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(GoogleBooksResource.class.getName());
	
	public BookSearch getBooks(String query) throws UnsupportedEncodingException {

		//Poner parametro de entrada en formato correcto
		String titulo= URLEncoder.encode(query, "UTF-8");
		//Introducir url de consulta
		String uri="https://www.googleapis.com/books/v1/volumes?q="+titulo+"&printType=books&country=ES&key="+GOOGLE_API;
	log.log(Level.FINE,"Google_uri:"+uri);
		//Hacer peticion al servicio REST
		ClientResource cr= new ClientResource(uri);
		//Convertir ese objeto JSON a objeto JAVA
		BookSearch m= cr.get(BookSearch.class);
		//Regresar objeto
	    return m;
	}
	public Item getBook(String volumeID) throws UnsupportedEncodingException{
		
		String uri="https://www.googleapis.com/books/v1/volumes/"+volumeID+"?country=ES&projection=full&key="+GOOGLE_API;
		ClientResource cr= new ClientResource(uri);
		Item m= cr.get(Item.class);
		return m;
	}
	

}
