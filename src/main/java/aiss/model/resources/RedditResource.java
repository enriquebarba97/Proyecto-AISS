package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.*;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.reddit.NewPost;
import aiss.model.reddit.Post;
import aiss.model.reddit.RedditModel;
import aiss.model.reddit.RedditResponse;
import aiss.model.reddit.RedditUser;

public class RedditResource {
	private static final String uriOauth = "https://oauth.reddit.com/api/";
	private static final String uriUser = uriOauth + "v1/me";
	private static final String uriPost = uriOauth + "submit";
	private static final String uriBooks = "https://www.reddit.com/r/books/search.json";
	private static final String agent = "webapp:book-assistant-aiss:v1.1";
	private static final Logger log = Logger.getLogger(RedditResource.class.getName());
	private String accessToken;
	
	public RedditResource() {
		super();
	}
	
	public RedditResource(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public RedditModel<Post> getPosts(String q) {
		String uri = "";
		RedditModel<Post> result = null;
		ClientResource cr = null;
		
		try {
			String query = URLEncoder.encode(q, "UTF-8");
			uri = uriBooks + "?q=" + query + "&limit=5&restrict_sr=true";
			log.log(Level.FINE, "Reddit search URI: " + uri);
		}catch(UnsupportedEncodingException e) {
			log.warning("Error encoding the query");
			log.warning(e.getMessage());
			return null;
		}
					
		try {
			cr = new ClientResource(uri);
			result = cr.get(RedditModel.class);
		}catch (ResourceException e) {
			log.warning("Error retrieving posts from Reddit: " + cr.getResponse().getStatus());
		}
		
		return result;
	}
	
	public String getCurrentUser() {
		ClientResource cr = new ClientResource(uriUser);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(accessToken);
		cr.setChallengeResponse(chr);
		
		String result = null;
		try {
			RedditUser user = cr.get(RedditUser.class);
			result = user.getName();
		}catch(ResourceException e) {
			log.warning("ERROR: " + e.getMessage());
		}
		return result;
	}
	
	public void postOnBooks(NewPost post) {
		ClientResource cr  = new ClientResource(uriPost);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(accessToken);
		cr.setChallengeResponse(chr);
		cr.getClientInfo().setAgent(agent);
		
		log.info("Posting to Reddit: " + uriPost);
		log.info("Title" + post.getTitle());
		try {
			cr.post(post);
			log.info(cr.getResponse().getEntityAsText());
		}catch (ResourceException e) {
			log.warning("ERROR: " + e.getMessage());
			log.warning(e.getResponse().getEntityAsText());
		}
		
	}
		
	public String postOnBooks(String title, String text, Boolean spoiler) throws UnsupportedEncodingException {
		title = URLEncoder.encode(title, "UTF-8");	
		text = URLEncoder.encode(text, "UTF-8");
		String uri = uriPost + "?api_type=json&kind=self&spoiler="+spoiler+"&sr=test&title="+title+
					"&text="+text;
		ClientResource cr  = new ClientResource(uri);
		ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
		chr.setRawValue(accessToken);
		cr.setChallengeResponse(chr);
		cr.getClientInfo().setAgent(agent);
		
		log.info("Posting to Reddit: " + uri);
		try {
			RedditResponse response = cr.post("", RedditResponse.class);
			String result = null;
			if(!response.getJson().getErrors().isEmpty()) {
				result ="Ratelimit: " + response.getJson().getErrors().get(0).get(1);
				log.info("Result of the submit: " +result);
				return result;
			}else {
				result = "Post submitted succesfully";
				log.info("Result of the submit: " +result);
				return result;
			}
		}catch (ResourceException e) {
			log.warning("ERROR: " + e.getMessage());
			log.warning(e.getResponse().getEntityAsText());
			return "There was an error submitting the post.";
		}
	}
}
