package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Usercheckin;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class CheckinRepositoryImpl implements CheckinRepositoryCustom{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Usercheckin> addCheckinToUser(String user, String youthcentre) {
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_checkin_user");

        storedProc.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2,String.class, ParameterMode.IN);


        System.out.println(user);
        System.out.println(youthcentre);
        storedProc.setParameter(1, user);
        storedProc.setParameter(2, youthcentre);

        return storedProc.getResultList();
    }
}
