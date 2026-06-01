package tests;

import base.APIBaseTest;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payLoads.CreateUserPayload;
import utilities.TestDataBuilder;

import javax.sound.midi.Soundbank;
import java.net.http.HttpResponse;

public class APICreateUserTest extends APIBaseTest {
    @Test
    public void verifyUserCreation(){
        CreateUserPayload payload = TestDataBuilder.createUserPayload();
        // Send POST request
        Response response = request.body(payload).when().post("/api/users")
                .then().extract().response();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),201);
        String name = response.jsonPath().getString("name");
        String job = response.jsonPath().getString("job");
        String id = response.jsonPath().getString("id");
        Assert.assertEquals(name, "Seenu");
        Assert.assertEquals(job, "Automation Tester");
        Assert.assertNotNull(id);

        System.out.println("User Created Successfully");
    }
}
