package controllers;

import authentication.AuthRequirement;
import models.Event;
import models.dao.EventDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexis on 26/10/2016.
 */
public class EventController implements PageController {
    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_NOT_REQUIRED;
    }

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String splittedUri[] = uri.split("/");
        int eventId = Integer.parseInt(splittedUri[splittedUri.length-1]);

        EventDAO eDAO = new EventDAO();
        Event event = eDAO.findEventById(eventId);
        request.getSession().setAttribute("event", event);
        request.getRequestDispatcher("/partials/event.jsp").forward(request, response);
    }

    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
