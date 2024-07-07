package airlines;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineTests extends AirlineAPIs {

    @Test
    public void createAirline() throws IOException {

        Map payLoad = Payloads.getCreateAirLinePayloadFromMap();
        Response response = createAirline(payLoad);
        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
