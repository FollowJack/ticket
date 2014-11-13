package web.backingBeans;

import web.dtos.CategoryDTO;
import web.infrastructure.Navigator;
import web.services.ICategoryService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Deniel on 30.10.2014.
 */
@Named
@javax.enterprise.context.SessionScoped
public class CategoryManager implements Serializable{

    @Inject
    ICategoryService categoryService;

    private boolean isNewCategory;
    private CategoryDTO categoryToEdit;

    public ArrayList<CategoryDTO> getAll() {
        ArrayList<CategoryDTO> result = categoryService.get();
        return result;
    }

    public String edit(long id) {
        isNewCategory = false;
        categoryToEdit = categoryService.get(id);

        return Navigator.CATEGORY_EDIT;
    }

    public String save(CategoryDTO category) {

        if (categoryService.save(category))
            return Navigator.CATEGORY_LIST;

        categoryToEdit = category;

        return Navigator.CATEGORY_EDIT;

    }

    public String create(){
        isNewCategory = true;
        categoryToEdit = new CategoryDTO();
        return Navigator.CATEGORY_EDIT;
    }


    //---- Getter & Setter -----
    public void setCategoryToEdit(CategoryDTO categoryToEdit) {
        this.categoryToEdit = categoryToEdit;
    }

    public CategoryDTO getCategoryToEdit() {
        return categoryToEdit;
    }

    public boolean isNewCategory() {
        return isNewCategory;
    }

    public void setNewCategory(boolean isNewCategory) {
        this.isNewCategory = isNewCategory;
    }
}
