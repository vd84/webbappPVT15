package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_get_all_users",
                procedureName = "sproc_get_all_users",
                resultClasses = ReturnUser.class),
        @NamedStoredProcedureQuery(name = "sproc_get_one_user",
                procedureName = "sproc_get_one_user",
                resultClasses = ReturnUser.class),
        @NamedStoredProcedureQuery(name = "sproc_login",
                procedureName = "sproc_login",
                resultClasses = ReturnUser.class),
        @NamedStoredProcedureQuery(name = "sproc_add_user",
                procedureName = "sproc_add_user",
                resultClasses = ReturnUser.class),
        @NamedStoredProcedureQuery(name = "sproc_update_user",
                procedureName = "sproc_update_user",
                resultClasses = ReturnUser.class),
        @NamedStoredProcedureQuery(name = "sproc_update_user_without_password",
                procedureName = "sproc_update_user_without_password",
                resultClasses = ReturnUser.class)
})
public class ReturnUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String displayname;
    private int points;
    private int fairplaypoints;
    private int currentyouthcentre;
    private String youthcentrename;
    private int role;
    private int isfacebookuser;
    private String image;


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

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
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

    public int getIsfacebookuser() {
        return isfacebookuser;
    }

    public void setIsfacebookuser(int isfacebookuser) {
        this.isfacebookuser = isfacebookuser;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
