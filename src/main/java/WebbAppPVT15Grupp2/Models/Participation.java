package WebbAppPVT15Grupp2.Models;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_add_participation",
                procedureName = "sproc_add_participation",
                resultClasses = Activity.class),
        @NamedStoredProcedureQuery(name = "sproc_delete_user_participation",
                procedureName = "sproc_delete_user_participation",
                resultClasses = Participation.class),



})
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy hh:mm:ss")
    private Timestamp registrationdate;
    private boolean participated;
    private int extrapoints;
    private int user;
    private int activity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRegistrationDate() {
        return registrationdate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationdate = registrationDate;
    }

    public boolean isParticipated() {
        return participated;
    }

    public void setParticipated(boolean participated) {
        this.participated = participated;
    }

    public int getExtraPoints() {
        return extrapoints;
    }

    public void setExtraPoints(int extraPoints) {
        this.extrapoints = extraPoints;
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
