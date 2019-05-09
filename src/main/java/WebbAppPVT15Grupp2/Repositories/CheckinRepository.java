package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Relation;
import org.springframework.data.repository.CrudRepository;

public interface CheckinRepository extends CrudRepository<Relation, Integer>, CheckinRepositoryCustom {
}
