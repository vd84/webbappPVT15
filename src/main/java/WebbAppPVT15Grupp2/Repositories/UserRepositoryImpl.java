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
    public List<ReturnUser> modifyUser(String id, String username, String password, String active, String points, String fairplaypoints, String ) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_update_user");

        String firstParam = id;
        String secondParam = username;
        String thirdParam = password;
        String fourthParam = active;
        String fifthParam = points;
        String sixthParam = fairplaypoints;


        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);


        storedProc.setParameter(1, id);
        storedProc.setParameter(2, username);
        storedProc.setParameter(3, password);
        storedProc.setParameter(4, active);
        storedProc.setParameter(5, points);
        storedProc.setParameter(6, fairplaypoints);
        storedProc.setParameter(7, );
        storedProc.setParameter(8, fairplaypoints);
        storedProc.setParameter(9, fairplaypoints);
        storedProc.setParameter(10, fairplaypoints);


        return storedProc.getResultList();
    }
}
