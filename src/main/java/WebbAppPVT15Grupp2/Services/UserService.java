package WebbAppPVT15Grupp2.Services;


import WebbAppPVT15Grupp2.Models.User;
import WebbAppPVT15Grupp2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class UserService {
    @Autowired
    UserRepository respository;

    @GetMapping("/user")
    public Iterable<User> findAllUsers(){
        return respository.findAll();
    }
}
