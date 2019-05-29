package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.*;
import WebbAppPVT15Grupp2.Repositories.BadgeRepository;
import WebbAppPVT15Grupp2.Repositories.CheckinYouthcentreRepository;
import WebbAppPVT15Grupp2.Repositories.UserRepository;
import WebbAppPVT15Grupp2.Repositories.YouthcentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


import static WebbAppPVT15Grupp2.Models.Badges_Enum.*;

@RestController
@CrossOrigin("*")
public class CheckinYouthcentreService {
    @Autowired
    CheckinYouthcentreRepository repository;

    @Autowired
    BadgeRepository badgeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    YouthcentreRepository youthcentreRepository;

    //response om användaren redan har loggat in på youthcentre
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "User already checked in on this youthcentre")
    public class alreadyCheckedin extends RuntimeException {
    }

    @RequestMapping(value = "/checkinyouthcentre", method = RequestMethod.POST)
    public ResponseEntity<List<Badge>> checkinUser(@RequestBody CheckinYouthcentre checkinyouthcentre) {
        List<Badge> newBadges = new ArrayList<>();
        Iterable<Badge> addedBadge;
        try {
            Iterable<CheckinYouthcentre> myCheckins = repository.addCheckinYouthcentreToUser(checkinyouthcentre.getUserid(), checkinyouthcentre.getYouthcentreid());
            List<CheckinYouthcentre> myCheckinArray = new ArrayList<>();
            myCheckins.forEach(myCheckinArray::add);

            Iterable<ReturnUser> users = userRepository.getOneUser(String.valueOf(checkinyouthcentre.getUserid()));
            ReturnUser user = users.iterator().next();

            Iterable<Badge> myBadges = badgeRepository.getUsersBadges(checkinyouthcentre.getUserid());
            List<Integer> myBadgeIdArray = new ArrayList<>();
            for (Badge mb : myBadges) {
                myBadgeIdArray.add(mb.getId());
            }

            Iterable<ReturnYouthcentre> youthcentres = youthcentreRepository.getAllYouthcentresById(0);
            List<ReturnYouthcentre> yothcentresArray = new ArrayList<>();
            youthcentres.forEach(yothcentresArray::add);

            double ycLat = 0;
            double yclon = 0;
            double cycLat = 0;
            double cyclon = 0;

            for (ReturnYouthcentre RYC : yothcentresArray) {
                if (RYC.getId() == checkinyouthcentre.getYouthcentreid()) {
                    ycLat = RYC.getLat();
                    yclon = RYC.getLon();
                }
                if (RYC.getId() == user.getCurrentyouthcentre()) {
                    cycLat = RYC.getLat();
                    cyclon = RYC.getLon();
                }
            }

            user.setTravelleddistance(user.getTravelleddistance() + (int) calculateDistance(cycLat, cyclon, ycLat, yclon));
            userRepository.modifyUserWithoutPassword(String.valueOf(user.getId()), user.getUsername(), user.getDisplayname(), "1", String.valueOf(user.getPoints()), String.valueOf(user.getFairplaypoints()), String.valueOf(user.getCurrentyouthcentre()), String.valueOf(user.getRole()), String.valueOf(user.getRole()), user.getAvatar(), user.getTravelleddistance());

            try {
                if (user.getTravelleddistance() > 3000 && !myBadgeIdArray.contains(THREE_KILOMETER_TRAVLED.getId())) {
                    addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), THREE_KILOMETER_TRAVLED.getId());
                    addedBadge.forEach(newBadges::add);
                }
                if (user.getTravelleddistance() > 5000 && !myBadgeIdArray.contains(FIVE_KILOMETER_TRAVLED.getId())) {
                    addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), FIVE_KILOMETER_TRAVLED.getId());
                    addedBadge.forEach(newBadges::add);
                }
                if (user.getTravelleddistance() > 8000 && !myBadgeIdArray.contains(EIGHT_KILOMETER_TRAVLED.getId())) {
                    addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), EIGHT_KILOMETER_TRAVLED.getId());
                    addedBadge.forEach(newBadges::add);
                }

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
                        addedBadge = badgeRepository.addBadgeToUser(checkinyouthcentre.getUserid(), FIFTH_TIME_VISITOR_BADGE.getId());
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

    private double calculateDistance(double currentYouthCentreLat, double currentYouthCentreLon, double checkinYouthcentreLat, double checkinYouthCentreLon) {


        double lon1 = currentYouthCentreLon;
        double lat1 = currentYouthCentreLat;

        double lon2 = checkinYouthCentreLon;
        double lat2 = checkinYouthcentreLat;

        int R = 6371; // km

        double x1 = lat2 - lat1;
        double dLat = toRad(x1);
        double x2 = lon2 - lon1;
        double dLon = toRad(x2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;

        return d * 1000;
    }

    private double toRad(double x) {
        return x * Math.PI / 180;
    }
}
