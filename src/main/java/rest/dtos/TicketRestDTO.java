package rest.dtos;

import domain.entities.CategoryEntity;
import domain.entities.TicketEntity;
import web.dtos.CategoryDTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Deniel on 12.11.2014.
 */
public class TicketRestDTO {

    private long id;
    @NotNull
    @Size(min = 3,max = 150)
    private String subject;
    @NotNull @Size(min = 3,max = 2000)
    private String body;
    @NotNull @Size(min = 3,max = 150)
    private String owner;
    private Date createdOn;
    private Date modifiedOn;


    private CategoryDTO category;

    public TicketRestDTO(){}

    public TicketRestDTO(
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
        this.category = new CategoryDTO(entity.getCategoryByCategoryId());

    }
    public void updateEntity(TicketEntity entity) {
        createdOn = createdOn == null ? new java.sql.Date(new java.util.Date().getTime()) : createdOn;

        entity.setBody(body);
        entity.setOwner(owner);
        entity.setCreatedOn(new java.sql.Date(createdOn.getTime()));
        entity.setModifiedOn(new java.sql.Date(new java.util.Date().getTime()));
        entity.setSubject(subject);

        CategoryEntity categoryEntity = new CategoryEntity();
        category.updateEntity(categoryEntity);
        entity.setCategoryByCategoryId(categoryEntity);
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
