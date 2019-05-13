package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "checkinactivity")
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_checkin_activity",
        procedureName = "sproc_checkin_activity",
        resultClasses = CheckinActivity.class)
})

public class CheckinActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int userid;
    private int activityid;
    private Timestamp checkindate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    public Timestamp getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(Timestamp checkindate) {
        this.checkindate = checkindate;
    }
}
