package tests;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import commons.BaseTest;
import entities.Pet;
import entities.PetSold;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

// This is Exercise 2
public class ListPetsSoldTest extends BaseTest {

    @Test
    public void testFindPetsBySoldStatus() {
        Response res = findPetsByStatus("sold");

        assertEquals(200, res.getStatusCode());

        List<Pet> petsSold = PetSold.convertJsonToPetsList(res.asString());

        for (Pet petSold: petsSold) {
            System.out.println("id: "+ petSold.getId() + "\n" + "name:" + petSold.getName());
        }
    }

    private Response findPetsByStatus(String status) {
        return given()
                .queryParam("status", status)
                .when()
                .get("/pet/findByStatus");
    }
}
