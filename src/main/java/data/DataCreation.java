package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataCreation {

    private static Faker faker = new Faker(new Locale("en-GB"));

    public static String fakeFullName(){return faker.gameOfThrones().character();}
    public static String randomEmail(){return faker.internet().emailAddress();}
}


