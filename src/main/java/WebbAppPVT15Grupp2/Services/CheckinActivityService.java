package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Badge;
import WebbAppPVT15Grupp2.Models.CheckinActivity;
import WebbAppPVT15Grupp2.Repositories.BadgeRepository;
import WebbAppPVT15Grupp2.Repositories.CheckinActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static WebbAppPVT15Grupp2.Models.Badges_Enum.FIRST_TIME_PARTICIPANT;
import static WebbAppPVT15Grupp2.Models.Badges_Enum.FIRST_TIME_VISITOR;

@RestController
@CrossOrigin("*")
public class CheckinActivityService {
    @Autowired
    CheckinActivityRepository repository;

    @Autowired
    BadgeRepository badgeRepository;

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "User already checked in to this activity")
    public class alreadyCheckedin extends RuntimeException{

    }

    @RequestMapping(value = "/checkinactivity", method = RequestMethod.POST)
    public ResponseEntity<List<CheckinActivity>> checkinOnActivity(@RequestBody CheckinActivity checkinactivity){
        try {
            Iterable<CheckinActivity> activityCheckins = repository.addCheckinActivityToUser(String.valueOf(checkinactivity.getUserid()), String.valueOf(checkinactivity.getActivityid()));

            List<CheckinActivity> target = new ArrayList<>();
            activityCheckins.forEach(target::add);
            try {
                List<Badge> newBadge = new ArrayList<>();
                Iterable<Badge> addedBadge = badgeRepository.addBadgeToUser(checkinactivity.getUserid(), FIRST_TIME_PARTICIPANT.getId());
                addedBadge.forEach(newBadge::add);

                return new ResponseEntity<>(target, HttpStatus.CREATED);

            }catch (DataIntegrityViolationException e){
                System.out.println("Already have the badge");
            }


        }catch (DataIntegrityViolationException dve){
            throw new alreadyCheckedin();
        }
        return null;
    }
}
