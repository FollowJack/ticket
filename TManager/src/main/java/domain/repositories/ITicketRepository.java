package domain.repositories;


import domain.entities.TicketEntity;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 24.10.2014.
 */
@Remote
public interface ITicketRepository {

    public List<TicketEntity> find();
    public TicketEntity find(long id);
    public TicketEntity add(TicketEntity ticket);
    public void remove(long id);
    public boolean update(TicketEntity ticket);

    public ArrayList<TicketEntity> getByCategoryName(String categoryName);

}
