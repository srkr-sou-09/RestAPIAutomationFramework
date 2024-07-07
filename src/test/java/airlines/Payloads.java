package airlines;

import airlines.pojos.Airline;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import utils.DateUtils;
import utils.RandomDataGenrator;
import utils.RandomDataTypeEnums;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String getCreateAirLinePayloadFromString(String id, String name, String country,String logo,
                                                 String slogan,String head_quaters, String website, String established){

        String payLoad  = "{\n" +
                "    \"_id\":\""+id+"\",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"country\": \""+country+"\",\n" +
                "    \"logo\": \""+logo+"\",\n" +
                "    \"slogan\": \""+slogan+"\",\n" +
                "    \"head_quaters\": \""+head_quaters+"\",\n" +
                "    \"website\": \""+website+"\",\n" +
                "    \"established\": \""+established+"\"\n" +
                "}";
        return payLoad;
    }

    public static Map<String,Object> getCreateAirLinePayloadFromMap(String id, String name, String country,String logo,
                                                 String slogan,String head_quaters, String website, String established){

        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("id", id);
        payload.put("name", name);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("head_quaters", head_quaters);
        payload.put("website", website);
        payload.put("established", established);
        return payload;

    }

    public static Map<String,Object> getCreateAirLinePayloadFromMap(){

        Faker faker = new Faker();
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("id", RandomStringUtils.randomAlphanumeric(8) + "-"
                        + RandomStringUtils.randomAlphanumeric(4)+"-"
                        + RandomStringUtils.randomAlphanumeric(4)+"-"
                        + RandomStringUtils.randomAlphanumeric(4)+"-"
                        + RandomStringUtils.randomAlphanumeric(12))    ;
        payload.put("name", RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.FIRSTNAME));
        payload.put("country", RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.COUNTRY));
        payload.put("logo", RandomDataGenrator.getRandomAlphabets(25));
        payload.put("slogan", RandomDataGenrator.getRandomAlphabets(25));
        payload.put("head_quaters", RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.CITYNAME));
        payload.put("website", RandomDataGenrator.gerRandomWebsiteName());
        payload.put("established", faker.number().numberBetween(1900, DateUtils.getCurrentYear()));
        return payload;
    }

    public static Airline getCreateAirlinePayloadFromPojo(){
        return Airline
                .builder()
                .id(RandomStringUtils.randomAlphanumeric(8) + "-"
                        + RandomStringUtils.randomAlphanumeric(4)+"-"
                        + RandomStringUtils.randomAlphanumeric(4)+"-"
                        + RandomStringUtils.randomAlphanumeric(4)+"-"
                        + RandomStringUtils.randomAlphanumeric(12))
                .name(RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.FIRSTNAME))
                .country(RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.COUNTRY))
                .logo(RandomDataGenrator.getRandomAlphabets(25))
                .slogan(RandomDataGenrator.getRandomAlphabets(25))
                .head_quaters(RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.CITYNAME))
                .website(RandomDataGenrator.gerRandomWebsiteName())
                .established(String.valueOf(RandomDataGenrator.gerRandomNumber(1900, DateUtils.getCurrentYear())))
                .build();

    }
}
