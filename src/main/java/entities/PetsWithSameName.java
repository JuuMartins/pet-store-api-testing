package entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetsWithSameName {
    private final List<Pet> petsSold;

    public PetsWithSameName(List<Pet> petsSold) {
        this.petsSold = petsSold;
        printPetsWithSameName();
    }

    public Map<String, Integer> getPetsSoldWithSameName() {
        Map<String, Integer> namesAndQuantitySold = new HashMap<>();

        for (Pet pet : petsSold) {
            namesAndQuantitySold.merge(pet.getName(), 1, Integer::sum);
        }

        return namesAndQuantitySold;
    }

    public void printPetsWithSameName() {
        Map<String, Integer> namesAndQuantitySold = getPetsSoldWithSameName();

        System.out.println("Pets sold with the same name:");
        for (Map.Entry<String, Integer> entry : namesAndQuantitySold.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
