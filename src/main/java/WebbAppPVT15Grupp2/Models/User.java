package WebbAppPVT15Grupp2.Models;


import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String passWord;
    private boolean active;
    private int points;
    private int fairPlayPoints;
    private String facebookLogin;
    private String facebookPassword;
    private String currentYouthCentre;
    private String role;

    public User(String userName, String passWord, boolean active, int points, int fairPlayPoints, String facebookLogin, String facebookPassword, String currentYouthCenter, String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.active = active;
        this.points = points;
        this.fairPlayPoints = fairPlayPoints;
        this.facebookLogin = facebookLogin;
        this.facebookPassword = facebookPassword;
        this.currentYouthCentre = currentYouthCenter;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public int getFairPlayPoints() {
        return fairPlayPoints;
    }

    public void setFairPlayPoints(int fairPlayPoints) {
        this.fairPlayPoints = fairPlayPoints;
    }

    public String getFacebookLogin() {
        return facebookLogin;
    }

    public void setFacebookLogin(String facebookLogin) {
        this.facebookLogin = facebookLogin;
    }

    public String getFacebookPassword() {
        return facebookPassword;
    }

    public void setFacebookPassword(String facebookPassword) {
        this.facebookPassword = facebookPassword;
    }

    public String getCurrentYouthCenter() {
        return currentYouthCentre;
    }

    public void setCurrentYouthCenter(String currentYouthCenter) {
        this.currentYouthCentre = currentYouthCenter;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
