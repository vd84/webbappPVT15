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
    public List<ReturnUser> login(String userName, String password, String isfacebookuser) {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_login");

        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);


        storedProc.setParameter(1, userName);
        storedProc.setParameter(2, password);
        storedProc.setParameter(3, isfacebookuser);



        return storedProc.getResultList();

    }

    @Override
    public List<ReturnUser> addUser(String userName, String displayname, String password, String currentYouthCentre, String isFacebookUser) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_add_user");



        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);



        storedProc.setParameter(1, userName);
        storedProc.setParameter(2, password);
        storedProc.setParameter(3, currentYouthCentre);
        storedProc.setParameter(4, isFacebookUser);
        storedProc.setParameter(5, displayname);




        return storedProc.getResultList();
    }

    @Override
    public List<ReturnUser> modifyUser(String id, String username, String displayname, String password, String active, String points, String fairplaypoints, String currentyouthcentre, String role, String isFacebookUser, int avatar) {
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
        storedProc.registerStoredProcedureParameter(11, int.class, ParameterMode.IN);






        storedProc.setParameter(1, id);
        storedProc.setParameter(2, username);
        storedProc.setParameter(3, displayname);
        storedProc.setParameter(4, password);
        storedProc.setParameter(5, active);
        storedProc.setParameter(6, points);
        storedProc.setParameter(7, fairplaypoints);
        storedProc.setParameter(8, currentyouthcentre);
        storedProc.setParameter(9, role);
        storedProc.setParameter(10, isFacebookUser);
        storedProc.setParameter(11, avatar);



        return storedProc.getResultList();
    }

    @Override
    public List<ReturnUser> modifyUserWithoutPassword(String id, String username, String displayname, String active, String points, String fairplaypoints, String currentyouthcentre, String role, String isFacebookUser, int avatar) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_update_user_without_password");




        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(10, int.class, ParameterMode.IN);






        storedProc.setParameter(1, id);
        storedProc.setParameter(2, username);
        storedProc.setParameter(3, displayname);
        storedProc.setParameter(4, active);
        storedProc.setParameter(5, points);
        storedProc.setParameter(6, fairplaypoints);
        storedProc.setParameter(7, currentyouthcentre);
        storedProc.setParameter(8, role);
        storedProc.setParameter(9, isFacebookUser);
        storedProc.setParameter(10, avatar);



        return storedProc.getResultList();
    }




}
