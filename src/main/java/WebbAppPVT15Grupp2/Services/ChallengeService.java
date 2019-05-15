package WebbAppPVT15Grupp2.Services;


import WebbAppPVT15Grupp2.Models.Challenge;
import WebbAppPVT15Grupp2.Repositories.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ChallengeService {
    @Autowired
    ChallengeRepository repository;

    @RequestMapping(value = "/challenge", method = RequestMethod.POST)
    public ResponseEntity<?> addChallenge(@RequestBody Challenge addChallenge, UriComponentsBuilder ucBuilder) {
        //logger.info("Creating User : {}", addActivity);
        Iterable<Challenge> challenges = repository.addChallenge(addChallenge.getName(), String.valueOf(addChallenge.getChallenger()), String.valueOf(addChallenge.getChallenged()), String.valueOf(addChallenge.getResponsibleUser()), String.valueOf(addChallenge.getActivity()));

        List<Challenge> target = new ArrayList<>();
        challenges.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.CREATED);

    }

    @GetMapping("/challenge")
    public Iterable<Challenge> findAllActivities() {
        return repository.findAll();
    }



}
