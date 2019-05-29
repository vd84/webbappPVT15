package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Avatar;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class AvatarRepositoryImpl implements AvatarRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Avatar> getAllAvatars() {
        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_all_avatars");

        return storedProc.getResultList();
    }

    @Override
    public List<Avatar> getUserAvatar(int id) {

        StoredProcedureQuery storedProc = em.createNamedStoredProcedureQuery("sproc_get_users_avatar");

        storedProc.registerStoredProcedureParameter(1, int.class, ParameterMode.IN);

        storedProc.setParameter(1, id);

        return storedProc.getResultList();
    }
}