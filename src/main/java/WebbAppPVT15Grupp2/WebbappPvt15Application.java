package WebbAppPVT15Grupp2;

import WebbAppPVT15Grupp2.Models.ExternalYouthCenter;
import com.github.goober.coordinatetransformation.positions.RT90Position;
import com.github.goober.coordinatetransformation.positions.WGS84Position;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.List;

import static org.aspectj.bridge.MessageUtil.fail;

@SpringBootApplication
public class WebbappPvt15Application {

    public static void main(String[] args) {
        //SpringApplication.run(WebbappPvt15Application.class, args);

        getExternal();



        SpringApplication.run(WebbappPvt15Application.class, args);

        //UserRepository repo = c.getBean(UserRepository.class);
        //repo.sproc_add_user("TestUser2", 1);

    }

    @RequestMapping("/")
    String index() {
        return "index";
    }

    private static void getExternal() {
        final String uri = "http://api.stockholm.se/ServiceGuideService/ServiceUnitTypes/af3bb542-fad5-42c5-8b8f-b9a41bbff4c2/ServiceUnits/json?apikey=56010af30b114502bfbf8db404ef41a4";

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        ResponseEntity<List<ExternalYouthCenter>> ycResponse = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<ExternalYouthCenter>>() {
        });

        List<ExternalYouthCenter> list = ycResponse.getBody();


        /**
         * konvertering av koordinater från x,y till GPS format
         */

        RT90Position position = new RT90Position(6583052, 1627548);
        WGS84Position wgsPos = position.toWGS84();


        double xPosFromLM = 6653174.343;
        double yPosFromLM = 1613318.742;

        double lat = ((double) Math.round(wgsPos.getLatitude() * 10000)) / 10000;
        double lon = ((double)Math.round(wgsPos.getLongitude() * 10000)) / 10000;

        //double lat = ((double) Math.round(rtPos.getLatitude() * 1000) / 1000);
        //double lon = ((double) Math.round(rtPos.getLongitude() * 1000) / 1000);

        System.out.println("Lat: " + lat);
        System.out.println("Lon: " + lon);

        for (ExternalYouthCenter yc : list) {
            System.out.println(yc);
        }


    }

}