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
    public class alreadyCheckedin extends RuntimeException {

    }


    @RequestMapping(value = "/checkinyouthcentre", method = RequestMethod.POST)
    public ResponseEntity<List<Badge>> checkinUser(@RequestBody CheckinYouthcentre checkinyouthcentre) {
        //public ResponseEntity<List<Badge>> checkinUser(@RequestBody CheckinYouthcentre checkinyouthcentre){

        try {
            Iterable<CheckinYouthcentre> myCheckins = repository.addCheckinYouthcentreToUser(checkinyouthcentre.getUserid(), checkinyouthcentre.getYouthcentreid());
            List<CheckinYouthcentre> myCheckinArray = new ArrayList<>();
            myCheckins.forEach(myCheckinArray::add);


            try {
                Iterable<Badge> addedBadge;
                List<Badge> newBadges = new ArrayList<>();

                switch (myCheckinArray.size()) {
                    case 1:
                        addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), FIRST_TIME_VISITOR_BADGE.getId());
                        addedBadge.forEach(newBadges::add);
                        break;
                    case 3:
                        addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), THIRD_TIME_VISITOR_BADGE.getId());
                        addedBadge.forEach(newBadges::add);
                        break;
                    case 5:
                        addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), THIRD_TIME_VISITOR_BADGE.getId());
                        addedBadge.forEach(newBadges::add);
                        break;
                    default:

                }

                return new ResponseEntity<>(newBadges, HttpStatus.CREATED);

            } catch (DataIntegrityViolationException e) {
                System.out.println("Already have the badge");
            }
            /*//Hämtar alla checkins som användaren har på youthcentre
            Iterable<CheckinYouthcentre> existingCheckins = repository.getMyYouthcentreCheckins(checkinyouthcentre.getUserid());

            //Hämtar alla badges som en användare redan har
            Iterable<Badge> ownedUserBadges = badgeRepository.getUsersBadges(checkinyouthcentre.getUserid());
            List<Badge> existingUserBadges = new ArrayList<>();
            ownedUserBadges.forEach(existingUserBadges::add);

            List<Badge> existingCheckinBadges = new ArrayList<>();
            for(Badge b : existingUserBadges){
                if(b.getBadgerange() > 1000){
                    existingCheckinBadges.add(b);
                }
            }*/


           /* //Kollar om man har FirsCheckinBadge och lägger till den på användaren om man inte har den
            boolean alreadyHaveFirstCheckinBadge = false;
            for (Badge b : existingUserBadges) {
                if (b.getId() == 1) {
                    alreadyHaveFirstCheckinBadge = true;
                }
            }*/
            /*try {
                List<Badge> newBadges = new ArrayList<>();
                //if (!alreadyHaveFirstCheckinBadge) {
                Iterable<Badge> addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), FIRST_TIME_VISITOR_BADGE.getId());

                addedBadge.forEach(newBadges::add);

                //}

                //skickar tillbaka den nya badgen
                //return new ResponseEntity<>(newBadges, HttpStatus.CREATED);
                //skickar tillbaka den länk som skapats
                return new ResponseEntity<>(newBadges, HttpStatus.CREATED);
            } catch (DataIntegrityViolationException e) {
                System.out.println("Already have the badge");
            }*/
        } catch (DataIntegrityViolationException dve) {
            throw new alreadyCheckedin();

        }
        return null;
    }
}
