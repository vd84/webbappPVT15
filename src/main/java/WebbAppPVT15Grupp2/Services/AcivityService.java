package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Activity;
import WebbAppPVT15Grupp2.Repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AcivityService {
    @Autowired
    ActivityRepository repository;

    @RequestMapping(value = "/activity", method = RequestMethod.POST)
    public ResponseEntity<?> addActivity(@RequestBody Activity addActivity, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating User : {}", addActivity);
        Iterable<Activity> users = repository.addActivity(String.valueOf(addActivity.getCreatedby()),addActivity.getStartdate(), addActivity.getEnddate(), String.valueOf(addActivity.getResponsibleuser()), addActivity.getName(), addActivity.getDescription(), addActivity.getAlternativelocation(), String.valueOf(addActivity.getIssuggestion()), String.valueOf(addActivity.getCategory()), String.valueOf(addActivity.getResource()), String.valueOf(addActivity.getChallenger()), String.valueOf(addActivity.getChallenged()));

        List<Activity> target = new ArrayList<>();
        users.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.CREATED);

    }

    @GetMapping("/allActivity")
    public Iterable<Activity> findAllActivities() {
        return repository.findAll();
    }

    @RequestMapping(value = "/activity", method = RequestMethod.GET)
    public ResponseEntity<?> getAllActivites() {
        //logger.info("Fetching user by id {}", id);
        Iterable<Activity> allActivities = repository.getAllActivities();

        List<Activity> target = new ArrayList<>();
        allActivities.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }


    @RequestMapping(value = "/activity/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMyAcitivies(@PathVariable("id") int id) {
        //logger.info("Fetching user by id {}", id);
        Iterable<Activity> myActivites = repository.getAllMyActivites(String.valueOf(id));

        List<Activity> target = new ArrayList<>();
        myActivites.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @RequestMapping(value = "/activityChallenged/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMyAcitiviesChallenged(@PathVariable("id") int id) {
        //logger.info("Fetching user by id {}", id);
        Iterable<Activity> myActivites = repository.getAllMyActivitesChallenged(String.valueOf(id));

        List<Activity> target = new ArrayList<>();
        myActivites.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @RequestMapping(value = "/activity", method = RequestMethod.PUT)
    public ResponseEntity<?> modifyUser(@RequestBody Activity modActivity) {

        Iterable<Activity> changedActivity = repository.modifyActivity(modActivity.getId(),modActivity.getStartdate(),modActivity.getEnddate(), modActivity.getName(), modActivity.getDescription(), modActivity.getResponsibleuser(), modActivity.getAlternativelocation(), modActivity.getIssuggestion(), modActivity.getIsactive(), modActivity.getCategory(), modActivity.getResource(), modActivity.getChallenger(), modActivity.getChallenged(), modActivity.getCompleted(), modActivity.getWinner(), modActivity.getChallengeaccepted(),modActivity.getChallengerejected());

        List<Activity> target = new ArrayList<>();
        changedActivity.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @RequestMapping(value = "/activity/youthcentre/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getActivityByYouthcentre(@PathVariable("id") int id) {
        //logger.info("Fetching user by id {}", id);
        Iterable<Activity> youthcentreActivities = repository.getAllActivitiesByYouthCentre(id);

        List<Activity> target = new ArrayList<>();
        youthcentreActivities.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }
}
