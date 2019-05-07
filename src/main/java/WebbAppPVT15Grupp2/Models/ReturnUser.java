package WebbAppPVT15Grupp2.Models;

import javax.persistence.*;
//import java.io.Serializable;

@Entity
public class ReturnUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private int id;
    //@Column(name = "username")
    private String username;
    //@Column(name = "points")
    private int points;
    //@Column(name = "fairplaypoints")
    private int fairplaypoints;
    //@Column(name = "currentyouthcentre")
    private int currentyouthcentre;
    private String currentyouthcentrename;
    //@Column(name = "role")
    private int role;

    public ReturnUser(int id, String userName, int points, int fairPoints, int youthCentre, String youthcentrename, int role) {
        this.id = id;
        this.username = userName;
        this.points = points;
        this.fairplaypoints = fairPoints;
        this.currentyouthcentre = youthCentre;
        this.currentyouthcentrename = youthcentrename;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFairplaypoints() {
        return fairplaypoints;
    }

    public void setFairplaypoints(int fairplaypoints) {
        this.fairplaypoints = fairplaypoints;
    }

    public int getCurrentyouthcentre() {
        return currentyouthcentre;
    }

    public void setCurrentyouthcentre(int currentyouthcentre) {
        this.currentyouthcentre = currentyouthcentre;
    }

    public String getCurrentyouthcentrename() {
        return currentyouthcentrename;
    }

    public void setCurrentyouthcentrename(String currentyouthcentrename) {
        this.currentyouthcentrename = currentyouthcentrename;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
