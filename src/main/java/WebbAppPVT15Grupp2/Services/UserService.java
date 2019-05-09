package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.ReturnUser;
import WebbAppPVT15Grupp2.Models.User;
import WebbAppPVT15Grupp2.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ReturnUser>> getOneUser(@PathVariable("id") int id) {


        Iterable<ReturnUser> users = repository.getOneUser(String.valueOf(id));

        List<ReturnUser> target = new ArrayList<>();
        users.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.OK);

    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<List<ReturnUser>> login(@RequestBody User loginUser) {
        Iterable<ReturnUser> users = repository.login(loginUser.getUsername(), loginUser.getPassword());
            List<ReturnUser> target = new ArrayList<>();
            users.forEach(target::add);
        if (((List<ReturnUser>) users).size() != 0) {
            return new ResponseEntity<>(target, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(target, HttpStatus.NO_CONTENT);
        }
    }



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
    public ResponseEntity<?> submitUser(@RequestBody User addUser) {
        logger.info("Creating User : {}", addUser);

        if (repository.existsById((int) addUser.getId())) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }

        Iterable<ReturnUser> users = repository.addUser(addUser.getUsername(), addUser.getPassword(), String.valueOf(addUser.getCurrentyouthcentre()));

        List<ReturnUser> target = new ArrayList<>();
        users.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.CREATED);
    }




    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<?> modifyUser(@RequestBody User modUser) {
        logger.info("Modefying User : {}", modUser);

        if(repository.getOneUser(String.valueOf(modUser.getId())) == null){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        Iterable<ReturnUser> users = repository.modifyUser(String.valueOf(modUser.getId()), modUser.getUsername(), modUser.getPassword(), String.valueOf(modUser.getActive()), String.valueOf(modUser.getPoints()), String.valueOf(modUser.getFairplaypoints()), modUser.getFacebooklogin(), modUser.getFacebookpassword(), String.valueOf(modUser.getCurrentyouthcentre()), String.valueOf(modUser.getRole()));

        List<ReturnUser> target = new ArrayList<>();
        users.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);


    }


}
