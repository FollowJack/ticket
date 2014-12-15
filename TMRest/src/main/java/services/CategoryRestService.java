package services;

import domain.entities.CategoryEntity;
import domain.repositories.ICategoryRepository;
import rest.dtos.CategoryRestDTO;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 14.11.2014.
 */
@RequestScoped
@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryRestService implements ICategoryRestService{



    @Context
    private UriInfo uriInfo;

    @EJB(mappedName = "CategoryRepository")
    private ICategoryRepository categoryRepository;

    @GET
    public List<CategoryRestDTO> get() {

        List<CategoryEntity> categories = categoryRepository.find();
        List<CategoryRestDTO> result = new ArrayList<CategoryRestDTO>();

        for (CategoryEntity category: categories) {
            CategoryRestDTO categoryDTO= new CategoryRestDTO(category);
            result.add(categoryDTO);
        }

        return result;
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") String id) {

        long categoryId = Long.parseLong(id);
        CategoryEntity category = categoryRepository.find(categoryId);

        if (category == null)
            throw new NotFoundException();

        CategoryRestDTO result = new CategoryRestDTO(category);
        return Response.ok(result).build();
    }
}
