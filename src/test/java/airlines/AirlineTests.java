package airlines;


import airlines.pojos.Airline;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.AssertionUtil;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AirlineTests extends AirlineAPIs {

    @Test
    public void createAirline() throws IOException {

        Map payLoad = Payloads.getCreateAirLinePayloadFromMap();
        Response response = createAirline(payLoad);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createAirlineUsingPojo() throws IOException {

        //Airline payLoad = Payloads.getCreateAirlinePayloadFromPojo();
        Airline payLoad = new Airline();
        Response response = createAirline(payLoad);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createAirlineUsingPojoBuilder() throws IOException {

        //Airline payLoad = Payloads.getCreateAirlinePayloadFromPojo();
        Airline payLoad = new Airline().toBuilder().name("Souvik").build();
        Response response = createAirline(payLoad);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createsAirlneAndValidateResponse() throws IOException {
        Airline payLoad = new Airline().toBuilder().name("Souvik").build();
        Response response = createAirline(payLoad);

        /* first way - validate response using jsonPath
            - this method is hectic job to perform as it requires every single tags to be written explicitly.
            even if response has any extra field which is not present in the request body then the following method would not work
        */
        Assert.assertEquals(response.jsonPath().get("name"),payLoad.getName());

        // 2nd way - use ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        Airline createAirlineResponse = objectMapper.readValue(response.getBody().asString(), Airline.class);
        Assert.assertEquals(createAirlineResponse,payLoad);
    }

    @Test
    public void createAirlineAndVerfiyResponse() throws IOException {
        Airline  request = Payloads.getCreateAirlinePayloadFromPojo();
        Response response = createAirline(request);
        Map<String, Object> expectedValueMap  = new HashMap<>();

        expectedValueMap.put("id",request.getId());
        expectedValueMap.put("name",request.getName());
        expectedValueMap.put("country",request.getCountry());
        expectedValueMap.put("logo",request.getLogo());
        expectedValueMap.put("slogan",request.getSlogan());
        expectedValueMap.put("head_quaters",request.getHead_quaters());
        expectedValueMap.put("website",request.getWebsite());
        expectedValueMap.put("established",request.getEstablished());

        AssertionUtil.assertExpectedValuesWithJsonPath(response,expectedValueMap);


    }


}
