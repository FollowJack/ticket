package services;

import dtos.CategoryRestDTO;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Deniel on 14.11.2014.
 */
public interface ICategoryRestService {

    public Response get(String id);
    public List<CategoryRestDTO> get();
}
