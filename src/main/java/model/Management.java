package model;

import model.enums.Action;

import javax.persistence.*;

@Entity
@Table
public class Management {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int actorId;
    private Action action;
    private String timestamp;

    public Management() {
    }

    public Management(Long id, int actorId, Action action, String timestamp) {
        this.id = id;
        this.actorId = actorId;
        this.action = action;
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
