package airlines.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.apache.commons.lang3.RandomStringUtils;
import utils.DateUtils;
import utils.RandomDataGenrator;
import utils.RandomDataTypeEnums;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {
    private String id;
    private String name=RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.FIRSTNAME);
    private String country=RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.COUNTRY);
    private String logo=RandomDataGenrator.getRandomAlphabets(25);
    private String slogan=RandomDataGenrator.getRandomAlphabets(25);
    private String head_quaters=RandomDataGenrator.getRandomDataFor(RandomDataTypeEnums.CITYNAME);
    private String website=RandomDataGenrator.gerRandomWebsiteName();
    private String established=String.valueOf(RandomDataGenrator.gerRandomNumber(1900, DateUtils.getCurrentYear()));


}
