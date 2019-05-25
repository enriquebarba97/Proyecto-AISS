package aiss.controller.oauth;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import aiss.model.resources.RedditResource;
import aiss.utility.RedditOAuth;

/**
 * Servlet implementation class RedditOauth2Callback
 */
public class RedditOauth2Callback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedditOauth2Callback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		try {
			JSONObject token = RedditOAuth.getToken(code);
			String accessToken = token.getString("access_token");
			RedditResource reddit = new RedditResource(accessToken);
			String username = reddit.getCurrentUser();
			request.getSession().setAttribute("Reddit-token", accessToken);
			request.getSession().setAttribute("Reddit-refresh", token.getString("refresh_token"));
			request.getSession().setAttribute("Reddit-expires", System.currentTimeMillis());
			request.getSession().setAttribute("Reddit-user", username);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String volumeID = (String) request.getSession().getAttribute("volumeID");
		response.sendRedirect("/bookShowController?volumeID="+volumeID);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
