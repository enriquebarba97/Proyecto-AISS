package aiss.api.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Book;
import aiss.api.model.repository.BookRepository;
import aiss.api.model.repository.MapBookRepository;

public class BookResource {
	
	/* Singleton */
	private static BookResource _instance=null;
	BookRepository repository;
	
	private BookResource() {
		repository=MapBookRepository.getInstance();

	}
	
	public static BookResource getInstance()
	{
		if(_instance==null)
				_instance=new BookResource();
		return _instance;
	}
	
	@GET
	@Produces("/application.json")
	public Collection<Book> getAll(){
		return repository.getAllBooks();
	}
	
	@GET
	@Path("/{bookisbn}")
	@Produces("/application.json")
	public Book get(@PathParam("bookisbn") String isbn) {
		Book b = repository.getBook(isbn);
		if(b == null) {
			throw new NotFoundException("The book with ISBN="+ isbn +" was not found");
		}
		return b;
	}
	
	@GET
	@Path("/{autor}")
	@Produces("/application.json")
	public Collection<Book> getAll(@PathParam("autor") String author) {
		Collection<Book> books = repository.getBooksAuthor(author);
		if(books == null) {
			throw new NotFoundException("The books with Author="+ author +" were not found");
		}
		return books;
	}
	
	/////////////////PREGUNTAR LO DE GENERAR ISBN(ADDBOOK(BOOK))
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addBook(@Context UriInfo uriInfo, Book book) {
		if (book.getTitle() == null || "".equals(book.getTitle())) {
			throw new BadRequestException("The title of the book must not be null");
		}
	repository.addBook(book);
	
	UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
	URI uri = ub.build(book.getIsbn());
	ResponseBuilder resp = Response.created(uri);
	resp.entity(book);			
	return resp.build();
	}
	
	////////HAY QIE ACTUALIZAR LA LISTA DE REVIEWS?
	@PUT
	@Consumes("application/json")
	public Response updateBook(Book book) {
		Book oldBook = repository.getBook(book.getIsbn());
		if(oldBook == null) {
			throw new NotFoundException("The book with isbn="+ book.getIsbn() +" was not found");
		}
		//update title
		if (book.getTitle()!=null) {
			oldBook.setTitle(book.getTitle());
		}
		//update author
		if(book.getAuthor()!=null) {
			oldBook.setAuthor(book.getAuthor());
		}
		//update rating
		if(book.getRating()!=null){
			oldBook.setRating(book.getRating());
		}
		//update price
		if(book.getPrecio()!=null) {
			oldBook.setPrecio(book.getPrecio());
		}
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{bookIsbn}")
	public Response removeBook(@PathParam("bookIsbn") String isbn) {
		 Book toberemoved=repository.getBook(isbn);
		if (toberemoved == null) {
			throw new NotFoundException("The book with isbn="+ isbn +" was not found");
		}	
		else {
			repository.deleteBook(isbn);
		}
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{autor}")
	public Response removeBooksPerAuthor(@PathParam("autor") String author) {
		 Collection<Book> toberemoved=repository.getBooksAuthor(author);
		if (toberemoved == null) {
			throw new NotFoundException("The books with author="+ author +" were not found");
		}	
		else {
			repository.deleteBooksPerAuthor(author);
		}
		return Response.noContent().build();
	}
}
