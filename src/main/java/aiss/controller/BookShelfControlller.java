package aiss.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.log.Logger;

import aiss.model.resources.GoogleBooksResource;

/**
 * Servlet implementation class BookShelfControlller
 */
public class BookShelfControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
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
		// TODO Auto-generated method stub
		
		String id= request.getParameter("volumeId");
		String token= (String) request.getSession().getAttribute("GoogleBooks-token");
		GoogleBooksResource rc= new GoogleBooksResource(token);
		String add= request.getParameter("add");
		String remove= request.getParameter("remove");
		if(add!=null && !"".equals(add)) {
			rc.addBook(id, 2);
		}else if(remove!=null && "".equals(remove)) {
			rc.removeBook(id, 2);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
