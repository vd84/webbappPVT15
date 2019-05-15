package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Activity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ActivityRepositoryImpl implements ActivityRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Activity> getAllActivities() {
        return null;
    }

    @Override
    public List<Activity> addActivity(String userId, String activityName, String activityDescription, String altlocation, String category, String resource) {
        return null;
    }
}
