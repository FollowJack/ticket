package web.backingBeans;

import web.entities.TicketDTO;
import web.infrastructure.Navigator;
import web.services.ITicketService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Deniel on 30.10.2014.
 */
@Named
@javax.enterprise.context.SessionScoped
public class TicketManager implements Serializable{

    @Inject
    ITicketService ticketService;

    private TicketDTO ticketToEdit;

    public ArrayList<TicketDTO> getAll() {
        ArrayList<TicketDTO> result = ticketService.get();
        return result;
    }

    public String edit(long id) {
        ticketToEdit = ticketService.get(id);

        return Navigator.TICKET_EDIT;
    }

    public String save(TicketDTO ticket) {

        if (ticketService.save(ticket))
            return Navigator.TICKET_LIST;

        ticketToEdit = ticket;

        return Navigator.TICKET_EDIT;

    }

    //---- Getter & Setter -----
    public void setTicketToEdit(TicketDTO ticketToEdit) {
        this.ticketToEdit = ticketToEdit;
    }

    public TicketDTO getTicketToEdit() {
        return ticketToEdit;
    }
}
