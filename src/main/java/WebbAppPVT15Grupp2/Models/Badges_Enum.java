package WebbAppPVT15Grupp2.Models;

public enum Badges_Enum {

    //youthcentre checkins
    FIRST_TIME_VISITOR_BADGE(1),
    THIRD_TIME_VISITOR_BADGE(11),
    FIFTH_TIME_VISITOR_BADGE(31),

    //Activity checkins
    FIRST_TIME_PARTICIPANT(21),
    THIRD_TIME_PARTICIPANT(32),
    FIFTH_TIME_PARTICIPANT(33),

    //TraveledDistance
    THREE_KILOMETER_TRAVLED(34),
    FIVE_KILOMETER_TRAVLED(35),
    EIGHT_KILOMETER_TRAVLED(36);

    private int id;

    Badges_Enum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
