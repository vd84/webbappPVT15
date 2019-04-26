package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.PUser;
import WebbAppPVT15Grupp2.Repositories.PuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class PUserService {
    @Autowired
    PuserRepository repository;

    @GetMapping("/user")
    public Iterable<PUser> findAllUsers(){
        return repository.findAll();
    }

}
