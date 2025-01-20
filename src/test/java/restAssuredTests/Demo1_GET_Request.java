package restAssuredTests;

import static io.restassured.RestAssured.*; // Corrected the import to remove extra spacing.
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Demo1_GET_Request {
    
    @Test
    public void getWeatherDetails() {
        given()
            .log().all() // Optional: Log the request for debugging.
        .when()
            .get("https://jsonplaceholder.typicode.com/posts/1") // Correct JSONPlaceholder endpoint.
        .then()
            .log().all() // Optional: Log the response for debugging.
            .statusCode(200) // Check for HTTP status 200.
            .statusLine("HTTP/1.1 200 OK") // Verify the status line.
            .assertThat()
            .body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")) // Validate "title" field.
            .header("Content-Type", "application/json; charset=utf-8"); // Ensure Content-Type matches.
    }
}


/*
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MenuAPITest {
    @Test
    public void testGetMenu() {
        RestAssured.baseURI = "https://api.swiggy.com";

        given()
            .header("Authorization", "Bearer <token>")
            .queryParam("restaurantId", 123)
        .when()
            .get("/restaurants/{id}/menu")
        .then()
            .statusCode(200)
            .body("menuItems.size()", greaterThan(0))
            .body("menuItems[0].name", notNullValue());
    }
}*/