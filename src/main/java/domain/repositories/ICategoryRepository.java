package domain.repositories;

import domain.entities.CategoryEntity;

import java.util.List;

/**
 * Created by Deniel on 03.11.2014.
 */
public interface ICategoryRepository {

    CategoryEntity find(long id);

    CategoryEntity add(CategoryEntity ticket);

    void remove(long id);

    boolean update(CategoryEntity entity);

    List<CategoryEntity> find();
}
