package com.practicing.com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class sod2 {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        String url = "http://localhost:3000/comments";

        withGetterAndSetterWithOutConstructor bp1 = new withGetterAndSetterWithOutConstructor();
        bp1.setId(15);
        bp1.setBody("comment 15");
        bp1.setPostId(15);

        String json = MAPPER.writeValueAsString(bp1);

        System.out.println("*************" + json);

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .log().all(true).body(json).post(url).andReturn();

        System.out.println("The status code is: " + response.getStatusCode());
        assertEquals(response.getStatusCode(),201, "HTTP Message");
    }
}
