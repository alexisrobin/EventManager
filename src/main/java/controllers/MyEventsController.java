package controllers;

import models.Event;
import models.User;
import models.dao.EventDAO;
import models.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by il-es on 17/10/2016.
 */
public class MyEventsController implements PageController {

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("events", this.retrieveUserEvents(request));
        request.getRequestDispatcher("/partials/myevents.jsp").forward(request, response);
    }

    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) {
    }

    private ArrayList<Event> retrieveUserEvents(HttpServletRequest request) {
        EventDAO eDAO = new EventDAO();
        User user = (User) request.getSession().getAttribute("user");
        return eDAO.findEventsByUser(user);
    }

    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_REQUIRED;
    }

}
