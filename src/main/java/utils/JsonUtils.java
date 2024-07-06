package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String, Object> getJsonDataAsMap(String jsonFileName) throws IOException {
        String completeJsonFilePath = System.getProperty("user.dir") + "/src/main/resources/" + jsonFileName + ".json";
        Map<String,Object> data;
        data = objectMapper.readValue(new File(completeJsonFilePath), new TypeReference<>() {});
        return data;
    }
}
