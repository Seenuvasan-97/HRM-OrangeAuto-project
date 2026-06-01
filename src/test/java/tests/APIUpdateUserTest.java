package tests;

import base.APIBaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payLoads.CreateUserPayload;
import utilities.TestDataBuilder;

public class APIUpdateUserTest extends APIBaseTest {
    @Test
    public void verifyUpdateUser(){
        CreateUserPayload payload = TestDataBuilder.updateUserPayload();
        Response response = request.pathParam("userId",2).body(payload)
                .when().put("/api/users/{userId}").then().extract().response();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
        String name = response.jsonPath().getString("name");
        String job = response.jsonPath().getString("job");
        String updatedAt = response.jsonPath().getString("updatedAt");
        Assert.assertEquals(name, "Seenu");
        Assert.assertEquals(job, "Senior Automation Tester");
        Assert.assertNotNull(updatedAt);
        System.out.println("User Updated Successfully");
    }
}
