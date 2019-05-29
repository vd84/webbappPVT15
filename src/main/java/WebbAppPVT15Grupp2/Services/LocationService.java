package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Location;
import WebbAppPVT15Grupp2.Repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LocationService {
    @Autowired
    LocationRepository repository;

    @GetMapping("/location")
    public Iterable<Location> findAllLocations() {
        return repository.findAll();
    }

    @GetMapping("/location/{id}")
    public ResponseEntity<?> getLocationByID(@PathVariable("id") int id) {
        Location location = repository.findById((int) id).get();
        if (location == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Location>(location, HttpStatus.OK);
    }
}
