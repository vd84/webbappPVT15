package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Hello;
import WebbAppPVT15Grupp2.Repositories.HelloRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class HelloService {
    @Autowired
    HelloRespository respository;

    public static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/hello")
    public Iterable<Hello> findAllHellos(){
        return respository.findAll();
    }





}





