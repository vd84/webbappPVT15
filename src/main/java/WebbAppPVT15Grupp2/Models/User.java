package WebbAppPVT15Grupp2.Models;


import javax.persistence.*;

@Entity
@Table(name = "user")
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

    public long getId() {
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

    public int isActive() {
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

    public void setFairplay_points(int fairplay_points) {
        this.fairplaypoints = fairplay_points;
    }

    public String getFacebook_login() {
        return facebooklogin;
    }

    public void setFacebook_login(String facebook_login) {
        this.facebooklogin = facebook_login;
    }

    public String getFacebook_password() {
        return facebookpassword;
    }

    public void setFacebook_password(String facebook_password) {
        this.facebookpassword = facebook_password;
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
