package web.entities;

import domain.entities.TicketEntity;

import java.util.Date;

/**
 * Created by Deniel on 30.10.2014.
 */
public class TicketDTO {

    private long id;
    private String subject;
    private String body;
    private String owner;
    private Date createdOn;
    private Date modifiedOn;

    public TicketDTO(){}

    public TicketDTO(long id, String subject,String body, String owner, Date createdOn) {
        this.id = id;
        this.subject = subject;
        this.body = body;
        this.owner = owner;
        this.createdOn = createdOn;
    }

    public TicketDTO(
            TicketEntity entity) {
        updateModel(entity);
    }

    private void updateModel(TicketEntity entity) {
        this.id = entity.getId();
        this.subject = entity.getSubject();
        this.body = entity.getBody();
        this.owner = entity.getOwner();
        this.createdOn = entity.getCreatedOn();
        this.modifiedOn = entity.getModifiedOn();

    }
    public void updateEntity(TicketEntity entity) {
        entity.setBody(body);
        entity.setOwner(owner);
        entity.setModifiedOn(new java.sql.Date(new Date().getTime()));
        entity.setSubject(subject);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

}
