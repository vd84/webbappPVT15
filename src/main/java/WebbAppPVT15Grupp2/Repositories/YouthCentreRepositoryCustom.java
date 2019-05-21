package WebbAppPVT15Grupp2.Repositories;

//import WebbAppPVT15Grupp2.Models.Youthcentre;

import WebbAppPVT15Grupp2.Models.ReturnYouthcentre;
import WebbAppPVT15Grupp2.Models.Youthcentre;

import java.util.List;

public interface YouthCentreRepositoryCustom {
    List<ReturnYouthcentre> getAllYouthcentres();

    List<ReturnYouthcentre> addYouthcentre(double lon, double lat, String name);
}
