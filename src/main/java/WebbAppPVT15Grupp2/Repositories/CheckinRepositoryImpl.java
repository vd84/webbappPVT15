package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Relation;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class CheckinRepositoryImpl implements CheckinRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Relation> addCheckinToUser(String relationStartPoint, String relationEndPoint) {
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_checkin_user");

        storedProc.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2,String.class, ParameterMode.IN);

        storedProc.setParameter(1, relationStartPoint);
        storedProc.setParameter(2, relationEndPoint);

        return storedProc.getResultList();
    }
}
