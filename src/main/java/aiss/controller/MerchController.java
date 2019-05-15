package aiss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.aliexpress.ProductSearch;
import aiss.model.resources.AliExpressResource;


public class MerchController  extends HttpServlet  {
	private static final long serialVersionUID = 1L;
    
	
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerchController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		String title = request.getParameter("title");
		RequestDispatcher rd = null;

			// Merch de AliExpress
			AliExpressResource ali= new AliExpressResource();
			ProductSearch productos= ali.getProducts(title);
			rd = request.getRequestDispatcher("/merch.jsp");
			
			
			
			if(productos !=null) {
				
				
				request.setAttribute("productos", productos.getItems());
			} else {
				rd = request.getRequestDispatcher("/error.jsp");
			}
		
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}


