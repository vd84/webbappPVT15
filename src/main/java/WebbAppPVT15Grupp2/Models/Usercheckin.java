package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "usercheckin")
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_checkin_user",
        procedureName = "sproc_checkin_user",
        resultClasses = Usercheckin.class)
})

public class Usercheckin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int user;
    private int youthcentre;
    private Timestamp checkindate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getYouthcentre() {
        return youthcentre;
    }

    public void setYouthcentre(int youthcentre) {
        this.youthcentre = youthcentre;
    }

    public Timestamp getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(Timestamp checkindate) {
        this.checkindate = checkindate;
    }
}
