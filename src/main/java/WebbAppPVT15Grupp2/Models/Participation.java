package WebbAppPVT15Grupp2.Models;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "participation")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
    private Timestamp registrationDate;
    private boolean participated;
    private int extraPoints;
    private int user;
    private int activity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isParticipated() {
        return participated;
    }

    public void setParticipated(boolean participated) {
        this.participated = participated;
    }

    public int getExtraPoints() {
        return extraPoints;
    }

    public void setExtraPoints(int extraPoints) {
        this.extraPoints = extraPoints;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }
}
