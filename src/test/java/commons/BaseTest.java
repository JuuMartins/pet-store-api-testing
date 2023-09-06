package commons;

import entities.User;
import factory.UserFactory;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class BaseTest implements Constants {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = APP_BASE_URL;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(APP_CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();

        ResponseSpecBuilder repBuilder = new ResponseSpecBuilder();
        repBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = repBuilder.build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
