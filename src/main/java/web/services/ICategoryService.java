package web.services;

import web.entities.CategoryDTO;

import java.util.ArrayList;

/**
 * Created by Deniel on 03.11.2014.
 */
public interface ICategoryService {


    public ArrayList<CategoryDTO> get();

    public CategoryDTO get(long id);

    public boolean save(CategoryDTO category);
}
