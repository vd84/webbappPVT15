package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Participation;
import WebbAppPVT15Grupp2.Repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class ParticipationService {

    @Autowired
    ParticipationRepository repository;

    @RequestMapping(value = "/participation", method = RequestMethod.POST)
    public ResponseEntity<?> submitParticipation(@RequestBody Participation addParticipation, UriComponentsBuilder ucBuilder) {
        try {
            repository.sproc_add_participation(addParticipation.getActivity(), addParticipation.getUser());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataIntegrityViolationException e){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }

    }

    @RequestMapping(value = "/participation", method = RequestMethod.GET)
    public Iterable<Participation> findAllParticipations() {
        return repository.findAll();
    }

}
