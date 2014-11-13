package rest.services;

import rest.dtos.TicketRestDTO;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Deniel on 12.11.2014.
 */
public interface ITicketRestService {

    public List<TicketRestDTO> get();
    public Response get(String id);
    public Response create(TicketRestDTO ticket);
    public Response update(TicketRestDTO ticket);
    public Response delete(String id);
}


