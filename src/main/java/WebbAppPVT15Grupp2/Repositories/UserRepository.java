package WebbAppPVT15Grupp2.Repositories;


import WebbAppPVT15Grupp2.CustomRepositories.UserRepositoryCustom;
import WebbAppPVT15Grupp2.Models.ReturnUser;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<ReturnUser, Integer>, UserRepositoryCustom {
    @Procedure
    String sproc_add_user(String name, String password, int youthcentre);

    @Procedure
    List<ReturnUser> sproc_get_all_users();

    /**
     *
     * @param id
     * @param name
     * @param pass
     * @param active must be sent as an int 1= true and 0 = false
     * @param facebooklogin
     * @param facebookpassword
     * @param currentyouthcentre
     * @param role
     */
    @Procedure
    void sproc_update_user(long id, String name, String pass,int  active , String facebooklogin, String facebookpassword,int currentyouthcentre, int role);
}


