package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.CheckinYouthcentre;
import org.springframework.data.repository.CrudRepository;

public interface CheckinYouthcentreRepository extends CrudRepository<CheckinYouthcentre, Integer>, CheckinYouthcentreRepositoryCustom {
}
