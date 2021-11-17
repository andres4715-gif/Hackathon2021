package com.practicing.com;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getDemoReqres {

    @BeforeSuite
    void setUp() {
        System.out.println("Initial Setup for fake api");
    }

    @AfterSuite
    void tearDown() {
        System.out.println("TearDown fake api");
    }

    @Test
    void getRequestFakeApi() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        given().
                queryParam("page", "2")
                .body("")
                .when()
                .get()
                .then()
                .assertThat().statusCode(200)
                .body("page", equalTo(2));
    }

    @Test
    void getRequestFakeApi2() {
        System.out.println("Just this is a second test fake api");
    }
}
