package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Challenge;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class ChallengeRepositoryImpl implements ChallengeRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Challenge> addChallenge(String name, String challenger, String challenged, String responsibleuser, String activity) {
        StoredProcedureQuery storedProc =
                em.createNamedStoredProcedureQuery("sproc_add_challange");


        storedProc.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        storedProc.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);




        storedProc.setParameter(1, name);
        storedProc.setParameter(2, challenger);
        storedProc.setParameter(3, challenged);
        storedProc.setParameter(4, responsibleuser);
        storedProc.setParameter(5, activity);




        return storedProc.getResultList();


    }
}
