package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.ReturnYouthcentre;
import WebbAppPVT15Grupp2.Repositories.YouthcentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class YouthcentreService {

    @Autowired
    YouthcentreRepository repository;

    @RequestMapping(value = "/youthcentre/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ReturnYouthcentre>> getAllYouthcentres(@PathVariable("id") int id) {
        Iterable<ReturnYouthcentre> returnYouthcentres = repository.getAllYouthcentresById(id);

        List<ReturnYouthcentre> target = new ArrayList<>();
        returnYouthcentres.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @RequestMapping(value = "/youthcentre", method = RequestMethod.POST)
    public ResponseEntity<List<ReturnYouthcentre>> addYouthcentre(@RequestBody ReturnYouthcentre addYouthcentre) {
        Iterable<ReturnYouthcentre> youthcentres = repository.addYouthcentre(addYouthcentre.getLon(), addYouthcentre.getLat(), addYouthcentre.getName());
        List<ReturnYouthcentre> target = new ArrayList<>();
        youthcentres.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }

    @RequestMapping(value = "/youthcentre", method = RequestMethod.GET)
    public ResponseEntity<List<ReturnYouthcentre>> getAllYouthcentres() {

        Iterable<ReturnYouthcentre> youthcentres = repository.findAll();
        List<ReturnYouthcentre> target = new ArrayList<>();
        youthcentres.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }
}
