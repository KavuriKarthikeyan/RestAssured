package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Path_queryParameter {
	//https://reqres.in----------domain
	//page=2 ---------query parameter--filter the data
	//path parameter---------/api/users?--routing the request where it should go
	@Test
	public void testQueryAndPathParameters() {
		
		given()
		.pathParam("mypath","users")
		.queryParam("page",2)
		.queryParam("id",5)
		
		.when()
			.get("https://reqres.in/api/{mypath}")
			
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
//cookies and headers as part of the response 
	
}
