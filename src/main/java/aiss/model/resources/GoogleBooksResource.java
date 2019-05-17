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
	///Recuperar Lista completa de libros
	public List<Item> getListaEstanteria(Integer idEstanteria) {
		List<Item> res= new ArrayList<>();
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
		
		
		
		return res;
		
	}
	//Limitada a 40
	public BookSearch getListaEstanteria(Integer idEstanteria, Integer startIndex, Integer maxresult) {
		String uri= URI_ESTANT+idEstanteria+"/volumes?startIndex="+startIndex+"&maxResults="+maxresult+"&key="+ GOOGLE_API ;		
		ClientResource cr = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(token);
		cr.setChallengeResponse(chr);
		BookSearch m= cr.get(BookSearch.class);
		return m;
		
	}

	public void addBook(String volumeId, Integer idEstanteria ) {
		String uri= URI_ESTANT+idEstanteria+"/addVolume?volumeId="+volumeId+"&key="+GOOGLE_API;
		ClientResource cr =  new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(token);
		cr.setChallengeResponse(chr);
		cr.post("");
		
	}
	public void removeBook(String volumeId, Integer idEstanteria) {
		String uri= URI_ESTANT+idEstanteria+"/removeVolume?volumeId="+volumeId+"&key="+GOOGLE_API;
		ClientResource cr =  new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(token);
		cr.setChallengeResponse(chr);
		cr.post("");
	}

}
