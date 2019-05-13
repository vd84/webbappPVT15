package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnYouthcentre;
import WebbAppPVT15Grupp2.Models.Youthcentre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class YouthcentreRepositoryImpl implements YouthCentreRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<ReturnYouthcentre> getAllYouthcentres() {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_all_youthcentres");
        return storedProc.getResultList();
    }
}
