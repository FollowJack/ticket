package web.services;

import domain.entities.CategoryEntity;
import domain.repositories.ICategoryRepository;
import web.entities.CategoryDTO;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 03.11.2014.
 */
@RequestScoped
public class CategoryService implements ICategoryService,Serializable{

    @EJB(mappedName = "CategoryRepository")
    private ICategoryRepository categoryRepository;

    @Override
    public CategoryDTO get(long id) {

        CategoryEntity entity = categoryRepository.find(id);

        if(entity == null)
            return null;

        CategoryDTO result = new CategoryDTO(entity);

        return result;
    }

    @Override
    public ArrayList<CategoryDTO> get() {

        List<CategoryEntity> entities = categoryRepository.find();
        ArrayList<CategoryDTO> result = new ArrayList<CategoryDTO>();

        for(CategoryEntity category: entities){
            result.add(new CategoryDTO(category));
        }

        return result;
    }

    @Override
    public boolean save(CategoryDTO category) {

        if(category.getId() == 0){
            CategoryEntity entityToSave = new CategoryEntity();
            entityToSave.setName(category.getName());
            categoryRepository.add(entityToSave);
            return true;
        }

        CategoryEntity entity = categoryRepository.find(category.getId());
        category.updateEntity(entity);

        boolean result = categoryRepository.update(entity);
        return result;
    }
}
