package tests;

import commons.BaseTest;
import entities.PetSold;
import entities.PetsWithSameName;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;

//Exercise 3
public class PetsWithSameNameTest extends BaseTest {


    //Lists all the pets with status 'sold' and checks for any duplicate names.
    @Test
    public void listPetsSoldWithSameName() {
        Response res = findPetsByStatus("sold");

        assertEquals(200, res.getStatusCode());

        PetsWithSameName petsWithSameName = new PetsWithSameName(PetSold.convertJsonToPetsList(res.asString()));

        petsWithSameName.getPetsSoldWithSameName();
    }

    private Response findPetsByStatus(String status) {
        return given()
                .queryParam("status", status)
                .when()
                .get("/pet/findByStatus");
    }
}