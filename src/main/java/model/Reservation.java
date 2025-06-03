package model;

import com.google.protobuf.DescriptorProtos;

import javax.naming.spi.ResolveResult;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long workspaceId;
    private LocalDate date;
    private LocalTime beginTime;
    private LocalTime endTime;
    private String description;

    public Reservation(){}

    public Reservation(Long id, Long userId, Long workspaceId, LocalDate date, String description, LocalTime beginTime, LocalTime endTime){
        this.id = id;
        this.userId = userId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.workspaceId = workspaceId;
        this.date = date;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Long getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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
