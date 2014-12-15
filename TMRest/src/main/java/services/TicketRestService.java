package services;

import domain.entities.TicketEntity;
import domain.repositories.ITicketRepository;
import rest.dtos.TicketRestDTO;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 12.11.2014.
 */
@RequestScoped
@Path("/ticket")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@Stateless(mappedName="TicketRestService")
//@Remote(ITicketRestService.class)
public class TicketRestService implements ITicketRestService {


    @Context
    private UriInfo uriInfo;

    @EJB(mappedName = "TicketRepository")
    private ITicketRepository ticketRepository;

    @GET
    public List<TicketRestDTO> get() {

        List<TicketEntity> tickets = ticketRepository.find();
        List<TicketRestDTO> result = new ArrayList<TicketRestDTO>();

        for (TicketEntity ticket : tickets) {
            TicketRestDTO ticketDTO = new TicketRestDTO(ticket);
            result.add(ticketDTO);
        }

        return result;
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") String id) {

        long ticketId = Long.parseLong(id);
        TicketEntity ticket = ticketRepository.find(ticketId);

        if (ticket == null)
            throw new NotFoundException();

        TicketRestDTO result = new TicketRestDTO(ticket);
        return Response.ok(result).build();
    }

    @POST
    public Response create(TicketRestDTO ticket) {
        if (ticket == null)
            throw new BadRequestException();

        TicketEntity entity = new TicketEntity();
        ticket.updateEntity(entity);

        entity = ticketRepository.add(entity);
        URI ticketUri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(entity.getId())).build();
        return Response.created(ticketUri).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String id) {
        long ticketId = Long.parseLong(id);

        TicketEntity entity = ticketRepository.find(ticketId);
        if(entity == null){
            throw new NotFoundException();
        }

        ticketRepository.remove(ticketId);

        return Response.noContent().build();
    }

    @PUT
    public Response update(TicketRestDTO ticket) {
        if(ticket == null)
            throw new NotFoundException();

        TicketEntity ticketToUpdate = ticketRepository.find(ticket.getId());
        if(ticketToUpdate == null)
            throw new NotFoundException();

        ticket.updateEntity(ticketToUpdate);

        ticketRepository.update(ticketToUpdate);

        return Response.ok(ticket).build();
    }
}