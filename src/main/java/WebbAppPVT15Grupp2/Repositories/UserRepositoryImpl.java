package WebbAppPVT15Grupp2.Repositories;

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

    @Override
    public List<ReturnUser> getOneUser(String id) {

        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_get_one_user");

        String firstParam = id;


        storedProc.registerStoredProcedureParameter(firstParam, String.class, ParameterMode.IN);
        storedProc.setParameter(firstParam, firstParam);


        return storedProc.getResultList();

    }

    @Override
    public List<ReturnUser> login(String userName, String password) {

        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_login");

        String firstParam = userName;
        String secondParam = password;


        storedProc.registerStoredProcedureParameter(firstParam, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(firstParam, String.class, ParameterMode.IN);

        storedProc.setParameter(firstParam, firstParam);
        storedProc.setParameter(secondParam, secondParam);


        return storedProc.getResultList();

    }

    @Override
    public List<ReturnUser> addUser(String userName, String password, String currentYouthCentre) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_add_user");
        String firstParam = userName;
        String secondParam = password;
        String thirdParam = currentYouthCentre;


        storedProc.registerStoredProcedureParameter(firstParam, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(secondParam, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(thirdParam, String.class, ParameterMode.IN);


        storedProc.setParameter(firstParam, firstParam);
        storedProc.setParameter(secondParam, secondParam);
        storedProc.setParameter(thirdParam, thirdParam);


        return storedProc.getResultList();
    }

    @Override
    public List<ReturnUser> modifyUser(String id, String username, String password, String active, String points, String fairplaypoints) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_update_user");

        String firstParam = id;
        String secondParam = username;
        String thirdParam = password;
        String fourthParam = active;
        String fifthParam = points;
        String sixthParam = fairplaypoints;


        storedProc.registerStoredProcedureParameter(firstParam, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(secondParam, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(thirdParam, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(fourthParam, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(fifthParam, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(sixthParam, String.class, ParameterMode.IN);


        storedProc.setParameter(firstParam, firstParam);
        storedProc.setParameter(secondParam, secondParam);
        storedProc.setParameter(thirdParam, thirdParam);
        storedProc.setParameter(fourthParam, fourthParam);
        storedProc.setParameter(fifthParam, fifthParam);
        storedProc.setParameter(sixthParam, sixthParam);


        return storedProc.getResultList();
    }
}
