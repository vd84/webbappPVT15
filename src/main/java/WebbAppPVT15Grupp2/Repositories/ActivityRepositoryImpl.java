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
                em.createNamedStoredProcedureQuery("`sproc_get_all_active_activities`");


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

    @Override
    public List<Activity> getAllMyActivitesChallenged(String id) {

        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_get_my_challenges");


        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);


        storedProc.setParameter(1, id);


        return storedProc.getResultList();


    }

    @Override
    public List<Activity> modifyActivity(int id, String name, String description, int responsibleUser, String alternativeLocation, int isSuggestion, int isActive, int category, int resource, int challenger, int challenged, int isCompleted, int winner, int challengeaccepted, int challengerejected) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_update_activity");

        storedProc.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(4, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(6, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(7, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(8, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(9, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(10, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(11, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(12, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(13, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(14, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(15, int.class, ParameterMode.IN);


        storedProc.setParameter(1, id);
        storedProc.setParameter(2, name);
        storedProc.setParameter(3, description);
        storedProc.setParameter(4, responsibleUser);
        storedProc.setParameter(5, alternativeLocation);
        storedProc.setParameter(6, isSuggestion);
        storedProc.setParameter(7, isActive);
        storedProc.setParameter(8, category);
        storedProc.setParameter(9, resource);
        storedProc.setParameter(10, challenger);
        storedProc.setParameter(11, challenged);
        storedProc.setParameter(12, isCompleted);
        storedProc.setParameter(13, challengeaccepted);
        storedProc.setParameter(14, challengerejected);
        storedProc.setParameter(15, winner);



        return storedProc.getResultList();
    }

    @Override
    public List<Activity> getAllActivitiesByYouthCentre(int id) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_get_activities_by_youthcentre");

        storedProc.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);





        storedProc.setParameter(1, id);



        return storedProc.getResultList();
    }
}
