package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "getAllUsers", procedureName = "`sproc_get_all_users`",resultClasses = PUser.class)})

public class PUser implements Serializable {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "points")
    private int points;
    @Column(name = "currentYouthCentre")
    private int currentYouthCentre;
    @Column(name = "role")
    private int role;
}