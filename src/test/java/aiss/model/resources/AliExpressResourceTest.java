package aiss.model.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import aiss.model.aliexpress.ProductSearch;

public class AliExpressResourceTest {

	@Test
	public void testGetProducts() {
		String query = "lord of the rings";
		AliExpressResource rs = new AliExpressResource();
		ProductSearch search = rs.getProducts(query);
		
		assertNotNull("The search returned null", search);
		assertNotNull("The review object is null", search.getItems());
		
		System.out.println("The search for " + query +"'s items returned " + search.getItems().size() + " items");
		System.out.println(search.getItems().get(0).getTitle());
	}

}
