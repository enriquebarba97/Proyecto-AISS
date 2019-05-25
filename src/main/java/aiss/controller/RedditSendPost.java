package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import aiss.model.reddit.NewPost;
import aiss.model.resources.RedditResource;
import aiss.utility.RedditOAuth;

/**
 * Servlet implementation class RedditSendPost
 */
public class RedditSendPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(RedditSendPost.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedditSendPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = (String) request.getParameter("title");
		String text = (String) request.getParameter("text");
		Boolean spoiler = false;
		if(request.getParameter("spoiler")!=null) {
			spoiler = true;
		}
		log.info("Texto del post: " + text);
		
		String accessToken = (String) request.getSession().getAttribute("Reddit-token");
		if(accessToken != null && !"".equals(accessToken)) {
			Long time = (Long) request.getSession().getAttribute("Reddit-expires");
			String refresh_token = (String) request.getSession().getAttribute("Reddit-refresh");
			accessToken = refrescarToken(accessToken, time, refresh_token, request);
			RedditResource rs = new RedditResource(accessToken);
			rs.postOnBooks(title, text, spoiler);
			
		}else {
			log.info("Retrieving Reddit access token");
			request.getRequestDispatcher("/RedditAuthController").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String refrescarToken(String accessToken, Long time, String refresh_token, HttpServletRequest request) {
		String token = accessToken;
		if(System.currentTimeMillis()>(time+3300000L)) {
			log.fine("Refreshing Reddit access token");
			try {
				JSONObject refresco = RedditOAuth.refreshToken(refresh_token);
				token = refresco.getString("access_token");
				request.getSession().setAttribute("Reddit-token", token);
				request.getSession().setAttribute("Reddit-expires", System.currentTimeMillis());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return token;
	}
}
