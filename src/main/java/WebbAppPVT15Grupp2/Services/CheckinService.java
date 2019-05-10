package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.CheckinYouthcentre;
import WebbAppPVT15Grupp2.Repositories.CheckinYouthcentreRepository;
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
    CheckinYouthcentreRepository repository;

    @RequestMapping(value = "/checkin", method = RequestMethod.POST)
    public ResponseEntity<List<CheckinYouthcentre>> checkinUser(@RequestBody CheckinYouthcentre checkinyouthcentre){
        Iterable<CheckinYouthcentre> rel = repository.addCheckinToUser(String.valueOf(checkinyouthcentre.getUser()),String.valueOf(checkinyouthcentre.getYouthcentre()));

        List<CheckinYouthcentre> target = new ArrayList<>();
        rel.forEach(target::add);


        return new ResponseEntity<>(target, HttpStatus.CREATED);
    }
}
