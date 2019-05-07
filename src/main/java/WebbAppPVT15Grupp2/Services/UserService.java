package WebbAppPVT15Grupp2.Services;

//import WebbAppPVT15Grupp2.Models.ReturnUser;

import WebbAppPVT15Grupp2.Models.ReturnUser;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserService {
    @Autowired
    UserRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<ReturnUser>> getAllUsers() {

        Iterable<ReturnUser> users = repository.getAllUsers();

        List<ReturnUser> target = new ArrayList<>();
        users.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.OK);

    }

/*    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ReturnUser>> getOneUser(@PathVariable("id") int id) {



        Iterable<ReturnUser> users = repository.getOneUser(id);

        List<ReturnUser> target = new ArrayList<>();
        users.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.OK);

    }*/

    /*
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
        logger.info("Fetching user by id {}", id);

        if (!repository.existsById(id)) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        User user = repository.findById(id).get();

        return new ResponseEntity<User>(user, HttpStatus.OK);


    }*/



    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<?> submitUser(@RequestBody User addUser, UriComponentsBuilder ucBuilder) {
        logger.info("Creating User : {}", addUser);

        if (repository.existsById((int) addUser.getId())) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        String addedUserID = (repository.sproc_add_user(addUser.getUsername(), addUser.getPassword(), addUser.getCurrentyouthcentre()));


        return new ResponseEntity<User>(addUser, HttpStatus.CREATED);


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





}
