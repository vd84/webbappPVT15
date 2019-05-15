package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Activity;

import java.util.List;

public interface ActivityRepositoryCustom {

    List<Activity> getAllActivities();

    List<Activity> addActivity(String userId, String activityName, String activityDescription, String responsibleUser,  String altlocation, String category, String resource);


}