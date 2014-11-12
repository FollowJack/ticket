package web.backingBeans;

import web.entities.CategoryDTO;
import web.entities.TicketDTO;
import web.infrastructure.Navigator;
import web.services.ICategoryService;
import web.services.ITicketService;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Deniel on 30.10.2014.
 */
@Named
@javax.enterprise.context.SessionScoped
public class TicketManager implements Serializable{

    @Inject
    ITicketService ticketService;

    @Inject
    ICategoryService categoryService;

    private boolean isNewTicket;

    private TicketDTO ticketToEdit;
    private CategoryDTO selectedCategory;

    private List<TicketDTO> tickets;
    private List<CategoryDTO> categories;


    public String edit(long id) {
        isNewTicket = false;
        ticketToEdit = ticketService.get(id);

        return Navigator.TICKET_EDIT;
    }

    public String create(){
        isNewTicket = true;
        ticketToEdit = new TicketDTO();
        categories = categoryService.get();
        return Navigator.TICKET_EDIT;
    }

    public String save() {

        ticketToEdit.setCategory(selectedCategory);

        if (ticketService.save(ticketToEdit)){
            tickets = ticketService.get();
            return Navigator.TICKET_LIST;
        }


        return Navigator.TICKET_EDIT;
    }

    public String delete(long id){
        ticketService.delete(id);
        tickets = ticketService.get();
        return Navigator.TICKET_LIST;
    }

    //---- Getter & Setter -----
    public void setTicketToEdit(TicketDTO ticketToEdit) {
        this.ticketToEdit = ticketToEdit;
    }

    public TicketDTO getTicketToEdit() {
        return ticketToEdit;
    }

    public boolean isNewTicket() {
        return isNewTicket;
    }

    public void setNewTicket(boolean isNewTicket) {
        this.isNewTicket = isNewTicket;
    }

    public void setSelectedCategory(CategoryDTO selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public CategoryDTO getSelectedCategory() {
        return selectedCategory;
    }

    public List<TicketDTO> getTickets() {
        if(tickets == null || tickets.isEmpty())
            tickets = ticketService.get();

        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }

    public List<CategoryDTO> getCategories() {
        if(categories == null || categories.isEmpty())
            categories = categoryService.get();
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
