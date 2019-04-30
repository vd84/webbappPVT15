package WebbAppPVT15Grupp2.Repositories;


import WebbAppPVT15Grupp2.Models.User;
import WebbAppPVT15Grupp2.Models.ReturnUser;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Procedure
    void sproc_add_user(String name, String password, int youthcentre);

    @Procedure
    List<ReturnUser> sproc_get_all_users();
}


