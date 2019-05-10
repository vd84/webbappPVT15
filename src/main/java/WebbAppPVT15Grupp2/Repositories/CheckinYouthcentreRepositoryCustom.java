package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.CheckinYouthcentre;

import java.util.List;

public interface CheckinYouthcentreRepositoryCustom {
    List<CheckinYouthcentre> addCheckinToUser(String user, String youthcentre);
}
