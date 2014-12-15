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
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private long id;
    private String subject;
    private String owner;
    private Date created_on;
    private Date modified_on;
    private String body;
    private CategoryEntity category;


    public long getId() {
        return id;
    }
    public void setId(int id) {
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
    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date createdOn) {
        this.created_on = createdOn;
    }

    @Basic
    @Column(name = "modified_on", nullable = true, insertable = true, updatable = true)
    public Date getModified_on() {
        return modified_on;
    }

    public void setModified_on(Date modifiedOn) {
        this.modified_on = modifiedOn;
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
        if (created_on != null ? !created_on.equals(that.created_on) : that.created_on != null) return false;
        if (modified_on != null ? !modified_on.equals(that.modified_on) : that.modified_on != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (created_on != null ? created_on.hashCode() : 0);
        result = 31 * result + (modified_on != null ? modified_on.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumns(@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false))
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity categoryByCategoryId) {
        this.category = categoryByCategoryId;
    }
}
