package WebbAppPVT15Grupp2.Repositories;
import WebbAppPVT15Grupp2.Models.Badge;

import org.springframework.data.repository.CrudRepository;

public interface BadgeRepository extends CrudRepository<Badge, Integer>, BadgeRepositoryCustom {
}
