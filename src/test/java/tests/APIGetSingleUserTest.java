package tests;

import base.APIBaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APIGetSingleUserTest extends APIBaseTest {
    @Test
    public void verifySingleUserDetails(){
        Response response = request.pathParam("userId", 2)
                .when().get("/api/users/{userId}")
                .then().extract().response();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
        String firstName = response.jsonPath().getString("data.first_name");
        Assert.assertEquals(firstName,"Janet");
        String email = response.jsonPath().getString("data.email");
        Assert.assertTrue(email.contains("@reqres.in"));
        String contentType = response.getHeader("Content-Type");
        Assert.assertTrue(contentType.contains("application/json"));
        System.out.println("Test Passed Successfully");
    }
}
