package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Badge;
import WebbAppPVT15Grupp2.Models.UserBadge;
import WebbAppPVT15Grupp2.Repositories.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserBadgeService {

    @Autowired
    BadgeRepository repository;

    @RequestMapping(value = "/userbadge", method = RequestMethod.GET)
    public ResponseEntity<List<Badge>> getAllBadges() {

        Iterable<Badge> badges = repository.getAllBadges();

        List<UserBadge> target = new ArrayList<>();
        badges.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.OK);

    }

    @RequestMapping(value = "/userbadge", method = RequestMethod.POST)
    public ResponseEntity<?> submitUserBadge(@RequestBody UserBadge addUserBadge, UriComponentsBuilder ucBuilder) {
        repository.sproc_add_user_badge(addUserBadge.getUser(), addUserBadge.getBadge());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    /*@RequestMapping(value = "/userbadge", method = RequestMethod.GET)
    public Iterable<UserBadge> findAllUserBadges() {
        return repository.findAll();
    }*/
}
