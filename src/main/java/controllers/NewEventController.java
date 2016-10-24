package controllers;

import models.Event;
import models.dao.EventDAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Alexis on 24/10/2016.
 */
public class NewEventController implements PageController {

    @Override
    public String getExecute(HttpServletRequest request) {
        return "/partials/newevent.jsp";
    }

    @Override
    public String postExecute(HttpServletRequest request) {
        String name = request.getParameter("eventName");
        String address = request.getParameter("eventAddress");
        if(name != null && !name.isEmpty() && address != null && !address.isEmpty()){
            System.out.println("add event");
            EventDAO eventDAO = new EventDAO();
            Event e = new Event.EventBuilder().setName(name).setAddress(address).build();
            eventDAO.create(e);
        }
        return "/partials/myevents.jsp";
    }
}
