package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_get_participation_by_activity",
                procedureName = "sproc_get_participation_by_activity",
                resultClasses = ReturnActivityParticipation.class)
})

public class ReturnActivityParticipation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String displayname;
    private int participated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public int getParticipated() {
        return participated;
    }

    public void setParticipated(int participated) {
        this.participated = participated;
    }
}
