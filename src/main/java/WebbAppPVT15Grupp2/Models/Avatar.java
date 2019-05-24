package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_get_all_avatars",
                procedureName = "sproc_get_all_avatars",
                resultClasses = Avatar.class),
        @NamedStoredProcedureQuery(name = "sproc_get_users_avatar",
                procedureName = "sproc_get_users_avatar",
                resultClasses = Avatar.class)
})
public class Avatar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String image;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}