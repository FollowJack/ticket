package domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Deniel on 30.10.2014.
 */
@Entity
@Table(name = "ticket", schema = "public", catalog = "ticket_db")
public class TicketEntity implements Serializable{
    private long id;
    private String subject;
    private String owner;
    private Date createdOn;
    private Date modifiedOn;
    private String body;
    private CategoryEntity categoryByCategoryId;

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "subject", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "owner", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "created_on", nullable = false, insertable = true, updatable = true)
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Basic
    @Column(name = "modified_on", nullable = true, insertable = true, updatable = true)
    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @Basic
    @Column(name = "body", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (id != that.id) return false;
        if (body != null ? !body.equals(that.body) : that.body != null) return false;
        if (createdOn != null ? !createdOn.equals(that.createdOn) : that.createdOn != null) return false;
        if (modifiedOn != null ? !modifiedOn.equals(that.modifiedOn) : that.modifiedOn != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (modifiedOn != null ? modifiedOn.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "category_id", referencedColumnName = "id"), @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)})
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
