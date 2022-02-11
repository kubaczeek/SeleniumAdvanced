package common;

import com.github.javafaker.Faker;

import java.util.Random;

public class UserFactory {

    Faker faker = new Faker();

    public User getRandomUser() {
        Random rand = new Random();

        User user = new User.UserBuilder()
                .firstName(String.valueOf(faker.name().firstName()))
                .lastName(String.valueOf(faker.name().lastName()))
                .email(String.valueOf(faker.internet().emailAddress()))
                .password(String.valueOf(faker.internet().password()))
                .socialTitle(rand.nextBoolean() ? "Mr" : "Mrs")
                .dateOfBirth(faker.number().numberBetween(10, 12) + "/"
                        + faker.number().numberBetween(10, 28) + "/"
                        + faker.number().numberBetween(1900, 2022))
                .build();
        return user;
    }

    public User getAlreadyRegisteredUser() {
        return new User.UserBuilder()
                .firstName("Jakub")
                .lastName("Cichocki")
                .email("kubas28jc@interia.pl")
                .password("Q12345")
                .socialTitle("Mr")
                .dateOfBirth("10/28/2001")
                .build();
    }
}
