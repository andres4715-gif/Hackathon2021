package com.practicing.com;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;

public class sod_WiltLombok {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        String url = "http://localhost:3000/comments";

        usingLombok bp1 = new usingLombok();
        bp1.setId(13);
        bp1.setBody("comment 13");
        bp1.setPostId(13);

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
