package WebbAppPVT15Grupp2.Models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_add_challange",
                procedureName = "sproc_add_challange",
                resultClasses = Activity.class),

})
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int challenger;

    private int responsibleUser;

    private int activity;

    private int winner;

    private boolean completed;

    private int challenged;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChallenger() {
        return challenger;
    }

    public void setChallenger(int challenger) {
        this.challenger = challenger;
    }

    public int getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(int responsibleUser) {
        this.responsibleUser = responsibleUser;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getChallenged() {
        return challenged;
    }

    public void setChallenged(int challenged) {
        this.challenged = challenged;
    }
}
