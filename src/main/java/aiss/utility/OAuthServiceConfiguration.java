package aiss.utility;

import java.util.Set;
import java.util.HashSet;
/**
 * Configuration for an OAuth 2.0 service provider.
 * 
 * @author japarejo
 *
 */
public class OAuthServiceConfiguration {
	private String tokenUrl;
	private String clientId;
	private String clientSecret; 
	private String authorizationFormUrl;
	private Set<String> scopes;
	
	
	public OAuthServiceConfiguration(){
		this("", "", "", "", new HashSet<String>());
	}
	
	public OAuthServiceConfiguration(String tokenUrl, String clientId, String clientSecret, String authorizationFormUrl,
			Set<String> scopes) {
		super();
		this.tokenUrl = tokenUrl;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.authorizationFormUrl = authorizationFormUrl;
		this.scopes = scopes;
	}
	
	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setAuthorizationFormUrl(String authorizationFormUrl) {
		this.authorizationFormUrl = authorizationFormUrl;
	}

	public void setScopes(Set<String> scopes) {
		this.scopes = scopes;
	}
	
	public String getTokenUrl() {
		return tokenUrl;
	}
	public String getClientId() {
		return clientId;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public String getAuthorizationFormUrl() {
		return authorizationFormUrl;
	}
	public Set<String> getScopes() {
		return scopes;
	}
	
	
}
