package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;




@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_add_activity",
                procedureName = "sproc_add_activity",
                resultClasses = Activity.class),
        @NamedStoredProcedureQuery(name = "`sproc_get_all_active_activities`",
                procedureName = "`sproc_get_all_active_activities`",
                resultClasses = Activity.class),
        @NamedStoredProcedureQuery(name = "sproc_get_my_activities",
                procedureName = "sproc_get_my_activities",
                resultClasses = Activity.class),

})
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   // @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Timestamp registrationdate;
    private int createdby;
    private int responsibleuser;
   // @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Timestamp startdate;
   // @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Timestamp enddate;
    private String name;
    private String description;
    private String alternativelocation;
    private int issuggestion;
    private int isactive;
    private int category;
    private int resource;
    private int challenger;
    private int challenged;
    private int completed;
    private String winner;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Timestamp registrationdate) {
        this.registrationdate = registrationdate;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public int getResponsibleuser() {
        return responsibleuser;
    }

    public void setResponsibleuser(int responsibleuser) {
        this.responsibleuser = responsibleuser;
    }

    public Timestamp getStartdate() {
        return startdate;
    }

    public void setStartdate(Timestamp startdate) {
        this.startdate = startdate;
    }

    public Timestamp getEnddate() {
        return enddate;
    }

    public void setEnddate(Timestamp enddate) {
        this.enddate = enddate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlternativelocation() {
        return alternativelocation;
    }

    public void setAlternativelocation(String alternativelocation) {
        this.alternativelocation = alternativelocation;
    }

    public boolean isIssuggestion() {
        return issuggestion;
    }

    public void setIssuggestion(boolean issuggestion) {
        this.issuggestion = issuggestion;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public int getChallenger() {
        return challenger;
    }

    public void setChallenger(int challenger) {
        this.challenger = challenger;
    }

    public int getChallenged() {
        return challenged;
    }

    public void setChallenged(int challenged) {
        this.challenged = challenged;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
