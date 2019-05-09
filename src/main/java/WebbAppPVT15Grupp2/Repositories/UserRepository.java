package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<ReturnUser, Integer>, UserRepositoryCustom {

}


