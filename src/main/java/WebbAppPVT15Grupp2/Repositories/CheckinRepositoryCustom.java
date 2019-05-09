package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Relation;

import java.util.List;

public interface CheckinRepositoryCustom {
    List<Relation> addCheckinToUser(String relationStartPoint, String relationEndPoint);
}
