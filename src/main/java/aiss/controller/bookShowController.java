package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googlebooks.IndustryIdentifier;
import aiss.model.googlebooks.Item;
import aiss.model.idreambooks.BookReviews;
import aiss.model.reddit.Post;
import aiss.model.reddit.RedditModel;
import aiss.model.resources.GoogleBooksResource;
import aiss.model.resources.IDreamBooksResource;
import aiss.model.resources.RedditResource;

public class bookShowController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(bookShowController.class.getName());

    
	
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookShowController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String query = request.getParameter("volumeID");
		
		RequestDispatcher rd = null;
		
		String token= (String) request.getSession().getAttribute("GoogleBooks-token");
		if(token!=null && !"".equals(token)) {
			request.setAttribute("logged", true);
			GoogleBooksResource rc= new GoogleBooksResource(token);
			List<Item> lista= rc.getListaEstanteria(2);
			log.info("Libros por leer: "+ lista.size());
			boolean stat= false;
			for(Item i : lista) {
				stat=i.getId().equals(query);
				if(stat) {
					request.setAttribute("estado", stat);
					break;
				}
			}
		}
		
		GoogleBooksResource google= new GoogleBooksResource();
		Item books= google.getBook(query);

		

		if ( books!=null ){
			
			String title = books.getVolumeInfo().getTitle();
			String isbn="";
			for(IndustryIdentifier id:books.getVolumeInfo().getIndustryIdentifiers()) {
				if(id.getType().equals("ISBN_13")) {
					isbn = id.getIdentifier();
					break;
				}
			}
			 //Reviews del libro
			IDreamBooksResource iDreamBooks = new IDreamBooksResource();
			BookReviews reviews = iDreamBooks.getReviews(isbn);
			if(reviews != null) {
				request.setAttribute("reviews", reviews);
			}
			
			// Posts en Reddit
			RedditResource reddit = new RedditResource();
			RedditModel<Post> posts = reddit.getPosts(title);
			
			rd = request.getRequestDispatcher("/coment.jsp");
			request.setAttribute("books", books);
			
			
			if(reddit != null ) {
				request.setAttribute("posts", posts.getData().getChildren());
				request.setAttribute("title", title);
			}
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}

