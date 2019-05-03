package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.Activity;
import WebbAppPVT15Grupp2.Repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AcivityService {
    @Autowired
    ActivityRepository repository;

    @GetMapping("/activity")
    public Iterable<Activity> findAllUsers() {
        return repository.findAll();
    }




}
