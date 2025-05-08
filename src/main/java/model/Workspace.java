package model;

import model.enums.Status;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Workspace {
    @Id
    private Long id;
    private String name;
    private String location;
    private String capacity;
    private String facilities;
    private Status status;

    public Workspace(){
    }

    public Workspace(String name, String location, String capacity, String falcilities, Status status) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.facilities = falcilities;
        this.status = status;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
