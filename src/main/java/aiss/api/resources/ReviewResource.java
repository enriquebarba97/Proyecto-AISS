package aiss.api.resources;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;


import aiss.api.model.Listing;
import aiss.api.model.Review;
import aiss.api.model.repository.BookRepository;
import aiss.api.model.repository.MapBookRepository;




@Path("/reviews")
public class ReviewResource {
	
	private static final Logger log = Logger.getLogger(ReviewResource.class.getName());
	
	public static ReviewResource _instance=null;
		BookRepository repository;
		
	private ReviewResource(){
			repository=MapBookRepository.getInstance();
	}
		
	public static ReviewResource getInstance(){
			if(_instance==null)
				_instance=new ReviewResource();
			return _instance; 
	}
	
	// AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER
	// AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER
	// AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER AÑADIR A SWAGGER
	@GET
	@Produces("application/json")
	public Listing<Review> getAll(@QueryParam("startIndex") @DefaultValue("0") int startIndex,
			@QueryParam("maxResults") @DefaultValue("5") int maxResults,
			@QueryParam("critic") @DefaultValue("") String critic,
			@QueryParam("from") @DefaultValue("") String from,
			@QueryParam("until") @DefaultValue("") String until)
	{
		log.info("Critic filter: " + critic);
		List<Review> results = new ArrayList<>(repository.getAllReviews());
		if(!critic.equals("")) {
			List<Review> parcial = new ArrayList<Review>();
			for(Review r:results) {
				if(r.getAuthor().toLowerCase().contains(critic.toLowerCase()))
					parcial.add(r);
			}
			results = parcial;
		}
		
		if(!from.equals("")) {
			List<Review> parcial = new ArrayList<Review>();
			LocalDate fromDate = LocalDate.parse(from, DateTimeFormatter.ofPattern("d/MM/yyyy"));
			for(Review r:results) {
				if(r.getRelease_date().isAfter(fromDate))
					parcial.add(r);
			}
			results = parcial;
		}
		
		if(!until.equals("")) {
			List<Review> parcial = new ArrayList<Review>();
			LocalDate untilDate = LocalDate.parse(until, DateTimeFormatter.ofPattern("d/MM/yyyy"));
			for(Review r:results) {
				if(r.getRelease_date().isBefore(untilDate))
					parcial.add(r);
			}
			results = parcial;
		}
		
		maxResults = maxResults<=10 ? maxResults:10;
		int endIndex = startIndex+maxResults<results.size() ? startIndex+maxResults:results.size();
		Listing<Review> res = new Listing<Review>(results.size(), startIndex, maxResults, 
				results.subList(startIndex, endIndex));
		
		
		return res;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Review getPerId(@PathParam("id") String id)
	{
		Review review = repository.getReview(id);
		if(review == null) {
			throw new NotFoundException("The review with id="+ id +" was not found");
		}
		
		return review;
	}
	///////¿CAMBIAR GET EN EL RECURSO REVIEW? HAY MAS DE 1 REVIEW POR LIBRO¿NO?
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addReview(@Context UriInfo uriInfo, Review review) {
		if(review.getCritic_review() == null || "".equals(review.getCritic_review())) {
			throw new BadRequestException("The critic review of the book must not be null");
		}
		if(review.getTitle() == null) {
			throw new BadRequestException("The title of de book must no be null");
		}
		
		repository.addReview(review);
		
		//EL SIGUIENTE CÓDIGO ES SIEMPRE IGUAL EN LOS MÉTODOS POST.
		//SE NECESITA PARA CONSTRUIR LA RESPUESTA DEL MÉTODO POST.
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(review.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(review);			
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateReview(Review review) {
		Review oldReview = repository.getReview(review.getId());
		
		if(oldReview == null) {
			throw new NotFoundException("The review was not found");
	
		}
		repository.updateReview(review);
	
		return Response.noContent().build();
	}
	//////SI CADA LIBRO TIENE MAS DE 1 REVIEW,COMO VAS A ELIMINAR UNA REVIEW PASANDO SOLO EL TITULO
	////// O SE BORRAN TODAS(CAMBIO CODIGO) O SE CAMBIA LA DEFINICION Y QUE BORRE SEGUN ID
	@DELETE
	@Path("/{id}")
	public Response removeReview(@PathParam("id") String id) {
		Review reviewToBeRemoved = repository.getReview(id);
		if(reviewToBeRemoved == null) {
			throw new NotFoundException("The review was not found");
		}else {
			repository.deleteReview(id);
		}
		return Response.noContent().build(); //EL UPDATE Y EL DELETE SIEMPRE TIENEN ESTE MENSAJE DE VUELTA
	}
	
}	

