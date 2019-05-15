package WebbAppPVT15Grupp2.Repositories;

import WebbAppPVT15Grupp2.Models.Challenge;

import java.util.List;

public interface ChallengeRepositoryCustom {

    List<Challenge> addChallenge(String name, String challenger, String challenged, String responsibleuser, String activity);


}
