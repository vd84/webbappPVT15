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

import static WebbAppPVT15Grupp2.Models.Badges_Enum.*;

@RestController
@CrossOrigin("*")
public class CheckinActivityService {
    @Autowired
    CheckinActivityRepository repository;

    @Autowired
    BadgeRepository badgeRepository;

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "User already checked in to this activity")
    public class alreadyCheckedin extends RuntimeException {

    }

    @RequestMapping(value = "/checkinactivity", method = RequestMethod.POST)
    public ResponseEntity<List<Badge>> checkinOnActivity(@RequestBody CheckinActivity checkinactivity) {
        try {
            Iterable<CheckinActivity> myCheckins = repository.addCheckinActivityToUser(String.valueOf(checkinactivity.getUserid()), String.valueOf(checkinactivity.getActivityid()));
            List<CheckinActivity> myCheckinArray = new ArrayList<>();
            myCheckins.forEach(myCheckinArray::add);

            try {
                Iterable<Badge> addedBadge;
                List<Badge> newBadges = new ArrayList<>();

                switch (myCheckinArray.size()) {
                    case 1:
                        addedBadge = badgeRepository.addBadgeToUser(checkinactivity.getUserid(), FIRST_TIME_PARTICIPANT.getId());
                        addedBadge.forEach(newBadges::add);
                        break;
                    case 3:
                        addedBadge = badgeRepository.addBadgeToUser(checkinactivity.getUserid(), THIRD_TIME_PARTICIPANT.getId());
                        addedBadge.forEach(newBadges::add);
                        break;
                    case 5:
                        addedBadge = badgeRepository.addBadgeToUser(checkinactivity.getUserid(), FIFTH_TIME_PARTICIPANT.getId());
                        addedBadge.forEach(newBadges::add);
                        break;
                    default:
                }

                return new ResponseEntity<>(newBadges, HttpStatus.CREATED);

            } catch (DataIntegrityViolationException e) {
                System.out.println("Already have the badge");
            }

        } catch (DataIntegrityViolationException dve) {
            throw new alreadyCheckedin();
        }
        return null;
    }
}
