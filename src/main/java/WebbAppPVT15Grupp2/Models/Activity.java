package WebbAppPVT15Grupp2.Models;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime registrationDate;
    private LocalDateTime createdBy;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String name;
    private String description;
    private int responsibleUser;

    private String alternativeLocation;
    private boolean isSuggestion;
    private boolean isActive;
    private int category;
    private int resource;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDateTime getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LocalDateTime createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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

    public int getResponsibleUser() {
        return responsibleUser;
    }

    public void setResponsibleUser(int responsibleUser) {
        this.responsibleUser = responsibleUser;
    }


    public String getAlternativeLocation() {
        return alternativeLocation;
    }

    public void setAlternativeLocation(String alternativeLocation) {
        this.alternativeLocation = alternativeLocation;
    }

    public boolean isSuggestion() {
        return isSuggestion;
    }

    public void setSuggestion(boolean suggestion) {
        isSuggestion = suggestion;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
}
