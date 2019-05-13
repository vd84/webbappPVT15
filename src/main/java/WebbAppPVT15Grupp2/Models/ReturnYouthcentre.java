package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_store_youthcentre",
                procedureName = "sproc_store_youthcentres",
                resultClasses = ExternalYouthCenter.class),
        @NamedStoredProcedureQuery(name = "sproc_get_all_youthcentres",
                procedureName = "sproc_get_all_youthcentres",
                resultClasses = ReturnYouthcentre.class)
})

public class ReturnYouthcentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int score;
    private int location;
    private String name;
    private double lat;
    private double lon;
    private int currentactivactivities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public int getCurrentactivactivities() {
        return currentactivactivities;
    }

    public void setCurrentactivactivities(int currentactivactivities) {
        this.currentactivactivities = currentactivactivities;
    }
}
