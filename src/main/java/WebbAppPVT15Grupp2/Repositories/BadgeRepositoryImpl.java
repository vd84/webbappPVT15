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
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_all_badges");

        return storedProc.getResultList();

    }
    @Override
    public List<Badge> getUsersBadges(int id) {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_users_badges");

        storedProc.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);

        storedProc.setParameter(1, id);

        return storedProc.getResultList();
    }

    @Override
    public List<Badge> getYouthcentreBadges(int id) {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_badge_by_youthcentreid");

        storedProc.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);

        storedProc.setParameter(1, id);

        return storedProc.getResultList();
    }

}
