package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Challenge;
import org.springframework.data.repository.CrudRepository;

public interface ChallengeRepository extends CrudRepository<Challenge, Integer>, ChallengeRepositoryCustom {
}
