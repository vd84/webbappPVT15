package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Avatar;

import java.util.List;

public interface AvatarRepositoryCustom {

    List<Avatar> getAllAvatars();

    List<Avatar> getUserAvatar(int id);



}