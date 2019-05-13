package WebbAppPVT15Grupp2.Services;

//import WebbAppPVT15Grupp2.Models.Youthcentre;
import WebbAppPVT15Grupp2.Models.ReturnYouthcentre;
import WebbAppPVT15Grupp2.Models.Youthcentre;
import WebbAppPVT15Grupp2.Repositories.YouthcentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class YouthcentreService {

    @Autowired
    YouthcentreRepository repository;

    @RequestMapping(value = "/youthcentre", method = RequestMethod.GET)
    public ResponseEntity<List<ReturnYouthcentre>> getAllYouthcentres(){
        Iterable<ReturnYouthcentre> returnYouthcentres = repository.getAllYouthcentres();

        List<ReturnYouthcentre> target = new ArrayList<>();
        returnYouthcentres.forEach(target::add);

        return new ResponseEntity<>(target, HttpStatus.OK);
    }

}
