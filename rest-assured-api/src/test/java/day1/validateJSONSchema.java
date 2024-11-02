package day1;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class validateJSONSchema {
	//Create a JSON Schema from JSON response
	//Add JSON Schema in project classpath
	// Add JSON Schema Validator dependency in pom.xml
	//Create a function to check response against Schema
	
	@Test
	public void testGet(){
		baseURI="https://reqres.in/api";
		given().get("/users?page=2")
		.then().statusCode(200)
		.body("data[4].first_name",equalTo("George"))
		.body("data.first_name", hasItems("George","Rachel","Michael", "Lindsay", "Tobias", "Byron"));
		
		
	}

}
