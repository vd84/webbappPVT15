package WebbAppPVT15Grupp2.Models;

public enum Badges_Enum {


    FIRST_TIME_VISITOR(1),
    FIRST_TIME_PARTICIPANT(21);

    private int id;
        Badges_Enum(int id){
            this.id = id;
        }

    public int getId() {
        return id;
    }
}
