package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.CheckinActivity;

import java.util.List;

public interface CheckinActivityRepositoryCustom {
    List<CheckinActivity> addCheckinActivityToUser(String userid, String activityid);
}
