package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.UserBadge;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

public interface UserBadgeRepository extends CrudRepository<UserBadge, Integer> {

    @Procedure
    void sproc_add_user_badge(
            int user,
            int badge
    );
}
