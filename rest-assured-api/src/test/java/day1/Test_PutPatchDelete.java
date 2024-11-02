package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_PutPatchDelete {
	
	@Test
	public void Put() {
		JSONObject request = new JSONObject();
		request.put("name","Raghav");
		request.put("job", "Teacher");                
		System.out.println(request.toString());
		
		baseURI="https://reqres.in/api";
		
		given().
		header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		
		.body(request.toString())
		.when().put("/users/2").
		then().
		statusCode(200)
		.log().all();
	}

	@Test
	public void Patch() {
		JSONObject request = new JSONObject();
		request.put("name","Raghav");
		request.put("job", "Teacher");                
		System.out.println(request.toString());
		
		baseURI="https://reqres.in";
		
		given().
		header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		
		.body(request.toString())
		.when().patch("/api/users/2").
		then(). 
		statusCode(200)
		.log().all();
	}
	
	@Test
	public void Delete() {
	
		
		baseURI="https://reqres.in/api";
		when().delete("api/users/2").
		then().
		statusCode(204)
		.log().all();
	}
}
