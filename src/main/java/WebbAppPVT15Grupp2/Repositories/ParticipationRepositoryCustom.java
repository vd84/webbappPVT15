package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Activity;
import WebbAppPVT15Grupp2.Models.Participation;

import java.util.List;

public interface ParticipationRepositoryCustom {

    List<Activity> addParticipation(int userId, int activityId);

    List<Participation> deleteParticipation(int user, int activity);
}
