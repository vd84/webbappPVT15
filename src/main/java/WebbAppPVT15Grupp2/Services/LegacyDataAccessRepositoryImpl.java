package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.ReturnUser;
import WebbAppPVT15Grupp2.Models.User;
import WebbAppPVT15Grupp2.Repositories.LegacyDataAccessRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
public class LegacyDataAccessRepositoryImpl implements LegacyDataAccessRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/legacy2")
    @Override
    public List<ReturnUser> getSomeLegacyData(){
    //public List<ReturnUser> getSomeLegacyData(String firstParameter){
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sproc_get_all_users");

        //Set the parameters of the stored procedure.
        //String firstParam = "firstParam";
        //storedProcedure.registerStoredProcedureParameter(firstParam, String.class, ParameterMode.IN);
        //storedProcedure.setParameter(firstParam, "");

        // Call the stored procedure.
        java.util.List<Object[]> storedProcedureResults = storedProcedure.getResultList();

        // Use Java 8's cool new functional programming paradigm to map the objects from the stored procedure results
        return storedProcedureResults.stream().map(result -> new ReturnUser(
                (int) result[0],
                (String) result[1],
                (int) result[2],
                (int) result[3],
                (int) result[4],
                (String) result[5],
                (int) result[6]
        )).collect(Collectors.toList());

    }

}
