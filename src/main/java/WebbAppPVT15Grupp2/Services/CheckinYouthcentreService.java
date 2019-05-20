package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Badge;
import WebbAppPVT15Grupp2.Models.CheckinYouthcentre;
import WebbAppPVT15Grupp2.Repositories.BadgeRepository;
import WebbAppPVT15Grupp2.Repositories.CheckinYouthcentreRepository;
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
public class CheckinYouthcentreService {
    @Autowired
    CheckinYouthcentreRepository repository;

    @Autowired
    BadgeRepository badgeRepository;

    //response om användaren redan har loggat in på youthcentre
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "User already checked in on this youthcentre")
    public class alreadyCheckedin extends RuntimeException{

    }


    @RequestMapping(value = "/checkinyouthcentre", method = RequestMethod.POST)
    public ResponseEntity<List<CheckinYouthcentre>> checkinUser(@RequestBody CheckinYouthcentre checkinyouthcentre){
    //public ResponseEntity<List<Badge>> checkinUser(@RequestBody CheckinYouthcentre checkinyouthcentre){

        try {
            Iterable<CheckinYouthcentre> rel = repository.addCheckinYouthcentreToUser(String.valueOf(checkinyouthcentre.getUserid()), String.valueOf(checkinyouthcentre.getYouthcentreid()));
            List<CheckinYouthcentre> target = new ArrayList<>();
            rel.forEach(target::add);

            /*
            //Hämtar alla badges som en användare redan har
            Iterable<Badge> usersBadges = badgeRepository.getUsersBadges(checkinyouthcentre.getUserid());
            List<Badge> existingUserBadges = new ArrayList<>();
            usersBadges.forEach(existingUserBadges::add);

            //Kollar om man har FirsCheckinBadge och lägger till den på användaren om man inte har den
            boolean alreadyHaveFirstCheckinBadge = false;
            for (Badge b : existingUserBadges) {
                if (b.getId() == 1) {
                    alreadyHaveFirstCheckinBadge = true;
                }
            }*/
            try {
                List<Badge> newBadges = new ArrayList<>();
                //if (!alreadyHaveFirstCheckinBadge) {
                Iterable<Badge> addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), FIRST_TIME_VISITOR.getId());

                addedBadge.forEach(newBadges::add);

            //}

            //skickar tillbaka den nya badgen
            //return new ResponseEntity<>(newBadges, HttpStatus.CREATED);
            //skickar tillbaka den länk som skapats
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
