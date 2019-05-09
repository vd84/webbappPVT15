package WebbAppPVT15Grupp2.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "sproc_checkin_user",
        procedureName = "sproc_checkin_user",
        resultClasses = Relation.class)
})

public class Relation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int relationStartPoint;
    private int relationEndPoint;

    public int getRelationStartPoint() {
        return relationStartPoint;
    }

    public void setRelationStartPoint(int relationStartPoint) {
        this.relationStartPoint = relationStartPoint;
    }

    public int getRelationEndPoint() {
        return relationEndPoint;
    }

    public void setRelationEndPoint(int relationEndPoint) {
        this.relationEndPoint = relationEndPoint;
    }
}
