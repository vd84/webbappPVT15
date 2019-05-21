package WebbAppPVT15Grupp2;

import WebbAppPVT15Grupp2.Models.*;
import WebbAppPVT15Grupp2.Repositories.YouthcentreRepository;
import com.github.goober.coordinatetransformation.positions.RT90Position;
import com.github.goober.coordinatetransformation.positions.WGS84Position;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.aspectj.bridge.MessageUtil.fail;

@SpringBootApplication
public class WebbappPvt15Application {


    public static void main(String[] args) {
        //SpringApplication.run(WebbappPvt15Application.class, args);


        ConfigurableApplicationContext c = SpringApplication.run(WebbappPvt15Application.class, args);

        YouthcentreRepository repo = c.getBean(YouthcentreRepository.class);
        List<ReturnYouthcentre> existingYouthcentres =  ((YouthcentreRepository) repo).getAllYouthcentres();
        //Iterable<Youthcentre> tempusers = ((YouthcentreRepository) repo).getAllYouthcentres();

        List<ExternalYouthCenter> externalYouthcenters = getExternal();
        //List<ReturnYouthcentre> incomingReturnYouthcentres = new ArrayList<>();


        System.out.println(existingYouthcentres);

        /**
         * konvertering av koordinater från x,y till GPS format
         */

        RT90Position position;
        WGS84Position wgsPos;


        for (ExternalYouthCenter eyc : externalYouthcenters) {
            position = new RT90Position(eyc.getGeographicalPosition().getX(), eyc.getGeographicalPosition().getY());
            wgsPos = position.toWGS84();

            double lat = ((double) Math.round(wgsPos.getLatitude() * 10000)) / 10000;
            double lon = ((double)Math.round(wgsPos.getLongitude() * 10000)) / 10000;

            ReturnYouthcentre ryc = new ReturnYouthcentre();
            ryc.setName(eyc.getName());
            ryc.setLat(lat);
            ryc.setLon(lon);

            /*ryc.setName("DSV YouthCentre");
            ryc.setLat(59.406646);
            ryc.setLon(17.94528);*/

            //incomingReturnYouthcentres.add(ryc);
            System.out.println(eyc.getName() + " : " + eyc.getName().length());
            if (!existingYouthcentres.contains(ryc)){

                //List<ReturnYouthcentre> addedYouthcentre = ((YouthcentreRepository) repo).addYouthcentre(lon,lat,eyc.getName());
                repo.addYouthcentre(lon,lat,eyc.getName());
            }

//            System.out.println(eyc);
//            System.out.println(eyc.getName() + " - Lat: " + lat + ", Lon: " + lon);
        }


//        System.out.println("test");

       /* ActivityRepository repo = c.getBean(ActivityRepository.class);
        Iterable<Activity> tempusers = ((ActivityRepository) repo).getAllActivities();
        System.out.println(tempusers);*/

    }



    @RequestMapping("/")
    String index() {
        return "index";
    }

    private static List<ExternalYouthCenter> getExternal() {
        final String uri = "http://api.stockholm.se/ServiceGuideService/ServiceUnitTypes/af3bb542-fad5-42c5-8b8f-b9a41bbff4c2/ServiceUnits/json?apikey=56010af30b114502bfbf8db404ef41a4";

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
        ResponseEntity<List<ExternalYouthCenter>> ycResponse = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<ExternalYouthCenter>>() {
        });

        List<ExternalYouthCenter> externalYouthCenters = ycResponse.getBody();

        return externalYouthCenters;

    }


}