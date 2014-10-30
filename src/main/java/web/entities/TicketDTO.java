package web.entities;

import java.util.Date;

/**
 * Created by Deniel on 30.10.2014.
 */
public class TicketDTO {

    private long id;
    private String subject;
    private String body;
    private String owner;
    private Date createdAt;

    public TicketDTO(){}

    public TicketDTO(long id, String subject,String body, String owner, Date createdAt) {
        this.id = id;
        this.subject = subject;
        this.body = body;
        this.owner = owner;
        this.createdAt = createdAt;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
