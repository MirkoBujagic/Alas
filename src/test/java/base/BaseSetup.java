package base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.hamcrest.Matchers.lessThan;

public class BaseSetup {

    String bearerToken = "4907dddd1a6727bc8ebea33657bc6e5c7b086c096eb7dc7557693103d527e337";

    @BeforeTest
    public void setup() {
        RequestSpecBuilder requestSpecificationBuilder = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v2")
                .setContentType(ContentType.JSON).setAccept(ContentType.JSON)
                .setConfig(RestAssured.config().objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON)));


        if (bearerToken != null) {
            requestSpecificationBuilder.addHeader("Authorization", "Bearer " + bearerToken);
        }

        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectResponseTime(lessThan(20000L)).build();

        RestAssured.requestSpecification = requestSpecificationBuilder.build();
        RestAssured.responseSpecification = responseSpecification;
    }
}