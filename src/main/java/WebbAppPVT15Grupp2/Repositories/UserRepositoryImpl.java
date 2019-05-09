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



        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.setParameter(1, id);


        return storedProc.getResultList();

    }

    @Override
    public List<ReturnUser> login(String userName, String password) {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_login");

        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

        storedProc.setParameter(1, userName);
        storedProc.setParameter(2, password);


        return storedProc.getResultList();

    }

    @Override
    public List<ReturnUser> addUser(String userName, String password, String currentYouthCentre) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_add_user");



        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);


        storedProc.setParameter(1, userName);
        storedProc.setParameter(2, password);
        storedProc.setParameter(3, currentYouthCentre);


        return storedProc.getResultList();
    }

    @Override
    public List<ReturnUser> modifyUser(String id, String username, String password, String active, String points, String fairplaypoints, String facebookusername, String facebookpassword, String currentyouthcentre, String role) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_update_user");




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
        storedProc.setParameter(7, facebookusername);
        storedProc.setParameter(8, facebookpassword);
        storedProc.setParameter(9, currentyouthcentre);
        storedProc.setParameter(10, role);


        return storedProc.getResultList();
    }
}
