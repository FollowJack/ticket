package web.services;

import domain.entities.TicketEntity;
import domain.repositories.ITicketRepository;
import web.entities.TicketDTO;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 30.10.2014.
 */
@RequestScoped
public class TicketService implements ITicketService,Serializable {

    @EJB(mappedName = "TicketRepository")
    private ITicketRepository ticketRepository;

    @Override
    public TicketDTO get(long id) {

        TicketEntity entity = ticketRepository.find(id);

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

    @Override
    public boolean save(TicketDTO ticket) {

        if(ticket.getId() == 0){
            TicketEntity ticketToSave = new TicketEntity();
            ticket.updateEntity(ticketToSave);
            ticketRepository.add(ticketToSave);
            return true;
        }

        TicketEntity entity = ticketRepository.find(ticket.getId());
        ticket.updateEntity(entity);

        boolean result = ticketRepository.update(entity);
        return result;
    }

    @Override
    public void delete(long id) {
        if(id == 0)
            return;

        ticketRepository.remove(id);
    }
}
