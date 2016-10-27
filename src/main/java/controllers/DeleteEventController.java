package controllers;

import authentication.AuthRequirement;
import models.Event;
import models.dao.EventDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alexis on 27/10/2016.
 */
public class DeleteEventController implements PageController {
    @Override
    public AuthRequirementState getAuthRequirementState() {
        return AuthRequirementState.IS_REQUIRED;
    }

    @Override
    public void getExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventDAO eDAO = new EventDAO();
        request.setAttribute("isLogged", "true");
        request.setAttribute("isOnEvents", "false");
        eDAO.delete(this.retrieveEventWithUri(request));
        response.sendRedirect(request.getContextPath() + "/action/events");
    }

    @Override
    public void postExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private Event retrieveEventWithUri(HttpServletRequest request){
        String uri = request.getRequestURI();
        String splittedUri[] = uri.split("/");
        int eventId = Integer.parseInt(splittedUri[splittedUri.length-2]);
        EventDAO eDAO = new EventDAO();
        return eDAO.findEventById(eventId);
    }
}
