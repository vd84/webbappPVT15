package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Activity;

import java.util.List;

public interface ActivityRepositoryCustom {

    List<Activity> getAllActivities();

    List<Activity> addActivity(String createdby, String responsibleUser, String activityname, String description, String altLocation, String isSuggestion, String category, String resource, String challenger, String challenged);

    List<Activity> getAllMyActivites(String id);

    List<Activity> getAllMyActivitesChallenged(String id);

    List<Activity> modifyActivity(int id, String name, String description, int responsibleUser, String alternativeLocation, int isSuggestion, int isActive, int category, int resource, int challenger, int challenged, int isCompleted);
}