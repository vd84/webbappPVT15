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

        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_get_all_active_activites");


        return storedProc.getResultList();

    }

    @Override
    public List<Activity> addActivity(String createdby, String responsibleUser, String activityname, String description, String altLocation, String isSuggestion, String category, String resource, String challenger, String challenged) {

        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_add_activity");


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


        storedProc.setParameter(1, createdby);
        storedProc.setParameter(2, activityname);
        storedProc.setParameter(3, description);
        storedProc.setParameter(4, responsibleUser);
        storedProc.setParameter(5, altLocation);
        storedProc.setParameter(6, isSuggestion);
        storedProc.setParameter(7, category);
        storedProc.setParameter(8, resource);
        storedProc.setParameter(9, challenger);
        storedProc.setParameter(10, challenged);


        return storedProc.getResultList();


    }

    @Override
    public List<Activity> getAllMyActivites(String id) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_get_my_activities");


        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);


        storedProc.setParameter(1, id);


        return storedProc.getResultList();
    }

}
