package utils;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;
import reporting.ExtentReportManager;
import reporting.Setup;

import java.util.*;

public class AssertionUtil {

    public static void assertExpectedValuesWithJsonPath(Response response, Map<String,Object> expectedValueMap){
        List<AssertionKeys> actualValuesMap = new ArrayList<>();
        actualValuesMap.add(new AssertionKeys("JSON_PATH","EXPECTED_VALUE","ACTUAL_VALUE","RESULT"));
        boolean allmatched = true;

        Set<String> jsonPaths = expectedValueMap.keySet();
        for (String jsonPath : jsonPaths) {
            Optional<Object>  actualValue = Optional.ofNullable(response.jsonPath().get(jsonPath));
            if(actualValue.isPresent()){
                Object value = actualValue.get();
                if(value.equals((Object) expectedValueMap.get(jsonPath)))
                    actualValuesMap.add(new AssertionKeys(jsonPath,expectedValueMap.get(jsonPath),value,"MATCHED"));
                else{
                    allmatched = false;
                    actualValuesMap.add(new AssertionKeys(jsonPath,expectedValueMap.get(jsonPath),value,"NOT_MATCHED"));
                }
            }
            else if(jsonPath.equals("id"))
                actualValuesMap.add(new AssertionKeys(jsonPath,expectedValueMap.get(jsonPath),actualValue,"SKIPPED"));
            else{
                allmatched = false;
                actualValuesMap.add(new AssertionKeys(jsonPath,expectedValueMap.get(jsonPath),"NO_VALUE_FOUND","NOT_MATCHED"));
            }
        }
        if(allmatched)
            ExtentReportManager.logPassDetails("All assertions are matched. 👍👍👍");
        else
            ExtentReportManager.logFailureDetails("All assertions are not passed. 👎👎👎");

        String[][]  finalAssertionsMap = actualValuesMap.stream()
                .map(assertions->  new String[]
                        {assertions.getJsonpath(),
                        String.valueOf(assertions.getExpectedValue()),
                        String.valueOf(assertions.getActualValue()),
                        assertions.getResult()})
                .toArray(String[][]::new);
        Setup.extentTest.get().info(MarkupHelper.createTable(finalAssertionsMap));
    }
}
