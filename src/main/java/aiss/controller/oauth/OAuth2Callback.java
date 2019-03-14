
package aiss.controller.oauth;

import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.utility.OAuthRegistry;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.http.GenericUrl;

/**
 * Servlet implementation class OAuth2Callback
 */
public class OAuth2Callback extends AbstractAuthorizationCodeCallbackServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log=Logger.getLogger(OAuth2Callback.class.getName());
		
	@Override
	protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
			throws ServletException, IOException {
		String provider=getInitParameter("provider");
		req.getSession().setAttribute(provider+"-token", credential.getAccessToken());
		OAuthRegistry.onAuthorizationSuccess(getInitParameter("onSuccess"), provider, credential, req, resp);				
		
	}

	@Override
	protected void onError(HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
			throws ServletException, IOException {
		log.warning("ERROR on OAuth Callback! "+errorResponse.getCode()+": "+errorResponse.getError()+". "+errorResponse.getErrorDescription());
		resp.getWriter().append("ERROR!").append(errorResponse.getCode()).append(": ")
			.append(errorResponse.getError()).append(errorResponse.getErrorDescription());
	}

	@Override
	protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
				
		GenericUrl url = new GenericUrl(req.getRequestURL().toString());
		url.setRawPath("/oauth2callback/"+getInitParameter("provider"));
		return url.build();
	}

	@Override
	protected AuthorizationCodeFlow initializeFlow() throws IOException {		
		return OAuthRegistry.initializeFlow(getInitParameter("provider"));
	}

	@Override
	protected String getUserId(HttpServletRequest req) throws ServletException, IOException {		
		return UUID.randomUUID().toString();
	}
}
