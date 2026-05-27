package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIreqresGet {
    @Test
    public void firstApiRequest() {

        Response response =
                RestAssured
                        .given()
                        .relaxedHTTPSValidation()
                        .when()
                        .get("https://reqres.in/api/users/2");

        System.out.println(
                response.asPrettyString()
        );

        Assert.assertEquals(
                response.statusCode(),
                401
        );

        String error =
                response.jsonPath()
                        .getString("error");

        Assert.assertEquals(
                error,
                "missing_api_key"
        );
    }
}
