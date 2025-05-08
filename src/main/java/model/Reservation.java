package model;

import com.google.protobuf.DescriptorProtos;

import javax.naming.spi.ResolveResult;
import javax.persistence.*;

@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int userId;
    private int workspaceId;
    private String date;
    private String time;
    private String description;

    public Reservation(){}

    public Reservation(Long id, int userId, int workspaceId, String date, String time, String description){
        this.id = id;
        this.userId = userId;
        this.workspaceId = workspaceId;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(int workspaceId) {
        this.workspaceId = workspaceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
