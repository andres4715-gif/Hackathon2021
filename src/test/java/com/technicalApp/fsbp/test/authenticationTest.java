package com.technicalApp.fsbp.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technicalApp.fsbp.models.authentication;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class authenticationTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test(enabled = true, priority = 1, description = "POST Account Authenticate")
    public void authenticateTestPost() throws JsonProcessingException {
        String url = "https://cwh-uat.firestonebpco.com/api/authenticate";
        authentication bp1 = new authentication();
        bp1.setUserName("dunant");
        bp1.setUserParam("Pass-999");
        bp1.setCountryCode("us");
        bp1.setRememberMe(false);

        String json = MAPPER.writeValueAsString(bp1);
        System.out.println("***************" + json);

        Response response = RestAssured
                .given()
                .contentType("application/json")
                .log().all(true).body(json).post(url).andReturn();

        System.out.println("The status code is: " + response.getStatusCode());
        assertEquals(response.getStatusCode(),200, "Check Status code");
    }
}
