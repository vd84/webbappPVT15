package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.CheckinActivity;
import WebbAppPVT15Grupp2.Repositories.CheckinActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CheckinActivityService {
    @Autowired
    CheckinActivityRepository repository;

    @RequestMapping(value = "/checkinactivity", method = RequestMethod.POST)
    public ResponseEntity<List<CheckinActivity>> checkinOnActivity(@RequestBody CheckinActivity checkinactivity){
        Iterable<CheckinActivity> activityCheckins = repository.addCheckinActivityToUser(String.valueOf(checkinactivity.getUserid()),String.valueOf(checkinactivity.getActivityid()));

        List<CheckinActivity> target = new ArrayList<>();
        activityCheckins.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.CREATED);
    }
}
