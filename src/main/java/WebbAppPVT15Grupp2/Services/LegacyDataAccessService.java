package WebbAppPVT15Grupp2.Services;

import WebbAppPVT15Grupp2.Models.ReturnUser;
import WebbAppPVT15Grupp2.Models.User;
import WebbAppPVT15Grupp2.Repositories.LegacyDataAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
public class LegacyDataAccessService implements LegacyDataAccessRepository {

    @Autowired
    private LegacyDataAccessRepository repository;



    @RequestMapping(value = "/legacy2", method = RequestMethod.GET)
    public ResponseEntity<List<ReturnUser>> addUser(){
        Iterable<ReturnUser> returnUser = repository.getSomeLegacyData();

        List<ReturnUser> target = new ArrayList<>();
        returnUser.forEach(target::add);
        return new ResponseEntity<>(target, HttpStatus.OK);


    }


     /*@PersistenceContext
    private EntityManager entityManager;*/

    /*@RequestMapping(value = "/legacy2", method = RequestMethod.GET)
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

    }*/

}
