package WebbAppPVT15Grupp2.Services;
import WebbAppPVT15Grupp2.Models.Badge;
import WebbAppPVT15Grupp2.Repositories.BadgeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/badge/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Badge>> getOneBadge(@PathVariable("id") int id) {

        Iterable<Badge> badges = repository.getUsersBadges(id);

        ArrayList<Badge> oneBadge = new ArrayList<>();
        badges.forEach(oneBadge::add);
        return new ResponseEntity<>(oneBadge, HttpStatus.OK);

    }
}
