package restAssuredTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidation {

    @Test
    public void verifyJsonSchema() {
        // Set the base URI
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Send GET request and validate the JSON schema
        RestAssured.given()
            .when()
            .get("/posts/1") // Correct endpoint
            .then()
            .assertThat()
            .body(matchesJsonSchemaInClasspath("schemaData.json")); // Ensure schema file exists in classpath
    }
}