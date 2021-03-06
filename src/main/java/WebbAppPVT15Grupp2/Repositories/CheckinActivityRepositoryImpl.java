package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.CheckinActivity;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


public class CheckinActivityRepositoryImpl implements CheckinActivityRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CheckinActivity> addCheckinActivityToUser(String userid, String activityid) {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_checkin_activity");

        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

        storedProc.setParameter(1, userid);
        storedProc.setParameter(2, activityid);

        return storedProc.getResultList();
    }
}
