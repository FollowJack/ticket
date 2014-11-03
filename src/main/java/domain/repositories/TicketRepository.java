package domain.repositories;


import domain.entities.CategoryEntity;
import domain.entities.TicketEntity;
import util.stringHelper.StringUtil;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 24.10.2014.
 */
@Stateless(mappedName="TicketRepository")
@Remote(ITicketRepository.class)
public class TicketRepository implements ITicketRepository{

    @PersistenceContext(unitName = "ticketPersistenceUnit")
    EntityManager entityManager;

    @Override
    public TicketEntity find(long id) {
        TicketEntity result = entityManager.find(TicketEntity.class,id);
        return result;
    }

    @Override
    public TicketEntity add(TicketEntity ticket) {
        if(ticket == null)
            return null;

        entityManager.persist(ticket);

        TicketEntity result = find(ticket.getId());

        return result;
    }

    @Override
    public void remove(long id) {
        TicketEntity ticketToRemove = find(id);

        if(ticketToRemove == null)
            return;

        entityManager.remove(ticketToRemove);
    }

    @Override
    public boolean update(TicketEntity ticket) {
        if(ticket == null)
            return false;

        TicketEntity ticketToUpdate = find(ticket.getId());
        if(ticketToUpdate == null)
            return false;

        entityManager.merge(ticket);

        return true;
    }

    @Override
    public ArrayList<TicketEntity> getByCategoryName(String categoryName) {
        if(StringUtil.isNullOrWhiteSpace(categoryName))
            return new ArrayList<TicketEntity>();

        CategoryEntity category = entityManager.find(CategoryEntity.class, categoryName);
        long categoryId = category.getId();

        ArrayList<TicketEntity> result = (ArrayList<TicketEntity>) entityManager.createQuery("SELECT t from TicketEntity t where t.categoryByCategoryId  = :categoryId").getResultList();

        if(result == null ||result.isEmpty())
            return new ArrayList<TicketEntity>();

        return result;
        //SELECT TicketEntity t From CategoryEntity INNNER JOIN TicketEntity on CategoryEntity.id = TicketEntity.category_id WHERE ...
    }

    @Override
    public List<TicketEntity> find() {
        Query query = entityManager.createQuery("SELECT t FROM TicketEntity t");
        List<TicketEntity> result =  query.getResultList();

        if(result == null ||result.isEmpty())
            return new ArrayList<TicketEntity>();

        return result;
    }

}
