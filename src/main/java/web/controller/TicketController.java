package web.controller;

import web.entities.TicketDTO;
import web.services.ITicketService;
import web.services.TicketService;

import javax.inject.Named;

/**
 * Created by Deniel on 30.10.2014.
 */
@Named
public class TicketController {

    ITicketService ticketService = new TicketService();

    public TicketDTO getNewest(){
        TicketDTO result = ticketService.get(1);
        return result;
    }
}
