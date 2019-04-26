package WebbAppPVT15Grupp2.Controllers;
/*
import WebbAppPVT15Grupp2.Models.PUser;
import WebbAppPVT15Grupp2.Repositories.PuserRepository;
//import org.kds.spring.jpa.domain.Employees;
//import org.kds.spring.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PUserController {

    @Autowired
    private PuserRepository puserRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PUser>> getAllUsers() {

        Iterable<PUser> employees = puserRepository.getAllUsers();

        List<PUser> target = new ArrayList<>();
        employees.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.OK);

    }
*/


    /*@RequestMapping(value = "/puser", method = RequestMethod.GET)
    public ResponseEntity<PUser> getAllEmployeeById(@PathVariable(name = "id") long id) {

        PUser one = puserRepository.findOne(id);
        return new ResponseEntity<PUser>(one, HttpStatus.OK);
    }*/
//}