package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedditNewPost
 */
public class RedditNewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(RedditNewPost.class.getName());

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedditNewPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("volumeID", request.getParameter("volumeID"));
		String accessToken = (String) request.getSession().getAttribute("Reddit-token");
		if(accessToken == null || "".equals(accessToken)) {
			log.info("Retrieving Reddit access token");
			request.getRequestDispatcher("/RedditAuthController").forward(request, response);
		}else {
			request.setAttribute("title", request.getParameter("title"));
			request.getRequestDispatcher("/post.jsp").forward(request, response);
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
