package restAssuredTests;

import java.util.HashMap;
import org.testng.annotations.*;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_PUT_Request {

    public static HashMap<String, String> map = new HashMap<>();

    // Employee data
    String empName = RestUtil.getempName();
    String empSal = RestUtil.getempSal();
    String empAge = RestUtil.getempAge();
    int emp_id = 11254; // Replace with a valid employee ID

    @BeforeClass
    public void putData() {
        // Prepare data to update
        map.put("name", empName);
        map.put("salary", empSal);
        map.put("age", empAge);

        // Set base URI and base path
        RestAssured.baseURI = "http://dummy.restapiexample.com";
        RestAssured.basePath = "/api/v1/update/" + emp_id;
    }

    @Test
    public void testPUT() {
        // Send PUT request
        given()
            .contentType("application/json") // Set content type to JSON
            .body(map) // Attach the request body
        .when()
            .put() // Perform PUT operation
        .then()
            .log().all() // Log response for debugging
            .statusCode(anyOf(equalTo(200), equalTo(409))); // Allowable status codes
    }
}
