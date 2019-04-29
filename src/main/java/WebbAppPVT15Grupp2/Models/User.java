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
    private int currentYouthCentre;
    private int role;


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

    public int getCurrentYouthCenter() {
        return currentYouthCentre;
    }

    public void setCurrentYouthCenter(int currentYouthCenter) {
        this.currentYouthCentre = currentYouthCenter;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
