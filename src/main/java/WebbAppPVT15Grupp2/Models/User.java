package WebbAppPVT15Grupp2.Models;

public class User {

    private long id;
    private String name;

    public User (long id, String name){
            this.id = id;
            this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
