package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Usercheckin;
import org.springframework.data.repository.CrudRepository;

public interface CheckinRepository extends CrudRepository<Usercheckin, Integer>, CheckinRepositoryCustom {
}
