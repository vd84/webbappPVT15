package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Hello;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public interface HelloRespository extends CrudRepository<Hello, Integer> {
}
