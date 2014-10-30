package web.controller;

import javax.inject.Named;

/**
 * Created by Deniel on 30.10.2014.
 */
@Named
public class TicketController {

    public String sayHello(){
        return "Hello from controller.";
    }

}
