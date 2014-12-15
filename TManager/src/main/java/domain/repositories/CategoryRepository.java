package domain.repositories;


import domain.entities.CategoryEntity;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 24.10.2014.
 */
@Stateless(mappedName="CategoryRepository")
@Remote(ICategoryRepository.class)
public class CategoryRepository implements ICategoryRepository{

    @PersistenceContext(unitName = "ticketPersistenceUnit")
    EntityManager entityManager;

    @Override
    public CategoryEntity find(long id) {
        CategoryEntity result = entityManager.find(CategoryEntity.class,id);
        return result;
    }

    @Override
    public CategoryEntity add(CategoryEntity category) {
        if(category == null)
            return null;

        entityManager.persist(category);

        CategoryEntity result = find(category.getId());

        return result;
    }

    @Override
    public void remove(long id) {
        CategoryEntity categoryToRemove = find(id);

        if(categoryToRemove == null)
            return;

        entityManager.remove(categoryToRemove);
    }

    @Override
    public boolean update(CategoryEntity category) {
        if(category == null)
            return false;

        CategoryEntity categoryToUpdate = find(category.getId());
        if(categoryToUpdate == null)
            return false;

        entityManager.merge(category);

        return true;
    }

    @Override
    public List<CategoryEntity> find() {
        Query query = entityManager.createQuery("SELECT c FROM CategoryEntity c");
        List<CategoryEntity> result =  query.getResultList();

        if(result == null ||result.isEmpty())
            return new ArrayList<CategoryEntity>();

        return result;
    }

}
