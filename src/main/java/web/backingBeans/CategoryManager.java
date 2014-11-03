package web.backingBeans;

import web.entities.CategoryDTO;
import web.entities.TicketDTO;
import web.infrastructure.Navigator;
import web.services.ICategoryService;
import web.services.ITicketService;

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


    private CategoryDTO categoryToEdit;

    public ArrayList<CategoryDTO> getAll() {
        ArrayList<CategoryDTO> result = categoryService.get();
        return result;
    }

    public String edit(long id) {
        categoryToEdit = categoryService.get(id);

        return Navigator.CATEGORY_EDIT;
    }

    public String save(CategoryDTO category) {

        if (categoryService.save(category))
            return Navigator.TICKET_LIST;

        categoryToEdit = category;

        return Navigator.CATEGORY_EDIT;

    }

    //---- Getter & Setter -----
    public void setCategoryToEdit(CategoryDTO categoryToEdit) {
        this.categoryToEdit = categoryToEdit;
    }

    public CategoryDTO getCategoryToEdit() {
        return categoryToEdit;
    }
}
