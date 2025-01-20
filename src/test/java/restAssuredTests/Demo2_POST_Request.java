package restAssuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_POST_Request {

    public static HashMap<String, String> map = new HashMap<>();

    @BeforeTest
    public void postData() {
        map.put("FirstName", RestUtil.getFirstName());
        map.put("LastName", RestUtil.getLastName());
        map.put("UserName", RestUtil.getUserName());
        map.put("Password", RestUtil.getPassword());
        map.put("Email", RestUtil.getEmail());
        
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.basePath = "/posts";
    }

    @Test
    public void post() {
        given()
            .contentType("application/json")
            .body(map)
        .when()
            .post()
        .then()
            .statusCode(201)
            .body("FirstName", equalTo(map.get("FirstName")))
            .body("LastName", equalTo(map.get("LastName")))
            .body("UserName", equalTo(map.get("UserName")))
            .body("Email", equalTo(map.get("Email")))
            .body("id", notNullValue());
    }
}
