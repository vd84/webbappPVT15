package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnYouthcentre;
import org.springframework.data.repository.CrudRepository;

public interface YouthcentreRepository extends CrudRepository<ReturnYouthcentre, Integer>, YouthCentreRepositoryCustom {

}