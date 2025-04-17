package model;

import com.google.protobuf.DescriptorProtos;

import javax.naming.spi.ResolveResult;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Reservation {
    private int id;
    private int userId;
    private int workspaceId;
    private String date;
    private String time;

    public Reservation(){}

    public Reservation(int id, int userId, int workspaceId, String date, String time){
        this.id = id;
        this.userId = userId;
        this.workspaceId = workspaceId;
        this.date = date;
        this.time = time;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
