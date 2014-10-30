package web.controller;

import web.entities.TicketDTO;
import web.services.ITicketService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

/**
 * Created by Deniel on 30.10.2014.
 */
@Named
public class TicketController {

    @Inject
    ITicketService ticketService;

    public TicketDTO getNewest(){
        TicketDTO result = ticketService.get(1);
        return result;
    }

    public ArrayList<TicketDTO> getAll(){

        ArrayList<TicketDTO> result = ticketService.get();
        return result;
    }
}
