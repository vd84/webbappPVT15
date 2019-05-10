package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Usercheckin;

import java.util.List;

public interface CheckinRepositoryCustom {
    List<Usercheckin> addCheckinToUser(String user, String youthcentre);
}
