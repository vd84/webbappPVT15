package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Activity;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;

public interface ActivityRepository extends CrudRepository<Activity, Integer> {

    @Procedure
    void sproc_add_activity(int in_createdBy,
                       String in_name,
                       String in_description ,
                       int in_responsibleUser,
                       String in_alternativeLocation,
                       int in_category,
                       int in_resource);
}
