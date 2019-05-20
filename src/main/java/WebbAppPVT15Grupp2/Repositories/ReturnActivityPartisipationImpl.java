/*
package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnActivityParticipation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class ReturnActivityPartisipationImpl implements ReturnActivityParticipationRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ReturnActivityParticipation> getParticipationByActivity(int activityId) {
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_participation_by_activity");

        storedProc.registerStoredProcedureParameter(1,int.class, ParameterMode.IN);

        storedProc.setParameter(1, activityId);

        return storedProc.getResultList();
    }
}
*/
