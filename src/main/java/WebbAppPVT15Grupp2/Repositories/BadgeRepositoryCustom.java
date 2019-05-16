package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Badge;

import java.util.List;

public interface BadgeRepositoryCustom {

    List<Badge> getAllBadges();

    List<Badge> getUsersBadges(int id);

    List<Badge> getYouthcentreBadges(int id);

    List<Badge> addBadgeToUser(int userid, int badgeid);

}
