package WebbAppPVT15Grupp2.Services;


import WebbAppPVT15Grupp2.Models.Hello;
import WebbAppPVT15Grupp2.Repositories.HelloRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class HelloService {
    @Autowired
    HelloRespository respository;

    public static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Iterable<Hello> findAllHellos(){
        return respository.findAll();
    }

    @RequestMapping(value = "/hello{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findHelloById(@PathVariable("id") int id){
        logger.info("Fetching user by id {}", id);
        Hello hello = respository.findById(id).get();
        if(hello == null){
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Hello>(hello, HttpStatus.OK);

    }




    @PostMapping("/hello")
    public Hello submitAHello(@RequestBody Hello hello){
        return respository.save(hello);
    }

}
