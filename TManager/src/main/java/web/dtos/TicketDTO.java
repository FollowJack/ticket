package web.dtos;

import domain.entities.CategoryEntity;
import domain.entities.TicketEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Deniel on 30.10.2014.
 */
public class TicketDTO {

    private long id;
    @NotNull @Size(min = 3,max = 150)
    private String subject;
    @NotNull @Size(min = 3,max = 2000)
    private String body;
    @NotNull @Size(min = 3,max = 150)
    private String owner;
    private Date createdOn;
    private Date modifiedOn;



    private CategoryDTO category;

    public TicketDTO(){}

    public TicketDTO(long id, String subject,String body, String owner, Date createdOn) {
        this.id = id;
        this.subject = subject;
        this.body = body;
        this.owner = owner;
        this.createdOn = createdOn;
        this.category = new CategoryDTO();
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
        this.createdOn = entity.getCreated_on();
        this.modifiedOn = entity.getModified_on();
        this.category = new CategoryDTO(entity.getCategory());

    }
    public void updateEntity(TicketEntity entity) {
        createdOn = createdOn == null ? new java.sql.Date(new java.util.Date().getTime()) : createdOn;

        entity.setBody(body);
        entity.setOwner(owner);
        entity.setCreated_on(new java.sql.Date(createdOn.getTime()));
        entity.setModified_on(new java.sql.Date(new java.util.Date().getTime()));
        entity.setSubject(subject);

        CategoryEntity categoryEntity = new CategoryEntity();
        category.updateEntity(categoryEntity);
        entity.setCategory(categoryEntity);
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
