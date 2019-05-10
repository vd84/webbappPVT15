package WebbAppPVT15Grupp2;

import WebbAppPVT15Grupp2.Models.ExternalYouthCenter;
import WebbAppPVT15Grupp2.Repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class WebbappPvt15Application {

    public static void main(String[] args) {
        //SpringApplication.run(WebbappPvt15Application.class, args);

        getExternal();



        ApplicationContext c = SpringApplication.run(WebbappPvt15Application.class, args);

        UserRepository repo = c.getBean(UserRepository.class);
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

        for (ExternalYouthCenter yc : list) {
            System.out.println(yc);
        }


    }

}