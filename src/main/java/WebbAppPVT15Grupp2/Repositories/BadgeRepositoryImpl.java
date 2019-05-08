package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Badge;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class BadgeRepositoryImpl implements BadgeRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Badge> getAllBadges() {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_get_all_badges");

        return storedProc.getResultList();

    }
    @Override
    public List<Badge> getOneBadge(int id) {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_one_badge");

        storedProc.registerStoredProcedureParameter(id, int.class, ParameterMode.IN);

        storedProc.setParameter(id, id);

        return storedProc.getResultList();
    }
}
