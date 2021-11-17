package com.practicing.com;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class postDemoReqres {

    @BeforeSuite
    void setUp() {
        System.out.println("Initial Setup for fake api POST method");
    }

    @AfterSuite
    void tearDown() {
        System.out.println("TearDown fake api POST method");
    }

    @Test
    void postRequestFakeApi() {
        RestAssured.baseURI = "http://localhost:3000/students/";
        String userData = "{\"name\":\"Montebellanitados\",\"lastName\":\"Estradasmias\",\"age\":\"30\",\"id\":6}";
        given().body(userData)
                .when()
                .post()
                .then().log().all()
                .assertThat().statusCode(201)
                .body("id", is(notNullValue()));
    }

    @Test
    void getRequestFakeApi2() {
        System.out.println("Just this is a second test fake api apply for POST method");
    }
}
