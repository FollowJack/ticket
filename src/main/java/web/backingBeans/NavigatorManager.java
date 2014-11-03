package web.backingBeans;

import web.infrastructure.Navigator;

import javax.inject.Named;

/**
 * Created by Deniel on 03.11.2014.
 */
@Named
public class NavigatorManager {

    public String getCategoryList(){
        return Navigator.CATEGORY_LIST;
    }

    public String getTicketList() {
        return Navigator.TICKET_LIST;
    }
}
