package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.PUser2;
import WebbAppPVT15Grupp2.Models.ReturnUser;
import WebbAppPVT15Grupp2.Models.User;
import WebbAppPVT15Grupp2.Repositories.PUser2Repository;
//import WebbAppPVT15Grupp2.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.management.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class PUser2Service {
    @Autowired
    PUser2Repository repo;

    @GetMapping("/getPuser2")
    public List sproc_get_all_users(){


        return repo.sproc_get_all_users();
    }
}
