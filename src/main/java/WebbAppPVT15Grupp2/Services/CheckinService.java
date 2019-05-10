package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Usercheckin;
import WebbAppPVT15Grupp2.Repositories.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin("*")
public class CheckinService {
    @Autowired
    CheckinRepository repository;

    @RequestMapping(value = "/checkin", method = RequestMethod.POST)
    public ResponseEntity<List<Usercheckin>> checkinUser(@RequestBody Usercheckin usercheckin){
        Iterable<Usercheckin> rel = repository.addCheckinToUser(String.valueOf(usercheckin.getUser()),String.valueOf(usercheckin.getYouthcentre()));

        List<Usercheckin> target = new ArrayList<>();
        rel.forEach(target::add);


        return new ResponseEntity<>(target, HttpStatus.CREATED);
    }
}
