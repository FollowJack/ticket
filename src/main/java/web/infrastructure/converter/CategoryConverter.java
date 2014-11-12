package web.infrastructure.converter;

import web.entities.CategoryDTO;
import web.services.ICategoryService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Deniel on 06.11.2014.
 */
@Named
@FacesConverter(value = "categoryConverter")
public class CategoryConverter implements Converter {

    @Inject
    ICategoryService categoryService;

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
            long id = Long.parseLong(s);
            CategoryDTO result = categoryService.get(id);
            return result;
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
            CategoryDTO result = (CategoryDTO)o;
            //CategoryDTO result = categoryService.get(id);

            return new Long(result.getId()).toString();
    }
}
