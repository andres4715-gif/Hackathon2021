package com.practicing.com;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getDemo {

    @BeforeSuite
    void setUp() {
        System.out.println("Initial Setup");
    }

    @AfterSuite
    void tearDown() {
        System.out.println("TearDown");
    }

    @Test
    void getRequest() {
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.basePath = "students";
        given().when().get().then().log().all().statusCode(200);
    }

    @Test
    void getRequest2() {
        System.out.println("Just this is a second test");
    }
}
