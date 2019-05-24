package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Avatar;
import org.springframework.data.repository.CrudRepository;

public interface AvatarRepository extends CrudRepository<Avatar, Integer>, AvatarRepositoryCustom {
}
