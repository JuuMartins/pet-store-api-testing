package factory;

import com.github.javafaker.Faker;
import entities.User;
public class UserFactory {

    private static Faker faker = new Faker();

    public static User generateUser() {
        User user = new User();
        user.setId(faker.number().numberBetween(1, 99));
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        user.setPassword(faker.number().toString());
        user.setPhone(faker.phoneNumber().toString());
        user.setUserStatus(faker.number().randomDigit());
        return user;
    }
}

