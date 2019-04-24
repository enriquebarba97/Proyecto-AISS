package aiss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googlebooks.BookSearch;
import aiss.model.resources.GoogleBooksResource;

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
		BookSearch books= google.getBook(query);

		

		if ( books!=null ){
			rd = request.getRequestDispatcher("/coment.jsp");
			request.setAttribute("books", books.getItems());
			
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}

