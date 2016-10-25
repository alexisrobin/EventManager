package controllers;

import models.Event;
import models.User;
import models.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by il-es on 17/10/2016.
 */
public class MyEventsController implements PageController {

    @Override
    public String getExecute(HttpServletRequest request) {
        request.getSession().setAttribute("events", this.eventsBuilder());
        return "/partials/myevents.jsp";
    }

    @Override
    public String postExecute(HttpServletRequest request) {
        return null;
    }

    private void testWithUser() {
        UserDAO uDao = new UserDAO();
        User u = new User.UserBuilder().setMail("robinalexis@outlook.fr").setPassword("okok").build();
        uDao.create(u);
    }

    private ArrayList<Event> eventsBuilder() {
        ArrayList<Event> eventList = new ArrayList<Event>();
        eventList.add(new Event.EventBuilder().setName("Java EE Meetup").build());
        eventList.add(new Event.EventBuilder().setName("Grosse réu").build());
        return eventList;
    }

    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_REQUIRED;
    }

}
