package utils;

import net.datafaker.Faker;

public class RandomDataGenrator {

    public static Faker faker = new Faker();

    public static String getRandomDataFor (RandomDataTypeEnums dataTypeEnums) {
        switch (dataTypeEnums){
            case FIRSTNAME:
                return faker.name().firstName();
            case LASTNAME:
                return faker.name().lastName();
            case FULLNAME:
                return faker.name().fullName();
            case COUNTRY:
                return faker.address().country();
            case CITYNAME:
                return faker.address().cityName();
            default:
                return "No such data type found";
        }

    }
}
