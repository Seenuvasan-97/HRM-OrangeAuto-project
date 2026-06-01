package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class WeatherAPITest {
    String apiKey = "6e2f77a32d27d2b19be70e190c818bac";
    @Test
    private void verifyWeatherAPI(){
        RestAssured.baseURI = "https://api.openweathermap.org/";
        Response response = given().queryParam("q","bengaluru")
                .queryParam("appid",apiKey)
                .queryParam("units","metric")
                .header("Content-Type", "application/json")

                .when().get("/data/2.5/weather")
                .then().extract().response();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);
        String cityName = response.jsonPath().getString("name");
        Assert.assertEquals(cityName,"Bengaluru");
        String contentType = response.getContentType();
        Assert.assertTrue(contentType.contains("application/json"));



    }
}
