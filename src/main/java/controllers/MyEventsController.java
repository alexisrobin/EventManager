package controllers;

import models.Event;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by il-es on 17/10/2016.
 */
public class MyEventsController implements PageController {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().setAttribute("events", this.eventsBuilder());
        return "/partials/mesEvenements.jsp";
    }

    private ArrayList<Event> eventsBuilder() {
        ArrayList<Event> eventList = new ArrayList<Event>();
        eventList.add(new Event("Java EE Meetup"));
        eventList.add(new Event("Grosse réu"));
        return eventList;
    }
}
