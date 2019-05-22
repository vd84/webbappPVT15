package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnYouthcentre;
import WebbAppPVT15Grupp2.Models.Youthcentre;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class YouthcentreRepositoryImpl implements YouthCentreRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<ReturnYouthcentre> getAllYouthcentres(int userid) {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_all_youthcentres");

        storedProc.registerStoredProcedureParameter(1, int.class,ParameterMode.IN);

        storedProc.setParameter(1, userid);
        return storedProc.getResultList();
    }

    @Override
    public List<ReturnYouthcentre> addYouthcentre(double lon, double lat, String name) {
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_add_youthcentre");

        storedProc.registerStoredProcedureParameter(1, double.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, double.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);

        storedProc.setParameter(1, lon);
        storedProc.setParameter(2, lat);
        storedProc.setParameter(3, name);

        return storedProc.getResultList();
    }
}
