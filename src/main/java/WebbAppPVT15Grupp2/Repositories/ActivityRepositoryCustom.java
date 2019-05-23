package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Activity;
import WebbAppPVT15Grupp2.Models.ReturnActivity;

import java.util.List;

public interface ActivityRepositoryCustom {

    List<Activity> getAllActivities();

    List<Activity> addActivity(String createdby,String startdate, String enddate, String responsibleUser, String activityname, String description, String altLocation, String isSuggestion, String category, String resource, String challenger, String challenged);

    List<Activity> getAllMyActivites(String id);

    List<Activity> getAllMyActivitesChallenged(String id);

    List<Activity> modifyActivity(int id, String startdate, String enddate, String name, String description, int responsibleUser, String alternativeLocation, int isSuggestion, int isActive, int category, int resource, int challenger, int challenged, int isCompleted,int winner, int challengeaccepted, int challengerejected);

    List<Activity> getAllActivitiesByYouthCentre(int id);

}