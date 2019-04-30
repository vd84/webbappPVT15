package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Hello;
import WebbAppPVT15Grupp2.Models.PUser2;
import WebbAppPVT15Grupp2.Repositories.HelloRespository;
import WebbAppPVT15Grupp2.Repositories.PUser2Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class addUserService {
    @Autowired
    PUser2Repository repo;

    private static final Logger logger = LoggerFactory.getLogger(addUserService.class);

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ResponseEntity<?> submitUser(@RequestBody PUser2 pUser2, UriComponentsBuilder ucBuilder){
        logger.info("Creating User : {}", pUser2);

        if (false) {
            logger.error("Unable to create. A User with name {} already exist", pUser2.getUsername());
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        repo.sproc_add_user(pUser2.getUsername(),pUser2.getCurrent_youthcentre());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/addUser/{id}").buildAndExpand(pUser2.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);


    }
}
