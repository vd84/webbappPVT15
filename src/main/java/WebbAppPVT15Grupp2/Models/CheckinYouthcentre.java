package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "checkinyouthcentre")
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_checkin_youthcentre",
                procedureName = "sproc_checkin_youthcentre",
                resultClasses = CheckinYouthcentre.class),
        @NamedStoredProcedureQuery(name = "sproc_get_my_youthcentre_checkins",
                procedureName = "sproc_get_my_youthcentre_checkins",
                resultClasses = CheckinYouthcentre.class)
})

public class CheckinYouthcentre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userid;
    private int youthcentreid;
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

    public int getYouthcentreid() {
        return youthcentreid;
    }

    public void setYouthcentreid(int youthcentreid) {
        this.youthcentreid = youthcentreid;
    }

    public Timestamp getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(Timestamp checkindate) {
        this.checkindate = checkindate;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CheckinYouthcentre) {
            CheckinYouthcentre CYC = (CheckinYouthcentre) obj;
            if(this.getUserid() == CYC.getUserid() && this.youthcentreid == CYC.getYouthcentreid()){
                return true;
            }
        }
        return false;
    }
}
