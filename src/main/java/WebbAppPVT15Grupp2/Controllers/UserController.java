package WebbAppPVT15Grupp2.Controllers;



import WebbAppPVT15Grupp2.Models.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/user")
    public User user(@RequestParam(value = "name", defaultValue = "Peter") String name){
        return new User(counter.incrementAndGet(), String.format(template, name));
    }
}
