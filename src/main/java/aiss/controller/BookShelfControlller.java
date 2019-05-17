package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.GoogleBooksResource;

/**
 * Servlet implementation class BookShelfControlller
 */
public class BookShelfControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BookShelfControlller.class.getName());

   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookShelfControlller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String id= request.getParameter("volumeId");
		String token= (String) request.getSession().getAttribute("GoogleBooks-token");
		GoogleBooksResource rc= new GoogleBooksResource(token);
		String envio= request.getParameter("envio");
		if(envio!=null && !"".equals(envio)) {
			if(envio.equals("añadir")) {
				rc.addBook(id, 2);
			}else if(envio.equals("eliminar")) {
				rc.removeBook(id, 2);
			}
		}
		
		request.getRequestDispatcher("/bookShowController").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
