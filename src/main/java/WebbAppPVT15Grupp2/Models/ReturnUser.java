package WebbAppPVT15Grupp2.Models;

import javax.persistence.*;
//import java.io.Serializable;

@Entity
public class ReturnUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "points")
    private int points;
    @Column(name = "fairplaypoints")
    private int fairplaypoints;
    @Column(name = "currentyouthcentre")
    private int currentyouthcentre;
    @Column(name = "role")
    private int role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    /*private int id;
    private String username;
    private int points;
    private int fairplay_points;
    private int current_youthcentre;
    private int role;

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

    public int getFairplay_points() {
        return fairplay_points;
    }

    public void setFairplay_points(int fairplay_points) {
        this.fairplay_points = fairplay_points;
    }

    public int getCurrent_youthcentre() {
        return current_youthcentre;
    }

    public void setCurrent_youthcentre(int current_youthcentre) {
        this.current_youthcentre = current_youthcentre;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }*/
}
