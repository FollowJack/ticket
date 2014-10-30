package web.services;

import domain.entities.TicketEntity;
import domain.repositories.ITicketRepository;
import web.entities.TicketDTO;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 30.10.2014.
 */
@RequestScoped
public class TicketService implements ITicketService {

/*    ArrayList<TicketDTO> tickets = new ArrayList<TicketDTO>();

    public TicketService(){
        tickets.add(new TicketDTO(1,"Error at Acteno Office", "Wolfgang gone wild","Buhmann",new Date(2014,10,30)));
        tickets.add(new TicketDTO(2,"Error at Acteno Office again", "Wolfgang gone wild again","Johannes",new Date(2014,10,29)));
        tickets.add(new TicketDTO(3,"Error at Acteno Office again oO", "Wolfgang gone brutal wild","Kisters",new Date(2014,10,28)));
    }*/

    @EJB(mappedName = "TicketRepository")
    private ITicketRepository ticketRepository;

    @Override
    public TicketDTO get(long id) {

        TicketEntity entity = ticketRepository.find(1);

        if(entity == null)
            return null;

        TicketDTO result = new TicketDTO(entity);

        return result;
    }

    @Override
    public ArrayList<TicketDTO> get() {

        List<TicketEntity> entities = ticketRepository.find();
        ArrayList<TicketDTO> result = new ArrayList<TicketDTO>();

        for(TicketEntity ticket : entities){
            result.add(new TicketDTO(ticket));
        }

        return result;
    }
}
