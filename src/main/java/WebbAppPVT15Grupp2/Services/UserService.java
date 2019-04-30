package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.User;
import WebbAppPVT15Grupp2.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserService {
    @Autowired
    UserRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ResponseEntity<?> submitUser(@RequestBody User pUser2, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", pUser2);

        if (false) {
            logger.error("Unable to create. A User with name {} already exist", pUser2.getUsername());
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        System.out.println(pUser2.getCurrentyouthcentre());
        repository.sproc_add_user(pUser2.getUsername(), pUser2.getPassword(), pUser2.getCurrentyouthcentre());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/addUser/{id}").buildAndExpand(pUser2.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);


    }

    @GetMapping("/user")
    public Iterable<User> findAllUsers() {
        return repository.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        logger.info("Fetching user by id {}", id);
        User user = repository.findById(id).get();

        if (user == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);


    }

    @GetMapping("/getPuser2")
    public List sproc_get_all_users() {


        return repository.sproc_get_all_users();
    }
}
