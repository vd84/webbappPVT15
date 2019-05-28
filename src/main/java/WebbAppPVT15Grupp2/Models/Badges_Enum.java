package WebbAppPVT15Grupp2.Models;

public enum Badges_Enum {

    //youthcentre checkins
    FIRST_TIME_VISITOR_BADGE(1),
    THIRD_TIME_VISITOR_BADGE(11),
    FIFTH_TIME_VISITOR_BADGE(31),


    //Activity checkins
    FIRST_TIME_PARTICIPANT(21);

    private int id;
        Badges_Enum(int id){
            this.id = id;
        }

    public int getId() {
        return id;
    }
}
