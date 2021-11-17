package com.fsbp.com.account.post;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountAuthenticate {

    @Test(enabled = true, priority = 1, description = "POST Account Authenticate")
    public void AccountAuthentication() {
        RestAssured.baseURI = "https://cwh-uat.firestonebpco.com/api";
        RequestSpecification httpRequestAuthentication = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "dunant");
        requestParams.put("userParam", "Pass-999");
        requestParams.put("countryCode", "us");
        requestParams.put("rememberMe", "false");
        httpRequestAuthentication.header("Content-Type", "application/json");
        httpRequestAuthentication.body(requestParams.toString());
        Response responseAuthentication = httpRequestAuthentication.post("/authenticate");

        JsonPath jsonPathEvaluator = responseAuthentication.jsonPath();
        String licenseNumber = jsonPathEvaluator.get("licenseNumber");
        String email = jsonPathEvaluator.get("email");
        String familyName = jsonPathEvaluator.get("familyName");

        int getStatusCode = responseAuthentication.getStatusCode();
        Assert.assertTrue(getStatusCode == 200, "The status code is " + getStatusCode
                + " please check because the status code should be 200");

        /*
        Assert.assertEquals(licenseNumber, "0040099999", "Check licenseNumber "
           //      + licenseNumber + " because it is not expected value");
        Assert.assertEquals(email, "HornadayScott@bfdp.com", "Check email for this user: " +
                familyName + " because it is not the expecter value");
        Assert.assertEquals(familyName, "Dunant", "Check familyName for this user: " +
                familyName + " because it is not the expecter value");
                
         */

        System.out.println("The status code is: " + responseAuthentication.getStatusCode());
        System.out.println(responseAuthentication.body().asString());
        System.out.println("licenseNumber: " + licenseNumber);
        System.out.println("Email: " + email);
        System.out.println("familyName: " + familyName);
    }
}
