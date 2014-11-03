package web.services;

import web.entities.TicketDTO;

import java.util.ArrayList;

/**
 * Created by Deniel on 30.10.2014.
 */
public interface ITicketService {

    public TicketDTO get(long id);
    public ArrayList<TicketDTO> get();
    public boolean save(TicketDTO ticket);

}
