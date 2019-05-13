package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.CheckinActivity;
import org.springframework.data.repository.CrudRepository;

public interface CheckinActivityRepository extends CrudRepository<CheckinActivity, Integer>,CheckinActivityRepositoryCustom {
}
