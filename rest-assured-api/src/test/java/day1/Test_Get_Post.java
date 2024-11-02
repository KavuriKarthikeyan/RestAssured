package day1;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class Test_Get_Post {
	/*
	 * @Test public void test_Get() { Response response =
	 * get("https://reqres.in/api/users?page=2");
	 * System.out.println(response.getStatusCode());
	 * System.out.println(response.getTime());
	 * System.out.println(response.getBody().asString());
	 * System.out.println(response.getHeader("content-type"));
	 * 
	 * int statusCode = response.getStatusCode(); Assert.assertEquals(statusCode,
	 * 200); }
	 * 
	 * @Test public void test2(){ baseURI="https://reqres.in/api";
	 * given().get("/users?page=2") .then().statusCode(200)
	 * .body("data[4].first_name",equalTo("George")) .body("data.first_name",
	 * hasItems("George","Rachel","Michael", "Lindsay", "Tobias", "Byron"));
	 * 
	 * 
	 * }
	 */
	
	@Test(priority =1)
	public void testPost() {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * map.put("name", "Raghav"); map.put("job", "Teacher");
		 * System.out.println(map);
		 */
		
		JSONObject request = new JSONObject(map);
		request.put("name","Raghav");
		request.put("job", "Teacher");                
		System.out.println(request.toString());
		
		baseURI="https://reqres.in/api";
		
		given().
		header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		
		.body(request.toString())
		.when().post("/users").
		then().
		statusCode(201)
		.log().all();
		
	}
	
	@Test(priority =2)
	public void testPostPOJO() {
		POJO_POSTRequest data=new POJO_POSTRequest();
		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("12345");
		String courseArr[]= {"c","c+"};
		
		data.setCourses(courseArr);
		
		baseURI="https://reqres.in/api";
		
		given().
			header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(data.toString())
		
		.when()
			.post("/users")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Scott"))
			.body("location", equalTo("France"))
			.body("phone", equalTo("123456"))
			.body("coursee[0]", equalTo("C"))
			.body("coursee[0]", equalTo("C++"))
			.log().all();
		
	}
}
