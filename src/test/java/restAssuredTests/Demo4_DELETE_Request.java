package restAssuredTests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Demo4_DELETE_Request {
	@Test
	public void testDeleteRequest() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		given().when().delete("/posts/1").then().statusCode(200) // JSONPlaceholder returns 200 for successful delete
				.body(equalTo("{}")); // The response body is an empty JSON object
	}
}