package WebbAppPVT15Grupp2.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeographicalPosition {

    @JsonProperty("X")
    private int x;
    @JsonProperty("Y")
    private int y;

    public GeographicalPosition() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "X : " + x + "  Y: " + y;
    }
}
