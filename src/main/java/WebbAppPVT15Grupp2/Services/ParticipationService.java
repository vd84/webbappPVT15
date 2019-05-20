package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Activity;
import WebbAppPVT15Grupp2.Models.Participation;
import WebbAppPVT15Grupp2.Models.ReturnActivityParticipation;
import WebbAppPVT15Grupp2.Repositories.ParticipationRepository;
//import WebbAppPVT15Grupp2.Repositories.ReturnActivityParticipationRepository;
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


    @RequestMapping(value = "/participation/delete", method = RequestMethod.POST)
    public ResponseEntity<?> deleteParticipation(@RequestBody Participation deleteParticipation, UriComponentsBuilder ucBuilder) {
        Iterable<Participation> deletedParticipant = repository.deleteParticipation(deleteParticipation.getUser(), deleteParticipation.getActivity());

        List<Participation> target = new ArrayList<>();
        deletedParticipant.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @RequestMapping(value = "/participationbyactivity/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getParticipationByActivity(@PathVariable("id") int id){
        Iterable<ReturnActivityParticipation> participations = repository.getParticipationByActivity(id);

        List<ReturnActivityParticipation> target = new ArrayList<>();
        participations.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);

    }


}
