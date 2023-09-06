package tests;

import commons.BaseTest;
import entities.User;
import factory.UserFactory;
import org.junit.Test;

import java.net.HttpURLConnection;

import static io.restassured.RestAssured.given;

public class CreateAndGetUserTest extends BaseTest {

    @Test
    public void createUserAndGetYourData() {
        User user = UserFactory.generateUser();
        testUserShouldNotExist(user);
        testCreateUserShouldReturnStatusCodeOk(user);
        testUserShouldExistByUsername(user);
    }

    private void testUserShouldNotExist(User user) {
        given()
                .pathParam("username", user.getUsername())
        .when()
                .get("/user/{username}")
        .then()
                .assertThat().statusCode(HttpURLConnection.HTTP_NOT_FOUND);
    }

    private void testCreateUserShouldReturnStatusCodeOk(User user) {
        given()
                .body(user)
        .when()
                .post("/user")
        .then()
                .assertThat().statusCode(HttpURLConnection.HTTP_OK);
    }

    private void testUserShouldExistByUsername(User user) {
        given()
                .pathParam("username", user.getUsername())
        .when()
                .get("/user/{username}")
        .then()
                .assertThat().statusCode(HttpURLConnection.HTTP_OK);
    }
}
