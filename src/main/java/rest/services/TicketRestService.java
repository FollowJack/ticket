package rest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Deniel on 12.11.2014.
 */
@Path("/ticket")
//@Stateless(mappedName="TicketRestService")
//@Remote(ITicketRestService.class)
public class TicketRestService implements ITicketRestService {


//    @Context
//    private UriInfo uriInfo;

//    @Inject
//    TicketRepository ticketRepository;
//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public List<TicketRestDTO> get() {
//
//        List<TicketEntity> tickets = ticketRepository.find();
//        List<TicketRestDTO> result = new ArrayList<TicketRestDTO>();
//
//        for(TicketEntity ticket : tickets) {
//            TicketRestDTO ticketDTO = new TicketRestDTO(ticket);
//            result.add(ticketDTO);
//        }
//
//        return result;
//    }

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return "Bla";
    }

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public TicketRestDTO get(long id) {
//
//        TicketEntity entity = ticketRepository.find(id);
//        TicketRestDTO result = new TicketRestDTO(entity);
//
//        return result;
//    }
}