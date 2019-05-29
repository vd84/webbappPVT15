package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnYouthcentre;

import java.util.List;

public interface YouthCentreRepositoryCustom {
    List<ReturnYouthcentre> getAllYouthcentresById(int userid);

    List<ReturnYouthcentre> addYouthcentre(double lon, double lat, String name);
}
