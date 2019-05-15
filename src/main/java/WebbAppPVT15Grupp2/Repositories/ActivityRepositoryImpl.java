package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Activity;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class ActivityRepositoryImpl implements ActivityRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Activity> getAllActivities() {
        return null;
    }

    @Override
    public List<Activity> addActivity(String userId, String activityName, String activityDescription, String responsibleUser,  String altlocation, String category, String resource) {

        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_add_activity");



        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);




        storedProc.setParameter(1, userId);
        storedProc.setParameter(2, activityName);
        storedProc.setParameter(3, activityDescription);
        storedProc.setParameter(4, responsibleUser);
        storedProc.setParameter(5, altlocation);
        storedProc.setParameter(6, category);
        storedProc.setParameter(7, resource);





        return storedProc.getResultList();



    }
}
