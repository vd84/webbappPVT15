/*
package WebbAppPVT15Grupp2.Services;


import WebbAppPVT15Grupp2.Models.ReturnActivityParticipation;
import WebbAppPVT15Grupp2.Repositories.ReturnActivityParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ReturnActivityParticipationService {
    @Autowired
    ReturnActivityParticipationRepository repository;

    @RequestMapping(value = "/participation/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getParticipationByActivity(@PathVariable("id") int id){
        Iterable<ReturnActivityParticipation> participations = repository.getParticipationByActivity(id);

        List<ReturnActivityParticipation> target = new ArrayList<>();
        participations.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);

    }
}
*/
