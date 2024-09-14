package com.APIAutomation.Tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class APIautomation {

	@Test
	public void getMethod() throws IOException {

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		// check for 200 Ok status code and json schema structure
		//to check json schema structure here I have used JsonschemaValidator maven dependency 
		given().log().all().when().get("posts").then().assertThat().statusCode(200)
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));

	}
}
