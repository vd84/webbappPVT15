package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnUser;
import net.bytebuddy.asm.Advice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class LegacyDataAccessImpl implements LegacyDataAccessRepositoryCustom{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ReturnUser> getSomeLegacyData() {
        StoredProcedureQuery getReturnUsers = em.createStoredProcedureQuery("sproc_add_user");
        return getReturnUsers.getResultList();
    }



}
