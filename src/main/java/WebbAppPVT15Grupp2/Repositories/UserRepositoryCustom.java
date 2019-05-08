package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.ReturnUser;

import java.util.List;

public interface UserRepositoryCustom {

    List<ReturnUser> getAllUsers();


    List<ReturnUser> getOneUser(String id);

    List<ReturnUser> login(String userName, String password);

    List<ReturnUser> addUser(String userName, String password, String currentYouthCentre);

    List<ReturnUser> modifyUser(String id, String userName,String password, String active, String points,String fairplaypoints, String facebooklogin, String facebookpassword, String currentYouthCentre, String role);

}