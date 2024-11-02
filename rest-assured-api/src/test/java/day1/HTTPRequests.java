package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 given()
 content type, set cookies, add auth, add param, set headers info etc...
 --------------------------------------
  when()*
  get, post, put, delete
  -----------------------------------------------------
   then()
   validate status code, extract responser, etract headers cookies & response body...
  */


public class HTTPRequests {
	@Test(priority=1)
	void getUser() {	
		
		given()
		.when()
			.get("https://reqres.in/api/users/2")
			
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}

	@Test(priority=2)
	void postUser() {	
		
		given()
		.when()
			.get("https://reqres.in/api/users/2")
			
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
	}
	

}
