package com.practicing.com;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firstApi {
    int contador = 1;

  /*
    CHECKINT THIS FROM THIS PAGE
    https://www.toolsqa.com/rest-assured-tutorial/
    REST API Testing – Basics

    TOPICS:
    Configure Eclipse with Rest-Assured
    REST API Test using Rest Assured
    Validate Response Status using Rest Assured
    Validate Response Header using Rest Assured
    Read JSON Response Body using Rest Assured
 */

    @Test(enabled = true, priority = 1, description = "Checking the status result")
    public void checkTheStatusResult() {
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequestPepito = RestAssured.given();
        Response responseAndres = httpRequestPepito.request(Method.GET, "/Hyderabad");
        int statusCode = responseAndres.getStatusCode();
        System.out.println("The status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200, "This enpoint: "
                + "GetWeatherDetails is returning " + statusCode + " CHeck it and try again");
    }

    @Test(enabled = true, priority = 3, description = "Easy and first way to check body")
    public void CheckBodyFirstOption() {
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequestPepito = RestAssured.given();
        Response responseAndres = httpRequestPepito.request(Method.GET, "/Hyderabad");
        responseAndres.getBody().prettyPrint();
        Assert.assertTrue(responseAndres.body().asString().contains("City"),
                "Check because this response doesn't have this specific text");
    }

    @Test(enabled = true, priority = 4, description = "Easy and second way to check body")
    public void CheckBodySecondOption() {
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/Hyderabad");
        System.out.println("Response Body is =>  " + response.asString());
        System.out.println(response.asPrettyString());
    }

    @Test(enabled = true, priority = 2, description = "Checking headers")
    public void checkingHeaders() {
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequestPepito = RestAssured.given();
        Response responseAndres = httpRequestPepito.request(Method.GET, "/Hyderabad");
        String contentTypeFirstOption = responseAndres.header("content-Type");
        String contentSecondOption = responseAndres.contentType();
        Headers allHeaders = responseAndres.headers();

        for (Header header : allHeaders) {
            System.out.println("Header " + contador
                    + " "
                    + header.getName()
                    + ": "
                    + header.getValue());
            contador += 1;
        }
        System.out.println("This is the first contentType: " + contentTypeFirstOption);
        System.out.println("This is the second contentType: " + contentSecondOption);
        String checkServer = responseAndres.header("server");
        System.out.println("The server is: " + checkServer);

        Assert.assertEquals(contentTypeFirstOption, "application/json; charset=utf-8",
                "The content-type header is different");
        Assert.assertEquals(checkServer, "nginx/1.17.10 (Ubuntu)",
                "the server header is different plese check");
        Assert.assertTrue(checkServer.equals("nginx/1.17.10 (Ubuntu)"),
                "The second option for server is different");
        Assert.assertEquals(responseAndres.getHeader("Content-Type"),
                "application/json; charset=utf-8",
                "Check Content-type cos it is not equal");
    }

    @Test(enabled = true, priority = 5, description = "Read JSON Response Body using Rest Assured")
    public void checkJsonBodyResponse() {
        RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
        RequestSpecification httpRequestPepito = RestAssured.given();
        Response responseAndres = httpRequestPepito.request(Method.GET, "/Hyderabad");
        JsonPath jsonPathEvaluator = responseAndres.jsonPath();

        // Printing
        System.out.println(responseAndres.body().asString());
        String city = jsonPathEvaluator.get("City");
        String temperature = jsonPathEvaluator.get("Temperature");
        System.out.println("City: " + city);
        System.out.println("Temperature: " + temperature);

        // Assert
        // We can try to do that also with: Temperature, Humidity, Weather Description...etc
        Assert.assertTrue(city.equals("Hyderabad"),
                "Please check the city " + jsonPathEvaluator.get("City")
                        + " is not the good response.");
    }

    // TODO: CHECK THIS PAGE: https://www.toolsqa.com/rest-assured/post-request-using-rest-assured/

  /*
    CHECKINT THIS FROM THIS PAGE
    https://www.toolsqa.com/rest-assured-tutorial/
    REST API Testing – Advance

    TOPICS:

    POST Request using Rest Assured
    Serialization and Deserialization in Java
    Deserialize Json Response
    Authentication and Authorization in REST WebServices
    PUT Request using Rest Assured
    DELETE Request using Rest Assured
 */

    @Test(enabled = true, priority = 6, description = "ow to make a POST Request using Rest Assured")
    public void postRequest() {
        RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification httpRequestPepito = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "morpheus");
        requestParams.put("job", "leader");

        // adding headers, This is the format to send the body
        httpRequestPepito.header("Content-Type", "application/json");

        // getting body
        httpRequestPepito.body(requestParams.toString());

        // getting response
        Response responseAndres = httpRequestPepito.post("/users");
        System.out.println(responseAndres.getStatusCode());
        System.out.println(responseAndres.body().asString());
        int getStatusCode = responseAndres.getStatusCode();
        Assert.assertTrue(getStatusCode == 201,
                "The status code is wrong please check it ");
    }

    // Serialization and Deserialization in Java
    // TODO CHECK THIS CLASS FOR THIS EXECUTION: SerializationRectangle
    // TODO: Continue with this link: https://www.toolsqa.com/rest-assured/serialization-and-deserialization-in-java/
    // TODO: MAIN LINK: https://www.toolsqa.com/rest-assured-tutorial/

    @Test(enabled = true, priority = 7, description = "Deserialization since another class")
    public void deserialization() {
        rectangle rect = new rectangle(18, 78);
        rect.Area(10.9, 4.7);
        rectangle.SerializeToFile(rect, "filetocheckexecution.txt");
        System.out.println("checking Deserialization");
    }

    // NEXT TOPIC:
    // move forward: https://www.toolsqa.com/rest-assured/deserialize-json-response/
    // TODO CHECK THIS TOPIC: Deserialize Json Response

    @Test(enabled = false, priority = 8, description = "Checking serializable")
    public void RegistrationSuccessful() {
        RestAssured.baseURI = "https://restapi.demoqa.com/customer";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName", "Virender"); // Cast
        requestParams.put("LastName", "Singh");
        requestParams.put("UserName", "63userf2d3d2011");
        requestParams.put("Password", "password1");
        requestParams.put("Email", "ed26dff39@gmail.com");

        request.body(requestParams.toString());
        Response response = request.post("/register");

        ResponseBody body = response.getBody();

        // Deserialize the Response body into RegistrationSuccessResponse
        registrationSuccessResponse responseBody = body.as(registrationSuccessResponse.class);

        // Use the RegistrationSuccessResponse class instance to Assert the values of
        // Response.
        Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
        Assert.assertEquals("Operation completed successfully", responseBody.Message);
    }
}
