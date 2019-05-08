package WebbAppPVT15Grupp2.Services;
import WebbAppPVT15Grupp2.Models.Badge;
import WebbAppPVT15Grupp2.Repositories.BadgeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class BadgeService {
    @Autowired
    BadgeRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(BadgeService.class);

    @RequestMapping(value = "/badge", method = RequestMethod.GET)
    public ResponseEntity<List<Badge>> getAllBadges() {

        Iterable<Badge> badges = repository.getAllBadges();

        List<Badge> target = new ArrayList<>();
        badges.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.OK);
    }
}
