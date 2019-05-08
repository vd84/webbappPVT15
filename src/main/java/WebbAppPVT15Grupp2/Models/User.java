package WebbAppPVT15Grupp2.Models;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private int active;
    private int points;
    private int fairplaypoints;
    private String facebooklogin;
    private String facebookpassword;
    private int currentyouthcentre;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
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

    public String getFacebooklogin() {
        return facebooklogin;
    }

    public void setFacebooklogin(String facebooklogin) {
        this.facebooklogin = facebooklogin;
    }

    public String getFacebookpassword() {
        return facebookpassword;
    }

    public void setFacebookpassword(String facebookpassword) {
        this.facebookpassword = facebookpassword;
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
}
