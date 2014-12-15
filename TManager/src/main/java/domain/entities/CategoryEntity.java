package domain.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Deniel on 30.10.2014.
 */
@Entity
@Table(name = "category", schema = "public", catalog = "ticket_db")
public class CategoryEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private long id;
    private String name;
    private Collection<TicketEntity> ticketsById;

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "category")
    public Collection<TicketEntity> getTicketsById() {
        return ticketsById;
    }

    public void setTicketsById(Collection<TicketEntity> ticketsById) {
        this.ticketsById = ticketsById;
    }
}