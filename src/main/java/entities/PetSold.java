package entities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class PetSold {

    private PetSold() {
    }

    public static List<Pet> convertJsonToPetsList(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Pet>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
