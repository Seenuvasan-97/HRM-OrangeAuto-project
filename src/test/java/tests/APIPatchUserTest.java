package tests;

import base.APIBaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestDataBuilder;

import java.util.HashMap;

public class APIPatchUserTest extends APIBaseTest {
    @Test
    public void verifyPartialUserUpdate(){
        // Build PATCH payload
        HashMap<String, Object> payload =
                TestDataBuilder.patchUserPayLoad();

        // Send PATCH request
        Response response =

                request

                        .pathParam("userId", 2)

                        .body(payload)

                        .when()

                        .patch("/api/users/{userId}")

                        .then()

                        .extract()
                        .response();

        // Print response
        System.out.println(
                response.asPrettyString()
        );

        // Status code validation
        Assert.assertEquals(
                response.statusCode(),
                200
        );

        // Response validation
        String updatedJob =
                response.jsonPath()
                        .getString("job");

        String updatedAt =
                response.jsonPath()
                        .getString("updatedAt");

        Assert.assertEquals(
                updatedJob,
                "Lead Automation Tester"
        );

        Assert.assertNotNull(updatedAt);

        System.out.println(
                "PATCH Update Successful"
        );
    }

    }

