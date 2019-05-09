package WebbAppPVT15Grupp2.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouthCenter {

    @JsonProperty("GeographicalPosition")
    private GeographicalPosition geographicalPosition;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;

    public YouthCenter() {

    }

    public GeographicalPosition getGeographicalPosition() {
        return geographicalPosition;
    }

    public void setGeographicalPosition(GeographicalPosition geographicalPosition) {
        this.geographicalPosition = geographicalPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name + "  ID: " + id + "  Geographical Location: " + geographicalPosition;
    }
}