package WebbAppPVT15Grupp2.Services;


import WebbAppPVT15Grupp2.Models.Hello;
import WebbAppPVT15Grupp2.Repositories.HelloRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findHelloById(@PathVariable("id") int id){
        logger.info("Fetching user by id {}", id);
        Hello hello = respository.findById(id).get();
        if(hello == null){
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Hello>(hello, HttpStatus.OK);

    }




    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ResponseEntity<?> submitAHello(@RequestBody Hello hello, UriComponentsBuilder ucBuilder){
        logger.info("Creating User : {}", hello);

        if (false) {
            logger.error("Unable to create. A User with name {} already exist", hello.getMessage());
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        respository.save(hello);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/hello/{id}").buildAndExpand(hello.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);

    }

}