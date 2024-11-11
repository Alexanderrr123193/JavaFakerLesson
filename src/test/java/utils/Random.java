package utils;

import com.github.javafaker.Faker;
import java.util.concurrent.ThreadLocalRandom;

public class Random {
    private final Faker faker = new Faker();

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    private int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getRandomSubject() {
        String[] subjects = {"Accounting", "Maths", "Arts", "Social Studies",
                "Chemistry", "Computer Science", "Commerce",
                "Physics", "Economics"};
        return getRandomItemFromArray(subjects);
    }

    public String getUserHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return states[faker.random().nextInt(states.length)];
    }

    public String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jodhpur");
            default:
                return "City not found";
        }
    }

    public String getRandomPicture() {
        String[] pictures = {"picture.png", "picture1.png", "picture2.png"};
        return faker.options().option(pictures);
    }

    public class TestDataGenerator {
        public String[] getRandomDateOfBirth() {
            int day = getRandomInt(1, 28);
            int monthIndex = getRandomInt(0, 11);
            String[] months = {
                    "January", "February", "March", "April", "May", "June",
                    "July", "August", "September", "October", "November", "December"
            };
            String month = months[monthIndex];
            int year = getRandomInt(1900, 2024);
            return new String[]{String.valueOf(day), month, String.valueOf(year)};
        }
    }
}
