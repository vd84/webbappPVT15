package WebbAppPVT15Grupp2.Repositories;

//import WebbAppPVT15Grupp2.Models.PUser2;
import WebbAppPVT15Grupp2.Models.PUser2;
import WebbAppPVT15Grupp2.Models.ReturnUser;
import WebbAppPVT15Grupp2.Models.User;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PUser2Repository extends CrudRepository<PUser2, Integer>{
    @Procedure
    void sproc_add_user(String name, int youthcentre);

    @Procedure
    Object[] sproc_get_all_users();
}


