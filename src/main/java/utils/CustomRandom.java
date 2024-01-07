package utils;

import com.github.javafaker.Faker;

public class CustomRandom {

    public static String generateFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String generatePhoneNumber() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String generatePassword() {
        Faker faker = new Faker();
        return faker.internet().password();
    }

}
