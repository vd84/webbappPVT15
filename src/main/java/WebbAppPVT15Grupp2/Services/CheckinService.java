package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Relation;
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
    public ResponseEntity<List<Relation>> checkinUser(@RequestBody Relation relation){
        Iterable<Relation> rel = repository.addCheckinToUser(String.valueOf(relation.getRelationStartPoint()),String.valueOf(relation.getRelationEndPoint()));

        List<Relation> target = new ArrayList<>();
        rel.forEach(target::add);


        return new ResponseEntity<>(target, HttpStatus.CREATED);
    }
}
