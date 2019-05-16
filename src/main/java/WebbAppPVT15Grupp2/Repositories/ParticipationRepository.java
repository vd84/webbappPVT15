package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Participation;
import org.springframework.data.repository.CrudRepository;

public interface ParticipationRepository extends CrudRepository<Participation, Integer>, ParticipationRepositoryCustom {


}
