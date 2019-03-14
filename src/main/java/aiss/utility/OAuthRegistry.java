package aiss.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.BasicAuthentication;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;

/**
 * 
 * This class loads the data from the OAuth providers and creates
 * authorization flows for our servlets.
 * 
 * @author japarejo
 *
 */

public class OAuthRegistry {
	
	private static Logger log=Logger.getLogger(OAuthRegistry.class.getName());
            
	// File from which the OAuth data for each provider will be loaded
	protected static final String OAUTH_RESOURCE="WEB-INF/OAuthConfig.json";
	// Map were the configurations are loaded:
	protected static Map<String,OAuthServiceConfiguration> serviceConfigurations=null;
	
	static { // We load the configuration of the OAuth providers when the class is loaded by the server:
		loadConfig();
	}
	
	/**
	 * Creates an OAuth2 authorization flow for using the data provided as parameter 
	 * @param tokenURL
	 * @param clientID
	 * @param clientSecret
	 * @param authorizationFormURL
	 * @param scopes
	 * @return authorizatin flow
	 * @throws IOException
	 */
	public static AuthorizationCodeFlow initializeFlow(String tokenURL, String clientID, String clientSecret, String authorizationFormURL,Set<String> scopes) throws IOException {
		AuthorizationCodeFlow.Builder flowBuilder = new AuthorizationCodeFlow.Builder(
				BearerToken.authorizationHeaderAccessMethod(), new NetHttpTransport(), new JacksonFactory(),
				new GenericUrl(tokenURL),
				new ClientParametersAuthentication(clientID, clientSecret),
				clientID, authorizationFormURL).setDataStoreFactory(
						MemoryDataStoreFactory.getDefaultInstance());

		// Set scopes		
		flowBuilder.setScopes(scopes);

		return flowBuilder.build();
	}
	
	/**
	 * Create an authorization flow for an specific service.
	 * 
	 * @param service name for which we create the authorization flow.
	 * @return an authorization flow configured for the service provided as parameter
	 * @throws IOException when there is no configuration for the service in 
	 * the registry
	 */
	public static AuthorizationCodeFlow initializeFlow(String service) throws IOException{
		log.finest("Creating authorization flow for "+service);
		if(serviceConfigurations==null)
			loadConfig();
		OAuthServiceConfiguration config=serviceConfigurations.get(service);
		if(config==null)
			throw new IOException("There is no OAuth configuration for the service '"+config+"'");
		return initializeFlow(config.getTokenUrl(), config.getClientId(),
				config.getClientSecret(), config.getAuthorizationFormUrl(), config.getScopes());
	}
	
	
	public static void onAuthorizationSuccess(String onSuccess, String provider, Credential credential, HttpServletRequest request, HttpServletResponse response) throws IOException{
		if(onSuccess!=null){
			if(onSuccess.equals("close"))
				response.getWriter().print("<script>window.close()</script>");
			else if(onSuccess.startsWith("redirect:"))
				response.sendRedirect(onSuccess.replaceAll("redirect:", ""));
		}else
			response.getWriter().append("Access token for ").append(provider+": ").append(credential.getAccessToken());
	}
	
	/**
	 * Load the configuration of the different OAuth providers from the Json file.
	 */
	private static void loadConfig()
	{
		serviceConfigurations=new HashMap<>();
		ObjectMapper om=new ObjectMapper();		
		try {						
			
			InputStream is = Thread.currentThread().getContextClassLoader()
				    .getResourceAsStream(OAUTH_RESOURCE);
			
			if(is==null)
				log.warning("Unable read file "+OAUTH_RESOURCE);
			else{
				serviceConfigurations=(Map<String,OAuthServiceConfiguration>)om.readValue(is, new TypeReference<HashMap<String,OAuthServiceConfiguration>>(){});
			}
			log.info(serviceConfigurations.size()+" OAuth configurations Loaded!");
		} catch (IOException e) { 			
			log.log(Level.WARNING,"Unable to load OAuth configuration from "+OAUTH_RESOURCE);
			log.log(Level.WARNING,e.getMessage());
		}
	}
	
}
