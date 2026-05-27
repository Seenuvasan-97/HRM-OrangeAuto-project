package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIclient {
    public static Response post(
            String url,
            String payload) {

        return RestAssured
                .given()
                .header(
                        "Content-Type",
                        "application/json"
                )
                .body(payload)
                .when()
                .post(url);
    }

}
