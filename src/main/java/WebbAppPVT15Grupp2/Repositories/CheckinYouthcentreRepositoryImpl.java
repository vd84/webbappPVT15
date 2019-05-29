package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.CheckinYouthcentre;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class CheckinYouthcentreRepositoryImpl implements CheckinYouthcentreRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CheckinYouthcentre> addCheckinYouthcentreToUser(int userid, int youthcentreid) {
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_checkin_youthcentre");

        storedProc.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, int.class, ParameterMode.IN);

        storedProc.setParameter(1, userid);
        storedProc.setParameter(2, youthcentreid);

        return storedProc.getResultList();
    }

    @Override
    public List<CheckinYouthcentre> getMyYouthcentreCheckins(int userid) {
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_my_youthcentre_checkins");

        storedProc.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);

        storedProc.setParameter(1, userid);

        return storedProc.getResultList();
    }
}
