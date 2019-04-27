package aiss.model.resources;

import java.util.logging.Logger;

import org.restlet.Request;
import org.restlet.data.Header;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import aiss.model.aliexpress.ProductSearch;
import aiss.model.aliexpress.Search;

public class AliExpressResource {
	
	private static final String key = "DCKYQTYERAKUSDMH";
	private static final String uri = "https://api.aliseeks.com/v1/search/realtime";
	
	private static final Logger log = Logger.getLogger(AliExpressResource.class.getName());
	
	public ProductSearch getProducts(String q) {
		ProductSearch result = null;
		ClientResource cr = null;
		Search sr = new Search(q);
		
		try {
			cr = new ClientResource(uri);
			Series<Header> headers = (Series<Header>) cr.getRequestAttributes().get("org.restlet.http.headers");
			if (headers == null) {
			    headers = new Series<Header>(Header.class);
			    cr.getRequestAttributes().put("org.restlet.http.headers", headers);
			}
			headers.set("X-Api-Client-Id", key);
			result = cr.post(sr, ProductSearch.class);
			
		} catch (ResourceException e) {
			log.warning("Error retrieving the resource: " + cr.getResponse().getStatus());
		}
		
		return result;
	}
}
