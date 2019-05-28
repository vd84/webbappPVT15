package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.CheckinYouthcentre;

import java.util.List;

public interface CheckinYouthcentreRepositoryCustom {
    List<CheckinYouthcentre> addCheckinYouthcentreToUser(int user, int youthcentre);

    List<CheckinYouthcentre> getMyYouthcentreCheckins(int userid);
}
