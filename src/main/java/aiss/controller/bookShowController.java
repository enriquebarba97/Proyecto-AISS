package aiss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.aliexpress.ProductSearch;
import aiss.model.googlebooks.IndustryIdentifier;
import aiss.model.googlebooks.Item;
import aiss.model.idreambooks.BookReviews;
import aiss.model.reddit.Post;
import aiss.model.reddit.RedditModel;
import aiss.model.resources.AliExpressResource;
import aiss.model.resources.GoogleBooksResource;
import aiss.model.resources.IDreamBooksResource;
import aiss.model.resources.RedditResource;

public class bookShowController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    
	
	 
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
			// Reviews del libro
			IDreamBooksResource iDreamBooks = new IDreamBooksResource();
			BookReviews reviews = iDreamBooks.getReviews(isbn);
			
			// Posts en Reddit
			RedditResource reddit = new RedditResource();
			RedditModel<Post> posts = reddit.getPosts(title);
			// Merch de AliExpress
			AliExpressResource ali= new AliExpressResource();
			ProductSearch productos= ali.getProducts(title);
			rd = request.getRequestDispatcher("/coment.jsp");
			request.setAttribute("books", books);
			
			
			if(reviews != null && reddit != null && productos !=null) {
				
				request.setAttribute("reviews", reviews);
				request.setAttribute("posts", posts.getData().getChildren());
				request.setAttribute("productos", productos.getItems());
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

