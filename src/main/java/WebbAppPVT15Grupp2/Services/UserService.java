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

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> submitUser(@RequestBody User addUser, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", addUser);

        if (false) {
            logger.error("Unable to create. A User with name {} already exist", addUser.getUsername());
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        System.out.println(addUser.getCurrentyouthcentre());
        repository.sproc_add_user(addUser.getUsername(), addUser.getPassword(), addUser.getCurrentyouthcentre());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/addUser/{id}").buildAndExpand(addUser.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);


    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<?> modifyUser(@RequestBody User modUser, UriComponentsBuilder ucBuilder) {
        logger.info("Modefying User : {}", modUser);

        if (false) {
            logger.error("Unable to create. A User with name {} already exist", modUser.getUsername());
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        repository.sproc_update_user(modUser.getId(), modUser.getUsername(), modUser.getPassword(), modUser.isActive(), modUser.getFacebook_login(), modUser.getFacebook_password(), modUser.getCurrentyouthcentre(), modUser.getRole());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/addUser/{id}").buildAndExpand(modUser.getId()).toUri());
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
