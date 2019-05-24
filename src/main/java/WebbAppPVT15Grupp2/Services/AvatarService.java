package WebbAppPVT15Grupp2.Services;
import WebbAppPVT15Grupp2.Models.Avatar;
import WebbAppPVT15Grupp2.Repositories.AvatarRepository;
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
public class AvatarService {
    @Autowired
    AvatarRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(BadgeService.class);

    @RequestMapping(value = "/avatar", method = RequestMethod.GET)
    public ResponseEntity<List<Avatar>> getAllAvatars() {

        Iterable<Avatar> badges = repository.getAllAvatars();

        List<Avatar> allAvatars = new ArrayList<>();
        badges.forEach(allAvatars::add);
        return new ResponseEntity<>(allAvatars, HttpStatus.OK);
    }

    @RequestMapping(value = "/avatar/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Avatar>> getUsersBadges(@PathVariable("id") int id) {

        Iterable<Avatar> avatar = repository.getUserAvatar(id);

        ArrayList<Avatar> avatars = new ArrayList<>();
        avatar.forEach(avatars::add);
        return new ResponseEntity<>(avatars, HttpStatus.OK);

    }

}
