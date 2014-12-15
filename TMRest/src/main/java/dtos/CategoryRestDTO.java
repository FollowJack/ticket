package dtos;

import domain.entities.CategoryEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Deniel on 03.11.2014.
 */
public class CategoryRestDTO {

    private long id;
    @NotNull @Size(min = 3,max = 200)
    private String name;

    public CategoryRestDTO(CategoryEntity entity) {
        updateModel(entity);
    }

    public CategoryRestDTO() { }

    private void updateModel(CategoryEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void updateEntity(CategoryEntity entity) {
        entity.setId(id);
        entity.setName(name);
    }

    @Override
    public boolean equals(Object obj) {
        CategoryRestDTO category = (CategoryRestDTO)obj;
        return category.id == this.id;
    }
}
