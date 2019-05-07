package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnUser;
import WebbAppPVT15Grupp2.Models.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface LegacyDataAccessRepository {
    List<ReturnUser> getSomeLegacyData ();
    //List<ReturnUser> getSomeLegacyData (@RequestBody User getUser, UriComponentsBuilder ucBuilder);
}
