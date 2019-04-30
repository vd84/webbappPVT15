package WebbAppPVT15Grupp2.Models;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class PUser2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private boolean active;
    private int points;
    private int fairplay_points;
    private String facebook_login;
    private String facebook_password;
    private int current_youthcentre;
    private String role;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getFacebook_login() {
        return facebook_login;
    }

    public void setFacebook_login(String facebook_login) {
        this.facebook_login = facebook_login;
    }

    public String getFacebook_password() {
        return facebook_password;
    }

    public void setFacebook_password(String facebook_password) {
        this.facebook_password = facebook_password;
    }

    public int getCurrent_youthcentre() {
        return current_youthcentre;
    }

    public void setCurrent_youthcentre(int current_youthcentre) {
        this.current_youthcentre = current_youthcentre;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
