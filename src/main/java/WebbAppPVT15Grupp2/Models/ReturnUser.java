package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;
//import java.io.Serializable;


@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_get_all_users",
                procedureName = "sproc_get_all_users",
                resultClasses = ReturnUser.class)
})
public class ReturnUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private int id;
    //@Column(name = "username")
    private String username;
    //@Column(name = "points")
    private int points;
    //@Column(name = "fairplaypoints")
    private int fairplaypoints;
    //@Column(name = "currentyouthcentre")
    private int currentyouthcentre;

    private String youthcentrename;
    //@Column(name = "role")
    private int role;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFairplaypoints() {
        return fairplaypoints;
    }

    public void setFairplaypoints(int fairplaypoints) {
        this.fairplaypoints = fairplaypoints;
    }

    public int getCurrentyouthcentre() {
        return currentyouthcentre;
    }

    public void setCurrentyouthcentre(int currentyouthcentre) {
        this.currentyouthcentre = currentyouthcentre;
    }

    public String getYouthcentrename() {
        return youthcentrename;
    }

    public void setYouthcentrename(String youthcentrename) {
        this.youthcentrename = youthcentrename;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
