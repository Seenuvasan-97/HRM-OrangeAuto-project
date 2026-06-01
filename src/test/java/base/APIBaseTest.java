package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import utilities.ConfigReader;

public class APIBaseTest {
    protected RequestSpecification request;
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI= ConfigReader.getProperty("apiBaseUrl");
        request = RestAssured.given().relaxedHTTPSValidation()

                // Authentication header
                .header(
                        "x-api-key",
                        ConfigReader.getProperty("reqresAPIKey")
                )
                .header("Content-Type", "application/json");

    }

}
