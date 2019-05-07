package WebbAppPVT15Grupp2.ImplRepositories;

import WebbAppPVT15Grupp2.CustomRepositories.UserRepositoryCustom;
import WebbAppPVT15Grupp2.Models.ReturnUser;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<ReturnUser> getAllUsers() {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_get_all_users");


        return storedProc.getResultList();
    }

/*    @Override
    public List<ReturnUser> getOneUser(int id) {

        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_get_one_user");

        int firstParam = id;
        storedProc.registerStoredProcedureParameter(firstParam, String.class, ParameterMode.IN);
        storedProc.setParameter(firstParam, firstParam);


        return storedProc.getResultList();

    }*/

}
