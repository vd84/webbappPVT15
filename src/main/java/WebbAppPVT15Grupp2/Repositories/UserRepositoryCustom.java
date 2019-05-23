package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnUser;

import java.util.List;

public interface UserRepositoryCustom {

    List<ReturnUser> getAllUsers();

    List<ReturnUser> getOneUser(String id);

    List<ReturnUser> login(String userName, String password, String isfacebookuser);

    List<ReturnUser> addUser(String userName, String displayName, String password, String currentYouthCentre, String isFacebookUser);

    List<ReturnUser> modifyUser(String id, String username, String displayname, String password, String active, String points, String fairplaypoints, String currentyouthcentre, String role, String isFacebookUser, String image);

}