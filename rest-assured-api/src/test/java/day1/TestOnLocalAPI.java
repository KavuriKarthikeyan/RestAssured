package day1;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class TestOnLocalAPI {
	
	@Test
	public void get()
	{
		baseURI="http://localhost:3000/";
		given().get("/users").then().statusCode(200);
		//get response
		given().get("/users").then().statusCode(200).log().all();
		
		
	}
	

	@Test
	public void post()
	{
		baseURI="http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Thomas");
		request.put("lastName", "Edison");
		request.put("subjectId", "2");
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users")
		.then()
		.statusCode(201);
		
	}
	

	@Test
	public void put()
	{
		baseURI="http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Albert11");
		request.put("lastName", "Edison1");
		request.put("subjectId", "2");
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/users/4")
		.then()
		.statusCode(201);
		
	}

	@Test
	public void patch()
	{
		baseURI="http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Jame");
		request.put("lastName", "Doe");
		request.put("subjectId", "2");
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("/users/3")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void delete()
	{
		baseURI="http://localhost:3000/";
		when()
		.delete("/users/4")
		.then().statusCode(200);
		
		
		
	}
	
}
