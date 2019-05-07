package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Participation;
import WebbAppPVT15Grupp2.Models.UserBadge;
import WebbAppPVT15Grupp2.Repositories.UserBadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class UserBadgeService {

    @Autowired
    UserBadgeRepository repository;

    @RequestMapping(value = "/userbadge", method = RequestMethod.POST)
    public ResponseEntity<?> submitUserBadge(@RequestBody UserBadge addUserBadge, UriComponentsBuilder ucBuilder) {
        repository.sproc_add_user_badge(addUserBadge.getUser(), addUserBadge.getBadge());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/userbadge", method = RequestMethod.GET)
    public Iterable<UserBadge> findAllUserBadges() {
        return repository.findAll();
    }
}
