package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Youthcentre;
import org.springframework.data.repository.CrudRepository;

public interface YouthcentreRepository extends CrudRepository<Youthcentre, Integer>, YouthCentreRepositoryCustom{

}