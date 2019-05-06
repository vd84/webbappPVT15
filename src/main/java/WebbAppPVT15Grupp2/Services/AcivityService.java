package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Activity;
import WebbAppPVT15Grupp2.Repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class AcivityService {
    @Autowired
    ActivityRepository repository;

    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    public ResponseEntity<?> submitUser(@RequestBody Activity addActivity, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating User : {}", addActivity);
        repository.sproc_add_activity(addActivity.getCreatedby(),addActivity.getName(),addActivity.getDescription(),addActivity.getResponsibleuser(),addActivity.getAlternativelocation(),addActivity.getCategory(),addActivity.getResource());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/User/{id}").buildAndExpand(addActivity.getId()).toUri());
        System.out.println(headers.getLocation());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);


    }

    @GetMapping("/activity")
    public Iterable<Activity> findAllActivities() {
        return repository.findAll();
    }

    @RequestMapping(value = "/activity/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getActivityById(@PathVariable("id") int id) {
        //logger.info("Fetching user by id {}", id);
        Activity activity = repository.findById((int) id).get();

        if (activity == null) {
            //logger.error("User with id {} not found.", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Activity>(activity, HttpStatus.OK);


    }




}
