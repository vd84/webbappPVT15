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

        storedProc.registerStoredProcedureParameter(id, String.class, ParameterMode.IN);
        storedProc.setParameter(id, id);


        return storedProc.getResultList();

    }

    @Override
    public List<ReturnUser> login(String userName, String password) {

        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_login");


        storedProc.registerStoredProcedureParameter(userName, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(password, String.class, ParameterMode.IN);

        storedProc.setParameter(userName, userName);
        storedProc.setParameter(password, password);


        return storedProc.getResultList();

    }

    @Override
    public List<ReturnUser> addUser(String userName, String password, String currentYouthCentre) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_add_user");


        storedProc.registerStoredProcedureParameter(userName, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(password, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(password, String.class, ParameterMode.IN);


        storedProc.setParameter(userName, userName);
        storedProc.setParameter(password, password);
        storedProc.setParameter(password, password);


        return storedProc.getResultList();
    }

    @Override
    public List<ReturnUser> modifyUser(String id, String userName, String password, String active, String points, String fairplaypoints, String facebooklogin, String facebookpassword, String currentYouthCentre, String role) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_update_user");


        storedProc.registerStoredProcedureParameter(id, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(userName, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(password, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(active, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(points, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(fairplaypoints, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(facebooklogin, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(facebookpassword, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(currentYouthCentre, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(role, String.class, ParameterMode.IN);



        storedProc.setParameter(id, id);
        storedProc.setParameter(userName, userName);
        storedProc.setParameter(password, password);
        storedProc.setParameter(active, active);
        storedProc.setParameter(points, points);
        storedProc.setParameter(fairplaypoints, fairplaypoints);
        storedProc.setParameter(facebooklogin, facebooklogin);
        storedProc.setParameter(facebookpassword, facebookpassword);
        storedProc.setParameter(currentYouthCentre, currentYouthCentre);
        storedProc.setParameter(role, role);


        return storedProc.getResultList();
    }
}
