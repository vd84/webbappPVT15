package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Activity;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;



public class ParticipationRepositoryImpl implements ParticipationRepositoryCustom {


    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Activity> addParticipation(int userId, int activityId) {
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_add_participation");

        storedProc.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, int.class, ParameterMode.IN);


        storedProc.setParameter(1, userId);
        storedProc.setParameter(2, activityId);



        return storedProc.getResultList();
    }
}
