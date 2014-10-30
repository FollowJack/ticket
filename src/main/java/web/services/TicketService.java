package web.services;

import web.entities.TicketDTO;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Deniel on 30.10.2014.
 */
public class TicketService implements ITicketService {

    ArrayList<TicketDTO> tickets = new ArrayList<TicketDTO>();

    public TicketService(){
        tickets.add(new TicketDTO(1,"Error at Acteno Office", "Wolfgang gone wild","Buhmann",new Date(2014,10,30)));
        tickets.add(new TicketDTO(2,"Error at Acteno Office again", "Wolfgang gone wild again","Johannes",new Date(2014,10,29)));
        tickets.add(new TicketDTO(3,"Error at Acteno Office again oO", "Wolfgang gone brutal wild","Kisters",new Date(2014,10,28)));
    }

    @Override
    public TicketDTO get(long id) {

        for (TicketDTO ticket : tickets){
            if(ticket.getId() == id)
                return ticket;
        }

        return null;
    }

    @Override
    public ArrayList<TicketDTO> get() {
        return tickets;
    }
}
