package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Activity;
import WebbAppPVT15Grupp2.Models.Participation;
import WebbAppPVT15Grupp2.Repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ParticipationService {

    @Autowired
    ParticipationRepository repository;

    @RequestMapping(value = "/participation", method = RequestMethod.POST)
    public ResponseEntity<?> submitParticipation(@RequestBody Participation addParticipation, UriComponentsBuilder ucBuilder) {
        Iterable<Activity> addedParticipation = repository.addParticipation(addParticipation.getUser(), addParticipation.getActivity());

        List<Activity> target = new ArrayList<>();
        addedParticipation.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);    }

    @RequestMapping(value = "/participation", method = RequestMethod.GET)
    public Iterable<Participation> findAllParticipations() {
        return repository.findAll();
    }

}
